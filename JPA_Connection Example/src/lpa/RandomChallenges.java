package lpa;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomChallenges {

    public static void main(String[] args) {

//        int[] sortedArray = generateRandomisedArray(10);
//        System.out.println(Arrays.toString(sortedArray));
//        Arrays.sort(sortedArray);
//        System.out.println(Arrays.toString(sortedArray));
//
//        int[] temp = new int[10];
//        for (int i = 0; i < temp.length; i++) {
//            temp[i] = sortedArray[sortedArray.length - (i + 1)];
//        }
//
//        sortedArray = temp;
//        System.out.println(Arrays.toString(sortedArray));

//        int [] x = getIntegers(5);
//        printArray(x);
//        x = sortIntegers(x);
//        printArray(x);#

//        int[] numbers = readIntegers();
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(findMin(numbers)+ "is the smallest number in the array");

        System.out.println(Arrays.toString(reverse(readIntegers())));

    }

    private static int[] generateRandomisedArray(int len) {
        Random random = new Random();
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }


    public static int[] getIntegers(int len) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[len];

        for (int i =0; i< x.length; i++){
            System.out.println("Please enter number at position "+i);
            x[i]=scanner.nextInt();
        }

        scanner.close();
        System.out.println(Arrays.toString(x));
        return x;
    }


    public static void printArray(int[] x){

        for(int i =0; i<x.length; i++){
            System.out.println("Element "+i+" contents "+ x[i]);

        }
    }

    public static int[] sortIntegers(int[] x){
        Arrays.sort(x);
        int[] reversed = new int[x.length];

        for (int i=0; i<x.length; i++){
            reversed[i] = x[x.length-(i+1)];
        }
        return reversed;

    }



    public static int[] readIntegers() {

        System.out.println("Enter numbers seperated by commas");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String [] strings = input.split(",");
        int[] numbers = new int[strings.length];
//       ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i=0 ; i<strings.length ; i++){
            numbers[i] =Integer.parseInt(strings[i].strip());
        };

        return numbers;
    }


    public static int findMin(int[] numbers){

        for (Number number: numbers){
            System.out.print(number+", ");
        }
        Arrays.sort(numbers);
        System.out.println();

        for (Number number: numbers){
            System.out.print(number+", ");
        }
        return numbers[0];
    }

    public static int [] reverse(int[] numbers){

        int [] reversed = new int[numbers.length];

        for (int i=0;i<numbers.length; i++){
            reversed[i]= numbers[numbers.length-(i+1)];
        }
        return reversed;

    }
}
