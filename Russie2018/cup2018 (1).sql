-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 08 fév. 2018 à 16:15
-- Version du serveur :  10.1.22-MariaDB
-- Version de PHP :  7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cup2018`
--

-- --------------------------------------------------------

--
-- Structure de la table `abonnement`
--

CREATE TABLE `abonnement` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_joueur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `abonnement`
--

INSERT INTO `abonnement` (`id`, `id_user`, `id_joueur`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `id` int(11) NOT NULL,
  `id_publication` int(11) NOT NULL,
  `description` varchar(250) NOT NULL,
  `id_user` int(11) NOT NULL,
  `date_creation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commentaire`
--

INSERT INTO `commentaire` (`id`, `id_publication`, `description`, `id_user`, `date_creation`) VALUES
(6, 2, 'malla bhim', 1, '1970-01-01'),
(7, 2, 'malla bhim', 1, '1970-01-01'),
(8, 2, 'ffff', 5, '2018-02-08'),
(9, 2, 'kkk', 5, '2018-02-08'),
(10, 5, 'aaa', 6, '2018-02-07');

-- --------------------------------------------------------

--
-- Structure de la table `entraineur`
--

CREATE TABLE `entraineur` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `description` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `entraineur`
--

INSERT INTO `entraineur` (`id`, `nom`, `prenom`, `description`) VALUES
(1, 'ghassen', 'daoudi', 'a9wa moudareb'),
(2, 'ddddd', 'dddd', 'ddddd');

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(11) NOT NULL,
  `id_entraineur` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `drapeau` varchar(250) NOT NULL,
  `maillot` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `equipe`
--

INSERT INTO `equipe` (`id`, `id_entraineur`, `nom`, `drapeau`, `maillot`) VALUES
(1, 1, 'tones', 'a7mer', 'a7mer'),
(2, 1, 'sss', 'lien', 'lien'),
(3, 1, 'tunisia', 'lien', 'lien'),
(4, 1, 'tunisia', 'lien', 'lien'),
(5, 1, 'tunisia', 'lien', 'lien'),
(6, 1, 'portugal', 'iiiii', 'llllll');

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `id` int(11) NOT NULL,
  `id_match` int(11) NOT NULL,
  `id_joueur_participant` int(11) NOT NULL,
  `carton` int(11) NOT NULL,
  `but` int(11) NOT NULL,
  `temps` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `fiche_pari`
--

CREATE TABLE `fiche_pari` (
  `id` int(11) NOT NULL,
  `cotetotal` float NOT NULL,
  `etat` varchar(255) NOT NULL,
  `id_user` int(11) NOT NULL,
  `misetotal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fiche_pari`
--

INSERT INTO `fiche_pari` (`id`, `cotetotal`, `etat`, `id_user`, `misetotal`) VALUES
(2, 53.5, 'Encours', 1, 53.5),
(3, 53.5, 'Encours', 1, 53.5),
(4, 53.5, 'Encours', 1, 80),
(5, 53.5, 'Encours', 1, 80),
(6, 53.5, 'Encours', 1, 80),
(7, 53.5, 'Encours', 1, 80),
(8, 53.5, 'Encours', 1, 80),
(9, 53.5, 'Encours', 1, 80);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE `joueur` (
  `id` int(11) NOT NULL,
  `id_equipe` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `age` int(11) NOT NULL,
  `poste` varchar(100) NOT NULL,
  `numero` int(11) NOT NULL,
  `club` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `joueur`
--

INSERT INTO `joueur` (`id`, `id_equipe`, `nom`, `prenom`, `age`, `poste`, `numero`, `club`) VALUES
(4, 1, 'sdds', 'ddddddd', 77, 'gauche', 88, 'css'),
(5, 1, 'ben haj', 'ahmed', 21, 'droite', 8, 'css'),
(6, 2, 'lilwayne', 'chika', 21, 'droite', 8, 'css');

-- --------------------------------------------------------

--
-- Structure de la table `joueur_participant`
--

CREATE TABLE `joueur_participant` (
  `id` int(11) NOT NULL,
  `id_joueur` int(11) NOT NULL,
  `temps_joue` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `match_2018`
--

CREATE TABLE `match_2018` (
  `id` int(11) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  `id_equipe_1` int(11) NOT NULL,
  `id_equipe_2` int(11) NOT NULL,
  `id_stade` int(11) NOT NULL,
  `date` date NOT NULL,
  `score` varchar(100) NOT NULL,
  `etat` enum('Debut','Encours','Termine','') NOT NULL,
  `duree` int(11) NOT NULL,
  `nombre_spectateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pari`
--

CREATE TABLE `pari` (
  `id` int(11) NOT NULL,
  `id_match` int(11) NOT NULL,
  `cote` float NOT NULL,
  `id_fiche_pari` int(11) NOT NULL,
  `mise` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `date_creation` date NOT NULL,
  `lien` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `liked` int(11) DEFAULT NULL,
  `disliked` int(11) DEFAULT NULL,
  `type` enum('article','galerie','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `id_user`, `titre`, `date_creation`, `lien`, `description`, `liked`, `disliked`, `type`) VALUES
(2, 1, 'lololo', '1970-01-01', 'tttt', 'test', 20, 7, 'galerie'),
(3, 1, 'lololo', '1970-01-01', 'tttt', 'test', 20, 7, 'article'),
(4, 1, 'lololo', '1970-01-01', 'tttt', 'test', 20, 7, 'galerie'),
(5, 5, 'lololo', '1970-01-01', 'tttt', 'test', 20, 7, 'article');

-- --------------------------------------------------------

--
-- Structure de la table `stade`
--

CREATE TABLE `stade` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `capacite` int(11) NOT NULL,
  `image` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `username` varchar(250) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mdp` varchar(250) NOT NULL,
  `role` enum('admin','moderateur','journaliste','membre') NOT NULL,
  `image` varchar(250) NOT NULL,
  `type` int(11) NOT NULL,
  `etat` int(11) NOT NULL,
  `date_creation` date NOT NULL,
  `connecte` enum('ON','OFF','','') NOT NULL,
  `jeton` float NOT NULL,
  `confirmkey` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `username`, `email`, `mdp`, `role`, `image`, `type`, `etat`, `date_creation`, `connecte`, `jeton`, `confirmkey`) VALUES
