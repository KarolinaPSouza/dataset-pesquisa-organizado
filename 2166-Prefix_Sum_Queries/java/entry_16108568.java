import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

class FastReader {
    private InputStream is = System.in;
    private byte[] inbuf = new byte[1 << 16]; // 64KB Buffer
    private int lenbuf = 0, ptrbuf = 0;

    private int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    private int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    public String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public int nextInt() {
        int c = skip();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = skip();
        long sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = readByte();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = readByte();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}

class ST{
    long tsum[];
    long tmaxpref[];
    public ST(int n){
        tsum=new long[4*n];
        tmaxpref=new long[4*n];
    }
    public void build(long arr[],int idx,int i,int j){
        if(i==j){
            tsum[idx]=arr[i];
            tmaxpref[idx]=Math.max(0,arr[i]);
            return;
        }
        int mid=i+(j-i)/2;
        build(arr,2*idx,i,mid);
        build(arr,2*idx+1,mid+1,j);
        tsum[idx]=tsum[2*idx]+tsum[2*idx+1];
        tmaxpref[idx]=Math.max(tmaxpref[2*idx],tsum[2*idx]+tmaxpref[2*idx+1]);
    }
    public void update(int idx,int i,int j,int k,long val){
        if(k<i || k>j) return;
        if(i==j){
            tsum[idx]=val;
            tmaxpref[idx]=Math.max(0,val);
            return;
        }
        int mid=i+(j-i)/2;
        update(2*idx,i,mid,k,val);
        update(2*idx+1,mid+1,j,k,val);
        tsum[idx]=tsum[2*idx]+tsum[2*idx+1];
        tmaxpref[idx]=Math.max(tmaxpref[2*idx],tsum[2*idx]+tmaxpref[2*idx+1]);
    }
    public long[] query(int idx,int i,int j,int l,int r){
        if(r<i || l>j) return new long[2];
        if(l<=i && j<=r) return new long[]{tsum[idx],tmaxpref[idx]};
        int mid=i+(j-i)/2;
        long left[]=query(2*idx,i,mid,l,r);
        long right[]=query(2*idx+1,mid+1,j,l,r);
        long ret[]=new long[2];
        ret[0]=left[0]+right[0];
        ret[1]=Math.max(left[1],left[0]+right[1]);
        return ret;  
    }
}
public class entry_16108568 {
    public static void main(String[] args){
        FastReader ip=new FastReader();
        StringBuilder op=new StringBuilder();
        int n=ip.nextInt();
        int q=ip.nextInt();
        long arr[]=new long[n+1];
        for(int i=1;i<=n;i++) arr[i]=ip.nextLong();

        ST st=new ST(n);
        st.build(arr,1,1,n);

        while(q-->0){
            int opr=ip.nextInt();
            if(opr==1){
                int k=ip.nextInt();
                long val=ip.nextLong();
                st.update(1,1,n,k,val);
            }
            else{
                int l=ip.nextInt(),r=ip.nextInt();
                op.append(st.query(1,1,n,l,r)[1]).append("\n");
            }
        }
        System.out.println(op);
    }
}