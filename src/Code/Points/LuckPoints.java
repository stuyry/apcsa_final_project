package Code.Points;

import Code.Main;
import Code.Reader;

public class LuckPoints extends Points{
    static long randomValue = (long) (Math.random() * 30); //simplest way (avoids max being surpassed (50))
    
    
    @Override
    public void applyState() { //really wanted to make this a constructor but I realized that when I make the object, the applied credits is null/0 and it constantly sets it to Weak/25
        setRandomValue(randomValue);

        if (getPoints() <= getRandomValue()) { //make limits random
            setState(State.LOW);
        } 
        else if (getPoints() <= getRandomValue() + 15) {
            setState(State.MEDIUM);
        }
        else { //TODO: VERY IMPORTANT MAKE THIS ELSE IN EVERYTHING
            setState(State.MAX); //NULL error occurs because of the logic lol
        }
        
    }

    @Override
    public long getActualValue() { 
        return getState().getActualValue() * 10; 
        //TODO: add conversion factor and change the Points, maybe 1 2 3, might do switch??
    }

    @Override
    public void sequence() {
        int points = 0;
        System.out.print("Apply Credits towards LUCK here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for luck: ");
        
        points = new Reader().getInputAsIntCredits();

        Integer points2 = points;

        setPoints(points); //IT WORKED!!
        new Main().setCreditsFromMain(new Main().getCreditsFromMain() - points2);

        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("Luck State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Chance of Critical Hit: ");
        System.out.println("" + getActualValue() + "".concat("%")); //update this to be 50 less than landing chancce
        System.out.print("Chance of landing attack: ");
        System.out.println("" + getActualValue() + "".concat("%"));

        System.out.print("\n");
    }
}
