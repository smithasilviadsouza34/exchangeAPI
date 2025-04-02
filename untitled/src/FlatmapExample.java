import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatmapExample {
    static int n=method1();

    private static int method1() {
        return 5;
    }

    static {
        method2();
    }

    private static void method2() {
    }

    public static void main(String args[]){
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("Geeks", "For"),
                Arrays.asList("GeeksForGeeks", "A computer portal"),
                Arrays.asList("Java", "Programming")
        );
        List<String> result=listOfLists.stream().flatMap(list->list.stream()).collect(Collectors.toList());

     System.out.println(result);
    }
}
