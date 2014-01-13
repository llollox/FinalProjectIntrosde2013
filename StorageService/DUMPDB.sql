SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `introsde` ;
CREATE SCHEMA IF NOT EXISTS `introsde` DEFAULT CHARACTER SET utf8 ;
USE `introsde` ;

-- -----------------------------------------------------
-- Table `introsde`.`ACTIVITY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`ACTIVITY` ;

CREATE TABLE IF NOT EXISTS `introsde`.`ACTIVITY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ACTIVITYGROUP` INT(11) NULL DEFAULT NULL,
  `AEROBIC` INT(11) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `DIFFICULTYVALUE` INT(11) NULL DEFAULT NULL,
  `TYPE` INT(11) NULL DEFAULT NULL,
  `VALUE` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`GOAL`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`GOAL` ;

CREATE TABLE IF NOT EXISTS `introsde`.`GOAL` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `ENDDATE` VARCHAR(255) NULL DEFAULT NULL,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  `VALUE` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`PERSON`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`PERSON` ;

CREATE TABLE IF NOT EXISTS `introsde`.`PERSON` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `BIRTHDATE` VARCHAR(255) NULL DEFAULT NULL,
  `EXERCISETIMESPERWEEK` INT(11) NULL DEFAULT NULL,
  `FIRSTNAME` VARCHAR(255) NULL DEFAULT NULL,
  `LASTNAME` VARCHAR(255) NULL DEFAULT NULL,
  `SEX` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 41
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`ACTIVITYCHOOSEN`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`ACTIVITYCHOOSEN` ;

CREATE TABLE IF NOT EXISTS `introsde`.`ACTIVITYCHOOSEN` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE` VARCHAR(255) NULL DEFAULT NULL,
  `PERCENTAGE` FLOAT NULL DEFAULT NULL,
  `ACTIVITY_ID` INT(11) NULL DEFAULT NULL,
  `GOAL_ID` INT(11) NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_ACTIVITYCHOOSEN_PERSON_ID` (`PERSON_ID` ASC),
  INDEX `FK_ACTIVITYCHOOSEN_GOAL_ID` (`GOAL_ID` ASC),
  INDEX `FK_ACTIVITYCHOOSEN_ACTIVITY_ID` (`ACTIVITY_ID` ASC),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_ACTIVITY_ID`
    FOREIGN KEY (`ACTIVITY_ID`)
    REFERENCES `introsde`.`ACTIVITY` (`ID`),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_GOAL_ID`
    FOREIGN KEY (`GOAL_ID`)
    REFERENCES `introsde`.`GOAL` (`ID`),
  CONSTRAINT `FK_ACTIVITYCHOOSEN_PERSON_ID`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `introsde`.`PERSON` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`EXCLUDEDFOOD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`EXCLUDEDFOOD` ;

CREATE TABLE IF NOT EXISTS `introsde`.`EXCLUDEDFOOD` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_EXCLUDEDFOOD_PERSON_ID` (`PERSON_ID` ASC),
  CONSTRAINT `FK_EXCLUDEDFOOD_PERSON_ID`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `introsde`.`PERSON` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`EXERCISE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`EXERCISE` ;

CREATE TABLE IF NOT EXISTS `introsde`.`EXERCISE` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `AEROBIC` INT(11) NULL DEFAULT NULL,
  `DESCRIPTION` VARCHAR(255) NULL DEFAULT NULL,
  `DIFFICULTYVALUE` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`EXERCISECATEGORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`EXERCISECATEGORY` ;

CREATE TABLE IF NOT EXISTS `introsde`.`EXERCISECATEGORY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`EXERCISEHISTORY`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`EXERCISEHISTORY` ;

