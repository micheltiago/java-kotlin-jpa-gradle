create table usuario(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario values (1,'Tiago Michel','tmichel@hotmail.com');
insert into usuario values (2,'Lucas Jung','lucasjung@hotmail.com');
insert into usuario values (3,'Natalia Jung','nat@gmail.com');