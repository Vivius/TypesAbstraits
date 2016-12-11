package info530;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        System.out.println(pile);

        /**
         * EXERCICE 2
         */
        List<Integer> chiffres_a = new ArrayList<>();
        chiffres_a.add(2);
        chiffres_a.add(5);
        chiffres_a.add(8);

        List<Integer> chiffres_b = new ArrayList<>();
        chiffres_b.add(2);
        chiffres_b.add(5);

        Integer[] chiffres_c = {1,2};

        IGrandEntier e1 = new GrandEntier(chiffres_a);
        IGrandEntier e2 = new GrandEntier(chiffres_c);
        e1.somme(e2);
        System.out.print("e1 + e2 = " + e1);
    }
}
