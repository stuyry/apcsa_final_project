package Code;

import Code.Points.DamagePoints;
import Code.Points.DefensePoints;
import Code.Points.HealthPoints;
import Code.Points.LuckPoints;
import Code.Points.MagicPoints;

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

    public void applyCreditsTowardsAttributes() { //TODO: THIS IS OKAY.. -> Will add logic later, just want to get a rough draft of battle actual working
        healthPoints.setPoints(new RandomNumber(50).getRandomNumber()); 
        damagePoints.setPoints(new RandomNumber(50).getRandomNumber());
        defensePoints.setPoints(new RandomNumber(50).getRandomNumber());
        magicPoints.setPoints(new RandomNumber(50).getRandomNumber());
        luckPoints.setPoints(new RandomNumber(50).getRandomNumber());

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
    //TODO: RESOLVED (via switch) add a method for choosing attack
}
