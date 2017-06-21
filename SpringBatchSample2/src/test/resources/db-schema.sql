CREATE TABLE IF NOT EXISTS `sample_table` (
`id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

ALTER TABLE `sample_table` ADD PRIMARY KEY (`id`);