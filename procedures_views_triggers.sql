--Procedures
--Funcao que recupera todos os gastos por cpf
CREATE FUNCTION recuperaGastosPorCpf(cpf char(14)) returns table(Preco_dos_gastos real) as $$
begin 
	return query select pagamvalor from pagamento where pagamento.favorecidocpf = cpf;
	
end;
$$
language 'plpgsql';

--funcao que recupera todos os gastos por nome
CREATE FUNCTION recuperaGastosPorNome(nome char(14)) returns table(Preco_dos_gastos real) as $$
begin 
	return query select p.pagamvalor from pagamento p join favorecido f on f.favorecidonome = nome and f.favorecidoid = p.favorecidoid;
	
end;
$$
language 'plpgsql';

--Funcao que qual programa de determinada acao gastou mais
CREATE FUNCTION recuperaProgramaMaisCaroAcao(NomeAcao varchar(200)) returns table(NomePrograma varchar(200), valor real) as $$
begin 
	return query select pr.prognome, sum(p.pagamvalor) from pagamento p join acao a on a.acaocod = p.acaocod and a.acaonome = NomeAcao join programa pr on pr.progcod = a.progcod group by pr.prognome 
	order by sum(p.pagamvalor) desc limit 1;
	
end;
$$
language 'plpgsql';

--funcao para a trigger
CREATE OR REPLACE FUNCTION verificaNovoFavorecido()
returns trigger as 
$$
begin
	if(NEW.favorecidoCPF <> OLD.favorecidoCPF and NEW.favorecidoCPF <> NULL) then
		insert into Favorecido(favorecidoCPF, FavorecidoNome, UniGestCod) values (NEW.favorecidoCPF, NEW.FavorecidoNome, NEW.UniGestCod);
	end if;
	return NEW;
end;
$$
language 'plpgsql';

--trigger
create trigger VerificaSeNaoNULLFavorecido after insert on favorecido
for each row execute procedure verificaNovoFavorecido();

--View
--view para os gastos totais individuais de cada favorecido
create view GastosTotaisIndividuais as select f.favorecidonome, sum(p.pagamvalor) as GastosIndividuais from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome; 