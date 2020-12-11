package modulse;

import java.util.HashSet;
import java.util.Stack;

public class module_4 {
    public static void main(String[] args) {
    sochinenie("hello my name is Bessie and this is my essay",10,7);//Задание 1
    split("((()))");//Задание 2
    System.out.println(" ");
    split("()()()");
    System.out.println();
    split("(()())");
    System.out.println();/////
    toCamelCase("hello_edabit");//Задание 3
    System.out.println();
    toSnakeCase("helloEdabit");//Задание 3
    System.out.println();
    System.out.println(overTime(16, 18, 30, 1.8));
    System.out.println(BMI("205 pounds", "73 inches") );
        System.out.println(bugger(39)  );
        System.out.println(bugger(39) );
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham.") );
        System.out.println(trouble(1222345, 12345) );
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A') );



    }
    //Задание 1
    public static void sochinenie(String stroke,int n,int k){
        int i=0,spaceIndex1=0,spaceIndex2=0;
        String buf="";
        boolean f=true;
        boolean f1=true;
        while (f){

            while(f1){ // Поиск пробелов, по которым мы будем обрезать строку
                spaceIndex1=stroke.indexOf(" ");
                spaceIndex2=stroke.indexOf(" ",spaceIndex1+1);
                if(spaceIndex1<k && spaceIndex2<=k){//2 пробела до ограничения
                    char sim3=stroke.charAt(spaceIndex2);
                    if(sim3==' '){//Если пробел стоит на ограничении
                        i=spaceIndex2;
                    }
                    else {//Если пробел не стоит на ограничении
                        i=stroke.indexOf(" ");
                    }
                    break;
                }else{
                if(spaceIndex1<=k && spaceIndex2>k){
                    char sim3=stroke.charAt(spaceIndex2);
                    if(sim3==' '&& (spaceIndex2==k+1)){//Если пробел стоит после  ограничения
                        i=spaceIndex2;
                    }
                    else{
                        i=stroke.indexOf(" ");
                    }
                    break;

                }
                break;
                }
            }
            System.out.println(stroke.substring(0,i));
            stroke=stroke.substring(i+1);
           if(stroke.length()<k){//Если строка меньше чем ограничение для проверок с k, то вывожу
               System.out.println(stroke);
               break;
           }

        }
    }
    //Задание 2
    public static void split(String s){
        int countLeft=0,countRigth=0,i=0,preI=0;
        Stack<Character> skobki = new Stack<>();
        for (int j = 0; j < s.length(); j++) {
            if(i==0)
                System.out.print("'");
            if(s.charAt(j)=='('){
                i++;
                skobki.push(s.charAt(j));
                System.out.print(s.charAt(j));
            }else{
                if(s.charAt(j)==')'){
                    i--;
                    skobki.pop();
                    System.out.print(')');
                }
            }
        }
        System.out.print("'");

    }
    //Задание 3
    public static void toCamelCase (String s){
        String[] subStr;
        subStr = s.split("_");
        System.out.print(subStr[0]);
        char buf;
        String bufer;
        for(int i = 1; i < subStr.length; i++) {
            buf= (char) (subStr[i].charAt(0)-32);
            System.out.print(buf+subStr[i].substring(1));

        }
    }
    public static void toSnakeCase (String s){
        char[] chars = s.toCharArray();

        int indexForSnake=0;
        int i=0;

        for (int j = 0; j < chars.length; j++) {
            if(chars[j]>=65 && chars[j]<=90)
                indexForSnake++;
        }
        char[] newChars= new char [s.length()+indexForSnake];
        char buf;
        int j=0,f=0;
        for (int k = 0; k <newChars.length -f; k++) {
            if(chars[k]>=65 && chars[k]<=90){
                        newChars[k]='_';
                        k++;
                        f++;
                        newChars[k]=(char)(chars[k-f]+32);


            }else{
                newChars[k]=chars[k-f];

            }

        }

        for (int k = 0; k < newChars.length; k++) {
            System.out.print(newChars[k]);
        }
        System.out.print(chars[chars.length-1]);

    }

