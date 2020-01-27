DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `salary` varchar(20) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
);

insert into  `employee` (id,name,salary,department,created_by,created_at) VALUES (1,'Sohan', '20000', 'tech','admin@cars24.com',now()); 
insert into  `employee` (id,name,salary,department,created_by,created_at) VALUES (2,'Sohan1', '20000', 'tech','admin@cars24.com',now());
insert into  `employee` (id,name,salary,department,created_by,created_at) VALUES (3,'Sohan2', '20000', 'tech','admin@cars24.com',now());
