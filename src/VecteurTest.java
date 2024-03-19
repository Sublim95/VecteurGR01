import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class VecteurTest {
    Vecteur data;

    @BeforeEach
    void setUp() {
        data = new Vecteur();
        data.ajouter(0);
        data.ajouter(10);
        data.ajouter(20);
        data.ajouter(30);
        data.ajouter(40);
        data.ajouter(50);
    }

    @org.junit.jupiter.api.Test
    void getElementAt() {
        assertEquals(0, data.getElementAt(0));
        assertEquals(30, data.getElementAt(3));
        assertEquals(50, data.getElementAt(5));
    }

    @org.junit.jupiter.api.Test
    void getNbElements() {
        Vecteur vide = new Vecteur();
        assertEquals(0, vide.getNbElements());
        assertEquals(6, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void estVide() {
        Vecteur vide = new Vecteur();
        assertEquals(true, vide.estVide());

        Vecteur data = new Vecteur();
        data.ajouter(0);
        data.ajouter(10);
        data.ajouter(20);
        data.ajouter(30);
        data.ajouter(40);
        data.ajouter(50);
        assertFalse(data.estVide());
    }

    @org.junit.jupiter.api.Test
    void ajouterEnd() {
        data.ajouter(90);
        data.ajouter(91);
        data.ajouter(92);
        assertEquals(90, data.getElementAt(6));
        assertEquals(91, data.getElementAt(7));
        assertEquals(92, data.getElementAt(8));
        assertEquals(9, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testAjouterIndexSpecifique() {
        data.ajouter(-10, 0);
        data.ajouter(25, 4);
        data.ajouter(60, 8);
        data.ajouter(70, 9);
        data.ajouter(80, 10);
        assertEquals(-10, data.getElementAt(0));
        assertEquals(25, data.getElementAt(4));
        assertEquals(60, data.getElementAt(8));
        assertEquals(70, data.getElementAt(9));
        assertEquals(80, data.getElementAt(10));
        assertEquals(11, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testAjouterIndexInvalide() {
        data.ajouter(99, -1);
        data.ajouter(99, 15);
        assertEquals(6,data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testAjouterValeurProvenantAutreVecteur() {
        Vecteur test7 = new Vecteur();
        test7.ajouter(95);
        test7.ajouter(96);
        test7.ajouter(97);
        data.ajouter(test7);
        assertEquals(9,data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void trouver() {
        assertEquals(1,data.trouver(10));
        assertEquals(3,data.trouver(30));
        assertEquals(5,data.trouver(50));
    }

    @org.junit.jupiter.api.Test
    void trouverTout() {
        Vecteur test9 = new Vecteur();
        data.ajouter(40);
        data.ajouter(97);
        data.ajouter(-10);
        test9.ajouter(40);
        test9.ajouter(97);
        test9.ajouter(-10);
        assertTrue(data.trouverTout(test9));

        test9.ajouter(99);
        assertFalse(data.trouverTout(test9));
    }

    @org.junit.jupiter.api.Test
    void effacerAt() {
        data.effacerAt(1);
        data.effacerAt(2);
        data.effacerAt(3);
        assertEquals(3, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void effacerTout() {
        Vecteur test11 = new Vecteur();
        test11.ajouter(0);
        test11.ajouter(40);
        test11.ajouter(50);
        data.effacerTout(test11);
        assertEquals(3, data.getNbElements());
    }

    @org.junit.jupiter.api.Test
    void testEffacerTout() {
        data.effacerTout();
        assertEquals(0, data.getNbElements());
    }
}