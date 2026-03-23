import java.io.*;
import java.util.*;

public class entry_9152588 {
  void solve(FastIO io) {
    int n = io.nextInt(), m = io.nextInt();
    var tickets = new TreeMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int ticket = io.nextInt();
      tickets.put(ticket, tickets.getOrDefault(ticket, 0) + 1);
    }

    var sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      int bid = io.nextInt();
      var maxTicketEntry = tickets.floorEntry(bid);
      if (maxTicketEntry == null) sb.append("-1\n");
      else {
        var maxTicketKey = maxTicketEntry.getKey();
        sb.append(maxTicketKey).append('\n');
        int remainingTickets = tickets.get(maxTicketKey) - 1;
        if (remainingTickets == 0) tickets.remove(maxTicketKey);
        else                       tickets.put(maxTicketKey, remainingTickets);
      }
    }
    io.print(sb);
  }

  public static void main(String[] args) {
    var m = new entry_9152588();
    var io = new FastIO();
    m.solve(io);
    io.close();
  }
}

/*@fmt:off*/
final class FastIO extends PrintWriter{InputStream stream;byte[]buf=new byte[1<<16];int curChar,numChars;
FastIO(){this(System.in,System.out);}FastIO(InputStream i,OutputStream o){super(o);stream=i;}
int nextByte() {if(numChars==-1){throw new InputMismatchException();}if(curChar >= numChars)
{curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}
if(numChars==-1){return -1;}}return buf[curChar++];}String next(){return next(' ');}
String nextLine(){return next('\n');}private String next(char l){int c;do{c=nextByte();}
while(c<=l);var res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>l);return res.toString();}
int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}
int res=0;do{if(c<'0'||c>'9'){throw new InputMismatchException();}res=10*res+c-'0';c=nextByte();}
while(c>' ');return res*sgn;}double nextDouble(){return Double.parseDouble(next());}
long nextLong(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}
long res=0;do{if(c<'0'||c>'9'){throw new InputMismatchException();}res=10*res+c-'0';c=nextByte();}
while(c>' ');return res*sgn;}}