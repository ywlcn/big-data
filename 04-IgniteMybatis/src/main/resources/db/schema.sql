
CREATE TABLE IF NOT EXISTS student (
  `studId` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `dob` DATETIME,
  PRIMARY KEY (`studId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

CREATE TABLE IF NOT EXISTS grade (
  `studId` int(11) NOT NULL,
	grade DOUBLE,
	PRIMARY KEY (studId)
) ENGINE=MyISAM DEFAULT CHARSET=utf8

