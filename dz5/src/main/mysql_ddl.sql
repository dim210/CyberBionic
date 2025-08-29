use itvdn_tr;
drop table if exists `carsmarket`;

CREATE TABLE `carsmarket` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) NOT NULL,
  `model_name` varchar(50) NOT NULL,
  `price` double DEFAULT '0',
 -- `rec_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
  -- ,
 -- KEY `idx_carsmarket_brand_name` (`brand_name`),
 -- KEY `idx_carsmarket_model_name` (`model_name`),
 -- KEY `idx_carsmarket_brand_model_name` (`brand_name`,`model_name`)
);

INSERT INTO `itvdn_tr`.`carsmarket` (`brand_name`,`model_name`,`price`) VALUES ('volkswagen','golf7',34000.45);
INSERT INTO `itvdn_tr`.`carsmarket` (`brand_name`,`model_name`,`price`) VALUES ('BMW','X3',46123.45);

------- test scheme
use itvdn_test;
drop table if exists `carsmarket`;

CREATE TABLE `carsmarket` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(50) NOT NULL,
  `model_name` varchar(50) NOT NULL,
  `price` double DEFAULT '0',
 -- `rec_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
  -- ,
 -- KEY `idx_carsmarket_brand_name` (`brand_name`),
 -- KEY `idx_carsmarket_model_name` (`model_name`),
 -- KEY `idx_carsmarket_brand_model_name` (`brand_name`,`model_name`)
);

INSERT INTO `itvdn_test`.`carsmarket` (`brand_name`,`model_name`,`price`) VALUES ('volkswagen','golf7',34000.45);
INSERT INTO `itvdn_test`.`carsmarket` (`brand_name`,`model_name`,`price`) VALUES ('BMW','X3',46123.45);