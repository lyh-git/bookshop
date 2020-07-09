/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-07-09 15:43:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'hua', '666666', '2020-06-10');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `author` varchar(100) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `price` double(100,3) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `disc` varchar(100) DEFAULT '无',
  `discount` double(11,2) DEFAULT '1.00',
  `store` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `create_time` varchar(100) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('21', 'java', '远华', '远华出版社       ', '10.000', '2', '无', '1.00', '78', '1', '2020-07-04');
INSERT INTO `book` VALUES ('23', '人月神话', '云华', '远华出版社      ', '100.000', '2', '无', '0.50', '80', '1', '2020-07-04');
INSERT INTO `book` VALUES ('26', '人性的弱点', '华哥', '圆滑出版社         ', '50.000', '1', '无', '1.00', '99', '1', '2020-07-05');
INSERT INTO `book` VALUES ('29', '围城', '我', '远华出版社 ', '20.000', '1', '有', '0.90', '16', '1', '2020-07-06');
INSERT INTO `book` VALUES ('30', '活着', '你', '国家出版社 ', '30.000', '1', '无', '1.00', '30', '1', '2020-07-08');

-- ----------------------------
-- Table structure for `booklist`
-- ----------------------------
DROP TABLE IF EXISTS `booklist`;
CREATE TABLE `booklist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `publicer` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booklist
-- ----------------------------
INSERT INTO `booklist` VALUES ('41', '围城', 'https://book.douban.com/subject/1008145/', '钱锺书 / 人民文学出版社 / 1991-2 / 19.00', '8.9', '(373035人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('42', '围城', 'https://book.douban.com/subject/11524204/', '钱钟书 / 人民文学出版社 / 1991-2-1 / 39.00元', '9.3', '(52105人评价)', '栩栩如生的世井百态图，人生的酸甜苦辣千般滋味均在其中得到了淋漓尽致的体现。钱钟书先生将自己的语言天才并入极其渊博的知识，再添加上一些讽刺主义的...');
INSERT INTO `booklist` VALUES ('43', '围城', 'https://book.douban.com/subject/1069848/', '钱钟书 / 生活·读书·新知三联书店 / 2002-5 / 18.60元', '9.0', '(27902人评价)', '姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百...');
INSERT INTO `booklist` VALUES ('44', '围城', 'https://book.douban.com/subject/1855364/', '钱锺书 / 人民文学出版社 / 2007-8 / 19.00元', '9.2', '(23992人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('45', '围城', 'https://book.douban.com/subject/24745649/', '钱钟书 / 人民文学出版社 / 2013-6 / 28.00', '9.2', '(11914人评价)', '来横贯常销畅销小说之首。《围城》是钱钟书唯一的一部长篇小说，堪称中国现当代长篇小说的经典。小说塑造了抗战开初一类知识分子的群像，生动反映了在国...');
INSERT INTO `booklist` VALUES ('46', '围城', 'https://book.douban.com/subject/1464989/', '钱钟书 / 人民文学出版社 / 1985 / 1.70元', '9.1', '(7465人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('47', '《围城》汇校本', 'https://book.douban.com/subject/3011470/', '錢鍾書、胥智芬滙校 / 四川文藝岀版社 / 1992 / 6.20元', '9.1', '(162人评价)', '那些吃饭斗嘴、争风吃醋，调侃意味是最浓了；而当我们看到三闾大学，辛辣的讽刺味则突出些；小说后半，方鸿渐回到上海，往日的朋友或冤家都已星散，他的...');
INSERT INTO `booklist` VALUES ('48', '围城', 'https://book.douban.com/subject/1039427/', '钱钟书 / 人民文学出版社 / 2001-01 / 15.20', '9.0', '(4629人评价)', '长篇小说《围城》和短篇小说集《人·兽·鬼》合为一书出版。');
INSERT INTO `booklist` VALUES ('49', '围城 / 人·兽·鬼', 'https://book.douban.com/subject/4054726/', '钱锺书 / 生活·读书·新知三联书店 / 2009-11 / 29.50元', '9.3', '(1104人评价)', '七年在上海初版，一九四八年再版，一九四九年三版，以后国内没有重印过。偶然碰见它的新版，那都是香港的“盗印”本。没有看到台湾的“盗印”本，据说在...');
INSERT INTO `booklist` VALUES ('50', '围城', 'https://book.douban.com/subject/3523063/', '钱钟书 / 人民文学出版社 / 1991-2 / 20.00元', '9.1', '(1516人评价)', '书仅有的一部长篇小说，堪称中国现当代长篇小说的经典。小说塑造了抗战开初一类知识分子的群像，生动反映了在国家特定时期，特殊人群的行为操守、以及困...');
INSERT INTO `booklist` VALUES ('51', '围城', 'https://book.douban.com/subject/27070488/', '钱锺书 / 人民文学出版社 / 2017-6 / 36.00', '9.3', '(4473人评价)', '姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百...');
INSERT INTO `booklist` VALUES ('52', '围城', 'https://book.douban.com/subject/1468602/', '钱钟书 / 人民文学出版社 / 2000-7 / 16.00元', '9.2', '(3718人评价)', '读丛书中的一册，书中以教育部全国高等学校中文学科教学指导委员会指定书目为依据，收录了当代著名作家钱钟书先生的长篇小说《围城》。\n    本书具...');
INSERT INTO `booklist` VALUES ('53', 'Qian Zhongshu', 'https://book.douban.com/subject/1712544/', '北京科海电子出版社 / 1991 / 16', '8.7', '(少于10人评价)', '国“个体家庭”的选择》是《个体家庭iFamily：当代中国城市现代化进程中的个体、家庭和国家》的再版。中国在现代化进程中，家庭主义逐步被个体化...');
INSERT INTO `booklist` VALUES ('54', '围城', 'https://book.douban.com/subject/1011250/', '钱钟书 / 人民文学出版社 / 2003-01 / 16.80', '8.7', '(406人评价)', '编外》是一部80后作家所写的职场小说。小说记述了一个大学毕业生进入一个行政事业单位之后的种种经历，以细腻、生动和不乏黑色幽默的笔触揭示了“单位...');
INSERT INTO `booklist` VALUES ('55', '谁在你家', 'https://book.douban.com/subject/34446478/', '沈奕斐 / 上海三联书店 / 2019-6 / 68元', '9.1', '(57人评价)', '的法国邮船白拉日隆子爵号在上海靠了岸。小说的主人公方鸿渐一踏上阔别四年的故土，就接二连三地陷入了“围城”。\n方鸿渐旅欧回国，正是一九三七年夏天...');
INSERT INTO `booklist` VALUES ('56', '编外', 'https://book.douban.com/subject/21612247/', '史啸思 / 天津人民出版社 / 2013-3 / 28.80元', '9.2', '(少于10人评价)', '版)显示给我们一个真正的聪明人是怎样看人生，又怎样用所有作家都必得使用的文字来表述自己的“观”和“感”的。小说原来也是可以这样写的，小说家的高...');
INSERT INTO `booklist` VALUES ('57', '围城', 'https://book.douban.com/subject/1008145/', '钱锺书 / 人民文学出版社 / 1991-2 / 19.00', '8.9', '(373035人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('58', '围城', 'https://book.douban.com/subject/11524204/', '钱钟书 / 人民文学出版社 / 1991-2-1 / 39.00元', '9.3', '(52105人评价)', '栩栩如生的世井百态图，人生的酸甜苦辣千般滋味均在其中得到了淋漓尽致的体现。钱钟书先生将自己的语言天才并入极其渊博的知识，再添加上一些讽刺主义的...');
INSERT INTO `booklist` VALUES ('59', '围城', 'https://book.douban.com/subject/1069848/', '钱钟书 / 生活·读书·新知三联书店 / 2002-5 / 18.60元', '9.0', '(27902人评价)', '姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百...');
INSERT INTO `booklist` VALUES ('60', '围城', 'https://book.douban.com/subject/1855364/', '钱锺书 / 人民文学出版社 / 2007-8 / 19.00元', '9.2', '(23992人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('61', '围城', 'https://book.douban.com/subject/24745649/', '钱钟书 / 人民文学出版社 / 2013-6 / 28.00', '9.2', '(11914人评价)', '来横贯常销畅销小说之首。《围城》是钱钟书唯一的一部长篇小说，堪称中国现当代长篇小说的经典。小说塑造了抗战开初一类知识分子的群像，生动反映了在国...');
INSERT INTO `booklist` VALUES ('62', '围城', 'https://book.douban.com/subject/1464989/', '钱钟书 / 人民文学出版社 / 1985 / 1.70元', '9.1', '(7465人评价)', '书所著的长篇小说。第一版于1947年由上海晨光出版公司出版。1949年之后，由于政治等方面的原因，本书长期无法在中国大陆和台湾重印，仅在香港出...');
INSERT INTO `booklist` VALUES ('63', '《围城》汇校本', 'https://book.douban.com/subject/3011470/', '錢鍾書、胥智芬滙校 / 四川文藝岀版社 / 1992 / 6.20元', '9.1', '(162人评价)', '那些吃饭斗嘴、争风吃醋，调侃意味是最浓了；而当我们看到三闾大学，辛辣的讽刺味则突出些；小说后半，方鸿渐回到上海，往日的朋友或冤家都已星散，他的...');
INSERT INTO `booklist` VALUES ('64', '围城', 'https://book.douban.com/subject/1039427/', '钱钟书 / 人民文学出版社 / 2001-01 / 15.20', '9.0', '(4629人评价)', '长篇小说《围城》和短篇小说集《人·兽·鬼》合为一书出版。');
INSERT INTO `booklist` VALUES ('65', '围城 / 人·兽·鬼', 'https://book.douban.com/subject/4054726/', '钱锺书 / 生活·读书·新知三联书店 / 2009-11 / 29.50元', '9.3', '(1104人评价)', '七年在上海初版，一九四八年再版，一九四九年三版，以后国内没有重印过。偶然碰见它的新版，那都是香港的“盗印”本。没有看到台湾的“盗印”本，据说在...');
INSERT INTO `booklist` VALUES ('66', '围城', 'https://book.douban.com/subject/3523063/', '钱钟书 / 人民文学出版社 / 1991-2 / 20.00元', '9.1', '(1516人评价)', '书仅有的一部长篇小说，堪称中国现当代长篇小说的经典。小说塑造了抗战开初一类知识分子的群像，生动反映了在国家特定时期，特殊人群的行为操守、以及困...');
INSERT INTO `booklist` VALUES ('67', '围城', 'https://book.douban.com/subject/27070488/', '钱锺书 / 人民文学出版社 / 2017-6 / 36.00', '9.3', '(4473人评价)', '姻是围城，冲进去了，就被生存的种种烦愁包围。《围城》是钱钟书撰写的一部“新《儒林外史》”。钱钟书以他洒脱幽默的文笔，描写了一群知识分子的生活百...');
INSERT INTO `booklist` VALUES ('68', '围城', 'https://book.douban.com/subject/1468602/', '钱钟书 / 人民文学出版社 / 2000-7 / 16.00元', '9.2', '(3718人评价)', '读丛书中的一册，书中以教育部全国高等学校中文学科教学指导委员会指定书目为依据，收录了当代著名作家钱钟书先生的长篇小说《围城》。\n    本书具...');
INSERT INTO `booklist` VALUES ('69', 'Qian Zhongshu', 'https://book.douban.com/subject/1712544/', '北京科海电子出版社 / 1991 / 16', '8.7', '(少于10人评价)', '国“个体家庭”的选择》是《个体家庭iFamily：当代中国城市现代化进程中的个体、家庭和国家》的再版。中国在现代化进程中，家庭主义逐步被个体化...');
INSERT INTO `booklist` VALUES ('70', '围城', 'https://book.douban.com/subject/1011250/', '钱钟书 / 人民文学出版社 / 2003-01 / 16.80', '8.7', '(406人评价)', '编外》是一部80后作家所写的职场小说。小说记述了一个大学毕业生进入一个行政事业单位之后的种种经历，以细腻、生动和不乏黑色幽默的笔触揭示了“单位...');
INSERT INTO `booklist` VALUES ('71', '谁在你家', 'https://book.douban.com/subject/34446478/', '沈奕斐 / 上海三联书店 / 2019-6 / 68元', '9.1', '(57人评价)', '的法国邮船白拉日隆子爵号在上海靠了岸。小说的主人公方鸿渐一踏上阔别四年的故土，就接二连三地陷入了“围城”。\n方鸿渐旅欧回国，正是一九三七年夏天...');
INSERT INTO `booklist` VALUES ('72', '编外', 'https://book.douban.com/subject/21612247/', '史啸思 / 天津人民出版社 / 2013-3 / 28.80元', '9.2', '(少于10人评价)', '版)显示给我们一个真正的聪明人是怎样看人生，又怎样用所有作家都必得使用的文字来表述自己的“观”和“感”的。小说原来也是可以这样写的，小说家的高...');

-- ----------------------------
-- Table structure for `book_type`
-- ----------------------------
DROP TABLE IF EXISTS `book_type`;
CREATE TABLE `book_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book_type
-- ----------------------------
INSERT INTO `book_type` VALUES ('3', '计算机', '2020-07-06');
INSERT INTO `book_type` VALUES ('4', '历史', '2020-07-08');

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `book_num` int(11) DEFAULT NULL,
  `book_price` double(11,2) DEFAULT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for `idea`
