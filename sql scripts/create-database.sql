DROP DATABASE IF EXISTS `estia`;

CREATE DATABASE `estia`;

USE `estia`;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
    `username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL,

    PRIMARY KEY (`username`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `blacklisted_site`;
CREATE TABLE `blacklisted_sites`(
    `website` varchar(75) NOT NULL,
    `student_username` varchar(50) NOT NULL,


    PRIMARY KEY (`website`),
    CONSTRAINT `FK_STUDENT_BLACKLIST` FOREIGN KEY (`student_username`)
    REFERENCES `student`(`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `study_preferences`;
CREATE TABLE `study_preferences`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `study_duration` int(4) DEFAULT NULL,
    `study_break_duration` int(4) DEFAULT NULL,
    `student_username` varchar(50) NOT NULL,

    PRIMARY KEY(`id`),

    CONSTRAINT `FK_STUDENT_SP` FOREIGN KEY (`student_username`)
    REFERENCES `student`(`username`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `calendar_event`;
CREATE TABLE `calendar_event`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(200) NOT NULL,
    `time_start` DATETIME NOT NULL,
    `time_end` DATETIME NOT NULL,
    `note` varchar(500) DEFAULT NULL,
    `student_username` varchar(50) NOT NULL,

    PRIMARY KEY(`id`),

    CONSTRAINT `FK_STUDENT_EVENT` FOREIGN KEY (`student_username`)
    REFERENCES `student`(`username`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

