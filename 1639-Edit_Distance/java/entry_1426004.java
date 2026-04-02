import java.util.Scanner;

public class entry_1426004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1= sc.next();
        String s2= sc.next();
        int m = s1.length();
        int n = s2.length();
        char x[]=s1.toCharArray();
        char y[]=s2.toCharArray();
        System.out.println(solve(x,y,m,n));
    }
    static int solve( char[] x , char[] y , int m , int n )
    {
        int L[][] = new int[m+1][n+1];
        if( m == 0 )
            return n ;
        if( n == 0 )
            return m ;
        for(int i=0 ; i<=m ; i++)
        {
            for(int j = 0 ; j <= n ; j++)
            {
if(i==0)
    L[i][j]=j;
else if(j==0)
    L[i][j]=i;
else if(x[i-1]==y[j-1])
    L[i][j]=L[i-1][j-1];
else
L[i][j]=1+min(L[i][j-1],L[i-1][j],L[i-1][j-1]);
            }
        }
        return L[m][n];
    }
    static int min( int a , int b , int c )
    {
        if( a<=b && a<=c )
        {
            return a ;
        }
        else if( b<= a && b<=c )
            return b ;
        return c;
    }
}