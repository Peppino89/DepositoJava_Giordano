package gestioneHotel;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Paradise");

        hotel.addCamera(new Camera(101, 80.0f));
        hotel.addCamera(new Camera(102, 90.0f));
        hotel.addCamera(new Suite("Jacuzzi", 201, 150.0f));
        hotel.addCamera(new Suite("Vista mare", 202, 180.0f));

        int numeroSuite = Hotel.countSuite(hotel.getCamere());

        hotel.getCamere().get(1).dettagli(true);
        System.out.println();
        hotel.getCamere().get(2).dettagli(false);
        System.out.println();
        hotel.getCamere().get(3).dettagli();
        System.out.println();
        System.out.println("Numero suite: " + numeroSuite);

    }
}
