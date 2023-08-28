CREATE DATABASE `almoxarifado` DEFAULT CHARACTER SET utf8 ;

use almoxarifado;

create table Unidade (
	id int NOT NULL AUTO_INCREMENT,
    sigla varchar(50) NOT NULL,
    primary key (id)
);

create table Produto (
	id int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    unidadeId int,
    primary key (id),
    foreign key (unidadeId) references Unidade(id)
);

create table Entrada (
	id int NOT NULL AUTO_INCREMENT,
    produtoId int NOT NULL,
    quantidade int NOT NULL,
    dataEntrada datetime NOT NULL,
    primary key (id),
    foreign key (produtoId) references Produto(id)
);

create table Saida (
	id int NOT NULL AUTO_INCREMENT,
    produtoId int NOT NULL,
    quantidade int NOT NULL,
    dataSaida datetime NOT NULL,
    primary key (id),
    foreign key (produtoId) references Produto(id)
);