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

    static HealthPoints healthPoints = new HealthPoints(); //OBJECTS SO I CAN ACCESS STATES AND ACTUAL VALUES (obvious)
    static DamagePoints damagePoints = new DamagePoints();
    static DefensePoints defensePoints = new DefensePoints();
    static LuckPoints luckPoints = new LuckPoints();
    static MagicPoints magicPoints = new MagicPoints();

    static String name = "";

    public void setCreditsFromMain(Integer setValue) { //in the end i want these two methods to be only static but that's just being picky
        credit.setCredits(setValue);
    }

    public Integer getCreditsFromMain() { //FIXED: this constantly returns the starting amount
        return credit.getCredits(); //used to be credits.get() (supplier) 
    } //works properly

     // TODO: fill in with all the values inputted, then loop through it to show user everything they put in
    //TODO: make it so that if a String is inputted where a string is, then they must reinput.
    public static void main(String[] args) {
        System.out.println("Name your character!");
        name = new Reader().getInputAsString();
        System.out.println("Name entered: " + name + "");
        System.out.print("\n"); 
        System.out.println("Starting credits: " + credits.get() + "");
        healthPoints.sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        damagePoints.sequence(); //simplified
        System.out.println("Current amount of credits left: " + credits.get() + "");
        defensePoints.sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        luckPoints.sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        magicPoints.sequence();
        System.out.println("Current amount of credits left: " + credits.get() + "");
        new Character(null, 0, null, 0, null, 0, null, 0, null, 0, null);

        
        // System.out.print("" + credits.get() + ""); //CLEARLY SUPPLIER WORKS, WHY AM I GETTING SO MANY ISSUES THEN :(
        // credit.setCredits(40);
        // System.out.print("" + credits.get() + "");


        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
