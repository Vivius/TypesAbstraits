package info530;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Iterator i1 = this.getChiffres().iterator(); // Iterator premier nombre.
        Iterator i2 = e2.getChiffres().iterator(); // Iterator second nombre.
        Iterator i3 = i1; // Iterator final
        List<Integer> result = new ArrayList<>(); // Resultat.

        Integer retenue = 0;
        Integer c1, c2;

        while(i1.hasNext() && i2.hasNext()) {
            c1 = (Integer) i1.next();
            c2 = (Integer) i2.next();

            if(c1 + c2 + retenue > 9) {
                retenue = c1 + c2 - 9;
                result.add(9);
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

        while(i3.hasNext()) {
            c1 = (Integer) i1.next();
            if(c1 + retenue > 9) {
                retenue = c1 - 9;
                result.add(9);
            } else {
                result.add(c1 + retenue);
                retenue = 0;
            }
        }
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
