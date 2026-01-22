package Code.Abilities;

public interface Magic {
    public interface Poison {
        int lowerDefense = 40; //vulnerability thingy I was talking about
        int MagicDrain = 5;
    }

    public interface Weaken { //Weaken
        int lowerAtk = 10;
        int MagicDrain = 3;
    }

    public interface MagicSpellOfNausea { //make Dizzy
        int lowerLuck = 40;
        int MagicDrain = 7;
        int lowerSelfDefense = 100;
    }
}
    // public int getPoisonDefenseNegator() {
    //     return Poison.lowerDefense;
    // }

    // public int getPoisonMagicDrain() {
    //     return Poison.MagicDrain;
    // }

    // public int getStickArmLowerAtk() {
    //     return StickArms.lowerAtk;
    // }

    // public int getStickArmMagicDrain() {
    //     return StickArms.MagicDrain;
    // }

    // public int getMagicSpellOfNauseaLowerLuck() {
    //     return MagicSpellOfNausea.lowerLuck;
    // }

    // public int getMagicSpellOfNauseaMagicDrain() {
    //     return MagicSpellOfNausea.MagicDrain;
    // }

    // public int getMagicSpellOfNauseaLowerSelfDefense() {
    //     return MagicSpellOfNausea.lowerSelfDefense;
    // }
//}
