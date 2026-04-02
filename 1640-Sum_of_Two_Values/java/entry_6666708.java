import java.util.*;
public class entry_6666708 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner sc = new Scanner(System.in);
  int n=sc.nextInt();
  int sum=sc.nextInt();
  int arr[]=new int[n];
  for(int i=0;i<n;i++) {
   arr[i]=sc.nextInt();
  }
  HashMap<Integer,Integer> map = new HashMap<>();
  int flag=-1;
  for(int i=0;i<n;i++) {
   if(map.containsKey(sum-arr[i])) {
    System.out.println((map.get(sum-arr[i])+1)+" "+(i+1));
    flag=0;
    break;
   }
   else {
    map.put(arr[i], i);
   }
  }
  if(flag==-1) {
   System.out.println("IMPOSSIBLE");
  }

 }

}