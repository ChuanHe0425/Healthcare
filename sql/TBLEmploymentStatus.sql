CREATE TABLE IF NOT EXISTS `TBLEmploymentStatus` (
	`EmploymentID` int(11) NOT NULL AUTO_INCREMENT,
	`EmploymentStatus` text NOT NULL,
	PRIMARY KEY (`EmploymentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLEmploymentStatus (EmploymentStatus)
VALUES ('Unemployed'), ('Employed'), ('Retired');