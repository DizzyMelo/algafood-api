insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tomatto', 20, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Don Matias', 30, 2);

insert into forma_pagamento (descricao) values ('Dinheiro');
insert into forma_pagamento (descricao) values ('Credito');


insert into permissao (nome, descricao) values ('Cadastro', 'Pode cadastrar novos clientes');
insert into permissao (nome, descricao) values ('Edicao', 'Pode editar clientes');

insert into estado (nome) values ('RN');
insert into estado (nome) values ('CE');

insert into cidade (nome, estado_id) values ('Natal', 1);
insert into cidade (nome, estado_id) values ('Fortaleza', 2);
