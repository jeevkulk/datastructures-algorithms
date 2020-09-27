package algorithm.series;

public class Fibonacci {

    public void fibo(int n) {
        if (n <= 0) {
            return;
        }
        int lastNum1 = 1;
        int lastNum2 = 1;
        System.out.print(lastNum1 +"," + lastNum2 + ",");
        for (int i = 2; i < n; i++) {
            int temp = lastNum2;
            lastNum2 = lastNum1 + lastNum2;
            System.out.print(lastNum2 + ",");
            lastNum1 = temp;
        }
    }

    public static void main(String[] args) {
        Fibonacci sparkDemo = new Fibonacci();
        sparkDemo.fibo(10);
    }
}
