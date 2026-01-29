package Code;

public class MagicPoints extends Points {
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
        else {
            setState(State.MAX);
        }
        
    }

    @Override
    public long getActualValue() { 
        return getState().getActualValue() * 20; 
        //TODO: RESOLVED add conversion factor and change the Points, maybe 1 2 3, might do switch??
    }

    @Override
    public void sequence() {
        
        int points = 0;
        System.out.print("Apply Credits towards MAG here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for Magic: ");
        points = new Reader().getInputAsIntCredits();

        Integer points2 = points;

        setPoints(points); //IT WORKED!!
        new Main().setCreditsFromMain(new Main().getCreditsFromMain() - points2);

        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("Magic State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Infliction of Magic: "); //TODO: fill in with something better once I have a better idea
        System.out.println("" + getActualValue() + "".concat("%")); //TODO: IMPORTANT ADD PERCENTS/FACTORS TO THE ATTRIBUTES OF THE MAGIC
        System.out.print("\n");
    }
}
