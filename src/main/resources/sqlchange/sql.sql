
/**
 * 不用做配置文件,仅做sql同步使用
 *
 * @author: qiaoyi
 * @edit:
 * @created:17/2/14
 */

/**
 * 用于Mybatis测试使用表
 */
 CREATE TABLE `test`.`test_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `test` VARCHAR(45) NULL,
  `tep` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
  );

/**
 * 用户表
 */
  CREATE TABLE `test`.`custom` (
   `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
   `phone` VARCHAR(45) NULL COMMENT '手机号',
   `email` VARCHAR(128) NULL COMMENT '邮箱',
   `passport` VARCHAR(128) NULL COMMENT '密码',
   `checker` INT(11) NULL COMMENT '验证码',
   `credit` INT(11) NOT NULL DEFAULT 100 COMMENT '信用分',
   `address` VARCHAR(256) NULL COMMENT '地址',
   `register_time` DATETIME COMMENT '注册时间',
   PRIMARY KEY (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

ALTER table `test`.`custom` add last_time DATETIME COMMENT '最后活跃时间';
