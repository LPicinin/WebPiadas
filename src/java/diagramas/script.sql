
CREATE TABLE public.usuario (
                pass_user VARCHAR(20) NOT NULL,
                login_user VARCHAR(50) NOT NULL,
                nivel INTEGER NOT NULL,
                CONSTRAINT usuario_pk PRIMARY KEY (pass_user, login_user)
);


CREATE SEQUENCE public.usuario_cod_seq_2;

CREATE TABLE public.categoria (
                cod_cat INTEGER NOT NULL DEFAULT nextval('public.usuario_cod_seq_2'),
                nome_cat VARCHAR(50) NOT NULL,
                descr_cat VARCHAR(50) NOT NULL,
                CONSTRAINT categoria_pk PRIMARY KEY (cod_cat)
);


ALTER SEQUENCE public.usuario_cod_seq_2 OWNED BY public.categoria.cod_cat;

CREATE SEQUENCE public.usuario_cod_seq;

CREATE TABLE public.piada (
                cod INTEGER NOT NULL DEFAULT nextval('public.usuario_cod_seq'),
                cod_cat INTEGER NOT NULL,
                like_piada INTEGER NOT NULL,
                deslike_piada INTEGER NOT NULL,
                titulo_piada VARCHAR(50) NOT NULL,
                palchave_piada VARCHAR(50) NOT NULL,
                pontuacao_piada INTEGER NOT NULL,
                texto_piada VARCHAR NOT NULL,
                datacad_piada TIMESTAMP NOT NULL,
                grr_piada INTEGER NOT NULL,
                pass_user VARCHAR(20) NOT NULL,
                login_user VARCHAR(50) NOT NULL,
                CONSTRAINT piada_pk PRIMARY KEY (cod)
);


ALTER SEQUENCE public.usuario_cod_seq OWNED BY public.piada.cod;

ALTER TABLE public.piada ADD CONSTRAINT usuario_piada_fk
FOREIGN KEY (pass_user, login_user)
REFERENCES public.usuario (pass_user, login_user)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.piada ADD CONSTRAINT categoria_piada_fk
FOREIGN KEY (cod_cat)
REFERENCES public.categoria (cod_cat)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

INSERT INTO public.usuario(pass_user, login_user, nivel) VALUES ('adm', 'adm', 0);
INSERT INTO public.categoria(
	nome_cat, descr_cat)
	VALUES ('Futebol', 'Coisa de Gado'); 

INSERT INTO public.piada(
	cod_cat, like_piada, deslike_piada, titulo_piada, palchave_piada, pontuacao_piada, texto_piada, datacad_piada, grr_piada, pass_user, login_user)
	VALUES (1, 0, 0, 'Flamengo é seleção', 'flamengo libertadores', 0, 'Você pensa que o flamengo é time', '2019-10-25', 0, 'adm', 'adm');