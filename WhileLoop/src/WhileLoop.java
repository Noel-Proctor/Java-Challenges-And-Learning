public class WhileLoop {
    public static void main(String[] args){
        int count = 5;
        int countOdd=0;
        int countEven =0;

        while(count<=20){
            if (isEvenNumber(count)){
                System.out.println(count);
                countEven++;
            }else{
                countOdd++;
            }

            if (countEven >=5){
                break;
            }
            count++;
        }



    }

    public static boolean isEvenNumber(int x){
        return x % 2==0;
    }
}
