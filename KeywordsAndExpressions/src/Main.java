//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.
       displayHighScore("Donald Trump",calculateHighScorePosition(1000));

    }


    /**
     * Returns a players position on the high score list
     *
     * @param name The name of the player
     * @param position The position of the player on the high score list.
     */
    public static void displayHighScore(String name, int position) {
        System.out.println(name + " managed to get to position " + position + " on the high score list");

    }

    public static int calculateHighScorePosition(double score) {

        if (score >= 1000) {
            return 1;
        } else if (score >= 500) {
            return 2;
        } else if (score >= 100) {
            return 3;
        } else {
            return 4;
        }
    }

}

