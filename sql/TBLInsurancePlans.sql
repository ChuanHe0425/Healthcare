CREATE TABLE IF NOT EXISTS `TBLInsurancePlans` (
	`PlanID` int(11) NOT NULL AUTO_INCREMENT,
	`PlanType` text NOT NULL,
	PRIMARY KEY (`PlanID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLInsurancePlans (PlanType)
VALUES ('Basic'), ('Extended Basic'), ('Premium');