package info530;

public class Main {

    public static void main(String[] args) {
        Pile<Integer> pile = new Pile<Integer>(10);
        pile.ajouter(5);
        pile.ajouter(6);
        pile.ajouter(10);
        System.out.print(pile.retirer());
    }
}
