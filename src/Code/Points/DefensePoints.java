package Code.Points;

public class DefensePoints implements Points{
    private long def;

    @Override
    public long getPoints() {
        return def;
    }

    @Override
    public void setPoints(long def) {
        this.def = def;
    }
}
