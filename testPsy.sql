-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 10 Février 2017 à 16:48
-- Version du serveur :  5.7.17-0ubuntu0.16.04.1
-- Version de PHP :  7.0.13-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `testPsy`
--

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`id`, `nom`, `prenom`, `email`, `password`, `telephone`, `adresse`) VALUES
(188, 'tioutchi', 'mehdi', 'mohamedelmehditioutchi@gmail.com', '$2a$10$9f08f5ea74de8a6b06875uasXW21lsHClbFO.5TY8KCkidHhh5BOO', '0758228443', '3 rue aristide'),
(189, 'samad', 'abdi', 'ok@ok.fr', '$2a$10$9f08f5ea74de8a6b06875uasXW21lsHClbFO.5TY8KCkidHhh5BOO', '0758228443', 'casimire de lavigne');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `telephone` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `id_medecin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `patient`
--

INSERT INTO `patient` (`id`, `nom`, `prenom`, `email`, `password`, `telephone`, `adresse`, `id_medecin`) VALUES
(2, 'med', 'medi', 'medi@gmail.com', '$2a$10$9f08f5ea74de8a6b06875uasXW21lsHClbFO.5TY8KCkidHhh5BOO', '0758228443', 'adr', 189),
(3, 'tioutchii', 'mehdiii', 'samad@ok.fr', '$2a$10$9f08f5ea74de8a6b06875uasXW21lsHClbFO.5TY8KCkidHhh5BOO', '0758228443', 'add', 188),
(4, 'ayoub', 'ayoub', 'ayoub@ok.fra', '$2a$10$9f08f5ea74de8a6b06875uasXW21lsHClbFO.5TY8KCkidHhh5BOO', '0758228443', 'adr1', 189),
(5, 'bertelle', 'cyrille', 'bertelle@gmail.com', '$2a$10$278c2d9d4a1d9378724dcu5WX.rVXp0vM1jEyJ41BJpxYEqkZ0C3K', '07876765', 'univlehavre', 189),
(6, 'patient1', 'patient1', 'patien1@gmail.com', '$2a$10$b6a86aa04a9aa439b5348O4xtXUq4AfDFdCuyrsvwaGsQFaOSkrZm', '0758228443', 'adr1', 188);

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `pdf` varchar(100) NOT NULL,
  `id_patient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uid` (`id_medecin`);

--
-- Index pour la table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_patient` (`id_patient`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=190;
--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `patient`
--
ALTER TABLE `patient`
  ADD CONSTRAINT `FK_Id_Medecin` FOREIGN KEY (`id_medecin`) REFERENCES `medecin` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
