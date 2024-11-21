public class PrimeNumberChallenge {

    public static void main(String[] args) {

        int count = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " is " + (isPrime(i) ? "Prime" : "NotPrime"));

            if (count == 3) {
                break;
            }
            count++;
        }
    }


    public static boolean isPrime(int x) {

        if (x <= 2) {
            return x == 2;
        }
        for (int divisor = 2; divisor < x; divisor++) {
            if (x % divisor == 0) {
                return false;
            }
        }
        return true;

    }
}
