
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel`  (
                          `orderno` int(11) NOT NULL PRIMARY KEY,
                          `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `price` float(6, 2) NOT NULL,
                          `hotelname` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                          `arrivedate` date NULL DEFAULT NULL,
                          `leavedate` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 ;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES (10001, '北京', 659, '酒店1', '2011-5-8','2011-5-11');
INSERT INTO `hotel` VALUES (10002, '上海', 799, '酒店2', '2019-11-11','2019-11-15');
INSERT INTO `hotel` VALUES (10003, '广州', 455, '酒店3', '2020-5-1','2020-5-4');
INSERT INTO `hotel` VALUES (10004, '上海', 699, '酒店4', '2019-5-4','2019-5-7');

SET FOREIGN_KEY_CHECKS = 1;
