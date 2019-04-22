-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.13-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping data for table magazinedb.faculty: ~0 rows (approximately)
/*!40000 ALTER TABLE `Faculty` DISABLE KEYS */;
INSERT IGNORE INTO `Faculty` (`Id`, `Name`) VALUES
	(1, 'Faculty1'),
	(2, 'Faculty2'),
	(3, 'Faculty3');
/*!40000 ALTER TABLE `Faculty` ENABLE KEYS */;

-- Dumping data for table magazinedb.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT IGNORE INTO `User` (`Id`, `Role`, `Faculty_Id`, `Has_Accepted_TOC`, `Email`) VALUES
	(1, 'Student', 1, 1, 'a@gmail.com'),
	(2, 'Coordinator', 1, 1, 'ewd.coordinator@sharklasers.com'),
	(3, 'Manager ', NULL, 1, 'ma@gmail.com'),
	(4, 'Coordinator', 2, 1, 'co@gmail.com'),
	(5, 'Student', 2, 1, 'stu@gmail.com'),
	(6, 'Student', 3, 1, 'stu3@gmail.com'),
	(7, 'Coordinator', 3, 1, 'co3@gmail.com');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
