import java.util.*;
public class entry_11177628 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        ArrayList<Integer> list=new ArrayList<Integer>();
        input.nextLine();
        String arrele = input.nextLine();
        String[] elements = arrele.split(" ");
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(elements[i]));
        }
        Collections.sort(list);
        int count=1;
        for(int i=0;i<n-1;i++){
            if(!list.get(i).equals(list.get(i+1))){
                count++;
            }

        }
        System.out.println(count);

    }




}