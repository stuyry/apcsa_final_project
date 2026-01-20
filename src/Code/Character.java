package Code;

import Code.Points.State;

public class Character { //TODO: make this a interface
    private final String name;
    private long dmg;
    private long def;
    private long HP;
    private long luck;
    private long magic;

    private final State dmgState;
    private final State defState;
    private final State HPState;
    private final State luckState;
    private final State magicState;

    public Character(String name, long dmg, State dmgState, long def, State defState, long HP, State HPState, long luck, State luckState, long magic, State magicState) {
        this.name = name;
        this.dmg = dmg;
        this.def = def;
        this.HP = HP;
        this.luck = luck;
        this.magic = magic;

        this.dmgState = dmgState;
        this.defState = defState;
        this.HPState = HPState;
        this.luckState = luckState;
        this.magicState = magicState;

    }

    public void printCharacterSummary() {
        System.out.println("Summary: ");
        System.out.print("Character Name: ");
        System.out.println("" + name + "");
        System.out.println("Health Stats (HP/State): " + HP + " / " + HPState);
        System.out.println("Attack Stats (damage/State): " + dmg + " / " + dmgState);
        System.out.println("Defense Stats (defense/State): " + def + " / " + defState);
        System.out.println("Luck Stats (luck/State): " + luck + " / " + luckState);
        System.out.println("Magic Stats (magic/State): " + magic + " / " + magicState + "\n");
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

    //TODO: Potentially add disabled state / skip turn state?? / turn Over state??

}
