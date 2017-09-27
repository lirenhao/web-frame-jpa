package com.yada.controller;

import com.yada.commons.base.BaseController;
import com.yada.commons.result.PageInfo;
import com.yada.commons.shiro.PasswordHash;
import com.yada.commons.utils.StringUtils;
import com.yada.model.Role;
import com.yada.model.User;
import com.yada.service.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHash passwordHash;

    /**
     * 用户管理页
     *
     * @return
     */
    @GetMapping("/manager")
    public String manager() {
        return "admin/user/user";
    }

    /**
     * 用户管理列表
     *
     * @param user
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @PostMapping("/dataGrid")
    @ResponseBody
    public Object dataGrid(User user, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = new HashMap<String, Object>();

        if (StringUtils.isNotBlank(user.getName())) {
            condition.put("name", user.getName());
        }
//        if (user.getOrganization() != null & user.getOrganization().getId() != null) {
//            condition.put("organizationId", user.getOrganization().getId());
//        }
        // TODO 查询
//        if (user.getCreatedateStart() != null) {
//            condition.put("startTime", user.getCreatedateStart());
//        }
//        if (user.getCreatedateEnd() != null) {
//            condition.put("endTime", user.getCreatedateEnd());
//        }
        pageInfo.setCondition(condition);
        userService.selectDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 添加用户页
     *
     * @return
     */
    @GetMapping("/addPage")
    public String addPage() {
        return "admin/user/userAdd";
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    public Object add(@Valid User user) {
        List<User> list = userService.selectByLoginName(user);
        if (list != null && !list.isEmpty()) {
            return renderError("登录名已存在!");
        }
        String salt = StringUtils.getUUId();
        String pwd = passwordHash.toHex(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(pwd);
        userService.save(user);
        return renderSuccess("添加成功");
    }

    /**
     * 编辑用户页
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/editPage")
    public String editPage(Model model, Long id) {
        User user = userService.findById(id);
        Set<Role> roles = user.getRoles();
        List<Long> ids = new ArrayList<Long>();
        for (Role role : roles) {
            ids.add(role.getId());
        }
        model.addAttribute("roleIds", ids);
        model.addAttribute("user", user);
        return "admin/user/userEdit";
    }

    /**
     * 编辑用户
     *
     * @param user
     * @return
     */
    @RequiresRoles("admin")
    @PostMapping("/edit")
    @ResponseBody
    public Object edit(@Valid User user) {
        List<User> list = userService.selectByLoginName(user);
        if (list != null && !list.isEmpty()) {
            return renderError("登录名已存在!");
        }
        // 更新密码
        if (StringUtils.isNotBlank(user.getPassword())) {
            User userInfo = userService.findById(user.getId());
            String salt = userInfo.getSalt();
            String pwd = passwordHash.toHex(user.getPassword(), salt);
            user.setPassword(pwd);
        }
        userService.update(user);
        return renderSuccess("修改成功！");
    }

    /**
     * 修改密码页
     *
     * @return
     */
    @GetMapping("/editPwdPage")
    public String editPwdPage() {
        return "admin/user/userEditPwd";
    }

    /**
     * 修改密码
     *
     * @param oldPwd
     * @param pwd
     * @return
     */
    @PostMapping("/editUserPwd")
    @ResponseBody
    public Object editUserPwd(String oldPwd, String pwd) {
        User user = userService.findById(getUserId());
        String salt = user.getSalt();
        if (!user.getPassword().equals(passwordHash.toHex(oldPwd, salt))) {
            return renderError("老密码不正确!");
        }
        userService.updatePwdByUserId(getUserId(), passwordHash.toHex(pwd, salt));
        return renderSuccess("密码修改成功！");
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequiresRoles("admin")
    @PostMapping("/delete")
    @ResponseBody
    public Object delete(Long id) {
        Long currentUserId = getUserId();
        if (id == currentUserId) {
            return renderError("不可以删除自己！");
        }
        userService.delete(id);
        return renderSuccess("删除成功！");
    }
}