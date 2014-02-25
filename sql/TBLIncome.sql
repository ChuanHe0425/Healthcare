CREATE TABLE `TBLIncome` (
	`IncomeID` int(11) NOT NULL AUTO_INCREMENT,
	`Income` text NOT NULL,
	PRIMARY KEY (`IncomeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `TBLIncome` (`IncomeID`, `Income`) VALUES
(1, '0-30000'),
(2, '30001-50000'),
(3, '50001-75000'),
(4, '75001-100000'),
(5, '100001+');