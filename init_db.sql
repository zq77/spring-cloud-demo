create table `product_category` (
    `id` int(20) not null auto_increment,
    `name` varchar(64) not null comment '类目名字',
    `type` int not null comment '类目编号',
    `deleted` tinyint not null default 0,
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`),
    unique key `uqe_category_type` (`type`)
);
INSERT INTO `product_category` (`id`, `name`, `type`)
VALUES
	(1,'热榜',1),
	(2,'好吃的',2);


create table `product` (
    `id` int(20) not null auto_increment,
    `name` varchar(64) not null comment '商品名称',
    `price` decimal(8,2) not null comment '单价',
    `stock` int not null comment '库存',
    `description` varchar(64) comment '描述',
    `icon` varchar(512) comment '小图',
    `status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
    `category_type` int not null comment '类目编号',
    `deleted` tinyint not null default 0,
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
);
INSERT INTO `product` (`name`, `price`, `stock`, `description`, `icon`, `status`, `category_type`)
VALUES
	('皮蛋粥',0.01,39,'好吃的皮蛋粥','//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg',0,1),
	('慕斯蛋糕',10.90,200,'美味爽口','//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg',1,1),
	('蜜汁鸡翅',0.02,982,'好吃','//fuss1product0.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg',0,1);
