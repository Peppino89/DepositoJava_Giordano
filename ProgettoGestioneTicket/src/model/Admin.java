package model;

public class Admin extends UtenteObserver{

    public Admin(String nomeUtente, String password){
        super(nomeUtente,password,"ADMIN");
    }

    @Override
    public void update(String messaggio) {
        System.out.println("[NOTIFICA ADMIN "+super.getNomeUtente()+"] "+messaggio);
    }
}
