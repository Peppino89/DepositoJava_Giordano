package model;

public class Ticket {
    private int id;
    private String titolo;
    private String descrizione;
    private String autore;
    private String status;

    public Ticket(int id, String titolo, String descrizione, String autore) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.autore = autore;
        this.status = "APERTO";// Di default quando verrà creato il ticket sarà già aperto
    }

    public int getId() {
        return id;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getAutore() {
        return autore;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ID: "+this.id+
                " | Titolo: "+this.titolo+
                " | Descrizione: "+this.descrizione+
                " | Autore: "+this.autore+
                " | Stato: "+this.status;
    }
}
