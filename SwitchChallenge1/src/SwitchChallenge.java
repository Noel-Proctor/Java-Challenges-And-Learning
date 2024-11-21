public class SwitchChallenge {

    public static void main(String[] args) {
        System.out.println("Hello World");

        char[] charArray = {'A', 'B', 'C', 'D', 'E'};
        for (char c : charArray) {
            containsChar(c);
        }


        int[] intArray = {0, 1, 2, 3, 4,5,6,7,8};
        for (int c : intArray) {
            enhancedSwitch(c);
        }
    }

    public static void containsChar(char a) {
        switch (a) {
            case 'A':
                System.out.println("Alpha");
                break;
            case 'B':
                System.out.println("Bravo");
                break;
            case 'C':
                System.out.println("Charlie");
                break;
            case 'D':
                System.out.println("Delta");
                break;
            default:
                System.out.println("Not Found");

        }
    }

    public static void enhancedSwitch(int day){
        String dayofWeek = switch(day){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 0 -> "Sunday";
            default -> "Invalid day";
        };

        System.out.println(day + "is "+dayofWeek);


    }


    public static boolean isLeapYear(int year){

        if (year<1 || year >9999){
            return false;
        }

        return switch(year){
            case ((year %400) ==0 )->true;
            case year %4 ==0 && year %100 !=0 ->true;
            default ->false;
        };
}
