import java.util.*;
public class entry_11196559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int targetSum = sc.nextInt();

        int arr[] = new int[n];
        int help[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            help[i] =arr[i];
        } 
        Arrays.sort(arr);
        int flag = 0;
        int a =-1,b=-1,c=-1,d=-1;
        for(int i=0;i<n-2;i++){
            for(int m=i+1;m<n-1;m++){
                int j=m+1;
                int k=n-1;
                while(j<k){
                    if(arr[m]+arr[i]+arr[j]+arr[k]==targetSum){
                        a=arr[i];b=arr[j];c=arr[k];d=arr[m];
                        flag = 1;
                        break;
                    }
                    else if(arr[i]+arr[m]+arr[j]+arr[k]>targetSum) k--;
                    else j++;
                }
                    if(flag==1) break;
                }
                if(flag==1) break;
        }
        if(flag==0){
            System.out.println("IMPOSSIBLE");
            return;
        }
        for(int i=0;i<n;i++){
            if(a==help[i]){
                System.out.print(i+1+" ");
                a=-1;
            } 
            else if(d==help[i]){
                System.out.print(i+1+" ");
                d=-1;
            }
            else if(b==help[i]){
                System.out.print(i+1+" ");
                b=-1;
            }
            else if(c==help[i]){
                System.out.print(i+1+" ");
                c=-1;
            }
            if(a==-1 && b==-1 && c==-1 && d==-1) break;
        }

        return;
    }

}