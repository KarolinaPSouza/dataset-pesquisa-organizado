import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeMap;

class Main {

    // a constant for regex used to split the space from user input
    public static final String SPACE = " ";

    static class CustomReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream dis;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public CustomReader() {
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public Integer nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg) {
                return -ret;
            }

            return ret;
        }

        public void close() throws IOException {
            if (dis == null)
                return;
            dis.close();
        }
    }

    public static void main(String[] args) throws Exception {

        // create reader to get input
        var reader = new CustomReader();

        int ticketsNumber = reader.nextInt();
        int customersNumber = reader.nextInt();

        // create an ordered map
        TreeMap<Integer, Integer> ticketPriceMap = new TreeMap<>();

        for (int i = 0; i < ticketsNumber; i++) {
            try {
                // read ticket price using the tokenizer
                int price = reader.nextInt();
                // get the current ticket number
                // if not found in the map, assign the value to 0
                var currentTicketPrice = ticketPriceMap.getOrDefault(price, 0);
                // insert ticket into the map, increasing the count by 1
                ticketPriceMap.put(price, currentTicketPrice + 1);
            } catch (Exception e) {
                reader.close();
                if (e instanceof NumberFormatException) {
                    throw new IllegalArgumentException("invalid ticket price argument");
                }
                throw e;
            }
        }

        // create string for result
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < customersNumber; i++) {
            try {
                if (ticketPriceMap.isEmpty()) {
                    result.append(-1).append("\n");
                    continue;
                }

                // get customer max pay using the tokenizer
                int maxPay = reader.nextInt();
                // find the highest ticket price possible for the customer
                var ticketKey = ticketPriceMap.floorKey(maxPay);
                if (ticketKey != null) {
                    // if the ticket is available, reduce the count by 1
                    // or remove it based on the remaining tickets
                    var availableTicket = ticketPriceMap.get(ticketKey);
                    if (availableTicket == 1) {
                        ticketPriceMap.remove(ticketKey);
                    } else {
                        ticketPriceMap.put(ticketKey, availableTicket - 1);
                    }
                    result.append(ticketKey).append("\n");
                } else {
                    // if no ticket is available for the customer, append -1 to the result
                    result.append(-1).append("\n");
                }
            } catch (Exception e) {
                reader.close();
                if (e instanceof NumberFormatException) {
                    throw new IllegalArgumentException("invalid customer max pay argument");
                }
                throw e;
            }
        }

        System.out.print(result);

        // close the reader
        reader.close();
    }
}