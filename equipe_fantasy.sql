-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 08, 2018 at 03:08 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cup2018`
--

-- --------------------------------------------------------

--
-- Table structure for table `equipe_fantasy`
--

CREATE TABLE `equipe_fantasy` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `pointstotal` bigint(255) NOT NULL,
  `classement` bigint(255) NOT NULL,
  `valeur` float NOT NULL,
  `banque` float NOT NULL,
  `transfers` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipe_fantasy`
--

INSERT INTO `equipe_fantasy` (`id`, `id_user`, `nom`, `pointstotal`, `classement`, `valeur`, `banque`, `transfers`) VALUES
(2, 1, 'rzouga\'s team', 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `equipe_fantasy`
--
ALTER TABLE `equipe_fantasy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipe_fantasy_ibfk_1` (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `equipe_fantasy`
--
ALTER TABLE `equipe_fantasy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipe_fantasy`
--
ALTER TABLE `equipe_fantasy`
  ADD CONSTRAINT `equipe_fantasy_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
