package org.example.domain.models;

public class Donjon {
    private final Salle[][] salles;
    private final int largeur;
    private final int hauteur;

    public Donjon(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.salles = new Salle[largeur][hauteur];
        genererSalles();
    }

    private void genererSalles() {
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                salles[x][y] = new Salle(5, 5, "Salle (" + x + ", " + y + ")");
            }
        }
    }

    public Salle getSalle(int x, int y) {
        if (x >= 0 && x < largeur && y >= 0 && y < hauteur) {
            return salles[x][y];
        }
        return null; // Si hors limites
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}
