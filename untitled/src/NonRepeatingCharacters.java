import java.util.Map;
import java.util.stream.Collectors;

public class NonRepeatingCharacters {

    public static void main(String args[]){
        String input = "Java Hungry Blog Alive is Awesome";

    String result=     input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).map(String::valueOf).collect(Collectors.joining());
    System.out.println(result);
    }

}
