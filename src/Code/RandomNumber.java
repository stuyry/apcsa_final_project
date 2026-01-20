package Code;
//Class made to generate everything for the opponent
public class RandomNumber {
    private static long randomNumber;

    public RandomNumber(int multiplier) {
        randomNumber = (long)(Math.random() * multiplier);
    }

    public long getRandomNumber() {
        return randomNumber;
    }
    
}
