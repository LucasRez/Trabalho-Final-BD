CREATE TABLE Orgao_Superior
(
  OrgSupNome varchar(200) NOT NULL,
  OrgSupCod INTEGER NOT NULL,
  PRIMARY KEY (OrgSupCod)
);

CREATE TABLE Orgao_Subordinado
(
  OrgSubCod INTEGER NOT NULL,
  OrgSubNome varchar(200) NOT NULL,
  OrgSupCod INTEGER NOT NULL,
  PRIMARY KEY (OrgSubCod),
  FOREIGN KEY (OrgSupCod) REFERENCES Orgao_Superior(OrgSupCod)
);

CREATE TABLE Unidade_gestora
(
  UniGestNome varchar(200) NOT NULL,
  UniGestCod INTEGER NOT NULL,
  OrgSubCod INTEGER NOT NULL,
  PRIMARY KEY (UniGestCod),
  FOREIGN KEY (OrgSubCod) REFERENCES Orgao_Subordinado(OrgSubCod)
);

CREATE TABLE Funcao
(
  FuncNome varchar(200) NOT NULL,
  FuncCod INTEGER NOT NULL,
  PRIMARY KEY (FuncCod)
);

CREATE TABLE Subfuncao
(
  SubfuncNome varchar(200) NOT NULL,
  SubfuncCod INTEGER NOT NULL,
  PRIMARY KEY (SubfuncCod)
);

CREATE TABLE Programa
(
  ProgNome varchar(200) NOT NULL,
  ProgCod INTEGER NOT NULL,
  PRIMARY KEY (ProgCod)
);

CREATE TABLE Acao
(
  AcaoNome varchar(200) NOT NULL,
  AcaoCod varchar(20) NOT NULL,
  Linguagem_cidada varchar(200),
  ProgCod INTEGER NOT NULL,
  PRIMARY KEY (AcaoCod),
  FOREIGN KEY (ProgCod) REFERENCES Programa(ProgCod)
);

CREATE TABLE Favorecido
(
  FavorecidoID serial primary key,
  FavorecidoCPF char(14) NOT NULL,
  FavorecidoNome varchar(200) NOT NULL,
  UniGestCod INTEGER NOT NULL,
  FOREIGN KEY (UniGestCod) REFERENCES Unidade_gestora(UniGestCod),
  unique(FavorecidoID, FavorecidoCPF)
);

CREATE TABLE Pagamento
(
  PagamCod char(12) NOT NULL,
  PagamData char(10) NOT NULL,
  PagamValor real NOT NULL,
  PagamGestCod INTEGER NOT NULL,
  FavorecidoCPF char(14) NOT NULL,
  FavorecidoID serial,
  PRIMARY KEY (FavorecidoID),
  FOREIGN KEY (FavorecidoID, FavorecidoCPF) REFERENCES Favorecido(FavorecidoID, FavorecidoCPF),
  unique(PagamCod, FavorecidoID)
);

CREATE TABLE Exerce
(
  UniGestCod INTEGER NOT NULL,
  FuncCod INTEGER NOT NULL,
  PRIMARY KEY (UniGestCod, FuncCod),
  FOREIGN KEY (UniGestCod) REFERENCES Unidade_gestora(UniGestCod),
  FOREIGN KEY (FuncCod) REFERENCES Funcao(FuncCod)
);

CREATE TABLE Possui
(
  FuncCod INTEGER NOT NULL,
  SubfuncCod INTEGER NOT NULL,
  PRIMARY KEY (FuncCod, SubfuncCod),
  FOREIGN KEY (FuncCod) REFERENCES Funcao(FuncCod),
  FOREIGN KEY (SubfuncCod) REFERENCES Subfuncao(SubfuncCod)
);


CREATE temp TABLE tab_temp(
  CodOrgSup integer not null,
  NomeCodSup varchar(200) not null,
  CodOrgSub integer not null,
  NomeOrgSub varchar(200) not null,
  CodUniGest integer not null,
  NomeUniGest varchar(200) not null,
  CodFunc integer not null,
  NomeFunc varchar(200) not null,
  CodSubFunc integer not null,
  NomeSubFunc varchar(200) not null,
  CodProg integer not null,
  NomeProg varchar(200) not null,
  CodAcao varchar(20) not null,
  NomeAcao varchar(200) not null,
  LingCidada varchar(200),
  CPFFav char(14) not null,
  NomeFav varchar(200) not null,
  CodPagam char(12) not null,
  GestPagam integer not null,
  DataPagam char(10) not null,
  ValorPagam real not null 
);

copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201301_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;
copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201302_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;
copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201303_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;
copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201304_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;
copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201305_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;
copy tab_temp FROM '/home/victor/UnB/Semestre6/BD/Trabalhos/ProjetoFinal/Dados/201306_Diarias.csv' delimiter '	' encoding 'WIN1252' csv header;

insert into Orgao_Superior (OrgSupCod, OrgSupNome)
select distinct on (CodOrgSup) CodOrgSup, NomeCodSup from tab_temp order by CodOrgSup, NomeCodSup;

insert into Orgao_Subordinado (OrgSubCod, OrgSubNome, OrgSupCod)
select distinct on (CodOrgSub) CodOrgSub, NomeOrgSub, CodOrgSup from tab_temp order by CodOrgSub, NomeOrgSub, CodOrgSup;

insert into Unidade_gestora (UniGestCod, UniGestNome, OrgSubCod)
select distinct on (CodUniGest) CodUniGest, NomeUniGest, CodOrgSub from tab_temp order by CodUniGest, NomeUniGest, CodOrgSub;

insert into Funcao (FuncCod, FuncNome)
select distinct on (CodFunc) CodFunc, NomeFunc from tab_temp order by CodFunc, NomeFunc;

insert into Subfuncao (SubfuncCod, SubfuncNome)
select distinct on (CodSubFunc) CodSubFunc, NomeSubFunc from tab_temp order by CodSubFunc, NomeSubFunc;

insert into Programa (ProgCod, ProgNome)
select distinct on (CodProg) CodProg, NomeProg from tab_temp order by CodProg, NomeProg;

insert into Acao (AcaoCod, AcaoNome, Linguagem_cidada, ProgCod)
select distinct on (CodAcao) CodAcao, NomeAcao, LingCidada, CodProg from tab_temp order by CodAcao, NomeAcao, LingCidada, CodProg;

insert into Favorecido (FavorecidoCPF, FavorecidoNome, UniGestCod)
select CPFFav, NomeFav, CodUniGest from tab_temp;

insert into Pagamento (FavorecidoCPF, PagamData, PagamValor, PagamGestCod, PagamCod)
select CPFFav, DataPagam, ValorPagam, GestPagam, CodPagam from tab_temp;

insert into Exerce (UniGestCod, FuncCod)
select distinct on (CodUniGest) CodUniGest, CodFunc from tab_temp order by CodUniGest, CodFunc;

insert into Possui (FuncCod, SubfuncCod)
select distinct on (CodFunc) CodFunc, CodSubFunc from tab_temp order by CodFunc, CodSubFunc;


