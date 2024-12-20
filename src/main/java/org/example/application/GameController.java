package org.example.application;

import org.example.domain.models.*;
import org.example.domain.services.CombatService;
import org.example.domain.services.DeplacementService;
import org.example.infrastructure.persistence.SaveLoadManager;
import org.example.infrastructure.utils.UserInputValidator;

public class GameController {
    private Joueur joueur;
    private Donjon donjon;
    private final UserInputValidator inputValidator;
    private final SaveLoadManager saveLoadManager;

    public GameController(UserInputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.saveLoadManager = new SaveLoadManager();
    }

    public void startGame() {
        afficherBienvenue();
        int choix = inputValidator.lireEntier(1, 2);

        if (choix == 1) {
            chargerPartie();
            if (joueur == null || donjon == null) {
                System.out.println("Aucune partie sauvegardée. Créons une nouvelle partie !");
                creerNouvellePartie();
            }
        } else {
            creerNouvellePartie();
        }

        while (true) {
            afficherMenu();
        }
    }

    private void afficherBienvenue() {
        System.out.println("Bienvenue dans le jeu !");
        System.out.println("1: Charger une partie");
        System.out.println("2: Commencer une nouvelle partie");
    }

    private void afficherMenu() {
        ConsoleUI.afficherEtat(joueur, donjon);

        System.out.println("1: Attaquer");
        System.out.println("2: Récolter");
        System.out.println("3: Afficher inventaire");
        System.out.println("4: Se déplacer");
        System.out.println("5: Sauvegarder la partie");
        System.out.println("6: Charger une partie");
        System.out.println("7: Quitter");

        int choix = inputValidator.lireEntier(1, 7);
        switch (choix) {
            case 1 -> attaquer();
            case 2 -> recolter();
            case 3 -> ConsoleUI.afficherInventaire(joueur);
            case 4 -> seDeplacer();
            case 5 -> sauvegarderPartie();
            case 6 -> chargerPartie();
            case 7 -> quitter();
        }
    }

    private void creerNouvellePartie() {
        donjon = new Donjon(5, 5);

        System.out.println("Choisissez votre classe : ");
        System.out.println("1: Guerrier\n2: Mage\n3: Voleur");

        int choix = inputValidator.lireEntier(1, 3);

        if (choix == 1) {
            joueur = new Guerrier("Guerrier");
        } else if (choix == 2) {
            joueur = new Mage("Mage");
        } else {
            joueur = new Voleur("Voleur");
        }

        joueur.createPlayer();
    }

    private void attaquer() {
        Monstre monstre = new Monstre(50, 8, 5, "Gobelin"); // Exemple de monstre
        System.out.println(joueur.getNom() + " attaque " + monstre.getNom() + ".");

        int degatsJoueur = Math.max(joueur.getForce() - monstre.getDefense(), 0);
        monstre.setSante(monstre.getSante() - degatsJoueur);
        System.out.println(joueur.getNom() + " inflige " + degatsJoueur + " dégâts à " + monstre.getNom() + ".");

        if (monstre.getSante() <= 0) {
            System.out.println(monstre.getNom() + " est vaincu !");
        } else {
            int degatsMonstre = Math.max(monstre.getForce() - joueur.getDefense(), 0);
            joueur.setSante(joueur.getSante() - degatsMonstre);
            System.out.println(monstre.getNom() + " contre-attaque et inflige " + degatsMonstre + " dégâts à " + joueur.getNom() + ".");
        }

        if (joueur.getSante() <= 0) {
            System.out.println(joueur.getNom() + " est mort...");
            quitter();
        }
    }



    private void recolter() {
        System.out.println("Récolte d'objets (non implémenté)");
    }

    private void seDeplacer() {
        DeplacementService deplacementService = new DeplacementService(5, 5);
        String direction = inputValidator.lireDirection();
        String resultat = deplacementService.deplacerDansSalle(joueur, donjon, direction);
        System.out.println(resultat);
    }

    private void sauvegarderPartie() {
        saveLoadManager.sauvegarderPartie(joueur, donjon);
    }

    private void chargerPartie() {
        SaveLoadManager.PartieData data = saveLoadManager.chargerPartie();
        if (data != null) {
            joueur = data.joueur;
            donjon = data.donjon;
            System.out.println("Partie chargée avec succès !");
        } else {
            System.out.println("Aucune sauvegarde trouvée ou erreur lors du chargement.");
        }
    }

    private void quitter() {
        System.out.println("Merci d'avoir joué !");
        System.exit(0);
    }
}