(1, 'ghassen', 'daoudi', 'tayeb', 'a@a.com', 'iiii', 'journaliste', 'ghassen', 3, 1, '1970-01-01', 'ON', 5, 'hiii'),
(5, 'ghassen', 'daoudi', 'tayeb', 'a@a.com', 'iiii', 'journaliste', 'ghassen', 3, 1, '1970-01-01', 'ON', 5, 'hiii'),
(6, 'ghassen', 'daoudi', 'tayeb', 'a@a.com', 'iiii', 'journaliste', 'ghassen', 3, 1, '1970-01-01', 'ON', 5, 'hiii'),
(7, 'ghassen', 'daoudi', 'tayeb', 'a@a.com', 'iiii', 'journaliste', 'ghassen', 3, 1, '1970-01-01', 'ON', 5, 'hiii'),
(8, 'ghassen', 'daoudi', 'tayeb', 'a@a.com', '$2a$12$VEYvv3Gxa81ENBBv7rxZiu5wMYZdUZ/kWxplTP7aOJdp7XlS7TEK2', 'journaliste', 'test', 3, 1, '1970-01-01', 'ON', 5, 'a68f94df53bd3393edb09789e60c8ca6');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_publication` (`id_publication`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `entraineur`
--
ALTER TABLE `entraineur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_entraineur` (`id_entraineur`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_match` (`id_match`),
  ADD KEY `ch_joueur_participant` (`id_joueur_participant`);

--
-- Index pour la table `fiche_pari`
--
ALTER TABLE `fiche_pari`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_equipe` (`id_equipe`);

--
-- Index pour la table `joueur_participant`
--
ALTER TABLE `joueur_participant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_joueur` (`id_joueur`);

--
-- Index pour la table `match_2018`
--
ALTER TABLE `match_2018`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_equipe_1` (`id_equipe_1`),
  ADD KEY `ck_equipe_2` (`id_equipe_2`),
  ADD KEY `ck_stade` (`id_stade`),
  ADD KEY `id` (`id`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Index pour la table `pari`
--
ALTER TABLE `pari`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_fiche_pari` (`id_fiche_pari`),
  ADD KEY `id_match` (`id_match`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id`),
  ADD KEY `ck_user` (`id_user`);

--
-- Index pour la table `stade`
--
ALTER TABLE `stade`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `entraineur`
--
ALTER TABLE `entraineur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `evenement`
--
ALTER TABLE `evenement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `fiche_pari`
--
ALTER TABLE `fiche_pari`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `joueur_participant`
--
ALTER TABLE `joueur_participant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `match_2018`
--
ALTER TABLE `match_2018`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `pari`
--
ALTER TABLE `pari`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `stade`
--
ALTER TABLE `stade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `id_publication` FOREIGN KEY (`id_publication`) REFERENCES `publication` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `ck_entraineur` FOREIGN KEY (`id_entraineur`) REFERENCES `entraineur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD CONSTRAINT `ch_joueur_participant` FOREIGN KEY (`id_joueur_participant`) REFERENCES `joueur_participant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ck_match` FOREIGN KEY (`id_match`) REFERENCES `match_2018` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `fiche_pari`
--
ALTER TABLE `fiche_pari`
  ADD CONSTRAINT `fiche_pari_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `ck_equipe` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `joueur_participant`
--
ALTER TABLE `joueur_participant`
  ADD CONSTRAINT `ck_joueur` FOREIGN KEY (`id_joueur`) REFERENCES `joueur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `match_2018`
--
ALTER TABLE `match_2018`
  ADD CONSTRAINT `ck_equipe_1` FOREIGN KEY (`id_equipe_1`) REFERENCES `equipe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ck_equipe_2` FOREIGN KEY (`id_equipe_2`) REFERENCES `equipe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ck_stade` FOREIGN KEY (`id_stade`) REFERENCES `stade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `match_2018_ibfk_1` FOREIGN KEY (`id_groupe`) REFERENCES `groupe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `pari`
--
ALTER TABLE `pari`
  ADD CONSTRAINT `pari_ibfk_1` FOREIGN KEY (`id_fiche_pari`) REFERENCES `fiche_pari` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pari_ibfk_2` FOREIGN KEY (`id_match`) REFERENCES `match_2018` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `publication`
--
ALTER TABLE `publication`
  ADD CONSTRAINT `ck_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
