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
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT IGNORE INTO `faculty` (`Id`, `Name`) VALUES
	(1, 'Faculty1'),
	(2, 'Faculty2'),
	(3, 'Faculty3');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;

-- Dumping data for table magazinedb.submission: ~12 rows (approximately)
/*!40000 ALTER TABLE `submission` DISABLE KEYS */;
INSERT IGNORE INTO `submission` (`Id`, `Path`, `Author_Id`, `Date`, `Year_Id`, `Has_Sent_Notice`, `Comment`, `Is_Selected`) VALUES
	(13, 'C:\\files\\BlueStacks_ScreenShot92.jpg', 1, '2019-03-11', 1, 0, '', 0),
	(14, 'C:\\files\\4k-wallpaper-abstract-art-1210276.jpg', 1, '2019-03-11', 1, 0, '', 1),
	(15, 'C:\\files\\564x511.jpg', 1, '2019-03-11', 1, 0, '', 0),
	(16, 'C:\\files\\forextutorial.pdf', 1, '2019-03-13', 1, 0, '', 0),
	(17, 'C:\\files\\11 ch 21-24 - Nov 25.pdf', 1, '2019-03-13', 1, 0, '', 0),
	(31, 'C:\\files\\1.1552641327448.4k-wallpaper-abstract-art-1210276.jpg', 1, '2019-03-15', 1, 0, '', 0),
	(32, 'path/to/file/on/disk', 1, '2019-03-15', 1, 0, NULL, 0),
	(33, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.jtuum1vu.TeamViewer.exe', 1, '2019-03-30', 1, 1, '', 0),
	(34, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.1553136879277.Harvard-main-examples.pdf', 1, '2019-03-21', 1, 0, '', 0),
	(35, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.jtuuqxuo.Harvard-main-examples.pdf', 1, '2019-03-30', 1, 1, '', 0),
	(36, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.1553137165906.TeamViewer.exe', 1, '2019-03-21', 1, 0, '', 1),
	(37, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.jtuup55h.1.jpg', 1, '2019-03-30', 1, 1, '', 0),
	(38, 'C:\\Users\\admin\\magazineApp\\upload-root\\1.1553319806877.4k-wallpaper-abstract-art-1210276.jpg', 1, '2019-03-23', 1, 0, '', 1),
	(39, 'C:\\Users\\admin\\magazineApp\\upload-root\\2.jtuwm8me.TeamViewer_Setup.exe', 1, '2019-03-30', 1, 1, '', 1),
	(40, 'C:\\Users\\admin\\magazineApp\\upload-root\\f2Faculty2_u5_20190422.09.59.41.35981388_971317.jpg', 5, '2019-04-22', 1, 0, 'fbgcnfn', 0),
	(41, 'C:\\Users\\admin\\magazineApp\\upload-root\\f2Faculty2_u5_20190422.09.59.59.35999158_935175.pdf', 5, '2019-04-22', 1, 0, '', 1),
	(42, 'C:\\Users\\admin\\magazineApp\\upload-root\\f2Faculty2_u5_20190422.10.00.46.36046807_136636.jar', 5, '2019-04-22', 1, 0, '', 0),
	(43, 'C:\\Users\\admin\\magazineApp\\upload-root\\f2Faculty2_u5_20190422.10.01.02.36062088_594561.docx', 5, '2019-04-22', 1, 0, '', 1);
/*!40000 ALTER TABLE `submission` ENABLE KEYS */;

-- Dumping data for table magazinedb.user: ~4 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`Id`, `Role`, `Faculty_Id`, `Has_Accepted_TOC`, `Email`) VALUES
	(1, 'Student', 1, 1, 'a@gmail.com'),
	(2, 'Coordinator', 1, 1, 'ewd.coordinator@sharklasers.com'),
	(3, 'Manager ', NULL, 1, 'ma@gmail.com'),
	(4, 'Coordinator', 2, 1, 'co@gmail.com'),
	(5, 'Student', 2, 1, 'stu@gmail.com'),
	(6, 'Student', 3, 1, 'stu3@gmail.com'),
	(7, 'Coordinator', 3, 1, 'co3@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping data for table magazinedb.year: ~0 rows (approximately)
/*!40000 ALTER TABLE `year` DISABLE KEYS */;
INSERT IGNORE INTO `year` (`Id`, `StartDate`, `EndDate`, `Entry_ClosureDate`) VALUES
	(1, '2018-12-31', '2019-12-30', '2019-08-31');
/*!40000 ALTER TABLE `year` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
