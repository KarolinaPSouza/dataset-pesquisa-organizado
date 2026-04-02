import java.util.*;

public class entry_5837578 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();
  int t =sc.nextInt();
  int [] nums = new int [n];
  for(int i=0;i<n;i++) {
   nums[i]=sc.nextInt();
  }
  boolean works = true;
  HashMap<Integer, ArrayList<Pair>> map=new HashMap<Integer, ArrayList<Pair>>();
  for(int i =0;i<n&&works;i++) {
   for(int j=i+1;j<n&&works;j++) {
    ArrayList<Pair>a = new ArrayList<Pair>();
    a = map.getOrDefault((nums[j]+nums[i]), new ArrayList<Pair>());
    a.add(new Pair(i,j));
    map.put(nums[j]+nums[i], a);
    if(map.containsKey(t-(nums[j]+nums[i]))) {
     for(Pair k :map.get(t-(nums[j]+nums[i]))) {
      if(k.a!=i&&k.a!=j&&k.b!=i&&k.b!=j&&works) {
       System.out.println(k.a+1+" "+(k.b+1)+" "+(i+1)+" "+(j+1));
       works = false;
      }
     }
    }

   }
  }
  if(works)System.out.println("IMPOSSIBLE");

 }
 static class Pair{
    int a,b;
    public Pair(int c,int d) {
     a=c;
     b=d;
    }
   }

}