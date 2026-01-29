package Code;

public class CharacterSkipTurn {

    public void Skip() {
        System.out.println("Turn Successfully passed over to the opponent !");
        Battle.opponentTurn = true;
        Battle.userTurn = false;
        Battle.retryMagic = false;
    }
}
