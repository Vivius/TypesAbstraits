package info530;

import java.util.Stack;

/**
 * Created by Vincent on 11/12/2016.
 */

public class Pile<T> {
    private Stack<T> pile;
    private int capacite;

    public Pile(int capacite) {
        pile = new Stack<T>();
        this.capacite = capacite;
    }

    public boolean ajouter(T element) {
        if(pile.size() < this.capacite) {
            pile.push(element);
            return true;
        } else {
            return false;
        }
    }

    public T retirer() {
        return pile.pop();
    }

    @Override
    public String toString() {
        return pile.toString();
    }
}
