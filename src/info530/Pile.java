package info530;

import java.util.Stack;

/**
 * Pile générique avec capacité limitée.
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
    public boolean empiler(T element) {
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
    public T depiler() {
        return this.pile.pop();
    }

    /**
     * Retourne l'élément au sommet de la pile sans le supprimer.
     * @return
     */
    public T sommet() {
        return this.pile.peek();
    }

    /**
     * Indique si la pile est vide ou non.
     * @return
     */
    public boolean vide() {
        return this.pile.empty();
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
