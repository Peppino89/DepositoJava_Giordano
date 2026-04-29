package esempiPattern.databaseSingleton;

public class Utente {

    private String nome;

    public Utente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Utente nome=" + nome ;
    }
}
