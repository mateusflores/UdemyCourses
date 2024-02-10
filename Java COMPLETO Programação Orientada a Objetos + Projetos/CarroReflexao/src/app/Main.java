package app;

import entities.Carro;
import reflectionManager.Reflexao;

public class Main {
    public static void main(String[] args) throws Exception {
        Carro c1 = new Carro("Uno", "A4N45R", 2010);
        Carro c2 = new Carro("Corsa", "T42FGT", 2020);

        System.out.printf("*** Antes da reflexão ***%s", c1.toString());

        Reflexao.update(c1, c2);

        System.out.printf("\n\n*** Depois da reflexão ***%s", c1.toString());
    }
}