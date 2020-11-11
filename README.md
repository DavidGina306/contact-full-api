<h1 align="center">Bem vindo a CONTACT FULL API 👋</h1>
<p align="center">
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <img src="https://img.shields.io/badge/JDK-%3E%3D1.8-blue.svg" />
  <img src="https://img.shields.io/badge/Maven-%3E%3D3.0-blue.svg" />
  <img src="https://img.shields.io/badge/SPRING-%3E%3D2.3.4-green.svg" />
  <img src="https://img.shields.io/badge/MYSQL-%3E%3D5.6-red.svg" />
  <a href="https://github.com/DavidGina306/contacts#readme" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://github.com/kefranabg/readme-md-generator/graphs/commit-activity" target="_blank">
    <img alt="Maintenance" src="https://img.shields.io/badge/Maintained%3F-yes-green.svg" />
  </a>
</p>

## Requerimentos

Para fazer o building e executar a aplicação é necessário:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [MYSQL](https://www.mysql.com/)

## ER DB - MYSQL
![contato](https://user-images.githubusercontent.com/39013655/98778000-0f2d7200-23c8-11eb-836d-4c719804c168.PNG)

## Configuração do server e da conexão do MYSQL 
No arquivo <strong>application.properties</strong> localizado em  src/main/resources/application.properties
```
server.port=9090

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/contacts?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
````
## Script SQL
No arquivo <strong>scriptsqldb.sql</strong> localizado em database/scriptsqldb.sql
```
CREATE DATABASE contacts;

use contacts; 

CREATE TABLE contatos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_date datetime DEFAULT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255)  NOT NULL,
  sexo char(1)  NOT NULL,
  telefone varchar(255)  NOT NULL,
  updated_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
```
## Front End da Aplicação em vue 

https://github.com/DavidGina306/contact-front


