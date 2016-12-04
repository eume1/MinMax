import java.util.*;

/**
 * Created by Admin on 12/3/2016.
 */
public class technical {

    public static void main(String[] args) {

        int windowSize = 4; //configurable

        List<Object> obj = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            obj.add(null);
        }

        obj.add(2); obj.add(3); obj.add(null); obj.add(null);
        obj.add(3); obj.add(4); obj.add(null); obj.add(null);
        obj.add(4); obj.add(5); obj.add(3); obj.add("blah");
        obj.add(5);

        // A reversed list stimulates a LIFO stream
        Collections.reverse(obj);
        generateMeanMax(windowSize, obj);
    }

    public static MeanMax generateMeanMax(int windowSize, List<Object> stream) {
        Set<Integer> subList = new LinkedHashSet<>();
        Object item;

        for (int i = 0; i < stream.size(); i++) {
            item = stream.get(i);
            if (subList.size() < windowSize && item != null && item instanceof Number) {
                subList.add(Integer.parseInt(item.toString()));
            }
        }
        return compute(windowSize, subList);
    }

    public static MeanMax<Integer, Integer> compute(int windowSize, Set<Integer> set) {
        int max = 0;
        int mean;
        int sum = 0;
        MeanMax<Integer, Integer> mm;

        int diff = windowSize - set.size();

        for (int i : set) {
            if (max < i) max = i;
            sum += i;
        }

        mean = (sum + diff) / windowSize;
        mm = new MeanMax<>(mean, max);
        System.out.println("MEAN: " + mean + " MAX: " + max + " SET SIZE: " + set.size());
        return mm;
    }

}



