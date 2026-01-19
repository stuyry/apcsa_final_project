package Code;

import Code.Points.State;

public class Character {
    private final String name;
    private final long dmg;
    private final long def;
    private final long HP;
    private final long luck;
    private final long magic;

    public Character(String name, long dmg, State dmgState, long def, State defState, long HP, State HPState, long luck, State luckState, long magic, State magicState) {
        this.name = name;
        this.dmg = dmg;
        this.def = def;
        this.HP = HP;
        this.luck = luck;
        this.magic = magic;
    }

    public void printCharacterSummary() {
        System.out.println("Summary: ");
        System.out.print("Character Name: ");
        System.out.println("" + name + "");
        System.out.print("Attack Stats (damage/State): ");
    }
}
