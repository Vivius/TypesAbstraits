package info530;

import java.util.*;

/**
 * Created by Vincent on 11/12/2016.
 */

public class GrandEntier implements IGrandEntier {
    private List<Integer> chiffres;

    // Implémentation avec une liste.
    public GrandEntier(List<Integer> chiffres) {
        this.chiffres = chiffres;
    }

    // Implémentation avec un tableau.
    public GrandEntier(Integer[] chiffres) {
        this.chiffres = Arrays.asList(chiffres);
    }

    @Override
    public void somme(IGrandEntier e2) {
        ListIterator<Integer> i1 = getChiffres().listIterator(getChiffres().size()); // Iterator premier nombre.
        ListIterator<Integer> i2 = e2.getChiffres().listIterator(e2.getChiffres().size()); // Iterator second nombre.
        ListIterator<Integer> i3 = i1; // Iterator final
        List<Integer> result = new ArrayList<>(); // Resultat.

        Integer retenue = 0;
        Integer c1, c2;

        // On fait l'addition unité par unité en gardant la retenue...
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

        // On regarde ce qu'il reste à traiter.
        if(this.getChiffres().size() > e2.getChiffres().size()) {
            i3 = i1;
        } else {
            i3 = i2;
        }

        // On traite la suite d'un des 2 nombre si elle existe.
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

        if(retenue != 0)
            result.add(retenue);

        // On inverse l'ordre de la liste car on l'a remplie de gauche à droite et pas de droite à gauche...
        Collections.reverse(result);
        this.chiffres = result;
    }

    @Override
    public void produit(IGrandEntier e) {
        // Copie du nombre de base.
        IGrandEntier e1 = new GrandEntier(this.getChiffres());
        // Chiffre 1.
        IGrandEntier un = new GrandEntier(new Integer[] {1});
        // Compteur partant de 1
        IGrandEntier compteur = new GrandEntier(new Integer[] {1});

        while (!compteur.toString().equals(e.toString())) {
            compteur.somme(un);
            this.somme(e1);
        }
    }

    @Override
    public String impression() {
        String nombre = "";
        for(Integer i : getChiffres()) {
            nombre += i;
        }
        return nombre;
    }

    @Override
    public List<Integer> getChiffres() {
        return this.chiffres;
    }

    @Override
    public String toString() {
        return impression();
    }
}
