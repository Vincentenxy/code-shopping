

# 数据库语句

- sqls
  ```sql

  # show databases;

  
  use shop;
  
  show tables;
  
  # 管理端菜单表
  create table `menu_info` (
  `menu_id` tinyint(4) comment '菜单id',
  `menu_name` varchar(60) not null comment '菜单名称',
  `menu_parent` tinyint(4) comment '父菜单id',
  `menu_icon`varchar(200) comment '菜单图标',
  `router` varchar(200) comment '菜单对应的路由',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary  key (`menu_id`)
  ) default charset=utf8 comment '微信商城系统-管理端左侧菜单栏表';
  desc menu_info;
  drop table menu_info;
  select * from menu_info;
  truncate table menu_info;
  
  insert into menu_info values
  ('10', '商品管理', NULL, '', 'goods', '', '', ''),
  ('11', '录入商品', '10', '', '/goods/InputGoods', '', '', ''),
  ('12', '修改商品信息', '10', '', '/goods/ModifyGoodsInfo', '', '', ''),
  ('20', '订单管理', NULL, '', 'orders', '', '', ''),
  ('21', '订单信息查询', '20', '', '/orders/ViewOrderInfo', '', '', ''),
  ('30', '数据统计', NULL, '', 'datamanger', '', '', '');
  
  update menu_info set menu_parent = '10' where menu_id='12';
  
  
  # 公司信息表
  create table `company_info` (
  `company_id` int(10) auto_increment comment '公司id，主键',
  `company_name` varchar(100) not null comment '公司名称',
  `company_desc` varchar(300) comment '公司描述',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`company_id`)
  ) default charset=utf8 comment '微信商城系统-公司信息表';
  desc company_info;
  drop table company_info;
  
  # 文件信息表
  create table `file_info` (
  `file_id` char(45) not null comment '文件id',
  `file_url` varchar(256) not null comment '文件url',
  `file_seq` tinyint(4) default 0 comment '文件顺序号',
  `file_type` tinyint(4) not null comment '文件类型，0-图片，1-视频',
  `is_main` tinyint(4) default 0 comment '是否主要文件，0-否，1-是',
  `create_time` datetime default now() not null comment '文件创建时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`file_id`)
  ) default charset=utf8 comment '微信商城系统-文件信息表';
  desc file_info;
  
  
  # 用户角色表
  create table role_style (
  `role_id` int(4) auto_increment comment '角色id，主键',
  `role_name` varchar(64) not null comment '角色名称',
  `role_desc` varchar(500) not null comment '角色描述',
  `create_time` datetime default now() not null comment '角色创建时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`role_id`)
  )default charset=utf8 comment '微信商城系统-用户角色表';
  desc role_style;
  drop table role_style;
  select * from shop.role_style;
  # 插入数据
  insert into shop.role_style values
  ('001', '超级管理员', '超级管理员，拥有最高权限', now(), '', '', ''),
  ('011', '店主', '店铺店主', now(), '', '', ''),
  ('012', '客服', '店铺客服', now(), '', '', ''),
  ('021', '普通客户', '普通购买客户', now(), '', '', '');
  
  # 店铺表
  create table `shop_info` (
  `shop_id` int(10) auto_increment comment '店铺id',
  `shop_name` varchar(90) not null comment '店铺名称',
  `shop_address` varchar(120) comment '店铺地址',
  `shop_desc` varchar(300) comment '店铺描述',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`shop_id`)
  ) default charset=utf8 comment '微信商城系统-店铺信息表';
  desc shop_info;
  drop table shop_info;
  
  # 类别表
  create table `category` (
  `category_id` int(4) auto_increment comment '类别id',
  `category_name` varchar(50) not null comment '类别名称',
  `category_parent_id` int(4) not null comment '父类别id',
  `category_desc` varchar(200) comment '类别描述',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`category_id`)
  ) default charset=utf8 comment '微信商城系统-类别信息表';
  desc category;
  drop table category;
  select * from category;
  insert into category values
  
  ('01000', '手机', '00000', '统一手机大类', '', '', ''),
  ('02000', '电脑', '00000', '电脑类别', '', '', ''),
  ('03000', '男装', '00000', '所有男性大类', '', '', ''),
  ('04000', '女装', '00000', '所有女性服装大类', '', '', ''),
  ('05000', '美妆', '00000', '化妆品等大类', '', '', ''),
  ('06000', '房产', '00000', '房子不动产', '', '', ''),
  ('04001', '女鞋', '04000', '女装下面女鞋', '', '', ''),
  ('03001', '男鞋', '03000', '男装下面男鞋', '', '', '');
  
  
  # ------------------------具有外键依赖的表------------------------
  # 用户信息表
  create table user_info (
  `user_id` int(10) auto_increment comment '用户id',
  `user_name` varchar(30)  not null comment '用户名',
  `user_passwd` varchar(200) not null comment '密码',
  `user_phone`  char(11) not null comment '手机号',
  `create_time` datetime default now() not null comment '注册时间',
  `img_id` varchar(20) comment '用户头像图片编号,图片表外键',
  `fk_role_id` int(4) default '0002' not null comment '角色类型',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`user_id`),
  constraint `fk_user_role` foreign key (`fk_role_id`) references shop.role_style(`role_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-用户信息表';
  desc user_info;
  drop table user_info;
  alter table user_info add unique(user_name);
  alter table user_info modify  `user_passwd` varchar(200);
  select * from shop.user_info;
  truncate table user_info;
  delete from user_info where user_phone = '18638378869';
  insert into user_info values
  (110000001, 'cesi', 'asdfasdfasdf', '18638378896', now(), '','12','','','');
  select user_name from user_info where user_name = 'cesi1';
  
  # 用户收获地址表
  create table `user_address` (
  `address_id` int(10) auto_increment comment '地址id',
  `fk_user_id` int(10) not null comment '用户id',
  `address_country` int(10) not null comment '国家',
  `address_province` int(10) not null comment '省份',
  `address_city` int(10) not null comment '城市',
  `address_detail` varchar(512) not null comment '详细地址',
  `is_default` tinyint(1) not null comment '是否默认，0-否，1-是',
  `zip_code` char(6) not null comment '邮政编码',
  `consignee` varchar(60) not null comment  '收货人姓名',
  `mobile` char(11) not null comment '手机号',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`address_id`),
  constraint `fk_address_user` foreign key (`fk_user_id`) references shop.user_info(`user_id`) on update cascade on delete cascade
  )default charset = utf8 comment '微信商城系统-收获地址表';
  desc user_address;
  drop table user_address;
  
  # 订单信息表
  create table `order_info` (
  `order_id` int auto_increment comment '订单主键',
  `order_num` varchar(20) not null comment '订单号',
  `fk_user_id` int(10) not null comment '用户id，用户表外键',
  `pay_price`   double(8,2) not null comment '订单价格',
  `is_pay` tinyint default 0 not null comment '是否支付，0-未支付，1-支付',
  `pay_time` datetime comment '支付时间',
  `is_ship` tinyint default 0 comment '是否收货，0-未收货，1-已收货',
  `ship_time` datetime comment '发货时间',
  `is_receipt` tinyint default 0 comment '是否发货，0-未发货，1-已发货',
  `ship_number` varchar(50) comment '快递公司订单编号，用来查询物流信息',
  `status` tinyint default 1 comment '订单状态，1-正常，0-禁用，-1-删除',
  `create_time` datetime default now() comment '订单创建时间',
  `update_time` datetime comment '订单更新时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`order_id`),
  constraint `fk_order_user` foreign key (`fk_user_id`) references shop.user_info(`user_id`) on update cascade on delete cascade
  )default charset = utf8 comment '微信商城系统-订单信息表';
  desc order_info;
  drop table order_info;
  
  # 品牌信息表
  create table `brand_info` (
  `brand_id` int(4) auto_increment comment '品牌id',
  `brand_name` varchar(100) not null comment '品牌中文名',
  `brand_name_eng` varchar(50) not null comment '品牌英文名',
  `brand_desc` varchar(200) not null comment '品牌描述',
  `fk_category_id` int(4) not null comment '外键，类别表id主键',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`brand_id`),
  constraint `fk_brand_category` foreign key (`fk_category_id`) references shop.category(`category_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-品牌信息表';
  desc brand_info;
  drop table brand_info;
  select * from brand_info;
  insert into brand_info values
  ('0010001', '阿迪达斯', 'Addias', '阿迪达斯品牌', '03000', '', '', ''),
  ('0010002', '测试1', 'test1', '测试品牌1', '01000', '', '', ''),
  ('0010003', '测试2', 'test2', '测试品牌2', '02000', '', '', ''),
  ('0010004', '测试3', 'test3', '测试品牌3', '03000', '', '', ''),
  ('0010005', '测试4', 'test4', '测试品牌4', '04000', '', '', ''),
  ('0010006', '测试5', 'test5', '测试品牌5', '05000', '', '', ''),
  ('0010007', '测试6', 'test6', '测试品牌6', '06000', '', '', ''),
  ('0010008', '测试7', 'test7', '测试品牌7', '01000', '', '', ''),
  ('0010009', '测试8', 'test8', '测试品牌8', '02000', '', '', '');
  # 商品信息表
  create table `goods_info` (
  `goods_id` int(10) auto_increment comment '商品id',
  `goods_num` varchar(30) not null unique comment '商品唯一编号',
  `goods_name` varchar(100) not null comment '商品名称',
  `goods_lable` varchar(100) not null comment '商品标签',
  `goods_desc` varchar(200) not null comment '商品详情',
  `goods_status` tinyint(4) default 1 not null comment '商品状态,0-下架，1-上架',
  `create_time` datetime default now() comment '商品入库时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  `fk_category_id` int(4) not null comment '类别id',
  `fk_shop_id` int(10) not null comment '店铺id',
  primary key (`goods_id`),
  constraint `fk_goods_category` foreign key (`fk_category_id`) references shop.category(`category_id`) on update cascade on delete cascade,
  constraint `fk_goods_shop` foreign key (`fk_shop_id`) references shop.shop_info(`shop_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-商品信息表';
  desc goods_info;
  drop table goods_info;
  alter table goods_info add `goods_num` varchar(30) not null unique comment '商品唯一编号';
  
  # 规格信息表
  drop table if exists `goods_format`;
  create table goods_format (
  `format_id` bigint(20) auto_increment comment '规格id,自增主键',
  `fk_goods_num` varchar(30) not null comment '商品唯一编号',
  `format_name` varchar(64) not null comment '规格名称',
  `format_price` double(8,2) default 0.00 not null comment '此规格价格',
  `format_count` int(4) comment '此规格数量',
  `format_status` tinyint(4) default 1 comment '此规格当前状态，0-停用，1-在用',
  `fk_brand_id` int not null comment '品牌id',
  `create_time` datetime default now() not null comment '此规格创建时间',
  `platform_price`   double(8,2) default 0.00 comment '平台价格',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`format_id`),
  constraint `fk_format_goods` foreign key (`fk_goods_num`) references shop.goods_info(`goods_num`) on update cascade on delete cascade,
  constraint `fk_format_brand` foreign key (`fk_brand_id`) references shop.brand_info (`brand_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-商品规格信息表';
  desc goods_format;
  drop table goods_format;
  
  # 图片对应关系表
  drop table if exists relation_obj_file;
  create table `relation_obj_file` (
  `relation_id` bigint(20) auto_increment comment '商品与图片关系映射关系id',
  `obj_id` varchar(100) comment '图片所属主体id',
  `fk_file_id` varchar(45) not null comment '文件id,',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`relation_id`),
  constraint `fk_relation_file_info` foreign key (fk_file_id) references shop.file_info(file_id) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-实体与图片视频对应表';
  desc relation_obj_file;
  drop table relation_obj_file;
  
  # 购物车表
  create table `goods_shopcar` (
  `car_id` int auto_increment comment '购物车id',
  `fk_user_id` int(10) not null comment '用户id',
  `fk_shop_id` int(10) not null comment '店铺id',
  `fk_goods_id` int(10) not null comment '商品id',
  `goods_price`   double(8, 2) not null comment '商品价格',
  `goods_count` int default 1 not null comment '商品数量，默认为1',
  `status` tinyint default 0 not null comment '此条商品状态，0-正常，1-禁用',
  `add_time` datetime default now() comment '加入购物车的时间',
  `update_time` datetime null comment '此条记录更新时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`car_id`),
  constraint `fk_shopcar_user` foreign key (`fk_user_id`) references shop.user_info(`user_id`) on update cascade on delete cascade,
  constraint `fk_shopcar_shop` foreign key (`fk_shop_id`) references shop.shop_info(`shop_id`) on update cascade on delete cascade,
  constraint `fk_shopcar_goods` foreign key (`fk_goods_id`) references shop.goods_info(`goods_id`) on update cascade on delete cascade
  )default charset=utf8 comment '微信商城系统-购物车表';
  desc goods_shopcar;
  drop table goods_shopcar;
  
  # 订单商品表
  create table `relation_order_goods` (
  `id` int(10) auto_increment comment '商品id，主键自增',
  `fk_order_id` int(10) not null comment '订单id，订单信息表id主键',
  `fk_shop_id` int(10) not null comment '外键，店铺id',
  `fk_goods_id` int(10) not null comment '外键，商品编号',
  `goods_count` int default 1 not null comment '订单中此商品数量，默认1件',
  `good_price`   double(8, 2) default  0.00 not null comment '订单中商品的最终售卖价格，用于计算订单费用使用',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`id`),
  constraint `fk_relation_order_goods` foreign key (`fk_order_id`) references shop.order_info(`order_id`) on update cascade on delete cascade,
  constraint `fk_relation_shop` foreign key (`fk_shop_id`) references shop.shop_info(`shop_id`) on update cascade on delete cascade,
  constraint `fk_relation_goods` foreign key (`fk_goods_id`) references shop.goods_info(`goods_id`) on update cascade on delete cascade
  )default charset=utf8 comment '微信商城系统-订单商品表';
  desc relation_order_goods;
  drop table relation_order_goods;
  
  # 收藏列表
  create table `collect_goods` (
  `collect_id` int(10) auto_increment comment '收藏id,主键',
  `fk_user_id` int(10) not null comment '外键，用户id',
  `fk_goods_id` int(10) not null comment '外键，商品id',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`collect_id`),
  constraint `fk_collect_user` foreign key (`fk_user_id`) references shop.user_info(`user_id`) on update cascade on delete cascade,
  constraint `fk_collect_goods` foreign key (`fk_goods_id`) references shop.goods_info(`goods_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-用户收藏列表';
  desc collect_goods;
  drop table collect_goods;
  
  # 物流信息表
  create table `logistic_info` (
  `id` int(10) auto_increment comment 'id,自增主键',
  `fk_order_id` int(10) not null comment '订单id,外键',
  `tacking_number` varchar(50) not null comment '快递公司快递单号',
  `delivery_time` datetime default now() not null comment '发货时间',
  `receive_time` datetime not null comment '收货时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`id`),
  constraint `fk_logistic_order` foreign key (`fk_order_id`) references shop.order_info(`order_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城-物流信息表';
  desc logistic_info;
  drop table logistic_info;
  
  # 首页轮播图信息
  use shop;
  create table `slide_show` (
  `slide_id` int(4) comment '轮播id',
  `fk_file_id` varchar(45) not null comment '外键，图片id',
  `slide_url` varchar(200) not null comment '详情链接',
  `slide_desc` varchar(300) comment '详情描述',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary  key (`slide_id`),
  constraint `fk_slide_file` foreign key (`fk_file_id`) references shop.file_info(`file_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-首页轮播图信息表';
  desc slide_show;
  drop table shop.slide_show;
  truncate table  shop.slide_show;
  
  # 创建评论表
  drop table if exists `criticism`;
  create table `criticism` (
  `criticism_id` int auto_increment comment '评论id',
  `fk_goods_num` varchar(30) not null comment '商品唯一编号',
  `fk_user_id` int(10) not null comment '外键，用户id',
  `content` varchar(600) not null comment '评论内容',
  `parentId` int comment '父评论id',
  `date` datetime default now() comment '评论创建时间',
  `spare1` varchar(10) comment '备用字段',
  `spare2` varchar(50) comment '备用字段',
  `spare3` varchar(100) comment '备用字段',
  primary key (`criticism_id`),
  constraint `fk_criticism_goods` foreign key (`fk_goods_num`) references shop.goods_info(`goods_num`) on update cascade on delete cascade,
  constraint `fk_criticism_user` foreign key (`fk_user_id`) references shop.user_info(`user_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-商品评论表';
  desc criticism;
  
  
  #测试
  CREATE TABLE `new_mobile` (
  `id` int(11) NOT NULL auto_increment,
  `mobile_name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET = UTF8;
  
  desc new_mobile;
  select * from new_mobile;
  insert into new_mobile value ('1', 'shou');
  insert into new_mobile value (null, 'shou');
  insert into new_mobile (id, mobile_name) value (null, '测试1');
  insert into new_mobile value (2343, 'ceshi ');
  
  # 格式化时间
  select date_format(now(), '%Y%m%d%H%m%s');
  
  
  # 创建用户wxshop/123456 指定shop库
  show databases;
  use mysql;
  show tables;
  desc user;
  
  # 创建wxshop/123456
  create user 'wxshop'@'%' identified by '1233456';
  
  # 修改用户密码 5.7版本以后版本，没有password字段
  alter user 'wxshop'@'%' identified by '123456';  # 方法1
  update user set authentication_string=password('123456') where user = 'wxshop'; # 方法2
  flush privileges ;
  
  # 设置外键检查
  set foreign_key_checks  = 0;
  
  
  # 指定数据库
  grant all on shop.* to 'wxshop'@'%';
  
  # 查询数据
  select Host, User from user;
  
  
  
  # 插入文件数据
  insert into
  file_info
  values
  ('20211224_ac1df063-7d55-487e-a2a6-cbefa3cfcd9a', 'C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20211224\\20211224_ac1df063-7d55-487e-a2a6-cbefa3cfcd9a.xml','1','0','0',now(),'','',''),
  ('20211224_b5106330-a1b4-42dc-8f11-6f4ef58b6c4b', 'C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20211224\\20211224_b5106330-a1b4-42dc-8f11-6f4ef58b6c4b.xml','1','0','0',now(),'','',''),
  ('20211224_ae1167d4-639a-4150-8eb4-7b8db8f3eaea', 'C:\\Users\\vincentEnxy\\Desktop\\Temp\\imgs\\20211224\\20211224_ae1167d4-639a-4150-8eb4-7b8db8f3eaea.flv','1','1','0',now(),'','','');
  select file_url from file_info;
  select * from file_info;
  
  
  use shop;
  select * from file_info;
  select * from menu_info;
  drop table menu_info;

  ```