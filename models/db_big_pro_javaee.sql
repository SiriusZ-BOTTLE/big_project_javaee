/*
 Navicat Premium Data Transfer

 Source Server         : ConnectionTo_MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : db_big_pro_javaee

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 10/06/2020 19:51:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `plate_id` int(11) NULL DEFAULT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `article_title` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `article_content` varchar(3000) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `blog_id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `blog_title` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `blog_content` varchar(1500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`blog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '博客' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for commentx
-- ----------------------------
DROP TABLE IF EXISTS `commentx`;
CREATE TABLE `commentx`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `object_id` int(11) NULL DEFAULT NULL,
  `comment_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `comment_content` varchar(1500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `creator_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `reply_id` int(11) NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '回复/评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of commentx
-- ----------------------------
INSERT INTO `commentx` VALUES (8, 3, 'post', '有人吗, 求大佬!', 'SiriusZ', NULL, '2020-06-07 17:20:16');
INSERT INTO `commentx` VALUES (9, 3, 'post', '别想了, 这个论坛就咱俩人', 'SilkWorm', NULL, '2020-06-07 18:48:52');
INSERT INTO `commentx` VALUES (10, 1, 'post', '我赞同, 顶!', 'SilkWorm', NULL, '2020-06-07 19:07:35');
INSERT INTO `commentx` VALUES (11, 3, 'post', '厦提陌梯筛诗新杈畅枢般辅渡唁亦罢两顺竣暂渔农芋霎散怕熬庵聂谍概知有钥恢抖焦畏右毫仪耘蠢筒畴靠弃墩店蚀纸憔凑畜申泰牲根璧许筋铐醒钧哆超等括还瞒雹律殉逞耸遵跳先篱刻馒底壮淑禁纱铛羊长子献锤蚁纳琳', 'SilkWorm', NULL, '2020-06-07 19:12:14');
INSERT INTO `commentx` VALUES (12, 3, 'post', '楼上发的什么乱码?', 'SiriusZ', NULL, '2020-06-07 19:12:57');
INSERT INTO `commentx` VALUES (13, 3, 'post', '一个人都没的吗?', 'SiriusZ', NULL, '2020-06-07 19:46:09');
INSERT INTO `commentx` VALUES (17, 7, 'post', '测试用户发帖: 更新帖子的最后更新日期', 'TestUser', NULL, '2020-06-09 11:20:59');
INSERT INTO `commentx` VALUES (18, 3, 'post', '测试用户发帖: 更新帖子的最后更新日期', 'TestUser', NULL, '2020-06-09 11:21:08');
INSERT INTO `commentx` VALUES (19, 1, 'post', '测试用户发帖: 更新帖子的最后更新日期', 'TestUser', NULL, '2020-06-09 11:21:23');
INSERT INTO `commentx` VALUES (22, 40, 'post', '你又搞啥呀', 'SiriusZ', NULL, '2020-06-09 21:12:06');
INSERT INTO `commentx` VALUES (26, 1, 'post', '时区测试', 'SiriusZ', NULL, '2020-06-10 11:50:57');

-- ----------------------------
-- Table structure for groupx
-- ----------------------------
DROP TABLE IF EXISTS `groupx`;
CREATE TABLE `groupx`  (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `owner_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `group_description` varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `group_cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '群组' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image`  (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `object_id` int(11) NULL DEFAULT NULL,
  `image_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `image_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`image_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '图片实体' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES (1, 1, 'post', '5d875453459b432fbc7965739add1c74.png');
INSERT INTO `image` VALUES (2, 1, 'post', '497ab0e27f6e4bbe863faf77ca790fb2.png');
INSERT INTO `image` VALUES (3, 2, 'post', '0b5fd086d99841d3ad4e66fea9262097.jpg');
INSERT INTO `image` VALUES (4, 3, 'post', 'a0876896cf614b1a914b1149f9909c99.jpg');
INSERT INTO `image` VALUES (5, 5, 'post', 'b017e04584414db38807bb932a541e65.png');
INSERT INTO `image` VALUES (6, 6, 'post', '8982c3fe7acb44e6af3a6526099dcd0d.png');
INSERT INTO `image` VALUES (7, 7, 'post', '6a7c486a549f4afbb34cc15b451f4253.png');
INSERT INTO `image` VALUES (8, 39, 'post', '3b85e061f8934b379eab393b0d666e16.png');
INSERT INTO `image` VALUES (9, 40, 'post', 'dc4decf746414241bf412a8c4aa4fff1.png');

-- ----------------------------
-- Table structure for map_user_article_collection
-- ----------------------------
DROP TABLE IF EXISTS `map_user_article_collection`;
CREATE TABLE `map_user_article_collection`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `article_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_文章_收藏\r\n用户收藏的文章' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_blog_collection
-- ----------------------------
DROP TABLE IF EXISTS `map_user_blog_collection`;
CREATE TABLE `map_user_blog_collection`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `blog_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_博客_收藏\r\n用户收藏的博客' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_group_member
-- ----------------------------
DROP TABLE IF EXISTS `map_user_group_member`;
CREATE TABLE `map_user_group_member`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `group_id` int(11) NOT NULL,
  `is_admin` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_群组_成员\r\n用户与群组间的多对多关系, 分为普通成员和管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_object_liking
-- ----------------------------
DROP TABLE IF EXISTS `map_user_object_liking`;
CREATE TABLE `map_user_object_liking`  (
  `object_id` int(11) NOT NULL,
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`object_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_对象_点赞\r\n用户对博客, 帖子, 文章等基础对象的点赞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_plate_admin
-- ----------------------------
DROP TABLE IF EXISTS `map_user_plate_admin`;
CREATE TABLE `map_user_plate_admin`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `plate_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `plate_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_板块_管理员\r\n板块没有普通成员, 但是板块可以设置管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_plate_collection
-- ----------------------------
DROP TABLE IF EXISTS `map_user_plate_collection`;
CREATE TABLE `map_user_plate_collection`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `plate_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `plate_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_板块_收藏\r\n这个表存储用户收藏的板块' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_plate_collection
-- ----------------------------
INSERT INTO `map_user_plate_collection` VALUES ('SilkWorm', 20);
INSERT INTO `map_user_plate_collection` VALUES ('SilkWorm', 21);
INSERT INTO `map_user_plate_collection` VALUES ('SiriusZ', 17);
INSERT INTO `map_user_plate_collection` VALUES ('SiriusZ', 18);
INSERT INTO `map_user_plate_collection` VALUES ('SiriusZ', 20);
INSERT INTO `map_user_plate_collection` VALUES ('TestUser', 17);
INSERT INTO `map_user_plate_collection` VALUES ('TestUser', 18);
INSERT INTO `map_user_plate_collection` VALUES ('TestUser', 19);
INSERT INTO `map_user_plate_collection` VALUES ('TestUser', 20);

-- ----------------------------
-- Table structure for map_user_post_collection
-- ----------------------------
DROP TABLE IF EXISTS `map_user_post_collection`;
CREATE TABLE `map_user_post_collection`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `post_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_帖子_收藏\r\n用户收藏的帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_post_collection
-- ----------------------------
INSERT INTO `map_user_post_collection` VALUES ('SiriusZ', 1);
INSERT INTO `map_user_post_collection` VALUES ('TestUser', 1);
INSERT INTO `map_user_post_collection` VALUES ('TestUser', 2);
INSERT INTO `map_user_post_collection` VALUES ('SiriusZ', 3);
INSERT INTO `map_user_post_collection` VALUES ('TestUser', 3);
INSERT INTO `map_user_post_collection` VALUES ('SiriusZ', 7);
INSERT INTO `map_user_post_collection` VALUES ('TestUser', 7);
INSERT INTO `map_user_post_collection` VALUES ('SiriusZ', 37);

-- ----------------------------
-- Table structure for map_user_user_following
-- ----------------------------
DROP TABLE IF EXISTS `map_user_user_following`;
CREATE TABLE `map_user_user_following`  (
  `user_id_0` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_id_1` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`user_id_0`, `user_id_1`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '映射_用户_用户_关注\r\n用户之间可以单向关注, 当两个用户之间存在两个相反的单向关注时, 称他们互相关注' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `message_id` int(11) NOT NULL,
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `target_id` int(11) NULL DEFAULT NULL,
  `message_title` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `message_type` varchar(5) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `message_content` varchar(300) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `is_read` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '消息\r\n用户可以收到系统发出的消息, 当有新的回复或者新的评论时, 系统会发出消息给相关用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for plate
-- ----------------------------
DROP TABLE IF EXISTS `plate`;
CREATE TABLE `plate`  (
  `plate_id` int(11) NOT NULL AUTO_INCREMENT,
  `plate_name` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `owner_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `plate_description` varchar(600) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `plate_cover_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `activated` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`plate_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '板块' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plate
-- ----------------------------
INSERT INTO `plate` VALUES (17, '太空工程师', 'SiriusZ', '太空工程师游戏板块', '4653ceb4ce0040e09d7073c145d6e11e.jpg', '2020-05-25 21:11:32', 1);
INSERT INTO `plate` VALUES (18, '实验化学', 'SiriusZ', '这个板块中收录了各类实验化学有关帖子', 'eb19fce5976749acb5359d286ecd62eb.jpg', '2020-05-25 21:19:47', 1);
INSERT INTO `plate` VALUES (19, '生活化学', 'SiriusZ', '收录与生活中的化学有关的帖子', '18b81da6fd244d38aca242991b6e347c.jpg', '2020-05-25 21:20:30', 1);
INSERT INTO `plate` VALUES (20, 'JavaEE', 'SiriusZ', 'JavaEE', '72db8c1b425544df9227a3a21cbbac35.png', '2020-05-25 21:26:16', 1);
INSERT INTO `plate` VALUES (21, 'STPC论坛官方板块', 'SiriusZ', 'STPC论坛官方板块\n有什么疑问, 欢迎提问', 'e696e1abef9d44338b565acbd24d9fa8.png', '2020-06-09 20:57:12', 1);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `creator_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `plate_id` int(11) NULL DEFAULT NULL,
  `group_id` int(11) NULL DEFAULT NULL,
  `post_title` varchar(150) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `post_content` varchar(1500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `post_images_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`post_id`) USING BTREE,
  FULLTEXT INDEX `title_content_index`(`post_title`, `post_content`) WITH PARSER `ngram`
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '帖子' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, 'SiriusZ', 21, NULL, '关于论坛管理', '蚂疑饵琐丈剔杉么亡难加康搓鲫甜脏蜈阀丸呵蝠西埠辆犀戴贾筑滞能孵尺挚堰浴庆臊何轨唾催七涯茴凹其铸辖桩征咙雏嫩峻憨整蔽朱桨氮睡师策众撞贬原\r\n成河鸟丹窗城滑鼎糙锯玷母锈破捡涤向蔚灌兆夜户\r\n孩系蓄惋浑酷春展钠盛役赚涣橘腊侠行肠线注案邀驰锻夕翠养揖沿仆青赞脚牺详咬纲逆伐蟋睁堕罪徙忠粹背壁饰薇础坞聋蒿求荣浆皱堤排过英煮携柑钓矫间宽溅奶纯慕满劝嘱蛀泥趁擦熙扫辈埃曙宝戚已蝎败扩魄秋倍兔蒙黔颗标货撰取实吓控鬼冗瘸旷楔云舟股裹匾捍\r\n厦提陌梯筛诗新杈畅枢般辅渡唁亦罢两顺竣暂渔农芋霎散怕熬庵聂谍概知有钥恢抖焦畏右毫仪耘蠢筒畴靠弃墩店蚀纸憔凑畜申泰牲根璧许筋铐醒钧哆超等括还瞒雹律殉逞耸遵跳先篱刻馒底壮淑禁纱铛羊长子献锤蚁纳琳', NULL, '2020-05-29 21:03:00', '2020-06-10 11:50:57');
INSERT INTO `post` VALUES (2, 'SiriusZ', NULL, NULL, 'xxxxxxx', '蚂疑饵琐丈剔杉么亡难加康搓鲫甜脏蜈阀丸呵蝠西埠辆犀戴贾筑滞能孵尺挚堰浴庆臊何轨唾催七涯茴凹其铸辖桩征咙雏嫩峻憨整蔽朱桨氮睡师策众撞贬原\r\n成河鸟丹窗城滑鼎糙锯玷母锈破捡涤向蔚灌兆夜户\r\n孩系蓄惋浑酷春展钠盛役赚涣橘腊侠行肠线注案邀驰锻夕翠养揖沿仆青赞脚牺详咬纲逆伐蟋睁堕罪徙忠粹背壁饰薇础坞聋蒿求荣浆皱堤排过英煮携柑钓矫间宽溅奶纯慕满劝嘱蛀泥趁擦熙扫辈埃曙宝戚已蝎败扩魄秋倍兔蒙黔颗标货撰取实吓控鬼冗瘸旷楔云舟股裹匾捍\r\n厦提陌梯筛诗新杈畅枢般辅渡唁亦罢两顺竣暂渔农芋霎散怕熬庵聂谍概知有钥恢抖焦畏右毫仪耘蠢筒畴靠弃墩店蚀纸憔凑畜申泰牲根璧许筋铐醒钧哆超等括还瞒雹律殉逞耸遵跳先篱刻馒底壮淑禁纱铛羊长子献锤蚁纳琳', NULL, '2020-05-29 21:14:15', '2020-05-29 21:14:15');
INSERT INTO `post` VALUES (3, 'SiriusZ', 18, NULL, '各位大佬问一个化学问题', '蚂疑饵琐丈剔杉么亡难加康搓鲫甜脏蜈阀丸呵蝠西埠辆犀戴贾筑滞能孵尺挚堰浴庆臊何轨唾催七涯茴凹其铸辖桩征咙雏嫩峻憨整蔽朱桨氮睡师策众撞贬原\r\n成河鸟丹窗城滑鼎糙锯玷母锈破捡涤向蔚灌兆夜户\r\n孩系蓄惋浑酷春展钠盛役赚涣橘腊侠行肠线注案邀驰锻夕翠养揖沿仆青赞脚牺详咬纲逆伐蟋睁堕罪徙忠粹背壁饰薇础坞聋蒿求荣浆皱堤排过英煮携柑钓矫间宽溅奶纯慕满劝嘱蛀泥趁擦熙扫辈埃曙宝戚已蝎败扩魄秋倍兔蒙黔颗标货撰取实吓控鬼冗瘸旷楔云舟股裹匾捍\r\n厦提陌梯筛诗新杈畅枢般辅渡唁亦罢两顺竣暂渔农芋霎散怕熬庵聂谍概知有钥恢抖焦畏右毫仪耘蠢筒畴靠弃墩店蚀纸憔凑畜申泰牲根璧许筋铐醒钧哆超等括还瞒雹律殉逞耸遵跳先篱刻馒底壮淑禁纱铛羊长子献锤蚁纳琳', NULL, '2020-06-05 10:16:42', '2020-06-09 11:21:08');
INSERT INTO `post` VALUES (7, 'SiriusZ', 17, NULL, '测试用贴', '啦啦啦啦啦啦啦啦啦啦\n啦啦啦啦啦啦啦啦啦啦\n啦啦啦啦啦啦啦啦啦啦\n啦啦啦啦啦啦啦啦啦啦\n啦啦啦啦啦啦啦啦啦啦', NULL, '2020-06-08 22:11:28', '2020-06-09 11:20:59');
INSERT INTO `post` VALUES (10, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:12:50', '2020-06-09 19:12:50');
INSERT INTO `post` VALUES (11, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:04', '2020-06-09 19:13:04');
INSERT INTO `post` VALUES (12, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:04', '2020-06-09 19:13:04');
INSERT INTO `post` VALUES (13, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:05', '2020-06-09 19:13:05');
INSERT INTO `post` VALUES (14, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:05', '2020-06-09 19:13:05');
INSERT INTO `post` VALUES (15, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:05', '2020-06-09 19:13:05');
INSERT INTO `post` VALUES (16, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:06', '2020-06-09 19:13:06');
INSERT INTO `post` VALUES (17, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:06', '2020-06-09 19:13:06');
INSERT INTO `post` VALUES (18, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:06', '2020-06-09 19:13:06');
INSERT INTO `post` VALUES (19, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:06', '2020-06-09 19:13:06');
INSERT INTO `post` VALUES (20, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:07', '2020-06-09 19:13:07');
INSERT INTO `post` VALUES (21, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:07', '2020-06-09 19:13:07');
INSERT INTO `post` VALUES (22, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:07', '2020-06-09 19:13:07');
INSERT INTO `post` VALUES (23, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:08', '2020-06-09 19:13:08');
INSERT INTO `post` VALUES (24, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:08', '2020-06-09 19:13:08');
INSERT INTO `post` VALUES (25, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:08', '2020-06-09 19:13:08');
INSERT INTO `post` VALUES (26, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:08', '2020-06-09 19:13:08');
INSERT INTO `post` VALUES (27, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:09', '2020-06-09 19:13:09');
INSERT INTO `post` VALUES (28, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:09', '2020-06-09 19:13:09');
INSERT INTO `post` VALUES (29, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:17', '2020-06-09 19:13:17');
INSERT INTO `post` VALUES (30, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:17', '2020-06-09 19:13:17');
INSERT INTO `post` VALUES (31, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:17', '2020-06-09 19:13:17');
INSERT INTO `post` VALUES (32, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:18', '2020-06-09 19:13:18');
INSERT INTO `post` VALUES (33, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:18', '2020-06-09 19:13:18');
INSERT INTO `post` VALUES (34, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:18', '2020-06-09 19:13:18');
INSERT INTO `post` VALUES (35, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:18', '2020-06-09 19:13:18');
INSERT INTO `post` VALUES (36, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:19', '2020-06-09 19:13:19');
INSERT INTO `post` VALUES (37, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:19', '2020-06-09 19:13:19');
INSERT INTO `post` VALUES (38, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 19:13:19', '2020-06-09 19:13:19');
INSERT INTO `post` VALUES (40, 'SilkWorm', 21, NULL, '刚才测试帖子刷屏了, 问题不大', '这条帖子存在的意义就是为了让千篇一律的页面显得不那么枯燥(雾\n这条放在最前面!!!!!!\n(来张LOGO图)', NULL, '2020-06-09 21:02:24', '2020-06-09 21:12:06');
INSERT INTO `post` VALUES (41, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 21:56:51', '2020-06-09 21:56:51');
INSERT INTO `post` VALUES (42, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 22:00:02', '2020-06-09 22:00:02');
INSERT INTO `post` VALUES (43, 'SilkWorm', NULL, NULL, '测试用帖子, 由sql语句生成', '测试用文本', NULL, '2020-06-09 22:44:58', '2020-06-09 22:44:58');

-- ----------------------------
-- Table structure for userx
-- ----------------------------
DROP TABLE IF EXISTS `userx`;
CREATE TABLE `userx`  (
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_name` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `is_admin` tinyint(1) NULL DEFAULT NULL,
  `user_avatar_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_email` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `user_signature` varchar(90) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `register_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userx
-- ----------------------------
INSERT INTO `userx` VALUES ('SilkWorm', '张四', 'pwd123456', NULL, NULL, NULL, NULL, 'M', NULL, '2020-06-05 18:45:01');
INSERT INTO `userx` VALUES ('SiriusZ', '张三', 'pwd123456', NULL, NULL, 'xxxxx@xxxxx.xxxxx', 'xxxxxxxxxxx', 'S', NULL, '2020-06-05 18:46:10');
INSERT INTO `userx` VALUES ('TestUser', '测试用户', 'pwd123456', NULL, NULL, NULL, NULL, 'M', NULL, '2020-06-09 11:15:28');
INSERT INTO `userx` VALUES ('TestUser2', '测试用户2', 'pwd123456', NULL, NULL, NULL, '12345678901', 'M', NULL, '2020-06-09 11:16:59');
INSERT INTO `userx` VALUES ('TestUser3', '测试用户3', 'pwd123456', NULL, NULL, NULL, NULL, 'M', NULL, '2020-06-10 18:53:08');
INSERT INTO `userx` VALUES ('user-000', 'user-000', 'pwd123456', NULL, NULL, NULL, NULL, 'M', NULL, '2020-05-25 19:40:42');

SET FOREIGN_KEY_CHECKS = 1;
