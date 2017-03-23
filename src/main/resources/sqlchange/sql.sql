
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
   `password` VARCHAR(128) NULL COMMENT '密码',
   `checker` INT(11) NULL COMMENT '验证码',
   `credit` INT(11) NOT NULL DEFAULT 100 COMMENT '信用分',
   `address` VARCHAR(256) NULL COMMENT '地址',
   `register_time` DATETIME COMMENT '注册时间',
   PRIMARY KEY (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

ALTER table `test`.`custom` add last_time DATETIME COMMENT '最后活跃时间';
ALTER table `test`.`custom` add token VARCHAR(256) COMMENT 'token';

ALTER TABLE `test`.`custom`
 CHANGE COLUMN `password` `password` VARCHAR(128) NULL DEFAULT NULL COMMENT '密码' ;

ALTER table `test`.`custom` add longitude VARCHAR(128) COMMENT '经度';
ALTER table `test`.`custom` add latitude VARCHAR(128) COMMENT '纬度';
ALTER table `test`.`custom` add city VARCHAR(128) COMMENT '城市';
ALTER table `test`.`custom` add province VARCHAR(128) COMMENT '省份';
ALTER table `test`.`custom` add pt INT(4) COMMENT '设备类型';
ALTER table `test`.`custom` add dt VARCHAR(128) COMMENT '机型';

CREATE TABLE `test`.`shopping_cart` (
   `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
   ``
   PRIMARY KEY (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车';


 CREATE TABLE `test`.`refund` (
   `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
   `phone` VARCHAR(45) NULL COMMENT '手机号',
   `order_id` VARCHAR(128) NULL COMMENT '订单编号',
   `reason` VARCHAR(512) NULL COMMENT '退货说明',
   `message` VARCHAR(512) NULL COMMENT '留言说明',
   `pic1` VARCHAR(256) NULL COMMENT '图片1',
   `pic2` VARCHAR(256) NULL COMMENT '图片2',
   `pic3` VARCHAR(256) NULL COMMENT '图片3',
   `product_id` VARCHAR(128) NULL COMMENT '退货商品id',
   `number` INT(3) COMMENT '退款货物数量',
   `status` INT(3) NOT NULL DEFAULT '0' COMMENT '状态',
   `time` DATETIME COMMENT '提交退换货时间',
   PRIMARY KEY (`id`),
   INDEX phone_index(`phone`),
   INDEX order_index(`order_id`),
   INDEX date_index(`time`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退货表';

ALTER table `test`.`refund` add `address` VARCHAR(512) COMMENT '地址';

