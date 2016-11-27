CREATE FUNCTION exemplo(favorecidoNome varchar(80), favorecidoCPF char(14), UnidadeGestCod integer) returns void as $$
begin 

		insert into Favorecido (FavorecidoCPF, FavorecidoNome, UniGestCod) values (favorecidoCPF, favorecidoNome, UnidadeGestCod);
	
end;
$$
language 'plpgsql';

CREATE FUNCTION procura(fnome varchar(80)) returns integer as $$
begin 

	select f.FavorecidoID from Favorecido as f where f.FavorecidoNome = fnome;
	
end;
$$
language 'plpgsql';

select procura('Victor Vieira');

--gasto total dos 6 meses
select sum(pagamvalor) "Soma Gastos Totais" from pagamento;

select favorecidocpf, pagamvalor from pagamento;

--Funcao que recupera todos os gastos por cpf
CREATE FUNCTION recuperaGastosPorCpf(cpf char(14)) returns table(Preco_dos_gastos real) as $$
begin 
	return query select pagamvalor from pagamento where pagamento.favorecidocpf = cpf;
	
end;
$$
language 'plpgsql';

select recuperaGastosPorCpf('***.648.25*-**');

--funcao que recupera todos os gastos por nome
CREATE FUNCTION recuperaGastosPorNome(nome char(14)) returns table(Preco_dos_gastos real) as $$
begin 
	return query select p.pagamvalor from pagamento p join favorecido f on f.favorecidonome = nome and f.favorecidoid = p.favorecidoid;
	
end;
$$
language 'plpgsql';

select recuperaGastosPorNome('SERGIO RICARDO CALDERINI ROSA');

select * from pagamento join favorecido on pagamento.favorecidocpf = favorecido.favorecidocpf;

--query que retorna os gastos de forma decrescente
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) desc;
--query que retorna os gastos de forma crescente
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) asc;
--query que retorna o funcionario com o maior gasto
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) desc limit 1;
--query que retorna o orgao superior que mais gastou
select osup.orgsupnome, sum(p.pagamvalor) from orgao_superior osup join orgao_subordinado osub on osup.orgsupcod = osub.orgsupcod join unidade_gestora u on u.orgsubcod = osub.orgsubcod
join favorecido f on f.unigestcod = u.unigestcod join pagamento p on f.favorecidoid = p.favorecidoid group by osup.orgsupnome order by sum(p.pagamvalor) desc limit 1;
-Qual codigo de pagamento teve o maior gasto?
select p.pagamcod, sum(p.pagamvalor) from pagamento p group by p.pagamcod order by sum(p.pagamvalor) desc limit 1;





