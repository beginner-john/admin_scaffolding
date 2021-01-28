/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : admin_scaffolding

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2021-01-28 11:13:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_data_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_data_dictionary`;
CREATE TABLE `t_data_dictionary` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `key_code` varchar(255) DEFAULT NULL COMMENT '字典编码',
  `key_en` varchar(255) DEFAULT NULL COMMENT '字典英文名',
  `key_cn` varchar(255) DEFAULT NULL COMMENT '字典中文名',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT=' 数据字典主表。保存字段key，只能手动往数据库添加';

-- ----------------------------
-- Records of t_data_dictionary
-- ----------------------------
INSERT INTO `t_data_dictionary` VALUES ('1', '1001', 'declare status', '申报状态', '2020-12-01 17:22:01', '1', null, null);

-- ----------------------------
-- Table structure for t_data_dictionary_desc
-- ----------------------------
DROP TABLE IF EXISTS `t_data_dictionary_desc`;
CREATE TABLE `t_data_dictionary_desc` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dictionary_id` bigint DEFAULT NULL COMMENT '字典主表id',
  `value_code` varchar(255) DEFAULT NULL COMMENT '字典编码',
  `value_en` varchar(255) DEFAULT NULL COMMENT '字典英文名',
  `value_cn` varchar(255) DEFAULT NULL COMMENT '字典中文名',
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据字典 详情表。配合数据字典主表一起使用';

-- ----------------------------
-- Records of t_data_dictionary_desc
-- ----------------------------
INSERT INTO `t_data_dictionary_desc` VALUES ('1', '1', '1001001', 'undeclared', '未申报3', '2020-12-01 17:23:06', '1', null, null);
INSERT INTO `t_data_dictionary_desc` VALUES ('2', '1', '1001002', 'declaring', '申报中', '2020-12-01 17:24:31', '1', null, null);
INSERT INTO `t_data_dictionary_desc` VALUES ('3', '1', '1001003', 'declaration success', '申报成功', '2020-12-01 17:25:24', '1', null, null);
INSERT INTO `t_data_dictionary_desc` VALUES ('4', '1', '1001004', 'declaration failure', '申报失败', '2020-12-01 17:26:00', '1', null, null);

-- ----------------------------
-- Table structure for t_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operation_log`;
CREATE TABLE `t_operation_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '访问者用户名',
  `access_path` varchar(255) DEFAULT NULL COMMENT '访问路径',
  `access_desc` varchar(255) DEFAULT NULL COMMENT '访问描述',
  `access_ip` varchar(255) DEFAULT NULL COMMENT '访问者的ip',
  `create_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='访问接口记录';

-- ----------------------------
-- Records of t_operation_log
-- ----------------------------
INSERT INTO `t_operation_log` VALUES ('1', 'anonymousUser', '/aa2222/login', '', '10.240.165.76', '2021-01-21 10:49:47');
INSERT INTO `t_operation_log` VALUES ('2', 'anonymousUser', '/login', '用户登录', '10.240.165.76', '2021-01-21 11:05:45');
INSERT INTO `t_operation_log` VALUES ('3', 'anonymousUser', '/login', '用户登录', '10.240.165.76', '2021-01-21 11:21:06');
INSERT INTO `t_operation_log` VALUES ('4', 'tom', '/users/save', '新增用户', '10.240.165.76', '2021-01-21 11:50:51');
INSERT INTO `t_operation_log` VALUES ('5', 'tom', '/users/save', '新增用户', '10.240.165.76', '2021-01-21 12:02:11');
INSERT INTO `t_operation_log` VALUES ('6', 'tom', '/basic/dataDictionary', '数据字典列表', '172.20.10.7', '2021-01-21 13:48:16');
INSERT INTO `t_operation_log` VALUES ('7', 'tom', '/users/{id}', '用户详情', '172.20.10.7', '2021-01-21 14:05:37');
INSERT INTO `t_operation_log` VALUES ('8', 'tom', '/users/{id}', '用户详情', '172.20.10.7', '2021-01-21 14:06:27');
INSERT INTO `t_operation_log` VALUES ('9', 'tom', '/users/{id}', '用户详情', '172.20.10.7', '2021-01-21 14:26:10');

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `resource_id` bigint DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色和资源的中间关联表';

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO `t_role_resource` VALUES ('2', '3', '3', '2020-11-29 17:33:47', null);

-- ----------------------------
-- Table structure for t_system_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_system_resource`;
CREATE TABLE `t_system_resource` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '资源名称',
  `code` varchar(255) DEFAULT NULL COMMENT '资源code',
  `res_url` varchar(255) DEFAULT NULL COMMENT '资源的url',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `type` int DEFAULT NULL COMMENT '资源类型，1：菜单，2：按钮，3：功能',
  `show_order` int DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=COMPACT COMMENT='系统资源表';

