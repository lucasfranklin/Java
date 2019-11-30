-- liquibase formatted sql

-- changeset lucas.silva: 1.0 dbms:mysql

CREATE TABLE `company` (
  `id` bigint(100) NOT NULL,
  `vacancies` int(11) NOT NULL,
  `name` varchar(90) COLLATE utf8mb4_general_ci NOT NULL,
  `document` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `site` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `salary` decimal(10,2)  NOT NULL,
  `age` int(11) NOT NULL,
  constraint company_pk
        PRIMARY KEY (`id`)
);
-- changeset lucas.silva: 1.1 dbms:mysql
CREATE TABLE `user` (
  `idUser` bigint(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `document` varchar(13) COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(11) NOT NULL,
  `login` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `idComany` bigint(100) NOT NULL,
  `salary` decimal(10,2) NOT NULL,
  `idAddress` bigint(100) NOT NULL,
    constraint user_pk
  PRIMARY KEY (`idUser`)
 ;
-- changeset lucas.silva: 1.2 dbms:mysql
CREATE TABLE `Address` (
  `idAddress` bigint(100) NOT NULL AUTO_INCREMENT,
  `zipCode` varchar(9) COLLATE utf8mb4_general_ci NOT NULL,
  `street` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `number` int(11) NOT NULL,
  `district` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `country` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idAddress`)
)


