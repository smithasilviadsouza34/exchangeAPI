import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingNumbers {

    public static void main(String args[]){
       Integer[] num={10,20,10,30,40};

        List<Integer> numList=Arrays.asList(num);
        Map<Integer,Long> frequencyMap= numList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        frequencyMap.entrySet().stream().filter(entry->entry.getValue()>1).forEach(entry->System.out.println(entry.getKey()+" Count : "+entry.getValue()));

    }
}
