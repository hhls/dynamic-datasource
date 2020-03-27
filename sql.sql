# Dump of table t_user_00
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_00`;

CREATE TABLE `t_user_00` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user_01
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_01`;

CREATE TABLE `t_user_01` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user_02
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_02`;

CREATE TABLE `t_user_02` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user_03
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_03`;

CREATE TABLE `t_user_03` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table t_user_04
# ------------------------------------------------------------

DROP TABLE IF EXISTS `t_user_04`;

CREATE TABLE `t_user_04` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(64) NOT NULL,
  `user_name` varchar(16) NOT NULL,
  `password` varchar(64) NOT NULL,
  `age` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_num` (`user_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `t_user_04` WRITE;
/*!40000 ALTER TABLE `t_user_04` DISABLE KEYS */;

INSERT INTO `t_user_04` (`id`, `user_num`, `user_name`, `password`, `age`)
VALUES
	(6,'wergsgdf3243','admin','adf23',23);

/*!40000 ALTER TABLE `t_user_04` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
