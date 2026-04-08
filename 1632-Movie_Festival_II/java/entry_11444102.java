import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class entry_11444102 {
    public static void main(String[] args) {
   FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int testcases = 1;
        //testcases = fs.nextInt();

        for(int testcase = 1; testcase <= testcases; testcase++) {
            new Solution(fs, out).solve(testcase);
        }

        out.close();
    }
}

class TreeMultiSet<T> {
 TreeMap<T, Integer> countMap;
    int count = 0;
 TreeMultiSet() {
  countMap = new TreeMap<>();
 }

 boolean contains(T t) {
  return countMap.containsKey(t);
 }

 void add(T t) {
  countMap.compute(t, (key, value) -> value == null? 1: value + 1);
        count = count + 1;
 }

    T first() {
  return countMap.firstKey();
 }

 T last() {
  return countMap.lastKey();
 }

 boolean remove(T t) {
  class Value {
            private int value = 0;

            void setValue(int value) {
                this.value = value;
            } 

            int getValue() {
                return value;
            }
        }

        Value value = new Value();
  countMap.compute(t, (k, v) -> {
     if(v != null) {
                        value.setValue(v);
                        return v > 1? v - 1: null;
     }
                    return null;
    });

  if(value.getValue() > 0) {
            count = count - 1;
   return true;
  } else {
   return false;
  }
 }

 boolean isEmpty() {
  return count == 0;
 }

 int size() {
  return count;
 }

 void clear() {
  countMap.clear();
 }

 T max() {
  return countMap.lastKey();
 }
}
class Solution { 

    public final int mod = 1000000007;

    void solve(int testCaseNumber) {
        //Let the magic happen
  int n = fs.nextInt();
  int k = fs.nextInt();

  List<Pair<Integer, Integer>> movieTimes = new ArrayList<>();

  for(int i = 0; i < n; ++i) {
   int a = fs.nextInt();
   int b = fs.nextInt();

   movieTimes.add(Pair.of(a, b));
  }

  Collections.sort(movieTimes, (movieTime1, movieTime2) -> {
    if(movieTime1.first().equals(movieTime2.first())) {
     return movieTime1.second().compareTo(movieTime2.second());
    }
    return movieTime1.first().compareTo(movieTime2.first());
   });

  int ans = 0;
  TreeMultiSet<Integer> endTimes = new TreeMultiSet<Integer>();

  for(int i = 0; i < n; ++i) {
   if(k > 0) {
    k--;
    ans++;
    endTimes.add(movieTimes.get(i).second()); 
   } else {
    if(movieTimes.get(i).first() >= endTimes.first()) {
     endTimes.add(movieTimes.get(i).second());
     endTimes.remove(endTimes.first());
     ans++;
    } else {
     int movieEndTime = movieTimes.get(i).second();

     if(endTimes.last() > movieEndTime) {
      endTimes.remove(endTimes.last());
      endTimes.add(movieEndTime);
     }
    }
   }
  }

  out.print(ans);
    }

    Solution(FastScanner fs, PrintWriter out) {
        this.fs = fs;
        this.out = out;
    }
    private final FastScanner fs;
    private final PrintWriter out;
}

class Pair<U,V> {
    private U first;
    private V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
    U first() {
        return this.first;
    }
    V second() {
        return this.second;
    }
    static <S,T> Pair<S,T> of(S s, T t) {
        return new Pair<S,T>(s, t);
    }
 @Override
 public String toString() {
  return "{\n" + 
    "\tfirst: " + first.toString() + ",\n" +
       "\tsecond: " + second.toString() + "\n" + 
    "}"; 
 }
}

class FastScanner {
   final private int BUFFER_SIZE = 1 << 16;
   private DataInputStream din;
   private byte[] buffer;
   private int bufferPointer, bytesRead;

   public FastScanner() {
       din = new DataInputStream(System.in);
       buffer = new byte[BUFFER_SIZE];
       bufferPointer = bytesRead = 0;
   }

   public String next() {
       byte[] buf = new byte[64]; // line length
       int cnt = 0, c;
       while ((c = read()) != -1) {
           if (c == '\n') {
               if (cnt != 0) {
                   break;
               }
               else {
                   continue;
               }
           }
           buf[cnt++] = (byte)c;
       }
       return new String(buf, 0, cnt);
   }

   public int nextInt() {
       int ret = 0;
       byte c = read();
       while (c <= ' ') {
           c = read();
       }
       boolean neg = (c == '-');
       if (neg)
           c = read();
       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');

       if (neg)
           return -ret;
       return ret;
   }

   public int[] nextIntArray(int n) {
    int arr[] = new int[n];
    for(int i = 0; i < n; ++i) {
     arr[i] = nextInt();
    }
    return arr;
   }

   public long nextLong() {
       long ret = 0;
       byte c = read();
       while (c <= ' ')
           c = read();
       boolean neg = (c == '-');
       if (neg)
           c = read();
       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');
       if (neg)
           return -ret;
       return ret;
   }

   public double nextDouble() {
       double ret = 0, div = 1;
       byte c = read();
       while (c <= ' ')
           c = read();
       boolean neg = (c == '-');
       if (neg)
           c = read();

       do {
           ret = ret * 10 + c - '0';
       } while ((c = read()) >= '0' && c <= '9');

       if (c == '.') {
           while ((c = read()) >= '0' && c <= '9') {
               ret += (c - '0') / (div *= 10);
           }
       }

       if (neg)
           return -ret;
       return ret;
   }

   private byte read() {
       if (bufferPointer == bytesRead)
           fillBuffer();
       return buffer[bufferPointer++];
   }

   private void fillBuffer() {
       try {
           bytesRead = din.read(buffer, bufferPointer = 0,
                               BUFFER_SIZE);
           if (bytesRead == -1)
               buffer[0] = -1;
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
   }

   public void close() {
       if (din == null)
           return;
       try {
        din.close();
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
   }
}

class Mutable<T> {
    private T t;

    Mutable() {
        this.t = null;
    }

    Mutable(T t) {
        this.t = t;
    }

    T get() {
        return t;
    }

    void set(T t) {
        this.t = t;
    } 

    public String toString() {
        return t == null? "null": t.toString();
    }
}

class Helper {
    static final Random random = new Random();
    static final int mod = 1_000_000_007;

    static void ruffleSort(int[] a) {
        int n = a.length;// shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0)
            return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0)
            return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }
}
