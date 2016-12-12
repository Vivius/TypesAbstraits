package info530;

import java.util.*;

/**
 * Created by Vincent on 11/12/2016.
 */

public class GrandEntier implements IGrandEntier {
    private INombre nombre;

    // Implémentation avec une liste.
    public GrandEntier(ListeEntiers nombre) {
        this.nombre = nombre;
    }

    // Implémentation avec un tableau.
    public GrandEntier(StringEntiers nombre) {
        this.nombre = nombre;
    }

    @Override
    public void somme(IGrandEntier other) {
        INombre result = new ListeEntiers(new ArrayList<>()); // Resultat.
        INombre last = null;
        Integer retenue = 0, c1, c2;
        int sizeMin, sizeMax, indexThis, indexOther, limit;

        if(getNombre().size() <= other.getNombre().size()) {
            sizeMin = getNombre().size();
            sizeMax = other.getNombre().size();
        } else {
            sizeMin = other.getNombre().size();
            sizeMax = getNombre().size();
        }

        limit = sizeMax - sizeMin;

        // On fait l'addition unité par unité en gardant la retenue...
        for(indexThis = getNombre().size() - 1, indexOther = other.getNombre().size() - 1; indexThis >= 0 && indexOther >= 0; indexOther--, indexThis--) {
            c1 = getNombre().get(indexThis);
            c2 = other.getNombre().get(indexOther);

            if(c1 + c2 + retenue > 9) {
                result.add((c1 + c2 + retenue) % 10);
                retenue = (c1 + c2 + retenue) / 10;
            } else {
                result.add(c1 + c2 + retenue);
                retenue = 0;
            }
        }

        // On regarde ce qu'il reste à traiter.
        if(getNombre().size() > other.getNombre().size()) {
            last = getNombre();
        } else {
            last = other.getNombre();
        }

        // On traite la suite d'un des 2 nombre si elle existe.
        for(int i = limit - 1; i >= 0; i--) {
            c1 = last.get(i);
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
        result.reverse();
        nombre = result;
    }

    @Override
    public void produit(IGrandEntier e) {

        if(!e.toString().equals("0") && !this.toString().equals("0")) {
            // Copie du nombre de base.
            IGrandEntier nbOrigine = new GrandEntier(new StringEntiers(getNombre().toString()));
            // Chiffre 1.
            IGrandEntier un = new GrandEntier(new StringEntiers("1"));
            // Compteur partant de 1
            IGrandEntier compteur = new GrandEntier(new StringEntiers("1"));

            while (!compteur.toString().equals(e.toString())) {
                compteur.somme(un);
                this.somme(nbOrigine);
            }
        } else {
            nombre = new StringEntiers("0");
        }
    }

    @Override
    public String impression() {
        return nombre.toString();
    }

    public INombre getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return impression();
    }
}
