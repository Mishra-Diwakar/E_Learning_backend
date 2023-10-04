-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: elearning
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `teacher` int DEFAULT NULL,
  `header` varchar(150) DEFAULT NULL,
  `banner` varchar(120) DEFAULT NULL,
  `description` text,
  `fee` int DEFAULT NULL,
  `startDate` varchar(50) DEFAULT NULL,
  `duration` varchar(50) DEFAULT NULL,
  `createdBy` int DEFAULT NULL,
  `updatedBy` int DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  `updatedAt` timestamp NULL DEFAULT NULL,
  `startTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (10,'Java Programming',5,'Master in java','java_img.png','Welcome to the Comprehensive Java Programming Fundamentals course! This course is designed to provide you with a solid foundation in Java programming, whether you\'re a beginner with no prior coding experience or an experienced programmer looking to expand your skill set.\r\n\r\nJava is a versatile and widely-used programming language known for its portability, readability, and extensive libraries. In this course, we will take you on a journey from the basics of Java syntax to more advanced topics, equipping you with the knowledge and tools to develop your own Java applications.',6000,'2023-08-25','6 month',2,2,'2023-08-24 12:06:58','2023-08-24 12:06:58','10:31'),(11,'Data Science',5,'Full Stack Data Science Masters','full_right.png','Welcome to the Comprehensive Java Programming Fundamentals course! This course is designed to provide you with a solid foundation in Java programming, whether you\'re a beginner with no prior coding experience or an experienced programmer looking to expand your skill set.\r\n\r\nJava is a versatile and widely-used programming language known for its portability, readability, and extensive libraries. In this course, we will take you on a journey from the basics of Java syntax to more advanced topics, equipping you with the knowledge and tools to develop your own Java applications.',10000,'2023-08-26','1 year',2,2,'2023-08-24 12:16:27','2023-08-24 12:16:27','10:00'),(12,'Master in Python',5,'Full stack development using python','da_img.png','If you have enabled the subscription.pending and subscription.halted webhook, you receive notifications every time a Subscription moves to one of the above-mentioned states. You can then decide to hold off the delivery of the service as per your business model.\r\n\r\nWe also send an email to the customer notifying them about the payment failure. This email contains a link that the customer can use to change the card details associated with the Subscription.',7000,'2023-09-10','1 year',2,2,'2023-09-05 09:44:39','2023-09-22 05:11:47','18:00'),(13,'Machine Learning',5,'Machine Learning Fundamentals and Applications','machine_img.png','This course provides a comprehensive introduction to the fundamental principles, techniques, and applications of machine learning. Students will learn the theoretical foundations and practical implementation of machine learning algorithms to solve real-world problems. The course covers various aspects, including data preprocessing, model selection, evaluation metrics, and deployment strategies.',6000,'2023-09-24','6 Month',2,2,'2023-09-25 05:28:53','2023-09-25 05:28:53','11:00'),(14,'Java Developer',6,'Full Stack java developer','stack_img.png','This comprehensive course is designed to equip aspiring and intermediate developers with the skills and knowledge necessary to become proficient Java developers. From basic concepts to advanced application development, this course covers a broad spectrum of Java programming techniques and best practices.',6000,'2023-09-24','6 Month',2,2,'2023-09-25 05:36:11','2023-09-25 05:36:11','10:00'),(15,'DevOps',7,'Mastering DevOps: Streamlining Software Development and Deployment','dev_img.png','This comprehensive DevOps course equips participants with the skills and knowledge to effectively implement DevOps principles and practices within software development lifecycles. Learn to bridge the gap between development and operations, optimizing collaboration, automation, and continuous improvement to enhance project outcomes.',6000,'2023-09-30','6 Month',2,2,'2023-09-25 05:37:59','2023-09-25 05:37:59','09:00'),(16,'Java Comunity',8,'Java Community Course: Mastering Java Development','java_img.png','Welcome to the Java Community Course, where we delve into the world of Java development and equip you with the skills to become a proficient Java developer. This comprehensive course covers essential Java concepts, programming techniques, and advanced topics to help you excel in building robust applications.',7000,'2023-09-29','6 Month',2,2,'2023-09-25 05:39:36','2023-09-25 05:39:36','13:00'),(17,'Prism Backend development',7,' Prism Backend Development','backend_img.png','This course provides a comprehensive introduction to backend development using Prism, a modern and powerful framework. Participants will gain hands-on experience in designing, building, and deploying robust backend solutions for web applications. From API development to database integration, this course covers the essential tools and practices needed to excel in backend development.',6000,'2023-09-29','6 Month',2,2,'2023-09-25 05:41:05','2023-09-25 05:41:05','14:00'),(18,'Web Development',6,'Web Development Fundamentals','web_img.png','This course covers the foundational principles and essential skills required to become proficient in web development. Topics include HTML, CSS, JavaScript, and an introduction to popular frameworks and libraries. Participants will gain hands-on experience in creating interactive and responsive web applications.',6000,'2023-10-03','6 Month',2,2,'2023-09-25 05:47:34','2023-09-25 05:47:34','16:30'),(20,'uiwdid',6,'diwud','image_2023_09_25T12_06_22_323Z.png','erirh34irh39rh329t39th3thti',12345,'2023-09-30','6 month',2,2,'2023-09-30 09:13:52','2023-09-30 09:13:52','16:45'),(21,'fytdsrsrtyfgu',7,'jhgufyesrse','image_2023_09_25T12_06_22_323Z.png','ihiuyuguihujiut8t8y8yuyuyuyiyiuiuhgvoytfouy5',124,'2023-09-30','6 month',2,2,'2023-09-30 11:32:51','2023-09-30 11:32:51','20:49'),(22,'fytdsrsrtyfgu',7,'jhgufyesrse','image_2023_09_25T12_06_22_323Z.png','ihiuyuguihujiut8t8y8yuyuyuyiyiuiuhgvoytfouy5',124,'2023-09-30','6 month',2,2,'2023-09-30 11:34:23','2023-09-30 11:34:23','20:49');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_feature`
