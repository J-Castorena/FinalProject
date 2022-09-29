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
  `city` VARCHAR(45) NULL,
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
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `image_url` VARCHAR(9000) NULL,
  `biography` TEXT NULL,
  `role` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  `date_of_birth` DATE NULL,
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
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `image_url` VARCHAR(2000) NULL,
  `description` TEXT NULL,
  `user_id` INT NOT NULL,
  `address_id` INT NULL,
  `created_date` DATETIME NULL,
  `last_updated_date` DATETIME NULL,
  `active` TINYINT NULL,
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
  `rating` SMALLINT NULL,
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
  `image_url` VARCHAR(10000) NULL,
  `review_id` INT NOT NULL,
  `caption` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_review_image_review1_idx` (`review_id` ASC),
  CONSTRAINT `fk_review_image_review1`
    FOREIGN KEY (`review_id`)
    REFERENCES `review` (`id`)
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
  `comments` TEXT NULL,
  `blog_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `title` VARCHAR(200) NULL,
  `active` TINYINT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_blog_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_blog_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `datenight_discussion_board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `datenight_discussion_board` ;

CREATE TABLE IF NOT EXISTS `datenight_discussion_board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `comment` TEXT NULL,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `date_night_id` INT NOT NULL,
  `datenight_discussion_board_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_datenight_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_datenight_comment_date_night1_idx` (`date_night_id` ASC),
  INDEX `fk_datenight_discussion_board_datenight_discussion_board1_idx` (`datenight_discussion_board_id` ASC),
  CONSTRAINT `fk_datenight_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_datenight_comment_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_datenight_discussion_board_datenight_discussion_board1`
    FOREIGN KEY (`datenight_discussion_board_id`)
    REFERENCES `datenight_discussion_board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `blog_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `blog_comment` ;

