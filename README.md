# 进销存管理系统

## 页面全部激活

```
create database goods;

DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `userpower` int NOT NULL DEFAULT '2',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `usertable` VALUES ('1', 'admin', 'admin', '1');
INSERT INTO `usertable` VALUES ('2', 'guest', 'guest', '2');

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `customerid` int NOT NULL AUTO_INCREMENT,
  `customername` varchar(20) NOT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `starttime` date NOT NULL,
  `endtime` date NOT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `customers` VALUES ('1', '东华食堂', '1232345', '2020-01-01', '2025-01-01');
INSERT INTO `customers` VALUES ('2', '爱心屋', '2346788', '2020-05-01', '2028-08-04');
INSERT INTO `customers` VALUES ('3', '计算机大院', '1011100', '2019-04-04', '2028-01-21');

DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodid` int NOT NULL AUTO_INCREMENT,
  `goodname` varchar(20) NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`goodid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `goods` VALUES ('1', '苹果', '12');
INSERT INTO `goods` VALUES ('2', '泡面', '30');
INSERT INTO `goods` VALUES ('3', '可乐', '10');
INSERT INTO `goods` VALUES ('4', '面包', '20');
INSERT INTO `goods` VALUES ('5', '酸奶', '5');
INSERT INTO `goods` VALUES ('6', '香蕉', '10');

DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE `suppliers` (
  `supplierid` int NOT NULL AUTO_INCREMENT,
  `suppliername` varchar(20) NOT NULL,
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `starttime` date NOT NULL,
  `endtime` date NOT NULL,
  PRIMARY KEY (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `suppliers` VALUES ('1', '大号公司', '3742345', '2020-01-04', '2025-01-01');
INSERT INTO `suppliers` VALUES ('2', '小号公司', '8933234', '2019-01-01', '2024-01-01');
INSERT INTO `suppliers` VALUES ('3', '中号公司', '2341234', '2020-04-01', '2025-04-01');

DROP TABLE IF EXISTS `purchaseorder`;
CREATE TABLE `purchaseorder` (
  `purchaseid` int NOT NULL AUTO_INCREMENT,
  `supplierid` int NOT NULL,
  `goodid` int NOT NULL,
  `purchaseprice` decimal(8,2) NOT NULL,
  `purchasetime` date NOT NULL,
  `amount` int NOT NULL,
  `isreturn` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`purchaseid`),
  KEY `goodid` (`goodid`),
  KEY `supplierid1` (`supplierid`),
  CONSTRAINT `goodid` FOREIGN KEY (`goodid`) REFERENCES `goods` (`goodid`),
  CONSTRAINT `supplierid1` FOREIGN KEY (`supplierid`) REFERENCES `suppliers` (`supplierid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `purchaseorder` VALUES ('1', '1', '1', '100.00', '2022-03-02', '12', '1');
INSERT INTO `purchaseorder` VALUES ('2', '2', '1', '90.00', '2022-03-18', '15', '2');
INSERT INTO `purchaseorder` VALUES ('3', '3', '5', '90.00', '2022-03-02', '5', '1');
INSERT INTO `purchaseorder` VALUES ('4', '2', '2', '50.00', '2022-03-09', '30', '1');
INSERT INTO `purchaseorder` VALUES ('5', '2', '3', '72.00', '2022-03-10', '20', '1');
INSERT INTO `purchaseorder` VALUES ('6', '3', '4', '80.00', '2022-03-17', '30', '1');

CREATE TABLE `salesorder` (
  `salesid` int NOT NULL AUTO_INCREMENT,
  `customerid` int NOT NULL,
  `goodid` int NOT NULL,
  `salesprice` decimal(8,2) NOT NULL,
  `salestime` date NOT NULL,
  `amount` int NOT NULL,
  `isreturn` int NOT NULL DEFAULT '1',
  PRIMARY KEY (`salesid`),
  KEY `goodid` (`goodid`),
  CONSTRAINT `goodid` FOREIGN KEY (`goodid`) REFERENCES `goods` (`goodid`),
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

```
