package Code;

import Code.Points.HealthPoints;

public class Main {
    //static ReadTheInputs x = new ReadTheInputs();
    static HealthPoints healthPoints = new HealthPoints();
    public static void main(String[] args) {
        System.out.print("Apply Credits towards HP here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        healthPoints.setPoints(new Reader().getInputAsInt()); //IT WORKED!!
        System.out.print(healthPoints.getPoints());
        //REALLY happy this worked. Initally I was thinking about making a second constructor with a holder variable
        //and then calling that every time but then as I went to code it I was like WAIT, new makes a seperate object EVERY single time in Java's memory, so i did it.
    }
}
