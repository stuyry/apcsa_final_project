package Code.Points;

import Code.Main;
import Code.Reader;

public class DefensePoints extends Points{
    @Override
    public void applyState() { 
        
        if (getPoints() < 10) { //make limits random
            setState(State.LOW);
        } 
        else if (getPoints() < 20) {
            setState(State.MEDIUM);
        }
        else {
            setState(State.MAX);
        }
        
    }
    @Override
    public long getActualValue() { 
        return getState().getActualValue(); 
        //TODO: add conversion factor and change the Points, maybe 1 2 3, might do switch??
    }

    @Override
    public void sequence() {
        int points = 0;

        System.out.print("Apply Credits towards DEF here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for defense: ");
        
        points = new Reader().getInputAsInt();

        Integer points2 = points;

        setPoints(points); //IT WORKED!!
        new Main().setCreditsFromMain(new Main().getCreditsFromMain() - points2);

        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("Defense State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Damage mitigated as %: ");
        System.out.println("" + getActualValue() + "".concat("%"));
        System.out.print("\n");
    }
}
