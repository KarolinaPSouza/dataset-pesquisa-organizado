import java.io.*;
import java.util.*;

public class entry_10571233 {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din != null)
                din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg ? -ret : ret;
        }
    }

    public static void main(String[] args) throws IOException {
        Reader br = new Reader();

        // อ่านจำนวนตั๋วและจำนวนลูกค้า
        int n = br.nextInt();
        int m = br.nextInt();

        // ใช้ TreeMap เพื่อเก็บราคาและจำนวนตั๋ว
        TreeMap<Integer, Integer> concertMap = new TreeMap<>();
        StringBuilder result = new StringBuilder(); // ใช้ StringBuilder เพื่อประสิทธิภาพที่ดีกว่า StringBuffer

        // อ่านราคาตั๋ว
        for (int i = 0; i < n; i++) {
            int price = br.nextInt();
            concertMap.put(price, concertMap.getOrDefault(price, 0) + 1);
        }

        // ประมวลผลการชำระเงินของลูกค้า
        for (int i = 0; i < m; i++) {
            int pricePaidByCustomer = br.nextInt();
            Map.Entry<Integer, Integer> entry = concertMap.lowerEntry(pricePaidByCustomer + 1);
            if (entry != null) {
                result.append(entry.getKey()).append('\n'); // พิมพ์ราคาตั๋วที่ใช้ได้
                // ลดจำนวนตั๋วหรือลบออกหากใช้ไปหมดแล้ว
                if (entry.getValue() == 1) {
                    concertMap.remove(entry.getKey());
                } else {
                    concertMap.put(entry.getKey(), entry.getValue() - 1);
                }
            } else {
                result.append("-1\n"); // ไม่มีตั๋วที่สามารถใช้ได้
            }
        }

        // พิมพ์ผลลัพธ์ทั้งหมดในครั้งเดียว
        System.out.print(result);

        // ปิด Reader
        br.close();
    }
}