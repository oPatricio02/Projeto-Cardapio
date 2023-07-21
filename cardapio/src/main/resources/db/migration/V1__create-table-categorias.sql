CREATE TABLE categorias(
   id bigint NOT NULL AUTO_INCREMENT,
   nome VARCHAR(45) NULL,
   descricao VARCHAR(45) NULL,
   valor DECIMAL NULL,
  PRIMARY KEY (id)
  );



-- -----------------------------------------------------
-- Table produtos
-- -----------------------------------------------------
CREATE TABLE produtos (
   id bigint NOT NULL AUTO_INCREMENT,
   categoria bigint NOT NULL,
   nome VARCHAR(45) NULL,
   descricao VARCHAR(45) NULL,
   valor DECIMAL NULL,
  PRIMARY KEY (id),
  INDEX `id_categoria_idx` (`categoria` ASC) VISIBLE,
  CONSTRAINT id
    FOREIGN KEY (categoria)
    REFERENCES categorias (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

