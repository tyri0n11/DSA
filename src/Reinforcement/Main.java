package Reinforcement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(removePunctuation("Let's try, Mike !"));
    }

    //REINFORCEMENT
    //R-1.1
    public static void inputAllBaseTypes(){
        Scanner sc = new Scanner(System.in);

        String s = null;

        if (s==null){
            System.out.println("Enter string: ");
            s = sc.nextLine();
        }

        System.out.println("Enter integer: ");
        int i = sc.nextInt();

        System.out.println("Enter long: ");
        long l = sc.nextInt();

        System.out.println("Enter float: ");
        float f = sc.nextFloat();

        System.out.println("Enter double: ");
        double d = sc.nextDouble();

        System.out.println("Enter boolean value: ");
        boolean flag = sc.nextBoolean();

        System.out.println("Enter character: ");
        char c = sc.next().charAt(0);

        sc.close();
            System.out.println(i);
            System.out.println(l);
            System.out.println(f);
            System.out.println(d);
            System.out.println(s);
            System.out.println(flag);
            System.out.println(c);
    }
    //R-1.2
    public static void gameEntry_R1_2(){
        GameEntry[] A = new GameEntry[5];
        for (int i = 0; i < A.length; i++) {
            A[i] = new GameEntry(i * 100);
        }
        GameEntry[] B = A.clone();
        A[4].score =550;
        System.out.println("B[4] score: "+ B[4].score);

    }
    //R-1.3
    public static boolean isMultiple(long n, long m){
        return (n%m==0);
    }
    //R-1.4
    public static boolean isEven(int i){ return (i%2==0);}
    //R-1.5
    public static int findSum(int n){
        int result = 0;

        for(int i=0; i<=n; i++){
            result += i;
        }
        return result;
    }
    //R-1.6
    public static int findOddSum(int n){
        int result = 0;
        for(int i=0; i<=n; i++){
            if(i%2!=0){
                result += i;
            }
        }
        return result;
    }
    //R-1.7
    public static int findSquaresSum(int n){
        int result=0;

        for(int i=0; i<=n; i++){
            result += i^2;
        }
        return result;
    }
    //R-1.8
    public static int countVowels(String s){
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if( ch=='u' || ch=='e' || ch=='o' || ch=='a' || ch=='i'  ){
                count ++;
            }
        }
        return count;
    }
    //R-1.9
    public static String removePunctuation(String s){

        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i<sb.length(); i++) {
            char ch = sb.charAt(i);
            if (!Character.isLetter(ch) && !Character.isWhitespace(ch)) {
                sb.deleteCharAt(i);
                i--;
            }
        }

        return sb.toString();
    }
    //R-1.10
    /* Write a Java class, Flower, that has three instance variables of type String, int,
 and float, which respectively represent the name of the flower, its number of
 petals, and price. Your class must include a constructor method that initializes
 each variable to an appropriate value, and your class should include methods for
 setting the value of each type, and getting the value of each type.*/
    Flowers f1 = new Flowers((float) 3.41);
    Flowers f2 = new Flowers((int)5);
    Flowers f3 = new Flowers("Hoa Ngu Sac");
}