-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 04-07-2017 a las 07:08:20
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcec`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurantees`
--

CREATE TABLE `restaurantees` (
  `id` bigint(20) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` varchar(255) NOT NULL,
  `Precio` varchar(255) NOT NULL,
  `Horario` varchar(255) NOT NULL,
  `Estado` varchar(255) NOT NULL,
  `Imagen` varchar(255) NOT NULL,
  `Pais` varchar(255) NOT NULL,
  `Direccion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Volcado de datos para la tabla `restaurantees`
--

INSERT INTO `restaurantees` (`id`, `Nombre`, `Descripcion`, `Precio`, `Horario`, `Estado`, `Imagen`, `Pais`, `Direccion`) VALUES
(1, 'ss', 'ssdf', '23', '23', 'chiapas', '', 'meico', 'conocido'),
(2, 'asdas', 'sadasd', '39', '34', 'San Clemente', 'imagenes/hotel.jpg', 'Mexico', '(16.3788331, -93.81857869999999)'),
(3, 'come rico', 'esta muy rico', '123123', '24', 'Oaxaca', 'imagenes/hotel.jpg', 'Mexico', '(17.6073656, -96.94597549999997)');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `restaurantees`
--
ALTER TABLE `restaurantees`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Nombre` (`Nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `restaurantees`
--
ALTER TABLE `restaurantees`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
