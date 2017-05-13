
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

CREATE TABLE `test`.`shopping_cart`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `phone` VARCHAR(45) NULL COMMENT '手机号',
  `count` INT (5) DEFAULT 1 COMMENT '数量',
  `user_id` INT(11) COMMENT '用户id',
  `product_id` INT (11) NOT  NULL COMMENT '商品id',
  `time` DATETIME COMMENT '第一次时间',
   PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

CREATE TABLE `test`.`collection`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `phone` VARCHAR(45) NULL COMMENT '手机号',
  `product_id` INT (11) NOT  NULL COMMENT '商品id',
  `time` DATETIME COMMENT '用户收藏时间',
   PRIMARY KEY (`id`),
   INDEX phone_index(`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

CREATE TABLE `test`.`address`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `phone` VARCHAR(45) NULL COMMENT '手机号',
  `name` VARCHAR(256) NULL COMMENT '用户编辑名',
  `district` INT(11) COMMENT '地区id',
  `residential_area` INT(11) COMMENT '小区id',
  `self_lifting_cabinet` INT(11) COMMENT '自提柜id',
  `warehouse_id` INT(11) COMMENT '分库id',
  `dt` DATETIME COMMENT '时间',
  PRIMARY KEY (`id`),
  INDEX phone_index(`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户地址表';

ALTER TABLE `test`.`shopping_cart`
  add `address_id` INT(11) COMMENT '地址id',
  add `cabinet_id` INT(11) COMMENT '柜子id',
  add `type` int(2) comment '0:预约,1:现货',
  add `stock` int(11) comment '库存';

ALTER  TABLE `test`.`address`
    add `default_address` int(2) not null default 0 COMMENT '0:普通地址,1:默认账户';

CREATE TABLE `test`.`system_message`(
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `title` VARCHAR(512) NULL COMMENT '标题',
  `message` TEXT NOT NULL COMMENT '系统消息',
  `url` VARCHAR(1024) NOT NULL  COMMENT '图片url',
  `phone` VARCHAR(45) NOT NULL COMMENT '手机号',
  `create_type` INT(2) DEFAULT 0 COMMENT '创建类型',
  `dt` DATETIME COMMENT '时间',
  PRIMARY KEY (`id`),
  INDEX phone_index(`phone`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户系统消息表';

ALTER  TABLE `test`.`address`
    add `user_name` VARCHAR(512) NULL COMMENT '收货人姓名';

ALTER  TABLE `test`.`address`
  add `district_name` VARCHAR(512) NULL COMMENT '地区名字',
  add `residential_area_name` VARCHAR(512) NULL COMMENT '小区名字',
  add `location` VARCHAR(512) NULL COMMENT '自提柜具体位置';

ALTER  TABLE `test`.`address`
  add `remove` INT(2) NULL DEFAULT 0 COMMENT '0正常,1删除';

ALTER  TABLE `test`.`address`
  add `cabinet_number` VARCHAR(512) NULL COMMENT '自提柜id';

ALTER  TABLE `test`.`address`
  add `recieve_phone` VARCHAR(512) NULL COMMENT '收货人手机号';

ALTER TABLE  `test`.`category`
    ADD `is_fresh` int(2) NOT NULL DEFAULT 0 COMMENT  '0:普通,1:生鲜';

ALTER TABLE `test`.`shopping_cart`
    add `status` int(2) not NULL DEFAULT 0 COMMENT '购物车状态,0:正常 1:删除';