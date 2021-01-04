// Omar Loudghiri, This class provides the date.
import java.util.*;

public class Date {

// Fields
    //a. a field that stores the day number.
    private int day;

    //b. a field that stores what month number it is.
    private int month;

//Constructors

    // a constructor that takes two inputs and set those inputs to be the day and the month of the current instance of Date.
    public Date(int day, int month){
        this.day = day;
        this.month = month;
    }

// Methods

    // a. a method to access the day number.
    public int getDay() {
        return day;
    }

    //b. a method to access the month number.
    public int getMonth() {
        return month;
    }

    /*c. a method that adds one day each time it is called, depending on how many days in the month there are, it adds 1
    /* to month */
    public void incrementDay(){
        day++;
        if ((month == 1 || month == 3 || month == 5 || month ==7 || month ==8 || month == 10 || month ==12) && (day > 31)){
            day=1;
            month++;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11 ) && (day > 30)){
            day=1;
            month++;
        }
        if ((month == 2) && (day > 29)) {
            day=1;
            month++;
        }
        if (month>12){
            month = 1;
            day=1;
        }
    }

    //d. a method that overrides the equals method and makes it compare between the date of two instances of a Date
    @Override
    public boolean equals (Object obj) {
        if(obj == this) return true;
        if(( (obj == null) || (this.getClass() != obj.getClass()))) return false;
        Date other = (Date) obj;
        return(this.getDay() == other.getDay() && this.getMonth() == other.getMonth());
    }

    //e. a method that overruns the toString method and makes it return a sentence that include the date.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append( "today is: " + this.getMonth() + '/' + this.getDay());

        return sb.toString();
    }
}
