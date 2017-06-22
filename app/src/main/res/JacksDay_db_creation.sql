CREATE DATABASE JacksDay_db;

CREATE TABLE `activities` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `action_time` varchar(45) NOT NULL,
  `action_title` varchar(45) NOT NULL,
  `action_icon` varchar(45) NOT NULL,
  PRIMARY KEY (`action_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('02:33', 'jedzenie', '50ml mlenia')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('3:33', 'spanie', '30min')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('4:34', 'spanie', '50min')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('8:33', 'jedzenie', '50ml mlenia')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('12:03', 'spanie', '30min')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('15:33', 'spanie', '1,5h')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('20:33', 'jedzenie', '50ml mlenia')
INSERT INTO activities (`action_time`, `action_title`, `action_icon`) VALUES ('22:33', 'jedzenie', '50ml mlenia')



