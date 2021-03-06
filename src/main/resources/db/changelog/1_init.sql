--liquibase formatted sql

CREATE DATABASE IF NOT  EXISTS `zayets_bot` DEFAULT CHARACTER SET utf8;
GO

CREATE TABLE `zayets_bot`.`bot_setting` (
  `bot_name` VARCHAR(255) NOT NULL,
  `telegram_bot_id` VARCHAR(255) NOT NULL,
  `token` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`bot_name`));
GO

CREATE TABLE IF NOT  EXISTS `zayets_bot`.`actions` (
  `action_id` int(11) NOT NULL AUTO_INCREMENT,
  `text` longtext NOT NULL,
  `parent_action_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`action_id`))
  ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Messages to show for users. Can contain reference to parent action';
GO

CREATE TABLE IF NOT  EXISTS `zayets_bot`.`user_last_actions` (
  `user_chat_id` INT NOT NULL,
  `last_action_id` INT NOT NULL,
  PRIMARY KEY (`user_chat_id`),
  INDEX `actionFK_idx` (`last_action_id` ASC),
  CONSTRAINT `actionFK`
    FOREIGN KEY (`last_action_id`)
    REFERENCES `zayets_bot`.`actions` (`action_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
GO
