import java.util.*;

public class entry_3333533 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        scan.nextLine();
        ArrayList<Integer> storage = new ArrayList<>();
        for(int i = 0; i < n; i++){
            storage.add(scan.nextInt());
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int l = 0;
        boolean found = false;
        while(i < n){
            if(map.containsKey(x - storage.get(i))){
                l = map.get(x- storage.get(i));
                i ++;
                found = true;
                break;
            }else{
                map.put(storage.get(i), i+1);
                i++;
            }
        }
        if(found) {
            System.out.println(l + " " + i);
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}