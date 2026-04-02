import java.io.*;
import java.util.*;

public class entry_9478771 {
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int target = Integer.parseInt(st1.nextToken());
            StringTokenizer str = new StringTokenizer(br.readLine());
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0] = Integer.parseInt(str.nextToken());
                arr[i][1] = i;
            }
            Arrays.sort(arr,Comparator.comparingDouble(o ->o[0]));


            boolean found = false;
            for(int a = 0;a<n-3;a++){
                if(found) break;
                for(int b=a+1;b<n-2;b++){
                    int itr1 = b+1;
                    int itr2 = n-1;
                    if(found) break;
                    while(itr1<itr2){
                        int sum = arr[a][0]+arr[b][0]+arr[itr1][0]+arr[itr2][0];
                        if(sum == target){
                            found = true;
                            System.out.println((arr[a][1]+1) + " " + (arr[itr2][1]+1) + " "+ (arr[itr1][1]+1) + " " + (arr[b][1]+1 ));
                            break;
                        }
                        else if(sum>target){
                            itr2--;
                        }
                        else{
                            itr1++;
                        }
                    }
                }
            }
            if(!found){
                System.out.println("IMPOSSIBLE");
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}