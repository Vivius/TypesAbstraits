package info530;

import java.util.*;

/**
 * Class gérant les grands entiers implémentant l'interface INombre.
 */

public class GrandEntier implements IGrandEntier {
    private INombre nombre;

    // Constructeur générique.
    public GrandEntier(INombre nombre) {
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
     * @param other
     */
    @Override
    public void produit(IGrandEntier other) {
        // Liste des nombres qui seront additionés entre eux.
        List<IGrandEntier> numbers = new ArrayList<>();
        // Nombre temporaire qui sera utilisé lors des calculs.
        IGrandEntier nbTemp = new GrandEntier(new ListeEntiers(new ArrayList<>()));
        // Résultat final.
        IGrandEntier result = new GrandEntier(new StringEntiers("0"));
        // Variables nécessaires pour le calcul.
        Integer retenue = 0, cTemp, cHaut, cBas, cActuel, cpt = 0;

        // On vérifie si un des nombres vaut 0 avant d'aller plus loin.
        if(!other.toString().equals("0") && !this.toString().equals("0")) {
            // Parcours de chaque chiffre du nombre de base (situé en haut pour la multiplication à la main).
            for(int i = getNombre().size()-1; i >= 0; i--) {
                cBas = getNombre().get(i);
                //System.out.println("Nb bas = " + cBas);
                // Parcours de chaque chiffre de l'autre nombre (situé en bas pour la multiplication à la main).
                for(int j = other.getNombre().size()-1; j >= 0; j--) {
                    cHaut = other.getNombre().get(j);
                    //System.out.println("    Nb haut = " + cHaut);
                    cTemp = cBas * cHaut;
                    cActuel = (cTemp + retenue) % 10;
                    //System.out.println("        cActuel = " + cActuel);
                    retenue = (cTemp + retenue) / 10;
                    //System.out.println("        retenue = " + retenue);
                    nbTemp.getNombre().add(cActuel); // Construction du nombre actuel chiffre par chiffre.
                }
                // Ajout de la retenue en dernier pour le nombre actuel si différent de 0.
                if(retenue != 0)
                    nbTemp.getNombre().add(retenue);
                retenue = 0; // On remet à 0 pour les traitement ultérieurs.

                nbTemp.getNombre().reverse(); // On construit le résultat dans le bon sens de lecture.
                //System.out.println("Nb temp  = " + nbTemp);
                numbers.add(nbTemp); // Ajout du résultat aux résultats à additioner à la fin.

                // Réinitialisation du nombre temporaire.
                nbTemp = new GrandEntier(new ListeEntiers(new ArrayList<>()));

                cpt++; // On indique qu'il faudra ajouter un 0 de plus au début du prochain nombre.
                for(int j = 0; j < cpt; j++) // Ajout des 0.
                    nbTemp.getNombre().add(0);
            }

            // On fait la somme finale de tous les résultats trouvés.
            for (int i = 0; i < numbers.size(); i++) {
                //System.out.println(i + " = " + numbers.get(i));
                result.somme(numbers.get(i));
            }

            nombre = result.getNombre();
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
