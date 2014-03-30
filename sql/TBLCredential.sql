CREATE TABLE TBLCredential (
  `credential_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(256) DEFAULT NULL,
  `representative_id` int(11) DEFAULT NULL,
  `applicant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`credential_id`),
  KEY `fk_applicant_id` (`applicant_id`),
  KEY `fk_representative_id` (`representative_id`),
  CONSTRAINT `fk_representative_id` FOREIGN KEY (`representative_id`) REFERENCES `TBLRepresentative` (`representative_id`),
  CONSTRAINT `fk_applicant_id` FOREIGN KEY (`applicant_id`) REFERENCES `TBLApplicant` (`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;