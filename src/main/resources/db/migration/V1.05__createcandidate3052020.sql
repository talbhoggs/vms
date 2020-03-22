CREATE TABLE `candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` int(11) NOT NULL,
  `party_list_id` int(11) NOT NULL,
  `election_id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_candidate_position_id` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_candidate_election_id` FOREIGN KEY (`election_id`) REFERENCES `election` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_party_list_party_list_id` FOREIGN KEY (`party_list_id`) REFERENCES `party_list` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8