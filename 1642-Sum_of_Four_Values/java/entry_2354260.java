import java.io.*;
import java.util.*;

//2 Pointers, Sort and Mapping
public class entry_2354260 {

 public static void main(String[] args) throws Exception {
  int n = ni(), x = ni();
  Number[] numbers = new Number[n];
  for (int i = 0; i < n; i++) {
   numbers[i] = new Number(i + 1, ni());
  }
  Arrays.sort(numbers, (n1, n2) -> n1.value - n2.value);

  for (int i = 0; i < n; i++) {
   Number n1 = numbers[i];
   for (int j = i + 1; j < n; j++) {
    Number n2 = numbers[j];
    int remain = x - n1.value - n2.value;
    int from = j + 1, to = n - 1;
    while (from < to) {
     int need = numbers[from].value + numbers[to].value;
     if (need < remain) {
      from++;
     } else if (need > remain) {
      to--;
     } else {
      System.out.println(
        n1.index + " " + n2.index + " " + numbers[from].index + " " + numbers[to].index);
      return;
     }
    }
   }
  }

  System.out.println("IMPOSSIBLE");
 }

 static class Number {
  public int index;
  public int value;

  public Number(int index, int value) {
   this.index = index;
   this.value = value;
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