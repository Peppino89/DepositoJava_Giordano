select clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
inner join ordini on clienti2.id = ordini.id
order by clienti2.nome asc;

select clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2
inner join ordini on  ordini.id = clienti2.id
order by clienti2.nome asc;

select clienti2.nome, ordini.data_ordine, ordini.importo
from clienti2 left join ordini
on ordini.id = clienti2.id
order by ordini.importo asc;

/*
Esercizio
*/

/* Punto 1
Elenca i clienti attivi, cioè quelli che hanno effettuato almeno un ordine, mostrando per ciascuno:

Nome del cliente, Totale ordini effettuati, Somma totale degli importi spesi

*/
SELECT
    c.nome AS nome_cliente,
    COUNT(o.id) AS totale_ordini_effettuati,
    SUM(o.importo) AS somma_totale_importi_spesi
FROM clienti2 c
INNER JOIN ordini o
    ON c.id = o.id_cliente
GROUP BY c.id, c.nome;

/*
  Punto 2
  Elenca i clienti inattivi, cioè quelli che non hanno mai effettuato ordini, mostrando solo:
  Nome del cliente Città di residenza
*/
SELECT
    c.nome AS nome_cliente,
    c.citta AS citta_residenza
FROM clienti2 c
LEFT JOIN Ordini o
    ON c.id = o.id_cliente
WHERE o.id IS NULL;


/*
Punto 3
Individua gli ordini orfani, cioè ordini presenti in tabella ma senza un cliente valido associato (es. cliente cancellato), e mostra:

ID dell’ordine, Data dell’ordine, Importo
(Cliente = NULL)
*/

SELECT
    o.id AS id_ordine,
    o.data_ordine,
    o.importo,
    c.id AS cliente
FROM clienti2 c
RIGHT JOIN Ordini o
    ON c.id = o.id_cliente
WHERE c.id IS NULL;

