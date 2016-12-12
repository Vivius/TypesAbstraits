package info530;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
         * EXERCICE 1
         */
        Pile<Integer> pile = new Pile<>(10);
        pile.ajouter(1);
        pile.ajouter(2);
        pile.ajouter(3);
        pile.ajouter(4);
        pile.ajouter(5);
        pile.ajouter(6);
        pile.ajouter(7);
        pile.ajouter(8);
        pile.ajouter(9);
        pile.ajouter(10);
        pile.ajouter(11);
        System.out.println("Pile finale : " + pile);

        /**
         * EXERCICE 2
         */

        // ADDITION
        List<Integer> chiffres_a = new ArrayList<>();
        chiffres_a.add(2);
        chiffres_a.add(5);
        chiffres_a.add(8);
        chiffres_a.add(7);
        chiffres_a.add(2);
        chiffres_a.add(1);
        String chiffres_b = "1258987523";

        IGrandEntier e1 = new GrandEntier(new ListeEntiers(chiffres_a));
        IGrandEntier e2 = new GrandEntier(new StringEntiers(chiffres_b));

        System.out.println("e1 = " + e1 + ", e2 = " + e2);
        e1.somme(e2);
        System.out.println("e1 + e2 = " + e1);

        // MULTIPLICATION
        List<Integer> chiffres_c = new ArrayList<>();
        chiffres_c.add(6);
        chiffres_c.add(7);
        chiffres_c.add(5);
        chiffres_c.add(1);
        chiffres_c.add(4);
        chiffres_c.add(2);
        chiffres_c.add(8);
        chiffres_c.add(9);
        chiffres_c.add(6);
        chiffres_c.add(7);
        chiffres_c.add(5);
        chiffres_c.add(1);
        chiffres_c.add(4);
        chiffres_c.add(2);
        chiffres_c.add(8);
        chiffres_c.add(9);
        chiffres_c.add(6);

        String chiffres_d = "3998616456499876312649898761312";

        IGrandEntier e3 = new GrandEntier(new ListeEntiers(chiffres_c));
        IGrandEntier e4 = new GrandEntier(new StringEntiers(chiffres_d));

        System.out.println("e3 = " + e3 + ", e4 = " + e4);
        e3.produit(e4);
        System.out.println("e3 * e4 = " + e3);
    }
}
