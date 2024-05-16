package Recursion;

public class RaisingNumber {
    public static double power(double base, int exponent){
        if(exponent == 0){
            return 1;
        } else if(exponent>0){
            return base * power(base, exponent - 1);
        } else return 1/(base + power(base, - exponent - 1));
    }
    public static void main(String[] args){
        System.out.println(power(2,5));
    }
}