-- ----------------------------
-- Records of t_system_resource
-- ----------------------------
INSERT INTO `t_system_resource` VALUES ('3', '用户管理菜单', 'user_manage_menu', null, null, '1', '10', '2020-11-29 10:59:45', null, null, null);
INSERT INTO `t_system_resource` VALUES ('4', '用户管理菜单', 'user_manage_menu', null, null, '1', '10', '2020-11-29 10:59:45', null, null, null);
INSERT INTO `t_system_resource` VALUES ('5', '角色管理菜单', 'role_manage_menu', '/home/role', null, '1', null, '2020-11-29 13:54:18', null, null, null);

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色code，以这个来判断不同角色',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称，用于界面显示',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int DEFAULT '1' COMMENT '状态，用于伪删除。1，存在，0，不存在',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `update_by` bigint DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', 'admin', '管理员', '管理员权限', '1', '2020-11-21 10:18:28', null, null, null);
INSERT INTO `t_system_role` VALUES ('2', 'system_admin', '系统管理员', '系统管理员权限', '1', '2020-11-21 10:19:59', null, null, null);
INSERT INTO `t_system_role` VALUES ('3', 'group_leader', '组长', '组长权限', '1', '2020-11-21 10:21:12', null, null, null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '密码，加密',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sex` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '性别',
  `status` bit(1) DEFAULT NULL COMMENT '状态，启用1，禁用0',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_admin` bit(1) DEFAULT NULL COMMENT '是否是管理员，0为普通用户，1为系统管理员',
  `create_by` bigint DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL,
  `update_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '$2a$10$C3dq3h/WAQWxEanXtdeEUOrx87.fejXEAfFOaa3t8XUnVy4xhbNcy', null, null, '', '2020-11-01 13:15:14', '', '1', null, null);
INSERT INTO `t_user` VALUES ('2', 'tom', '$2a$10$C3dq3h/WAQWxEanXtdeEUOrx87.fejXEAfFOaa3t8XUnVy4xhbNcy', null, null, '', '2020-11-01 13:17:27', '\0', '1', null, null);
INSERT INTO `t_user` VALUES ('3', 'jack', '$2a$10$cfQYSPA.84ZP5MzHlyV2aujcvwfH.17LXO1XFFGOI1ZqSUIvB2h4y', '13142123512', 'woman', '', '2020-11-20 09:57:08', '\0', '2', '2021-01-07 11:24:47', '2');
INSERT INTO `t_user` VALUES ('5', 'xiong', '$2a$10$C3dq3h/WAQWxEanXtdeEUOrx87.fejXEAfFOaa3t8XUnVy4xhbNcy', '13174225651', null, '', null, '\0', null, null, null);
INSERT INTO `t_user` VALUES ('6', 'tiger', '$2a$10$3iK0yVGP8Bjn6.5OP/ctw.p3HlxwEM91GXLeHPzA38pjx34F6bKW.', '13142123512', 'man', '', null, '\0', null, null, null);
INSERT INTO `t_user` VALUES ('7', 'john', '$2a$10$YDfZKhLg4s8wk7HuCCY2yuh9aDmPFCkZRtNm0qyxbg5fKWDqZ6Rq6', '13142123512', 'man', '', null, '\0', null, null, null);
INSERT INTO `t_user` VALUES ('8', 'gold', '$2a$10$4E.lJAz97oYzzcuMoxM5z.gbNWyHcrVT2okbijRgwfivozxB2nx12', '13142123512', 'woman', '', null, '\0', null, null, null);
INSERT INTO `t_user` VALUES ('9', 'moli', '$2a$10$MgorjZKgbfgxs6eFaRwXNeNVIVy9ZKiJFAMxCRXVDiPzB9zGedh36', '13142123512', 'woman', '', '2021-01-07 11:24:02', '\0', '2', null, null);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('5', '1', '2', '2020-11-29 11:01:33', null);
