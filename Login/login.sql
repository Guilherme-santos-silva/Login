create table senha
(
	login varchar(50),
	senha varchar(50),
	primary key (login, senha)
)

insert into senha (login, senha) values ('x','x')

select * from senha