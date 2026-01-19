package Code;

import Code.Points.DamagePoints;
import Code.Points.DefensePoints;
import Code.Points.HealthPoints;
import Code.Points.LuckPoints;
import Code.Points.MagicPoints;
import java.util.function.Supplier;


public class Main {
    //static ReadTheInputs x = new ReadTheInputs();
    static Credits credit = new Credits();
    static Supplier<Integer> credits = () -> credit.getCredits();

    public void setCreditsFromMain(Integer setValue) { //in the end i want these two methods to be only static but that's just being picky
        credit.setCredits(setValue);
    }

    public Integer getCreditsFromMain() { //FIXED: this constantly returns the starting amount
        return credit.getCredits(); //used to be credits.get() (supplier) 
    } //works properly

    String[] allValues = new String[1]; // TODO: fill in with all the values inputted, then loop through it to show user everything they put in
    //TODO: make it so that if a String is inputted where a string is, then they must reinput.
    public static void main(String[] args) {
        System.out.println("Starting credits: " + credits.get() + "");
        new HealthPoints().sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        new DamagePoints().sequence(); //simplified
        System.out.println("Current amount of credits left: " + credits.get() + "");
        new DefensePoints().sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        new LuckPoints().sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        new MagicPoints().sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");

        
        // System.out.print("" + credits.get() + ""); //CLEARLY SUPPLIER WORKS, WHY AM I GETTING SO MANY ISSUES THEN :(
        // credit.setCredits(40);
        // System.out.print("" + credits.get() + "");


        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