--

DROP TABLE IF EXISTS `course_feature`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_feature` (
  `id` int NOT NULL AUTO_INCREMENT,
  `feature` varchar(250) DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `createdBy` int DEFAULT NULL,
  `updatedBy` int DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  `updatedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_feature`
--

LOCK TABLES `course_feature` WRITE;
/*!40000 ALTER TABLE `course_feature` DISABLE KEYS */;
INSERT INTO `course_feature` VALUES (1,'Platform Independence',10,2,2,'2023-09-01 10:45:27','2023-10-03 07:29:42'),(2,'Object-Oriented Programming',10,2,2,'2023-09-01 10:45:27','2023-10-03 07:29:42'),(3,'Simple and Easy to Learn',10,2,NULL,'2023-10-03 07:29:42',NULL),(4,'Robustness and Reliability',10,2,NULL,'2023-10-03 07:29:42',NULL),(5,'Security',10,2,NULL,'2023-10-03 07:29:42',NULL),(6,'Architecture-Neutral',10,2,NULL,'2023-10-03 07:29:42',NULL),(7,'Portability',10,2,NULL,'2023-10-03 07:29:42',NULL),(8,'Interdisciplinary Approach',11,2,NULL,'2023-10-03 07:43:59',NULL),(9,'Data Collection and Cleaning',11,2,NULL,'2023-10-03 07:43:59',NULL),(10,'Data Analysis and Exploration',11,2,NULL,'2023-10-03 07:43:59',NULL),(11,'Data Visualization',11,2,NULL,'2023-10-03 07:43:59',NULL),(12,'Big Data Processing',11,2,NULL,'2023-10-03 07:43:59',NULL),(13,'Natural Language Processing',11,2,NULL,'2023-10-03 07:43:59',NULL),(14,'Deep Learning',11,2,NULL,'2023-10-03 07:43:59',NULL),(15,'Data Mining',11,2,NULL,'2023-10-03 07:43:59',NULL),(16,'Easy-to-Read Syntax',12,2,NULL,'2023-10-03 08:00:52',NULL),(17,'Interpreted and Interactive',12,2,NULL,'2023-10-03 08:00:52',NULL),(18,'Object-Oriented',12,2,NULL,'2023-10-03 08:00:52',NULL),(19,'Dynamic Typing',12,2,NULL,'2023-10-03 08:00:52',NULL),(20,'Multi-Paradigm',12,2,NULL,'2023-10-03 08:00:52',NULL),(21,'Platform-Independent',12,2,NULL,'2023-10-03 08:00:52',NULL),(22,'High-Level Language',12,2,NULL,'2023-10-03 08:00:52',NULL),(23,'Learning from Data',13,2,NULL,'2023-10-03 08:21:23',NULL),(24,'Automation and Adaptability',13,2,NULL,'2023-10-03 08:21:23',NULL),(25,'Generalization',13,2,NULL,'2023-10-03 08:21:23',NULL),(26,'Prediction and Decision Making',13,2,NULL,'2023-10-03 08:21:23',NULL),(27,'Scalability',13,2,NULL,'2023-10-03 08:21:23',NULL),(28,'Platform Independence',14,2,NULL,'2023-10-03 08:28:00',NULL),(29,'Robustness and Reliability',14,2,NULL,'2023-10-03 08:28:00',NULL),(30,'Platform-Independent Standard Library',14,2,NULL,'2023-10-03 08:28:00',NULL),(31,'Security',14,2,NULL,'2023-10-03 08:28:00',NULL),(32,'Collaboration and Communication',15,2,NULL,'2023-10-03 08:31:03',NULL),(33,'Automation',15,2,NULL,'2023-10-03 08:31:03',NULL),(34,'Continuous Integration (CI)',15,2,NULL,'2023-10-03 08:31:03',NULL),(35,'Continuous Deployment (CD)',15,2,NULL,'2023-10-03 08:31:03',NULL),(36,'Monitoring and Feedback',15,2,NULL,'2023-10-03 08:31:03',NULL),(37,'Cross-Functional Teams',15,2,NULL,'2023-10-03 08:31:03',NULL),(38,'Infrastructure as Code (IaC)',15,2,NULL,'2023-10-03 08:31:03',NULL),(39,'Diversity and Inclusivity',16,2,NULL,'2023-10-03 08:36:32',NULL),(40,'Open Source Philosophy',16,2,NULL,'2023-10-03 08:36:32',NULL),(41,'Collaboration and Sharing',16,2,NULL,'2023-10-03 08:36:32',NULL),(42,'Educational Resources',16,2,NULL,'2023-10-03 08:36:32',NULL),(43,'Automatic API Generation',17,2,NULL,'2023-10-03 08:42:48',NULL),(44,'Code-First Approach',17,2,NULL,'2023-10-03 08:42:48',NULL),(45,'Schema-Driven Development',17,2,NULL,'2023-10-03 08:42:48',NULL),(46,'Real-Time Development and Mocking',17,2,NULL,'2023-10-03 08:42:48',NULL),(47,'Prisma Integration',17,2,NULL,'2023-10-03 08:42:48',NULL),(48,'Middleware Support',17,2,NULL,'2023-10-03 08:42:48',NULL),(49,'Front-end Development',18,2,NULL,'2023-10-03 09:10:03',NULL),(50,'Back-end Development',18,2,NULL,'2023-10-03 09:10:03',NULL),(51,'Frameworks and Libraries',18,2,NULL,'2023-10-03 09:10:03',NULL),(52,'Responsive Design',18,2,NULL,'2023-10-03 09:10:03',NULL),(53,'Performance Optimization',18,2,NULL,'2023-10-03 09:10:03',NULL);
/*!40000 ALTER TABLE `course_feature` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_topic`
--

