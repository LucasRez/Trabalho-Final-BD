
--Queries

--query que retorna os gastos de forma decrescente
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) desc;
--query que retorna os gastos de forma crescente
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) asc;
--query que retorna o funcionario com o maior gasto
select f.favorecidonome, sum(p.pagamvalor) from pagamento p join favorecido f on f.favorecidoid = p.favorecidoid group by f.favorecidonome order by sum(p.pagamvalor) desc limit 1;
--query que retorna o orgao superior que mais gastou
select osup.orgsupnome, sum(p.pagamvalor) from orgao_superior osup join orgao_subordinado osub on osup.orgsupcod = osub.orgsupcod join unidade_gestora u on u.orgsubcod = osub.orgsubcod
join favorecido f on f.unigestcod = u.unigestcod join pagamento p on f.favorecidoid = p.favorecidoid group by osup.orgsupnome order by sum(p.pagamvalor) desc limit 1;
--Qual codigo de pagamento teve o maior gasto?
select p.pagamcod, sum(p.pagamvalor) from pagamento p group by p.pagamcod order by sum(p.pagamvalor) desc limit 1;
--query que mostra qual programa gastou mais
select pr.prognome, sum(p.pagamvalor) from pagamento p join acao a on p.acaocod = a.acaocod join programa pr on a.progcod = pr.progcod group by pr.prognome order by sum(p.pagamvalor) desc limit 1;
--query que mostra qual acao gastou mais
select a.acaonome, sum(p.pagamvalor) from pagamento p join acao a on p.acaocod = a.acaocod group by a.acaonome order by sum(p.pagamvalor) desc limit 1;




