import krg.petr.otus.javabasic.game.*;
import krg.petr.otus.javabasic.unit.ColorConst;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayGameTest {
    @DisplayName("HomeWork 16 - PlayerOneWin")
    @Test
    public void testPlayerOneWin() {
        Dice dice = new Dice() {
            Boolean firstRun = false;
            @Override
            public int roll() {
                if (!firstRun) {
                    firstRun = true;
                    return 6;
                } else {
                    firstRun = false;
                    return 4;
                }
            }
        };


        GameWinnerPrinter winnerPrinter = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                Assertions.assertEquals("Вася", winner.getName());
            }
        };
        Game game = new Game(dice, winnerPrinter);

        game.playGame(new Player("Вася"),new Player("Петя"));

    }

    @DisplayName("HomeWork 16 - PlayerSecondWin")
    @Test
    public void testPlayerSecondWin() {
        Dice dice = new Dice() {
            Boolean firstRun = false;
            @Override
            public int roll() {
                if (!firstRun) {
                    firstRun = true;
                    return 4;
                } else {
                    firstRun = false;
                    return 6;
                }
            }
        };


        GameWinnerPrinter winnerPrinter = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                Assertions.assertEquals("Петя", winner.getName());
            }
        };
        Game game = new Game(dice, winnerPrinter);

        game.playGame(new Player("Вася"),new Player("Петя"));

    }

    @DisplayName("HomeWork 16 - DiceOutOfRange")
    @Test
    public void testDiceOutOfRange() {
        Dice dice = new DiceImpl();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(dice, winnerPrinter);

        int cubeDigit = dice.roll();
        org.junit.jupiter.api.Assertions.assertTrue(cubeDigit <= 6);
        org.junit.jupiter.api.Assertions.assertTrue(cubeDigit >= 1);

        game.playGame(new Player("Вася"),new Player("Петя"));

    }

    @DisplayName("HomeWork 16 - DeadHeat")
    @Test
    public void testDeadHeat() {
        Dice dice = new Dice() {
            @Override
            public int roll() {
                return 4;
            }
        };


        GameWinnerPrinter winnerPrinter = new GameWinnerPrinter() {
            @Override
            public void printWinner(Player winner) {
                Assertions.assertEquals("Ничья", winner.getName());
            }
        };
        Game game = new Game(dice, winnerPrinter);

        game.playGame(new Player("Вася"),new Player("Петя"));

    }

}
