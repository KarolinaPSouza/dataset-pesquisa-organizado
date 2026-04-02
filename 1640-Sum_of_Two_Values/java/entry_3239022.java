import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_3239022 {
    public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    boolean found = false; int pos1 = 0, pos2 = 0;

    String[] line = in.readLine().split(" ");
    int N  = Integer.parseInt(line[0]), x = Integer.parseInt(line[1]);
    ArrayList <Integer> arr = new ArrayList<>(), temp;


    line = in.readLine().split(" ");
    for(int i = 0; i < line.length; i++){
        int a = Integer.parseInt(line[i]);
        arr.add(a);
    }

    temp = new ArrayList<>(arr);

    Collections.sort(arr);
    int lastNum = 0, loc;

    for (int i = 0; i < arr.size(); i++) {
        int val = arr.get(i);
        if(x > val){
        if(lastNum != val){
            loc = Collections.binarySearch(arr, (x - val));
            if(loc >= 0){
                pos1 = arr.indexOf(val); pos2 = arr.lastIndexOf(x-val);
                if(pos1 != pos2){
                pos1 = val; pos2 = arr.get(loc);
                found = true;
                break;
                }
            }

        }
        lastNum = val;
    }else{break;}
    }

    if(found){
        System.out.println((temp.indexOf(pos1)+1) + " " + (temp.lastIndexOf(pos2)+1));
    }else{
        System.out.println("IMPOSSIBLE");
    }

    }
}

