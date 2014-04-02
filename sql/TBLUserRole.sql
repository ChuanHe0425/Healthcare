CREATE TABLE IF NOT EXISTS `TBLUserRole` (
  `EmailAddress` varchar(45) NOT NULL,
  `RoleName` varchar(45) NOT NULL,
  PRIMARY KEY (`EmailAddress`,`RoleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
