public class Vecteur {
    private int[] tableau;
    private int nbElements;

    public static final int RATIO_AGRANDISSEMENT = 2;
    public static final int TAILLE_INITIALE = 5;

    public Vecteur() {
        this(TAILLE_INITIALE);
    }

    public Vecteur(int tailleInitiale) {
        tableau = new int[tailleInitiale];
        nbElements = 0;
    }

    public String toString() {
        String str = estVide() ? "[" : "[" + tableau[0];
        for (int i = 1; i < nbElements; i++)
            str +=  ", " + tableau[i];
        return str + "]";
    }

    public int getElementAt(int index) {
        return tableau[index];
    }

    public int getNbElements() {
        return nbElements;
    }

    public boolean estVide() {
        return nbElements == 0;
    }

    public void ajouter(int element) {
        ajouter(element, nbElements);
    }

    public boolean ajouter(int element, int index) {
        if (index < 0 || index > nbElements)
            //throw new IndexOutOfBoundsException();
            return false;
        if (nbElements >= tableau.length)
            resize();
        for (int i = nbElements; i > index; i--)
            tableau[i] = tableau[i - 1];
        tableau[index] = element;
        nbElements++;
        return true;
    }

    public void ajouter(Vecteur autre) {
        for (int i = 0 ; i < autre.getNbElements(); i++)
            this.ajouter(autre.getElementAt(i));
    }

    public int trouve(int valeur) {
        for (int i = 0; i < nbElements; i++)
            if (tableau[i] == valeur)
                return i;
        return -1;
    }

    public boolean trouveTout(Vecteur autre) {
        for (int i = 0 ; i < autre.getNbElements(); i++)
            if (trouve(autre.getElementAt(i)) == -1)
                return false;
        return true;
    }

    private void resize() {
        int[] nouveau = new int[RATIO_AGRANDISSEMENT * tableau.length];
        for (int i = 0 ; i < tableau.length; i++)
            nouveau[i] = tableau[i];
        tableau = nouveau;
    }
}
