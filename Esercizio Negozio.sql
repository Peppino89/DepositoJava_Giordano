/*Esercizio Negozio */

CREATE DATABASE Negozio; /*Creo il database Negozio*/
use negozio; /* mi sposto su questo DB*/

-- Crea la tabella Vendite con tutti i campi necessari
CREATE TABLE Vendite (
  id               INT,            -- identificatore univoco della vendita
  prodotto         VARCHAR(100),  -- nome del prodotto venduto
  categoria        VARCHAR(50),   -- categoria merceologica
  quantita         INT,            -- numero di unità vendute
  prezzo_unitario  DECIMAL(6,2),  -- prezzo per singola unità (es. 99.90)
  data_vendita     DATE           -- data in cui è avvenuta la vendita
);

/*Inserisco 30 valori nella tabella*/
INSERT INTO Vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1,  'Laptop Pro',       'Elettronica',  2,  1299.99, '2024-01-05'),
(2,  'Mouse wireless',   'Elettronica',  5,    29.99, '2024-01-07'),
(3,  'Tastiera meccanica','Elettronica', 3,    89.99, '2024-01-10'),
(4,  'Monitor 27"',      'Elettronica',  1,   349.00, '2024-01-12'),
(5,  'Cuffie Bluetooth', 'Elettronica',  4,    79.99, '2024-01-15'),
(6,  'Scarpe da corsa',  'Abbigliamento',3,    99.90, '2024-01-18'),
(7,  'Giacca invernale', 'Abbigliamento',2,   149.00, '2024-01-20'),
(8,  'T-shirt cotone',   'Abbigliamento',8,    19.99, '2024-01-22'),
(9,  'Pantaloni jeans',  'Abbigliamento',4,    59.90, '2024-01-25'),
(10, 'Cappello lana',    'Abbigliamento',6,    24.99, '2024-02-01'),
(11, 'Romanzo bestseller','Libri',       7,    14.99, '2024-02-03'),
(12, 'Manuale SQL',      'Libri',        3,    39.99, '2024-02-05'),
(13, 'Storia d"Italia',  'Libri',        2,    22.50, '2024-02-08'),
(14, 'Dizionario IT-EN', 'Libri',        1,    18.00, '2024-02-10'),
(15, 'Fumetto manga',    'Libri',        9,     8.99, '2024-02-12'),
(16, 'Tavolo da pranzo', 'Arredamento',  1,   299.00, '2024-02-14'),
(17, 'Sedia ergonomica', 'Arredamento',  2,   189.90, '2024-02-16'),
(18, 'Lampada LED',      'Arredamento',  5,    34.99, '2024-02-18'),
(19, 'Tappeto soggiorno','Arredamento',  1,   119.00, '2024-02-20'),
(20, 'Libreria 5 ripiani','Arredamento', 2,   229.00, '2024-02-22'),
(21, 'Padella antiaderente','Cucina',    4,    45.99, '2024-03-01'),
(22, 'Set coltelli',     'Cucina',       2,    89.00, '2024-03-03'),
(23, 'Frullatore',       'Cucina',       3,    59.99, '2024-03-05'),
(24, 'Tostapane',        'Cucina',       2,    29.90, '2024-03-07'),
(25, 'Macchina caffè',   'Cucina',       1,   199.00, '2024-03-10'),
(26, 'Pallone calcio',   'Sport',        6,    25.99, '2024-03-12'),
(27, 'Racchetta tennis', 'Sport',        3,    79.00, '2024-03-14'),
(28, 'Tappetino yoga',   'Sport',        7,    19.99, '2024-03-16'),
(29, 'Guantoni boxe',    'Sport',        2,    49.90, '2024-03-18'),
(30, 'Bicicletta MTB',   'Sport',        1,   599.00, '2024-03-20');


/* 1) Totale vendite per categoria Visualizza, per ogni categoria, 
il numero totale di vendite effettuate. */

