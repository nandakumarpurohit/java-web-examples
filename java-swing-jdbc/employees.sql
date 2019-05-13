CREATE TABLE employees (
  employee_id int(11) NOT NULL AUTO_INCREMENT,
  full_name varchar(75) DEFAULT NULL,
  gender varchar(45) DEFAULT NULL,
  department varchar(45) DEFAULT NULL,
  position varchar(45) DEFAULT NULL,
  salary double DEFAULT NULL,
  PRIMARY KEY (employee_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*LOCK TABLES 'employees' WRITE;*/
/*!40000 ALTER TABLE 'employees' DISABLE KEYS */;

INSERT INTO employees (employee_id, full_name, gender, department, position, salary)
VALUES
	(1,'John Doe','Male','Admin','CEO',6500),
	(2,'Richard Castle','Male','Investigation','Writer',2600),
	(3,'Sheldan Cooper','Male','Lab','Scientist',1300),
	(4,'Penny','Female','Butt Kicking','Chef',120000),
	(106,'New guy','Male','New Dept','New Pos',123123),
	(107,'Usama Awan','Male','SQA','Engineer',40000),
	(108,'Ali Abbas Jaffri','Male','.NET','Software Engineer',100000);

/*!40000 ALTER TABLE 'employees' ENABLE KEYS */;
/*UNLOCK TABLES;*/