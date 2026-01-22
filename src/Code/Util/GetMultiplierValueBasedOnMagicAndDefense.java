package Code.Util;

import Code.Battle;
import Code.Abilities.Magic;

public class GetMultiplierValueBasedOnMagicAndDefense {
    public double getDefenseMultiplier() { //used to multiply against the attack/damage multiplier
        //ALL GOOD HERE!!
        //TODO: make specifically for Poison
        //TODO: remove test case


        //System.out.println("TESTING: get Defense Multiplier value (IF NEGATIVE): " + (double)(1 + (Math.abs((double)opp.getDEF() - ((double)Magic.Poison.lowerDefense * (double)characterPoisonMagicTurnHolder)) / 100.0))); //THIS WOULD NOT PRINT CORRECTLY, BUT TESTED AND THIS METHOD WORKS FINE
        if (Battle.userTurn) {//Pretty printed but not fully
            return ((double) Battle.opp.getDEF() -
             ((double) Magic.Poison.lowerDefense *
              (double) Battle.characterPoisonMagicTurnHolder) -
               ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * Battle.oppNauseaTurnHolder) < 0 ?
               
               (1.0 + (double)(Math.abs((double) Battle.opp.getDEF() - 
                ((double) Magic.Poison.lowerDefense * (double) Battle.characterPoisonMagicTurnHolder) - //REDO
                 ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)Battle.oppNauseaTurnHolder)) / 100.0))  :
                 
                 (1.0 - (double)(Math.abs((double) Battle.opp.getDEF() - 
                ((double) Magic.Poison.lowerDefense * (double) Battle.characterPoisonMagicTurnHolder) - //REDO
                 ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)Battle.oppNauseaTurnHolder)) / 100.0)) ); 
        }
        //TODO: FINISH AFTER MAKING SEPERATE VARIABLES FOR TURNHOLDER AND FOR OPPONENT AND CHARACTER
        //Pretty Printed
//REMOVE
else {
        // System.out.println((double) character.getDEF() - 
        // (((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) + 
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder)));

        // System.out.println(1 + (Math.abs((double) character.getDEF() -
        // (((double) Magic.Poison.lowerDefense * (double) oppPoisonTurnHolder) +
        // ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * characterNauseaMagicTurnHolder))) / 100.0));

//REMOVE

        return ((double) Battle.character.getDEF() - 
        ((double) Magic.Poison.lowerDefense * (double) Battle.oppPoisonTurnHolder) - 
        ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * Battle.characterNauseaMagicTurnHolder) < 0 ? 
        
        (1.0 + (double)(Math.abs((double) Battle.character.getDEF() - //THE MATH IS WEIRD BECAUSE 0 - 40 = 0.4 + 1 = 1.4, but 0 -200 = 2 + 1 = 3 even though it should be 2/2.4 if both applied, that's messed up, but I guess I could add it to rules? //TODO: IMPORTANT
        ((double) Magic.Poison.lowerDefense * (double) Battle.oppPoisonTurnHolder) - 
        ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)Battle.characterNauseaMagicTurnHolder )) / 100.0)) :
        
        (1.0 - (double)(Math.abs((double) Battle.character.getDEF() - 
        ((double) Magic.Poison.lowerDefense * (double) Battle.oppPoisonTurnHolder) - 
        ((double) Magic.MagicSpellOfNausea.lowerSelfDefense * (double)Battle.characterNauseaMagicTurnHolder )) / 100.0)) );
}
    }
}
