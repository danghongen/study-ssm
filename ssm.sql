/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : ssm

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 14/04/2020 15:34:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE "menu" (
  "id" bigint(20) NOT NULL,
  "parentId" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "menu_name" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "permission" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '0', '鬼剑士', 'professor:index');
INSERT INTO `menu` VALUES (2, '1', '剑魂', 'professor:sword_soul');
INSERT INTO `menu` VALUES (3, '1', '红眼', 'professor:red_eye');
INSERT INTO `menu` VALUES (4, '1', '阿修罗', 'professor:asura');
INSERT INTO `menu` VALUES (5, '1', '鬼泣', 'professor:devil_may_cry');
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE "role_menu" (
  "id" bigint(20) NOT NULL,
  "role_id" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "menu_id" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
INSERT INTO `role_menu` VALUES (1, '1', '1');
INSERT INTO `role_menu` VALUES (2, '1', '2');
INSERT INTO `role_menu` VALUES (3, '1', '3');
INSERT INTO `role_menu` VALUES (4, '1', '4');
INSERT INTO `role_menu` VALUES (5, '1', '5');
INSERT INTO `role_menu` VALUES (6, '2', '1');
INSERT INTO `role_menu` VALUES (7, '2', '2');
INSERT INTO `role_menu` VALUES (8, '2', '3');
INSERT INTO `role_menu` VALUES (9, '2', '4');
INSERT INTO `role_menu` VALUES (10, '2', '5');
INSERT INTO `role_menu` VALUES (11, '3', '2');
INSERT INTO `role_menu` VALUES (12, '3', '3');
INSERT INTO `role_menu` VALUES (13, '3', '4');
INSERT INTO `role_menu` VALUES (14, '3', '5');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE "sys_role" (
  "id" bigint(20) NOT NULL,
  "role_name" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '管理员');
INSERT INTO `sys_role` VALUES (3, '用户王宝乐');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE "sys_user" (
  "id" bigint(20) NOT NULL AUTO_INCREMENT,
  "user_name" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "password" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "salt" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'he', '125', NULL);
INSERT INTO `sys_user` VALUES (2, 'lj', '521', NULL);
INSERT INTO `sys_user` VALUES (3, 'jh', '999', NULL);
INSERT INTO `sys_user` VALUES (4, 'de', '123456', NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE "user_role" (
  "id" bigint(20) NOT NULL,
  "user_id" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  "role_id" varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY ("id")
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, '1', '1');
INSERT INTO `user_role` VALUES (2, '2', '2');
INSERT INTO `user_role` VALUES (3, '3', '2');
INSERT INTO `user_role` VALUES (4, '4', '3');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