DROP TABLE IF EXISTS `course_topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course_topic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `topic` varchar(250) DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `createdBy` int DEFAULT NULL,
  `updatedBy` int DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  `updatedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_topic`
--

LOCK TABLES `course_topic` WRITE;
/*!40000 ALTER TABLE `course_topic` DISABLE KEYS */;
INSERT INTO `course_topic` VALUES (1,'Syntax and Structure',10,2,2,'2023-09-01 10:45:27','2023-10-03 07:29:42'),(2,'Control Flow',10,2,2,'2023-09-01 10:45:27','2023-10-03 07:29:42'),(3,'Operators',10,2,2,'2023-09-02 12:29:28','2023-10-03 07:29:42'),(4,'Data Types and Variables:',10,2,2,'2023-09-02 12:29:28','2023-10-03 07:29:42'),(5,'Arrays',10,2,2,'2023-09-02 12:29:48','2023-10-03 07:29:42'),(6,'Classes and Objects',10,2,2,'2023-09-02 12:29:48','2023-10-03 07:29:42'),(7,'Inheritance',10,2,NULL,'2023-10-03 07:29:42',NULL),(8,'Interfaces',10,2,NULL,'2023-10-03 07:29:42',NULL),(9,'Packages',10,2,NULL,'2023-10-03 07:29:42',NULL),(10,'Exception Handling',10,2,NULL,'2023-10-03 07:29:42',NULL),(11,'Collections Framework',10,2,NULL,'2023-10-03 07:29:42',NULL),(12,'Generics',10,2,NULL,'2023-10-03 07:29:42',NULL),(13,'Threads and Concurrency',10,2,NULL,'2023-10-03 07:29:42',NULL),(14,'File I/O',10,2,NULL,'2023-10-03 07:29:42',NULL),(15,'Java I/O Streams',10,2,NULL,'2023-10-03 07:29:42',NULL),(16,'Serialization and Deserialization',10,2,NULL,'2023-10-03 07:29:42',NULL),(17,'Annotations',10,2,NULL,'2023-10-03 07:29:42',NULL),(18,'Lambda Expressions',10,2,NULL,'2023-10-03 07:29:42',NULL),(19,'Java Virtual Machine (JVM)',10,2,NULL,'2023-10-03 07:29:42',NULL),(20,'Data Collection and Integration',11,2,NULL,'2023-10-03 07:43:59',NULL),(21,'Exploratory Data Analysis (EDA)',11,2,NULL,'2023-10-03 07:43:59',NULL),(22,'Statistical Analysis',11,2,NULL,'2023-10-03 07:43:59',NULL),(23,'Machine Learning',11,2,NULL,'2023-10-03 07:43:59',NULL),(24,'Big Data and Distributed Computing',11,2,NULL,'2023-10-03 07:43:59',NULL),(25,'Data Visualization',11,2,NULL,'2023-10-03 07:43:59',NULL),(26,'Model Evaluation and Validation',11,2,NULL,'2023-10-03 07:43:59',NULL),(27,'Data Mining',11,2,NULL,'2023-10-03 07:43:59',NULL),(28,'Time Series Analysis',11,2,NULL,'2023-10-03 07:43:59',NULL),(29,'Databases and SQL',11,2,NULL,'2023-10-03 07:43:59',NULL),(30,'Ethics and Privacy in Data Science',11,2,NULL,'2023-10-03 07:43:59',NULL),(31,'Cloud Computing and Storage',11,2,NULL,'2023-10-03 07:43:59',NULL),(32,'Basic Syntax and Data Types',12,2,NULL,'2023-10-03 08:00:52',NULL),(33,'Functions and Modules',12,2,NULL,'2023-10-03 08:00:52',NULL),(34,'Object-Oriented Programming (OOP)',12,2,NULL,'2023-10-03 08:00:52',NULL),(35,'File Handling',12,2,NULL,'2023-10-03 08:00:52',NULL),(36,'Exception Handling',12,2,NULL,'2023-10-03 08:00:52',NULL),(37,'Advanced Data Structures',12,2,NULL,'2023-10-03 08:00:52',NULL),(38,'Regular Expressions',12,2,NULL,'2023-10-03 08:00:52',NULL),(39,'Database Access',12,2,NULL,'2023-10-03 08:00:52',NULL),(40,'Web Development',12,2,NULL,'2023-10-03 08:00:52',NULL),(41,'Data',13,2,NULL,'2023-10-03 08:21:23',NULL),(42,'Algorithms',13,2,NULL,'2023-10-03 08:21:23',NULL),(43,'Training and Learning',13,2,NULL,'2023-10-03 08:21:23',NULL),(44,'Features and Feature Engineering',13,2,NULL,'2023-10-03 08:21:23',NULL),(45,'Model Evaluation and Validation',13,2,NULL,'2023-10-03 08:21:23',NULL),(46,'Overfitting and Underfitting',13,2,NULL,'2023-10-03 08:21:23',NULL),(47,'Hyperparameters and Tuning',13,2,NULL,'2023-10-03 08:21:23',NULL),(48,'Deployment',13,2,NULL,'2023-10-03 08:21:23',NULL),(49,'Introduction',14,2,NULL,'2023-10-03 08:28:00',NULL),(50,'Control Flow',14,2,NULL,'2023-10-03 08:28:00',NULL),(51,'Methods and Functions',14,2,NULL,'2023-10-03 08:28:00',NULL),(52,'Object-Oriented Programming (OOP)',14,2,NULL,'2023-10-03 08:28:00',NULL),(53,'Exception Handling',14,2,NULL,'2023-10-03 08:28:00',NULL),(54,'Collections Framework',14,2,NULL,'2023-10-03 08:28:00',NULL),(55,'Generics',14,2,NULL,'2023-10-03 08:28:00',NULL),(56,'Threads and Concurrency',14,2,NULL,'2023-10-03 08:28:00',NULL),(57,'Overview and Introduction to DevOps',15,2,NULL,'2023-10-03 08:31:03',NULL),(58,'DevOps Culture and Principles',15,2,NULL,'2023-10-03 08:31:03',NULL),(59,'DevOps Practices',15,2,NULL,'2023-10-03 08:31:03',NULL),(60,'DevOps Tools and Technologies',15,2,NULL,'2023-10-03 08:31:03',NULL),(61,'DevOps Lifecycle',15,2,NULL,'2023-10-03 08:31:03',NULL),(62,'DevOps Automation and Orchestration',15,2,NULL,'2023-10-03 08:31:03',NULL),(63,'DevOps and Cloud Computing',15,2,NULL,'2023-10-03 08:31:03',NULL),(64,'DevOps Metrics and KPIs',15,2,NULL,'2023-10-03 08:31:03',NULL),(65,'Security in DevOps (DevSecOps)',15,2,NULL,'2023-10-03 08:31:03',NULL),(66,'Core Java Concepts and Programming',16,2,NULL,'2023-10-03 08:36:32',NULL),(67,'ava Frameworks and Libraries',16,2,NULL,'2023-10-03 08:36:32',NULL),(68,'Spring Framework',16,2,NULL,'2023-10-03 08:36:32',NULL),(69,'Java EE (Enterprise Edition)',16,2,NULL,'2023-10-03 08:36:32',NULL),(70,'JavaFX and Swing',16,2,NULL,'2023-10-03 08:36:32',NULL),(71,'Mobile Development',16,2,NULL,'2023-10-03 08:36:32',NULL),(72,'Web Development with Java',16,2,NULL,'2023-10-03 08:36:32',NULL),(73,'Testing and Quality Assurance',16,2,NULL,'2023-10-03 08:36:32',NULL),(74,'DevOps and Build Tools',16,2,NULL,'2023-10-03 08:36:32',NULL),(75,'Cloud Computing and Java',16,2,NULL,'2023-10-03 08:36:32',NULL),(76,'API Endpoint Management',17,2,NULL,'2023-10-03 08:42:48',NULL),(77,'Authentication and Authorization',17,2,NULL,'2023-10-03 08:42:48',NULL),(78,'Data Storage and Management',17,2,NULL,'2023-10-03 08:42:48',NULL),(79,'Parsing and Processing API Specifications',17,2,NULL,'2023-10-03 08:42:48',NULL),(80,'Integration with Testing Frameworks',17,2,NULL,'2023-10-03 08:42:48',NULL),(81,'Documentation Generation',17,2,NULL,'2023-10-03 08:42:48',NULL),(82,'Error Handling and Logging',17,2,NULL,'2023-10-03 08:42:48',NULL),(83,'Security Measures',17,2,NULL,'2023-10-03 08:42:48',NULL),(84,'Monitoring and Analytics',17,2,NULL,'2023-10-03 08:42:48',NULL),(85,'HTML',18,2,NULL,'2023-10-03 09:10:03',NULL),(86,'CSS',18,2,NULL,'2023-10-03 09:10:03',NULL),(87,'JavaScript',18,2,NULL,'2023-10-03 09:10:03',NULL),(88,'Front-End Development',18,2,NULL,'2023-10-03 09:10:03',NULL),(89,'Back-End Development',18,2,NULL,'2023-10-03 09:10:03',NULL),(90,'Web Frameworks',18,2,NULL,'2023-10-03 09:10:03',NULL),(91,'DBMS',18,2,NULL,'2023-10-03 09:10:03',NULL),(92,'Version Control Systems',18,2,NULL,'2023-10-03 09:10:03',NULL),(93,'Security',18,2,NULL,'2023-10-03 09:10:03',NULL),(94,'APIs',18,2,NULL,'2023-10-03 09:10:03',NULL);
/*!40000 ALTER TABLE `course_topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `myorders`
--

