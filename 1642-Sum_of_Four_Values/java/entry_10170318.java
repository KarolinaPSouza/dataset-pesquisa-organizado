import java.util.*;
public class entry_10170318 {
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int x=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        List<Integer> ans=new ArrayList<>();
        List<Integer> xyz=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            for(int m=i+1;m<n-2;m++){
                 int j=m+1;
                  int k=n-1;
                   int sum=0;
            while(j<k){
                sum=temp[i]+temp[m]+temp[j]+temp[k];
                if(sum==x){
                    ans.add(temp[i]);
                    ans.add(temp[m]);
                    ans.add(temp[j]);
                    ans.add(temp[k]);
                    break;
                }else if(sum>x){
                    k--;
                }else{
                    j++;
                }
            }
            if(ans.size()!=0){
                break;
            }
        }
        if(ans.size()!=0){
            break;
        }
    }
        if(ans.size()==0){
            System.out.println("IMPOSSIBLE");
        }else{
            int j=0;
            while(j<ans.size()){
               for(int i=0;i<n;i++){
                    if(ans.get(j)==arr[i]){
                     xyz.add(i+1);
                     arr[i]=-1;
                     break;
                }
             }
             j++;
           }
           for(int i=0;i<xyz.size();i++){
            System.out.print(xyz.get(i)+" ");
           }
        }
    }
}