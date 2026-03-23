import java.io.DataInputStream;
import java.io.IOException;
import java.util.TreeMap;

class Main {
    static class CustomReader {
        final private int BUFFER_SIZE = 64 * 1024; // 64kbs adjust as needed
        final private DataInputStream dis;
        final private byte[] buffer;
        private int bufferPointer, bytesRead;

        public CustomReader() {
            dis = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = 0;
            bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            // reset buffer pointer to zero and fill up the buffer up to BUFFER_SIZE
            bytesRead = dis.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            // if no more data to read, assign -1 to set end of the input stream flag
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            // if the buffer exhausted, fill up the buffer
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++]; // return at bufferPointer index then increase the value
        }

        public Integer nextInt() throws IOException {
            // set initial return value
            int intValue = 0;
            // read the first byte to find first valid number
            byte currentByte = read();
            while (currentByte <= ' ') {
                currentByte = read();
            }

            do {
                // transfrom byte into integer
                intValue = intValue * 10 + (currentByte - '0');
            } while ((currentByte = read()) >= '0' && currentByte <= '9'); // read next byte that are in range of 0 to 9

            return intValue;
        }

        public void close() throws IOException {
            if (dis == null) return;
            dis.close();
        }
    }

    public static void main(String[] args) throws Exception {

        // create custom reader to get input
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