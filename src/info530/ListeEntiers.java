package info530;

import java.util.Collections;
import java.util.List;

/**
 * Représentation d'un grand entier sous forme d'une liste chaînée implémentant l'interface INombre.
 */

public class ListeEntiers implements INombre {
    private List<Integer> liste;

    public ListeEntiers(List<Integer> liste) {
        this.liste = liste;
    }

    @Override
    public Integer get(int index) {
        return liste.get(index);
    }

    @Override
    public void add(Integer element) {
        liste.add(element);
    }

    @Override
    public void reverse() {
        Collections.reverse(liste);
    }

    @Override
    public int size() {
        return liste.size();
    }

    @Override
    public String toString() {
        String nombre = "";
        for(Integer i : liste) {
            nombre += i;
        }
        return nombre;
    }
}
