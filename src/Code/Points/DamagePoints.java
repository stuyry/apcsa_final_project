package Code.Points;

public class DamagePoints extends Points {
    private long dmg;

    @Override
    public long getPoints() {
        return dmg;
    }

    @Override
    public void setPoints(long dmg) {
        this.dmg = dmg;
    }

    
}
