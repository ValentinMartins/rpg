package org.example.domain.services;

import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;

public class DeplacementService {
    private final int largeurSalle;
    private final int hauteurSalle;

    public DeplacementService(int largeurSalle, int hauteurSalle) {
        this.largeurSalle = largeurSalle;
        this.hauteurSalle = hauteurSalle;
    }

    public String deplacerDansSalle(Joueur joueur, Donjon donjon, String direction) {
        int x = joueur.getPositionX();
        int y = joueur.getPositionY();
        int salleX = joueur.getSalleX();
        int salleY = joueur.getSalleY();

        switch (direction.toUpperCase()) {
            case "N" -> y--;
            case "S" -> y++;
            case "E" -> x++;
            case "O" -> x--;
            default -> {
                return "Direction invalide.";
            }
        }

        if (x < 0) { salleX--; x = largeurSalle - 1; }
        if (x >= largeurSalle) { salleX++; x = 0; }
        if (y < 0) { salleY--; y = hauteurSalle - 1; }
        if (y >= hauteurSalle) { salleY++; y = 0; }

        if (donjon.getSalle(salleX, salleY) == null) {
            return "Vous ne pouvez pas sortir des limites du donjon.";
        }

        joueur.setPositionX(x);
        joueur.setPositionY(y);
        joueur.setSalleX(salleX);
        joueur.setSalleY(salleY);

        return "Position mise à jour.";
    }
}
