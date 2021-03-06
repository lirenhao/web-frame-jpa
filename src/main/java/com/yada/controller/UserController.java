package com.yada.controller;

import com.yada.commons.base.BaseController;
import com.yada.commons.result.Data;
import com.yada.commons.shiro.PasswordHash;
import com.yada.commons.utils.StringUtils;
import com.yada.model.Role;
import com.yada.model.User;
import com.yada.query.UserQuery;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * @param query
     * @return
     */
    @PostMapping("/dataGrid")
    @ResponseBody
    public Data dataGrid(UserQuery query) {
        return userService.selectDataGrid(query);
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
    public Object add(@Valid User user, @Valid Long[] roleIds) {
        List<User> list = userService.selectByLoginName(user);
        if (list != null && !list.isEmpty()) {
            return renderError("登录名已存在!");
        }
        String salt = StringUtils.getUUId();
        String pwd = passwordHash.toHex(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(pwd);

        Set<Role> roles = new HashSet<Role>();
        for(Long roleId : roleIds){
            Role role = new Role();
            role.setId(roleId);
            roles.add(role);
        }
        user.setRoles(roles);

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
    public Object edit(@Valid User user, @Valid Long[] roleIds) {
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
        Set<Role> roles = new HashSet<Role>();
        for(Long roleId : roleIds){
            Role role = new Role();
            role.setId(roleId);
            roles.add(role);
        }
        user.setRoles(roles);
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