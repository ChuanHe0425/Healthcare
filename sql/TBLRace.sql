CREATE TABLE IF NOT EXISTS `TBLRace` (
	`RaceID` int(11) NOT NULL AUTO_INCREMENT,
	`Race` text NOT NULL,
	PRIMARY KEY (`RaceID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLRace (Race)
VALUES
	('African American/Black'),
	('Asian'),
	('White (Non-Hispanic)'),
	('Hispanic'),
	('American Indian/Alaska Native'),
	('South Asian'),
	('Other');