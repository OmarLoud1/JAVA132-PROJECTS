//Omar Loudghiri oxl51, EECS 132 project 2
// this class is comprised of many methods that perform manipulations on arrays and strings




public class HW2 {

    //this method replaces the first however many occurrences of a letter ( specified) into a new character.
    public static String replaceFirstK(String input, char initial, char fin, int num){

        // check that all the elements are input correctly.
        if(input.length() == 0 || initial == 0 || fin == 0 || num < 0){
            return "string is null";
        }

        // creates a string builder that will contain the output string.
        StringBuilder sb = new StringBuilder();

        // a variable that will keep track of how many times we have changed the letter we want to change.
        int counter = 0;

        // a loop that goes through the input string and stores the letter we want to keep while changing
        // the ones we want to change until reaching the end of the string
        for (int i = 0; i < input.length(); i++){

            // if the letter is not the one we want to change. appends the initial letter to sb, else append the new one until we reach the num limit.
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

    // this method prints all the characters in alphebital order beginning in the first char and ending in the last char
    public static String allChars(char first, char last){

        // checks that the inout are letters
        if( !Character.isLetter(first) || !Character.isLetter(last) ){
            return "null";
        }

        // creates a string that contains all letters of the alphabet in a sorted fashion.
        String all = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder();

        // goes through the number of character between the first and the last char and appends that string until it reaches last
        for (int i = 0; i < ((last - first) + 1); i++){
            sb.append(all.charAt( first -'a' + i ));
        }
        return sb.toString();
    }

    // this method uncovers from the first string, the characters that are present in the second string
    public static String showCharOfString(String input , String show){
        //controls that the inputs are correct
        if(input.equals(""))
            return "error: no input";

        // creates a string builder to store the output.
        StringBuilder sb = new StringBuilder();

        // initializing the variable j which indicates the position of the character in the show string that are also present in the input string.
        int j;

        //this is a double loop, the first one goes through each letter of the input string until we reach its length
        for(int i = 0; i  < input.length(); i++){

            // this loop goes through each character of the find string until they both match and then it stores the matching letter.
            for(j = 0; j < show.length() && input.charAt(i) != show.charAt(j)  ; j++);

            // appends the letters that are present in both string in the order they were given in the first string.
            if(j < show.length() && input.charAt(i) == show.charAt(j) ) {
                sb.append(input.charAt(i));
            }
            // if they do not match it replaces that character with an underscore.
            else
                sb.append('_');


        }
        return sb.toString();
    }

    //this method emulates the game hangman, that makes you guess a word and uncovers the letters you have guessed from
    // the word, you only have a limited amount of guesses
    public static boolean hangman (String toGuess, int guesses ){

        //chack that the input is correct
        if(toGuess.equals("") || guesses <= 0)
            return false;

        //creates a string builder to store the good guesses
        StringBuilder letters = new StringBuilder();

        //this is declared to store the input of the person playing, it takes a string but only considers the first char
        String guess;

        //this is a counter that keeps track of how many bad guesses we have made
        int bad_guesses = 0;

        // a boolean that keeps track of whether we have guessed correctly or not.
        boolean guessed = false;

        //should run while we wrongly guessed less than the limit of guesses, also while we haven't guessed right
        while (bad_guesses < guesses && guessed == false){

            //runs the method showcharofsting on the intended guess and the input.
            String out = showCharOfString(toGuess, letters.toString());

            //prints a string with all the characters guessed so far with the number of bad guesses.
            System.out.println(out);
            System.out.println("bad guesses" + bad_guesses);

            //prompts the user for an input
            guess =  javax.swing.JOptionPane.showInputDialog("what's your guess");

            //initializes the index for the loop that goes through the toGuess string.
            int j ;

            // loop that goes through the toGuess string until it finds a character that is both in the input and in toGuess
            // it stores the loaction of that character
            for (j = 0; j < toGuess.length() -1 && guess.charAt(0) != toGuess.charAt(j) ; j++);

            //if it the loop stops when the characters are the same, it appends it to the guessed character string
            if ( guess.charAt(0) == toGuess.charAt(j)){
                letters.append(guess.charAt(0));
            }

            //if it is a bad guess then we increment the number of bad guesses
            else if(j == toGuess.length() -1 || guess.charAt(0) != toGuess.charAt(j) )
            {
                bad_guesses++;
            }

            // if we have guessed the full word, we set the guessed flag to true to leave the loop
            else if ( toGuess.equals(showCharOfString(toGuess, letters.toString())  )){
                guessed = true;
            }
        }

        // prints the guessed string if guessed correctly
        if ( toGuess.equals(showCharOfString(toGuess, letters.toString())  )) {
            System.out.println("YOU WIN !");
            System.out.println(toGuess);
            return true;
        }

        else
            System.out.println(" YOU LOST");
        return false;

    }

    //this methods searches through a 1 dimensional  array of chars to find a corresponding string,
    // either the string is forward or backward does not matter
    public static boolean hiddenString (char[] array, String find){
        //this keeps track of what letter we start at when searching in the string
        int letter;

        // this keeps track of how many letters we have found that match in the array and the string
        int count;

        //checks that the inputs are in the correct format
        if(array == null || find.equals("")){
            System.out.println("error");
            return false;
        }

        //this loop goes through the whole array from the first to the last letter
        for (int i = 0; i < array.length; i++ ){

             letter = i;
             count = 0;

            //this loop goes through the string we want to find in the array.
            for(int j = 0; j < find.length(); j++){

                // if the letter in the string corresponds to the letter in the array we increment both the counter and letter
                if( letter < array.length && find.charAt(j) == array[letter]){
                    letter++;
                    count++;
                }
            }
            // if the counter of the consecutive corresponding letter is equal to the length of the string, the string is found
            if ( count == find.length()){
                return true;
            }
        }

        // this loop goes through the array from last to first
        for (int i = array.length - 1; i >= 0 ; i--){
            letter = i;
            count = 0;

            // this loop goes through the characters of the string and compares them to the array from end to beginning
            for (int j = 0; j < find.length(); j++ ){
                if (letter >= 0 && find.charAt(j) == array[letter] ) {
                    letter--;
                    count++;
                }
            }
            // if the counter of the consecutive corresponding letter is equal to the length of the string, the string is found
            if ( count == find.length()){
                return true;
            }
        }
        //if nothing was found the method returns false
        return false;
    }

    // this method takes a 2 dimensional array as an input and finds if a string is hidden in that arry
    public static boolean hiddenString (char[][] array, String find){
        if(array == null || find.equals(""))
            return false;

        // i is for rows and j is for columns

        // pass all the rows through the hidden string method
        for (int i = 0; i < array.length; i++){

             //creates a new temporary array for each row
             char[] row = new char[array[i].length];

             //this loop goes through each character of the row and copies it into the new array and then passes it
             // through the 1d hidden string method, it will return true if the hidden string is there
             for (int j = 0; j< array[i].length; j++){
                 row[j] = array[i][j];
                 if(hiddenString(row, find)){
                  return true;
                 }
             }
        }

        // this loop goes through all the columns
        for ( int j = 0; j < array[j].length ; j++){

            //creates a new temporary array
            char[] column = new char[array[j].length];

            // this loop copies each element of the column and makes the array go through the 1d hidden string method
            // which will return true if the hidden string is in the row
            for( int i = 0; i < array.length; i++){
                column[i] = array[i][j];
                if(hiddenString(column, find)){
                    return true;
                }
            }
        }


        //this double(i and j) loop will pass through every character of the array untill it finds the first character
        // of string we want to find
        for( int i = 0; i < array.length; i++){

            // a variable that keeps track of the number of letters found
            int count = 0;

            for( int j = 0; j < array[i].length; j++){

                // if we find the first letter
                if (find.charAt(0) == array[i][j]){

                    //this loop goes through all the character surrounding the first matching letter for the length of the
                    // string to find
                    for ( int x = 1; x <= find.length() && j < array[i].length - 1 && i < array.length - 1; x++ ){

                        //check if the diagonal going right and down is equal
                        if(array[++i][++j] == find.charAt(x)){
                            count ++;
                    }
                        //check if the diagonal going up and left is equal
                        else if(array[--i][--j] == find.charAt(x)){
                            count ++;
                        }
                        //check if the diagonal going left and down is equal
                        else if(array[++i][--j] == find.charAt(x)){
                            count++;
                        }
                        //check if the diagonal going up and right is equal
                        else if(array[--i][++j] == find.charAt(x)){
                            count++;
                        }
                    }
                    // if the count was reached in any direction the method returns true
                    if ( count == find.length()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
