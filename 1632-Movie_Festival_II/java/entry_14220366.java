//package cses.sortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class entry_14220366 {
 public static void main(String[] args) throws IOException {
  final int n = readInt();
  final int k = readInt();
  List<int[]> movies = new ArrayList<>(n);
  for (int i = 0; i < n; i++) {
   int start = readInt();
   int end = readInt();
   movies.add(new int[] { start, end });
  }
  Collections.sort(movies, new Comparator<int[]>() {
   @Override
   public int compare(int[] o1, int[] o2) {
    return o1[1] == o2[1] ? Integer.compare(o2[0], o1[0]) : Integer.compare(o1[1], o2[1]);
   }
  });

  TreeMap<Integer, Integer> pq = new TreeMap<>();
  int pqSize = 0;

  int hits = 0;
  for (int i = 0; i < n; i++) {
   int[] a = movies.get(i);
   Integer floor = pq.floorKey(a[0]);
   if (floor != null) {
    hits++;

    int count = pq.get(floor);
    if (count == 1) {
     pq.remove(floor);
    } else {
     pq.put(floor, count - 1);
    }

    pq.put(a[1], pq.getOrDefault(a[1], 0) + 1);
   } else if(pqSize < k) {
    hits++;
    pq.put(a[1], pq.getOrDefault(a[1], 0) + 1);
    pqSize++;
   }
  }
  System.out.println(hits);
 }

 private static final int BUFFER_SIZE = 1 << 16;
 private static final InputStream in = System.in;
 private static final byte[] buffer = new byte[BUFFER_SIZE];
 private static int bufferPointer = 0, bytesRead = 0;

 public static void skip() {
  byte c = Read();
  while (c <= ' ') {
   c = Read();
  }
  do {
   c = Read();
  } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
 }

 public static void skipLine() {
  byte c = Read();
  while (c == '\n' || c == '\r') {
   c = Read();
  }
  do {
   c = Read();
  } while (c != -1 && c != '\n' && c != '\r');
 }

 public static String read() {
  final StringBuilder sb = new StringBuilder();
  byte c = Read();
  while (c <= ' ') {
   c = Read();
  }
  do {
   sb.append((char) c);
   c = Read();
  } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
  return sb.toString();
 }

 public static String read(final int length) {
  final byte[] ret = new byte[length];
  int idx = 0;
  byte c = Read();
  while (c <= ' ') {
   c = Read();
  }
  do {
   ret[idx++] = c;
   c = Read();
  } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
  return new String(ret, 0, idx);
 }

 public static String[] readStringArray(final int strings) {
  final String[] arr = new String[strings];
  for (int i = 0; i < strings; i++) {
   arr[i] = read();
  }
  return arr;
 }

 public static String readLine() {
  final StringBuilder sb = new StringBuilder();
  byte c = Read();
  while (c == '\n' || c == '\r') {
   c = Read();
  }
  do {
   sb.append((char) c);
   c = Read();
  } while (c != -1 && c != '\n' && c != '\r');
  return sb.toString();
 }

 public static char readChar() {
  byte c = Read();
  while (Character.isWhitespace(c)) {
   c = Read();
  }
  return (char) c;
 }

 public static char[] readCharArray(final int chars) {
  final char[] arr = new char[chars];
  for (int i = 0; i < chars; i++) {
   arr[i] = readChar();
  }
  return arr;
 }

 public static java.math.BigInteger readBigInteger() {
  return new java.math.BigInteger(read());
 }

 public static java.math.BigDecimal readBigDecimal() {
  return new java.math.BigDecimal(read());
 }

 public static byte readByte() {
  byte ret = 0;
  byte c = Read();
  while (c <= ' ')
   c = Read();
  boolean neg = (c == '-');
  if (neg)
   c = Read();
  do {
   ret = (byte) (ret * 10 + c - '0');
  } while ((c = Read()) >= '0' && c <= '9');
  if (neg)
   return (byte) -ret;
  return ret;
 }

 public static byte[] readByteArray(final int numbers) {
  final byte[] arr = new byte[numbers];
  for (int i = 0; i < numbers; i++) {
   arr[i] = readByte();
  }
  return arr;
 }

 public static short readShort() {
  short ret = 0;
  byte c = Read();
  while (c <= ' ')
   c = Read();
  boolean neg = (c == '-');
  if (neg)
   c = Read();
  do {
   ret = (short) (ret * 10 + c - '0');
  } while ((c = Read()) >= '0' && c <= '9');
  if (neg)
   return (short) -ret;
  return ret;
 }

 public static short[] readShortArray(final int numbers) {
  final short[] arr = new short[numbers];
  for (int i = 0; i < numbers; i++) {
   arr[i] = readShort();
  }
  return arr;
 }

 public static int readInt() {
  int ret = 0;
  byte c = Read();
  while (c <= ' ')
   c = Read();
  boolean neg = (c == '-');
  if (neg)
   c = Read();
  do {
   ret = ret * 10 + c - '0';
  } while ((c = Read()) >= '0' && c <= '9');
  if (neg)
   return -ret;
  return ret;
 }

 public static int[] readIntArray(final int numbers) {
  final int[] arr = new int[numbers];
  for (int i = 0; i < numbers; i++) {
   arr[i] = readInt();
  }
  return arr;
 }

 public static long readLong() {
  long ret = 0;
  byte c = Read();
  while (c <= ' ')
   c = Read();
  boolean neg = (c == '-');
  if (neg)
   c = Read();
  do {
   ret = ret * 10 + c - '0';
  } while ((c = Read()) >= '0' && c <= '9');
  if (neg)
   return -ret;
  return ret;
 }

 public static long[] readLongArray(final int numbers) {
  final long[] arr = new long[numbers];
  for (int i = 0; i < numbers; i++) {
   arr[i] = readLong();
  }
  return arr;
 }

 public static double readDouble() {
  double ret = 0, div = 1;
  byte c = Read();
  while (c <= ' ')
   c = Read();
  boolean neg = (c == '-');
  if (neg)
   c = Read();
  do {
   ret = ret * 10 + c - '0';
  } while ((c = Read()) >= '0' && c <= '9');
  if (c == '.') {
   while ((c = Read()) >= '0' && c <= '9') {
    ret += (c - '0') / (div *= 10);
   }
  }
  if (neg)
   return -ret;
  return ret;
 }

 public static double[] readDoubleArray(final int numbers) {
  final double[] arr = new double[numbers];
  for (int i = 0; i < numbers; i++) {
   arr[i] = readDouble();
  }
  return arr;
 }

 public static boolean hasMoreBytes() {
  if (bufferPointer == bytesRead)
   fillBuffer();
  return bufferPointer < bytesRead;
 }

 private static void fillBuffer() {
  try {
   bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
   if (bytesRead == -1)
    buffer[0] = -1;
  } catch (IOException e) {
   throw new UncheckedIOException(e);
  }
 }

 private static byte Read() {
  if (bufferPointer == bytesRead)
   fillBuffer();
  return buffer[bufferPointer++];
 }
}