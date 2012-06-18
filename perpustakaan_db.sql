/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost
 Source Database       : perpustakaan_db

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : utf-8

 Date: 06/19/2012 00:35:40 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authors`
-- ----------------------------
DROP TABLE IF EXISTS `authors`;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `input_date` date NOT NULL,
  `last_update` date NOT NULL,
  `note` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `authors`
-- ----------------------------
BEGIN;
INSERT INTO `authors` VALUES ('3', 'Fauzan Qadri', '2012-06-17', '2012-06-17', 'Test'), ('4', 'Qadri Fauzan', '2012-06-18', '2012-06-19', 'Another Tester Insert tester');
COMMIT;

-- ----------------------------
--  Table structure for `book_categories`
-- ----------------------------
DROP TABLE IF EXISTS `book_categories`;
CREATE TABLE `book_categories` (
  `book_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `FK855EA5322FF20E5F` (`category_id`),
  CONSTRAINT `FK855EA5322FF20E5F` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `book_categories`
-- ----------------------------
BEGIN;
INSERT INTO `book_categories` VALUES ('1', '3'), ('1', '5');
COMMIT;

-- ----------------------------
--  Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `isbn_issn` varchar(255) NOT NULL,
  `note` text NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `input_date` date NOT NULL,
  `last_data_update` date NOT NULL,
  `stock` int(11) NOT NULL,
  `book_location` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK59922AAED2BBC7F` (`author_id`),
  KEY `FK59922AA3F126775` (`publisher_id`),
  CONSTRAINT `FK59922AA3F126775` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK59922AAED2BBC7F` FOREIGN KEY (`author_id`) REFERENCES `authors` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `books`
-- ----------------------------
BEGIN;
INSERT INTO `books` VALUES ('1', 'Belajar JSP dan Hibernate dalam 2 Minggu', '0987654321', 'tester', '3', '3', '', '2012-06-17', '2012-06-18', '11', 'Computer Science 2 1');
COMMIT;

-- ----------------------------
--  Table structure for `categories`
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `input_date` date NOT NULL,
  `last_update` date NOT NULL,
  `note` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `categories`
-- ----------------------------
BEGIN;
INSERT INTO `categories` VALUES ('3', 'Komputer', '2012-06-17', '2012-06-18', 'Update Category'), ('5', 'Science And Technology', '2012-06-19', '2012-06-19', 'Category For Science And Technology');
COMMIT;

-- ----------------------------
--  Table structure for `publishers`
-- ----------------------------
DROP TABLE IF EXISTS `publishers`;
CREATE TABLE `publishers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `note` text NOT NULL,
  `input_date` date NOT NULL,
  `last_update` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `publishers`
-- ----------------------------
BEGIN;
INSERT INTO `publishers` VALUES ('3', 'Penerbit Andi', 'Test', '2012-06-17', '2012-06-17');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
