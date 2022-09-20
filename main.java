import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        int[] numbers = {4, 1, 5, 8, 99, 23, 11};
        ArrayList <Integer> num = new ArrayList<>();
        for(int i: numbers){
            num.add(i);
        }
        ArrayList<Integer> res = Node.heap_sort(num);
        for(int i: res){
            System.out.print(i + " ");
        }
    }
}
