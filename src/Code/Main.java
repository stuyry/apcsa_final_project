package Code;

import Code.Points.DamagePoints;
import Code.Points.DefensePoints;
import Code.Points.HealthPoints;
import Code.Points.LuckPoints;
import Code.Points.MagicPoints;
import Code.Points.Name;
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
    static Name name;
    static Character character;

    //static String name = "";

    public void setCreditsFromMain(Integer setValue) { //in the end i want these two methods to be only static but that's just being picky
        credit.setCredits(setValue);
    }

    public Integer getCreditsFromMain() { //FIXED: this constantly returns the starting amount
        return credit.getCredits(); //used to be credits.get() (supplier) 
    } //works properly

     // TODO: fill in with all the values inputted, then loop through it to show user everything they put in
    //TODO: make it so that if a String is inputted where a string is, then they must reinput.
    public static void main(String[] args) { //TODO: IMPORTANT WITH LOTS TO DO: MAKE TRY CATCH FOR NAME AND REMOVE THE RANDOM VALUES FROM PRINTING IN SEQUENCES.
        System.out.println("Name your character!");
        name = new Name();
        System.out.println("Name entered: " + name.getName() + "");
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
        System.out.println("Credits unused (applied as negation to Opponent HP): " + credits.get() + "");
        System.out.print("\n");
        character = new Character(name, damagePoints.getActualValue(), damagePoints.getState(), defensePoints.getActualValue(), defensePoints.getState(), healthPoints.getActualValue(), healthPoints.getState(), luckPoints.getActualValue(), luckPoints.getState(), magicPoints.getActualValue(), magicPoints.getState());
        
        character.printCharacterSummary();
        // System.out.print("" + credits.get() + ""); //CLEARLY SUPPLIER WORKS, WHY AM I GETTING SO MANY ISSUES THEN :(
        // credit.setCredits(40);
        // System.out.print("" + credits.get() + "");


        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
