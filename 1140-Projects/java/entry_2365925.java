import java.io.*;
import java.util.*;

// Dynamic Programming + TreeMap
public class entry_2365925 {

 public static void main(String[] args) throws Exception {
  int n = ni();
  Project[] projects = new Project[n];
  for (int i = 0; i < n; i++) {
   Project project = new Project(ni() - 1, ni(), ni());
   projects[i] = project;
  }
  Arrays.sort(projects, (p1, p2) -> p1.start - p2.start);

  TreeMap<Integer, Long> earnings = new TreeMap<>();
  earnings.put(0, 0l);
  Map.Entry<Integer, Long> startEntry = earnings.firstEntry();
  Long maxStart = 0l, maxEnd = 0l;
  int maxEndKey = 0;
  for (Project project : projects) {
   Map.Entry<Integer, Long> entry = startEntry;
   while (entry != null && entry.getKey() <= project.start) {
    startEntry = entry;
    maxStart = Math.max(maxStart, startEntry.getValue());
    earnings.remove(entry.getKey());
    entry = earnings.higherEntry(entry.getKey());
   }
   Long end = earnings.get(project.end);
   if (end == null) {
    end = 0L;
   }
   Long newEnd = maxStart + project.reward;
   if (newEnd > end && (newEnd > maxEnd || newEnd < maxEnd && project.end < maxEndKey)) {
    earnings.put(project.end, newEnd);
    if (maxEnd < newEnd) {
     maxEnd = newEnd;
     maxEndKey = project.end;
    }
   }
  }

  System.out.println(maxEnd);
 }

 static class Project {
  public int start;
  public int end;
  public int reward;

  public Project(int start, int end, int reward) {
   this.start = start;
   this.end = end;
   this.reward = reward;
  }
 }

 /*
  * **********************BASIC READER ******************************************
  * *****************************************************************************
  *****************************************************************************/

 static InputStream is = System.in;;
 static byte[] inbuf = new byte[1024 << 4];
 static int lenbuf = 0, ptrbuf = 0;

 static int readByte() {
  if (lenbuf == -1)
   throw new InputMismatchException();
  if (ptrbuf >= lenbuf) {
   ptrbuf = 0;
   try {
    lenbuf = is.read(inbuf);
   } catch (IOException e) {
    throw new InputMismatchException();
   }
   if (lenbuf <= 0)
    return -1;
  }
  return inbuf[ptrbuf++];
 }

 static boolean isSpaceChar(int c) {
  return !(c >= 33 && c <= 126);
 }

 static int skip() {
  int b;
  while ((b = readByte()) != -1 && isSpaceChar(b))
   ;
  return b;
 }

 static int ns() {
  int b = skip();
  int result = 0;
  while (!(isSpaceChar(b))) {
   result |= (1 << (b - 'a'));
   b = readByte();
  }
  return result;
 }

 static char[] ns(int n) {
  char[] buf = new char[n];
  int b = skip(), p = 0;
  while (p < n && !(isSpaceChar(b))) {
   buf[p++] = (char) b;
   b = readByte();
  }
  return n == p ? buf : Arrays.copyOf(buf, p);
 }

 static int ni() {
  int num = 0, b;
  boolean minus = false;
  while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
   ;
  if (b == '-') {
   minus = true;
   b = readByte();
  }

  while (true) {
   if (b >= '0' && b <= '9') {
    num = num * 10 + (b - '0');
   } else {
    return minus ? -num : num;
   }
   b = readByte();
  }
 }
}