import java.util.*;
public class entry_2271485{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int target=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int ans[]=solve(a,n,target);
        if(ans[0]==-1) System.out.println("IMPOSSIBLE");
        else
            System.out.println((ans[0]+1)+" "+(ans[1]+1));
    }
    public static int[] solve(int a[],int n,int target)
    {
        int left=0,right=n-1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int t=target-a[i];
            if(map.containsKey(t) && map.get(t)!=i) return new int[]{map.get(t),i};
            else map.put(a[i],i);
        }
        return new int[]{-1};
    }
}
