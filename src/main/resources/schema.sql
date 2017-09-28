-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` (`id`, `name`, `address`, `code`, `icon`, `pid`, `seq`, `create_time`) VALUES ('1', '总经办', '王家桥', '01', 'fi-social-windows', null, '0', '2014-02-19 01:00:00');
INSERT INTO `organization` (`id`, `name`, `address`, `code`, `icon`, `pid`, `seq`, `create_time`) VALUES ('3', '技术部', '', '02', 'fi-social-github', null, '1', '2015-10-01 13:10:42');
INSERT INTO `organization` (`id`, `name`, `address`, `code`, `icon`, `pid`, `seq`, `create_time`) VALUES ('5', '产品部', '', '03', 'fi-social-apple', null, '2', '2015-12-06 12:15:30');
INSERT INTO `organization` (`id`, `name`, `address`, `code`, `icon`, `pid`, `seq`, `create_time`) VALUES ('6', '测试组', '', '04', 'fi-social-snapchat', '3', '0', '2015-12-06 13:12:18');

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('1', '权限管理', '', null, '系统管理', 'fi-folder', null, '0', '0', '1', '0', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('11', '资源管理', '/resource/manager', 'ajax', '资源管理', 'fi-database', '1', '1', '0', '1', '0', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('12', '角色管理', '/role/manager', 'ajax', '角色管理', 'fi-torso-business', '1', '2', '0', '1', '0', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('13', '用户管理', '/user/manager', 'ajax', '用户管理', 'fi-torsos-all', '1', '3', '0', '1', '0', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('14', '部门管理', '/organization/manager', 'ajax', '部门管理', 'fi-results-demographics', '1', '4', '0', '1', '0', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('111', '列表', '/resource/treeGrid', 'ajax', '资源列表', 'fi-list', '11', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('112', '添加', '/resource/add', 'ajax', '资源添加', 'fi-page-add', '11', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('113', '编辑', '/resource/edit', 'ajax', '资源编辑', 'fi-page-edit', '11', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('114', '删除', '/resource/delete', 'ajax', '资源删除', 'fi-page-delete', '11', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('121', '列表', '/role/dataGrid', 'ajax', '角色列表', 'fi-list', '12', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('122', '添加', '/role/add', 'ajax', '角色添加', 'fi-page-add', '12', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('123', '编辑', '/role/edit', 'ajax', '角色编辑', 'fi-page-edit', '12', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('124', '删除', '/role/delete', 'ajax', '角色删除', 'fi-page-delete', '12', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('125', '授权', '/role/grant', 'ajax', '角色授权', 'fi-check', '12', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('131', '列表', '/user/dataGrid', 'ajax', '用户列表', 'fi-list', '13', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('132', '添加', '/user/add', 'ajax', '用户添加', 'fi-page-add', '13', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('133', '编辑', '/user/edit', 'ajax', '用户编辑', 'fi-page-edit', '13', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('134', '删除', '/user/delete', 'ajax', '用户删除', 'fi-page-delete', '13', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('141', '列表', '/organization/treeGrid', 'ajax', '用户列表', 'fi-list', '14', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('142', '添加', '/organization/add', 'ajax', '部门添加', 'fi-page-add', '14', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('143', '编辑', '/organization/edit', 'ajax', '部门编辑', 'fi-page-edit', '14', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('144', '删除', '/organization/delete', 'ajax', '部门删除', 'fi-page-delete', '14', '0', '0', '1', '1', '2014-02-19 01:00:00');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('221', '日志监控', '', null, null, 'fi-folder', null, '3', '0', '0', '0', '2015-12-01 11:44:20');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('226', '修改密码', '/user/editPwdPage', 'ajax', null, 'fi-unlock', null, '4', '0', '1', '1', '2015-12-07 20:23:06');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('227', '登录日志', '/sysLog/manager', 'ajax', null, 'fi-info', '221', '0', '0', '1', '0', '2016-09-30 22:10:53');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('228', 'Druid监控', '/druid', 'iframe', null, 'fi-monitor', '221', '0', '0', '1', '0', '2016-09-30 22:12:50');
INSERT INTO `resource` (`id`, `name`, `url`, `open_mode`, `description`, `icon`, `pid`, `seq`, `status`, `opened`, `resource_type`, `create_time`) VALUES ('229', '系统图标', '/icons.html', 'ajax', null, 'fi-photo', '221', '0', '0', '1', '0', '2016-12-24 15:53:47');

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` (`id`, `name`, `seq`, `description`, `status`) VALUES ('1', 'admin', '0', '超级管理员', '0');
INSERT INTO `role` (`id`, `name`, `seq`, `description`, `status`) VALUES ('2', 'de', '0', '技术部经理', '0');
INSERT INTO `role` (`id`, `name`, `seq`, `description`, `status`) VALUES ('7', 'pm', '0', '产品部经理', '0');
INSERT INTO `role` (`id`, `name`, `seq`, `description`, `status`) VALUES ('8', 'test', '0', '测试账户', '0');

-- ----------------------------
-- Records of role_resource
-- ----------------------------
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '1');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '11');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '111');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '112');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '113');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '114');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '12');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '121');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '122');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '123');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '124');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '125');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '13');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '131');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '132');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '133');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '134');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '14');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '141');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '142');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '143');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '144');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '221');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '227');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('1', '228');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '1');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '13');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '131');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '132');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '133');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '221');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '227');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('2', '228');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '1');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '14');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '141');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '142');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '143');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '221');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('7', '226');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '1');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '11');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '111');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '12');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '121');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '13');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '131');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '14');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '141');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '221');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '227');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '228');
INSERT INTO `role_resource` (`role_id`, `resource_id`) VALUES ('8', '229');

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` (`id`, `login_name`, `name`, `password`, `salt`, `sex`, `age`, `phone`, `user_type`, `status`, `organization_id`, `create_time`) VALUES ('1', 'admin', 'admin', '05a671c66aefea124cc08b76ea6d30bb', 'test', '0', '25', '18707173376', '0', '0', '1', '2015-12-06 13:14:05');
INSERT INTO `user` (`id`, `login_name`, `name`, `password`, `salt`, `sex`, `age`, `phone`, `user_type`, `status`, `organization_id`, `create_time`) VALUES ('13', 'snoopy', 'snoopy', '05a671c66aefea124cc08b76ea6d30bb', 'test', '0', '25', '18707173376', '1', '0', '3', '2015-10-01 13:12:07');
INSERT INTO `user` (`id`, `login_name`, `name`, `password`, `salt`, `sex`, `age`, `phone`, `user_type`, `status`, `organization_id`, `create_time`) VALUES ('14', 'dreamlu', 'dreamlu', '05a671c66aefea124cc08b76ea6d30bb', 'test', '0', '25', '18707173376', '1', '0', '5', '2015-10-11 23:12:58');
INSERT INTO `user` (`id`, `login_name`, `name`, `password`, `salt`, `sex`, `age`, `phone`, `user_type`, `status`, `organization_id`, `create_time`) VALUES ('15', 'test', 'test', '05a671c66aefea124cc08b76ea6d30bb', 'test', '0', '25', '18707173376', '1', '0', '6', '2015-12-06 13:13:03');

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '7');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('1', '8');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('13', '2');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('14', '7');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('15', '8');