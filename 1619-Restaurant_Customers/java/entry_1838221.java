import java.util.*;
import java.io.*;

public class entry_1838221 {
 public static void main(String[] args) throws IOException{
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st=new StringTokenizer(br.readLine());
  int n=Integer.parseInt(st.nextToken());

  TreeMap<Integer,Integer> custMap=new TreeMap<>();
  int start=0;
  int end=0;

  while(n!=0){
      st=new StringTokenizer(br.readLine());
      start=Integer.parseInt(st.nextToken());
      end=Integer.parseInt(st.nextToken());

      custMap.put(start,1);
      custMap.put(end,-1);
      n--;
  }

  int maxCust=0;
  int currCust=0;
  for(Map.Entry<Integer, Integer> time:custMap.entrySet()){
      currCust+=time.getValue();
      maxCust=Math.max(maxCust,currCust);
  }
  System.out.println(maxCust);
 }
}