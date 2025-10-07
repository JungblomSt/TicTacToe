public class TicTacToe {
    private char[] playField;

    public TicTacToe() {

        System.out.println("Hi!!");
        Player player1 = new Player(Player.addPlayerName(), 'X');
        Player player2 = new Player(Player.addPlayerName(), 'O');
        Player currentPlayer = player1;

        welcomeInstructions(player1, player2);

        while (true) {
            playField = initPlayField();
            printPlayField(playField);
            currentPlayer = Game(currentPlayer, player1, player2);
        }
    }
// Functions
    private Player Game(Player currentPlayer, Player player1, Player player2) {
        while (true) {
            System.out.println("What number do you want to replace with your " + "'" + currentPlayer.getSymbol() +"'" +  " " + currentPlayer.getName() +"?");
            int move = InputHandler.getInt(1, 9) - 1;
            if (playField[move] != player1.getSymbol() && playField[move] != player2.getSymbol())
            {
                playField[move] = currentPlayer.getSymbol();
                printPlayField(playField);
            } else {
                System.out.println("The number is taken, try with an other one!");
                continue; //dont switch players
            }
//                checkWinner(currentPlayer, player1, player2);
//                checkDraw();

            if (!checkWinner(currentPlayer, player1, player2) || !checkDraw()) {
                break;
            }

            currentPlayer = switchPlayer(currentPlayer, player1, player2);
        }
        return currentPlayer;
    }

    private static void welcomeInstructions(Player player1, Player player2) {
        System.out.println("Welcome " + player1.getName() + " and " + player2.getName() + "!");
        System.out.println("You are now going to play a game of TicTacToe!");
        System.out.println();
        System.out.println("Players take turns placing their symbol in a square.");
        System.out.println("Be the first to get 3 of your symbol in a row — horizontally \u2190 \u2192, vertically \u2191 \u2193, or diagonally \u2199 \u2196.");
        System.out.println("First to 3 in a row wins.");
        System.out.println("If all 9 squares are filled with no winner, it’s a draw, and you can try again.");
    }

    // Switch player, more code but easy to read (for me)
    private static Player switchPlayer(Player currentPlayer, Player player1, Player player2) {
        if (currentPlayer == player1){
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
        return currentPlayer;

        //  Altenative sulution.
        //    private static Player switchPlayer(Player currentPlayer, Player player1, Player player2) {
        //        return currentPlayer == player1 ? player2 : player1;
        //    }
    }

    private boolean checkWinner(Player currentPlayer, Player player1, Player player2) {
        int[][] winningCombinations = {
                //rows
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                //column
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                //Diagonal
                {0, 4, 8}, {2, 4, 6}
        };

        for (int[] combo : winningCombinations) {
            char a = playField[combo[0]];
            char b = playField[combo[1]];
            char c = playField[combo[2]];

            if (a == b && b == c) { // We have a winner!!
                System.out.println(currentPlayer.getName() + " wins!");
                currentPlayer.setScore(currentPlayer.getScore() + 1);
                printScore(player1, player2);
                return false;
            }

        }
    return  true;

    }
    public void printScore(Player player1, Player player2) {
        System.out.println(player1.getName().toUpperCase() + " Score: "  + player1.getScore());
        System.out.println(player2.getName().toUpperCase() + " Score: "  + player2.getScore());
    }

    //ToDo change if you want to be able to change symbol
    //check if the board is full
    private boolean checkDraw() {
        int moves = 0;
        for (char symbol : playField) {
            if (symbol == 'X' || symbol == 'O') {
                moves++;
            }
        }
        if (moves == 9) {
            System.out.println("It's a draw!");
            return false;
        }
        return true;
    }
    private boolean playAgain() {
        // spela igen?
        //j/n + kontroll
        return true;
    }


    private static char[] initPlayField() {
        //Make the playfeald
        char[] playField = new char[9];
        //fill the playfeald with numbers
        for (int i = 0; i < 9; i++) {
            playField[i] = (char) ('1' + i);
        }
        return playField;
    }

//        System.out.println("Here is the playfeald:");
//        for (int i = 0; i < playField.length; i++) {
//            for (int j = 0; j < playField[i].length; j++) {
//                System.out.print(playField[i][j] + " ");
//            }
//            System.out.println();
//        }

//        char[] playField = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    //wrote the playfield this way so it was easy to read and understand, for me
    public void printPlayField(char[] playField) {
//        System.out.println("This is the playfield: ");
        System.out.println();
        System.out.println(" " + playField[0] + " | " + playField[1] + " | " + playField[2]);
        System.out.println("---+---+---");
        System.out.println(" " + playField[3] + " | " + playField[4] + " | " + playField[5]);
        System.out.println("---+---+---");
        System.out.println(" " + playField[6] + " | " + playField[7] + " | " + playField[8]);
        System.out.println();
    }
}

