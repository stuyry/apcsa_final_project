package Code;

// import Code.Abilities.Attack;

public class CharacterJabSequence {
    public void Jab() {
        System.out.println("Character used JAB ! - Regaining 2 Magic Credits!");
        Battle.damageMultiplier = Attack.Jab.jabMultiplier;
        Battle.isNormalAttack = true;

        Battle.magicCharacterCreditsToApplyClamped = Math.clamp(Battle.character.getMagicCredits() + Attack.Jab.MagicGain, 0, 10);
        Battle.character.setMagicCredits(Battle.magicCharacterCreditsToApplyClamped);

        Battle.retryMagic = false;
                            
        new ApplyBasedOnLuck().applyBasedOnLuck();
    }
}
