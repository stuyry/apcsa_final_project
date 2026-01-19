package Code.Points;

public class DamagePoints implements Points {
    private long dmgCreditsApplied; //this is credits applied
    private damageStrength strength;


    @Override
    public long getPoints() { //this will show them the credits applied
        return dmgCreditsApplied;
    }

    @Override
    public void setPoints(long dmgCreditsApplied) { //user will input this
        this.dmgCreditsApplied = dmgCreditsApplied;
    }

    public enum damageStrength { //this will be used to acheive the level
        WEAK(25),
        STRONG(50), //UPDATE THESE VALUES AS A FRACTION OF HP
        MAX(100); //THIS SEEMS BALANCED

        private long damageStrength;

        private damageStrength(long damageStrength) {
            this.damageStrength = damageStrength;
        }

        public long getDamageStrength() {
            return damageStrength;
        }
    }

    public damageStrength getStrength() { //this computes the level
        //TODO: put this in the constructor??
        if (dmgCreditsApplied < 10) { //make limits random
            strength = damageStrength.WEAK;
        } 
        else if (dmgCreditsApplied < 20) {
            strength = damageStrength.STRONG;
        }
        strength = damageStrength.MAX;

        return strength;
    }

    public String stringStrength() { //this shows the level
        return ("" + getStrength() + "");
    }
    
    public long getDmg() {
        return getStrength().getDamageStrength();
    }
    
}
