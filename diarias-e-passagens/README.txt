Nome dos Alunos

Bruno Jos� Bergamaschi Kumer Reis ___________________14/0017666
Victor Ara�jo Vieira ________________________________14/0032801

O que foi implementado em nosso programa?
Todas as funcionalidades  pedidas no TODO foram implementadas, com DAOs adicionais para melhor funcionamento
do programa e tamb�m uma interface gr�fica textual, que permite a verifica��o de todas as funcionalidades pe-
didas via console.Todas as entradas foram verificadas e corrigidas caso inseridas de forma equivocada, e fi-
zemos uma extensa  cole��o de testes que testam todas as fun��es de altera��o no banco de dados e verifica��o
do mesmo e todas passaram com sucesso.

Como deve ser executado o programa?

1.O programa foi testado e funcionou corretamente no Eclipse JEE Mars

2.Deve se descompactar o arquivo zip, abrir o eclipse, ir em File -> Import ->Existing Projects into Workspace ->Em "Select root directory" navegar at� a pasta extra�da do zip
e selecion�-la -> Apertar em Finish

3.O banco de dados utilizado no programa foi o PgAdmin III. Para rodar o programa deve-se instalar o PostgreSQL. Para baix�-lo, basta entrar nesse site http://www.postgresql.org/download/
Selecionar a vers�o correspondente ao seu sistema operacional e realizar o download. Execute o instalador baixado e siga as instru��es at� completar a instala��o. Caso ele pe�a qual senha
o senhor deseja utilizar para acessar o banco de dados, para maior facilidade  use a senha "postgres" que � a padr�o do Banco de Dados. Ao acessar o PgAdmin III, clique duas vezes no servidor
que foi escolhido durante a instala��o e digite sua senha (Caso sua senha seja diferente da padr�o dita acima, voc� deve ir at� o arquivo persistence.xml localizado em imdb->src->main->java->
->META-INF->persistence.xml e nas linhas 12 e 13 voc� deve colocar o usu�rio e a senha correspondentes as suas). Tendo acesso ao banco de dados, clique com o bot�o de direito em cima de Database
e selecione a op��o New Database... e crie uma nova database com o nome imdb.

Existe um teste no diret�rio na pasta imdb->src->test->java chamado IMDBPopulandoBDTeste.java, aperte com o bot�o direito nele, selecione run as->JUNIT test para popular seu banco de dados com
alguns filmes, albuns e faixas m�sicais. Caso o senhor deseje, pode acrescentar essas coisas manualmente via PgAdmin III. Para verificar os filmes,albuns,g�nero e autores gerados pelo teste,
v� at� o PGAdmin III->Database->schemas->public->Tables e aperta na tabela que deseja ver e em seguida aperta na tabela no lado direito da lupa escrito sql dentro na parte superior do software.
� interessante fazer isso para digitar nomes v�lidos nas pesquisas.

4.Para executar o software, aperte com o bot�o direito na classe IMDB.java e selecione run as->Java Application. Essa classe encontra-se em imdb/src/main/java/br.unb.cic.imdb.ui

OBSERVA��O IMPORTANTE : Caso j� tenha usado o PGAdmin para outros projetos que tenham populado o banco de dados, v� at� o PGAdmin, selecione o imdb, aperte na lupa com sql dentro, digite
no campo de texto o seguinte:

drop schema public cascade;
create schema public;

e aperte em executar. Em seguida reinicie a conex�o com o Database e fa�a tudo acima para executar. Esse passo � importante para limpar o banco de dados feitos no mesmo programa de outros alunos,
fazendo assim com que n�o existam erros.



