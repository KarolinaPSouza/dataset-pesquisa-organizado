import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SplittableRandom;
import java.util.StringTokenizer;

public class entry_9612670 {

    public static void main(String[] args) throws Exception {
        final Apartments apartments = readApartmentsInfo();
        final int numberOfServedApplicants = apartments.computeNumberOfServedApplicants();

        System.out.println(numberOfServedApplicants);
    }

    private static Apartments readApartmentsInfo() throws Exception {
        try (ConsoleReader reader = new ConsoleReader(" ")) {
            final int applicantsCount = reader.nextInt();
            final int apartmentsCount = reader.nextInt();
            final int maxAllowedDifference = reader.nextInt();

            final int[] applicantsDesiredSizes = new int[applicantsCount];
            for (int i = 0; i < applicantsCount; i++) {
                applicantsDesiredSizes[i] = reader.nextInt();
            }

            final int[] apartmentsSizes = new int[apartmentsCount];
            for (int i = 0; i < apartmentsCount; i++) {
                apartmentsSizes[i] = reader.nextInt();
            }

            return new Apartments(applicantsDesiredSizes, apartmentsSizes, maxAllowedDifference);
        }
    }

    private static class Apartments {

        private final SplittableRandom random = new SplittableRandom();

        private final int[] applicantsDesiredSizes;
        private final int[] apartmentsSizes;
        private final int maxAllowedDifference;

        Apartments(
                int[] applicantsDesiredSizes,
                int[] apartmentsSizes,
                int maxAllowedDifference) {
            this.applicantsDesiredSizes = applicantsDesiredSizes;
            this.apartmentsSizes = apartmentsSizes;
            this.maxAllowedDifference = maxAllowedDifference;
        }

        int computeNumberOfServedApplicants() {
            quickSort(this.applicantsDesiredSizes, 0, this.applicantsDesiredSizes.length - 1);
            quickSort(this.apartmentsSizes, 0, this.apartmentsSizes.length - 1);

            int servedApplicants = 0;
            for (int i = 0, j = 0; i < this.apartmentsSizes.length && j < this.applicantsDesiredSizes.length; i++) {

                while (this.apartmentsSizes[i] > this.applicantsDesiredSizes[j] + this.maxAllowedDifference) {
                    if (++j >= this.applicantsDesiredSizes.length) {
                        return servedApplicants;
                    }
                }

                if (this.apartmentsSizes[i] >= this.applicantsDesiredSizes[j] - this.maxAllowedDifference
                        && this.apartmentsSizes[i] <= this.applicantsDesiredSizes[j++] + this.maxAllowedDifference) {
                    servedApplicants++;
                }
            }

            return servedApplicants;
        }

        private void quickSort(final int[] a, final int leftBound, final int rightBound) {
            final int median = a[leftBound == rightBound ? leftBound : random.nextInt(leftBound, rightBound)];

            int i = leftBound;
            int j = rightBound;

            while (i <= j) {

                while (a[i] < median) {
                    i++;
                }

                while (a[j] > median) {
                    j--;
                }

                if (i <= j) {
                    final int t = a[i];
                    a[i] = a[j];
                    a[j] = t;

                    i++;
                    j--;
                }
            }

            if (j > leftBound) {
                quickSort(a, leftBound, j);
            }

            if (i < rightBound) {
                quickSort(a, i, rightBound);
            }
        }
    }

    private static class ConsoleReader implements AutoCloseable {
        private final BufferedReader reader;
        private final String delimiter;
        private StringTokenizer tokenizer;

        ConsoleReader(final String delimiter) {
            this.delimiter = delimiter;
            this.reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (this.tokenizer == null || !tokenizer.hasMoreElements()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine(), this.delimiter);
            }
            return this.tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        @Override
        public void close() throws Exception {
            this.reader.close();
        }
    }
}