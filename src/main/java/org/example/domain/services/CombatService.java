package org.example.domain.services;

import org.example.domain.models.Joueur;
import org.example.domain.models.Monstre;

import java.util.Random;

public class CombatService {

    public String engagerCombat(Joueur joueur, Monstre monstre) {
        Random random = new Random();

        while (joueur.getSante() > 0 && monstre.getSante() > 0) {

            int degatsJoueur = Math.max(joueur.getForce() - monstre.getDefense(), 0);
            monstre.setSante(monstre.getSante() - degatsJoueur);

            if (monstre.getSante() <= 0) {
                return "Victoire ! Vous avez vaincu le monstre.";
            }


            int degatsMonstre = Math.max(monstre.getForce() - joueur.getDefense(), 0);
            joueur.setSante(joueur.getSante() - degatsMonstre);

            if (joueur.getSante() <= 0) {
                return "Défaite... Vous avez été vaincu.";
            }
        }

        return "Combat terminé.";
    }
}
