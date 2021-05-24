use happyhouse;

CREATE TABLE IF NOT EXISTS `happyhouse`.`question` (
  `qno` INT NOT NULL AUTO_INCREMENT,
  `chk` VARCHAR(16) NOT NULL,
  `userid` VARCHAR(16) NOT NULL,
  `pwd` VARCHAR(16),
  `subject` VARCHAR(100) NOT NULL,
  `img` VARCHAR(100),
  `content` VARCHAR(2000) NOT NULL,
  `hit` INT DEFAULT 0,
  `time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `question_userid_FK_idx` (`userid` ASC) VISIBLE,
  PRIMARY KEY (`qno`),
  CONSTRAINT `question_userid_FK`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `answer` (
  `ano` INT NOT NULL AUTO_INCREMENT,
  `qno` INT,
  `content` VARCHAR(2000) NOT NULL,
  `time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `question_qno_FK_idx` (`qno` ASC) VISIBLE,
  PRIMARY KEY (`ano`),
  CONSTRAINT `question_qno_FK`
    FOREIGN KEY (`qno`)
    REFERENCES `happyhouse`.`question` (`qno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `happyhouse`.`notice` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `userid` VARCHAR(16) NOT NULL,
  `subject` VARCHAR(100) NOT NULL,
  `img` VARCHAR(100),
  `content` VARCHAR(2000) NOT NULL,
  `hit` INT DEFAULT 0,
  `time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  INDEX `notice_userid_FK_idx` (`userid` ASC) VISIBLE,
  PRIMARY KEY (`no`),
  CONSTRAINT `notice_userid_FK`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

drop table noticefile;
CREATE TABLE IF NOT EXISTS `happyhouse`.`noticefile` (
  `fileno` INT NOT NULL AUTO_INCREMENT,
  `no` INT,
  `originalfilename` VARCHAR(255) NOT NULL,
  `filename` VARCHAR(255) NOT NULL,
  `filepath` VARCHAR(255) NOT NULL,
  INDEX `noticefile_no_FK_idx` (`no` ASC) VISIBLE,
  PRIMARY KEY (`fileno`),
  CONSTRAINT `notice_no_FK`
    FOREIGN KEY (`no`)
    REFERENCES `happyhouse`.`notice` (`no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

drop table qnafile;
CREATE TABLE IF NOT EXISTS `happyhouse`.`qnafile` (
  `fileno` INT NOT NULL AUTO_INCREMENT,
  `qno` INT,
  `originalfilename` VARCHAR(255) NOT NULL,
  `filename` VARCHAR(255) NOT NULL,
  `filepath` VARCHAR(255) NOT NULL,
  INDEX `qnafile_qno_FK_idx` (`qno` ASC) VISIBLE,
  PRIMARY KEY (`fileno`),
  CONSTRAINT `qnafile_qno_FK`
    FOREIGN KEY (`qno`)
    REFERENCES `happyhouse`.`question` (`qno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


select * 
from noticefile
where no=1;

INSERT INTO question(chk, userid, pwd, subject, content) VALUES(1,'ssafy','ssafy','응애','도와주세요');

INSERT INTO answer(qno, content) VALUES(1,'어림도 없지');