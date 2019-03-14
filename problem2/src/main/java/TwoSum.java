import java.util.*;
import java.util.stream.Collectors;

public class TwoSum {

    private static int[] findTwoSum(int[] list, int i) {
        ArrayList<Integer> returnList = new ArrayList<>();
        List<Integer> integerList = Arrays.stream(list).boxed().collect(Collectors.toList());
        HashSet<Tuple<Integer, Integer>> sums = new HashSet<>();
        for (Integer valueToAdd : integerList) {
            for (Integer item : integerList) {
                if (valueToAdd + item == i) {
                    Tuple<Integer, Integer> tuple = new Tuple<>(valueToAdd, item);
                    if(sums.stream().allMatch(tupleToMatch -> {
                        if (tupleToMatch.x.equals(tuple.x) && tupleToMatch.y.equals(tuple.y)) {
                            return false;
                        } else return !tupleToMatch.x.equals(tuple.y) || !tupleToMatch.y.equals(tuple.x);
                    })) {
                        sums.add(tuple);
                    }
                }
            }
        }
        sums.forEach(value -> {
            returnList.add(value.x);
            returnList.add(value.y);
            System.out.println("x--> "+value.x + " y--> "+value.y);
        });
        return returnList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] {8, 3, 1, 5, 6,  7, 5, 9, 4, 2,  0, 10, 2}, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }

    public static class Tuple<X, Y> {
        final X x;
        final Y y;

        Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
