package modulse;

import com.sun.deploy.security.CredentialManager;

public class module_1 {
    public static void main(String[] args) {
        int[] nums = {1, 5, 9};
        System.out.println(remaider(1,3));//Остаток от деления
        System.out.println(triArea(3,2));//Площадь треугольника
        System.out.println(animals(2,3,5));//Ноги животных
        System.out.println(profitableGamble(0.2,50,9));//Функция
        System.out.println(operation(24,15,9));//Действие с числами
        System.out.println(ctoa('A'));//Преобразование в номер по таблице ASCII
        System.out.println(addUpTo(3));//Факториал
        System.out.println(nextEdge(8,10));//Максимальное значение третьего ребра
        System.out.println(sumOfCubes(nums));//Сумма кубов массива чисел
        System.out.println(abcmath(42,5,10));//Функция добавления числа к самому себе n раз и проверка деления

    }
    //Задание №1
    public static double remaider(double a, double b){
        return a%b;
    }
    //Задание №2
    public static double triArea(double a, double b){
        return 0.5*a*b;
    }
    //Задание №3
    public static int animals (int a, int b, int c){
        int chic=2,cow=4,pig=4;
        return chic*a+cow*b+pig*c;
    }
    //Задание №4
    public static boolean profitableGamble(double a,int b, int c){
        if((a*b-c)>0){
            return true;
        }
        else return false;
    }
    //Задание №5
    public static String operation (int c, int b,int a){
        String s="none";
        if (a+b==c){
            s="Addited";
        }
        else{
             if(a-b==c || b-a==c){
                 s="subtracted";
             }
             else{
                 if(a*b==c){
                     s="multiplicated";
                 }
                 else{
                     if (a/b==c || b/c==c){
                         s="separated";
                     }
                 }
             }
        }
        return (s);
    }
    //Задание №6
    public static int ctoa (char a){
        return (int)a;

    }
    //Задание №7
    public  static int addUpTo(int a){
        int i=0,sum=0;
        while (i!=a){
            i++;
            sum+=i;

        }
        return sum;
    }
    //Задание №8
    public static double nextEdge(double a, double b) {
        return a + b - 1;
    }
    //Задание №9
    public static  int sumOfCubes(int [] a){
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            sum+=(a[i]*a[i]*a[i]);

        }
        return sum;
    }
    //Задание №10
    public static boolean abcmath(int a, int b, int c){
        int i=0;
        while (i!=b){
            a=a*2;
            i++;
        }
        return (a%c==0)? true:false;
    }

}