-- ----------------------------
DROP TABLE IF EXISTS `idea`;
CREATE TABLE `idea` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `content` text,
  `send_time` varchar(100) DEFAULT NULL,
  `sender` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idea
-- ----------------------------
INSERT INTO `idea` VALUES ('5', '好评', '书本太好了,很满意的服务', '2020-07-06', 'hua');
INSERT INTO `idea` VALUES ('7', '范围分为', '访问违法未', '2020-07-07', 'hua');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_item_id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  `priceSum` double(11,2) NOT NULL,
  `status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('97', '0', '1', '784.99', '-1');
INSERT INTO `order` VALUES ('98', '0', '1', '609.95', '-1');
INSERT INTO `order` VALUES ('99', '0', '1', '966.00', '-1');
INSERT INTO `order` VALUES ('100', '0', '1', '100000.00', '-1');
INSERT INTO `order` VALUES ('101', '0', '1', '100000.00', '-1');
INSERT INTO `order` VALUES ('102', '0', '1', '100000.00', '-1');
INSERT INTO `order` VALUES ('103', '0', '1', '4800000.00', '-1');
INSERT INTO `order` VALUES ('104', '0', '1', '1000000.00', '2');
INSERT INTO `order` VALUES ('105', '0', '1', '1000000.00', '2');
INSERT INTO `order` VALUES ('106', '0', '2', '100000.00', '2');
INSERT INTO `order` VALUES ('107', '0', '2', '300000.00', '2');
INSERT INTO `order` VALUES ('108', '0', '1', '100000.00', '2');
INSERT INTO `order` VALUES ('109', '0', '1', '80.00', '2');
INSERT INTO `order` VALUES ('110', '0', '1', '100000.00', '2');
INSERT INTO `order` VALUES ('111', '0', '1', '100000.00', '-1');
INSERT INTO `order` VALUES ('112', '0', '0', '100000.00', '2');
INSERT INTO `order` VALUES ('113', '0', '2', '80.00', '-1');
INSERT INTO `order` VALUES ('114', '0', '2', '40.00', '-1');
INSERT INTO `order` VALUES ('115', '0', '1', '100058.00', '-1');
INSERT INTO `order` VALUES ('116', '0', '5', '1400000.00', '-1');
INSERT INTO `order` VALUES ('117', '0', '4', '100040.00', '-1');
INSERT INTO `order` VALUES ('118', '0', '4', '18.00', '-1');
INSERT INTO `order` VALUES ('119', '0', '4', '100000.00', '-1');
INSERT INTO `order` VALUES ('120', '0', '4', '100000.00', '-1');
INSERT INTO `order` VALUES ('121', '0', '4', '100000.00', '-1');
INSERT INTO `order` VALUES ('122', '0', '4', '40.00', '2');
INSERT INTO `order` VALUES ('123', '0', '6', '58.00', '2');
INSERT INTO `order` VALUES ('124', '0', '4', '40.00', '2');
INSERT INTO `order` VALUES ('125', '0', '4', '40.00', '2');
INSERT INTO `order` VALUES ('126', '0', '4', '18.00', '2');
INSERT INTO `order` VALUES ('127', '0', '4', '18.00', '2');
INSERT INTO `order` VALUES ('128', '0', '4', '40.00', '2');
INSERT INTO `order` VALUES ('129', '0', '4', '1040.00', '2');
INSERT INTO `order` VALUES ('130', '0', '1', '170.00', '-1');
INSERT INTO `order` VALUES ('131', '0', '1', '50.00', '1');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `price_sum` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('23', '1', '1', '97', '84.99149999999999');
INSERT INTO `orderitem` VALUES ('24', '1', '2', '97', '200');
INSERT INTO `orderitem` VALUES ('25', '1', '3', '97', '500');
INSERT INTO `orderitem` VALUES ('26', '1', '1', '98', '509.94899999999996');
INSERT INTO `orderitem` VALUES ('27', '1', '2', '98', '100');
INSERT INTO `orderitem` VALUES ('28', '1', '4', '99', '66');
INSERT INTO `orderitem` VALUES ('29', '1', '5', '99', '900');
INSERT INTO `orderitem` VALUES ('30', '1', '20', '100', '100000');
INSERT INTO `orderitem` VALUES ('31', '1', '20', '101', '100000');
INSERT INTO `orderitem` VALUES ('32', '1', '20', '102', '100000');
INSERT INTO `orderitem` VALUES ('33', '1', '20', '103', '4800000');
INSERT INTO `orderitem` VALUES ('34', '1', '20', '104', '1000000');
INSERT INTO `orderitem` VALUES ('35', '1', '20', '105', '1000000');
INSERT INTO `orderitem` VALUES ('36', '2', '23', '106', '100000');
INSERT INTO `orderitem` VALUES ('37', '2', '21', '107', '200000');
INSERT INTO `orderitem` VALUES ('38', '2', '23', '107', '100000');
INSERT INTO `orderitem` VALUES ('39', '1', '21', '108', '100000');
INSERT INTO `orderitem` VALUES ('40', '1', '26', '109', '80');
INSERT INTO `orderitem` VALUES ('41', '1', '21', '110', '100000');
INSERT INTO `orderitem` VALUES ('42', '1', '21', '111', '100000');
INSERT INTO `orderitem` VALUES ('43', '2', '21', '112', '100000');
INSERT INTO `orderitem` VALUES ('44', '2', '26', '113', '80');
INSERT INTO `orderitem` VALUES ('45', '2', '26', '114', '40');
INSERT INTO `orderitem` VALUES ('46', '1', '21', '115', '100000');
INSERT INTO `orderitem` VALUES ('47', '1', '26', '115', '40');
INSERT INTO `orderitem` VALUES ('48', '1', '29', '115', '18');
INSERT INTO `orderitem` VALUES ('49', '5', '21', '116', '1400000');
INSERT INTO `orderitem` VALUES ('50', '4', '21', '117', '100000');
INSERT INTO `orderitem` VALUES ('51', '4', '26', '117', '40');
INSERT INTO `orderitem` VALUES ('52', '4', '29', '118', '18');
INSERT INTO `orderitem` VALUES ('53', '4', '21', '119', '100000');
INSERT INTO `orderitem` VALUES ('54', '4', '21', '120', '100000');
INSERT INTO `orderitem` VALUES ('55', '4', '21', '121', '100000');
INSERT INTO `orderitem` VALUES ('56', '4', '26', '122', '40');
INSERT INTO `orderitem` VALUES ('57', '6', '29', '123', '18');
INSERT INTO `orderitem` VALUES ('58', '6', '26', '123', '40');
INSERT INTO `orderitem` VALUES ('59', '4', '26', '124', '40');
INSERT INTO `orderitem` VALUES ('60', '4', '26', '125', '40');
INSERT INTO `orderitem` VALUES ('61', '4', '29', '126', '18');
INSERT INTO `orderitem` VALUES ('62', '4', '29', '127', '18');
INSERT INTO `orderitem` VALUES ('63', '4', '26', '128', '40');
INSERT INTO `orderitem` VALUES ('64', '4', '26', '129', '1040');
INSERT INTO `orderitem` VALUES ('65', '1', '26', '130', '160');
INSERT INTO `orderitem` VALUES ('66', '1', '21', '130', '10');
INSERT INTO `orderitem` VALUES ('67', '1', '26', '131', '50');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'luo', '123456', '华仔', '男', '123456@qq.com', '123456', '-1', '广西北海');
INSERT INTO `user` VALUES ('2', 'luo', '123456', '华仔', '男', '123456@qq.com', '123456', '1', '广西北海');
INSERT INTO `user` VALUES ('3', 'huazai', '123456', '远华', '无', '', '', '1', '');
INSERT INTO `user` VALUES ('4', 'hua', '123456', '语言', '男', '2063126', '9909980', '-1', '北海');
INSERT INTO `user` VALUES ('5', 'yuan', '123', '', '无', '', '', null, '');
INSERT INTO `user` VALUES ('6', 'admin', '123', 'nini', '男', '65487', '987987', '0', '');
INSERT INTO `user` VALUES ('7', 'luo', '123456', '', '无', '', '', null, '');
