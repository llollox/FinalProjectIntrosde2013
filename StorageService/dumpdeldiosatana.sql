CREATE DATABASE  IF NOT EXISTS `introsde` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `introsde`;
-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: introsde
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ACTIVITY`
--

DROP TABLE IF EXISTS `ACTIVITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIVITY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `VALUE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVITY`
--

LOCK TABLES `ACTIVITY` WRITE;
/*!40000 ALTER TABLE `ACTIVITY` DISABLE KEYS */;
INSERT INTO `ACTIVITY` VALUES (1,'3 Times Gymnastic',3),(2,'150 Minutes Bicycle',150),(3,'75 Minutes Swimming',75),(4,'40 Minutes Jumping the Rope',40),(5,'100 Minutes Walking Fast',100),(6,'350 Minutes Aerobic Light Activity',350),(7,'250 Minutes Aerobic Moderate Activity',250),(8,'3 Times Anaerobic Moderate Activity',3),(9,'5 Times Anaerobic Light Activity',5),(10,'250 Minutes Aerobic Hard Activity',250),(11,'400 Minutes Aerobic Moderate Activity',400),(12,'3 Times Anaerobic Medium Activity',5),(13,'3 Times Anaerobic Hard Activity',3);
/*!40000 ALTER TABLE `ACTIVITY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ACTIVITYCHOOSEN`
--

DROP TABLE IF EXISTS `ACTIVITYCHOOSEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIVITYCHOOSEN` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `PERCENTAGE` float DEFAULT NULL,
  `ACTIVITY_ID` int(11) DEFAULT NULL,
  `GOAL_ID` int(11) DEFAULT NULL,
  `PERSON_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ACTIVITYCHOOSEN_PERSON_ID` (`PERSON_ID`),
  KEY `FK_ACTIVITYCHOOSEN_GOAL_ID` (`GOAL_ID`),
  KEY `FK_ACTIVITYCHOOSEN_ACTIVITY_ID` (`ACTIVITY_ID`),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_ACTIVITY_ID` FOREIGN KEY (`ACTIVITY_ID`) REFERENCES `ACTIVITY` (`ID`),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_GOAL_ID` FOREIGN KEY (`GOAL_ID`) REFERENCES `GOAL` (`ID`),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `PERSON` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVITYCHOOSEN`
--

LOCK TABLES `ACTIVITYCHOOSEN` WRITE;
/*!40000 ALTER TABLE `ACTIVITYCHOOSEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACTIVITYCHOOSEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Activity_has_categories`
--

DROP TABLE IF EXISTS `Activity_has_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activity_has_categories` (
  `idactivity` int(11) NOT NULL,
  `idcategory` int(11) NOT NULL,
  PRIMARY KEY (`idactivity`,`idcategory`),
  KEY `FK_Activity_has_categories_idcategory` (`idcategory`),
  CONSTRAINT `FK_Activity_has_categories_idactivity` FOREIGN KEY (`idactivity`) REFERENCES `ACTIVITY` (`ID`),
  CONSTRAINT `FK_Activity_has_categories_idcategory` FOREIGN KEY (`idcategory`) REFERENCES `EXERCISECATEGORY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activity_has_categories`
--

LOCK TABLES `Activity_has_categories` WRITE;
/*!40000 ALTER TABLE `Activity_has_categories` DISABLE KEYS */;
INSERT INTO `Activity_has_categories` VALUES (10,1),(6,2),(12,3),(13,3),(2,4),(7,4),(10,4),(9,5),(8,6),(8,8),(9,8),(1,9),(8,9),(13,9),(8,10),(12,10),(4,11),(7,12),(10,12),(11,13),(11,14),(12,15),(13,15),(7,16),(10,16),(6,17),(6,18),(3,19),(10,19),(6,20),(7,20),(11,20),(11,21),(5,22),(13,23),(9,24);
/*!40000 ALTER TABLE `Activity_has_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXCLUDEDFOOD`
--

DROP TABLE IF EXISTS `EXCLUDEDFOOD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXCLUDEDFOOD` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `PERSON_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EXCLUDEDFOOD_PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_EXCLUDEDFOOD_PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `PERSON` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXCLUDEDFOOD`
--

LOCK TABLES `EXCLUDEDFOOD` WRITE;
/*!40000 ALTER TABLE `EXCLUDEDFOOD` DISABLE KEYS */;
/*!40000 ALTER TABLE `EXCLUDEDFOOD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXERCISE`
--

DROP TABLE IF EXISTS `EXERCISE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXERCISE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `DIFFICULTYVALUE` float DEFAULT NULL,
  `idcategory` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EXERCISE_idcategory` (`idcategory`),
  CONSTRAINT `FK_EXERCISE_idcategory` FOREIGN KEY (`idcategory`) REFERENCES `EXERCISECATEGORY` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXERCISE`
--

LOCK TABLES `EXERCISE` WRITE;
/*!40000 ALTER TABLE `EXERCISE` DISABLE KEYS */;
INSERT INTO `EXERCISE` VALUES (1,'Aerobic Dance (Casual)',2.65,1),(2,'Aerobic Dance (Moderate)',3,1),(3,'Aerobic Dance (Intense)',3.71,1),(4,'Basketball (Full court)',2.7,2),(5,'Basketball (Half court)',1.67,2),(6,'Calisthenics',2,3),(7,'Cycling (5.5 mph, 9 kmph)',1.6,4),(8,'Cycling (10 mph, 16 kmph)',3,4),(9,'Cycling (13 mph, 21 kmph)',4.26,4),(10,'Cycling (Racing)',4.66,4),(11,'Dancing (Casual)',2.62,5),(12,'Dancing (Moderate)',2.84,5),(13,'Dancing (Extreme)',3.65,5),(14,'Field Sports (Competitive)',3.7,6),(15,'Frisbie',2.75,7),(16,'Golf (Carry Clubs)',2.37,8),(17,'Golf (with Cart)',2,8),(18,'Gymnastics',1.96,9),(19,'Housework',1.7,10),(20,'Jump Rope (Fast)',4.6,11),(21,'Jump Rope (Slow)',3.7,11),(22,'Martial Arts',5.35,12),(23,'Racquetball',4.88,13),(24,'Rollerblading (Casual)',3.6,14),(25,'Rollerblading (Fast)',4.25,14),(26,'Rowing Machine (Extreme)',4.91,15),(27,'Rowing Machine (Moderate)',3.27,15),(28,'Running (4 mph, 6.5 kmph)',2.92,16),(29,'Running (5 mph, 8 kmph)',3.62,16),(30,'Running (6 mph, 9.7 kmph)',4.8,16),(31,'Running (7 mph, 11.3 kmph)',5.4,16),(32,'Running (8 mph, 13 kmph)',6.3,16),(33,'Running (10 mph, 16 kmph)',7.5,16),(34,'Running (12 mph, 19.3 kmph)',7.9,16),(35,'Softball',1.91,17),(36,'Stair Step (6\", 15.2 cm)',3.71,18),(37,'Stair Step (8\", 20.3 cm)',4.09,18),(38,'Stair Step (10\", 25.4 cm)',4.42,18),(39,'Stair Step (12\", 30.5 cm)',4.91,18),(40,'Swimming (Casual)',3,19),(41,'Swimming (Vigorous)',10,19),(42,'Tennis (Doubles)',2.56,20),(43,'Tennis (Singles)',3,20),(44,'Volleyball (Casual)',1.39,21),(45,'Volleyball (Vigorous)',3.98,21),(46,'Walking (2 mph, 3.2 kmph)',1.4,22),(47,'Walking (2.5 mph, 4 kmph)',1.75,22),(48,'Walking (3 mph, 4.8 kmph)',2,22),(49,'Walking (3.5 mph, 5.6 kmph)',2.3,22),(50,'Walking (4 mph, 6.5 kmph)',2.67,22),(51,'Walking (4.5 mph, 7.2 kmph)',3.1,22),(52,'Weight Training (Intense)',3.2,23),(53,'Weight Training (Normal)',2.35,23),(54,'Yardwork (Heavy)',3.4,24),(55,'Yardwork (Regular)',1.6,24);
/*!40000 ALTER TABLE `EXERCISE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXERCISECATEGORY`
--

DROP TABLE IF EXISTS `EXERCISECATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXERCISECATEGORY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `AEROBIC` int(11) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXERCISECATEGORY`
--

LOCK TABLES `EXERCISECATEGORY` WRITE;
/*!40000 ALTER TABLE `EXERCISECATEGORY` DISABLE KEYS */;
INSERT INTO `EXERCISECATEGORY` VALUES (1,1,'Aerobic Dance'),(2,1,'Basketball'),(3,0,'Calisthenics'),(4,1,'Cycling'),(5,0,'Dancing'),(6,1,'Field Sports'),(7,1,'Frisbie'),(8,0,'Golf'),(9,0,'Gymnastics'),(10,0,'Housework'),(11,1,'Jump Rope'),(12,1,'Martial Arts'),(13,1,'Racquetball'),(14,1,'Rollerblading'),(15,0,'Rowing Machine'),(16,1,'Running'),(17,1,'Softball'),(18,1,'Stair Step'),(19,1,'Swimming'),(20,1,'Tennis'),(21,1,'Volleyball'),(22,1,'Walking'),(23,0,'Weight Training'),(24,0,'Yardwork');
/*!40000 ALTER TABLE `EXERCISECATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXERCISEHISTORY`
--

DROP TABLE IF EXISTS `EXERCISEHISTORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EXERCISEHISTORY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `idactivitychoosen` int(11) DEFAULT NULL,
  `idexercise` int(11) DEFAULT NULL,
  `idperson` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EXERCISEHISTORY_idexercise` (`idexercise`),
  KEY `FK_EXERCISEHISTORY_idperson` (`idperson`),
  KEY `FK_EXERCISEHISTORY_idactivitychoosen` (`idactivitychoosen`),
  CONSTRAINT `FK_EXERCISEHISTORY_idactivitychoosen` FOREIGN KEY (`idactivitychoosen`) REFERENCES `ACTIVITYCHOOSEN` (`ID`),
  CONSTRAINT `FK_EXERCISEHISTORY_idexercise` FOREIGN KEY (`idexercise`) REFERENCES `EXERCISE` (`ID`),
  CONSTRAINT `FK_EXERCISEHISTORY_idperson` FOREIGN KEY (`idperson`) REFERENCES `PERSON` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXERCISEHISTORY`
--

LOCK TABLES `EXERCISEHISTORY` WRITE;
/*!40000 ALTER TABLE `EXERCISEHISTORY` DISABLE KEYS */;
/*!40000 ALTER TABLE `EXERCISEHISTORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FAVOURITEFOOD`
--

DROP TABLE IF EXISTS `FAVOURITEFOOD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FAVOURITEFOOD` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `PERSON_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_FAVOURITEFOOD_PERSON_ID` (`PERSON_ID`),
  CONSTRAINT `FK_FAVOURITEFOOD_PERSON_ID` FOREIGN KEY (`PERSON_ID`) REFERENCES `PERSON` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FAVOURITEFOOD`
--

LOCK TABLES `FAVOURITEFOOD` WRITE;
/*!40000 ALTER TABLE `FAVOURITEFOOD` DISABLE KEYS */;
/*!40000 ALTER TABLE `FAVOURITEFOOD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GOAL`
--

DROP TABLE IF EXISTS `GOAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GOAL` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GOAL`
--

LOCK TABLES `GOAL` WRITE;
/*!40000 ALTER TABLE `GOAL` DISABLE KEYS */;
INSERT INTO `GOAL` VALUES (1,'Loose Weight Seriously'),(2,'Important Health Benefits'),(3,'Great Health Benefits');
/*!40000 ALTER TABLE `GOAL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GOALCHOOSEN`
--

DROP TABLE IF EXISTS `GOALCHOOSEN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GOALCHOOSEN` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `idgoal` int(11) DEFAULT NULL,
  `idperson` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_GOALCHOOSEN_idgoal` (`idgoal`),
  KEY `FK_GOALCHOOSEN_idperson` (`idperson`),
  CONSTRAINT `FK_GOALCHOOSEN_idperson` FOREIGN KEY (`idperson`) REFERENCES `PERSON` (`ID`),
  CONSTRAINT `FK_GOALCHOOSEN_idgoal` FOREIGN KEY (`idgoal`) REFERENCES `GOAL` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GOALCHOOSEN`
--

LOCK TABLES `GOALCHOOSEN` WRITE;
/*!40000 ALTER TABLE `GOALCHOOSEN` DISABLE KEYS */;
/*!40000 ALTER TABLE `GOALCHOOSEN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Goal_has_Activity`
--

DROP TABLE IF EXISTS `Goal_has_Activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Goal_has_Activity` (
  `idgoal` int(11) NOT NULL,
  `idactivity` int(11) NOT NULL,
  PRIMARY KEY (`idgoal`,`idactivity`),
  KEY `FK_Goal_has_Activity_idactivity` (`idactivity`),
  CONSTRAINT `FK_Goal_has_Activity_idgoal` FOREIGN KEY (`idgoal`) REFERENCES `GOAL` (`ID`),
  CONSTRAINT `FK_Goal_has_Activity_idactivity` FOREIGN KEY (`idactivity`) REFERENCES `ACTIVITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Goal_has_Activity`
--

LOCK TABLES `Goal_has_Activity` WRITE;
/*!40000 ALTER TABLE `Goal_has_Activity` DISABLE KEYS */;
INSERT INTO `Goal_has_Activity` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(2,6),(2,7),(2,8),(2,9),(3,10),(3,11),(3,12),(3,13);
/*!40000 ALTER TABLE `Goal_has_Activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HEALTHPROFILE`
--

DROP TABLE IF EXISTS `HEALTHPROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `HEALTHPROFILE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DATE` varchar(255) DEFAULT NULL,
  `HEARTRATE` int(11) DEFAULT NULL,
  `HEIGHT` double DEFAULT NULL,
  `MAXBLOODPRESSURE` int(11) DEFAULT NULL,
  `MINBLOODPRESSURE` int(11) DEFAULT NULL,
  `WEIGHT` double DEFAULT NULL,
  `idperson` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_HEALTHPROFILE_idperson` (`idperson`),
  CONSTRAINT `FK_HEALTHPROFILE_idperson` FOREIGN KEY (`idperson`) REFERENCES `PERSON` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HEALTHPROFILE`
--

LOCK TABLES `HEALTHPROFILE` WRITE;
/*!40000 ALTER TABLE `HEALTHPROFILE` DISABLE KEYS */;
INSERT INTO `HEALTHPROFILE` VALUES (1,'2014-01-15',63,1.9147124449550152,122,68,101.98103855256865,1),(2,'2014-01-15',69,1.7417701640059886,134,68,83.26837692827607,2),(3,'2014-01-15',86,1.7899953353409939,138,73,80.91993748753706,2),(4,'2014-01-15',65,2.006663881164763,169,71,113.21094005495156,3),(5,'2014-01-15',86,2.2591806022221297,152,108,114.41926470737516,3),(6,'2014-01-15',78,1.9118734479541948,141,82,112.78315739582223,3),(7,'2014-01-15',67,1.979962491915685,151,86,89.06655550083818,4),(8,'2014-01-15',81,1.9734353870743675,141,70,84.33413683357571,4),(9,'2014-01-15',73,1.9693542742343733,155,85,85.23328713748619,4),(10,'2014-01-15',81,1.9782273059241857,106,83,86.27746366991552,4),(11,'2014-01-15',89,1.677052872928602,86,69,88.87820391148183,5),(12,'2014-01-15',74,1.8310800900161481,167,69,89.74299817447177,5),(13,'2014-01-15',75,1.9088778027517546,82,64,84.5734121419655,5),(14,'2014-01-15',68,1.637558272527104,133,81,86.30838916663323,5),(15,'2014-01-15',74,2.19123347441095,160,70,112.65270616109972,6),(16,'2014-01-15',88,2.0256743225460294,122,69,112.40749617163375,6),(17,'2014-01-15',70,2.005776775322023,131,77,97.59737196498202,7),(18,'2014-01-15',84,2.0249273851363685,174,104,96.31671303176023,7),(19,'2014-01-15',85,1.9039139023678553,173,98,96.45275173493077,7),(20,'2014-01-15',77,1.9553818794450792,174,96,94.28251504209125,7),(21,'2014-01-15',74,1.8333633244601208,128,72,98.67506705148445,8),(22,'2014-01-15',71,2.081107467079481,173,107,97.44521002358469,8),(23,'2014-01-15',88,1.6852152296426477,138,101,101.73983599637235,8),(24,'2014-01-15',73,1.7057851976031464,73,62,98.33445146060093,8),(25,'2014-01-15',88,1.7583250513647593,161,83,117.05738338731823,9),(26,'2014-01-15',75,2.161291238236979,145,64,122.04826272762993,9),(27,'2014-01-15',61,2.1015183427461195,138,102,104.19530820213276,10),(28,'2014-01-15',80,2.0996665696959442,133,83,105.2780008537688,10),(29,'2014-01-15',89,1.989177548660511,79,69,90.01133535203013,11),(30,'2014-01-15',88,1.7282601304367897,138,93,85.41570890431709,11),(31,'2014-01-15',85,1.9006938535856173,92,61,91.01068893086423,11),(32,'2014-01-15',82,1.6204780500532983,135,83,87.52550601992081,12),(33,'2014-01-15',86,1.8694106840562468,138,104,105.48872478163068,13),(34,'2014-01-15',86,1.9898741323789246,173,109,106.98010072152285,13),(35,'2014-01-15',72,1.8162592042993357,131,95,105.89254385765933,13),(36,'2014-01-15',61,1.9223232543140074,114,82,90.69019117782214,14),(37,'2014-01-15',73,1.7382690726837466,156,103,94.97689150719553,14),(38,'2014-01-15',81,2.000073253714994,101,75,92.50154883889915,14),(39,'2014-01-15',80,2.1339559983095295,88,65,95.2243376148638,15),(40,'2014-01-15',84,2.0004778139525277,141,93,92.36631299903502,15),(41,'2014-01-15',89,1.9106435906664119,163,66,94.11467410440873,15),(42,'2014-01-15',68,1.9508069154279981,127,89,95.67356229239299,15),(43,'2014-01-15',80,2.1012354727315774,117,92,93.03127739377632,15),(44,'2014-01-15',80,1.6672458480767611,103,86,94.19888564201841,16),(45,'2014-01-15',65,1.7980372349682026,121,75,95.95018162177102,16),(46,'2014-01-15',76,1.9299105870082782,136,101,123.12844100925659,17),(47,'2014-01-15',64,2.1642715817961338,156,103,116.85630842231524,17),(48,'2014-01-15',62,1.4172567554504154,169,105,87.91721736691707,18),(49,'2014-01-15',68,1.83060275055504,125,103,91.54301133595467,18),(50,'2014-01-15',69,2.001680398866736,135,108,99.07244795051544,19),(51,'2014-01-15',61,2.1283241761982903,157,83,99.17335589021799,19),(52,'2014-01-15',76,1.82814532915171,145,70,98.79056497436487,19),(53,'2014-01-15',86,1.9639979471712867,161,103,96.50299854074726,19),(54,'2014-01-15',85,2.174130603666552,105,86,106.56996598392351,20),(55,'2014-01-15',71,1.895927487276061,124,69,105.14749780617335,20),(56,'2014-01-15',67,1.9818473674986974,77,67,102.37163096637748,20),(57,'2014-01-15',66,2.144913245928907,143,104,108.88486468434648,21),(58,'2014-01-15',74,2.0344728557061997,129,107,109.49870881873845,21),(59,'2014-01-15',67,2.201929780190893,148,77,108.78218504817264,21),(60,'2014-01-15',80,2.190234930039218,144,84,113.38677467581041,21),(61,'2014-01-15',61,1.8145435097130265,87,63,112.59360257726695,21),(62,'2014-01-15',66,1.9527502964623955,144,108,89.12677227458256,22),(63,'2014-01-15',72,2.038000260116455,174,81,92.97133545560615,22),(64,'2014-01-15',70,2.0263875696793257,126,85,92.6504760435713,22),(65,'2014-01-15',83,1.9524003310130837,154,106,93.46368419132483,22),(66,'2014-01-15',65,1.9065422377314862,138,84,91.00733462902316,22),(67,'2014-01-15',77,2.005859303581908,130,75,89.77521709948738,23),(68,'2014-01-15',82,1.8222700110426886,172,88,85.30206249635371,23),(69,'2014-01-15',77,1.8936111088164949,90,73,94.50748127719478,24),(70,'2014-01-15',86,1.9117985768488166,168,107,93.81163130725913,24),(71,'2014-01-15',61,2.0194202863794537,117,102,109.0969272226003,25),(72,'2014-01-15',81,1.89813932622582,163,97,81.13514941743902,26),(73,'2014-01-15',70,1.8675474238223657,134,79,79.1096810917472,26),(74,'2014-01-15',61,1.8395253337528412,126,104,79.04130249001983,26),(75,'2014-01-15',77,1.8482614913565854,104,76,76.3369905943084,26),(76,'2014-01-15',64,1.970471814152552,138,63,94.27319886176029,27),(77,'2014-01-15',63,1.5535265321431817,146,83,93.4586091082602,27),(78,'2014-01-15',67,2.207110166500494,109,68,127.9669737266675,28),(79,'2014-01-15',68,2.2526842795364797,144,101,128.79710705065384,28),(80,'2014-01-15',62,2.073179474423395,107,66,124.08307611585269,28),(81,'2014-01-15',80,1.9450140222946226,101,89,122.64414759895438,28),(82,'2014-01-15',82,1.792355011458614,148,72,95.36123054287327,29),(83,'2014-01-15',79,1.9314608579220198,119,75,99.42469510257752,29),(84,'2014-01-15',81,1.95767725675878,145,108,116.45239667836238,30),(85,'2014-01-15',69,2.1075282203232337,162,72,120.08648626125596,30),(86,'2014-01-15',79,2.1929206750059196,166,74,117.19968670285772,30),(87,'2014-01-15',78,2.2185820332349455,170,67,120.58534212437972,30),(88,'2014-01-15',84,2.129722195086874,132,88,105.9300405497854,31),(89,'2014-01-15',69,2.2195125798491446,163,101,108.64131722333256,31),(90,'2014-01-15',72,1.8687462963214996,137,87,117.09011353549798,32),(91,'2014-01-15',75,2.2197733050347233,154,102,118.40653913870202,32),(92,'2014-01-15',75,1.9993217365479166,164,96,114.71668988424206,32),(93,'2014-01-15',63,1.9049811687683789,172,97,91.54266796936162,33),(94,'2014-01-15',87,1.6821164746531885,170,108,91.42914025755437,33),(95,'2014-01-15',79,1.834119034007824,152,83,84.63372156243342,34),(96,'2014-01-15',64,2.217405224505798,104,88,126.87215188833673,35),(97,'2014-01-15',82,1.975587095729761,96,75,128.00421545379882,35),(98,'2014-01-15',65,1.9887255631880367,158,80,127.61260255573983,35),(99,'2014-01-15',65,1.7593029613004985,154,103,128.85498039500982,35),(100,'2014-01-15',89,2.242076007417508,146,80,127.49906549202007,35),(101,'2014-01-15',82,1.8234761344032127,168,71,97.46701925194394,36),(102,'2014-01-15',90,2.04578615099054,114,79,102.48511789177533,36),(103,'2014-01-15',83,2.022718065367671,132,102,101.62677763892862,36),(104,'2014-01-15',85,1.9932660103033677,155,89,99.367522903211,36),(105,'2014-01-15',61,1.8843371939251403,140,99,101.30619409093431,37),(106,'2014-01-15',64,1.9290810963272425,171,81,100.70221959986895,37),(107,'2014-01-15',65,2.0391969385170015,129,104,98.4955511742002,37),(108,'2014-01-15',79,1.8851404487852645,117,105,101.41982151815206,38),(109,'2014-01-15',81,1.9377589244413718,153,86,99.28542004122272,38),(110,'2014-01-15',73,1.9551961501156283,94,64,97.4388706420153,38),(111,'2014-01-15',88,1.680362471462256,105,68,98.28038466290519,38),(112,'2014-01-15',75,1.6632311992887183,135,97,96.74763480291841,39),(113,'2014-01-15',74,1.9595783221768572,103,91,97.67520057753141,39),(114,'2014-01-15',75,2.0863661749271483,156,93,94.08418343111593,39),(115,'2014-01-15',78,1.7755569996209415,127,62,98.15309457688008,39),(116,'2014-01-15',78,2.012635022102355,131,94,96.18478022671958,39),(117,'2014-01-15',69,1.8938617984519062,124,109,82.20778183467466,40),(118,'2014-01-15',83,1.9518149504796547,172,81,83.18086241318707,40);
/*!40000 ALTER TABLE `HEALTHPROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PERSON`
--

DROP TABLE IF EXISTS `PERSON`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PERSON` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BIRTHDATE` varchar(255) DEFAULT NULL,
  `EXERCISETIMESPERWEEK` int(11) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `SEX` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PERSON`
--

LOCK TABLES `PERSON` WRITE;
/*!40000 ALTER TABLE `PERSON` DISABLE KEYS */;
INSERT INTO `PERSON` VALUES (1,'1987-02-28',2,'Stephen','Weigh',1),(2,'1988-08-11',7,'Patrick','Mills',0),(3,'1988-06-17',3,'Andrew','Ogilvy',1),(4,'1979-09-20',1,'Damien','Ryan',1),(5,'1981-08-24',7,'Daryl','Corletto',0),(6,'1980-06-23',5,'David','Andersen',1),(7,'1983-10-22',5,'David','Barlow',1),(8,'1987-10-02',1,'Joe','Ingles',1),(9,'1986-02-19',6,'Luke','Nevill',0),(10,'1978-02-03',3,'Matthew','Nielsen',1),(11,'1979-08-03',2,'Nathan','Crosswell',0),(12,'1979-11-06',2,'Peter','Crawford',0),(13,'1987-07-04',3,'Ater','Majok',0),(14,'1986-10-30',5,'Adam','Gibson',1),(15,'1985-02-18',5,'Brad','Newley',1),(16,'1983-08-14',3,'Jacob','Holmes',1),(17,'1982-12-31',3,'Luke','Schenscher',1),(18,'1975-12-13',1,'Calvin Thomas, Jr.','Bruton',0),(19,'1978-08-11',4,'Dusty','Rychart',1),(20,'1983-06-08',6,'Mark','Worthington',1),(21,'1979-07-10',3,'Russell','Hinder',1),(22,'1985-01-21',3,'Matt','Unicomb',0),(23,'1992-03-23',2,'Kyrie','Irving',0),(24,'1988-12-06',6,'Anatoly','Bose',0),(25,'1986-02-23',2,'Julian','Khazzouh',0),(26,'1991-02-16',1,'Tom','Daly',0),(27,'1984-09-05',5,'Damian','Martin',1),(28,'1984-10-22',6,'Aleks','Maric',0),(29,'1992-04-27',5,'Mitch','Creek',1),(30,'1969-01-19',5,'Luc','Longley',1),(31,'1988-04-03',0,'Daniel','Johnson',0),(32,'1986-12-09',3,'Aron','Baynes',1),(33,'1985-03-14',4,'Steven','Markovic',1),(34,'1984-03-04',4,'Rhys','Carter',1),(35,'1986-10-10',0,'Nathan','Jawai',0),(36,'1981-01-21',1,'Shawn','Redhage',0),(37,'1989-02-03',3,'Alex','Gynes',1),(38,'1987-09-19',2,'Greg','Hire',1),(39,'1990-08-23',3,'Ryan','Broekhoff',0),(40,'1985-02-07',6,'Ben','Madgen',1);
/*!40000 ALTER TABLE `PERSON` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-01-15  1:06:39