DROP TABLE IF EXISTS `myorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `myorders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `receiptId` varchar(50) DEFAULT NULL,
  `paymentId` varchar(50) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `myorders`
--

LOCK TABLES `myorders` WRITE;
/*!40000 ALTER TABLE `myorders` DISABLE KEYS */;
INSERT INTO `myorders` VALUES (1,2,'order_MYZH7dEwNebOCT',10000,'created','receiptGTZKT0F1Z6',NULL,'2023-09-05 07:14:56'),(2,2,'order_MYZKR4WQ9tiEiM',10000,'created','receipt4X36M2CC68',NULL,'2023-09-05 07:18:04'),(3,2,'order_MZ23RJY2gULGM8',6000,'created','receipt8TPFRZ9QR5',NULL,'2023-09-06 11:24:06'),(4,2,'order_MeqkXMo06CWy84',6000,'created','receiptWXE1WQKHYI',NULL,'2023-09-21 04:14:35'),(5,2,'order_MeqtuhTT1W1Sot',7000,'created','receipt1446LOT9F1',NULL,'2023-09-21 04:23:28'),(6,2,'order_MeqvlBvccAYMUB',7000,'created','receiptEOE2KZZG8L',NULL,'2023-09-21 04:25:13'),(7,2,'order_Mer6mAYLmupdKE',7000,'created','receiptRL0VRBMF1V',NULL,'2023-09-21 04:35:38'),(8,2,'order_MerYUa1XyR2YIb',7000,'created','receipt70CQBEFUNY',NULL,'2023-09-21 05:01:53'),(9,2,'order_MeraDJY0LmLMC3',7000,'created','receiptN0CC5YT8AW',NULL,'2023-09-21 05:03:30'),(10,2,'order_MesYKxFIzfOV15',7000,'created','receiptMUPA4T0TBJ',NULL,'2023-09-21 06:00:25'),(11,2,'order_MesdpdOVjlqnN1',7000,'created','receiptT2U1FSW4IH',NULL,'2023-09-21 06:05:38'),(12,2,'order_MesfuFiiMgBlE4',7000,'created','receiptZ0MD0SHIBX',NULL,'2023-09-21 06:07:35'),(13,2,'order_Met19QF8IYAgtY',10000,'created','receipt10W3PS3K3P',NULL,'2023-09-21 06:27:42'),(14,2,'order_Met2vfjgo5cqZM',10000,'created','receiptX5CX466T55',NULL,'2023-09-21 06:29:23'),(15,2,'order_MetZLPos8ssXRW',10000,'created','receiptX7JAFZEZAP',NULL,'2023-09-21 07:00:04'),(16,2,'order_MeyDilntRYQIWL',6000,'created','receiptQC3VF5DQAC',NULL,'2023-09-21 11:33:04'),(17,1,'order_MeyT1HrF88JS4V',6000,'created','receiptNBZILT0ZHG',NULL,'2023-09-21 11:47:33'),(18,1,'order_MgRLw2LqUE2ylA',7000,'created','receipt44YS6KQ987',NULL,'2023-09-25 04:41:58'),(19,1,'order_MgRZ5LsolfBDZp',10000,'created','receipt622FU7QGE1',NULL,'2023-09-25 04:54:25'),(20,1,'order_MgRZRvcgMKV1DL',10000,'created','receiptRXAS789769',NULL,'2023-09-25 04:54:45'),(21,1,'order_MgRb8QHkjDBq2Q',10000,'created','receipt5HGW6286IC',NULL,'2023-09-25 04:56:21'),(22,4,'order_MgS5cq11gKC661',6000,'created','receipt0PKPW1JC8K',NULL,'2023-09-25 05:25:13'),(23,4,'order_MgSBwoLGTJK7bi',6000,'created','receiptJXGOM0YAW5',NULL,'2023-09-25 05:31:12'),(24,1,'order_MgsbQJ1ckYIZ9C',6000,'created','receiptPHT1DWUZBF',NULL,'2023-09-26 07:21:21'),(25,9,'order_Mhka6b51eWb9V4',6000,'created','receipt7WYK47TTMI',NULL,'2023-09-28 12:09:33'),(26,9,'order_Mhka6y5bXsAK2G',6000,'created','receiptQVRTTL9WTY',NULL,'2023-09-28 12:09:34'),(27,9,'order_Mhka77aUAJf1rS',6000,'created','receipt87P0FA1N51',NULL,'2023-09-28 12:09:34'),(28,9,'order_MhkaDIr4rP8qej',6000,'created','receiptBBIQV392ZW',NULL,'2023-09-28 12:09:39');
/*!40000 ALTER TABLE `myorders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `orderId` varchar(50) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `paymentId` varchar(50) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,1,NULL,'order_MYZKR4WQ9tiEiM',10000,'paid','pay_MYZKWenvPAe4GF','2023-09-05 07:18:21'),(2,1,NULL,'order_MZ23RJY2gULGM8',6000,'paid','pay_MZ24LQhBchfJ2m','2023-09-06 11:25:07'),(3,1,NULL,'order_MeqkXMo06CWy84',6000,'paid','pay_MeqkyXuYIwRGwU','2023-09-21 04:15:12'),(4,1,NULL,'order_MeqvlBvccAYMUB',7000,'paid','pay_MeqvzXC5zyloWN','2023-09-21 04:25:38'),(5,1,12,'order_MeraDJY0LmLMC3',7000,'paid','pay_MeraViMQbBsRqB','2023-09-21 05:04:01'),(6,1,12,'order_MesYKxFIzfOV15',7000,'paid','pay_MesYS16Pn8g97g','2023-09-21 06:00:46'),(7,1,12,'order_MesdpdOVjlqnN1',7000,'paid','pay_Mese8ZCxUE0WMD','2023-09-21 06:06:07'),(8,1,12,'order_MesfuFiiMgBlE4',7000,'paid','pay_MesgKJmgU3lI4T','2023-09-21 06:08:11'),(9,1,11,'order_Met19QF8IYAgtY',10000,'paid','pay_Met1g7xuXycFVk','2023-09-21 06:28:24'),(10,1,11,'order_Met2vfjgo5cqZM',10000,'paid','pay_Met3Y1j9yRHvL4','2023-09-21 06:30:12'),(11,1,11,'order_MetZLPos8ssXRW',10000,'paid','pay_MetZaWcKY5OLIc','2023-09-21 07:00:30'),(12,1,12,'order_MgRLw2LqUE2ylA',7000,'paid','pay_MgRNZ1AZnXmu2w','2023-09-25 04:43:40'),(13,4,10,'order_MgSBwoLGTJK7bi',6000,'paid','pay_MgSD2kQdD72U6j','2023-09-25 05:32:24');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchasedcourse`
--

DROP TABLE IF EXISTS `purchasedcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchasedcourse` (
  `id` int NOT NULL AUTO_INCREMENT,
  `courseId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `enrolledAt` timestamp NULL DEFAULT NULL,
  `validTill` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchasedcourse`
--

LOCK TABLES `purchasedcourse` WRITE;
/*!40000 ALTER TABLE `purchasedcourse` DISABLE KEYS */;
INSERT INTO `purchasedcourse` VALUES (1,12,1,'2023-09-25 04:43:40','2024-09-25 04:43:40'),(2,11,1,'2023-09-21 07:00:30','2024-09-21 07:00:30'),(4,10,4,'2023-09-25 05:32:24','2024-09-25 05:32:24');
/*!40000 ALTER TABLE `purchasedcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `queries`
--

DROP TABLE IF EXISTS `queries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `queries` (
  `id` int NOT NULL AUTO_INCREMENT,
  `problem` varchar(500) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `queryType` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `queries`
--

LOCK TABLES `queries` WRITE;
/*!40000 ALTER TABLE `queries` DISABLE KEYS */;
INSERT INTO `queries` VALUES (1,'testing problem','java.nitya@gmail.com','6598745423',12,1,'solved',NULL),(2,'sir if i have not connected class today than how can i see my previous lectures','abc@gmail.com','5685749562',0,2,'created','2023-09-27 06:41:46'),(3,'sir if i have not connected class today than how can i see my previous lectures','abc@gmail.com','5685749562',0,2,'created','2023-09-27 06:47:08'),(4,'sir if i have not connected class today than how can i see my previous lectures','abc@gmail.com','5685749562',0,2,'created','2023-09-27 06:50:50'),(5,'Testing','abcd@gmail.com','7081642019',10,1,'created','2023-09-27 08:56:12'),(6,'Testing','abcd@gmail.com','7081642019',10,1,'created','2023-09-27 08:56:26'),(7,'testingoejihsrgherhge','anamparveen16@gmail.com','87977907698',0,2,'created','2023-09-30 05:46:42');
/*!40000 ALTER TABLE `queries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ratings`
--

DROP TABLE IF EXISTS `ratings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ratings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `rate` int DEFAULT NULL,
  `description` varchar(350) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  `updatedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ratings`
--

LOCK TABLES `ratings` WRITE;
/*!40000 ALTER TABLE `ratings` DISABLE KEYS */;
INSERT INTO `ratings` VALUES (1,1,10,4,'The most complete Java course you will ever find. Tim is a complete Java expert and a very good teacher. It\'s so much information here, that you must revisit this course to fully grasp everything.',NULL,'2023-08-24 12:06:58',NULL),(2,3,10,4,'The most complete Java course you will ever find. Tim is a complete Java expert and a very good teacher. It\'s so much information here, that you must revisit this course to fully grasp everything.',NULL,'2023-08-24 12:06:58',NULL),(4,1,11,5,'The most complete Java course you will ever find. Tim is a complete Java expert and a very good teacher. It\'s so much information here, that you must revisit this course to fully grasp everything.',NULL,'2023-08-24 12:06:58',NULL),(6,3,11,3,'The most complete Java course you will ever find. Tim is a complete Java expert and a very good teacher. It\'s so much information here, that you must revisit this course to fully grasp everything.',NULL,'2023-08-24 12:06:58',NULL),(10,4,12,3,'The most complete Java course you will ever find. Tim is a complete Java expert and a very good teacher. It\'s so much information here, that you must revisit this course to fully grasp everything.',NULL,'2023-08-24 12:06:58',NULL),(11,1,12,3,'this is testing review',NULL,'2023-09-25 09:17:14',NULL);
/*!40000 ALTER TABLE `ratings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `qualification` varchar(150) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(250) DEFAULT NULL,
  `otpNum` int DEFAULT NULL,
  `otpSentAt` timestamp NULL DEFAULT NULL,
  `userType` int DEFAULT NULL,
  `status` tinyint DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `mobile` varchar(12) DEFAULT NULL,
  `state` varchar(60) DEFAULT NULL,
  `pincode` int DEFAULT NULL,
  `district` varchar(60) DEFAULT NULL,
  `postOffice` varchar(100) DEFAULT NULL,
  `policeStation` varchar(100) DEFAULT NULL,
  `aadhar` varchar(12) DEFAULT NULL,
  `createdBy` int DEFAULT NULL,
  `updatedBy` int DEFAULT NULL,
  `loginAt` timestamp NULL DEFAULT NULL,
  `createdAt` timestamp NULL DEFAULT NULL,
  `updatedAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nityanand','ray','rainet',NULL,'male','nitya.java@gmail.com','$2a$10$799B0o3EC8f5Y17F/5ZjwOD.QU9Ie5p3guHNRu8JtsHLc0yMH9YOy',NULL,NULL,4,1,'2023-08-03','9661968212','Uttar Pradesh',201301,'east champaran','mehsi','motihari','987987987798',0,NULL,'2023-10-04 05:39:46','2023-08-18 23:02:42','2023-08-18 23:02:42'),(2,'Diwakar','mishra','diwakar',NULL,'male','diwakarkumar7575@gmail.com','$2a$10$J9Z8lYBTnXF0qBEJe5clteDZKNpV9pnmsyQ92u857q.X9oU4HT2dm',NULL,NULL,1,1,'2023-08-03','9661968212','Uttar Pradesh',201301,'east champaran','mehsi','motihari','987987987798',0,NULL,'2023-10-04 04:22:49','2023-08-18 23:02:42','2023-08-18 23:02:42'),(3,'adfdfd','adf ad','testingUser',NULL,'male','abc@gmail.com','$2a$10$Q7KZnYN3hPJrWwDOn1gfvuCKY6dgJdahHgshDq0Pv0.6/H2.M9iDa',4491,'2023-09-30 09:56:34',4,1,'2023-08-08','6546546544','Uttar Pradesh',201301,'east champaran','mehsi','motihari','654654654654',NULL,2,'2023-08-24 10:04:20','2023-08-24 10:04:20','2023-09-06 11:31:48'),(4,'Anam','Parween','aparween',NULL,'female','anamparveen16@gmail.com','$2a$10$cs7Of1c.JgSM47syiPgSRebjKgyAVql/KIVVmnoF1lHNseViaf/5m',NULL,NULL,4,1,'2023-08-09','7080968967','Uttar Pradesh',209727,'kannauj','kannauj','kannauj','789065432123',0,NULL,'2023-09-25 05:53:55','2023-09-24 10:10:06','2023-08-24 10:10:06'),(5,'Priti','Gupta','priti12','M.tech','female','priti@gmail.com','$2a$10$SkecCJtfVKkS5gyo5AGliuy6N2F3xYEYJkj1UwWq6r29Fa7by/nkq',NULL,NULL,3,1,'2023-09-03','8987455635','Uttar Pradesh',201301,'east champaran','mehsi','motihari','985635225368',2,NULL,'2023-09-28 04:47:16','2023-09-06 07:41:26','2023-09-06 07:41:26'),(6,'Gaurav','chauhan','gaurav_12','MCA','male','gaurav@gmail.com','$2a$10$RUqKXI.cvQdkG4Utu0zc..OmnNNXFnMDHXvVqr6Dp3hxIRoaiRTsS',5103,'2023-09-28 11:59:09',3,1,'1992-02-25','9874563211','Bihar',874565,'Gaya','Gaya','Ganga','789654857541',2,NULL,NULL,'2023-09-25 05:31:26','2023-09-25 05:31:26'),(7,'Manish','Gupta','Manish_12','MCA','male','manish@gmail.com','$2a$10$AYnT9WaOejGZrkODjchXc.pqXEoVqo9lhPLKyCoA5JgAWXp/ijHSG',NULL,NULL,3,1,'1992-02-25','9874563212','Bihar',874565,'Gaya','Gaya','Ganga','789654857544',2,NULL,NULL,'2023-09-25 05:32:36','2023-09-25 05:32:36'),(8,'Rishi','Mishra','Rishi_12','MCA','male','rishi@gmail.com','$2a$10$UT9IP/qHwHFS5smqcWGeoeiao4Wh6cREnzO3M9Ro.9lKjGTJW2YlC',NULL,NULL,3,1,'1992-02-25','9874563000','Bihar',874565,'Gaya','Gaya','Ganga','789654857540',2,NULL,NULL,'2023-09-25 05:33:12','2023-09-25 05:33:12'),(9,'Azeem','Qamar','Ansari',NULL,'male','qamarali7017@gmail.com','$2a$10$pBNczEqzaDpc3HRad.iyj.vpCTGHRhB3HT5omo7HLQxDO6aTxeU3q',3447,'2023-09-28 12:01:17',4,1,'2000-12-13','8791328156','Uttar Pradesh',246763,'Bijnor','Najibabad','Najibabad','649576399590',0,NULL,'2023-09-28 12:07:54','2023-09-26 07:49:55','2023-09-26 07:49:55'),(10,'anam','Parween','parween',NULL,'female','anamparveen16@gmail.com','$2a$10$PSplfbwBy7Iele5rUsrt4OEIf383BhaVfQeWLV3qlnO6pRNXpp3rK',NULL,NULL,4,1,'2000-01-01','7081642019','Uttar Pradesh',208017,'kanpur','kanpur','kanpur','787878787878',0,NULL,'2023-09-28 11:27:12','2023-09-26 07:54:25','2023-09-26 07:54:25');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usertype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'ADMIN'),(2,'STAFF'),(3,'TEACHER'),(4,'STUDENT');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `videos`
--

DROP TABLE IF EXISTS `videos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `videos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher` varchar(100) DEFAULT NULL,
  `title` varchar(250) DEFAULT NULL,
  `video` varchar(250) DEFAULT NULL,
  `videoExtension` varchar(6) DEFAULT NULL,
  `banner` varchar(150) DEFAULT NULL,
  `bannerExtension` varchar(6) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `playList` int DEFAULT NULL,
  `uploadedAt` timestamp NULL DEFAULT NULL,
  `uploadedBy` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `videos`
--

LOCK TABLES `videos` WRITE;
/*!40000 ALTER TABLE `videos` DISABLE KEYS */;
INSERT INTO `videos` VALUES (2,'Priti Gupta','Java tutorial | Lecture video 2','vid-2.mp4','mp4','post-1-2.png','png','00:02:45',10,'2023-09-20 10:13:14',2),(3,'Priti Gupta','Java tutorial | Lecture video 3','vid-3.mp4','mp4','post-1-3.png','png','00:02:09',10,'2023-09-20 10:13:29',2),(5,'Priti Gupta','Python | Lecture video 1 | Introduction','vid-5.mp4','mp4','post-2-1.png','png','00:02:02',12,'2023-09-20 10:14:44',2),(6,'Priti Gupta','Python | Lecture video 2 | Variable','vid-6.mp4','mp4','post-2-2.png','png','00:02:14',12,'2023-09-20 10:15:06',2),(7,'Priti Gupta','Python | Lecture video 3 | Data type','vid-7.mp4','mp4','post-2-3.png','png','00:03:12',12,'2023-09-20 10:15:28',2);
/*!40000 ALTER TABLE `videos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-04 12:13:28
