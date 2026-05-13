package org.example.eserciziocatalogo.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProdottoService {
    private List<String> nomiProdotti;
    private Map<String,Double>prezziProdotti;
    private final PrezzoService prezzoService;

    @Autowired
    public ProdottoService(PrezzoService prezzoService){
        this.prezzoService = prezzoService;
    }

    @PostConstruct
    public void init(){
        this.nomiProdotti = new ArrayList<>();
        this.prezziProdotti = new HashMap<>();

        this.nomiProdotti.add("Mouse");
        this.nomiProdotti.add("Tastiera");
        this.nomiProdotti.add("Monitor");
        this.nomiProdotti.add("Stampante");

        this.prezziProdotti.put("Mouse",25.0);
        this.prezziProdotti.put("Tastiera",50.0);
        this.prezziProdotti.put("Monitor",200.0);
        this.prezziProdotti.put("Stampante",150.0);
    }

    public void stampaCatalogo(int percentualeSconto) {

        System.out.println("\n========================================");
        System.out.println("   CATALOGO PRODOTTI - Sconto: " + percentualeSconto + "%");
        System.out.println("========================================\n");

        for (String prodotto : nomiProdotti) {

            double prezzoOriginale = prezziProdotti.get(prodotto);

            double prezzoScontato =
                    prezzoService.prezzoScontato(
                            prezzoOriginale,
                            percentualeSconto
                    );

            System.out.printf(
                    "%-20s %10.2f€  ->  %10.2f€%n",
                    prodotto,
                    prezzoOriginale,
                    prezzoScontato
            );
        }

        System.out.println("\n========================================");
    }
}
