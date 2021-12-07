create table tb_usuario(
  	id SERIAL,
 	usuario varchar(255),
 	senha varchar(100),
	fg_ativo int,
	constraint pk_empresa_id primary key (id)
);

insert into tb_usuario (usuario,senha)
	values
	('yuri','123456');
	
update tb_usuario set senha=md5('123456')
	where id = 1

select * from tb_usuario;

CREATE TABLE tb_categoria(
 id serial,
 nome varchar(250),
 fg_ativo int,	
 constraint pk_categoria_id primary key (id)
);

CREATE TABLE tb_produto (
 id serial,
 id_categoria int,
 nome varchar(250),
 preco numeric,
 taxa numeric,
 qntd int, 
 fg_ativo int,
constraint pk_produtos_id primary key (id),
constraint fk_categoria_id foreign key (id_categoria) references tb_categoria(id)
);

CREATE TABLE tb_combustiveis(    
    id serial,
    id_categoria int,
    nome varchar(250),
    preco numeric,
    qntl int,
    taxa numeric,
    fg_ativo int,
    constraint pk_combustiveis_id primary key(id),
    constraint fk_combustiveis_id foreign key (id_categoria) references tb_categoria(id)
);


CREATE TABLE tb_cliente(
 id serial,
 nome varchar(250),
 cpf varchar(250),
 fg_ativo int,
 ddd varchar (3),
 numero varchar(10),
 constraint pk_cliente_id primary key(id)
);
