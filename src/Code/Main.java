package Code;

import Code.Points.DamagePoints;

public class Main {
    //static ReadTheInputs x = new ReadTheInputs();
    static DamagePoints dmgPoints = new DamagePoints();
    String[] allValues = new String[1]; // TODO: fill in with all the values inputted, then loop through it to show user everything they put in
    //TODO: make it so that if a String is inputted where a string is, then they must reinput.
    public static void main(String[] args) {
        System.out.print("Apply Credits towards DMG here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for damage: ");
        dmgPoints.setPoints(new Reader().getInputAsInt()); //IT WORKED!!
        System.out.print("RECEIVED: ");
        System.out.println("" + dmgPoints.getPoints() + "");
        dmgPoints.applyState();
        System.out.print("Damage State returned: ");
        System.out.println ("" + dmgPoints.getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Damage you will deal per Attack: ");
        System.out.print("" + dmgPoints.getActualValue() + "");
        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
