CREATE TABLE pousada.categorias
(
    id bigserial PRIMARY KEY,
    descricao character varying(150) NOT NULL,
    capacidade integer NOT NULL,
    preco_diaria double precision NOT NULL
);
ALTER TABLE pousada.categorias
    OWNER TO es3_usuario;

CREATE TABLE pousada.quartos
(
    id bigserial PRIMARY KEY,
    numero character varying(10) NOT NULL,
    categoria_id bigint NOT NULL REFERENCES pousada.categorias (id)
);
ALTER TABLE pousada.quartos
    OWNER TO es3_usuario;

CREATE TABLE pousada.cartoes
(
    id bigserial PRIMARY KEY,
    numero character(16) NOT NULL,
    data_emissao character(5) NOT NULL,
    data_validade character(5) NOT NULL,
    codigo_seguranca character(3) NOT NULL
);
ALTER TABLE pousada.cartoes
    OWNER TO es3_usuario;

CREATE TABLE pousada.enderecos
(
    id bigserial PRIMARY KEY,
    estado character varying(2) NOT NULL,
    cidade character varying(150) NOT NULL,
    bairro character varying(150) NOT NULL,
    logradouro character varying(300) NOT NULL,
    numero character varying(10) NOT NULL
);
ALTER TABLE pousada.enderecos
    OWNER TO es3_usuario;

CREATE TABLE pousada.pagantes
(
    id bigserial PRIMARY KEY,
    nome character varying(150) NOT NULL,
    rg character varying(14) NOT NULL,
    cpf character(11) NOT NULL,
    email character varying(150) NOT NULL,
    telefone character varying(15) NOT NULL,
    endereco_id bigint NOT NULL REFERENCES pousada.pagantes(id),
    cartao_id bigint NOT NULL REFERENCES pousada.cartoes(id)    
);
ALTER TABLE pousada.pagantes
    OWNER TO es3_usuario;

CREATE TABLE pousada.reservas
(
    id bigserial PRIMARY KEY,
    data_check_in timestamp without time zone NOT NULL,
    data_check_out timestamp without time zone NOT NULL,
    observacoes text,
    pessoas character varying(150)[],
    pagante_id bigint NOT NULL REFERENCES pousada.pagantes(id)
);
ALTER TABLE pousada.reservas
    OWNER TO es3_usuario;

CREATE TABLE pousada.reservas_quartos
(
    reserva_id bigint REFERENCES pousada.reservas(id),
    quarto_id bigint REFERENCES pousada.quartos(id),
    PRIMARY KEY(reserva_id, quarto_id)
);
ALTER TABLE pousada.reservas_quartos
    OWNER TO es3_usuario;
