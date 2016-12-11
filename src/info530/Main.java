package info530;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        /**
         * EXERCICE 1
         */
        Pile<Integer> pile = new Pile<Integer>(10);
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
        System.out.print(pile);

        /**
         * EXERCICE 2
         */
        List<Integer> chiffres1 = new ArrayList<>();
        chiffres1.add(2);
        chiffres1.add(5);
        chiffres1.add(8);

        List<Integer> chiffres2 = new ArrayList<>();
        chiffres2.add(2);
        chiffres2.add(5);

        IGrandEntier e1 = new GrandEntierListe(chiffres1);
        IGrandEntier e2 = new GrandEntierListe(chiffres2);
        e1.somme(e2);
        System.out.print(e1.getChiffres());
    }
}
