package org.example.domain.services;

import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;
import org.example.domain.models.Monstre;

public class PlayerActionService {
    private final CombatService combatService;
    private final DeplacementService deplacementService;

    public PlayerActionService(CombatService combatService, DeplacementService deplacementService) {
        this.combatService = combatService;
        this.deplacementService = deplacementService;
    }

    public void attaquer(Joueur joueur, Monstre monstre) {
        String resultat = combatService.engagerCombat(joueur, monstre);
        System.out.println(resultat);

        if (monstre.getSante() <= 0) {
            System.out.println(monstre.getNom() + " est vaincu !");
        } else if (joueur.getSante() <= 0) {
            System.out.println(joueur.getNom() + " est mort...");
        }
    }

    public void seDeplacer(Joueur joueur, Donjon donjon, String direction) {
        String resultat = deplacementService.deplacerDansSalle(joueur, donjon, direction);
        System.out.println(resultat);
    }
}
