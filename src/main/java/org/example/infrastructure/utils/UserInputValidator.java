package org.example.infrastructure.utils;

import java.util.Scanner;

public class UserInputValidator {
    private final Scanner scanner;

    public UserInputValidator() {
        this.scanner = new Scanner(System.in);
    }


    public int lireEntier(int min, int max) {
        int choix;
        while (true) {
            try {
                System.out.print("Votre choix : ");
                choix = Integer.parseInt(scanner.nextLine());
                if (choix >= min && choix <= max) {
                    return choix;
                } else {
                    System.out.println("Veuillez entrer un nombre entre " + min + " et " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }
    }


    public String lireDirection() {
        while (true) {
            System.out.print("Dans quelle direction voulez-vous aller ? (N, S, E, O) : ");
            String direction = scanner.nextLine().trim().toUpperCase();
            if ("N".equals(direction) || "S".equals(direction) || "E".equals(direction) || "O".equals(direction)) {
                return direction;
            } else {
                System.out.println("Direction invalide. Veuillez entrer N, S, E ou O.");
            }
        }
    }

    public String lireTexte() {
        System.out.print("Votre texte : ");
        return scanner.nextLine().trim();
    }
}
