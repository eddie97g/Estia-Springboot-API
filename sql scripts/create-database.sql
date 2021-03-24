DROP DATABASE IF EXISTS `estia`;

CREATE DATABASE `estia`;

USE `estia`;

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(50) UNIQUE NOT NULL,
    `password` varchar(100) NOT NULL,

    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `student` VALUES
(1, 'eddieg', '$2y$12$hSYSttxQX1d/CMMRCzODHu21OZuQm5/erQgtmBm7d/FFBs.X9S5IC');

DROP TABLE IF EXISTS `blacklisted_site`;
CREATE TABLE `blacklisted_site`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `website` varchar(75) NOT NULL,
    `studentID` int(11) NOT NULL,


    PRIMARY KEY (`id`),
    CONSTRAINT `FK_STUDENT_BLACKLIST` FOREIGN KEY (`studentID`)
    REFERENCES `student`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `blacklisted_site` VALUES 
(1, 'youtube.com', 1),
(2, 'reddit.com', 1),
(3, 'twitter.com', 1);

DROP TABLE IF EXISTS `study_preferences`;
CREATE TABLE `study_preferences`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `study_duration` int(4) DEFAULT NULL,
    `study_break_duration` int(4) DEFAULT NULL,
    `studentID` int(11) NOT NULL,

    PRIMARY KEY(`id`),

    CONSTRAINT `FK_STUDENT_SP` FOREIGN KEY (`studentID`)
    REFERENCES `student`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `calendar_event`;
CREATE TABLE `calendar_event`(
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `title` varchar(200) NOT NULL,
    `time_start` DATETIME NOT NULL,
    `time_end` DATETIME NOT NULL,
    `note` varchar(500) DEFAULT NULL,
    `studentID` int(11) NOT NULL,

    PRIMARY KEY(`id`),

    CONSTRAINT `FK_STUDENT_EVENT` FOREIGN KEY (`studentID`)
    REFERENCES `student`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

