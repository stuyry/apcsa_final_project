package Code;

import Code.Points.DamagePoints;

public class Main {
    //static ReadTheInputs x = new ReadTheInputs();
    static DamagePoints dmgPoints = new DamagePoints();
    public static void main(String[] args) {
        System.out.print("Apply Credits towards DMG here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        dmgPoints.setPoints(new Reader().getInputAsInt()); //IT WORKED!!
        System.out.println("" + dmgPoints.getPoints() + "");
        System.out.println (dmgPoints.stringStrength()); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("" + dmgPoints.getDmg() + "");
        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
