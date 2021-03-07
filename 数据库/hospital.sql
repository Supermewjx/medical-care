/*
Navicat MySQL Data Transfer

Source Server         : MYSQL
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : hospital

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2021-03-07 11:54:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bunk
-- ----------------------------
DROP TABLE IF EXISTS `bunk`;
CREATE TABLE `bunk` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Bunk_ID` int(255) NOT NULL COMMENT '床位号',
  `Room_ID` int(11) NOT NULL COMMENT '房间表外键ID',
  `Bunk_status` int(11) NOT NULL COMMENT '是否住人（0，未住1，住）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='床位表';

-- ----------------------------
-- Records of bunk
-- ----------------------------

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Depar_Name` varchar(255) DEFAULT NULL COMMENT '科室名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='科室表';

-- ----------------------------
-- Records of departments
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ept_name` varchar(255) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of dept
-- ----------------------------

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Doctor_number` varchar(255) NOT NULL COMMENT '医生工号',
  `Doctor_Name` varchar(255) NOT NULL COMMENT '医生姓名',
  `Departments_id` int(11) NOT NULL COMMENT '所属科室 外键',
  `Dept_ID` int(11) NOT NULL COMMENT '部门ID（外键）',
  `Doctor_Password` varchar(255) NOT NULL COMMENT '密码',
  `Doctor_email` varchar(255) NOT NULL COMMENT '邮箱',
  `Doctor_phone` varchar(255) NOT NULL COMMENT '电话',
  `Doctor_sex` varchar(255) NOT NULL COMMENT '性别',
  `Doctor_address` varchar(255) NOT NULL COMMENT '家庭住址',
  `Doctor_CarID` varchar(255) NOT NULL COMMENT '身份证号',
  `Doc_statsu` int(11) NOT NULL COMMENT '状态（0：正常登录1：异常不可登',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生表';

-- ----------------------------
-- Records of doctor
-- ----------------------------

-- ----------------------------
-- Table structure for doctordiagnose
-- ----------------------------
DROP TABLE IF EXISTS `doctordiagnose`;
CREATE TABLE `doctordiagnose` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Regis_ID` int(11) NOT NULL COMMENT '挂号外键 病人信息',
  `Diag_Condition` varchar(255) NOT NULL COMMENT '病情',
  `Is_hospital` int(11) NOT NULL COMMENT '是否需要住院（默认不需要）',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='医生诊断表';

-- ----------------------------
-- Records of doctordiagnose
-- ----------------------------

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Drug_name` varchar(255) NOT NULL COMMENT '药品名称',
  `Drug_price` decimal(10,0) NOT NULL COMMENT '药品单价',
  `Drug_explain` varchar(255) NOT NULL COMMENT '药品说明',
  `Drug_type` varchar(255) NOT NULL COMMENT '药品类型',
  `Drug_dosage` varchar(255) NOT NULL COMMENT '药品剂量',
  `Drug_specifications` varchar(255) NOT NULL COMMENT '药品规格',
  `Drug_way` varchar(255) NOT NULL COMMENT '药品使用方式',
  `Drug_quality` varchar(255) NOT NULL COMMENT '保质期',
  `Drug_manufacture` datetime NOT NULL COMMENT '药品生产日期',
  `Drug_company` varchar(255) NOT NULL COMMENT '单位(盒,片，瓶)',
  `Drug_manufactor` varchar(255) NOT NULL COMMENT '厂家',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品信息';

-- ----------------------------
-- Records of druginfo
-- ----------------------------

-- ----------------------------
-- Table structure for floor
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Floor_Name` varchar(255) NOT NULL COMMENT '病区名称',
  `Room_ID` int(11) NOT NULL COMMENT '房间号外键ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='病区信息表';

-- ----------------------------
-- Records of floor
-- ----------------------------

-- ----------------------------
-- Table structure for hospitalized
-- ----------------------------
DROP TABLE IF EXISTS `hospitalized`;
CREATE TABLE `hospitalized` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `recipe_id` int(11) NOT NULL COMMENT '处方表ID',
  `bunk_id` int(11) NOT NULL COMMENT '床位号外键',
  `status` int(11) NOT NULL COMMENT '是否出院（0，住院，1出院）',
  `hosp_day` varchar(255) NOT NULL COMMENT '住院天数',
  `hosp_start` datetime NOT NULL COMMENT '住院日期',
  `host_end` datetime NOT NULL COMMENT '出院日期',
  `host_money` decimal(10,0) NOT NULL COMMENT '住院金额',
  `registration_id` int(11) NOT NULL COMMENT '挂号表外键',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='住院表';

-- ----------------------------
-- Records of hospitalized
-- ----------------------------

-- ----------------------------
-- Table structure for manner
-- ----------------------------
DROP TABLE IF EXISTS `manner`;
CREATE TABLE `manner` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Manner_Name` varchar(255) NOT NULL COMMENT '方式名称(普通挂号，高级挂号)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='挂号方式表';

-- ----------------------------
-- Records of manner
-- ----------------------------

-- ----------------------------
-- Table structure for pharmacy
-- ----------------------------
DROP TABLE IF EXISTS `pharmacy`;
CREATE TABLE `pharmacy` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dru_ID` int(11) NOT NULL COMMENT '外键',
  `Drog_totalNumber` int(11) NOT NULL COMMENT '药房药品剩余总数量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药房表';

-- ----------------------------
-- Records of pharmacy
-- ----------------------------

-- ----------------------------
-- Table structure for recipe
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Regis_ID` int(11) NOT NULL COMMENT '挂号外键 病人信息',
  `Druginfo_ID` int(11) NOT NULL COMMENT '药品信息ID外键',
  `Drug_number` int(11) NOT NULL COMMENT '药品数量',
  `Drug_totalprice` decimal(10,0) NOT NULL COMMENT '总金额',
  `Recipe_payStatus` int(11) NOT NULL COMMENT '缴费状态',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处方表';

-- ----------------------------
-- Records of recipe
-- ----------------------------

-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Regis_number` varchar(255) NOT NULL COMMENT '号码',
  `Regis_Name` varchar(255) NOT NULL COMMENT '挂号信息姓名',
  `Regis_sex` int(5) NOT NULL COMMENT '性别（0:女 1:男）',
  `Regis_Phone` varchar(255) NOT NULL COMMENT '电话',
  `Regis_age` int(11) NOT NULL COMMENT '年龄',
  `Regis_birthday` datetime NOT NULL COMMENT '出生日期',
  `Regis_departments` int(11) NOT NULL COMMENT '科室ID(外键)',
  `Regis_doctor` int(11) NOT NULL COMMENT '医生ID(外键) ',
  `Regis_manner` int(11) NOT NULL COMMENT '挂号方式ID(外键)',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='挂号表';

-- ----------------------------
-- Records of registration
-- ----------------------------

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Room_num` int(255) NOT NULL COMMENT '房间号',
  `Floor_ID` int(11) NOT NULL COMMENT '病区外键ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房间表';

-- ----------------------------
-- Records of room
-- ----------------------------

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dru_ID` int(11) NOT NULL COMMENT ' 外键',
  `Drog_yktotalNumber` int(11) NOT NULL COMMENT '药库药品剩余总数量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药库表';

-- ----------------------------
-- Records of storage
-- ----------------------------
