-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.27


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema spadebranchdb
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ spadebranchdb;
USE spadebranchdb;

--
-- Table structure for table `spadebranchdb`.`brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brandId` varchar(5) NOT NULL,
  `brand` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`brandId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`brand`
--

/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` (`brandId`,`brand`) VALUES 
 ('B-001','Mass pvt'),
 ('B-002','Helies'),
 ('B-003','Brandix');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`custdebt`
--

DROP TABLE IF EXISTS `custdebt`;
CREATE TABLE `custdebt` (
  `customerId` varchar(10) NOT NULL DEFAULT '',
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`customerId`),
  CONSTRAINT `custdebt_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`custdebt`
--

/*!40000 ALTER TABLE `custdebt` DISABLE KEYS */;
/*!40000 ALTER TABLE `custdebt` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customerId` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`customer`
--

/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`customerId`,`name`,`address`) VALUES 
 ('C-0001','heshan','Bandaragama'),
 ('C-0002','heshan','Bandaragama');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`customertelephone`
--

DROP TABLE IF EXISTS `customertelephone`;
CREATE TABLE `customertelephone` (
  `customerId` varchar(10) NOT NULL DEFAULT '',
  `telNo` varchar(10) NOT NULL DEFAULT '',
  PRIMARY KEY (`customerId`,`telNo`),
  CONSTRAINT `customertelephone_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`customerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`customertelephone`
--

/*!40000 ALTER TABLE `customertelephone` DISABLE KEYS */;
INSERT INTO `customertelephone` (`customerId`,`telNo`) VALUES 
 ('C-0001','02154'),
 ('C-0002','02154'),
 ('C-0002','022254');
/*!40000 ALTER TABLE `customertelephone` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `code` varchar(20) NOT NULL DEFAULT '',
  `itemCode` varchar(8) DEFAULT NULL,
  `subId` varchar(8) DEFAULT NULL,
  `brandId` varchar(5) DEFAULT NULL,
  `supplierId` varchar(10) DEFAULT NULL,
  `saleType` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`code`),
  UNIQUE KEY `F3` (`itemCode`,`subId`,`brandId`,`supplierId`),
  KEY `F1` (`brandId`),
  KEY `F4` (`supplierId`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`brandId`) REFERENCES `brand` (`brandId`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`itemCode`) REFERENCES `itemcategory` (`itemCode`),
  CONSTRAINT `item_ibfk_3` FOREIGN KEY (`supplierId`) REFERENCES `supplier` (`supplierId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`code`,`itemCode`,`subId`,`brandId`,`supplierId`,`saleType`) VALUES 
 ('0001:001:0001:0001','C-0001','SB-0001','B-001','S-0001','sl'),
 ('0001:001:0001:0002','C-0001','SB-0002','B-001','S-0001','sl'),
 ('0001:002:0001:0001','C-0001','SB-0001','B-002','S-0001','nsl'),
 ('0001:003:0001:0001','C-0001','SB-0001','B-003','S-0001','nsl'),
 ('0002:001:0001:0002','C-0002','SB-0002','B-001','S-0001','nsl'),
 ('0002:001:0001:0003','C-0002','SB-0003','B-001','S-0001','sl'),
 ('0002:001:0001:0004','C-0002','SB-0004','B-001','S-0001','sl'),
 ('0002:001:0001:0005','C-0002','SB-0005','B-001','S-0001','sl'),
 ('0002:001:0001:0006','C-0002','SB-0006','B-001','S-0001','sl'),
 ('0002:003:0001:0001','C-0002','SB-0001','B-003','S-0001','nsl');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`itemcategory`
--

DROP TABLE IF EXISTS `itemcategory`;
CREATE TABLE `itemcategory` (
  `itemCode` varchar(8) NOT NULL DEFAULT '',
  `category` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`itemCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`itemcategory`
--

/*!40000 ALTER TABLE `itemcategory` DISABLE KEYS */;
INSERT INTO `itemcategory` (`itemCode`,`category`) VALUES 
 ('C-0001','Kiyath'),
 ('C-0002','Router Cutters'),
 ('C-0003','Cutters'),
 ('C-0004','Planer Blades'),
 ('C-0005','Other Items'),
 ('C-0006','Tips'),
 ('C-0007','Wheels'),
 ('C-0008','Silver Sole'),
 ('C-0009','Plux'),
 ('C-0010','Cupborad');
/*!40000 ALTER TABLE `itemcategory` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`kiyath`
--

DROP TABLE IF EXISTS `kiyath`;
CREATE TABLE `kiyath` (
  `code` varchar(20) NOT NULL DEFAULT '',
  `size` varchar(12) DEFAULT NULL,
  `noOfTips` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`code`),
  CONSTRAINT `kiyath_ibfk_1` FOREIGN KEY (`code`) REFERENCES `item` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`kiyath`
--

/*!40000 ALTER TABLE `kiyath` DISABLE KEYS */;
INSERT INTO `kiyath` (`code`,`size`,`noOfTips`) VALUES 
 ('0001:001:0001:0001','large',10),
 ('0001:001:0001:0002','large',10),
 ('0001:002:0001:0001','large',10),
 ('0001:003:0001:0001','large',10),
 ('0002:001:0001:0002','large',10);
/*!40000 ALTER TABLE `kiyath` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`routercutter`
--

DROP TABLE IF EXISTS `routercutter`;
CREATE TABLE `routercutter` (
  `code` varchar(20) NOT NULL DEFAULT '',
  `size` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`code`),
  CONSTRAINT `routercutter_ibfk_1` FOREIGN KEY (`code`) REFERENCES `item` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`routercutter`
--

/*!40000 ALTER TABLE `routercutter` DISABLE KEYS */;
INSERT INTO `routercutter` (`code`,`size`) VALUES 
 ('0002:001:0001:0003','large'),
 ('0002:001:0001:0004','large'),
 ('0002:001:0001:0005','large'),
 ('0002:001:0001:0006','large'),
 ('0002:003:0001:0001','large');
/*!40000 ALTER TABLE `routercutter` ENABLE KEYS */;


--
-- Table structure for table `spadebranchdb`.`supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierId` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(30) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `spadebranchdb`.`supplier`
--

/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`supplierId`,`name`,`address`,`email`) VALUES 
 ('S-0001','Heshan','Bandaragama','mhsandamal'),
 ('S-0003','jk','sdf','324');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
