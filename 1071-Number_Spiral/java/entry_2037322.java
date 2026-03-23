import java.util.*;
import java.io.*;

class Solution
{
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args)
    {
        //Scanner inp = new Scanner(System.in);
        FastReader inp = new FastReader();
        int t = inp.nextInt();

        for(int i=0; i<t;i++)
        {
            long r = inp.nextLong();
            long c = inp.nextLong();

            if(r>c)
            {
                if(r%2==0)
                {
                    System.out.println(r*r -c+1);
                    continue;
                }
                else
                {
                    System.out.println((r-1)*(r-1)+c);
                    continue;
                }
            }
            else if(c>r)
            {
                if(c%2!=0)
                {
                    System.out.println(c*c -r+1);
                    continue;
                }
                else
                {
                    System.out.println((c-1)*(c-1) + r);
                    continue;
                }
            }
            else
            {
                System.out.println(r*r - r +1);
            }
        }

    }
}