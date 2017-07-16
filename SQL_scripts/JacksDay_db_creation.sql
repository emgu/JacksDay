CREATE DATABASE JacksDay_db;

CREATE TABLE `activity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `timestamp` timestamp NOT NULL,
  `datetime` datetime NOT NULL,
  `name` varchar(45) NOT NULL,
  `details` varchar(45) NOT NULL,
  `icon` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table `activity`

INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('02:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('3:33', 'spanie', '30min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('4:34', 'spanie', '50min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('8:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('12:03', 'spanie', '30min');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('15:33', 'spanie', '1,5h');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('20:33', 'jedzenie', '50ml mlenia');
INSERT INTO activities (`action_time`, `action_title`, `action_detail`) VALUES ('22:33', 'jedzenie', '50ml mlenia');



