-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: detailsCricket
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ball`
--

DROP TABLE IF EXISTS `ball`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ball` (
                        `ballID` int NOT NULL AUTO_INCREMENT,
                        `ballNo` int DEFAULT NULL,
                        `strikerId` int DEFAULT NULL,
                        `nonStrikerId` int DEFAULT NULL,
                        `bowlerId` int DEFAULT NULL,
                        `runsScored` int DEFAULT NULL,
                        `isWicketFall` tinyint DEFAULT NULL,
                        `overNo` int DEFAULT NULL,
                        `matchNo` int DEFAULT NULL,
                        `inningsNo` int DEFAULT NULL,
                        `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                        `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                        PRIMARY KEY (`ballID`),
                        KEY `matchNo_idx` (`matchNo`),
                        CONSTRAINT `matchNo` FOREIGN KEY (`matchNo`) REFERENCES `match` (`matchID`)
) ENGINE=InnoDB AUTO_INCREMENT=630 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `innings`
--

DROP TABLE IF EXISTS `innings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `innings` (
                           `inningsID` int NOT NULL AUTO_INCREMENT,
                           `inningsNo` int DEFAULT NULL,
                           `matchNo` int DEFAULT NULL,
                           `battingTeamId` int DEFAULT NULL,
                           `bowlingTeamId` int DEFAULT NULL,
                           `totalRuns` int DEFAULT NULL,
                           `dotBalls` int DEFAULT NULL,
                           `sixes` int DEFAULT NULL,
                           `fours` int DEFAULT NULL,
                           `wicketsDown` int DEFAULT NULL,
                           `ballsPlayed` int DEFAULT NULL,
                           `isChasing` tinyint DEFAULT NULL,
                           `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                           `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                           PRIMARY KEY (`inningsID`),
                           KEY `idmatch_idx` (`matchNo`),
                           CONSTRAINT `matchID` FOREIGN KEY (`matchNo`) REFERENCES `match` (`matchID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `match`
--

DROP TABLE IF EXISTS `match`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `match` (
                         `matchID` int NOT NULL AUTO_INCREMENT,
                         `venue` varchar(45) DEFAULT NULL,
                         `overs` int DEFAULT NULL,
                         `teamId1` int DEFAULT NULL,
                         `teamId2` int DEFAULT NULL,
                         `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                         `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                         PRIMARY KEY (`matchID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
                          `playerID` int NOT NULL AUTO_INCREMENT,
                          `playerNo` int DEFAULT NULL,
                          `role` varchar(45) DEFAULT NULL,
                          `runsScored` int DEFAULT NULL,
                          `wicketsTaken` int DEFAULT NULL,
                          `ballsFaced` int DEFAULT NULL,
                          `runsGiven` int DEFAULT NULL,
                          `oversBalled` int DEFAULT NULL,
                          `scored4` int DEFAULT NULL,
                          `scored6` int DEFAULT NULL,
                          `strikeRate` double DEFAULT NULL,
                          `average` double DEFAULT NULL,
                          `economy` double DEFAULT NULL,
                          `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                          `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                          PRIMARY KEY (`playerID`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team` (
                        `teamID` int NOT NULL AUTO_INCREMENT,
                        `teamName` varchar(45) DEFAULT NULL,
                        `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                        `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                        PRIMARY KEY (`teamID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `team_player_map`
--

DROP TABLE IF EXISTS `team_player_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `team_player_map` (
                                   `teamID` int NOT NULL,
                                   `playerID` int NOT NULL,
                                   `createdTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5),
                                   `modifiedTime` timestamp(5) NOT NULL DEFAULT CURRENT_TIMESTAMP(5) ON UPDATE CURRENT_TIMESTAMP(5),
                                   PRIMARY KEY (`teamID`,`playerID`),
                                   KEY `playerID_idx` (`playerID`),
                                   CONSTRAINT `playerID` FOREIGN KEY (`playerID`) REFERENCES `player` (`playerID`),
                                   CONSTRAINT `teamID` FOREIGN KEY (`teamID`) REFERENCES `team` (`teamID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tossResult`
--

DROP TABLE IF EXISTS `tossResult`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tossResult` (
                              `tossID` int NOT NULL AUTO_INCREMENT,
                              `matchID` int NOT NULL,
                              `battingTeamID` int DEFAULT NULL,
                              `bowlingTeamID` int DEFAULT NULL,
                              `result` varchar(45) DEFAULT NULL,
                              PRIMARY KEY (`tossID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-13 16:58:11
