public class Player {
    private String name;
    private int score;
    private char symbol;

//    Om man behöver skriva in ett score
//    public Player(String name, int score, char symbol) {
//        this.name = name;
//        this.score = score;
//        this.symbol = symbol;
//    }

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public Player(String name) {
        this.name = name;
        this.symbol = name.toUpperCase().charAt(0); //används ej just nu, Första bokstaven i namnet istället för X och O.
        this.score = 0;
    }
    public static String addPlayerName() {
        System.out.println("Write the name of a player: ");
        //    String playerName = InputHandler.getString();
        //        char playerSymbol = playerName.charAt(0);
        //        int playerScore = 0;
        //        players.add(new Player(playerName));
        return InputHandler.getString();
    }

//    public void nameQuestion() {
//        System.out.println("Write the name of the first player: ");
//        public String player1 = new Player(InputHandler.getString());
//
//        System.out.println("Write the name of the second player: ");
//        player2 = InputHandler.getString();
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}

