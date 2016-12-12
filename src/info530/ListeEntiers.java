package info530;

import java.util.Collections;
import java.util.List;

/**
 * Created by Vincent on 12/12/2016.
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
