package krg.petr.otus.javabasic;

import krg.petr.otus.javabasic.game.*;

public class DiceGame {
    public static void main( String[] args ) {
        Dice dice = new DiceImpl();

        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"),
                new Player("Игорь"));
    }
}
