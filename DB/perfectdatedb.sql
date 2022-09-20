-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema perfectdatedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `perfectdatedb` ;

-- -----------------------------------------------------
-- Schema perfectdatedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `perfectdatedb` DEFAULT CHARACTER SET utf8 ;
USE `perfectdatedb` ;

-- -----------------------------------------------------
-- Table `address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `address` ;

CREATE TABLE IF NOT EXISTS `address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NULL,
  `zip` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(45) NOT NULL,
  `lname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `bio` TEXT NULL,
  `role` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `dob` DATE NULL,
  `address_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_address1_idx` (`address_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_user_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `date_night`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `date_night` ;

CREATE TABLE IF NOT EXISTS `date_night` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  `description` VARCHAR(45) NULL,
  `user_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_date_night_user_idx` (`user_id` ASC),
  INDEX `fk_date_night_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_date_night_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_date_night_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `review` ;

CREATE TABLE IF NOT EXISTS `review` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rating` VARCHAR(45) NULL,
  `comment` TEXT NULL,
  `review_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `date_night_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_user1_idx` (`user_id` ASC),
  INDEX `fk_review_date_night1_idx` (`date_night_id` ASC),
  CONSTRAINT `fk_review_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `additional_image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `additional_image` ;

CREATE TABLE IF NOT EXISTS `additional_image` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `image_url` VARCHAR(5000) NULL,
  `review_id` INT NOT NULL,
  `date_night_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_image_review1_idx` (`review_id` ASC),
  INDEX `fk_review_image_date_night1_idx` (`date_night_id` ASC),
  CONSTRAINT `fk_review_image_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `review` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_image_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `categories` ;

CREATE TABLE IF NOT EXISTS `categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `date_night_has_categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `date_night_has_categories` ;

CREATE TABLE IF NOT EXISTS `date_night_has_categories` (
  `date_night_id` INT NOT NULL,
  `categories_id` INT NOT NULL,
  PRIMARY KEY (`date_night_id`, `categories_id`),
  INDEX `fk_date_night_has_categories_categories1_idx` (`categories_id` ASC),
  INDEX `fk_date_night_has_categories_date_night1_idx` (`date_night_id` ASC),
  CONSTRAINT `fk_date_night_has_categories_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_date_night_has_categories_categories1`
    FOREIGN KEY (`categories_id`)
    REFERENCES `categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wishlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `wishlist` ;

CREATE TABLE IF NOT EXISTS `wishlist` (
  `user_id` INT NOT NULL,
  `date_night_id` INT NOT NULL,
  INDEX `fk_wishlist_user1_idx` (`user_id` ASC),
  INDEX `fk_wishlist_date_night1_idx` (`date_night_id` ASC),
  CONSTRAINT `fk_wishlist_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_wishlist_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog` ;

CREATE TABLE IF NOT EXISTS `blog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comments` VARCHAR(5000) NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_has_user` ;

CREATE TABLE IF NOT EXISTS `blog_has_user` (
  `blog_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`blog_id`, `user_id`),
  INDEX `fk_blog_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_blog_has_user_blog1_idx` (`blog_id` ASC),
  CONSTRAINT `fk_blog_has_user_blog1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `blog` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS perfectdate@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'perfectdate'@'localhost' IDENTIFIED BY 'perfectdate';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'perfectdate'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `user` (`id`, `fname`, `lname`, `email`, `username`, `password`, `image_url`, `bio`, `role`, `enabled`, `dob`, `address_id`) VALUES (1, 'tom', 'tom', 'tom@mail.com', 'admin', 'admin', NULL, NULL, 'ADMIN', 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `categories`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `categories` (`id`, `name`) VALUES (1, 'romantic');
INSERT INTO `categories` (`id`, `name`) VALUES (2, 'relaxing');
INSERT INTO `categories` (`id`, `name`) VALUES (3, 'first_date');
INSERT INTO `categories` (`id`, `name`) VALUES (4, 'second_date');
INSERT INTO `categories` (`id`, `name`) VALUES (5, 'adventure');
INSERT INTO `categories` (`id`, `name`) VALUES (6, 'wilderness');
INSERT INTO `categories` (`id`, `name`) VALUES (7, 'extreme');
INSERT INTO `categories` (`id`, `name`) VALUES (8, 'shows');
INSERT INTO `categories` (`id`, `name`) VALUES (9, 'get_out_frustrations');

COMMIT;

