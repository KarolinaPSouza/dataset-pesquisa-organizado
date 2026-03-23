import java.util.*;
import java.io.*;
public class entry_8468039 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        List<Integer> apartmentSizes = new ArrayList();
        List<Integer> availableSizes = new ArrayList();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            apartmentSizes.add(Integer.valueOf(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            availableSizes.add(Integer.valueOf(st.nextToken()));

        int count = 0;

        Collections.sort(availableSizes); 
        Collections.sort(apartmentSizes);
        int i = 0;
        int j = 0;
        while(i<availableSizes.size() && j<apartmentSizes.size()){
            int a = availableSizes.get(i);
            int b = apartmentSizes.get(j);
            if(Math.abs(a-b)<=k){
                count++;
                i++;
                j++;
            }
            else if(a<b)
                i++;
            else
                j++;
        }

        System.out.println(count);   
    }
}