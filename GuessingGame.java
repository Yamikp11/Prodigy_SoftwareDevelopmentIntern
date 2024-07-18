package guessinggame;
import java.util.*;
public class GuessingGame {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int ran_num=(int)(Math.random()*10);
        boolean b=true;
        int count=0;
        while(b){
        System.out.println("Guess the number(1 to 10)");
        int n=s.nextInt();
        if(n==ran_num+1){
            b=false;
            System.out.println("You correctly guess the number");
            System.out.println("You had take "+ count+" attempt to guess the number "+ (ran_num+1));
        }
        else if(n<ran_num+1){
            System.out.println("Guessed number is too low");
        }
        else if(n>ran_num+1){
            System.out.println("Guessed number is too high");
        }
        count++;
        }
    }
}
