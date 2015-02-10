CREATE SCHEMA `auto` ;

CREATE TABLE `auto`.`brand` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC));

INSERT INTO auto.brand (name) VALUES
('Audi'), ('Bentley'), ('BMW'), ('Chevrolet'), ('Chrysler'), ('Citroen'), ('Daewoo'), ('Dodge'), ('Skoda');