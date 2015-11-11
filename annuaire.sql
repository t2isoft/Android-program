-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 10 Août 2015 à 12:52
-- Version du serveur :  5.6.21
-- Version de PHP :  5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `annuaire`
--

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
`id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `promotion` varchar(10) NOT NULL,
  `login` varchar(10) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `nom`, `prenom`, `telephone`, `mail`, `promotion`, `login`, `password`) VALUES
(1, 'Spoutil', 'Roland', '0651619531', 'r.spoutilt@insta.fr', '138', 'spoutil', '098f6bcd4621d373cade4e832627b4f6'),
(2, 'Kelleoglu', 'Karl', '0612234567', '', '', '', ''),
(3, 'Renaux', 'Rodolphe', '0654213698', '', '', '', ''),
(4, 'Beyer', 'Maxime', '0687459796', '', '', '', ''),
(5, 'Langrand', 'Ludovic', '0698474975', '', '', '', ''),
(6, 'Ls', 'Lounis', '0645120014', '', '', '', ''),
(7, 'Boufatis', 'Romaric', '0664874654', '', '', '', ''),
(8, 'Crepin', 'Gabriel', '0697465496', '', '', '', ''),
(9, 'Martins', 'Nicolas', '0641984198', '', '', '', ''),
(10, 'Soares', 'Michael', '0684165415', '', '', '', '');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
