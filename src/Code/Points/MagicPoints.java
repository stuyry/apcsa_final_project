package Code.Points;

public class MagicPoints extends Points {
    private long MP;

    @Override
    public long getPoints() {
        return MP;
    }

    @Override
    public void setPoints(long MP) {
        this.MP = MP;
    }
}
