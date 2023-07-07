-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 06, 2023 at 06:31 AM
-- Server version: 8.0.30
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_reservasi_baru`
--

-- --------------------------------------------------------

--
-- Table structure for table `db_kamar`
--

CREATE TABLE `db_kamar` (
  `id_kamar` int NOT NULL,
  `type_kamar` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `jumlah_kamar` int NOT NULL,
  `harga` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `db_kamar`
--

INSERT INTO `db_kamar` (`id_kamar`, `type_kamar`, `jumlah_kamar`, `harga`) VALUES
(1, 'A0-1', 12, 1000000),
(2, 'A0-2', 10, 1000000);

-- --------------------------------------------------------

--
-- Table structure for table `db_reservasi`
--

CREATE TABLE `db_reservasi` (
  `id_reservasi` int NOT NULL,
  `id_tamu` int NOT NULL,
  `id_kamar` int NOT NULL,
  `type_kamar` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `duration` int NOT NULL,
  `total_harga` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `db_tamu`
--

CREATE TABLE `db_tamu` (
  `id_tamu` int NOT NULL,
  `nama_tamu` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `no_identitas` int NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `no_telepon` int NOT NULL,
  `alamat` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `db_tamu`
--

INSERT INTO `db_tamu` (`id_tamu`, `nama_tamu`, `no_identitas`, `email`, `no_telepon`, `alamat`) VALUES
(5, 'Agus Budi', 767767676, 'Agus77@gmail.com', 854232432, 'Denpasar'),
(6, 'Agus Budi', 767767676, 'Agus77@gmail.com', 854232432, 'Denpasar'),
(8, 'Juniarta', 1212, 'juniarta@test.com', 89991911, 'denpasar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `db_kamar`
--
ALTER TABLE `db_kamar`
  ADD PRIMARY KEY (`id_kamar`);

--
-- Indexes for table `db_reservasi`
--
ALTER TABLE `db_reservasi`
  ADD PRIMARY KEY (`id_reservasi`),
  ADD KEY `id_tamu` (`id_tamu`),
  ADD KEY `id_user` (`id_kamar`);

--
-- Indexes for table `db_tamu`
--
ALTER TABLE `db_tamu`
  ADD PRIMARY KEY (`id_tamu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `db_kamar`
--
ALTER TABLE `db_kamar`
  MODIFY `id_kamar` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `db_reservasi`
--
ALTER TABLE `db_reservasi`
  MODIFY `id_reservasi` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `db_tamu`
--
ALTER TABLE `db_tamu`
  MODIFY `id_tamu` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `db_reservasi`
--
ALTER TABLE `db_reservasi`
  ADD CONSTRAINT `db_reservasi_ibfk_1` FOREIGN KEY (`id_tamu`) REFERENCES `db_tamu` (`id_tamu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `db_reservasi_ibfk_2` FOREIGN KEY (`id_kamar`) REFERENCES `db_kamar` (`id_kamar`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
