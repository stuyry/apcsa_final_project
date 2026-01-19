package Code.Points;

public class DamagePoints implements Points {
    private long creditsApplied; //this is credits applied
    private State state;
    private long actualValue;


    @Override
    public long getPoints() { //this will show them the credits applied
        return creditsApplied;
    }

    @Override
    public void setPoints(long creditsApplied) { //user will input this
        this.creditsApplied = creditsApplied;
    }

    @Override
    public void applyState() { //really wanted to make this a constructor but I realized that when I make the object, the applied credits is null/0 and it constantly sets it to Weak/25
        if (creditsApplied < 10) { //make limits random
            state = State.LOW;
        } 
        else if (creditsApplied < 20) {
            state = State.MEDIUM;
        }
        else {
            state = State.MAX;
        }
        
    }

    @Override
    public State getState() {
        return state;
    }

    // public String getStateAsString() { //not necessary when I can do "" + getState() + ""
    //     return "" + state + "";
    // }

    @Override
    public long getActualValue() {
        return state.getActualValue(); 
        //TODO: add conversion factor and change the Points, maybe 1 2 3, might do switch??
    }

}
