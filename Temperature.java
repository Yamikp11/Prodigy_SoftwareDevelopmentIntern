package temperature;
import java.util.*;
public class Temperature {
    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
       System.out.println("Enter Temperature Value");
       double temp=s.nextDouble();
       System.out.println("Enter the unit (C,K,F)");
       char c=s.next().charAt(0);
       temp_conversion(c,temp);    
    }
    public static void temp_conversion(char c,double temp){
        double value;
        if(c=='C'){
            value=(temp*9/5)+32;
            System.out.println("Value in Fahrenheit "+ value+"F");
            value=temp + 273.15;
            System.out.println("value in Kelvin "+ value +"K");
        }
        else if(c=='F'){
            value=(temp-32)*5/9;
            System.out.println("Value in Celsius "+ value+"C");
            value=(temp-32)*5/9+273.15;
            System.out.println("value in Kelvin "+ value +"K");
        }
        else if(c=='K'){
            value=temp-273.15;
            System.out.println("Value in Celsius "+ value+"C");
            value=(temp - 273.15)*9/5+32;
            System.out.println("Value in Fahrenheit "+ value+"F");
        }
        else{
            System.out.println("Invalid Input");
        }
    }
}
