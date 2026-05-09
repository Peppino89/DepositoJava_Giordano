# Sistema Gestione Ticket - README

## Descrizione del Progetto

Questo progetto rappresenta un semplice sistema di gestione ticket realizzato in Java da console.

L’applicazione permette:
- registrazione utenti
- login utenti/admin
- creazione ticket
- visualizzazione ticket
- modifica ticket
- eliminazione ticket
- risoluzione ticket
- notifiche automatiche tramite Observer Pattern

Il progetto è stato sviluppato seguendo il pattern architetturale MVC e utilizzando diversi Design Pattern studiati durante il corso.

---

# Tecnologie Utilizzate

- Java
- Programmazione Orientata agli Oggetti (OOP)
- Console Application
- Collections Framework (`ArrayList`)
- Design Patterns

---

# Pattern Utilizzati

## 1. MVC (Model View Controller)

Il progetto segue l’architettura MVC:

### Model
Contiene le classi dati e la logica degli observer.

Esempi:
- `Ticket`
- `UtenteObserver`
- `Admin`
- `TicketNotifier`

---

### View
Gestisce l’interazione con l’utente tramite console.

Classe:
- `MenuView`

La view:
- mostra menu
- stampa ticket
- stampa messaggi

---

### Controller
Fa da intermediario tra View e Service.

Classe:
- `TicketController`

Il controller:
- riceve input dalla View
- richiama la Facade
- coordina il flusso applicativo

---

## 2. Singleton Pattern

Utilizzato per garantire una sola istanza dei servizi principali.

Classi:
- `AuthService`
- `TicketService`

Vantaggi:
- gestione centralizzata dei dati
- accesso globale controllato
- evita istanze duplicate

---

## 3. Facade Pattern

Classe:
- `TicketFacade`

La Facade fornisce un unico punto di accesso ai servizi del sistema.

Il Controller non comunica direttamente con:
- `AuthService`
- `TicketService`

ma utilizza solamente:
- `TicketFacade`

Vantaggi:
- codice più pulito
- minore accoppiamento
- semplificazione dell’architettura

---

## 4. Observer Pattern

Utilizzato per gestire le notifiche automatiche.

Classi coinvolte:
- `Observer`
- `UtenteObserver`
- `Admin`
- `TicketNotifier`

Funzionamento:
- gli utenti diventano observer dopo il login
- quando un ticket viene risolto
- il sistema notifica automaticamente l’utente proprietario del ticket

Esempio:

```text
[NOTIFICA UTENTE mario]
Il tuo ticket ID 3 è stato risolto.
```

---

# Struttura del Progetto

```text
src/
│
├── controller/
│   └── TicketController.java
│
├── model/
│   ├── Admin.java
│   ├── Observer.java
│   ├── Ticket.java
│   ├── TicketNotifier.java
│   └── UtenteObserver.java
│
├── service/
│   ├── AuthService.java
│   ├── TicketFacade.java
│   └── TicketService.java
│
├── utility/
│   └── InputUtility.java
│
├── view/
│   └── MenuView.java
│
└── Main.java
```

---

# Funzionalità del Sistema

## Utente

L’utente può:
- registrarsi
- effettuare login
- creare ticket
- visualizzare i propri ticket

---

## Admin

L’admin può:
- visualizzare tutti i ticket
- modificare ticket
- modificare singoli campi
- eliminare ticket
- risolvere ticket

Credenziali admin di default:

```text
Username: admin
Password: admin123
```

---

# Funzionamento Generale

## Registrazione

L’utente inserisce:
- username
- password

Il sistema verifica che l’utente non esista già.

---

## Login

Il sistema controlla:
- username
- password

e determina il ruolo:
- USER
- ADMIN

---

## Creazione Ticket

L’utente inserisce:
- titolo
- descrizione

Il ticket viene creato automaticamente con:
- ID incrementale
- stato iniziale = APERTO

---

## Risoluzione Ticket

Quando l’admin risolve un ticket:
- lo stato diventa `RISOLTO`
- il proprietario del ticket riceve una notifica automatica

---

# Logica degli ID

La variabile:

```java
private int nextId;
```

viene utilizzata per generare automaticamente un ID univoco per ogni ticket creato.

Ad ogni nuovo ticket:

```java
nextId++;
```

incrementa il valore per il ticket successivo.

---

# Gestione Input

Classe:
- `InputUtility`

Responsabilità:
- lettura stringhe
- lettura interi
- validazione input numerici

Esempio:

```java
while (!input.hasNextInt())
```

evita errori se l’utente inserisce valori non numerici.

---

# Possibili Migliorie Future

- persistenza dati su file/database
- password criptate
- ricerca ticket
- filtri avanzati
- assegnazione ticket
- GUI grafica
- gestione priorità ticket
- storico notifiche

---

# Conclusione

Il progetto dimostra l’utilizzo pratico:
- della programmazione orientata agli oggetti
- dell’architettura MVC
- dei principali Design Pattern

e rappresenta un esempio completo di applicazione Java console-based con gestione utenti, ticket e notifiche automatiche.
