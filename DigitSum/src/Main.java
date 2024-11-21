//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //int x=sumFirstAndLastDigit(11);

        System.out.println(getEvenDigitSum(122418));

        boolean b = hasSharedDigit(12, 13);


    }


    public static int sumFirstAndLastDigit(int x) {
        if (x < 0) {
            return -1;
        }
        int lastDigit = x % 10;
        while (x > 9) {
            x = x / 10;
        }
        x = x + lastDigit;
        return x;

    }

    public static int getEvenDigitSum(int x) {
        if (x < 0) {
            return -1;
        }
        int sumofEven = 0;
        while (x > 9) {

            sumofEven += (x % 10) % 2 == 0 ? x % 10 : 0;
            x = x / 10;

        }
        return sumofEven;
    }


    public static boolean hasSharedDigit(int x, int y) {
        if (x < 10 || x > 99 || y < 10 || y > 99) {
            return false;
        }

        while (x > 0) {
            if (x % 10 == y % 10 || x % 10 == y / 10) {
                return true;
            }
            x = x / 10;

            if (x < 0) {
                break;
            }
        }
        return false;
    }


    public static boolean hasSameLastDigit(int a, int b, int c) {
        int[] numbers = {a, b, c};
        for (int i : numbers) {
            if (!isValid(numbers[i])) {
                return false;
            }
        }

        for (int i : numbers) {
            for (int j : numbers) {
                if (i == j) {
                    continue;
                }

                if (numbers[i] % 10 == numbers[j] % 10) {
                    return true;
                }
            }

        }
        return false;
    }


    public static boolean isValid(int x){
        return x >= 10 && x <= 1000;

    }
}