import java.util.*;
public class entry_2235086 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        int arr[][]=new int[n][m];

        for(int i=0;i<n;i++)
        {
        String s=sc.next();
        for(int j=0;j<m;j++)
        {
        char ch=s.charAt(j);
        if(ch=='#')
        arr[i][j]=1;
        else
        arr[i][j]=0;
        }
        } 

        int ans=0;

        for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        if(arr[i][j]==0)
        {
        DFS(arr, i, j);
        ans+=1;
        }

        System.out.println(ans);


    }
    public static void DFS(int[][] arr,int i,int j)
    {
        if(i<0||i>=arr.length||j<0||j>=arr[0].length||arr[i][j]==1)
        return;
        arr[i][j]=1;
        DFS(arr,i+1,j);
        DFS(arr,i-1,j);
        DFS(arr,i,j+1);
        DFS(arr,i,j-1);
    }

}