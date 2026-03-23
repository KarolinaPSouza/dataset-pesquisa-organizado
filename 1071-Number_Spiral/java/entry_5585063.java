/******************************************************************************
 Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.
 *******************************************************************************/
import java.util.*;
public class entry_5585063 {
 public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    long t = sc.nextLong();
    StringBuilder sb = new StringBuilder("");
    while(t>0){

    long r = sc.nextLong(),c = sc.nextLong();
    long maxm = Math.max(r,c);

    long low = (maxm-1)*(maxm-1) + 1;
    long ans=-1;
    if((maxm&1)>0)
    {
        //from left
        long mid = low+maxm-1;
        if(r<maxm)
        {
            long diff = maxm-r;
            ans = mid+diff;
        }
        else
        {
            ans = low+c-1;
        }

    }
    else
    {
         long mid = low+maxm-1;
        if(r<maxm)
        {
            ans = low+r-1;
        }
        else
        {
            long diff = maxm-c;
            ans = mid+diff;
        }
        //from up
    }
    sb.append(ans+"\n");
    t--;
    }
    System.out.println(sb);

 }
}