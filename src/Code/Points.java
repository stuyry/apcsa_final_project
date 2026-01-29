package Code;


public abstract class Points {
    //private long points;
    private long creditsApplied; //this is credits applied
    private State state;
    private long randomValue;
    //private long actualValue;



    public long getPoints() { //this will show them the credits applied
        return creditsApplied;
    }


    public void setPoints(long creditsApplied) { //user will input this
        this.creditsApplied = creditsApplied;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(long randomValue) {
        this.randomValue = randomValue;
    }

    // public String getStateAsString() { //not necessary when I can do "" + getState() + ""
    //     return "" + state + "";
    // }


    public abstract long getActualValue();
    public abstract void applyState(); //STAY ABSTRACT
    public abstract void sequence(); //STAY ABSTRACT


    //public abstract long determineStrength(); //TODO: (RESOLVED) (will not be using) uncomment later
}
