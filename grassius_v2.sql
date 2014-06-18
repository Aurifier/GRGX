/*
Navicat MySQL Data Transfer

Source Server         : workLaptop
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : grassius_v2

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2014-06-10 13:56:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cis_motifs
-- ----------------------------
DROP TABLE IF EXISTS `cis_motifs`;
CREATE TABLE `cis_motifs` (
  `cis_id` int(10) unsigned NOT NULL DEFAULT '0',
  `fk_range_id` int(10) unsigned DEFAULT NULL,
  `matrix` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `logo` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pos_window` int(10) unsigned DEFAULT NULL,
  `neg_window` int(10) unsigned DEFAULT NULL,
  `source` varchar(125) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_tissue_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`cis_id`),
  KEY `cis_range` (`fk_range_id`),
  KEY `cis_tissue` (`fk_tissue_id`),
  CONSTRAINT `cis_range` FOREIGN KEY (`fk_range_id`) REFERENCES `ranges` (`range_id`),
  CONSTRAINT `cis_tissue` FOREIGN KEY (`fk_tissue_id`) REFERENCES `tissues` (`tissue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for domains
-- ----------------------------
DROP TABLE IF EXISTS `domains`;
CREATE TABLE `domains` (
  `domain_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_pfam_id` int(10) unsigned DEFAULT NULL,
  `hmm_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hmm_acc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`domain_id`),
  KEY `domain_pfam` (`fk_pfam_id`),
  CONSTRAINT `domain_pfam` FOREIGN KEY (`fk_pfam_id`) REFERENCES `pfams` (`pfam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for families
-- ----------------------------
DROP TABLE IF EXISTS `families`;
CREATE TABLE `families` (
  `family_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `abbr` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `isCoRegulator` tinyint(1) NOT NULL,
  PRIMARY KEY (`family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for funcat
-- ----------------------------
DROP TABLE IF EXISTS `funcat`;
CREATE TABLE `funcat` (
  `funcat_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `funcat_number` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`funcat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for funcat_funcat
-- ----------------------------
DROP TABLE IF EXISTS `funcat_funcat`;
CREATE TABLE `funcat_funcat` (
  `fk_funcat_id_1` int(10) unsigned DEFAULT NULL,
  `fk_funcat_id_2` int(10) unsigned DEFAULT NULL,
  KEY `funcat_1` (`fk_funcat_id_1`),
  KEY `funcat_2` (`fk_funcat_id_2`),
  CONSTRAINT `funcat_1` FOREIGN KEY (`fk_funcat_id_1`) REFERENCES `funcat` (`funcat_id`),
  CONSTRAINT `funcat_2` FOREIGN KEY (`fk_funcat_id_2`) REFERENCES `funcat` (`funcat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for genes
-- ----------------------------
DROP TABLE IF EXISTS `genes`;
CREATE TABLE `genes` (
  `gene_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_gene_type_id` int(10) unsigned DEFAULT NULL,
  `fk_range_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`gene_id`),
  KEY `fk_type` (`fk_gene_type_id`),
  KEY `range_gene` (`fk_range_id`),
  CONSTRAINT `fk_type` FOREIGN KEY (`fk_gene_type_id`) REFERENCES `gene_types` (`type_id`),
  CONSTRAINT `range_gene` FOREIGN KEY (`fk_range_id`) REFERENCES `ranges` (`range_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for gene_names
-- ----------------------------
DROP TABLE IF EXISTS `gene_names`;
CREATE TABLE `gene_names` (
  `name_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_gene_id` int(10) unsigned DEFAULT NULL,
  `fk_family_id` int(10) unsigned DEFAULT NULL,
  `is_accepted` tinyint(1) DEFAULT NULL,
  `comments` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`name_id`),
  KEY `gene_name` (`fk_gene_id`),
  KEY `gane_name_family` (`fk_family_id`),
  CONSTRAINT `gane_name_family` FOREIGN KEY (`fk_family_id`) REFERENCES `families` (`family_id`),
  CONSTRAINT `gene_name` FOREIGN KEY (`fk_gene_id`) REFERENCES `genes` (`gene_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for gene_types
-- ----------------------------
DROP TABLE IF EXISTS `gene_types`;
CREATE TABLE `gene_types` (
  `type_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for interactions
-- ----------------------------
DROP TABLE IF EXISTS `interactions`;
CREATE TABLE `interactions` (
  `interaction_id` int(10) unsigned NOT NULL,
  `regulation` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isConfirmed` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`interaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for literature
-- ----------------------------
DROP TABLE IF EXISTS `literature`;
CREATE TABLE `literature` (
  `literature_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pubmed_id` int(10) DEFAULT NULL,
  `web_address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` date DEFAULT NULL,
  `first_author` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`literature_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for pfams
-- ----------------------------
DROP TABLE IF EXISTS `pfams`;
CREATE TABLE `pfams` (
  `pfam_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`pfam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for proteins
-- ----------------------------
DROP TABLE IF EXISTS `proteins`;
CREATE TABLE `proteins` (
  `protein_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_transcript_id` int(10) unsigned NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_family_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`protein_id`),
  KEY `protiens_transcripts` (`fk_transcript_id`),
  CONSTRAINT `protiens_transcripts` FOREIGN KEY (`fk_transcript_id`) REFERENCES `transcripts` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for protein_domain
-- ----------------------------
DROP TABLE IF EXISTS `protein_domain`;
CREATE TABLE `protein_domain` (
  `fk_protein_id` int(10) unsigned NOT NULL,
  `fk_domain_id` int(10) unsigned NOT NULL DEFAULT '0',
  `start` int(10) unsigned DEFAULT NULL,
  `end` int(10) unsigned DEFAULT NULL,
  `eval` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bitscore` decimal(6,3) DEFAULT NULL,
  `sequence` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `hmm` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `match` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pp` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`fk_protein_id`,`fk_domain_id`),
  KEY `protiendomain_domain` (`fk_domain_id`),
  CONSTRAINT `protiendomain_domain` FOREIGN KEY (`fk_domain_id`) REFERENCES `domains` (`domain_id`),
  CONSTRAINT `protiendomain_protiens` FOREIGN KEY (`fk_protein_id`) REFERENCES `proteins` (`protein_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for protein_funcat
-- ----------------------------
DROP TABLE IF EXISTS `protein_funcat`;
CREATE TABLE `protein_funcat` (
  `fk_protein_id` int(10) unsigned DEFAULT NULL,
  `fk_funcat_id` int(10) unsigned DEFAULT NULL,
  KEY `protein_funcat` (`fk_protein_id`),
  KEY `funcat_protein` (`fk_funcat_id`),
  CONSTRAINT `funcat_protein` FOREIGN KEY (`fk_funcat_id`) REFERENCES `funcat` (`funcat_id`),
  CONSTRAINT `protein_funcat` FOREIGN KEY (`fk_protein_id`) REFERENCES `proteins` (`protein_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for protein_gene
-- ----------------------------
DROP TABLE IF EXISTS `protein_gene`;
CREATE TABLE `protein_gene` (
  `fk_protein_group_source` int(10) unsigned DEFAULT NULL,
  `fk_gene_target` int(10) unsigned DEFAULT NULL,
  `fk_interaction_id` int(10) unsigned DEFAULT NULL,
  `fk_literature_id` int(10) unsigned DEFAULT NULL,
  KEY `gene_source_gene` (`fk_protein_group_source`),
  KEY `gene_target_gene` (`fk_gene_target`),
  KEY `proteingene_lit` (`fk_literature_id`),
  KEY `proteingene_interaction` (`fk_interaction_id`),
  CONSTRAINT `gene_source_gene` FOREIGN KEY (`fk_protein_group_source`) REFERENCES `protein_group` (`group_id`),
  CONSTRAINT `gene_target_gene` FOREIGN KEY (`fk_gene_target`) REFERENCES `genes` (`gene_id`),
  CONSTRAINT `proteingene_interaction` FOREIGN KEY (`fk_interaction_id`) REFERENCES `interactions` (`interaction_id`),
  CONSTRAINT `proteingene_lit` FOREIGN KEY (`fk_literature_id`) REFERENCES `literature` (`literature_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for protein_group
-- ----------------------------
DROP TABLE IF EXISTS `protein_group`;
CREATE TABLE `protein_group` (
  `group_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_protein_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`group_id`,`fk_protein_id`),
  KEY `proteingroup_protein` (`fk_protein_id`),
  CONSTRAINT `proteingroup_protein` FOREIGN KEY (`fk_protein_id`) REFERENCES `proteins` (`protein_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for protein_protein
-- ----------------------------
DROP TABLE IF EXISTS `protein_protein`;
CREATE TABLE `protein_protein` (
  `fk_protein_group_1` int(10) unsigned DEFAULT NULL,
  `fk_protein_group_2` int(10) unsigned DEFAULT NULL,
  `fk_interaction_id` int(10) unsigned DEFAULT NULL,
  `fk_literature_id` int(10) unsigned DEFAULT NULL,
  KEY `protein_protein_1` (`fk_protein_group_1`),
  KEY `protein_protein_2` (`fk_protein_group_2`),
  KEY `proteinprotein_interaction` (`fk_interaction_id`),
  KEY `proteinprotein_lit` (`fk_literature_id`),
  CONSTRAINT `proteinprotein_interaction` FOREIGN KEY (`fk_interaction_id`) REFERENCES `interactions` (`interaction_id`),
  CONSTRAINT `proteinprotein_lit` FOREIGN KEY (`fk_literature_id`) REFERENCES `literature` (`literature_id`),
  CONSTRAINT `protein_protein_1` FOREIGN KEY (`fk_protein_group_1`) REFERENCES `protein_group` (`group_id`),
  CONSTRAINT `protein_protein_2` FOREIGN KEY (`fk_protein_group_2`) REFERENCES `protein_group` (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for ranges
-- ----------------------------
DROP TABLE IF EXISTS `ranges`;
CREATE TABLE `ranges` (
  `range_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `start` int(11) NOT NULL,
  `end` int(11) NOT NULL,
  `posFlank` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `negFlank` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chromosomes` tinyint(3) unsigned NOT NULL,
  `sequence` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`range_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tfome
-- ----------------------------
DROP TABLE IF EXISTS `tfome`;
CREATE TABLE `tfome` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_transcript_id` int(10) unsigned DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `family` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vector` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `insert` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `5prime_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `5prime_seq` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `5prime_temp` decimal(3,1) DEFAULT NULL,
  `3prime_name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `3prime_seq` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `3prime_temp` decimal(3,1) DEFAULT NULL,
  `pcr_condition` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sequence` text COLLATE utf8_unicode_ci,
  `translation` text COLLATE utf8_unicode_ci,
  `request_info` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `transcript_tfome` (`fk_transcript_id`),
  CONSTRAINT `transcript_tfome` FOREIGN KEY (`fk_transcript_id`) REFERENCES `transcripts` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tf_rules
-- ----------------------------
DROP TABLE IF EXISTS `tf_rules`;
CREATE TABLE `tf_rules` (
  `fk_family_id` int(10) unsigned NOT NULL,
  `fk_domain_id` int(10) unsigned NOT NULL,
  `is_not` tinyint(1) NOT NULL DEFAULT '0',
  `grouping_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`fk_family_id`,`fk_domain_id`,`grouping_id`),
  KEY `tfrules_domains` (`fk_domain_id`),
  CONSTRAINT `tfrules_domains` FOREIGN KEY (`fk_domain_id`) REFERENCES `domains` (`domain_id`),
  CONSTRAINT `tfrules_families` FOREIGN KEY (`fk_family_id`) REFERENCES `families` (`family_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tissues
-- ----------------------------
DROP TABLE IF EXISTS `tissues`;
CREATE TABLE `tissues` (
  `tissue_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`tissue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for transcripts
-- ----------------------------
DROP TABLE IF EXISTS `transcripts`;
CREATE TABLE `transcripts` (
  `transcript_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_gene_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`transcript_id`),
  KEY `transcripts_geneprot` (`fk_gene_id`),
  CONSTRAINT `transcripts_geneprot` FOREIGN KEY (`fk_gene_id`) REFERENCES `genes` (`gene_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for transcript_cluster
-- ----------------------------
DROP TABLE IF EXISTS `transcript_cluster`;
CREATE TABLE `transcript_cluster` (
  `fk_cluster_id` int(10) unsigned NOT NULL DEFAULT '0',
  `fk_transcript_id` int(10) unsigned DEFAULT NULL,
  `more_to_come_possibly` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`fk_cluster_id`),
  KEY `transcriptcluster_transcript` (`fk_transcript_id`),
  CONSTRAINT `transcriptcluster_cluster` FOREIGN KEY (`fk_cluster_id`) REFERENCES `tss_cluster` (`tss_cluster_id`),
  CONSTRAINT `transcriptcluster_transcript` FOREIGN KEY (`fk_transcript_id`) REFERENCES `transcripts` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for transcript_parts
-- ----------------------------
DROP TABLE IF EXISTS `transcript_parts`;
CREATE TABLE `transcript_parts` (
  `part_id` int(10) unsigned NOT NULL DEFAULT '0',
  `part_type` enum('exon','cds','fiveutr','threeutr','intron') COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_range_id` int(10) unsigned DEFAULT NULL,
  `fk_transcript_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`part_id`,`fk_transcript_id`),
  KEY `transcript_part` (`fk_transcript_id`),
  KEY `part_range` (`fk_range_id`),
  CONSTRAINT `part_range` FOREIGN KEY (`fk_range_id`) REFERENCES `ranges` (`range_id`),
  CONSTRAINT `transcript_part` FOREIGN KEY (`fk_transcript_id`) REFERENCES `transcripts` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for transcript_tissue_expression
-- ----------------------------
DROP TABLE IF EXISTS `transcript_tissue_expression`;
CREATE TABLE `transcript_tissue_expression` (
  `fk_tissue_id` int(10) unsigned NOT NULL DEFAULT '0',
  `fk_transcript_id` int(10) unsigned NOT NULL DEFAULT '0',
  `express_value` decimal(10,3) DEFAULT NULL,
  PRIMARY KEY (`fk_tissue_id`,`fk_transcript_id`),
  KEY `transcript_tissue` (`fk_transcript_id`),
  CONSTRAINT `tissue_transcript` FOREIGN KEY (`fk_tissue_id`) REFERENCES `tissues` (`tissue_id`),
  CONSTRAINT `transcript_tissue` FOREIGN KEY (`fk_transcript_id`) REFERENCES `transcripts` (`transcript_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for transcript_transcript_coexpression
-- ----------------------------
DROP TABLE IF EXISTS `transcript_transcript_coexpression`;
CREATE TABLE `transcript_transcript_coexpression` (
  `fk_transcript_1` int(10) unsigned DEFAULT NULL,
  `fk_transcript_2` int(10) unsigned DEFAULT NULL,
  `coexpress_value` decimal(10,3) DEFAULT NULL,
  `cluster` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_tissue_id` int(10) unsigned DEFAULT NULL,
  KEY `transcript1_transcript` (`fk_transcript_1`),
  KEY `transcript2_transcript` (`fk_transcript_2`),
  KEY `transcript_transcript_tissue` (`fk_tissue_id`),
  CONSTRAINT `transcript1_transcript` FOREIGN KEY (`fk_transcript_1`) REFERENCES `transcripts` (`transcript_id`),
  CONSTRAINT `transcript2_transcript` FOREIGN KEY (`fk_transcript_2`) REFERENCES `transcripts` (`transcript_id`),
  CONSTRAINT `transcript_transcript_tissue` FOREIGN KEY (`fk_tissue_id`) REFERENCES `tissues` (`tissue_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tss
-- ----------------------------
DROP TABLE IF EXISTS `tss`;
CREATE TABLE `tss` (
  `fk_cluster_id` int(10) unsigned NOT NULL DEFAULT '0',
  `total_tags` int(10) DEFAULT NULL,
  `isDom` tinyint(1) DEFAULT '0',
  `expression_tpm` float(10,0) DEFAULT NULL,
  `location` int(10) DEFAULT NULL,
  PRIMARY KEY (`fk_cluster_id`),
  CONSTRAINT `cluster_tss` FOREIGN KEY (`fk_cluster_id`) REFERENCES `tss_cluster` (`tss_cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for tss_cluster
-- ----------------------------
DROP TABLE IF EXISTS `tss_cluster`;
CREATE TABLE `tss_cluster` (
  `tss_cluster_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_range_interquartile` int(10) unsigned DEFAULT NULL,
  `low_density` float(10,0) DEFAULT NULL,
  `high_density` float(10,0) DEFAULT NULL,
  `expression_tpm` float(10,0) DEFAULT NULL,
  `shape_index` float(24,0) DEFAULT NULL,
  `cluster_shape` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_tissue_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`tss_cluster_id`),
  KEY `cluster_range2` (`fk_range_interquartile`),
  CONSTRAINT `cluster_range2` FOREIGN KEY (`fk_range_interquartile`) REFERENCES `ranges` (`range_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
