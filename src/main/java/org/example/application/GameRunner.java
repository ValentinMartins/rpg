package org.example.application;

import org.example.domain.models.Donjon;
import org.example.domain.models.Joueur;
import org.example.infrastructure.utils.UserInputValidator;

public class GameRunner {
    private final GameController gameController;

    public GameRunner() {
        UserInputValidator inputValidator = new UserInputValidator();
        gameController = new GameController(inputValidator);
    }

    public void run() {
        gameController.startGame();
    }
}
