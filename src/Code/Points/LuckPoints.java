package Code.Points;

public class LuckPoints extends Points{
    private long luck;

    @Override
    public long getPoints() {
        return luck;
    }

    @Override
    public void setPoints(long luck) {
        this.luck = luck;
    }
}
