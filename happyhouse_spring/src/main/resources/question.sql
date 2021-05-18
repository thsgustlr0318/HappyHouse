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

INSERT INTO question(chk, userid, pwd, subject, content) VALUES(1,'ssafy','ssafy','응애','도와주세요');

INSERT INTO answer(qno, content) VALUES(1,'어림도 없지');