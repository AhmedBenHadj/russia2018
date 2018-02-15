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
-- Table structure for table `joueur_fantasy`
--

CREATE TABLE `joueur_fantasy` (
  `id` int(11) NOT NULL,
  `id_joueur` int(11) NOT NULL,
  `id_equipe` int(11) NOT NULL,
  `posteF` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `prix` int(11) NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `joueur_fantasy`
--

INSERT INTO `joueur_fantasy` (`id`, `id_joueur`, `id_equipe`, `posteF`, `etat`, `prix`, `points`) VALUES
(9, 8, 2, 20, 30, 40, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `joueur_fantasy`
--
ALTER TABLE `joueur_fantasy`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_joueur` (`id_joueur`),
  ADD KEY `id_equipe` (`id_equipe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `joueur_fantasy`
--
ALTER TABLE `joueur_fantasy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `joueur_fantasy`
--
ALTER TABLE `joueur_fantasy`
  ADD CONSTRAINT `joueur_fantasy_ibfk_1` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `joueur_fantasy_ibfk_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipe_fantasy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
