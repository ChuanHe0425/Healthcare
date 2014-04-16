CREATE TABLE TBLInsuranceCompany (
  `insurance_company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(256) DEFAULT NULL,
  `city` varchar(256) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `representative_name` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`insurance_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO TBLInsuranceCompany (`company_name`, `city`, `state`, `representative_name`)
VALUES
('Insurance R Us','New York','NY','Geoffrey Giraffe'),
('Kinda Coverd','Boston','MA','Uncle Vinnie'),
('Golden Gate Insurers','San Francisco','CA','Danny Tanner'),
('Old Folks LLC','Miami','FL','Lebron James'),
('ObamaCare','Chicago','IL','Barak Obama'),

('Insurance R Us','New York','IL','Geoffrey Giraffe'),
('Kinda Coverd','Boston','NY','Uncle Vinnie'),
('Golden Gate Insurers','San Francisco','MA','Danny Tanner'),
('Old Folks LLC','Miami','CA','Lebron James'),
('ObamaCare','Chicago','FL','Barak Obama'),

('Insurance R Us','New York','MA','Geoffrey Giraffe'),
('Kinda Coverd','Boston','CA','Uncle Vinnie'),
('Golden Gate Insurers','San Francisco','FL','Danny Tanner'),
('Old Folks LLC','Miami','IL','Lebron James'),
('ObamaCare','Chicago','NY','Barak Obama'),

('Insurance R Us','New York','CA','Geoffrey Giraffe'),
('Kinda Coverd','Boston','FL','Uncle Vinnie'),
('Golden Gate Insurers','San Francisco','IL','Danny Tanner'),
('Old Folks LLC','Miami','NY','Lebron James'),
('ObamaCare','Chicago','MA','Barak Obama');