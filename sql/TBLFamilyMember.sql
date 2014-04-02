CREATE TABLE IF NOT EXISTS `TBLFamilyMember` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LastName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Age` int(11) DEFAULT NULL,
  `Customer` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Customer_idx` (`Customer`),
  CONSTRAINT `FK_Customer` FOREIGN KEY (`Customer`) REFERENCES `TBLCustomer` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;;
