package info530;

import java.util.Stack;

/**
 * Pile avec capacité limitée.
 */

public class Pile<T> {
    private Stack<T> pile;
    private int capacite;

    /**
     * Constructeur d'un pile avec capacité limitée.
     * @param capacite
     */
    public Pile(int capacite) {
        this.pile = new Stack<T>();
        this.capacite = capacite;
    }

    /**
     * Ajoute un élément dans la pile.
     * Retourne false si on dépasse la capacité définie.
     * @param element
     * @return
     */
    public boolean ajouter(T element) {
        if(this.pile.size() < this.capacite) {
            this.pile.push(element);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Retourne l'élément se trouvant au sommet de la pile.
     * Il sera également retiré de la pile.
     * @return
     */
    public T retirer() {
        return this.pile.pop();
    }

    /**
     * Réécriture de toString...
     * @return
     */
    @Override
    public String toString() {
        return this.pile.toString();
    }
}
