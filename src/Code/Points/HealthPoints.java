package Code.Points;

import Code.Main;
import Code.Reader;

public class HealthPoints extends Points {
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

        System.out.print("Apply Credits towards HP here!" + "\n");  //Buffered reader doesn't look at escape sequences Im pretty sure
        System.out.print("Credit input for health points: ");
        points = new Reader().getInputAsInt();

        Integer points2 = points;

        setPoints(points); //IT WORKED!!
        new Main().setCreditsFromMain(new Main().getCreditsFromMain() - points2);

        System.out.print("\n");
        System.out.print("RECEIVED: ");
        System.out.println("" + getPoints() + "");
        applyState();
        System.out.print("HP State returned: ");
        System.out.println ("" + getState() + ""); //EVERYTHING WORKS WONDERFUL!!!
        System.out.print("Character HP: ");
        System.out.println("" + getActualValue() + "".concat("%"));
        System.out.print("\n");

        //System.out.println(new Main().getCreditsFromMain()); //TODO: RESOLVED temp
    }
}
//OLD PROTOTYPE FROM MY SECOND COMMIT I THINK
    //     private long HP;

//     @Override
//     public long getPoints() {
//         return HP;
//     }
// //TODO: need to make opponent class and choose attack class
//     @Override
//     public void setPoints(long HP) { //used to update HP after each attack from opponenet
//         this.HP = HP;
//     } //TODO: might need to change to apply credits

//     // @Override
//     // public long determineStrength() {
//     //     if (getPoints() <= 33) { 
//     //         // TODO: make these values random to add some risk to the game so you don't definitively know how many points to allocate (more strategy / luck)
//     //         //TODO: make the first value between 0 and 60, and then the rest be half the distance from that number to 100, so 60, 40/2 = 20, 60 80 100 are the different strength levels
//     //         return 1;
//     //     }
//     //     return 1;
//     // }

//     // public void reportHP() {

//     // }
    



