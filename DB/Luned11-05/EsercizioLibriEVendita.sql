/* Esercizio Libri e Vendite*/

/*Punto 1
Esercizio 1 – INNER JOIN + WHERE + LIKE
Visualizzare l’elenco dei libri venduti in almeno un negozio, mostrando:
titolo del libro, autore, data_vendita, negozio.
Includere solo i libri il cui autore contiene la stringa “King” (indipendentemente da maiuscole/
minuscole).
*/

SELECT l.titolo, l.autore, v.data_vendita, v.negozio
FROM Libri l
INNER JOIN Vendite v
ON l.id = v.id_libro
WHERE LOWER(l.autore) LIKE '%king%';


/* Punto 2
Esercizio 2 – LEFT JOIN + WHERE + BETWEEN
Visualizzare tutti i libri, anche quelli che non hanno ancora vendite registrate, mostrando per ciascuno:
titolo, anno_pubblicazione, prezzo, data_vendita (se presente).
 Filtrare i risultati per anno_pubblicazione compreso tra 2000 e 2010.
*/
select l.titolo, l.anno_pubblicazione,l.prezzo,v.data_vendita
from libri l
left join vendite v
on l.id = v.id_libro
where l.anno_pubblicazione between 2000 and 2010;

/*Punto 3
 INNER JOIN + WHERE + IN
Visualizzare i dati dei libri venduti nei negozi appartenenti a una lista specifica:
("9 Oriole Lane", "98558 Milwaukee Point", "98016 Esch Trail").
Mostrare titolo, negozio, quantita, prezzo totale (quantita * prezzo).
*/

select l.titolo, v.negozio,v.quantita, v.quantita * l.prezzo as prezzo_totale
from libri l
inner join vendite v
on l.id = v.id_libro
where v.negozio in(
'9 Oriole Lane',
'98558 Milwaukee Point',
'98016 Esch Trail'
);

/*Punto 4 RIGHT JOIN + WHERE + LIKE + BETWEEN
Mostrare tutti i record di vendita, anche quelli che fanno riferimento a libri non più presenti nella
tabella Libri (caso anomalo).
Mostrare: titolo (se esiste), data_vendita, prezzo, quantita.
Includere solo le vendite:
avvenute tra il 2020-01-01 e il 2022-12-31
presso negozi il cui nome contiene la parola “Drive” (case-insensitive).*/

select l.titolo, v.data_vendita, l.prezzo, v.quantita
from Libri l
right join vendite v
on l.id = v.id_libro
where lower(v.negozio)like '%drive%' and v.data_vendita between '2020-01-01' and '2022-12-31'; 

/*
Punto 5 – INNER JOIN + WHERE combinato
Mostrare titolo, autore, prezzo e data_vendita dei libri:
con genere IN (‘Fantasy’, ‘Horror’, ‘Drama’) (ignora i libri con >1 genere)
con data_vendita dopo il 2015,
venduti in negozi il cui nome contiene ‘Plaza’,
ordinati dal più recente al più vecchio.
*/
SELECT 
    l.titolo,
    l.autore,
    l.prezzo,
    v.data_vendita
FROM Libri l
INNER JOIN Vendite v
ON l.id = v.id_libro
WHERE l.genere IN ('Fantasy', 'Horror', 'Drama')
AND v.data_vendita > '2015-12-31'
AND LOWER(v.negozio) LIKE '%plaza%'
ORDER BY v.data_vendita DESC;