import java.util.*;

/**
 * Created by Admin on 12/3/2016.
 */
public class technical {

    public static void main(String [] args) {

        List<Object> obj =new ArrayList<>();
        for (int i=0; i < 8; i++){
            obj.add(null);
        }
        //System.out.println("OBJECT: " + obj.size());
        obj.add(2); obj.add(3); obj.add(null); obj.add(null);
        obj.add(3); obj.add(4); obj.add(null); obj.add(null);
        obj.add(4); obj.add(5); obj.add(3); obj.add("blah");
        obj.add(5);

        // A reversed list stimulates a LIFO stream
        Collections.reverse(obj);
        generateMeanMax(5,obj);
    }

    public static MeanMax generateMeanMax(int windowSize, List<Object> stream){
        Set<Integer> subList = new LinkedHashSet<>();
        Object item;

        for (int i = 0; i < stream.size(); i++){
            item = stream.get(i);
            if (subList.size()<windowSize && item!=null && item instanceof Number){
                subList.add(Integer.parseInt(item.toString()));
            }
        }
        return compute(windowSize,subList);
    }

    public static MeanMax<Integer,Integer> compute(int windowSize, Set<Integer> set){
        int max = 0;
        int mean;
        int sum = 0;
        MeanMax<Integer,Integer> mm;

        System.out.println("SET_SIZE: " + set.size());
        int diff = windowSize - set.size();
        System.out.println("DIFF: " + diff);

        for (int i : set){
            if(max < i) max=i;
            System.out.println("i " + i);
            sum+=i;
        }

        mean = (sum+diff)/windowSize;
        mm = new MeanMax<>(mean,max);
        System.out.println("MEAN: " + mean + " MAX: " + max + " SET SIZE:" + set.size());
        return mm;
    }

}



