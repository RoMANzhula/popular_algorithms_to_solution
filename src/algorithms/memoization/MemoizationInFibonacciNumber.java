package algorithms.memoization;

import java.util.HashMap;

public class MemoizationInFibonacciNumber {

    private HashMap<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        MemoizationInFibonacciNumber solution = new MemoizationInFibonacciNumber();

        System.out.println(solution.getFibonacciNumber(10)); // output 55
    }

    public int getFibonacciNumber(int number) {
        if (number <= 1) return number;

        if (memo.containsKey(number)) {
            return memo.get(number); // get from cash
        }

        // formula F(i)=F(i−1)+F(i−2) for n≥2
        int result = getFibonacciNumber(number - 1) + getFibonacciNumber(number - 2);

        memo.put(number, result); // save to cash

        return result;
    }

}


//Мемоізація — це техніка, що використовується для оптимізації рекурсивних алгоритмів, запам'ятовуючи результати
// обчислень. Якщо один і той самий рекурсивний виклик повторюється з однаковими параметрами, результат цього
// виклику не буде обчислюватися вдруге, а одразу дістанеться з пам’яті (кешу).


//Memoization is a technique used to optimize recursive algorithms by memorizing the results of
// calculations. If the same recursive call is repeated with the same parameters, the result of this call
// will not be calculated a second time, but will be immediately retrieved from memory (cache).