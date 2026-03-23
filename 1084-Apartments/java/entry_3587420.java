import java.io.*;
import java.util.*;

public class entry_3587420 {
    public static void main(String[] args){
        FastScanner s = new FastScanner(System.in);
        int applicants = s.nextInt();
        int totalApartments = s.nextInt();
        int maxDiff = s.nextInt();

        ArrayList<Integer> desiredApts = new ArrayList<>();
        ArrayList<Integer> apartments = new ArrayList<>();

        for(int i = 0; i < applicants; i++){
            int aptSize = s.nextInt();
            desiredApts.add(aptSize);
        }

        for(int i = 0; i < totalApartments; i++){
            int aptSize = s.nextInt();
            apartments.add(aptSize);
        }

        Collections.sort(desiredApts);
        Collections.sort(apartments);

        System.out.println(findApartments(desiredApts, apartments, maxDiff));
    }

    public static int findApartments(ArrayList<Integer> desiredApts, ArrayList<Integer> apartments, int maxDiff){

        int matches = 0;
        int desiredIndex = 0;
        int aptIndex = 0;
        while(desiredIndex < desiredApts.size() && aptIndex < apartments.size()){

            int desiredSize = desiredApts.get(desiredIndex);
            int size = apartments.get(aptIndex);

            if(desiredSize + maxDiff >= size && desiredSize - maxDiff <= size){
                matches++;
                desiredIndex++;
                aptIndex++;
            }
            else if(desiredSize + maxDiff < size){
                desiredIndex++;
            }
            else{
                aptIndex++;
            }
        }
        return matches;
    }
}

class FastScanner{
    private InputStream stream;                                                                                         
    private byte[] buf = new byte[1024];                                                                                
    private int curChar;                                                                                                
    private int numChars;                                                                                               

    public FastScanner(InputStream stream)
    {
       this.stream = stream;                                                                                            
    }

    int read()
    {
       if (numChars == -1)
          throw new InputMismatchException();                                                                           
       if (curChar >= numChars){
          curChar = 0;                                                                                                  
          try{
             numChars = stream.read(buf);                                                                               
          } catch (IOException e) {
             throw new InputMismatchException();                                                                        
          }
          if (numChars <= 0)
             return -1;                                                                                                 
       }
       return buf[curChar++];                                                                                           
    }

    boolean isSpaceChar(int c)
    {
       return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;                                                                 
    }

    boolean isEndline(int c)
    {
       return c=='\n'||c=='\r'||c==-1;                                                                                  
    }

    int nextInt()
    {
       return Integer.parseInt(next());                                                                                 
    }

    long nextLong()
    {
       return Long.parseLong(next());                                                                                   
    }

    double nextDouble()
    {
       return Double.parseDouble(next());                                                                               
    }

    String next(){
       int c = read();                                                                                                  
       while (isSpaceChar(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                             
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isSpaceChar(c));                                                                                         
       return res.toString();                                                                                           
    }

    String nextLine(){
       int c = read();                                                                                                  
       while (isEndline(c))
          c = read();                                                                                                   
       StringBuilder res = new StringBuilder();                                                                         
       do{
          res.appendCodePoint(c);                                                                                       
          c = read();                                                                                                   
       }while(!isEndline(c));                                                                                           
       return res.toString();                                                                                           
    }

}