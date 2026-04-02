import java.util.Scanner;
public class entry_5798390 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner obj =new Scanner(System.in);
  int n=Integer.parseInt(obj.nextLine());
  String inputArray[]=obj.nextLine().split(" ");

  long arr[]=new long[n];
  for(int i=0;i<n;i++)
   arr[i]=Integer.parseInt(inputArray[i]);
  obj.close();

  long currMax=arr[0],finalMax=arr[0],sum[]=arr,pos=0;
  for(int i=1;i<n;i++)
  {
   if(sum[i-1]<0 && i==1)
    {currMax=sum[i];
    if(currMax>finalMax)
     finalMax=currMax;
    continue;}

    sum[i]+=sum[i-1];
  if(sum[i]<0 && finalMax>0)
   {sum[i]=0;
   continue;}
  currMax=sum[i];
  if(currMax>finalMax)
   finalMax=currMax;
  pos=i;
  }

  System.out.println(finalMax);



 }

}