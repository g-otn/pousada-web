CREATE TABLE pousada.categorias
(
    id bigserial PRIMARY KEY,
    descricao character varying(150) NOT NULL,
    capacidade integer NOT NULL,
    preco_diaria double precision NOT NULL
);

CREATE TABLE pousada.quartos
(
    id bigserial PRIMARY KEY,
    numero character varying(10) NOT NULL,
    categoria_id bigint REFERENCES pousada.categorias (id)
);

CREATE TABLE pousada.cartoes
(
    id bigserial PRIMARY KEY,
    numero character(16) NOT NULL,
    data_emissao character(5) NOT NULL,
    data_validade character(5) NOT NULL,
    codigo_seguranca character(3) NOT NULL
);

CREATE TABLE pousada.enderecos
(
    id bigserial PRIMARY KEY,
    estado character varying(2) NOT NULL,
    cidade character varying(150) NOT NULL,
    bairro character varying(150) NOT NULL,
    logradouro character varying(300) NOT NULL,
    numero character varying(10) NOT NULL
);

CREATE TABLE pousada.pagantes
(
    id bigserial PRIMARY KEY,
    nome character varying(150) NOT NULL,
    rg character varying(14) NOT NULL,
    cpf character(11) NOT NULL,
    email character varying(150) NOT NULL,
    telefone character varying(15) NOT NULL,
    endereco_id bigint REFERENCES pousada.pagantes(id),
    cartao_id bigint REFERENCES pousada.cartoes(id)    
);

CREATE TABLE pousada.reservas
(
    id bigserial PRIMARY KEY,
    data_check_in timestamp without time zone NOT NULL,
    data_check_out timestamp without time zone NOT NULL,
    observacoes text,
    pagante_id bigint REFERENCES pousada.pagantes(id)
);

CREATE TABLE pousada.pessoas
(
    id bigserial PRIMARY KEY,
    nome character varying(150) NOT NULL,
    reserva_id bigint REFERENCES pousada.reservas(id)
);
