package info530;

import java.util.*;

/**
 * Class gérant les grands entiers implémentant l'interface INombre.
 */

public class GrandEntier implements IGrandEntier {
    private INombre nombre;

    // Implémentation avec une liste chaînée.
    public GrandEntier(ListeEntiers nombre) {
        this.nombre = nombre;
    }

    // Implémentation avec un chaîne de caractères simple.
    public GrandEntier(StringEntiers nombre) {
        this.nombre = nombre;
    }

    /**
     * Addition du grand entier actuel avec celui spécifié en paramètre.
     * @param other
     */
    @Override
    public void somme(IGrandEntier other) {
        INombre result = new ListeEntiers(new ArrayList<>()); // Resultat.
        INombre last = null; // Dernier élément à traiter si les nombres de font pas la même taille.
        Integer retenue = 0, c1, c2;
        int sizeMin, sizeMax, limit;

        // On définie le chiffre de taille max et le chiffre de taille min.
        if(getNombre().size() <= other.getNombre().size()) {
            sizeMin = getNombre().size();
            sizeMax = other.getNombre().size();
        } else {
            sizeMin = other.getNombre().size();
            sizeMax = getNombre().size();
        }

        // On cherche l'indice limite où l'on doit s'arrêter dans le parcours des 2 nombres.
        limit = sizeMax - sizeMin;

        // On fait l'addition unité par unité avec retenue... On s'arrête dès qu'un ou les nombres sont entièrement parcourus.
        for(int indexThis = getNombre().size() - 1, indexOther = other.getNombre().size() - 1; indexThis >= 0 && indexOther >= 0; indexOther--, indexThis--) {
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

        // On regarde ce qu'il reste à traiter si un nombre est plus grand qu'un autre.
        if(getNombre().size() > other.getNombre().size()) {
            last = getNombre();
        } else {
            last = other.getNombre();
        }

        // On traite la suite d'un des 2 nombre si elle existe.
        // Si 2 nombres font la même taille on ne rentre pas dans la boucle car limit - 1 sera négatif...
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

        // On ajoute la dernière retenue si existente.
        if(retenue != 0)
            result.add(retenue);

        // On inverse l'ordre du résultat car on l'a rempli de gauche à droite et pas de droite à gauche...
        result.reverse();
        nombre = result;
    }

    /**
     * Multiplication du grand entier actuel avec celui spécifié en paramètre.
     * @param e
     */
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

    /**
     * Affichage du grand nombre actuel sous forme de chaîne de caractères.
     * @return
     */
    @Override
    public String impression() {
        return nombre.toString();
    }

    /**
     * Récupération du nombre actuel quelque soit son implémentation.
     * @return
     */
    public INombre getNombre() {
        return this.nombre;
    }

    /**
     * Réécriture de toString...
     * @return
     */
    @Override
    public String toString() {
        return impression();
    }
}
