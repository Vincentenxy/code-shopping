

# 数据库语句

- sqls
  ```sql
  # show databases;


  use shop;

  show tables;

  drop table user_address;

  desc user_address;

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

  # 图片信息表
  create table `img_info` (
      `img_id` bigint(20) auto_increment comment '图片主键id',
      `img_num` varchar(20) not null comment '图片编号',
      `img_url` varchar(256) not null comment '图片url',
      `img_seq` tinyint(4) default 0 not null comment '图片顺序号',
      `is_main` tinyint(4) default 1 not null comment '是否主图片，0-否，1-是',
      `create_time` datetime default now() not null comment '图片创建时间',
      `spare1` varchar(10) comment '备用字段',
      `spare2` varchar(50) comment '备用字段',
      `spare3` varchar(100) comment '备用字段',
      primary key (`img_id`)
  ) default charset=utf8 comment '微信商城系统-图片信息表';
  desc img_info;
  drop table img_info;

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

  # ------------------------具有外键依赖的表------------------------
  # 用户信息表
  create table user_info (
      `user_id` int(10) auto_increment comment '用户id',
      `user_name` varchar(30) not null comment '用户名',
      `user_passwd` varchar(16) not null comment '密码',
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

  # 商品信息表
  create table `goods_info` (
      `goods_id` int(10) auto_increment comment '商品id',
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

  # 规格信息表
  create table goods_format (
      `format_id` bigint(20) auto_increment comment '规格id,自增主键',
      `fk_goods_id` int(10) not null comment '商品id',
      `format_name` varchar(64) not null comment '规格名称',
      `format_price`   double(8,2) default 0.00 not null comment '此规格价格',
      `format_count` int(4) comment '此规格数量',
      `format_status` tinyint(4) default 1 comment '此规格当前状态，0-停用，1-在用',
      `create_time` datetime default now() not null comment '此规格创建时间',
        `platform_price`   double(8,2) default 0.00 comment '平台价格',
      `spare1` varchar(10) comment '备用字段',
      `spare2` varchar(50) comment '备用字段',
      `spare3` varchar(100) comment '备用字段',
      primary key (`format_id`),
      constraint `fk_format_goods` foreign key (`fk_goods_id`) references shop.goods_info(`goods_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-商品规格信息表';
  desc goods_format;
  drop table goods_format;

  # 图片对应关系表
  create table `relation_obj_img` (
      `relation_id` bigint(20) auto_increment comment '商品与图片关系映射表',
      `obj_id` int(10) not null comment '实体信息id',
      `fk_img_id` bigint(20) not null comment '图片id,',
      `spare1` varchar(10) comment '备用字段',
      `spare2` varchar(50) comment '备用字段',
      `spare3` varchar(100) comment '备用字段',
      primary key (`relation_id`),
      constraint `fk_relation_img` foreign key (fk_img_id) references shop.img_info(img_id) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-实体与商品图片对应表';
  desc relation_obj_img;
  drop table relation_obj_img;

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

  # 物流信息包
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
  
  
  # 首页轮播图信息表
  create table `slide_show` (
    `slide_id` int(4) comment '轮播id',
    `fk_img_id` bigint(20) not null comment '外键，图片id',
    `slide_url` varchar(200) not null comment '详情链接',
    `slide_desc` varchar(300) comment '详情描述',
    `spare1` varchar(10) comment '备用字段',
    `spare2` varchar(50) comment '备用字段',
    `spare3` varchar(100) comment '备用字段',
    primary  key (`slide_id`),
    constraint `fk_slide_img` foreign key (`fk_img_id`) references shop.img_info(`img_id`) on update cascade on delete cascade
  ) default charset=utf8 comment '微信商城系统-首页轮播图信息表';
  

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

  ```