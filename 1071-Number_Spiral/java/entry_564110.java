/*
    Author: @__goku__
            ssrivastava990@gmail.com
                    `\-.   `
                      \ `.  `
                       \  \ |
              __.._    |   \.       S O N - G O K U
       ..---~~     ~ . |    Y
         ~-.          `|    |
            `.               `~~--.
              \                    ~.
               \                     \__. . -- -  .
         .-~~~~~      ,    ,            ~~~~~~---...._
      .-~___        ,'/  ,'/ ,'\          __...---~~~
            ~-.    /._\_( ,(/_. 7,-.    ~~---...__
           _...>-  P""6=`_/"6"~   6)    ___...--~~~
            ~~--._ \`--') `---'   9'  _..--~~~
                  ~\ ~~/_  ~~~   /`-.--~~
                    `.  ---    .'   \_
                      `. " _.-'     | ~-.,-------._
                  ..._../~~   ./       .-'    .-~~~-.
            ,--~~~ ,'...\` _./.----~~.'/    /'       `-
        _.-(      |\    `/~ _____..-' /    /      _.-~~`.
       /   |     /. ^---~~~~       ' /    /     ,'  ~.   \
      (    /    (  .           _ ' /'    /    ,/      \   )
      (`. |     `\   - - - - ~   /'      (   /         .  |
       \.\|       \            /'        \  |`.           /
       /.'\\      `\         /'           ~-\         .  /\
      /,   (        `\     /'                `.___..-      \
     | |    \         `\_/'                  //      \.     |
     | |     |                 _Seal_      /' |       |     |
 */

import java.io.*;
import java.util.*;

public class entry_564110 {
    static PrintWriter out = new PrintWriter((System.out));

    public static void main(String args[]) throws IOException
    {
        Kioken sc = new Kioken();
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            kamehameha(y,x);
        }
        out.close();
    }

    public static void kamehameha(int x,int y)
    {
        long a,b;
        if(x%2!=0)
        {
            a=(long)x*x;
        }
        else
        {
            a=(long)(x-1)*(x-1)+1;
        }
        if(y%2==0)
        {
            b=(long)y*y;
        }
        else
        {
            b=(long)(y-1)*(y-1)+1;
        }
        if(x==y)
        {
            out.println((a + b) / 2);
        }
        else
        {
            if(x<y)
            {
                if(y%2==0)
                {
                    b -= (long)x - 1;
                }
                else
                {
                    b+=(long)x-1;
                }
                out.println(b);
            }
            else
            {
                if(x%2==0)
                {
                    a+=(long)y-1;
                }
                else
                {
                    a -= (long)y - 1;
                }
                out.println(a);
            }
        }
    }

    static class Kioken
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next()
        {
            while (!st.hasMoreTokens())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt(next());
        }

        public long nextLong()
        {
            return Long.parseLong(next());
        }

        public double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public String nextLine()
        {
            try
            {
                return br.readLine();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }

        public boolean hasNext()
        {
            String next = null;
            try
            {
                next = br.readLine();
            } catch (Exception e)
            {
            }
            if (next == null)
            {
                return false;
            }
            st = new StringTokenizer(next);
            return true;
        }
    }
}