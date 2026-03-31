import java.util.*;
import java.io.*;

public class entry_12731612 {

static class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }
}


    public static void main(String args[]) throws IOException{
        Reader br = new Reader();
        int n = br.nextInt();
        List<int[]> events = new ArrayList<>();

        for(int i = 0; i<n; i++){
            int a = br.nextInt();
            int b = br.nextInt();
            events.add(new int[]{a, 1});
            events.add(new int[]{b,-1});

        }
        Comparator<int[]> eventComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2){
                if (e1[0] !=e2[0]){
                    return Integer.compare(e1[0], e2[0]);

                } else {
                    return Integer.compare(e1[1], e2[2]);
                }


            }

        };
        Collections.sort(events, eventComparator);

        int current =0; 
        int max=0;
        for(int[] event: events){
            current+=event[1];
            max=Math.max(current, max);
        }
        System.out.println(max);


    }
}