USE bdPocQuestionario;

CREATE TABLE tbQuestionario (
	idQuestionario INT NOT NULL AUTO_INCREMENT, 
	titulo VARCHAR (50) NOT NULL,
    descricao VARCHAR (50) NOT NULL,
    PRIMARY KEY (idQuestionario)

) ENGINE=INNODB;

CREATE TABLE tbCategoria (
	idCategoria INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR (50) NOT NULL,
    descricao VARCHAR (50) NOT NULL,
    idQuestionario INT NOT NULL,
    
    PRIMARY KEY (idCategoria),
    FOREIGN KEY (idQuestionario)
        REFERENCES tbQuestionario(idQuestionario)
        ON DELETE CASCADE

) ENGINE=INNODB;

CREATE TABLE tbQuestao (
	idQuestao INT NOT NULL AUTO_INCREMENT,
    pergunta VARCHAR (500) NOT NULL,
    idCategoria INT NOT NULL,
    
    PRIMARY KEY (idQuestao),
    FOREIGN KEY (idCategoria)
        REFERENCES tbCategoria(idCategoria)
        ON DELETE CASCADE

) ENGINE=INNODB;