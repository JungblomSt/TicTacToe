public class Player {
    private String name;
    private int score;
    private char symbol;

    //constructors
    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    public Player(String name) {
        this.name = name;
        this.symbol = name.toUpperCase().charAt(0); //Not in use for now, first letter in name instead of X and O.
        this.score = 0;
    }
    //functions
    public static String addPlayerName() {
        System.out.println("Write the name of a player: ");
        return InputHandler.getString();
    }

    //get and set
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

