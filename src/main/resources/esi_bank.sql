-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-01-2023 a las 11:46:15
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Base de datos: `esi_bank`
--
CREATE DATABASE IF NOT EXISTS `esi_bank` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `esi_bank`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--
-- Creación: 04-01-2023 a las 10:33:33
--

DROP TABLE IF EXISTS `consulta`;
CREATE TABLE `consulta` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `contenido` text NOT NULL,
  `gestor_id` int(11) NOT NULL COMMENT 'identificador del gestor',
  `user_id` int(11) NOT NULL COMMENT 'identificador del usuario del sistema'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `consulta`:
--   `gestor_id`
--       `user` -> `id`
--   `user_id`
--       `user` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_bancaria`
--
-- Creación: 04-01-2023 a las 10:15:59
--

DROP TABLE IF EXISTS `cuenta_bancaria`;
CREATE TABLE `cuenta_bancaria` (
  `id` int(11) NOT NULL,
  `iban` varchar(24) NOT NULL,
  `saldo` float NOT NULL DEFAULT 0,
  `fecha_creacion` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `cuenta_bancaria`:
--   `user_id`
--       `user` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movimiento`
--
-- Creación: 04-01-2023 a las 10:18:55
--

DROP TABLE IF EXISTS `movimiento`;
CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `valor` float NOT NULL,
  `cuenta_origen` int(11) DEFAULT NULL,
  `cuenta_destino` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `movimiento`:
--   `cuenta_destino`
--       `cuenta_bancaria` -> `id`
--   `cuenta_origen`
--       `cuenta_bancaria` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo_domiciliado`
--
-- Creación: 04-01-2023 a las 10:23:03
--

DROP TABLE IF EXISTS `recibo_domiciliado`;
CREATE TABLE `recibo_domiciliado` (
  `id` int(11) NOT NULL,
  `concepto` varchar(128) NOT NULL,
  `fecha` date NOT NULL,
  `valor` float NOT NULL DEFAULT 0,
  `cuenta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `recibo_domiciliado`:
--   `cuenta_id`
--       `cuenta_bancaria` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta`
--
-- Creación: 04-01-2023 a las 10:43:36
--

DROP TABLE IF EXISTS `respuesta`;
CREATE TABLE `respuesta` (
  `id` int(11) NOT NULL,
  `contenido` text NOT NULL,
  `fecha` date NOT NULL,
  `consulta_id` int(11) NOT NULL,
  `gestor_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `respuesta`:
--   `consulta_id`
--       `consulta` -> `id`
--   `gestor_id`
--       `user` -> `id`
--   `user_id`
--       `user` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjeta`
--
-- Creación: 04-01-2023 a las 10:30:43
--

DROP TABLE IF EXISTS `tarjeta`;
CREATE TABLE `tarjeta` (
  `id` int(11) NOT NULL,
  `numero` int(16) NOT NULL,
  `emisor` varchar(32) NOT NULL DEFAULT 'Visa',
  `pin` int(4) NOT NULL,
  `cvv` int(3) NOT NULL,
  `limite_maximo` float NOT NULL,
  `limite_minimo` float NOT NULL,
  `fecha_caducidad` date NOT NULL,
  `cuenta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- RELACIONES PARA LA TABLA `tarjeta`:
--   `cuenta_id`
--       `cuenta_bancaria` -> `id`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--
-- Creación: 04-01-2023 a las 10:10:06
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `dni` varchar(9) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `password` varchar(128) NOT NULL,
  `email` varchar(128) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Tabla de usuarios registrados en el sistema';

--
-- RELACIONES PARA LA TABLA `user`:
--

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_consulta` (`user_id`),
  ADD KEY `gestor_consulta` (`gestor_id`);

--
-- Indices de la tabla `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cuenta_user` (`user_id`);

--
-- Indices de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cuenta_mov_origen` (`cuenta_origen`),
  ADD KEY `cuenta_mov_destino` (`cuenta_destino`);

--
-- Indices de la tabla `recibo_domiciliado`
--
ALTER TABLE `recibo_domiciliado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cuenta_recibo` (`cuenta_id`);

--
-- Indices de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `consulta_respuesta` (`consulta_id`),
  ADD KEY `respuesta_user` (`user_id`),
  ADD KEY `respuesta_gestor` (`gestor_id`);

--
-- Indices de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cuenta_tarjeta` (`cuenta_id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `movimiento`
--
ALTER TABLE `movimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recibo_domiciliado`
--
ALTER TABLE `recibo_domiciliado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `respuesta`
--
ALTER TABLE `respuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `gestor_consulta` FOREIGN KEY (`gestor_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_consulta` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cuenta_bancaria`
--
ALTER TABLE `cuenta_bancaria`
  ADD CONSTRAINT `cuenta_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `movimiento`
--
ALTER TABLE `movimiento`
  ADD CONSTRAINT `cuenta_mov_destino` FOREIGN KEY (`cuenta_destino`) REFERENCES `cuenta_bancaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cuenta_mov_origen` FOREIGN KEY (`cuenta_origen`) REFERENCES `cuenta_bancaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recibo_domiciliado`
--
ALTER TABLE `recibo_domiciliado`
  ADD CONSTRAINT `cuenta_recibo` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta_bancaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `respuesta`
--
ALTER TABLE `respuesta`
  ADD CONSTRAINT `consulta_respuesta` FOREIGN KEY (`consulta_id`) REFERENCES `consulta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_gestor` FOREIGN KEY (`gestor_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `respuesta_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarjeta`
--
ALTER TABLE `tarjeta`
  ADD CONSTRAINT `cuenta_tarjeta` FOREIGN KEY (`cuenta_id`) REFERENCES `cuenta_bancaria` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;