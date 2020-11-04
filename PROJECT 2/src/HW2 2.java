//Omar Loudghiri oxl51, EECS 132 project 2
import javax.swing.JOptionPane;


public class HW2 {

    public static String replaceFirstK(String input, char initial, char fin, int num){
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) != initial){
                sb.append(input.charAt(i));
            }
            else if(counter != num){
                sb.append(fin);
                counter ++;
            }
            else
                sb.append(input.charAt(i));

        }
    return sb.toString();
    }

    public static String allChars(char first, char last){
        String all = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ((last - first) + 1); i++){
            sb.append(all.charAt( first -'a' + i ));
        }
        return sb.toString();


    }

    public static String showCharOfString(String input , String show){
        StringBuilder sb = new StringBuilder();
        int j;
        for(int i = 0; i  < input.length(); i++){
            for(j = 0; j < show.length() && input.charAt(i) != show.charAt(j)  ; j++);


            if(j < show.length() && input.charAt(i) == show.charAt(j) ) {
                sb.append(input.charAt(i));
            }
            else
                sb.append('_');


        }
        return sb.toString();
    }


    public static boolean hangman (String toGuess, int guesses ){
        //creates a string builder to store the good guesses
        StringBuilder letters = new StringBuilder();
        String guess;
        int bad_guesses = 0;
        boolean guessed = false;
        //should run while we wrongly guessed less than
        while (bad_guesses < guesses && guessed == false){

            String out = showCharOfString(toGuess, letters.toString());
            int j = 0;
            System.out.println(out);
            System.out.println("bad guesses" + bad_guesses);

            guess =  javax.swing.JOptionPane.showInputDialog("what's your guess");

            for ( j = 0; j < toGuess.length() -1 && guess.charAt(0) != toGuess.charAt(j) ; j++){

                //problems, doesnt count the bad guesses

            }
            if ( guess.charAt(0) == toGuess.charAt(j)){

                letters.append(guess.charAt(0));
            }
            else
            if(j == toGuess.length() -1 || guess.charAt(0) != toGuess.charAt(j) )
            {
                bad_guesses++;
            }
            if ( toGuess.equals(showCharOfString(toGuess, letters.toString())  )){
                guessed = true;

            }

        }
        // doesnt quit after this is true
        if ( toGuess.equals(showCharOfString(toGuess, letters.toString())  )) {
            return true;
        }
        else
            System.out.println(" YOU LOST");
        return false;

    }

}

    public





}
