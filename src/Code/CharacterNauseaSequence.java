package Code;

// import Code.Abilities.Magic;

public class CharacterNauseaSequence {

    public void Nausea() {
        if (Battle.character.getMagicCredits() < Magic.MagicSpellOfNausea.MagicDrain) {
            System.out.println("Not Enough magic credits, please try again!");
        } else {
            System.out.println("Character used NAUSEA ! - Draining themselves of 7 Magic Credits !");
            System.out.println("Character inflicted Opponent with Nausea, decreasing their luck, but increasing chance for themselves to mitigate the opponent's attack");
            System.out.println("However, Character has made themselves more vulnerable, allowing the opponent to deal DOUBLE damage if their attack lands !");
            Battle.retryMagic = false; //boolean
            Battle.applyTurnHolder = false; //boolean

            Battle.characterNauseaMagicTurnHolder += 1; //Set
            Battle.character.setMagicCredits(Battle.character.getMagicCredits() - Magic.MagicSpellOfNausea.MagicDrain); //Set

        }
    }
}
