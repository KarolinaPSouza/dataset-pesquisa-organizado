import java.util.HashMap;
import java.util.Scanner;

public class entry_7333409 {
    public static void main(String[] args){
        Scanner keyboard=new Scanner(System.in);
        int length=keyboard.nextInt();
        int target=keyboard.nextInt();
        keyboard.nextLine();
        String[] arr=keyboard.nextLine().split(" ");
        boolean found=false;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int x=0;x<arr.length;x++){
            int number=Integer.parseInt(arr[x]);
            if (map.containsKey(target-number)){
                System.out.println(""+(map.get(target-number)+1)+" "+(x+1));
                found=true;
                break;
            }
            map.put(number,x);
        }
        if(!found){
            System.out.println("IMPOSSIBLE");
        }
    }
}