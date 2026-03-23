import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class entry_3462932 {
    static class in {
        static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer tokenizer = new StringTokenizer("");

        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            //System.out.println(" I WAS CALLED");
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        static String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
private static ArrayList<String> func(int n)
{
    ArrayList<String> ret= new ArrayList<>();
    if(n==1)
    {
        ret.add("0");
        ret.add("1");
        return ret;
    }
    ArrayList<String> rret=func(n-1);
    for(String i:rret)
    {
        ret.add("0"+i);
    }
    for(int i=rret.size()-1;i>=0;i--)
    {
        ret.add("1"+rret.get(i));
    }
    return ret;
}
static ArrayList<String> arr= new ArrayList<>();
private  static  void move(int n, int start,int ind, int dest)
{
    if(n==1)
    {
        arr.add(start+" "+dest);
        return;
    }
    move(n-1,start,dest,ind);
    arr.add(start+" "+dest);
    move(n-1,ind,start,dest);
}

private static HashSet <String>perm(String s)
{
    HashSet<String> set= new HashSet<>();
    if(s.length()==2)
    {
        set.add(s);
        set.add((s.charAt(1)+""+s.charAt(0)));
        return set;
    }
    for(int i=0;i<s.length();i++)
    {
        char a=s.charAt(i);
        HashSet<String> prv= perm(s.substring(0,i)+s.substring(i+1,s.length()));
        for(String curr:prv)set.add(a+curr);
    }
    return set;
}
static int ways=0;

private  static void  merge(int l, int mid , int h, int arr[] )
    {
        int n2= h-mid;
        int n1= mid-l+1;
        int left[]= new int [n1];
         int right[]= new int [n2];
         for(int i=0;i<n1;i++)left[i]=arr[l+i];
         for(int i=0;i<n2;i++)right[i]=arr[mid+1+i];
         int i=0,j=0,k=l;
         while(i<n1&& j<n2)
         {
             if(left[i]<right[j])
             {
                 arr[k]=left[i];
                 i++;
                 k++;
             }
             else
             {
                 arr[k]=right[j];
                 j++;k++;
             }
         }
         while(i<n1)
         {
             arr[k]=left[i]
                     ;
             i++;
             k++;
         }

        while(j<n2)
        {
            arr[k]=right[j];
            j++;
            k++;
        }

    }
private static  void mergesort(int l, int h, int []arr)
    {
        if(l<h)
        {
            int mid=l+(h-l)/2;
            mergesort(l,mid,arr);
            mergesort(mid+1,h,arr);
            merge(l,mid,h,arr);
            return;
        }
    }


    public static void main(String[] args) throws IOException {

        int n=in.nextInt();
        int m= in.nextInt();
        int k= in.nextInt();
        int houses[]= new  int [n];
        int house_size[]= new int [m];
        for(int i=0;i<n;i++)houses[i]=in.nextInt();
        for(int i=0;i<m;i++)house_size[i]=in.nextInt();
        mergesort(0,n-1,houses);
        //System.out.println(Arrays.toString(houses));
        mergesort(0,m-1,house_size);
         int i=0,j=0;
          int count=0;
         while(i<n&& j<m)
         {
             if(Math.abs(houses[i]-house_size[j])<=k)
             {
                 count++;
                  j++;
                  i++;
                  continue;
             }
             if(houses[i]<house_size[j])i++;
             else j++;
         }
        System.out.println(count);


    }
}

