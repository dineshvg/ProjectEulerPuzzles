import java.util.ArrayList;
import java.util.HashSet;

public class Problem1 {

    public static void main(String[] args) {
        System.out.println("If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.\n" +
                "\n" +
                "Find the sum of all the multiples of 3 or 5 below 1000.");
        int three = 3;
        int five = 5;

        ArrayList<Integer> multiplesOfThree = new ArrayList<>();
        ArrayList<Integer> multiplesOfFive = new ArrayList<>();
        multiplesOfThree = makeListInLimitForMultiples(three, multiplesOfThree);
        multiplesOfFive = makeListInLimitForMultiples(five, multiplesOfFive);

        multiplesOfThree.removeAll(new HashSet<>(multiplesOfFive));
        System.out.println("number of multiples for three: " + multiplesOfThree.size());
        System.out.println("number of multiples for five: " + multiplesOfFive.size());

        int sum = multiplesOfThree.stream().mapToInt(Integer::intValue).sum() +
                multiplesOfFive.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Answer: " + sum);
    }

    private static ArrayList<Integer> makeListInLimitForMultiples(int intgerUnderTest, ArrayList<Integer> multiplesHolder) {
        int limit = 1000;
        for (int i = 0; i < limit; i++) {
            if ((intgerUnderTest * i) < limit) {
                multiplesHolder.add(intgerUnderTest * i);
            }
        }
        return multiplesHolder;
    }
}
