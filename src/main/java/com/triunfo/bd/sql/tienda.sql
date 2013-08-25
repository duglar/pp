-- phpMyAdmin SQL Dump
-- version 3.5.8.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-08-2013 a las 19:58:38
-- Versión del servidor: 5.5.32-0ubuntu0.13.04.1
-- Versión de PHP: 5.4.9-4ubuntu2.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblbarrio`
--

CREATE TABLE IF NOT EXISTS `tblbarrio` (
  `SECBARRIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `SECMUNICIPIO` int(11) NOT NULL,
  PRIMARY KEY (`SECBARRIO`),
  KEY `FK_MUNICIPIO1234` (`SECMUNICIPIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcategoria`
--

CREATE TABLE IF NOT EXISTS `tblcategoria` (
  `SECCATEGORIA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRECATEGORIA` varchar(45) NOT NULL,
  PRIMARY KEY (`SECCATEGORIA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblcompra`
--

CREATE TABLE IF NOT EXISTS `tblcompra` (
  `SECCOMPRA` int(11) NOT NULL AUTO_INCREMENT,
  `SECPERSONA` int(11) NOT NULL,
  `SECPUNTODEVENTA` int(11) NOT NULL,
  `SECPROVEEDOR` int(11) NOT NULL,
  `TOTAL` decimal(50,0) NOT NULL,
  `TOTAL_CANTIDAD` decimal(50,0) NOT NULL,
  `DESCRIPCION` varchar(200) NOT NULL,
  PRIMARY KEY (`SECCOMPRA`),
  KEY `FK_PERSONA1234` (`SECPERSONA`),
  KEY `FK_PROVEEDOR123` (`SECPROVEEDOR`),
  KEY `FK_PUNTOVENTA1234` (`SECPUNTODEVENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldepartamento`
--

CREATE TABLE IF NOT EXISTS `tbldepartamento` (
  `SECDEPARTAMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `SECPAIS` int(11) NOT NULL,
  PRIMARY KEY (`SECDEPARTAMENTO`),
  KEY `FK_PAIS` (`SECPAIS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetallecompra`
--

CREATE TABLE IF NOT EXISTS `tbldetallecompra` (
  `SECDETALLECOMPRA` int(11) NOT NULL AUTO_INCREMENT,
  `SECPRODUCTO` int(11) NOT NULL,
  `SECCOMPRA` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `SUBTOTAL` decimal(50,0) NOT NULL,
  PRIMARY KEY (`SECDETALLECOMPRA`),
  KEY `FK_PRODUCTO123` (`SECPRODUCTO`),
  KEY `FK_COMPRA123` (`SECCOMPRA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldetalleventa`
--

CREATE TABLE IF NOT EXISTS `tbldetalleventa` (
  `SECDETALLEVENTA` int(11) NOT NULL AUTO_INCREMENT,
  `SECPRODUCTO` int(11) NOT NULL,
  `SECVENTA` int(11) NOT NULL,
  `SUBTOTAL` decimal(50,0) NOT NULL,
  PRIMARY KEY (`SECDETALLEVENTA`),
  KEY `FK_PRODUCTO` (`SECPRODUCTO`),
  KEY `FK_VENTA` (`SECVENTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbldocumento`
--

CREATE TABLE IF NOT EXISTS `tbldocumento` (
  `SECDOCUMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO` varchar(45) NOT NULL,
  `SECTIPODOCUMENTO` int(11) NOT NULL,
  PRIMARY KEY (`SECDOCUMENTO`),
  KEY `FK_TIPODOCUMENTO` (`SECTIPODOCUMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmarca`
--

CREATE TABLE IF NOT EXISTS `tblmarca` (
  `SECMARCA` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBREMARCA` varchar(45) NOT NULL,
  PRIMARY KEY (`SECMARCA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblmunicipio`
--

CREATE TABLE IF NOT EXISTS `tblmunicipio` (
  `SECMUNICIPIO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `SECDEPARTAMENTO` int(11) NOT NULL,
  PRIMARY KEY (`SECMUNICIPIO`),
  KEY `FK_DEPARTAMENTO` (`SECDEPARTAMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpais`
--

CREATE TABLE IF NOT EXISTS `tblpais` (
  `SECPAIS` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  PRIMARY KEY (`SECPAIS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TBLPERSONA`
--

CREATE TABLE IF NOT EXISTS `TBLPERSONA` (
  `SECPERSONA` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `PNOMBRE` varchar(45) NOT NULL,
  `SNOMBRE` varchar(45) NOT NULL,
  `PAPELLIDO` varchar(45) NOT NULL,
  `SAPELLIDO` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `EMAIL` varchar(45) DEFAULT NULL,
  `SECSEXO` int(11) NOT NULL,
  `SECTIPOPERSONA` int(11) NOT NULL,
  `SECMUNICIPIO` int(11) NOT NULL,
  `SECDOCUMENTO` int(11) NOT NULL,
  PRIMARY KEY (`SECPERSONA`),
  KEY `FK_DOCUMENTO123` (`SECDOCUMENTO`),
  KEY `FK_MUNICIPIO123` (`SECMUNICIPIO`),
  KEY `FK_SEXO` (`SECSEXO`),
  KEY `FK_TIPOPERSONA` (`SECTIPOPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpreciocompra`
--

CREATE TABLE IF NOT EXISTS `tblpreciocompra` (
  `SECPRECIO_COMPRA` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` date NOT NULL,
  `PRECIO` decimal(50,0) NOT NULL,
  PRIMARY KEY (`SECPRECIO_COMPRA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproducto`
--

CREATE TABLE IF NOT EXISTS `tblproducto` (
  `SECPRODUCTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE_PRODUCTO` varchar(45) NOT NULL,
  `SECPROVEEDOR` int(11) NOT NULL,
  `SECCATEGORIA` int(11) NOT NULL,
  `SECMARCA` int(11) NOT NULL,
  `SECPRECIOCOMPRA` int(11) NOT NULL,
  `SECUNIDAD` int(11) NOT NULL,
  `CODIGO` int(11) NOT NULL,
  `CANTIDAD` int(11) NOT NULL,
  `PRECIOVENTA` decimal(50,0) NOT NULL,
  PRIMARY KEY (`SECPRODUCTO`),
  KEY `FK_PROVEEDOR` (`SECPROVEEDOR`),
  KEY `FK_CATEGORIA` (`SECCATEGORIA`),
  KEY `FK_MARCA` (`SECMARCA`),
  KEY `FK_UNIDAD` (`SECUNIDAD`),
  KEY `FK_PRECIO_COMPRA` (`SECPRECIOCOMPRA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblproveedor`
--

CREATE TABLE IF NOT EXISTS `tblproveedor` (
  `SECPROVEEDOR` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `SECMUNICIPIO` int(11) NOT NULL,
  `NIT` varchar(45) NOT NULL,
  PRIMARY KEY (`SECPROVEEDOR`),
  KEY `FK_MUNICIPIO` (`SECMUNICIPIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblpuntodeventa`
--

CREATE TABLE IF NOT EXISTS `tblpuntodeventa` (
  `SECPUNTODEVENTA` int(11) NOT NULL AUTO_INCREMENT,
  `SECPERSONA` int(11) NOT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `DIRECCION` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `TELEFONO` varchar(45) NOT NULL,
  `NIT` varchar(45) NOT NULL,
  PRIMARY KEY (`SECPUNTODEVENTA`),
  KEY `FK_PERSONA` (`SECPERSONA`),
  KEY `FK_PERSONA123456` (`SECPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblrol`
--

CREATE TABLE IF NOT EXISTS `tblrol` (
  `SECROL` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`SECROL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblsexo`
--

CREATE TABLE IF NOT EXISTS `tblsexo` (
  `SECSEXO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`SECSEXO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipodocumento`
--

CREATE TABLE IF NOT EXISTS `tbltipodocumento` (
  `SECTIPODOCUMENTO` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`SECTIPODOCUMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbltipopersona`
--

CREATE TABLE IF NOT EXISTS `tbltipopersona` (
  `SECTIPOPERSONA` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(45) NOT NULL,
  PRIMARY KEY (`SECTIPOPERSONA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblunidad`
--

CREATE TABLE IF NOT EXISTS `tblunidad` (
  `SECUNIDAD` int(11) NOT NULL AUTO_INCREMENT,
  `UNIDADES` varchar(45) NOT NULL,
  PRIMARY KEY (`SECUNIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblusuario`
--

CREATE TABLE IF NOT EXISTS `tblusuario` (
  `SECUSUARIO` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `SECROL` int(11) NOT NULL,
  PRIMARY KEY (`SECUSUARIO`),
  KEY `FK_ROL1` (`SECROL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tblventa`
--

CREATE TABLE IF NOT EXISTS `tblventa` (
  `SECVENTA` int(11) NOT NULL AUTO_INCREMENT,
  `FECHA` date NOT NULL,
  `SECPUNTODEVENTA` int(11) NOT NULL,
  `SECCLIENTE` int(11) NOT NULL,
  `OBSERVACION` varchar(200) DEFAULT NULL,
  `SECVENDEDOR` int(11) NOT NULL,
  `TOTAL` decimal(10,0) DEFAULT NULL,
  `TOTAL_CANTIDAD` int(11) DEFAULT NULL,
  PRIMARY KEY (`SECVENTA`),
  KEY `FK_CLIENTE` (`SECCLIENTE`),
  KEY `FK_PUNTOVENTA` (`SECPUNTODEVENTA`),
  KEY `FK_VENDEDOR` (`SECVENDEDOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tblbarrio`
--
ALTER TABLE `tblbarrio`
  ADD CONSTRAINT `FK_MUNICIPIO1234` FOREIGN KEY (`SECMUNICIPIO`) REFERENCES `tblmunicipio` (`SECMUNICIPIO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblcompra`
--
ALTER TABLE `tblcompra`
  ADD CONSTRAINT `FK_PUNTOVENTA1234` FOREIGN KEY (`SECPUNTODEVENTA`) REFERENCES `tblpuntodeventa` (`SECPUNTODEVENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PERSONA1234` FOREIGN KEY (`SECPERSONA`) REFERENCES `TBLPERSONA` (`SECPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PROVEEDOR123` FOREIGN KEY (`SECPROVEEDOR`) REFERENCES `tblproveedor` (`SECPROVEEDOR`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldepartamento`
--
ALTER TABLE `tbldepartamento`
  ADD CONSTRAINT `FK_PAIS` FOREIGN KEY (`SECPAIS`) REFERENCES `tblpais` (`SECPAIS`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldetallecompra`
--
ALTER TABLE `tbldetallecompra`
  ADD CONSTRAINT `FK_COMPRA123` FOREIGN KEY (`SECCOMPRA`) REFERENCES `tblcompra` (`SECCOMPRA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PRODUCTO123` FOREIGN KEY (`SECPRODUCTO`) REFERENCES `tblproducto` (`SECPRODUCTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldetalleventa`
--
ALTER TABLE `tbldetalleventa`
  ADD CONSTRAINT `FK_PRODUCTO` FOREIGN KEY (`SECPRODUCTO`) REFERENCES `tblproducto` (`SECPRODUCTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_VENTA` FOREIGN KEY (`SECVENTA`) REFERENCES `tblventa` (`SECVENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tbldocumento`
--
ALTER TABLE `tbldocumento`
  ADD CONSTRAINT `FK_TIPODOCUMENTO` FOREIGN KEY (`SECTIPODOCUMENTO`) REFERENCES `tbltipodocumento` (`SECTIPODOCUMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblmunicipio`
--
ALTER TABLE `tblmunicipio`
  ADD CONSTRAINT `FK_DEPARTAMENTO` FOREIGN KEY (`SECDEPARTAMENTO`) REFERENCES `tbldepartamento` (`SECDEPARTAMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `TBLPERSONA`
--
ALTER TABLE `TBLPERSONA`
  ADD CONSTRAINT `FK_TIPOPERSONA` FOREIGN KEY (`SECTIPOPERSONA`) REFERENCES `tbltipopersona` (`SECTIPOPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_DOCUMENTO123` FOREIGN KEY (`SECDOCUMENTO`) REFERENCES `tbldocumento` (`SECDOCUMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_MUNICIPIO123` FOREIGN KEY (`SECMUNICIPIO`) REFERENCES `tblmunicipio` (`SECMUNICIPIO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SEXO` FOREIGN KEY (`SECSEXO`) REFERENCES `tblsexo` (`SECSEXO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblproducto`
--
ALTER TABLE `tblproducto`
  ADD CONSTRAINT `FK_PRECIO_COMPRA` FOREIGN KEY (`SECPRECIOCOMPRA`) REFERENCES `tblpreciocompra` (`SECPRECIO_COMPRA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CATEGORIA` FOREIGN KEY (`SECCATEGORIA`) REFERENCES `tblcategoria` (`SECCATEGORIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_MARCA` FOREIGN KEY (`SECMARCA`) REFERENCES `tblmarca` (`SECMARCA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PROVEEDOR` FOREIGN KEY (`SECPROVEEDOR`) REFERENCES `tblproveedor` (`SECPROVEEDOR`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_UNIDAD` FOREIGN KEY (`SECUNIDAD`) REFERENCES `tblunidad` (`SECUNIDAD`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblproveedor`
--
ALTER TABLE `tblproveedor`
  ADD CONSTRAINT `FK_MUNICIPIO` FOREIGN KEY (`SECMUNICIPIO`) REFERENCES `tblmunicipio` (`SECMUNICIPIO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblpuntodeventa`
--
ALTER TABLE `tblpuntodeventa`
  ADD CONSTRAINT `FK_PERSONA123456` FOREIGN KEY (`SECPERSONA`) REFERENCES `TBLPERSONA` (`SECPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD CONSTRAINT `FK_ROL1` FOREIGN KEY (`SECROL`) REFERENCES `tblrol` (`SECROL`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `tblventa`
--
ALTER TABLE `tblventa`
  ADD CONSTRAINT `FK_VENDEDOR` FOREIGN KEY (`SECVENDEDOR`) REFERENCES `TBLPERSONA` (`SECPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CLIENTE` FOREIGN KEY (`SECCLIENTE`) REFERENCES `TBLPERSONA` (`SECPERSONA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_PUNTOVENTA` FOREIGN KEY (`SECPUNTODEVENTA`) REFERENCES `tblpuntodeventa` (`SECPUNTODEVENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
