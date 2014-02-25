CREATE TABLE IF NOT EXISTS `TBLHealthCareCoverage` (
	`HealthID` int(11) NOT NULL AUTO_INCREMENT,
	`HealthCare` text NOT NULL,
	PRIMARY KEY (`HealthID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `TBLHealthCareCoverage` (`HealthID`, `HealthCare`) VALUES
(1, 'HealthIndividual'),
(2, 'HealthFamily');