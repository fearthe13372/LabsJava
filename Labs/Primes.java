package Labs;
// Простые числа
public class Primes {
    public static void main(String[] args) {
        boolean s;
        for (int i = 2; i < 100; i++) {
            s=isPrime(i);
            if(s){
                System.out.print(i+" ");
            }

        }

    }
    //Метод для поиска простых чисел
    public static boolean isPrime(int n) {
        Boolean ansver=false;
            if (n==2 || n==3 || n==5 || n==7){
                ansver= true;
            }
            else{
                if (n%2!=0 && n%3!=0 && n%5!=0 && n%7!=0){
                    ansver=true;
                }
                else{
                    ansver=false;
                }
            }


        return ansver;
    }
}
