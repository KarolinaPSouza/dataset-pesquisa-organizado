//package CSES;

import java.util.Scanner;

public class entry_7380457 {
//    public static class Reader {
//        final private int BUFFER_SIZE = 1 << 16;
//        private DataInputStream din;
//        private byte[] buffer;
//        private int bufferPointer, bytesRead;
//
//
//        public Reader() {
//            din = new DataInputStream(System.in);
//            buffer = new byte[BUFFER_SIZE];
//            bufferPointer = bytesRead = 0;
//        }
//
//        private void fillBuffer() throws IOException {
//            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
//            if (bytesRead == -1)
//                buffer[0] = -1;
//        }
//
//        private byte read() throws IOException {
//            if (bufferPointer == bytesRead)
//                fillBuffer();
//            return buffer[bufferPointer++];
//        }
//
//        public void close() throws IOException {
//            if (din == null)
//                return;
//            din.close();
//        }
//
//        public int nextInt() throws IOException {
//            int ret = 0;
//            byte c = read();
//            while (c <= ' ')
//                c = read();
//            boolean neg = (c == '-');
//            if (neg)
//                c = read();
//            do {
//                ret = ret * 10 + c - '0';
//            } while ((c = read()) >= '0' && c <= '9');
//
//            if (neg)
//                return -ret;
//            return ret;
//        }
//
//
//    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int k= sc.nextInt();
        long[] arr=new long[k];
        for(int i=0;i<k;i++){
            arr[i]= sc.nextLong();
        }
        long sum=0;
        for(int i=0;i<(1<<k);i++){
            long fact=1;
            long count=0;
            for(int j=0;j<k;j++){
                if(((1<<j) & i) !=0){

                    if(fact>n/arr[j]){
                        fact=n+1;
                        break;
                    }
                    fact*=arr[j];
                    count++;
                }
            }
            if(fact<=n){
                if ((count & 1)==1) {
                    //System.out.println(fact + " om ");
                    sum += n / fact;
                } else if (count != 0) {
                    //System.out.println(fact);
                    sum -= n / fact;
                }
            }
        }
        System.out.println(sum);
    }
}