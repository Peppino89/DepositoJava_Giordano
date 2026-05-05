package esempioMVC;

public class StudenteController {
    //Controller: collega Model e View

    private Studente model;
    private StudenteView view;

    public StudenteController(Studente model, StudenteView view) {
        this.model = model;
        this.view = view;
    }

    public void setVotoStudente(int voto){
        model.setVoto(voto);
    }
    public void aggiornaView(){
        view.stampaDettagliStudente(model.getNome(),model.getVoto());
    }

}
