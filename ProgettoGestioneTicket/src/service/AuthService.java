package service;

import model.Admin;
import model.UtenteObserver;

import java.util.ArrayList;

//Singleton
public class AuthService {

    private static AuthService instance;

    private ArrayList<UtenteObserver> utenti;

    private AuthService(){
        this.utenti = new ArrayList<>();

        //Creo l'admin di default
        utenti.add(new Admin("admin","admin123"));
    }

    public static AuthService getInstance(){
        if(AuthService.instance == null){
            AuthService.instance = new AuthService();
        }
        return AuthService.instance;
    }

    public boolean registraUtente(String nomeUtente, String password){
        if(utenteEsistente(nomeUtente)){
            return false; // vuol dire che l'utente è stato già registrato
        }

        //Altrimenti viene creato e registrato
        UtenteObserver utente = new UtenteObserver(nomeUtente,password,"USER");
        utenti.add(utente);

        return true;
    }


    public UtenteObserver loginUtente(String nomeUtente, String password){

        for(UtenteObserver utente : utenti){

            if (utente.getNomeUtente().equals(nomeUtente) && utente.getPassword().equals(password)){
                return utente;
            }
        }
        return null;
    }




    //Metodo privato booleano che mi serve per verificare che l'utente non sia già registrato
    private boolean utenteEsistente(String username){
        for(UtenteObserver utente : utenti){
            if (utente.getNomeUtente().equals(username)){
                return true;
            }
        }
        return false;
    }

}
