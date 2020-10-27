package modulse;

import java.util.Map;

public class module_3 {
    public static void main(String[] args) {


        solutions(5, 8, 14);//Квадратное уравнение
        System.out.println(findZip("all zip files are compressed"));// Позиция второго вхождения
        System.out.println(checkPerfect(6));// Совершенное число
        flipEndChars("Ada");// Замена символов
        System.out.println(isValidHexCode("#c5DB1f"));// Шестнадцатеричный код
        System.out.println(same (new int []  {1, 3, 4, 4, 4}, new int []  {2, 5, 7}) );//Уникальные элементы
        System.out.println(isKaprekar(297));//число Капрекара
        longestZero("01100001011000");//Самая большая последовательность
        System.out.println();
        System.out.println(nextPrime(24));;//Следующее простое число;
        System.out.println(rightTriangle(3, 4, 5) );//Прямоугольный треугольник
    }

    // Квадратное уравнение
    public static void solutions(int a, int b, int c) {
        double x, x1, x2;
        double D = Math.pow(b, 2) - 4 * a * c;
        if (D > 0) {
            x1 = (-b + Math.sqrt(D)) / (2 * a);
            x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println(a + " * x^2" + " + " + b + " + " + c + "= 0  x= " + x1 + " and x= " + x2 + ").");
        } else if (D == 0) {
            x = -b / (2 * a);
            System.out.println(a + "x^2" + " = 0 x= " + x + ".");
        } else
            System.out.println(a + " * x^2" + " + " + b + " + " + c + " = 0 ");
    }

    // Позиция второго вхождения
    public static int findZip(String s) {
        int iz1 = s.indexOf("zip");
        int iz2 = s.indexOf("zip", iz1 + 1);
        return iz2;
    }

    // Совершенное число
    public static boolean checkPerfect(int a) {
        int sum = 0;
        for (int i = 1; i < a; i++) {
            if (a % i == 0) {
                sum += i;
            }

        }
        return sum == a;
    }

    // Замена символов
    public static void flipEndChars(String s) {
        String a1 = "";
        if (s.length() == 1) {
            System.out.println("Incompatible.");
        } else {
            char beginning = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            if (beginning != end) {
                a1 = s.substring(1, s.length() - 1);
                System.out.println(end + a1 + beginning);

            } else if (beginning == end) {
                System.out.println("Two's a pair.");
            }
        }
    }

    // Шестнадцатеричный код
    public static boolean isValidHexCode(String s) {
        char c;
        boolean pr = false;
        c = s.charAt(0);
        if (s.length() <= 7) {
            if (c == '#') {
                for (int i = 1; i < s.length(); i++) {
                    c = s.charAt(i);
                    if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F')) {
                        pr = true;
                    } else
                        pr = false;
                }
            } else
                pr = false;
        } else
            pr = false;
        return pr;
    }
    //Уникальные элементы
    public static boolean same (int [] mas1, int [] mas2){
        int count1=0, count2=0;
        for (int i = 0; i < mas1.length; i++) {
            for (int j = i+1; j <mas1.length; j++) {
                if(mas1[i]==mas1[j]){
                    count1++;
                    i=j;
                }
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            for (int j = i+1; j <mas2.length; j++) {
                if(mas2[i]==mas2[j]){
                    count2++;
                    i=j;
                }
            }
        }
        return (mas1.length-count1)==(mas2.length-count2);
    }
    //число Капрекара
    public static boolean isKaprekar (int a){

        int n= (int) Math.pow(a,2);
        int length=Integer.toString(n).length();//убираем в длинне точку и ноль
        if(length==1){
            int left=0;
            double rigth=n;
            return (left+rigth)==a;
        }
        else {
            int c= (int) Math.ceil(length/2.0);//(int) убираю .0
            int left= (int) (n/Math.pow(10,c));//убираю .0
            int rigth=(int) (n%Math.pow(10,c));//убираю .0
            return (left+rigth)==a;
        }
    }
    //Самая большая последовательность
    public static void longestZero (String a){
        int count1=0;
        int count2=0;
        char s1='0';
        char s2='0';

        for (int i = 0; i < a.length()-1; i++) {
            char c1=a.charAt(i);
            char c2=a.charAt(i+1);
            if((int)c1==(int)c2){
                count1++;
                s1=c1;

            }
            else{
                if(count2<count1){
                    count2=count1;
                    s2=s1;
                    count1=0;
                }
            }
        }

        for (int i = 0; i < count2+1; i++) {//+1 т к он считает парами(найденные пары)
            System.out.print(s2);

        }
    }
    //Следующее простое число;
    public static int nextPrime(int n) {
        if (n==2 || n==3 || n==5 || n==7){
            return n;
        }
        else{
            if (n%2!=0 && n%3!=0 && n%5!=0 && n%7!=0){
                return n;
            }
            else{
                while (true){
                    n++;
                    if (n%2!=0 && n%3!=0 && n%5!=0 && n%7!=0){
                            return n;
                    }
                }
            }

        }

    }
    //Прямоугольный треугольник
    public static boolean rightTriangle (int a,int b, int c){
        int max=a;
        if(b<c){
            if(a<c){
                max=c;

                return max==Math.sqrt(Math.pow(a,2)+Math.pow(b,2));

            }
        }
        else {
            if(a<b){
                max=b;
                return max==Math.sqrt(Math.pow(c,2)+Math.pow(a,2));

            }
        }
        return max==Math.sqrt(Math.pow(c,2)+Math.pow(b,2));

    }


}
