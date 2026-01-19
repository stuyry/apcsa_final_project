package Code.Points;

public interface Points {
    //private long points;

    public abstract long getPoints();
    public abstract void setPoints(long points);
    public abstract void applyState();
    public abstract State getState();
    public abstract long getActualValue(); //access from state (in State.java / enum)


    //public abstract long determineStrength(); //TODO: (RESOLVED) (will not be using) uncomment later
}