    //Задание 4
    public static double overTime(double s, double d, double fa, double ka) {
        double loe = 0;
        for(double i = s; i < 17; i++) {
            loe =loe+ fa;
        }
        if(d > 17) {
            for(double i = 17; i < d; i++) {
                loe+= (fa * ka);
            }
        }
        return loe;
    }
    //Задание 5
    public static String BMI(String weight, String height) {
        String[] weightArr = weight.split(" ");
        String[] heightArr = height.split(" ");

        double weightInKG = (weightArr[1].equals("kilos")) ? Double.parseDouble(weightArr[0])
                : Double.parseDouble(weightArr[0])*0.453592;
        double heightInM = (heightArr[1].equals("meters")) ? Double.parseDouble(heightArr[0])
                : Double.parseDouble(heightArr[0])*0.0254;
        double valueBMI = Math.round(weightInKG / Math.pow(heightInM, 2.0) * 10) / 10.0;

        return (valueBMI < 18.5) ? valueBMI + " Underweight" :
                (valueBMI < 24.9) ? valueBMI + " Normal weight" :
                        (valueBMI < 29.9) ? valueBMI + " Overweight" : valueBMI + " Obesity";
    }
    //Задание 6
    public static int bugger(int num) {
        int p = num;
        int n = 0;
        while (p> 9) {
            p= 1;
            while (num > 0) {
                p *= num % 10;
                num /= 10;
            }
            num = p;
            n++;
        }

        return n;


    }
    //Задание 7
    public static String toStarShorthand(String str) {
        String m="";
        for(int i=0;i<str.length();i++){
            int c=1;
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i)==str.charAt(j)) {
                    i++;
                    c++;}

            }
            if(c>1) m+=str.charAt(i)+"*"+Integer.toString(c);
            else m+=str.charAt(i);
        }
        return m;
    }

    //Задание 8
    public static boolean doesRhyme(String s1, String s2) {
        String first= "";
        String second = "";
        String s3 = s1.toLowerCase();
        String s4 = s2.toLowerCase();
        s1 = s3.replaceAll("[.,!;:]", "");
        s2 = s4.replaceAll("[.,!;:]", "");
        for(int i = s1.length()-1; i > 0; i--) {
            if(s1.charAt(i) != ' ') {
                if(s1.charAt(i) == 'a' || s1.charAt(i) == 'o' || s1.charAt(i) == 'i' || s1.charAt(i) == 'e' || s1.charAt(i) == 'u')
                    first += s1.charAt(i);
            }
            else
                break;
        }
        for(int i = s2.length()-1; i > 0; i--) {
            if(s2.charAt(i) != ' ') {
                if(s2.charAt(i) == 'a' || s2.charAt(i) == 'o' || s2.charAt(i) == 'i' || s2.charAt(i) == 'e' || s2.charAt(i) == 'u')
                    second += s2.charAt(i);
            }
            else
                break;
        }
        if(first.equals(second))
            return true;
        else
            return false;
    }
    //Задание 9
    public static boolean trouble(int num1, int num2) {
        String slovo = String.valueOf(num1);
        String s1 = "";
        for(int i = 0; i < slovo.length() - 2; i++ ) {
            if(slovo.charAt(i) == slovo.charAt(i+1) && slovo.charAt(i+1) == slovo.charAt(i+2)) {
                s1 += slovo.charAt(i);
                s1 += slovo.charAt(i+1);
                s1 += slovo.charAt(i+2);
                break;
            }
        }
        slovo = String.valueOf(num2);
        char s2 = s1.charAt(0);
        for(int i = 0; i < slovo.length() - 1; i++) {
            if(slovo.charAt(i) == s2) {
                if(slovo.charAt(i) == slovo.charAt(i+1)) {
                    return true;

                }
            }
        }
        return false;
    }
    //Задание 10
    public static int countUniqueBooks(String str, char bookend) {
        HashSet s=new HashSet();
        boolean betweenBookEnds=false;
        for (char act:str.toCharArray()) {
            if (act==bookend)
                betweenBookEnds=betweenBookEnds?false:true;
            else
            if (betweenBookEnds)
                s.add(act);
        }
        return s.size();
    }

}
