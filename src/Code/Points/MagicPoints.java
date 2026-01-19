package Code.Points;

import Code.Reader;

public class MagicPoints extends Points {
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
        System.out.print("Apply Credits towards MAG here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for Magic: ");
        setPoints(new Reader().getInputAsInt()); //IT WORKED!!
        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("Magic State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Infliction of Magic: "); //TODO: fill in with something better once I have a better idea
        System.out.println("" + getActualValue() + "".concat("%"));
        System.out.print("\n");
    }
}
