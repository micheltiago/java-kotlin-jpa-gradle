create table curso(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    categoria varchar(50) not null,
    primary key(id)
);

insert into curso values (1,'Spring Boot kotlin','Programação');
insert into curso values (2,'Spring Boot Java','Programação');
insert into curso values (3,'SCRUM','Analise de Sistemas');