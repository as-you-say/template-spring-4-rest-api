DROP TABLE `board`;
DROP TABLE `account_role`;
DROP TABLE `role`;
DROP TABLE `account`;

CREATE TABLE `role` (
	`id` INT(11) AUTO_INCREMENT,
	`name` VARCHAR(30) UNIQUE,
	PRIMARY KEY(`id`)
);

CREATE TABLE `account` (
	`id` INT(11) AUTO_INCREMENT,
	`username` VARCHAR(50) UNIQUE,
	`password` VARCHAR(255),
	PRIMARY KEY(`id`)
);

CREATE TABLE `account_role` (
	`id` INT(11) AUTO_INCREMENT,
	`account_id` INT(11),
	`role_id` INT(11),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`account_id`) REFERENCES `account`(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`role_id`) REFERENCES `role`(`id`) ON DELETE CASCADE
);

CREATE TABLE `board` (
	`id` INT(11) AUTO_INCREMENT,
	`title` VARCHAR(255),
	`content` TEXT,
	`hits` INT(11),
	`account_id` INT(11),
	PRIMARY KEY(`id`),
	FOREIGN KEY (`account_id`) REFERENCES `account`(`id`)
);