-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2025 at 05:38 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mahasiswa`
--

-- --------------------------------------------------------

--
-- Table structure for table `biodata`
--

CREATE TABLE `biodata` (
  `NIM` varchar(15) NOT NULL,
  `Nama` varchar(100) NOT NULL,
  `Prodi` varchar(50) NOT NULL,
  `Fakultas` enum('FPTI','FPEB','FIP','FH','FK','FPMIPA','FPSD','FPOK') NOT NULL,
  `Alamat` varchar(255) NOT NULL,
  `Jenis_Kelamin` enum('L','P') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `biodata`
--

INSERT INTO `biodata` (`NIM`, `Nama`, `Prodi`, `Fakultas`, `Alamat`, `Jenis_Kelamin`) VALUES
('2500001', 'Rahma', 'Kedokteran', 'FK', 'Jl.Kesehatan', 'P'),
('2500742', 'Aliza', 'Pindidikan Agama Islam', 'FIP', 'Jl.Surga', 'P'),
('2500743', 'Baharudin', 'Kedokteran', 'FK', 'Jl.Kesehatan', 'L'),
('2500744', 'Shakira', 'Ilmu Hukum', 'FH', 'Jl.Keadilan', 'P'),
('2500748', 'Lee Jeno', 'Ilmu Olahraga', 'FPOK', 'Jl.Busan', 'L'),
('2500749', 'Nabila Zahra', 'Teknik Informatika', 'FPTI', 'Jl. Teknologi', 'P'),
('2500750', 'Rafi Ahmad', 'Manajemen', 'FPEB', 'Jl. Ekonomi', 'L'),
('2500751', 'Citra Amelia', 'Bimbingan dan Konseling', 'FIP', 'Jl. Pendidikan', 'P'),
('2500752', 'Dion Pratama', 'Ilmu Hukum', 'FH', 'Jl. Keadilan', 'L'),
('2500753', 'Alya Putri', 'Kedokteran Gigi', 'FK', 'Jl. Sehat Selalu', 'P'),
('2500754', 'Fadil Rahman', 'Matematika', 'FPMIPA', 'Jl. Angka Cerdas', 'L'),
('2500755', 'Hanifa Lestari', 'Desain Komunikasi Visual', 'FPSD', 'Jl. Kreatif', 'P'),
('2500756', 'Bagas Maulana', 'Pendidikan Jasmani', 'FPOK', 'Jl. Atletik', 'L'),
('2500757', 'Salsabila Ananda', 'Teknologi Pendidikan', 'FIP', 'Jl. Belajar', 'P'),
('2500758', 'Andi Setiawan', 'Ekonomi Syariah', 'FPEB', 'Jl. Amanah', 'L');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `biodata`
--
ALTER TABLE `biodata`
  ADD PRIMARY KEY (`NIM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
