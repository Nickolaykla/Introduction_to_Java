package algorithmization.multidimensional_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Task13 {
    public static void main(String[] args) {
        int[]arr = {1,6,4,2,3};
        Arrays.stream(arr).boxed()
                .sorted(Comparator.reverseOrder())
                .toArray();
    }
}
