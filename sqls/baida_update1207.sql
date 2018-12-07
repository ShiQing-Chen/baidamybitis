create TABLE `shop` (
  `id` varchar(36) NOT NULL COMMENT '商店id',
  `shop_name` varchar(50) DEFAULT NULL COMMENT '店铺名字',
  `shop_address` varchar(100) DEFAULT NULL COMMENT '店铺地址',
  `shop_path` varchar(200) DEFAULT NULL COMMENT '店铺log',
  `shop_status` int(1) DEFAULT 0 COMMENT '店铺状态 1为上线 0为下线',
  `shop_desc` varchar(500) DEFAULT NULL COMMENT '店铺描述',
  `shop_phone` varchar(50) DEFAULT NULL COMMENT '店铺电话',
  `start_fee` float(10,2) DEFAULT 0 COMMENT '起送费',
  `start_time` datetime DEFAULT NULL COMMENT '营业开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '营业结束时间',
  `shop_activity` varchar(500) DEFAULT NULL COMMENT '活动',
  `shop_heat` int DEFAULT 0 COMMENT '热度',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_deleted` (`is_deleted`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_status` (`shop_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';

create TABLE `goods` (
  `id` varchar(36) NOT NULL COMMENT '商品id',
  `shop_id` varchar(36) DEFAULT NULL COMMENT '店铺id',
  `class_id` varchar(36) DEFAULT NULL COMMENT '类别id',
  `goods_name` varchar(100) DEFAULT NULL COMMENT '商品名字',
  `goods_PRICE` float(10,2) DEFAULT 0 COMMENT '商品价格',
  `goods_status` int(1) DEFAULT 1 COMMENT '商品状态 1为上架 0为下架 默认上架',
  `goods_desc` varchar(500) DEFAULT NULL COMMENT '商品描述',
  `goods_heat` int DEFAULT 0 COMMENT '商品热度',
  `goods_path` varchar(200) DEFAULT NULL COMMENT '商品图片',
  `is_discount` int DEFAULT 0 COMMENT '是否打折 1为是 0为否 默认0',
  `goods_discount` float(10,2) DEFAULT 1 COMMENT '折扣 默认为1 不打折',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_shop` (`shop_id`),
  KEY `idx_class` (`class_id`),
  KEY `idx_status` (`goods_status`),
  KEY `idx_discount` (`is_discount`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

create TABLE `goodsclass` (
  `id` varchar(36) NOT NULL COMMENT '菜单类别id',
  `shop_id` varchar(36) DEFAULT NULL COMMENT '店铺id',
  `class_name` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `class_status` int(1) DEFAULT 1 COMMENT '类别状态 1为使用 0为不使用 默认1',
  `class_num` int DEFAULT NULL COMMENT '类别顺序',
  `class_desc` varchar(500) DEFAULT NULL COMMENT '类别描述',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_shop` (`shop_id`),
  KEY `idx_status` (`class_status`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单类别表';

create TABLE `activity` (
  `id` varchar(36) NOT NULL COMMENT '活动id',
  `shop_id` varchar(36) DEFAULT NULL COMMENT '店铺id',
  `activity_type` int(1) DEFAULT 0 COMMENT '活动类型 0为平台活动 1位商铺活动',
  `activity_title` varchar(50) DEFAULT NULL COMMENT '活动标题',
  `activity_status` int(1) DEFAULT 0 COMMENT '活动状态 1为上线 0位下线',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `activity_desc` varchar(500) DEFAULT NULL COMMENT '活动描述',
  `activity_path` varchar(200) DEFAULT NULL COMMENT '活动图片',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_shop` (`shop_id`),
  KEY `idx_type` (`activity_type`),
  KEY `idx_status` (`activity_status`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

create TABLE `admin` (
  `id` varchar(36) NOT NULL COMMENT '管理员id',
  `openid` varchar(36) DEFAULT NULL COMMENT '用户的唯一标识',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `admin_password` varchar(50) DEFAULT NULL COMMENT '管理员登录密码',
  `admin_phone` varchar(50) DEFAULT NULL COMMENT '管理员电话',
  `admin_status` int(1) DEFAULT 1 COMMENT '管理员状态 0为禁用 1为正常',
  `admin_desc` varchar(500) DEFAULT NULL COMMENT '管理员描述',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`admin_status`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

create TABLE `user` (
  `id` varchar(36) NOT NULL COMMENT '用户id',
  `login_user` varchar(36) DEFAULT NULL COMMENT '登录名',
  `login_password` varchar(36) DEFAULT NULL COMMENT '登录密码',
  `role_id` SMALLINT(6) DEFAULT NULL COMMENT '角色',
  `openid` varchar(36) DEFAULT NULL COMMENT '用户的唯一标识',
  `nickname` varchar(36) DEFAULT NULL COMMENT '用户昵称',
  `sex` SMALLINT(6) DEFAULT NULL COMMENT '用户性别, 1为男性 2为女性 0为未知',
  `province` varchar(36) DEFAULT NULL COMMENT '省份',
  `city` varchar(36) DEFAULT NULL COMMENT '城市',
  `country` varchar(36) DEFAULT NULL COMMENT '国家 CN为中国',
  `headimgurl` varchar(36) DEFAULT NULL COMMENT '用户头像',
  `privilege` varchar(500) DEFAULT NULL COMMENT '用户特权信息 json数组',
  `unionid` varchar(36) DEFAULT NULL COMMENT 'Unionid机制',
  `address_id` varchar(36) DEFAULT NULL COMMENT '地址id//暂时不用',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `user_phone` varchar(50) DEFAULT NULL COMMENT '用户电话',
  `user_address` varchar(200) DEFAULT NULL COMMENT '用户地址',
  `user_status` int(1) DEFAULT 1 COMMENT '用户状态 0为禁用 1为正常',
  `user_desc` varchar(500) DEFAULT NULL COMMENT '用户描述',
  `last_login_ip` varchar(36) DEFAULT NULL COMMENT '最后登录ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_openid` (`openid`),
  KEY `idx_unionid` (`unionid`),
  KEY `idx_address_id` (`address_id`),
  KEY `idx_login_user` (`login_user`),
  KEY `idx_status` (`user_status`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

create TABLE `horseman` (
  `id` varchar(36) NOT NULL COMMENT '骑手id',
  `openid` varchar(36) NOT NULL COMMENT '用户的唯一标识',
  `user_id` varchar(36) NOT NULL COMMENT '用户id',
  `man_name` varchar(50) DEFAULT NULL COMMENT '骑手名字',
  `man_status` int(1) DEFAULT 0 COMMENT '骑手状态 0为休息 1为工作',
  `man_phone` varchar(50) DEFAULT NULL COMMENT '骑手电话',
  `takeout_num` int DEFAULT 0 COMMENT '接单数量',
  `finish_num` int DEFAULT 0 COMMENT '完成订单数量',
  `man_takemoney` float(10,2) DEFAULT 0 COMMENT '接单金额',
  `man_finishmoney` float(10,2) DEFAULT 0 COMMENT '完成订单金额',
  `man_desc` datetime DEFAULT NULL COMMENT '骑手描述',
  `man_user` varchar(36) NOT NULL COMMENT '登录用户名',
  `man_password` varchar(36) NOT NULL COMMENT '登录密码',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_status` (`man_status`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='骑手表';

create TABLE `order` (
  `id` varchar(36) NOT NULL COMMENT '订单id',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
  `man_id` varchar(36) DEFAULT NULL COMMENT '骑手id',
  `address_id` varchar(36) DEFAULT NULL COMMENT '地址id',
  `order_name` varchar(100) DEFAULT NULL COMMENT '订单TITLE',
  `place_time` datetime DEFAULT NULL COMMENT '下单时间',
  `taking_time` datetime DEFAULT NULL COMMENT '接单时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `order_type` int(1) DEFAULT 0 COMMENT '订单类型 1为加急 0为一般',
  `order_status` int(1) DEFAULT 0 COMMENT '订单状态 0为 待接单 1为已接单，正在派送 2位已送达',
  `receiver_info` varchar(50) DEFAULT NULL COMMENT '收货人信息',
  `receiver_phone` varchar(50) DEFAULT NULL COMMENT '收货人电话',
  `order_address` varchar(200) DEFAULT NULL COMMENT '收货地址',
  `order_total` float(10,2) DEFAULT 0 COMMENT '订单金额',
  `real_total` float(10,2) DEFAULT 0 COMMENT '实际金额',
  `pay_way` int(1) DEFAULT 0 COMMENT '支付方式 0为微信 1为支付宝 2为货到付款',
  `order_isdiscount` int(1) DEFAULT 0 COMMENT '是否打折 1为是 0为否',
  `order_discount` float(10,2) DEFAULT 0 COMMENT '折扣',
  `send_cost` float(10,2) DEFAULT 0 COMMENT '配送费',
  `box_cost` float(10,2) DEFAULT 0 COMMENT '餐盒费',
  `order_desc` varchar(500) DEFAULT NULL COMMENT '备注',
  `order_text` varchar(500) DEFAULT NULL COMMENT '订单说明',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_user` (`user_id`),
  KEY `idx_man` (`man_id`),
  KEY `idx_address` (`address_id`),
  KEY `idx_type` (`order_type`),
  KEY `idx_status` (`order_status`),
  KEY `idx_pay_way` (`pay_way`),
  KEY `idx_isdiscount` (`order_isdiscount`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

create TABLE `orderitem` (
  `id` varchar(36) NOT NULL COMMENT '订单详情id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '订单id',
  `goods_id` varchar(36) DEFAULT NULL COMMENT '商品id',
  `goods_num` int DEFAULT 0 COMMENT '商品数量',
  `goods_price` float(10,2) DEFAULT 0 COMMENT '商品实际价格',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_order` (`order_id`),
  KEY `idx_goods` (`goods_id`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';


create TABLE `address` (
  `id` varchar(36) NOT NULL COMMENT '地址id',
  `user_id` varchar(36) DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(36) DEFAULT NULL COMMENT '订单id',
  `receiver_name` varchar(36) DEFAULT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(36) DEFAULT NULL COMMENT '收货人电话',
  `address_province` varchar(36) DEFAULT NULL COMMENT '省',
  `address_city` varchar(36) DEFAULT NULL COMMENT '市',
  `address_xian` varchar(36) DEFAULT NULL COMMENT '区/县',
  `addresss_treet` varchar(36) DEFAULT NULL COMMENT '街道',
  `addresss_detail` varchar(36) DEFAULT NULL COMMENT '详细',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `creator_id` varchar(36) DEFAULT NULL COMMENT '创建人id',
  `is_deleted` tinyint DEFAULT NULL COMMENT '假删除 0未删除 1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),  
  KEY `idx_user` (`user_id`),
  KEY `idx_order` (`order_id`),
  KEY `idx_creator_id` (`creator_id`),
  KEY `idx_deleted` (`is_deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='地址表';












