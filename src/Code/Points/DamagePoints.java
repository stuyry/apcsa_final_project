package Code.Points;

import Code.Reader;

public class DamagePoints extends Points {
    
    @Override
    public void applyState() { //really wanted to make this a constructor but I realized that when I make the object, the applied credits is null/0 and it constantly sets it to Weak/25
        
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
    public long getActualValue() { //accessed in state enum
        return getState().getActualValue(); 
        //TODO: add conversion factor and change the Points, maybe 1 2 3, might do switch??
    }

    // public String getStateAsString() { //not necessary when I can do "" + getState() + ""
    //     return "" + state + "";
    // }

    @Override
    public void sequence() {
        System.out.print("Apply Credits towards DMG here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for damage: ");
        setPoints(new Reader().getInputAsInt()); //IT WORKED!!
        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("Damage State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Damage you will deal per Attack: ");
        System.out.println("" + getActualValue() + "");
        System.out.print("\n");
    }

}