CREATE TABLE IF NOT EXISTS `introsde`.`EXERCISEHISTORY` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE` VARCHAR(255) NULL DEFAULT NULL,
  `idactivitychoosen` INT(11) NULL DEFAULT NULL,
  `idexercise` INT(11) NULL DEFAULT NULL,
  `idperson` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_EXERCISEHISTORY_idexercise` (`idexercise` ASC),
  INDEX `FK_EXERCISEHISTORY_idperson` (`idperson` ASC),
  INDEX `FK_EXERCISEHISTORY_idactivitychoosen` (`idactivitychoosen` ASC),
  CONSTRAINT `FK_EXERCISEHISTORY_idactivitychoosen`
    FOREIGN KEY (`idactivitychoosen`)
    REFERENCES `introsde`.`ACTIVITYCHOOSEN` (`ID`),
  CONSTRAINT `FK_EXERCISEHISTORY_idexercise`
    FOREIGN KEY (`idexercise`)
    REFERENCES `introsde`.`EXERCISE` (`ID`),
  CONSTRAINT `FK_EXERCISEHISTORY_idperson`
    FOREIGN KEY (`idperson`)
    REFERENCES `introsde`.`PERSON` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`FAVOURITEFOOD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`FAVOURITEFOOD` ;

CREATE TABLE IF NOT EXISTS `introsde`.`FAVOURITEFOOD` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(255) NULL DEFAULT NULL,
  `PERSON_ID` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_FAVOURITEFOOD_PERSON_ID` (`PERSON_ID` ASC),
  CONSTRAINT `FK_FAVOURITEFOOD_PERSON_ID`
    FOREIGN KEY (`PERSON_ID`)
    REFERENCES `introsde`.`PERSON` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`Goal_has_Activity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`Goal_has_Activity` ;

CREATE TABLE IF NOT EXISTS `introsde`.`Goal_has_Activity` (
  `idgoal` INT(11) NOT NULL,
  `idactivity` INT(11) NOT NULL,
  PRIMARY KEY (`idgoal`, `idactivity`),
  INDEX `FK_Goal_has_Activity_idactivity` (`idactivity` ASC),
  CONSTRAINT `FK_Goal_has_Activity_idgoal`
    FOREIGN KEY (`idgoal`)
    REFERENCES `introsde`.`GOAL` (`ID`),
  CONSTRAINT `FK_Goal_has_Activity_idactivity`
    FOREIGN KEY (`idactivity`)
    REFERENCES `introsde`.`ACTIVITY` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`HEALTHPROFILE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`HEALTHPROFILE` ;

CREATE TABLE IF NOT EXISTS `introsde`.`HEALTHPROFILE` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `DATE` VARCHAR(255) NULL DEFAULT NULL,
  `HEARTRATE` INT(11) NULL DEFAULT NULL,
  `HEIGHT` DOUBLE NULL DEFAULT NULL,
  `MAXBLOODPRESSURE` INT(11) NULL DEFAULT NULL,
  `MINBLOODPRESSURE` INT(11) NULL DEFAULT NULL,
  `WEIGHT` DOUBLE NULL DEFAULT NULL,
  `idperson` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `FK_HEALTHPROFILE_idperson` (`idperson` ASC),
  CONSTRAINT `FK_HEALTHPROFILE_idperson`
    FOREIGN KEY (`idperson`)
    REFERENCES `introsde`.`PERSON` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 122
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `introsde`.`Person_has_Goal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `introsde`.`Person_has_Goal` ;

CREATE TABLE IF NOT EXISTS `introsde`.`Person_has_Goal` (
  `idperson` INT(11) NOT NULL,
  `idgoal` INT(11) NOT NULL,
  PRIMARY KEY (`idperson`, `idgoal`),
  INDEX `FK_Person_has_Goal_idgoal` (`idgoal` ASC),
  CONSTRAINT `FK_Person_has_Goal_idperson`
    FOREIGN KEY (`idperson`)
    REFERENCES `introsde`.`PERSON` (`ID`),
  CONSTRAINT `FK_Person_has_Goal_idgoal`
    FOREIGN KEY (`idgoal`)
    REFERENCES `introsde`.`GOAL` (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
