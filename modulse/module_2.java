package modulse;

public class module_2 {
    public static void main(String[] args) {
        System.out.println(repeat("met",3));//Повторение каждого символа n раз
        System.out.println(differenceMaxMin(new int []  {10, 4, 1, 4, -10, -50, 32, 21}));// Разница между максимальным и минимальным значением
        System.out.println(isAvgWhole(new int []  {1,3}));//Среднее значение
        cumulativeSum(new int []  {1,2,3});//Вывод значений массива сложенных с самим собой и предыдущими элементами
        System.out.println(getDecimalPlaces("43.20"));// Сколько десятичных знаков
        System.out.println(fibonach(3));//Числа фибоначи
        System.out.println(isValid("59001"));//Проверка почтовых индексов
        System.out.println(isStrangePair("sparkling", "groups") );//Пара строк по определ условиям
        System.out.println(isPrefix("automation", "auto-"));//Префикс
        System.out.println(isSuffix("arachnophobia", "-phobia"));//Суффикс
        System.out.println(boxSeq(2));//Шаги-клетки


    }
    //Повторение каждого символа n раз
    public static String repeat(String s, int n){
        String news="";
        for (int i = 0; i <s.length(); i++) {
            for (int j = 0; j <n; j++) {
                news+=s.charAt(i);
            }
        }
        return  news;
    }
    // Разница между максимальным и минимальным значением
    public static int differenceMaxMin (int [] mas){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <mas.length; i++) {
            if(mas[i]>max){
                max=mas[i];
            }
            else{
                if(mas[i]<min){
                    min=mas[i];
                }
            }
        }
        return max-min;
    }
    //Среднее значение
    public static boolean isAvgWhole (int [] mas){
        int middle=0;
        for (int i = 0; i <mas.length; i++) {
            middle+=mas[i];
        }
        return (middle%2)==0;
    }
    //Вывод значений массива сложенных с самим собой и предыдущими элементами
    public static void cumulativeSum(int [] mas){
        int sum=0;
        for (int i = 0; i < mas.length; i++) {
            sum+=mas[i];
            mas[i]=sum;
            System.out.print(mas[i]+" ");
        }
    }
    // Сколько десятичных знаков
    public static  int getDecimalPlaces(String s){
        int da=s.indexOf(".");
        int Length=s.length()-da;
        return Length;
    }
    // Числа фибоначи
   public static int fibonach(int n)
    {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;

        return fibonach(n-1)+fibonach(n-2);
    }
    //Проверка почтовых индексов
    public static boolean isValid(String s){
        if(s.length()<=5){
            if(s.indexOf(" ")==-1){
            return true;
            }
            else return false;
        }
        else return false;
    }
    //Пара строк по определ условиям
    public static boolean isStrangePair(String s,String s2){

        if(s.indexOf(0)==s2.indexOf(s2.length()-1)){
            if(s2.indexOf(0)==s.indexOf(s2.length()-1)){
                return true;
            }
            else return false;
        }
        else return false;
    }
    //Префикс
    public static Boolean isPrefix (String a,String b){
        boolean s=false;
        for (int i = 0; i < b.length()-1; i++) {
            if(a.indexOf(i)==b.indexOf(i)){
                s=true;
            }
            else s=false;


        }
        return s;
    }
    //Суффикс
    public static Boolean isSuffix (String a,String b){
        boolean s=false;
        for (int i = 1; i < b.length(); i++) {
            if(a.indexOf(i+a.length()-b.length())==b.indexOf(i)){
                s=true;
            }
            else s=false;


        }
        return s;
    }
    //Шаги-клетки
    public static int boxSeq(int n){
        int count=0;
        if (n==0) return 0;
        for (int i = 1; i <=n; i++) {
            if(i%2!=0) count+=3;
            else count--;
        }
        return count;
    }
}
