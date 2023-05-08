INSERT INTO `product_category` (`id`, `name`, `type`)
VALUES
	(1,'热榜',1),
	(2,'好吃的',2);


INSERT INTO `product` (`name`, `price`, `stock`, `description`, `icon`, `status`, `category_type`)
VALUES
	('皮蛋粥',0.01,39,'好吃的皮蛋粥','//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg',0,1),
	('慕斯蛋糕',10.90,200,'美味爽口','//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg',1,1),
	('蜜汁鸡翅',0.02,982,'好吃','//fuss1product0.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg',0,1);


INSERT INTO `user_info` (`id`, `openid`, `role`)
VALUES
	(1,'xxx',1),
	(2,'yyy',2);