-- Conta quante righe (vendite) esistono per ogni categoria.
-- GROUP BY raggruppa le righe con la stessa categoria;
-- COUNT(*) conta il numero di righe in ciascun gruppo.
SELECT
    categoria,
    COUNT(*) AS totale_vendite   -- numero di vendite nella categoria
FROM Vendite
GROUP BY categoria;               -- un gruppo per ogni categoria distinta


/* 2) Prezzo medio per categoria Mostra, 
per ogni categoria, il prezzo medio dei prodotti venduti.*/

-- Calcola il prezzo medio dei prodotti per ogni categoria.
-- AVG() somma tutti i prezzi del gruppo e divide per il loro numero.
-- ROUND(..., 2) arrotonda il risultato a 2 cifre decimali.
SELECT
    categoria,
    ROUND(AVG(prezzo_unitario), 2) AS prezzo_medio  -- media arrotondata
FROM Vendite
GROUP BY categoria;                                  -- un gruppo per ogni categoria

/* 3) Quantità totale venduta per ogni prodotto Mostra il totale delle quantità vendute (SUM) per ciascun prodotto.*/
-- Somma le quantità di ogni prodotto su tutte le sue vendite.
-- Utile per sapere quante unità totali sono state vendute per articolo.
-- SUM() addiziona tutti i valori di quantita nello stesso gruppo.
SELECT
    prodotto,
    SUM(quantita) AS quantita_totale  -- somma delle unità vendute
FROM Vendite
GROUP BY prodotto;                    -- raggruppa per nome prodotto

/* 4) Prezzo massimo e minimo venduto nella tabella Mostra il prezzo massimo e il prezzo minimo tra tutti i prodotti venduti.*/

-- Restituisce il prodotto più caro e quello più economico in assoluto.
-- MAX() scorre tutta la tabella e restituisce il valore più alto;
-- MIN() restituisce il valore più basso.
-- Nessun GROUP BY: si opera sull'intera tabella come unico gruppo.
SELECT
    MAX(prezzo_unitario) AS prezzo_massimo,  -- il prezzo più alto
    MIN(prezzo_unitario) AS prezzo_minimo   -- il prezzo più basso
FROM Vendite;

/* 5) Numero totale di righe nella tabella Conta quante vendite sono state registrate nella tabella Vendite. */
-- Conta tutte le righe presenti nella tabella Vendite.
-- COUNT(*) include ogni riga indipendentemente dai valori NULL.
SELECT
    COUNT(*) AS totale_righe  -- numero totale di vendite registrate
FROM Vendite;

/* 6) I 5 prodotti più costosi (in base al prezzo_unitario) Elenca i 5 prodotti più costosi ordinati in modo decrescente rispetto al prezzo. */
-- Elenca i prodotti ordinati dal prezzo più alto al più basso.
-- ORDER BY ... DESC inverte l'ordinamento naturale (crescente).
-- LIMIT 5 taglia il risultato ai soli primi 5 record.
SELECT
    prodotto,
    prezzo_unitario
FROM Vendite
ORDER BY prezzo_unitario DESC  -- dal più costoso al meno costoso
LIMIT 5;                       -- prende solo i primi 5 risultati

/*7) I 3 prodotti meno venduti per quantità totale Mostra i nomi dei 3 prodotti con la quantità totale più bassa venduta (usa SUM e LIMIT).*/
      
	-- Trova i 3 prodotti con la quantità complessiva più bassa.
-- SUM(quantita) + GROUP BY somma le unità per ciascun prodotto.
-- ORDER BY ... ASC ordina dal più basso al più alto (ASC è il default).
-- LIMIT 3 restituisce solo i 3 prodotti in cima alla classifica inversa.
SELECT
    prodotto,
    SUM(quantita) AS quantita_totale   -- totale unità vendute per prodotto
FROM Vendite
GROUP BY prodotto                       -- raggruppa per nome prodotto
ORDER BY quantita_totale ASC           -- dal meno venduto al più venduto
LIMIT 3;                               -- prende solo i 3 meno venduti



