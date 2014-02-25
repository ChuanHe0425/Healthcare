CREATE TABLE IF NOT EXISTS `TBLDentalCareCoverage` (
	`DentalID` int(11) NOT NULL AUTO_INCREMENT,
	`DentalCareCoverage` text NOT NULL,
	PRIMARY KEY (`DentalID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `TBLDentalCareCoverage` (`DentalID`, `DentalCareCoverage`) 
VALUES (1, 'DentalIndividual'), (2, 'DentalFamily');