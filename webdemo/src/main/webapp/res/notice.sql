use happyhouse;

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

INSERT INTO notice(userid, subject, content) 
VALUES('admin', '쓰레기 배출 방법 안내문입니다.', '그냥 하세요');

INSERT INTO notice(userid, subject, content) 
VALUES('admin', '뭘 넣어야 잘넣었다고 소문이 날까', '응애');