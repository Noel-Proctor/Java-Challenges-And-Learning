public class Sum3And5 {

    public static void main(String[] args) {


        int sum = 0;
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                sum += i;
                count++;
                System.out.println((i));
            }

            if (count == 5) {
                break;
            }

        }

        System.out.print("Sum: " + sum);
    }


    public static boolean isOdd(int x) {

        if (x <= 0) {
            return false;
        }
        return x % 2 == 0;
    }


    public static long sumOdd(int start, int end) {

        int sum = 0;
        if (end < start) {
            return -1;
        }

        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                sum += i;
            }
        }

        return sum;

    }
}
