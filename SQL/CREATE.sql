DROP TABLE `role`;
CREATE TABLE `role` (
	`id` INT(11),
	`name` VARCHAR(30),
	PRIMARY KEY(`id`)
);

DROP TABLE `account`;
CREATE TABLE `account` (
	`id` INT(11),
	`username` VARCHAR(50),
	`password` VARCHAR(255),
	PRIMARY KEY(`id`)
);

DROP TABLE `account_role`;
CREATE TABLE `account_role` (
	`id` INT(11),
	`account_id` INT(11),
	`role_id` INT(11),
	PRIMARY KEY (`id`),
	FOREIGN KEY (`account_id`) REFERENCES `account`(`id`) ON DELETE CASCADE,
	FOREIGN KEY (`role_id`) REFERENCES `role`(`id`) ON DELETE CASCADE
);

DROP TABLE `board`;
CREATE TABLE `board` (
	`id` INT(11),
	`title` VARCHAR(255),
	`content` TEXT,
	`hits` INT(11),
	`account_id` INT(11),
	PRIMARY KEY(`id`),
	FOREIGN KEY (`account_id`) REFERENCES `account`(`id`)
);