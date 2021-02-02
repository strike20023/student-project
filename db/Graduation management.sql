/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : Graduation management

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 29/01/2021 11:32:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(64) NOT NULL COMMENT '学术交流活动名称',
  `activity_location` varchar(255) DEFAULT NULL COMMENT '活动地点',
  `activity_date` date DEFAULT NULL COMMENT '活动时间',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='学术交流活动表';

-- ----------------------------
-- Records of activity
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for activityassessment
-- ----------------------------
DROP TABLE IF EXISTS `activityassessment`;
CREATE TABLE `activityassessment` (
  `activityassessment_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `activity_id` int(9) unsigned zerofill NOT NULL,
  `student_id` int(9) unsigned zerofill NOT NULL,
  `activityassessment_name` varchar(64) DEFAULT NULL COMMENT '报告中英文名称',
  `photograph` binary(255) DEFAULT NULL COMMENT '参会证明图片',
  `comment` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`activityassessment_id`),
  KEY `_aa_activity` (`activity_id`),
  KEY `_aa_student` (`student_id`),
  CONSTRAINT `_aa_activity` FOREIGN KEY (`activity_id`) REFERENCES `activity` (`activity_id`),
  CONSTRAINT `_aa_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='学术交流信息统计表';

-- ----------------------------
-- Records of activityassessment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for assistantapplication
-- ----------------------------
DROP TABLE IF EXISTS `assistantapplication`;
CREATE TABLE `assistantapplication` (
  `assistantapplication_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `course_id` int(9) unsigned zerofill NOT NULL,
  `student_id` int(9) unsigned zerofill NOT NULL,
  PRIMARY KEY (`assistantapplication_id`),
  KEY `aa_course_id` (`course_id`),
  KEY `aa_student_id` (`student_id`),
  CONSTRAINT `aa_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `aa_student_id` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='助教工作申请表';

-- ----------------------------
-- Records of assistantapplication
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for assistantassessment
-- ----------------------------
DROP TABLE IF EXISTS `assistantassessment`;
CREATE TABLE `assistantassessment` (
  `assistantassessment_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `student_id` int(9) unsigned zerofill NOT NULL,
  `course_id` int(9) unsigned zerofill NOT NULL,
  `stu_assessment` varchar(255) DEFAULT NULL COMMENT '助教工作自述',
  `stu_date` datetime DEFAULT NULL COMMENT '学生评价时间',
  `tea_assessment` varchar(255) DEFAULT NULL COMMENT '授课教师评价',
  `tea_date` datetime DEFAULT NULL COMMENT '教师评价时间',
  `qualified` varchar(1) NOT NULL DEFAULT 'E' COMMENT '是否合格Y/N/E',
  PRIMARY KEY (`assistantassessment_id`),
  KEY `_aa_course` (`course_id`),
  KEY `_asa_student` (`student_id`),
  CONSTRAINT `_aa_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `_asa_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='助教工作评定表';

-- ----------------------------
-- Records of assistantassessment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `course_name` varchar(64) NOT NULL COMMENT '课程名称',
  `student_num` int(5) NOT NULL DEFAULT '0' COMMENT '授课人数',
  `course_type` varchar(64) NOT NULL COMMENT '课程性质',
  `student_type` varchar(64) NOT NULL COMMENT '授课对象',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='课程表';

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `project_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `project_name` varchar(64) NOT NULL COMMENT '项目名称',
  `project_type` varchar(64) NOT NULL COMMENT '项目类型',
  `project_start` date NOT NULL COMMENT '参与项目时间',
  `project_end` date NOT NULL COMMENT '结束项目时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='科研项目表';

-- ----------------------------
-- Records of project
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for projectassessment
-- ----------------------------
DROP TABLE IF EXISTS `projectassessment`;
CREATE TABLE `projectassessment` (
  `projectassessment_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `project_id` int(9) unsigned zerofill NOT NULL,
  `student_id` int(9) unsigned zerofill NOT NULL,
  `stu_work` varchar(64) DEFAULT NULL COMMENT '学生承担工作',
  `expenditure` int(9) DEFAULT NULL COMMENT '每个学生工作经费（万元）',
  `stu_signature` varchar(1) NOT NULL DEFAULT 'E' COMMENT '项目负责人签字认定Y/N/E',
  `tea_signature` varchar(1) NOT NULL DEFAULT 'E' COMMENT '指导教师签字认定Y/N/E',
  PRIMARY KEY (`projectassessment_id`),
  KEY `pa_project` (`project_id`),
  KEY `pa_student` (`student_id`),
  CONSTRAINT `pa_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `pa_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='项目参与情况表';

-- ----------------------------
-- Records of projectassessment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `student_name` varchar(64) NOT NULL COMMENT '学生姓名',
  `teacher_id` int(9) unsigned NOT NULL,
  `subject_id` int(9) unsigned zerofill NOT NULL,
  `user_id` int(9) unsigned zerofill NOT NULL,
  PRIMARY KEY (`student_id`),
  KEY `s_teacher` (`teacher_id`),
  KEY `s_user` (`user_id`),
  KEY `s_subject` (`subject_id`),
  CONSTRAINT `s_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `s_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `s_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='学生表';

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subject_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(64) NOT NULL COMMENT '学科名称',
  `maxassistant_num` int(3) NOT NULL DEFAULT '2' COMMENT '助教最大可选志愿数量',
  `projectrequirements_min` int(6) NOT NULL DEFAULT '6' COMMENT '参与项目最小经费要求',
  `activityrequirements_min` int(6) NOT NULL DEFAULT '2' COMMENT '学术交流最低次数要求',
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='学科及配置要求表';

-- ----------------------------
-- Records of subject
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(64) NOT NULL COMMENT '教师姓名',
  `subject_id` int(9) unsigned zerofill NOT NULL,
  `user_id` int(9) unsigned zerofill NOT NULL,
  `teacher_role` varchar(1) NOT NULL DEFAULT 'N' COMMENT '研究生培养管理员Y/N',
  PRIMARY KEY (`teacher_id`),
  KEY `t_user` (`user_id`),
  KEY `t_subject` (`subject_id`),
  CONSTRAINT `t_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`),
  CONSTRAINT `t_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='教师/管理员表';

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for teachercourse
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
  `teachercourse_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `course_id` int(9) unsigned zerofill NOT NULL,
  `teacher_id` int(9) unsigned zerofill NOT NULL,
  `teaching_time` int(3) unsigned DEFAULT '0' COMMENT '授课时间',
  PRIMARY KEY (`teachercourse_id`),
  KEY `tc_course` (`course_id`),
  KEY `tc_teacher` (`teacher_id`),
  CONSTRAINT `tc_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tc_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='授课教师表';

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(9) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `password` varchar(64) NOT NULL COMMENT '密码',
  `role` varchar(1) NOT NULL DEFAULT 'S' COMMENT '学生/教师 S/T',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='登录用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
