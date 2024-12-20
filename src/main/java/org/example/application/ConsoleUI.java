package org.example.application;

import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;
import org.example.domain.models.Salle;

public class ConsoleUI {

    public static void afficherEtat(Joueur joueur, Donjon donjon) {
        System.out.println("Vous êtes dans la salle (" + joueur.getSalleX() + ", " + joueur.getSalleY() + ")");
        System.out.println("Position dans la salle : (" + joueur.getPositionX() + ", " + joueur.getPositionY() + ")");

        Salle salle = donjon.getSalle(joueur.getSalleX(), joueur.getSalleY());
        if (salle != null) {
            afficherSalle(salle, joueur.getPositionX(), joueur.getPositionY());
        } else {
            System.out.println("Erreur : Salle introuvable.");
        }

        afficherDonjon(donjon, joueur.getSalleX(), joueur.getSalleY());
    }

    public static void afficherSalle(Salle salle, int joueurX, int joueurY) {
        System.out.println("Salle : " + salle.getNom());
        for (int y = 0; y < salle.getHauteur(); y++) {
            for (int x = 0; x < salle.getLargeur(); x++) {
                if (x == joueurX && y == joueurY) {
                    System.out.print("P "); // Position du joueur
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void afficherDonjon(Donjon donjon, int salleX, int salleY) {
        System.out.println("Donjon :");
        for (int y = 0; y < donjon.getHauteur(); y++) {
            for (int x = 0; x < donjon.getLargeur(); x++) {
                if (x == salleX && y == salleY) {
                    System.out.print("[P] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }

    public static void afficherInventaire(Joueur joueur) {
        System.out.println("Inventaire : (non implémenté)");
    }
}
