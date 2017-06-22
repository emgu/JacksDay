CREATE DATABASE JacksDay_db;

CREATE TABLE `activities` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `action_date` varchar(45) NOT NULL,
  `action_time` varchar(45) NOT NULL,
  `action_title` varchar(45) NOT NULL,
  `action_detail` varchar(45) NOT NULL,
  `action_icon` varchar(45) NOT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('02:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('3:33', 'spanie', '30min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('4:34', 'spanie', '50min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('8:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('12:03', 'spanie', '30min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('15:33', 'spanie', '1,5h');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('20:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('22:33', 'jedzenie', '50ml mlenia');



