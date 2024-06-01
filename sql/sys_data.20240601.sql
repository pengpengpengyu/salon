INSERT INTO ruoyi.sys_config (config_name,config_key,config_value,config_type,create_by,create_time,update_by,update_time,remark) VALUES
	 ('主框架页-默认皮肤样式名称','sys.index.skinName','skin-blue','Y','admin','2024-05-15 13:56:40','',NULL,'蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),
	 ('用户管理-账号初始密码','sys.user.initPassword','123456','Y','admin','2024-05-15 13:56:40','',NULL,'初始化密码 123456'),
	 ('主框架页-侧边栏主题','sys.index.sideTheme','theme-dark','Y','admin','2024-05-15 13:56:40','',NULL,'深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue'),
	 ('账号自助-是否开启用户注册功能','sys.account.registerUser','false','Y','admin','2024-05-15 13:56:40','',NULL,'是否开启注册用户功能（true开启，false关闭）'),
	 ('用户管理-密码字符范围','sys.account.chrtype','0','Y','admin','2024-05-15 13:56:40','',NULL,'默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数字和特殊字符（目前支持的特殊字符包括：~!@#$%^&*()-=_+）'),
	 ('用户管理-初始密码修改策略','sys.account.initPasswordModify','1','Y','admin','2024-05-15 13:56:40','',NULL,'0：初始密码修改策略关闭，没有任何提示，1：提醒用户，如果未修改初始密码，则在登录时就会提醒修改密码对话框'),
	 ('用户管理-账号密码更新周期','sys.account.passwordValidateDays','0','Y','admin','2024-05-15 13:56:40','',NULL,'密码更新周期（填写数字，数据初始化值为0不限制，若修改必须为大于0小于365的正整数），如果超过这个周期登录系统时，则在登录时就会提醒修改密码对话框'),
	 ('主框架页-菜单导航显示风格','sys.index.menuStyle','default','Y','admin','2024-05-15 13:56:40','',NULL,'菜单导航显示风格（default为左侧导航菜单，topnav为顶部导航菜单）'),
	 ('主框架页-是否开启页脚','sys.index.footer','true','Y','admin','2024-05-15 13:56:40','',NULL,'是否开启底部页脚显示（true显示，false隐藏）'),
	 ('主框架页-是否开启页签','sys.index.tagsView','true','Y','admin','2024-05-15 13:56:40','',NULL,'是否开启菜单多页签显示（true显示，false隐藏）');
INSERT INTO ruoyi.sys_config (config_name,config_key,config_value,config_type,create_by,create_time,update_by,update_time,remark) VALUES
	 ('用户登录-黑名单列表','sys.login.blackIPList','','Y','admin','2024-05-15 13:56:40','',NULL,'设置登录IP黑名单限制，多个匹配项以;分隔，支持匹配（*通配、网段）');

INSERT INTO ruoyi.sys_dept (parent_id,ancestors,dept_name,order_num,leader,phone,email,status,del_flag,create_by,create_time,update_by,update_time) VALUES
	 (0,'0','若依科技',0,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (100,'0,100','深圳总公司',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (100,'0,100','长沙分公司',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (101,'0,100,101','研发部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (101,'0,100,101','市场部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (101,'0,100,101','测试部门',3,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (101,'0,100,101','财务部门',4,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (101,'0,100,101','运维部门',5,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (102,'0,100,102','市场部门',1,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL),
	 (102,'0,100,102','财务部门',2,'若依','15888888888','ry@qq.com','0','0','admin','2024-05-15 13:56:38','',NULL);

INSERT INTO ruoyi.sys_dict_data (dict_sort,dict_label,dict_value,dict_type,css_class,list_class,is_default,status,create_by,create_time,update_by,update_time,remark) VALUES
	 (1,'男','0','sys_user_sex','','','Y','0','admin','2024-05-15 13:56:40','',NULL,'性别男'),
	 (2,'女','1','sys_user_sex','','','N','0','admin','2024-05-15 13:56:40','',NULL,'性别女'),
	 (3,'未知','2','sys_user_sex','','','N','0','admin','2024-05-15 13:56:40','',NULL,'性别未知'),
	 (1,'显示','0','sys_show_hide','','primary','Y','0','admin','2024-05-15 13:56:40','',NULL,'显示菜单'),
	 (2,'隐藏','1','sys_show_hide','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'隐藏菜单'),
	 (1,'正常','0','sys_normal_disable','','primary','Y','0','admin','2024-05-15 13:56:40','',NULL,'正常状态'),
	 (2,'停用','1','sys_normal_disable','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'停用状态'),
	 (1,'正常','0','sys_job_status','','primary','Y','0','admin','2024-05-15 13:56:40','',NULL,'正常状态'),
	 (2,'暂停','1','sys_job_status','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'停用状态'),
	 (1,'默认','DEFAULT','sys_job_group','','','Y','0','admin','2024-05-15 13:56:40','',NULL,'默认分组');
INSERT INTO ruoyi.sys_dict_data (dict_sort,dict_label,dict_value,dict_type,css_class,list_class,is_default,status,create_by,create_time,update_by,update_time,remark) VALUES
	 (2,'系统','SYSTEM','sys_job_group','','','N','0','admin','2024-05-15 13:56:40','',NULL,'系统分组'),
	 (1,'是','Y','sys_yes_no','','primary','Y','0','admin','2024-05-15 13:56:40','',NULL,'系统默认是'),
	 (2,'否','N','sys_yes_no','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'系统默认否'),
	 (1,'通知','1','sys_notice_type','','warning','Y','0','admin','2024-05-15 13:56:40','',NULL,'通知'),
	 (2,'公告','2','sys_notice_type','','success','N','0','admin','2024-05-15 13:56:40','',NULL,'公告'),
	 (1,'正常','0','sys_notice_status','','primary','Y','0','admin','2024-05-15 13:56:40','',NULL,'正常状态'),
	 (2,'关闭','1','sys_notice_status','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'关闭状态'),
	 (99,'其他','0','sys_oper_type','','info','N','0','admin','2024-05-15 13:56:40','',NULL,'其他操作'),
	 (1,'新增','1','sys_oper_type','','info','N','0','admin','2024-05-15 13:56:40','',NULL,'新增操作'),
	 (2,'修改','2','sys_oper_type','','info','N','0','admin','2024-05-15 13:56:40','',NULL,'修改操作');
INSERT INTO ruoyi.sys_dict_data (dict_sort,dict_label,dict_value,dict_type,css_class,list_class,is_default,status,create_by,create_time,update_by,update_time,remark) VALUES
	 (3,'删除','3','sys_oper_type','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'删除操作'),
	 (4,'授权','4','sys_oper_type','','primary','N','0','admin','2024-05-15 13:56:40','',NULL,'授权操作'),
	 (5,'导出','5','sys_oper_type','','warning','N','0','admin','2024-05-15 13:56:40','',NULL,'导出操作'),
	 (6,'导入','6','sys_oper_type','','warning','N','0','admin','2024-05-15 13:56:40','',NULL,'导入操作'),
	 (7,'强退','7','sys_oper_type','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'强退操作'),
	 (8,'生成代码','8','sys_oper_type','','warning','N','0','admin','2024-05-15 13:56:40','',NULL,'生成操作'),
	 (9,'清空数据','9','sys_oper_type','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'清空操作'),
	 (1,'成功','0','sys_common_status','','primary','N','0','admin','2024-05-15 13:56:40','',NULL,'正常状态'),
	 (2,'失败','1','sys_common_status','','danger','N','0','admin','2024-05-15 13:56:40','',NULL,'停用状态'),
	 (1,'黄金会员','00','salon_member_level',NULL,'info','Y','0','admin','2024-05-20 14:24:25','',NULL,NULL);
INSERT INTO ruoyi.sys_dict_data (dict_sort,dict_label,dict_value,dict_type,css_class,list_class,is_default,status,create_by,create_time,update_by,update_time,remark) VALUES
	 (2,'铂金会员','01','salon_member_level',NULL,'info','Y','0','admin','2024-05-20 14:24:53','',NULL,NULL),
	 (2,'钻石会员','02','salon_member_level',NULL,'info','Y','0','admin','2024-05-20 14:25:10','',NULL,NULL),
	 (1,'微信','1','salon_pay_mode',NULL,'default','Y','0','admin','2024-05-29 13:34:26','',NULL,NULL),
	 (2,'支付宝','2','salon_pay_mode',NULL,'default','Y','0','admin','2024-05-29 13:34:51','',NULL,NULL),
	 (3,'现金','3','salon_pay_mode',NULL,'default','Y','0','admin','2024-05-29 13:35:06','',NULL,NULL),
	 (9,'其他','9','salon_pay_mode',NULL,'warning','Y','0','admin','2024-05-29 13:35:21','admin','2024-05-29 13:35:35','');

INSERT INTO ruoyi.sys_dict_type (dict_name,dict_type,status,create_by,create_time,update_by,update_time,remark) VALUES
	 ('用户性别','sys_user_sex','0','admin','2024-05-15 13:56:40','',NULL,'用户性别列表'),
	 ('菜单状态','sys_show_hide','0','admin','2024-05-15 13:56:40','',NULL,'菜单状态列表'),
	 ('系统开关','sys_normal_disable','0','admin','2024-05-15 13:56:40','',NULL,'系统开关列表'),
	 ('任务状态','sys_job_status','0','admin','2024-05-15 13:56:40','',NULL,'任务状态列表'),
	 ('任务分组','sys_job_group','0','admin','2024-05-15 13:56:40','',NULL,'任务分组列表'),
	 ('系统是否','sys_yes_no','0','admin','2024-05-15 13:56:40','',NULL,'系统是否列表'),
	 ('通知类型','sys_notice_type','0','admin','2024-05-15 13:56:40','',NULL,'通知类型列表'),
	 ('通知状态','sys_notice_status','0','admin','2024-05-15 13:56:40','',NULL,'通知状态列表'),
	 ('操作类型','sys_oper_type','0','admin','2024-05-15 13:56:40','',NULL,'操作类型列表'),
	 ('系统状态','sys_common_status','0','admin','2024-05-15 13:56:40','',NULL,'登录状态列表');
INSERT INTO ruoyi.sys_dict_type (dict_name,dict_type,status,create_by,create_time,update_by,update_time,remark) VALUES
	 ('会员等级','salon_member_level','0','admin','2024-05-20 14:23:09','',NULL,NULL),
	 ('支付方式','salon_pay_mode','0','admin','2024-05-29 13:32:28','',NULL,'支付方式');

INSERT INTO ruoyi.sys_job (job_name,job_group,invoke_target,cron_expression,misfire_policy,concurrent,status,create_by,create_time,update_by,update_time,remark) VALUES
	 ('系统默认（无参）','DEFAULT','ryTask.ryNoParams','0/10 * * * * ?','3','1','1','admin','2024-05-15 13:56:40','',NULL,''),
	 ('系统默认（有参）','DEFAULT','ryTask.ryParams(''ry'')','0/15 * * * * ?','3','1','1','admin','2024-05-15 13:56:40','',NULL,''),
	 ('系统默认（多参）','DEFAULT','ryTask.ryMultipleParams(''ry'', true, 2000L, 316.50D, 100)','0/20 * * * * ?','3','1','1','admin','2024-05-15 13:56:40','',NULL,'');

INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('系统管理',0,10,'#','menuItem','M','0','1','','fa fa-gear','admin','2024-05-15 13:56:38','admin','2024-05-28 15:28:31','系统管理目录'),
	 ('系统监控',0,11,'#','menuItem','M','0','1','','fa fa-video-camera','admin','2024-05-15 13:56:38','admin','2024-05-28 15:28:35','系统监控目录'),
	 ('系统工具',0,12,'#','menuItem','M','0','1','','fa fa-bars','admin','2024-05-15 13:56:39','admin','2024-05-28 15:28:40','系统工具目录'),
	 ('若依官网',0,13,'http://ruoyi.vip','menuBlank','C','0','1','','fa fa-location-arrow','admin','2024-05-15 13:56:39','admin','2024-05-28 15:28:46','若依官网地址'),
	 ('用户管理',1,1,'/system/user','','C','0','1','system:user:view','fa fa-user-o','admin','2024-05-15 13:56:39','',NULL,'用户管理菜单'),
	 ('角色管理',1,2,'/system/role','','C','0','1','system:role:view','fa fa-user-secret','admin','2024-05-15 13:56:39','',NULL,'角色管理菜单'),
	 ('菜单管理',1,3,'/system/menu','','C','0','1','system:menu:view','fa fa-th-list','admin','2024-05-15 13:56:39','',NULL,'菜单管理菜单'),
	 ('部门管理',1,4,'/system/dept','','C','0','1','system:dept:view','fa fa-outdent','admin','2024-05-15 13:56:39','',NULL,'部门管理菜单'),
	 ('岗位管理',1,5,'/system/post','','C','0','1','system:post:view','fa fa-address-card-o','admin','2024-05-15 13:56:39','',NULL,'岗位管理菜单'),
	 ('字典管理',1,6,'/system/dict','','C','0','1','system:dict:view','fa fa-bookmark-o','admin','2024-05-15 13:56:39','',NULL,'字典管理菜单');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('参数设置',1,7,'/system/config','','C','0','1','system:config:view','fa fa-sun-o','admin','2024-05-15 13:56:39','',NULL,'参数设置菜单'),
	 ('通知公告',1,8,'/system/notice','','C','0','1','system:notice:view','fa fa-bullhorn','admin','2024-05-15 13:56:39','',NULL,'通知公告菜单'),
	 ('日志管理',1,9,'#','','M','0','1','','fa fa-pencil-square-o','admin','2024-05-15 13:56:39','',NULL,'日志管理菜单'),
	 ('在线用户',2,1,'/monitor/online','','C','0','1','monitor:online:view','fa fa-user-circle','admin','2024-05-15 13:56:39','',NULL,'在线用户菜单'),
	 ('定时任务',2,2,'/monitor/job','','C','0','1','monitor:job:view','fa fa-tasks','admin','2024-05-15 13:56:39','',NULL,'定时任务菜单'),
	 ('数据监控',2,3,'/monitor/data','','C','0','1','monitor:data:view','fa fa-bug','admin','2024-05-15 13:56:39','',NULL,'数据监控菜单'),
	 ('服务监控',2,4,'/monitor/server','','C','0','1','monitor:server:view','fa fa-server','admin','2024-05-15 13:56:39','',NULL,'服务监控菜单'),
	 ('缓存监控',2,5,'/monitor/cache','','C','0','1','monitor:cache:view','fa fa-cube','admin','2024-05-15 13:56:39','',NULL,'缓存监控菜单'),
	 ('表单构建',3,1,'/tool/build','','C','0','1','tool:build:view','fa fa-wpforms','admin','2024-05-15 13:56:39','',NULL,'表单构建菜单'),
	 ('代码生成',3,2,'/tool/gen','','C','0','1','tool:gen:view','fa fa-code','admin','2024-05-15 13:56:39','',NULL,'代码生成菜单');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('系统接口',3,3,'/tool/swagger','','C','0','1','tool:swagger:view','fa fa-gg','admin','2024-05-15 13:56:39','',NULL,'系统接口菜单'),
	 ('操作日志',108,1,'/monitor/operlog','','C','0','1','monitor:operlog:view','fa fa-address-book','admin','2024-05-15 13:56:39','',NULL,'操作日志菜单'),
	 ('登录日志',108,2,'/monitor/logininfor','','C','0','1','monitor:logininfor:view','fa fa-file-image-o','admin','2024-05-15 13:56:39','',NULL,'登录日志菜单'),
	 ('用户查询',100,1,'#','','F','0','1','system:user:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('用户新增',100,2,'#','','F','0','1','system:user:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('用户修改',100,3,'#','','F','0','1','system:user:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('用户删除',100,4,'#','','F','0','1','system:user:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('用户导出',100,5,'#','','F','0','1','system:user:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('用户导入',100,6,'#','','F','0','1','system:user:import','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('重置密码',100,7,'#','','F','0','1','system:user:resetPwd','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('角色查询',101,1,'#','','F','0','1','system:role:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('角色新增',101,2,'#','','F','0','1','system:role:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('角色修改',101,3,'#','','F','0','1','system:role:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('角色删除',101,4,'#','','F','0','1','system:role:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('角色导出',101,5,'#','','F','0','1','system:role:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('菜单查询',102,1,'#','','F','0','1','system:menu:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('菜单新增',102,2,'#','','F','0','1','system:menu:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('菜单修改',102,3,'#','','F','0','1','system:menu:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('菜单删除',102,4,'#','','F','0','1','system:menu:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('部门查询',103,1,'#','','F','0','1','system:dept:list','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('部门新增',103,2,'#','','F','0','1','system:dept:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('部门修改',103,3,'#','','F','0','1','system:dept:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('部门删除',103,4,'#','','F','0','1','system:dept:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('岗位查询',104,1,'#','','F','0','1','system:post:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('岗位新增',104,2,'#','','F','0','1','system:post:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('岗位修改',104,3,'#','','F','0','1','system:post:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('岗位删除',104,4,'#','','F','0','1','system:post:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('岗位导出',104,5,'#','','F','0','1','system:post:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('字典查询',105,1,'#','','F','0','1','system:dict:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('字典新增',105,2,'#','','F','0','1','system:dict:add','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('字典修改',105,3,'#','','F','0','1','system:dict:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('字典删除',105,4,'#','','F','0','1','system:dict:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('字典导出',105,5,'#','','F','0','1','system:dict:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('参数查询',106,1,'#','','F','0','1','system:config:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('参数新增',106,2,'#','','F','0','1','system:config:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('参数修改',106,3,'#','','F','0','1','system:config:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('参数删除',106,4,'#','','F','0','1','system:config:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('参数导出',106,5,'#','','F','0','1','system:config:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('公告查询',107,1,'#','','F','0','1','system:notice:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('公告新增',107,2,'#','','F','0','1','system:notice:add','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('公告修改',107,3,'#','','F','0','1','system:notice:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('公告删除',107,4,'#','','F','0','1','system:notice:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('操作查询',500,1,'#','','F','0','1','monitor:operlog:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('操作删除',500,2,'#','','F','0','1','monitor:operlog:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('详细信息',500,3,'#','','F','0','1','monitor:operlog:detail','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('日志导出',500,4,'#','','F','0','1','monitor:operlog:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('登录查询',501,1,'#','','F','0','1','monitor:logininfor:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('登录删除',501,2,'#','','F','0','1','monitor:logininfor:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('日志导出',501,3,'#','','F','0','1','monitor:logininfor:export','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('账户解锁',501,4,'#','','F','0','1','monitor:logininfor:unlock','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('在线查询',109,1,'#','','F','0','1','monitor:online:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('批量强退',109,2,'#','','F','0','1','monitor:online:batchForceLogout','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('单条强退',109,3,'#','','F','0','1','monitor:online:forceLogout','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务查询',110,1,'#','','F','0','1','monitor:job:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务新增',110,2,'#','','F','0','1','monitor:job:add','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务修改',110,3,'#','','F','0','1','monitor:job:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务删除',110,4,'#','','F','0','1','monitor:job:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('状态修改',110,5,'#','','F','0','1','monitor:job:changeStatus','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务详细',110,6,'#','','F','0','1','monitor:job:detail','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('任务导出',110,7,'#','','F','0','1','monitor:job:export','#','admin','2024-05-15 13:56:39','',NULL,'');
INSERT INTO ruoyi.sys_menu (menu_name,parent_id,order_num,url,target,menu_type,visible,is_refresh,perms,icon,create_by,create_time,update_by,update_time,remark) VALUES
	 ('生成查询',115,1,'#','','F','0','1','tool:gen:list','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('生成修改',115,2,'#','','F','0','1','tool:gen:edit','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('生成删除',115,3,'#','','F','0','1','tool:gen:remove','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('预览代码',115,4,'#','','F','0','1','tool:gen:preview','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('生成代码',115,5,'#','','F','0','1','tool:gen:code','#','admin','2024-05-15 13:56:39','',NULL,''),
	 ('会员管理',0,1,'#','menuItem','M','0','1',NULL,'fa fa-address-book','admin','2024-05-18 22:57:14','admin','2024-05-28 15:28:26',''),
	 ('会员信息',2000,1,'/salon/member','menuItem','C','0','0','','fa fa-address-card','admin','2024-05-18 23:00:07','admin','2024-05-18 23:01:58',''),
	 ('项目管理',0,2,'#','menuItem','M','0','1',NULL,'fa fa-tree','admin','2024-05-28 15:18:58','',NULL,''),
	 ('项目管理',2002,1,'/salon/item','menuItem','C','0','1',NULL,'fa fa-archive','admin','2024-05-28 15:21:16','',NULL,'');

INSERT INTO ruoyi.sys_notice (notice_title,notice_type,notice_content,status,create_by,create_time,update_by,update_time,remark) VALUES
	 ('温馨提醒：2018-07-01 若依新版本发布啦','2',0xE696B0E78988E69CACE58685E5AEB9,'0','admin','2024-05-15 13:56:41','',NULL,'管理员'),
	 ('维护通知：2018-07-01 若依系统凌晨维护','1',0xE7BBB4E68AA4E58685E5AEB9,'0','admin','2024-05-15 13:56:41','',NULL,'管理员'),
	 ('若依开源框架介绍','1',0x3C703E3C7370616E207374796C653D22636F6C6F723A20726762283233302C20302C2030293B223EE9A1B9E79BAEE4BB8BE7BB8D3C2F7370616E3E3C2F703E3C703E3C666F6E7420636F6C6F723D2223333333333333223E52756F5969E5BC80E6BA90E9A1B9E79BAEE698AFE4B8BAE4BC81E4B89AE794A8E688B7E5AE9AE588B6E79A84E5908EE58FB0E8849AE6898BE69EB6E6A186E69EB6EFBC8CE4B8BAE4BC81E4B89AE68993E980A0E79A84E4B880E7AB99E5BC8FE8A7A3E586B3E696B9E6A188EFBC8CE9998DE4BD8EE4BC81E4B89AE5BC80E58F91E68890E69CACEFBC8CE68F90E58D87E5BC80E58F91E69588E78E87E38082E4B8BBE8A681E58C85E68BACE794A8E688B7E7AEA1E79086E38081E8A792E889B2E7AEA1E79086E38081E983A8E997A8E7AEA1E79086E38081E88F9CE58D95E7AEA1E79086E38081E58F82E695B0E7AEA1E79086E38081E5AD97E585B8E7AEA1E79086E380813C2F666F6E743E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE5B297E4BD8DE7AEA1E790863C2F7370616E3E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE38081E5AE9AE697B6E4BBBBE58AA13C2F7370616E3E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE380813C2F7370616E3E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE69C8DE58AA1E79B91E68EA7E38081E799BBE5BD95E697A5E5BF97E38081E6938DE4BD9CE697A5E5BF97E38081E4BBA3E7A081E7949FE68890E7AD89E58A9FE883BDE38082E585B6E4B8ADEFBC8CE8BF98E694AFE68C81E5A49AE695B0E68DAEE6BA90E38081E695B0E68DAEE69D83E99990E38081E59BBDE99985E58C96E380815265646973E7BC93E5AD98E38081446F636B6572E983A8E7BDB2E38081E6BB91E58AA8E9AA8CE8AF81E7A081E38081E7ACACE4B889E696B9E8AEA4E8AF81E799BBE5BD95E38081E58886E5B883E5BC8FE4BA8BE58AA1E380813C2F7370616E3E3C666F6E7420636F6C6F723D2223333333333333223EE58886E5B883E5BC8FE69687E4BBB6E5AD98E582A83C2F666F6E743E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE38081E58886E5BA93E58886E8A1A8E5A484E79086E7AD89E68A80E69CAFE789B9E782B9E380823C2F7370616E3E3C2F703E3C703E3C696D67207372633D2268747470733A2F2F666F727564612E67697465652E636F6D2F696D616765732F313730353033303538333937373430313635312F35656435646236615F313135313030342E706E6722207374796C653D2277696474683A20363470783B223E3C62723E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A20726762283233302C20302C2030293B223EE5AE98E7BD91E58F8AE6BC94E7A4BA3C2F7370616E3E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE88BA5E4BE9DE5AE98E7BD91E59CB0E59D80EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F72756F79692E7669703C2F613E3C6120687265663D22687474703A2F2F72756F79692E76697022207461726765743D225F626C616E6B223E3C2F613E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE88BA5E4BE9DE69687E6A1A3E59CB0E59D80EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F646F632E72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F646F632E72756F79692E7669703C2F613E3C62723E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE6BC94E7A4BAE59CB0E59D80E38090E4B88DE58886E7A6BBE78988E38091EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F64656D6F2E72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F64656D6F2E72756F79692E7669703C2F613E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE6BC94E7A4BAE59CB0E59D80E38090E58886E7A6BBE78988E69CACE38091EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F7675652E72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F7675652E72756F79692E7669703C2F613E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE6BC94E7A4BAE59CB0E59D80E38090E5BEAEE69C8DE58AA1E78988E38091EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F636C6F75642E72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F636C6F75642E72756F79692E7669703C2F613E3C2F703E3C703E3C7370616E207374796C653D22636F6C6F723A207267622835312C2035312C203531293B223EE6BC94E7A4BAE59CB0E59D80E38090E7A7BBE58AA8E7ABAFE78988E38091EFBC9A266E6273703B3C2F7370616E3E3C6120687265663D22687474703A2F2F68352E72756F79692E76697022207461726765743D225F626C616E6B223E687474703A2F2F68352E72756F79692E7669703C2F613E3C2F703E3C703E3C6272207374796C653D22636F6C6F723A207267622834382C2034392C203531293B20666F6E742D66616D696C793A202671756F743B48656C766574696361204E6575652671756F743B2C2048656C7665746963612C20417269616C2C2073616E732D73657269663B20666F6E742D73697A653A20313270783B223E3C2F703E,'0','admin','2024-05-15 13:56:41','',NULL,'管理员');

INSERT INTO ruoyi.sys_oper_log (title,business_type,`method`,request_method,operator_type,oper_name,dept_name,oper_url,oper_ip,oper_location,oper_param,json_result,status,error_msg,oper_time,cost_time) VALUES
	 ('重置密码',2,'com.ruoyi.web.controller.system.SysProfileController.resetPwd()','POST',1,'admin','研发部门','/system/user/profile/resetPwd','127.0.0.1','内网IP','{"userId":["1"],"loginName":["admin"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-15 13:59:42',108),
	 ('菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.addSave()','POST',1,'admin','研发部门','/system/menu/add','127.0.0.1','内网IP','{"parentId":["0"],"menuType":["M"],"menuName":["会员管理"],"url":[""],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-address-book"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-18 22:57:14',150),
	 ('菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.addSave()','POST',1,'admin','研发部门','/system/menu/add','127.0.0.1','内网IP','{"parentId":["2000"],"menuType":["C"],"menuName":["会员信息"],"url":["/salon/memberInfo"],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-address-card"],"visible":["0"],"isRefresh":["0"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-18 23:00:07',20),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["2001"],"parentId":["2000"],"menuType":["C"],"menuName":["会员信息"],"url":["/salon/member"],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-address-card"],"visible":["0"],"isRefresh":["0"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-18 23:01:58',24),
	 ('字典类型',1,'com.ruoyi.web.controller.system.SysDictTypeController.addSave()','POST',1,'admin','研发部门','/system/dict/add','127.0.0.1','内网IP','{"dictName":["会员等级"],"dictType":["salon_member_level"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-20 14:23:09',134),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["黄金会员"],"dictValue":["00"],"dictType":["salon_member_level"],"cssClass":[""],"dictSort":["1"],"listClass":["info"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-20 14:24:25',29),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["铂金会员"],"dictValue":["01"],"dictType":["salon_member_level"],"cssClass":[""],"dictSort":["2"],"listClass":["info"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-20 14:24:53',50),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["钻石会员"],"dictValue":["02"],"dictType":["salon_member_level"],"cssClass":[""],"dictSort":["2"],"listClass":["info"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-20 14:25:10',27),
	 ('用户管理',2,'com.ruoyi.web.controller.system.SysUserController.editSave()','POST',1,'admin','研发部门','/system/user/edit','127.0.0.1','内网IP','{"userId":["2"],"deptId":["105"],"userName":["若依"],"dept.deptName":["测试部门"],"phonenumber":["15666666666"],"email":["ry@qq.com"],"loginName":["ry"],"sex":["1"],"role":["2"],"remark":["测试员1"],"status":["0"],"roleIds":["2"],"postIds":["2"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-22 12:57:12',168),
	 ('菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.addSave()','POST',1,'admin','研发部门','/system/menu/add','127.0.0.1','内网IP','{"parentId":["0"],"menuType":["M"],"menuName":["项目管理"],"url":[""],"target":["menuItem"],"perms":[""],"orderNum":["2"],"icon":["fa fa-tree"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:18:59',198);
INSERT INTO ruoyi.sys_oper_log (title,business_type,`method`,request_method,operator_type,oper_name,dept_name,oper_url,oper_ip,oper_location,oper_param,json_result,status,error_msg,oper_time,cost_time) VALUES
	 ('菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.addSave()','POST',1,'admin','研发部门','/system/menu/add','127.0.0.1','内网IP','{"parentId":["2002"],"menuType":["M"],"menuName":["项目管理"],"url":[""],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-archive"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:20:11',20),
	 ('菜单管理',3,'com.ruoyi.web.controller.system.SysMenuController.remove()','GET',1,'admin','研发部门','/system/menu/remove/2003','127.0.0.1','内网IP','2003','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:20:45',61),
	 ('菜单管理',1,'com.ruoyi.web.controller.system.SysMenuController.addSave()','POST',1,'admin','研发部门','/system/menu/add','127.0.0.1','内网IP','{"parentId":["2002"],"menuType":["C"],"menuName":["项目管理"],"url":["/salon/item"],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-archive"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:21:16',20),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["2000"],"parentId":["0"],"menuType":["M"],"menuName":["会员管理"],"url":["#"],"target":["menuItem"],"perms":[""],"orderNum":["10"],"icon":["fa fa-address-book"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:15',141),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["2000"],"parentId":["0"],"menuType":["M"],"menuName":["会员管理"],"url":["#"],"target":["menuItem"],"perms":[""],"orderNum":["1"],"icon":["fa fa-address-book"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:26',21),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["1"],"parentId":["0"],"menuType":["M"],"menuName":["系统管理"],"url":["#"],"target":["menuItem"],"perms":[""],"orderNum":["10"],"icon":["fa fa-gear"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:31',38),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["2"],"parentId":["0"],"menuType":["M"],"menuName":["系统监控"],"url":["#"],"target":["menuItem"],"perms":[""],"orderNum":["11"],"icon":["fa fa-video-camera"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:35',29),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["3"],"parentId":["0"],"menuType":["M"],"menuName":["系统工具"],"url":["#"],"target":["menuItem"],"perms":[""],"orderNum":["12"],"icon":["fa fa-bars"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:40',26),
	 ('菜单管理',2,'com.ruoyi.web.controller.system.SysMenuController.editSave()','POST',1,'admin','研发部门','/system/menu/edit','127.0.0.1','内网IP','{"menuId":["4"],"parentId":["0"],"menuType":["C"],"menuName":["若依官网"],"url":["http://ruoyi.vip"],"target":["menuBlank"],"perms":[""],"orderNum":["13"],"icon":["fa fa-location-arrow"],"visible":["0"],"isRefresh":["1"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-28 15:28:46',16),
	 ('字典类型',1,'com.ruoyi.web.controller.system.SysDictTypeController.addSave()','POST',1,'admin','研发部门','/system/dict/add','127.0.0.1','内网IP','{"dictName":["支付方式"],"dictType":["salon_pay_mode"],"status":["0"],"remark":["支付方式"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:32:28',168);
INSERT INTO ruoyi.sys_oper_log (title,business_type,`method`,request_method,operator_type,oper_name,dept_name,oper_url,oper_ip,oper_location,oper_param,json_result,status,error_msg,oper_time,cost_time) VALUES
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["微信"],"dictValue":["1"],"dictType":["salon_pay_mode"],"cssClass":[""],"dictSort":["1"],"listClass":["default"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:34:26',50),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["支付宝"],"dictValue":["2"],"dictType":["salon_pay_mode"],"cssClass":[""],"dictSort":["2"],"listClass":["default"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:34:52',16),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["现金"],"dictValue":["3"],"dictType":["salon_pay_mode"],"cssClass":[""],"dictSort":["3"],"listClass":["default"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:35:06',17),
	 ('字典数据',1,'com.ruoyi.web.controller.system.SysDictDataController.addSave()','POST',1,'admin','研发部门','/system/dict/data/add','127.0.0.1','内网IP','{"dictLabel":["9"],"dictValue":["其他"],"dictType":["salon_pay_mode"],"cssClass":[""],"dictSort":["9"],"listClass":["warning"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:35:21',17),
	 ('字典数据',2,'com.ruoyi.web.controller.system.SysDictDataController.editSave()','POST',1,'admin','研发部门','/system/dict/data/edit','127.0.0.1','内网IP','{"dictCode":["106"],"dictLabel":["其他"],"dictValue":["9"],"dictType":["salon_pay_mode"],"cssClass":[""],"dictSort":["9"],"listClass":["warning"],"isDefault":["Y"],"status":["0"],"remark":[""]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 13:35:35',25),
	 ('重置密码',2,'com.ruoyi.web.controller.system.SysUserController.resetPwdSave()','POST',1,'admin','研发部门','/system/user/resetPwd','127.0.0.1','内网IP','{"userId":["2"],"loginName":["ry"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 14:18:36',169),
	 ('重置密码',2,'com.ruoyi.web.controller.system.SysUserController.resetPwdSave()','POST',1,'admin','研发部门','/system/user/resetPwd','127.0.0.1','内网IP','{"userId":["2"],"loginName":["ry"]}','{"msg":"操作成功","code":0}',0,NULL,'2024-05-29 14:18:58',36);

INSERT INTO ruoyi.sys_post (post_code,post_name,post_sort,status,create_by,create_time,update_by,update_time,remark) VALUES
	 ('ceo','董事长',1,'0','admin','2024-05-15 13:56:38','',NULL,''),
	 ('se','项目经理',2,'0','admin','2024-05-15 13:56:38','',NULL,''),
	 ('hr','人力资源',3,'0','admin','2024-05-15 13:56:38','',NULL,''),
	 ('user','普通员工',4,'0','admin','2024-05-15 13:56:38','',NULL,'');

INSERT INTO ruoyi.sys_role (role_name,role_key,role_sort,data_scope,status,del_flag,create_by,create_time,update_by,update_time,remark) VALUES
	 ('超级管理员','admin',1,'1','0','0','admin','2024-05-15 13:56:38','',NULL,'超级管理员'),
	 ('普通角色','common',2,'2','0','0','admin','2024-05-15 13:56:38','',NULL,'普通角色');

INSERT INTO ruoyi.sys_role_dept (role_id,dept_id) VALUES
	 (2,100),
	 (2,101),
	 (2,105);

INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1),
	 (2,2),
	 (2,3),
	 (2,4),
	 (2,100),
	 (2,101),
	 (2,102),
	 (2,103),
	 (2,104),
	 (2,105);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,106),
	 (2,107),
	 (2,108),
	 (2,109),
	 (2,110),
	 (2,111),
	 (2,112),
	 (2,113),
	 (2,114),
	 (2,115);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,116),
	 (2,500),
	 (2,501),
	 (2,1000),
	 (2,1001),
	 (2,1002),
	 (2,1003),
	 (2,1004),
	 (2,1005),
	 (2,1006);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1007),
	 (2,1008),
	 (2,1009),
	 (2,1010),
	 (2,1011),
	 (2,1012),
	 (2,1013),
	 (2,1014),
	 (2,1015),
	 (2,1016);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1017),
	 (2,1018),
	 (2,1019),
	 (2,1020),
	 (2,1021),
	 (2,1022),
	 (2,1023),
	 (2,1024),
	 (2,1025),
	 (2,1026);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1027),
	 (2,1028),
	 (2,1029),
	 (2,1030),
	 (2,1031),
	 (2,1032),
	 (2,1033),
	 (2,1034),
	 (2,1035),
	 (2,1036);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1037),
	 (2,1038),
	 (2,1039),
	 (2,1040),
	 (2,1041),
	 (2,1042),
	 (2,1043),
	 (2,1044),
	 (2,1045),
	 (2,1046);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1047),
	 (2,1048),
	 (2,1049),
	 (2,1050),
	 (2,1051),
	 (2,1052),
	 (2,1053),
	 (2,1054),
	 (2,1055),
	 (2,1056);
INSERT INTO ruoyi.sys_role_menu (role_id,menu_id) VALUES
	 (2,1057),
	 (2,1058),
	 (2,1059),
	 (2,1060),
	 (2,1061);

INSERT INTO ruoyi.sys_user (dept_id,login_name,user_name,user_type,email,phonenumber,sex,avatar,password,salt,status,del_flag,login_ip,login_date,pwd_update_date,create_by,create_time,update_by,update_time,remark) VALUES
	 (103,'admin','若依','00','ry@163.com','15888888888','1','','85ca2b49527c399448421a8b94ea18bc','a6890b','0','0','127.0.0.1','2024-05-30 22:36:43','2024-05-15 21:59:42','admin','2024-05-15 13:56:38','','2024-05-30 14:36:43','管理员'),
	 (105,'ry','若依','00','ry@qq.com','15666666666','1','','39da14bd8bd13763b1a8414caf7ef33a','11cbc5','0','0','127.0.0.1',NULL,NULL,'admin','2024-05-15 13:56:38','admin','2024-05-29 14:18:58','测试员1');
INSERT INTO ruoyi.sys_user_online (sessionId,login_name,dept_name,ipaddr,login_location,browser,os,status,start_timestamp,last_access_time,expire_time) VALUES
	 ('79cac2f1-3707-4867-b1b2-f85373d5a0ea','admin','研发部门','127.0.0.1','内网IP','Chrome 12','Windows 10','on_line','2024-05-30 22:36:40','2024-05-30 22:41:50',1800000);

INSERT INTO ruoyi.sys_user_post (user_id,post_id) VALUES
	 (1,1),
	 (2,2);

INSERT INTO ruoyi.sys_user_role (user_id,role_id) VALUES
	 (1,1),
	 (2,2);
