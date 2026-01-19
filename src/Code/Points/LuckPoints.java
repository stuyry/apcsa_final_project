package Code.Points;

public class LuckPoints implements Points{
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
