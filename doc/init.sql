Drop Table If Exists `type`;
Create Table `type`(
	`Id` Int Unsigned Not Null Auto_Increment Comment '主键',
	`Title` Varchar(100) Not Null Comment '名称',
	`Icon` Varchar(100) Null Comment '图标',
	`Createtime` DateTime Not Null Comment '创建时间',
	Primary Key(`Id`)
) Comment = '类型表';

Drop Table If Exists `blog`;
Create Table `blog`(
	`Id` Int Unsigned Not Null Auto_Increment Comment '主键',
	`Createtime` DateTime Not Null Comment '创建时间',
	`Title` Varchar(100) Not Null Comment '标题',
	`Content` Longtext Not Null Comment '内容',
	`Description` Varchar(1000) Not Null Comment '简述',
	`Status` Bit Not Null Default 0 Comment '是否发布',
	`Recomand` Bit Not Null Default 0 Comment '是否推荐',
	`Typeid` Int Unsigned  Comment '类型id',
	Primary Key(`Id`),
	Constraint `fk_Blog_TID` Foreign Key(`Typeid`) References `type`(`Id`)
) Comment = '博客表';



Drop Table If Exists `tech`;
Create Table `tech`(
	`Id` Int Unsigned Not Null Auto_Increment Comment '主键',
	`Title` Varchar(100) Not Null Comment '名称',
	`Icon` Varchar(100) Null Comment '图标',
	`Level` Int Not Null Comment '层度',
	`Content` Varchar(1000) Not Null Comment '内容',
	`Status` Bit Not Null Default 0 Comment '状态',
	Primary Key(`Id`)
) Comment = '技术表';

Drop Table If Exists `progress`;
Create Table `progress`(
	`Id` Int Unsigned Not Null Auto_Increment Comment '主键',
	`Timenode` Varchar(50) Not Null Comment '时间节点',
	`Content` Varchar(500) Not Null Comment '内容',
	Primary Key(`Id`)
) Comment = '个人履历表';

Drop Table If Exists `project`;
Create Table `project`(
	`Id` Int Unsigned Not Null Auto_Increment Comment '主键',
	`Name` Varchar(100) Not Null Comment '项目名称',
	`Usedtech` Varchar(200) Not Null Comment '技术选型',
	`Content` Varchar(1000) Not Null Comment '项目内容',
	`Responsibility` Varchar(1000) Comment '项目职责',
	Primary Key(`Id`)
)Comment = '项目表';


Drop Table If Exists `user`;
CREATE TABLE `user` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(100) DEFAULT NULL,
  `Password` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `Nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `Mobile` varchar(30) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) Comment = '用户表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `Description` varchar(100) DEFAULT NULL,
  `Available` tinyint(1) DEFAULT '0',
  `Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '角色表';

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
	`Id` int unsigned NOT NULL AUTO_INCREMENT,
	`Userid` int unsigned NOT NULL,
	`Roleid` int unsigned NOT NULL,
	`Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
	`Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (`Id`),
	Constraint `fk_UserRole_UID` Foreign Key(`Userid`) References `user`(`Id`),
	Constraint `fk_UserRole_RID` Foreign Key(`Roleid`) References `role`(`Id`)
) Comment = '用户角色表';


DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `parentId` bigint(20) unsigned DEFAULT '0',
  `sort` int unsigned DEFAULT NULL,
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单图标',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) Comment = '路径表';

DROP TABLE IF EXISTS `roleresources`;
CREATE TABLE `roleresources` (
  `Id` int unsigned NOT NULL AUTO_INCREMENT,
  `Roleid` int unsigned NOT NULL,
  `Resourcesid` int unsigned NOT NULL,
  `Createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `Updatetime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
	Constraint `fk_RoleResources_RoleID` Foreign Key(`Roleid`) References `role`(`Id`),
	Constraint `fk_RoleResources_RID` Foreign Key(`Resourcesid`) References `resources`(`Id`)
) Comment = '角色资源表';

Drop Table If Exists `versionlog`;
Create Table `versionlog`(
  `Id` int Unsigned Not Null Auto_Increment Comment '主键',
  `Version` Varchar(100) Not Null Comment '版本号',
  `Discription` Varchar(200) Not Null Comment '描述',
  `Time` Datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  Primary Key(`Id`)
) Comment = '版本更新日志';

