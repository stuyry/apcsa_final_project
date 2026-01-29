package Code;

// import Code.Abilities.Attack;

public class CharacterHaymakerSequence {
    public void HayMaker() {
         if (Battle.character.getMagicCredits() < Attack.HayMaker.MagicDrain) {
            System.out.println ("Not Enough magic credits, please try again!");
        }
        else {
            System.out.println("Character used HAYMAKER ! - Draining themselves of 2 Magic Credits !");
            Battle.retryMagic = false;
            Battle.damageMultiplier = Attack.HayMaker.HayMakerMultiplier;
            Battle.isNormalAttack = true;
            Battle.character.setMagicCredits(Battle.character.getMagicCredits() - Attack.HayMaker.MagicDrain);
                                
            new ApplyBasedOnLuck().applyBasedOnLuck();
        }
    }
}
