Nome dos Alunos

Bruno José Bergamaschi Kumer Reis ___________________14/0017666
Victor Araújo Vieira ________________________________14/0032801

O que foi implementado em nosso programa?
Todas as funcionalidades  pedidas no TODO foram implementadas, com DAOs adicionais para melhor funcionamento
do programa e também uma interface gráfica textual, que permite a verificação de todas as funcionalidades pe-
didas via console.Todas as entradas foram verificadas e corrigidas caso inseridas de forma equivocada, e fi-
zemos uma extensa  coleção de testes que testam todas as funções de alteração no banco de dados e verificação
do mesmo e todas passaram com sucesso.

Como deve ser executado o programa?

1.O programa foi testado e funcionou corretamente no Eclipse JEE Mars

2.Deve se descompactar o arquivo zip, abrir o eclipse, ir em File -> Import ->Existing Projects into Workspace ->Em "Select root directory" navegar até a pasta extraída do zip
e selecioná-la -> Apertar em Finish

3.O banco de dados utilizado no programa foi o PgAdmin III. Para rodar o programa deve-se instalar o PostgreSQL. Para baixá-lo, basta entrar nesse site http://www.postgresql.org/download/
Selecionar a versão correspondente ao seu sistema operacional e realizar o download. Execute o instalador baixado e siga as instruções até completar a instalação. Caso ele peça qual senha
o senhor deseja utilizar para acessar o banco de dados, para maior facilidade  use a senha "postgres" que é a padrão do Banco de Dados. Ao acessar o PgAdmin III, clique duas vezes no servidor
que foi escolhido durante a instalação e digite sua senha (Caso sua senha seja diferente da padrão dita acima, você deve ir até o arquivo persistence.xml localizado em imdb->src->main->java->
->META-INF->persistence.xml e nas linhas 12 e 13 você deve colocar o usuário e a senha correspondentes as suas). Tendo acesso ao banco de dados, clique com o botão de direito em cima de Database
e selecione a opção New Database... e crie uma nova database com o nome imdb.

Existe um teste no diretório na pasta imdb->src->test->java chamado IMDBPopulandoBDTeste.java, aperte com o botão direito nele, selecione run as->JUNIT test para popular seu banco de dados com
alguns filmes, albuns e faixas músicais. Caso o senhor deseje, pode acrescentar essas coisas manualmente via PgAdmin III. Para verificar os filmes,albuns,gênero e autores gerados pelo teste,
vá até o PGAdmin III->Database->schemas->public->Tables e aperta na tabela que deseja ver e em seguida aperta na tabela no lado direito da lupa escrito sql dentro na parte superior do software.
É interessante fazer isso para digitar nomes válidos nas pesquisas.

4.Para executar o software, aperte com o botão direito na classe IMDB.java e selecione run as->Java Application. Essa classe encontra-se em imdb/src/main/java/br.unb.cic.imdb.ui

OBSERVAÇÃO IMPORTANTE : Caso já tenha usado o PGAdmin para outros projetos que tenham populado o banco de dados, vá até o PGAdmin, selecione o imdb, aperte na lupa com sql dentro, digite
no campo de texto o seguinte:

drop schema public cascade;
create schema public;

e aperte em executar. Em seguida reinicie a conexão com o Database e faça tudo acima para executar. Esse passo é importante para limpar o banco de dados feitos no mesmo programa de outros alunos,
fazendo assim com que não existam erros.



