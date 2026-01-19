package Code.Points;

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
    



