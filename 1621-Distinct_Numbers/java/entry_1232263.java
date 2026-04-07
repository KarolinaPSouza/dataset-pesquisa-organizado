import java.util.*;
class DistinctNumbers
// Status: Passed
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Set<Integer> x=new HashSet<Integer>();

        for(int i=0;i<n;i++)
        {
            x.add(sc.nextInt());
        }

        System.out.println(x.size());
        sc.close();
    }
}