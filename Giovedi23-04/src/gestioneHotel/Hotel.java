package gestioneHotel;

import java.util.ArrayList;

public class Hotel {
    private String nome;
    private ArrayList<Camera> camere;

    public Hotel(String nome) {
        this.nome = nome;
        this.camere = new ArrayList<>();
    }

    public void addCamera(Camera camera) {
        camere.add(camera);
    }

    public ArrayList<Camera> getCamere() {
        return camere;
    }

    public static int countSuite(ArrayList<Camera> camere) {
        int counter = 0;
        for (Camera camera : camere) {
            if (camera instanceof Suite) {
                counter++;
            }
        }

        return counter;
    }
}