CREATE TABLE IF NOT EXISTS `blog_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `blog_comment` TEXT NOT NULL,
  `blog_comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `blog_id` INT NOT NULL,
  `blog_comment_id` INT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_blog_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_blog_comment_blog1_idx` (`blog_id` ASC),
  INDEX `fk_blog_comment_blog_comment1_idx` (`blog_comment_id` ASC),
  CONSTRAINT `fk_blog_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_comment_blog1`
    FOREIGN KEY (`blog_id`)
    REFERENCES `blog` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_blog_comment_blog_comment1`
    FOREIGN KEY (`blog_comment_id`)
    REFERENCES `blog_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `category` ;

CREATE TABLE IF NOT EXISTS `category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `img_url` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `date_night_has_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `date_night_has_category` ;

CREATE TABLE IF NOT EXISTS `date_night_has_category` (
  `date_night_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`date_night_id`, `category_id`),
  INDEX `fk_date_night_has_category_category1_idx` (`category_id` ASC),
  INDEX `fk_date_night_has_category_date_night1_idx` (`date_night_id` ASC),
  CONSTRAINT `fk_date_night_has_category_date_night1`
    FOREIGN KEY (`date_night_id`)
    REFERENCES `date_night` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_date_night_has_category_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `category` (`id`)
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
-- Data for table `address`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (1, '210 Peachtree St NW', 'Atlanta', 'GA', '30303');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (2, '2333 Delray Rd', 'Thomaston', 'GA', '30286');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (3, '1717 Hwy 255 S', 'Cleveland', 'GA', '30528');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (4, '401 N River St', 'Glenwood Springs', 'CO', '81601');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (5, '2345 Somewhere Rd', 'Atlanta', 'GA', '30044');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (6, '2365 Lunar Ct', 'Buckhead', 'GA', '30305');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (7, '9863 Oakland Hwy', 'Norcross', 'GA', '30056');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (8, '673587 Harrys St', 'Midtown', 'CO', '67834');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (9, '46382 Arcado Rd', 'Lilburn', 'TX', '45629');
INSERT INTO `address` (`id`, `street`, `city`, `state`, `zip`) VALUES (10, '635 Miami Way', 'Buford', 'CA', '37494');

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (1, 'Steph', 'Karlsen', 'steph@mail.com', 'admin1', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', NULL, 'admin', 1, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (2, 'Jordy', 'Castorena', 'jordy@mail.com', 'admin2', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', NULL, 'admin', 1, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (3, 'Diego', 'Escutia', 'diego@mail.com', 'admin3', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', NULL, 'admin', 1, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (4, 'Liam', 'Smith', 'laim@mail.com', 'daisyliam12', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ipsum dolor sit amet consectetur adipiscing elit duis. Etiam sit amet nisl purus in mollis nunc sed. Quisque non tellus orci ac auctor augue mauris. Odio ut sem nulla pharetra.', 'user', 1, NULL, 1);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (5, 'Noah', 'Brown', 'noah@mail.com', 'noahtrace', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Mumblecore whatever occupy, fingerstache bicycle rights bodega boys viral 3 wolf moon. Master cleanse four dollar toast art party, bespoke salvia cornhole keytar. Actually swag chicharrones pour-over. Normcore pickled skateboard hashtag messenger bag cronut tbh iPhone. Chia tacos neutra shaman vape, fanny pack next level hot chicken 8-bit swag organic woke tote bag fit. Pinterest woke XOXO post-ironic jean shorts pug prism, authentic chillwave bushwick flannel enamel pin.', 'user', 1, NULL, 2);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (6, 'Olivia', 'Garcia', 'olivia@mail.com', 'BubblyOlivia2', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Cupcake ipsum dolor. Sit amet marshmallow topping cheesecake muffin. Halvah croissant candy canes bonbon candy. Apple pie jelly beans topping carrot cake danish tart cake cheesecake. Muffin danish chocolate soufflé pastry icing bonbon oat cake. Powder cake jujubes oat cake. Lemon drops tootsie roll marshmallow halvah carrot cake.', 'user', 1, NULL, 3);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (7, 'Steve', 'Thompson', 'steve@mail.com', 'richessteve87', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Busey ipsum dolor sit amet. Have you urinated? Have you drained your bladder? Are you free? Because if you haven\'t it will only come out later. I\'m giving you some information that your bodily fluids may penetrate your clothing fibre\'s without warning.It\'s OK to get Rib-grease on your face, because you\'re allowing people to see that you\'re proud of these ribs.', 'user', 1, NULL, 4);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (8, 'John', 'Risus', 'john@mail.com', 'risusKing', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Tincidunt dui ut ornare lectus sit amet est. Tristique risus nec feugiat in fermentum posuere urna nec. Pharetra pharetra massa massa ultricies mi quis hendrerit dolor', 'user', 1, NULL, 5);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (9, 'Carlos', 'Shupas', 'carlos@mail.com', 'carlosYeking', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Eu facilisis sed odio morbi quis commodo odio aenean sed. Lectus magna fringilla urna porttitor rhoncus. Rhoncus est pellentesque elit ullamcorper dignissim. Nam libero justo laoreet sit. Lorem ipsum dolor sit amet consectetur adipiscing elit. Donec pretium vulputate sapien nec. Tincidunt ornare massa eget egestas purus viverra accumsan. Pellentesque id nibh tortor id aliquet lectus proin.', 'user', 1, NULL, 6);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `image_url`, `biography`, `role`, `enabled`, `date_of_birth`, `address_id`) VALUES (10, 'Lee', 'Chang', 'lee@mail.com', 'Wher2Go', '$2a$10$hesaarzZt.BcMRyrML4cMeB96hmWwAS3t4R7KcFrwHL0K1CyLI.T6', '', 'Cras adipiscing enim eu turpis egestas pretium. Viverra nibh cras pulvinar mattis nunc sed. At augue eget arcu dictum varius. Maecenas pharetra convallis posuere morbi leo urna molestie at. In aliquam sem fringilla ut morbi tincidunt augue. In hac habitasse platea dictumst quisque sagittis purus. Laoreet sit amet cursus sit amet dictum sit amet. Integer malesuada nunc vel risus', 'user', 1, NULL, 7);

COMMIT;


