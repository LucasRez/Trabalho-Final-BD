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


