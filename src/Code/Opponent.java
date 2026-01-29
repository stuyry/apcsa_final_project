package Code;

public class Opponent {
    static HealthPoints healthPoints = new HealthPoints(); //OBJECTS SO I CAN ACCESS STATES AND ACTUAL VALUES (obvious) (from main)
    static DamagePoints damagePoints = new DamagePoints();
    static DefensePoints defensePoints = new DefensePoints();
    static LuckPoints luckPoints = new LuckPoints();
    static MagicPoints magicPoints = new MagicPoints();

    private long dmg;
    private long def;
    private long HP;
    private long luck;
    private long magic;

    private long magicCredits;

    public void applyCreditsTowardsAttributes(int multiplier) { //TODO: THIS IS OKAY.. -> Will add logic later, just want to get a rough draft of battle actual working
        healthPoints.setPoints(new RandomNumber(multiplier).getRandomNumber()); 
        damagePoints.setPoints(new RandomNumber(multiplier).getRandomNumber());
        defensePoints.setPoints(new RandomNumber(multiplier).getRandomNumber());
        magicPoints.setPoints(new RandomNumber(multiplier).getRandomNumber());
        //damagePoints.setPoints(50);
        //defensePoints.setPoints(0);
        luckPoints.setPoints(new RandomNumber(multiplier).getRandomNumber());
        //luckPoints.setPoints(50);

        healthPoints.applyState();
        damagePoints.applyState();
        defensePoints.applyState();
        magicPoints.applyState();
        luckPoints.applyState();

        dmg = damagePoints.getActualValue();
        def = defensePoints.getActualValue();
        HP = healthPoints.getActualValue();
        luck = luckPoints.getActualValue();
        magic = magicPoints.getActualValue();

        magicCredits = 10;
    }

    public long getHP() {
        return HP;
    }
    public void setHP(long HP) {
        this.HP = HP;        
    }
    public long getDMG() {
        return dmg;
    }
    public void setDMG(long dmg) {
        //for magic (weakened)
        this.dmg = dmg;
    }
    public long getDEF() {
        return def;
    }
    public void setDEF(long def) {
        //for magic (vulnerable)
        this.def = def;
    }
    public long getLuck() {
        return luck;
    }
    public void setLuck(long luck) {
        //for magic (dizzy)
        this.luck = luck;
    }
    public long getMagic() {
        return magic;
    }
    public void setMagic(long magic) {
        //for magic, (disable all magic)
        this.magic = magic;
    }

    public long getMagicCredits() {
        return magicCredits;
    }

    public void setMagicCredits(long magicCredits) {
        this.magicCredits = magicCredits;
    }
    //TODO: RESOLVED (via switch) add a method for choosing attack
}
