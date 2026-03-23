import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class entry_1377542 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        long k = Long.parseLong(strArr[2]);
        strArr = br.readLine().split(" ");
        Long[] applicantsDemand = new Long[n];
        ArrayList<Long>applicant = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            applicant.add(Long.parseLong(strArr[i]));
        }
        strArr = br.readLine().split(" ");
        Long[] availableSpace = new Long[m];
        ArrayList<Long>available = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            available.add(Long.parseLong(strArr[i]));
        }
        //Arrays.sort(applicantsDemand);
        //Arrays.sort(availableSpace);
        Collections.sort(applicant);
        Collections.sort(available);
        applicantsDemand = applicant.toArray(new Long[applicant.size()]);
        availableSpace = available.toArray(new Long[available.size()]);
        //applicantsDemand = (Long[]) applicant.toArray();
        //availableSpace = (Long[])available.toArray();
        int start = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long req = applicantsDemand[i]-k;
            int index = findFirstOccurance(availableSpace,req,start,availableSpace.length-1);
            //System.out.println(req+" "+index);
            if(index >= availableSpace.length){
                break;
            }
            if(availableSpace[index] <= applicantsDemand[i]+k){
                availableSpace[index] = 0l;
                start = index+1;
                count++;
            }


        }
        bw.write(count+"");
        bw.flush();
    }
    private static int findFirstOccurance(Long[]arr,long i,int start,int end) {
        int finalIndex = 0;
        boolean isPresent = false;
        while(start <= end){

            int middle = start+((end-start) / 2);
            if(arr[middle] == i){
                isPresent = true;
                if(middle-1 >= 0 && arr[middle-1] == i){
                    end = middle-1;
                    finalIndex = middle;
                }
                else{
                    finalIndex = middle;
                    break;
                }
            }
            else if(arr[middle] > i){
                end = middle - 1;
            }
            else if(arr[middle] < i){
                start = middle + 1;
            }

        }
        if(!isPresent){
            return start;
        }
        return finalIndex;
    }
}