package sistema;

public class Persona {
    //Accessi privati ovvero questi attributi non accessibili direttamente dall'esterno della classe
    private String nome;
    private int eta;

    //Accessi pubblici questi attributi sono accessibili direttamente dall'esterno della classe
    public String nazionalita;
    public String indirizzo;

    public  Persona(String nome, int eta,String nazionalita ,String indirizzo) {
        this.nome = nome;
        this.eta = eta;
        this.indirizzo = indirizzo;
        this.nazionalita = nazionalita;
    }

    //metodo publico
    public void Saluta(){
        System.out.println("Nome: "+this.nome);
    }

    //metodo Privato utilizzabile solo all'interno della classe stessa
    private void descrizione(){
        System.out.println("Descrizione: "+this.nazionalita);

    }



    //Quando si dichiarano gli attributi privati si dichiarno i metodi setter per modificarli e getter per accedervi
    public String getName(){
        return this.nome;
    }

    public void setName(String nome){
        this.nome = nome;
        System.out.println("il nuovo Nome è : "+this.nome);
    }

    public int getEta(){
        return this.eta;
    }

    public void setEta(int eta){
        this.eta = eta;
        System.out.println("La tua nuova Età: "+this.eta);
    }

}
