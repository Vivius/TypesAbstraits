package info530;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Vincent on 11/12/2016.
 */

public class GrandEntierListe implements IGrandEntier {
    private List<Integer> chiffres;

    public GrandEntierListe(List<Integer> chiffres) {
        this.chiffres = chiffres;
    }

    @Override
    public void somme(IGrandEntier e2) {
        ListIterator<Integer> i1 = this.getChiffres().listIterator(this.getChiffres().size()); // Iterator premier nombre.
        ListIterator<Integer> i2 = e2.getChiffres().listIterator(e2.getChiffres().size()); // Iterator second nombre.
        ListIterator<Integer> i3 = i1; // Iterator final
        List<Integer> result = new ArrayList<>(); // Resultat.

        Integer retenue = 0;
        Integer c1, c2;

        while(i1.hasPrevious() && i2.hasPrevious()) {
            c1 = i1.previous();
            c2 = i2.previous();

            if(c1 + c2 + retenue > 9) {
                result.add((c1 + c2 + retenue) % 10);
                retenue = (c1 + c2 + retenue) / 10;
            } else {
                result.add(c1 + c2 + retenue);
                retenue = 0;
            }
        }

        if(this.getChiffres().size() == e2.getChiffres().size()) {
            if(retenue != 0)
                result.add(retenue);
        } else if(this.getChiffres().size() > e2.getChiffres().size()) {
            i3 = i1;
        } else {
            i3 = i2;
        }

        while(i3.hasPrevious()) {
            c1 = i1.previous();
            if(c1 + retenue > 9) {
                result.add((c1 + retenue) % 10);
                retenue = (c1 + retenue) / 10;
            } else {
                result.add(c1 + retenue);
                retenue = 0;
            }
        }

        this.chiffres = result;
    }

    @Override
    public void produit(IGrandEntier e) {

    }

    @Override
    public void afficher() {

    }

    public List<Integer> getChiffres() {
        return chiffres;
    }
}
