package info530;

/**
 * Created by Vincent on 12/12/2016.
 */
public class StringEntiers implements INombre {
    private String chaine;

    public StringEntiers(String chaine) {
        this.chaine = chaine;
    }

    @Override
    public Integer get(int index) {
        char c = chaine.charAt(index);
        return Character.getNumericValue(c);
    }

    @Override
    public void add(Integer element) {
        chaine += element.toString();
    }

    @Override
    public void reverse() {
        chaine = new StringBuilder().reverse().toString();
    }

    @Override
    public int size() {
        return chaine.length();
    }

    @Override
    public String toString() {
        return chaine;
    }
}
