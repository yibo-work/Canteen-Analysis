/*
 Navicat Premium Data Transfer

 Source Server         : local Mysql57
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : canteen_analysis

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 19/05/2020 23:03:54
*/
create database if not exists canteen_analysis;

use canteen_analysis;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for import_log
-- ----------------------------
DROP TABLE IF EXISTS `import_log`;
CREATE TABLE `import_log`
(
    `id`          int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `student_no`  varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '学号',
    `sex`         varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '性别',
    `school_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '学院',
    `money`       decimal(10, 1)                                                NULL DEFAULT NULL COMMENT '消费金额',
    `time`        datetime(0)                                                   NULL DEFAULT NULL COMMENT '消费时间',
    `station`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消费地点',
    `create_time` datetime(0)                                                   NULL DEFAULT CURRENT_TIMESTAMP COMMENT '导入时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '导入记录'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`
(
    `id`          int(11)     NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `user_id`     int(11)     NOT NULL COMMENT '用户id',
    `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 14
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '登录记录'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log`
VALUES (3, 1, '2020-05-19 22:47:08');
INSERT INTO `login_log`
VALUES (4, 1, '2020-05-19 22:47:15');
INSERT INTO `login_log`
VALUES (5, 1, '2020-05-19 22:47:23');
INSERT INTO `login_log`
VALUES (6, 1, '2020-05-19 22:47:27');
INSERT INTO `login_log`
VALUES (7, 1, '2020-05-19 22:47:32');
INSERT INTO `login_log`
VALUES (8, 1, '2020-05-19 22:47:40');
INSERT INTO `login_log`
VALUES (9, 1, '2020-05-19 22:47:45');
INSERT INTO `login_log`
VALUES (10, 1, '2020-05-19 22:47:54');
INSERT INTO `login_log`
VALUES (11, 1, '2020-05-19 22:48:12');
INSERT INTO `login_log`
VALUES (12, 6, '2020-05-19 22:49:41');
INSERT INTO `login_log`
VALUES (13, 1, '2020-05-19 22:50:25');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`
(
    `code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '学院编号',
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '学院名称',
    PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '学院'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school`
VALUES ('01', '外国语学院');
INSERT INTO `school`
VALUES ('02', '艺术学院');
INSERT INTO `school`
VALUES ('03', '体育学院');
INSERT INTO `school`
VALUES ('04', '美视电影学院');
INSERT INTO `school`
VALUES ('05', '国际学院');
INSERT INTO `school`
VALUES ('06', '弘深学院');
INSERT INTO `school`
VALUES ('07', '博雅学院');
INSERT INTO `school`
VALUES ('08', '公共管理学院');
INSERT INTO `school`
VALUES ('09', '经济与工商管理学院');
INSERT INTO `school`
VALUES ('10', '新闻学院');
INSERT INTO `school`
VALUES ('11', '法学院');
INSERT INTO `school`
VALUES ('12', '马克思主义学院');
INSERT INTO `school`
VALUES ('13', '数学与统计学院');
INSERT INTO `school`
VALUES ('14', '物理学院');
INSERT INTO `school`
VALUES ('15', '化学化工学院');
INSERT INTO `school`
VALUES ('16', '生命科学学院');
INSERT INTO `school`
VALUES ('17', '机械工程学院');
INSERT INTO `school`
VALUES ('18', '电气工程学院');
INSERT INTO `school`
VALUES ('19', '能源与动力工程学院');
INSERT INTO `school`
VALUES ('20', '资源与安全学院');
INSERT INTO `school`
VALUES ('21', '材料科学与工程学院');
INSERT INTO `school`
VALUES ('22', '航空航天学院');
INSERT INTO `school`
VALUES ('23', '汽车工程学院');
INSERT INTO `school`
VALUES ('24', '建筑城规学院');
INSERT INTO `school`
VALUES ('25', '土木工程学院');
INSERT INTO `school`
VALUES ('26', '环境与生态学院');
INSERT INTO `school`
VALUES ('27', '管理科学与房地产学院');
INSERT INTO `school`
VALUES ('28', '光电工程学院');
INSERT INTO `school`
VALUES ('29', '微电子与通信工程学院');
INSERT INTO `school`
VALUES ('30', '计算机学院');
INSERT INTO `school`
VALUES ('31', '自动化学院');
INSERT INTO `school`
VALUES ('32', '大数据与软件学院');
INSERT INTO `school`
VALUES ('33', '药学院');
INSERT INTO `school`
VALUES ('34', '生物工程学院');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int(11)                                                       NOT NULL AUTO_INCREMENT COMMENT '主键自增id',
    `user_no`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '工号',
    `name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
    `phone`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '密码',
    `email`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `role_id`  int(11)                                                       NOT NULL COMMENT '角色，1、管理员 2、教师',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `user_user_no_uindex` (`user_no`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 3
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT = '用户'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'admin', '管理员', '13313331444', '1234qweR', 'test.@163.com', 1);
INSERT INTO `user`
VALUES (2, 'teacher', '教师', '13313331444', '000000', 'test.@163.com', 2);

SET FOREIGN_KEY_CHECKS = 1;