-- -----------------------------------------------------
-- Data for table `date_night`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (1, 'Yonah Mountain Vineyards', 'https://image.dynamixse.com/cdno/n/webp.q80.png-lossy-85/https://octanecdn.com/yonahmountainvineyardscom/yonahmountainvineyardscom_351586084.jpg', 'premium tour experience that takes our guests throughout our winery and barrel-aging wine caves. Tour guides may include owners Bob or Eric Miller, or an expert Yonah Mountain Vineyards\' staff member.\n\npremium tour experience that takes our guests throughout our winery and barrel-aging wine caves. Tour guides may include owners Bob or Eric Miller, or an expert Yonah Mountain Vineyards\' staff member.\n\npremium tour experience that takes our guests throughout our winery and barrel-aging wine caves. Tour guides may include owners Bob or Eric Miller, or an expert Yonah Mountain Vineyards\' staff member.\n\npremium tour experience that takes our guests throughout our winery and barrel-aging wine caves. Tour guides may include owners Bob or Eric Miller, or an expert Yonah Mountain Vineyards\' staff member.\n\n', 4, 2, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (2, 'Tandem Skydiving', 'https://www.skydiveatlanta.com/wp-content/uploads/2019/01/tandem.jpg', 'Tandem skydiving is the most popular way to experience skydiving for first timers. With less than 30 minutes training you can jump attached to an expert instructor.', 5, 3, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (3, 'Sun Dial Restaurant', 'https://images.squarespace-cdn.com/content/v1/5a1c363cf14aa168f5288db9/1531425741368-MIJPEQ7NMGVD5VNH6TJO/image-asset.jpeg?format=1500w', 'Situated on the uppermost floors of The Westin Peachtree Plaza, The Sun Dial Restaurant, Bar & View offers unparalleled views and a distinct Atlanta dining experience that makes the most of the city’s proximity to local, farm-to-table ingredients. A tri-level complex, The Sun Dial features an upscale restaurant, a cocktail lounge and an observatory level with a breathtaking 360-degree panorama of the magnificent skyline from 723 feet above.', 6, 1, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (4, 'Glenwood Hot Spring Pool', 'https://www.hotspringspool.com/sites/default/files/styles/gallery_full/public/images/ghs_couple_on_steps_25821_Web.jpg?itok=3fpq6U-J', 'Mother nature’s great creations provide even greater rewards. After hitting the scenic hikes and trails, ease every well-earned ache in the world’s largest hot springs pool, open year-round. Soak in natural heated water with 15 minerals to re-energize and renew tired muscles', 4, 4, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (5, 'Le Bilboquet', 'https://www.atlantaeats.com/wp-content/uploads/2021/10/rock-steady.jpg', 'Enjoy top tier French cuisine in their light and airy dining room, or on their gorgeous patio on a summer day. Whatever you do, don’t skip dessert! Their pastries are to die for. You can even make a whole evening out of it with a meander around Buckhead Village!', 7, 5, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (6, 'Rock Steady', 'https://www.atlantaeats.com/wp-content/uploads/2020/01/garden-room-interior.jpg', 'This West Midtown/Georgia Tech spot is a must for date night! Jerk chicken sliders, oxtail pappardelle, brown stew lamb shank… are you salivating yet? The interiors are gorgeous, with an eclectic mix of modern and island touches that lend to its modern Caribbean fare. The service is fantastic, and there’s a selection of drinks with Caribbean flavors too, like their “Mr. Killa” with Appleton 12 rum, Habanero Tamarind Curry, Lemon, and Pineapple or their guava lemonade. There’s some valet parking as well as street parking.', 7, 6, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (7, 'Tiny Lou’s', 'https://www.atlantaeats.com/wp-content/uploads/2019/07/gypsykitchen-patio.jpg', 'Enjoy classic French fare with a visit to Tiny Lou’s in the newly renovated Hotel Clermont. We love their intimate and sexy atmosphere with vintage inspired decor that nods to the past. The pastries are also of note, from Young Gun Claudia Martinez.', 4, 7, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (8, 'St. Cecilia', 'https://www.atlantaeats.com/wp-content/uploads/2020/01/wonderkid-interior-blog.jpg', 'Another Chef Ford Fry spot, St. Cecilia is a great date night spot for freshly made pasta. High ceilings, excellent service, and fresh crudo that’ll delight your senses. It’s totally worth it for the complimentary focaccia bread alone. You and your date will love this elegant, airy Italian option!', 5, 8, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (9, 'Wonderkid', 'https://www.atlantaeats.com/wp-content/uploads/2021/01/ruby-chow-interior.jpg', 'Take a trip through time with a trip to Wonderkid–a true treat if you’re dating a vintage loving lady. Romantic doesn’t have to mean fancy and expensive–think sexy, 70s vibes with an unfancy and affordable homegrown diner menu. Unlike the diners you or your parents may have grown up with, there’s an expansive and inventive cocktail menu you and your date will enjoy imbibing. A truly special place in the heart of the Atlanta Dairies complex, make this place your next date night go-to. ', 6, 9, NULL, NULL, 1);
INSERT INTO `date_night` (`id`, `name`, `image_url`, `description`, `user_id`, `address_id`, `created_date`, `last_updated_date`, `active`) VALUES (10, 'Ray’s on the River', 'https://www.atlantaeats.com/wp-content/uploads/2021/01/forza-storico-patio.jpg', 'Ray’s on the River in Sandy Springs is one of those rare places where the food is matched by the beautiful view. Set against the Chattahoochee just west of Northside Drive, Rays brings a fine-dining touch to a tranquil corner of the city. Ray’s menu includes reasonably priced lunches and a couple of steaks that top $30, so whatever your reason for stopping by, your wallet will feel less stretched than your belly. If you’re looking for a table with a river view, be sure to get there early.', 5, 10, NULL, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `review`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (1, 3, 'nice view, food is bland', '2022-01-25', 4, 3);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (2, 5, 'excellent wine options and great flavor', '2022-03-14', 5, 1);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (3, 4, 'nice thrill ', '2022-02-01', 6, 2);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (4, 5, 'nice relaxing afternoon', '2022-02-19', 4, 4);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (5, 4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Pretium aenean pharetra magna ac placerat vestibulum lectus mauris ultrices. Tempus urna et pharetra pharetra massa.', '2022-04-28', 6, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (6, 5, 'Amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Egestas maecenas pharetra convallis posuere morbi leo urna. Aliquam eleifend mi in nulla. Consequat ac felis donec et.', '2022-07-08', 4, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (7, 3, 'Dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Egestas maecenas pharetra convallis posuere morbi leo urna. Aliquam eleifend mi in nulla. Consequat ac felis donec et.', '2022-08-20', 5, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (8, 4, 'Quis viverra nibh cras pulvinar mattis nunc sed. Congue eu consequat ac felis donec et odio pellentesque. Nunc sed blandit libero volutpat sed cras ornare. ', '2022-09-05', 8, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (9, 2, 'Fermentum leo vel orci porta non pulvinar. Et odio pellentesque diam volutpat commodo sed egestas egestas. Vulputate eu scelerisque felis imperdiet proin fermentum', '2022-06-09', 9, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (10, 5, 'At elementum eu facilisis sed odio. Quis blandit turpis cursus in hac habitasse. Ut morbi tincidunt augue interdum velit. Dignissim convallis aenean et tortor at risus viverra adipiscing at', '2022-09-25', 7, 5);
INSERT INTO `review` (`id`, `rating`, `comment`, `review_date`, `user_id`, `date_night_id`) VALUES (11, 5, 'Tempus egestas sed sed risus pretium. Nunc aliquet bibendum enim facilisis gravida neque convallis', '2022-09-28', 10, 5);

COMMIT;


-- -----------------------------------------------------
-- Data for table `additional_image`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (1, 'https://image.dynamixse.com/crop/350x500/webp.q80.png-lossy-85/https://octanecdn.com/yonahmountainvineyardscom/yonahmountainvineyardscom_976402161.jpg', 2, 'winery');
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (2, 'data:image/jpeg;base64,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', 3, 'skydive');
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (3, 'https://www.travelandleisure.com/thmb/4T9F7Hm31MyCuVaPePsCjf_nnxU=/1800x1012/smart/filters:no_upscale()/chena-hot-springs-resort-fairbanks-alaska-HOTSPRINGSUS1020-a9f34b93cd4544228c706a8eb1f9e852.jpg', 4, 'hotspring');
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (4, 'https://images.pexels.com/photos/958545/pexels-photo-958545.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1', 5, NULL);
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (5, 'https://images.pexels.com/photos/370984/pexels-photo-370984.jpeg?auto=compress&cs=tinysrgb&w=400', 6, NULL);
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (6, 'https://images.pexels.com/photos/1537635/pexels-photo-1537635.jpeg?auto=compress&cs=tinysrgb&w=400', 7, NULL);
INSERT INTO `additional_image` (`id`, `image_url`, `review_id`, `caption`) VALUES (7, 'https://images.pexels.com/photos/590477/pexels-photo-590477.jpeg?auto=compress&cs=tinysrgb&w=400', 8, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `wishlist`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `wishlist` (`user_id`, `date_night_id`) VALUES (4, 1);
INSERT INTO `wishlist` (`user_id`, `date_night_id`) VALUES (5, 3);
INSERT INTO `wishlist` (`user_id`, `date_night_id`) VALUES (6, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `blog`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (1, 'I live in the lawrenceville area are there any good couples massage places nearby?', '2022-01-02', 4, 'Good massage place', 1, NULL);
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (2, 'Are the any places near Atlanta that i should avoid to safety?', '2022-02-04', 6, 'Safety', 1, NULL);
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (3, 'Top breweries in denver? ', '2022-03-05', 5, 'Beer', 1, NULL);
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (4, 'What are some of the Best Steakhouses in Los Angeles?', '2022-04-06', 6, 'Craving Steak!', 1, NULL);
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (5, 'Looking for a Romatinc bar in the Boulder area', '2022-05-07', 7, 'Romatic bar', 1, NULL);
INSERT INTO `blog` (`id`, `comments`, `blog_date`, `user_id`, `title`, `active`, `image_url`) VALUES (6, 'My 15th Anniversary approches, and I dont know what to do!', '2022-06-08', 8, 'Anniversary Ideas', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `datenight_discussion_board`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `datenight_discussion_board` (`id`, `comment`, `comment_date`, `user_id`, `date_night_id`, `datenight_discussion_board_id`) VALUES (1, 'Is this place still rad?', NULL, 4, 1, 1);
INSERT INTO `datenight_discussion_board` (`id`, `comment`, `comment_date`, `user_id`, `date_night_id`, `datenight_discussion_board_id`) VALUES (2, 'who much does it cost per person to skydive? ', NULL, 6, 2, 2);
INSERT INTO `datenight_discussion_board` (`id`, `comment`, `comment_date`, `user_id`, `date_night_id`, `datenight_discussion_board_id`) VALUES (3, 'I was told sometimes birds crash in the windows while you\'re dinning', NULL, 5, 3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `blog_comment`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (1, 'try Massage Oasis near hwy 29. One of my favorite places. ', '2022-01-14', 8, 1, NULL, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (2, 'I always to golden massage in buford rd. They give you wine with your couples massage. ', '2022-01-15', 6, 1, NULL, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (3, 'I thought oasis was dirty', '2022-01-18', 5, 1, 1, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (4, 'If you value your life stay away from west Atlanta', '2022-02-08', 6, 2, NULL, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (5, 'Just avoid Atlanta at all costs. Its dirty anyways', '2022-02-09', 4, 2, NULL, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (6, 'I think Atlanta is a nice city if you know where to go. ', '2022-02-15', 5, 2, NULL, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (7, 'what are you talking about? Its so crowed and unsafe', '2022-02-17', 4, 2, 1, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (8, '1. New Belgium, 2. BlueMoon, 3. Great Divide Brewing', '2022-03-10', 3, 3, 1, NULL);
INSERT INTO `blog_comment` (`id`, `blog_comment`, `blog_comment_date`, `user_id`, `blog_id`, `blog_comment_id`, `image_url`) VALUES (9, 'Go to Relaxed Body, they have the best prices and top notch service. ', '2022-01-19', 7, 1, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `category`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (1, 'Romantic', 'https://images.pexels.com/photos/2418920/pexels-photo-2418920.jpeg?auto=compress&cs=tinysrgb&w=300');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (2, 'First Date', 'https://i.postimg.cc/5tsMYzSQ/coffe.webp');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (3, 'Second Date', 'https://i.postimg.cc/nr2VHLhn/balloon.webp');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (4, 'Relaxing', 'https://i.postimg.cc/q7j3Zm4b/spa.jpg');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (5, 'Adventure', 'https://i.postimg.cc/7LB71WbV/zz.jpg');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (6, 'Extreme', 'https://i.postimg.cc/RhZ7xx82/x.webp');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (7, 'Wilderness', 'https://images.pexels.com/photos/4099305/pexels-photo-4099305.jpeg?auto=compress&cs=tinysrgb&w=300');
INSERT INTO `category` (`id`, `name`, `img_url`) VALUES (8, 'Shows', 'https://i.postimg.cc/HnJvLc6m/shows.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `date_night_has_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `perfectdatedb`;
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (1, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (2, 7);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (3, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (4, 2);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (5, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (6, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (7, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (8, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (9, 1);
INSERT INTO `date_night_has_category` (`date_night_id`, `category_id`) VALUES (10, 1);

COMMIT;

