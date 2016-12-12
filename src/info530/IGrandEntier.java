package info530;

import java.util.List;

/**
 * Contrat que doit remplir un Grand Entier.
 */

public interface IGrandEntier {
    void somme(IGrandEntier e);
    void produit(IGrandEntier e);
    String impression();

    INombre getNombre();
}
