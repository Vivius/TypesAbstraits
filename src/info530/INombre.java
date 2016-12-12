package info530;

/**
 * Interface permettant de rendre générique la façon de traiter les nombres quelque soit leur structure de données.
 */
public interface INombre {
    Integer get(int index); // Obtient un chiffre par son indice (partant de 0).
    void add(Integer element);
    void reverse();
    int size(); // Obtient le nombre de chiffres.
}
