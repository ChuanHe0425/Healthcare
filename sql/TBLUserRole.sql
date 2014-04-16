CREATE TABLE IF NOT EXISTS `TBLUserRole` (
  `email` varchar(45) NOT NULL,
  `RoleName` varchar(45) NOT NULL,
  PRIMARY KEY (`email`,`RoleName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
