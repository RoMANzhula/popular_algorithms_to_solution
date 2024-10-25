package algorithms.recursion;

public class CalculateNumberFactorial {
    public static void main(String[] args) {
        CalculateNumberFactorial solution = new CalculateNumberFactorial();

        int number = 5; // we will have get next 5 * 4 = 20 * 3 = 60 * 2 = 120 * 1 = 120
        int number2 = 4; // 4 * 3 = 12 * 2 = 24 * 1 = 24

        System.out.print("Here factorial of our number _" + number + "_: ");
        System.out.println(solution.getFactorial(number));
    }

    public long getFactorial(int number) {
        if (number == 0) return 1;

        long result = number * getFactorial(number - 1);

        return result;
    }

}

// Рекурсія підходить для задач з природною рекурсивною структурою, як обчислення факторіалу або робота з деревами.

//Коли використовувати:
//- Для задач із природною рекурсивною структурою або коли алгоритм можна розбити на підзадачі з однаковою логікою.
//- Коли є завдання з деревами, графами або комбінаторикою.
//Приклад задач:
//- Обхід дерева або графа (DFS).
//- Обчислення факторіалу або чисел Фібоначчі.
//Часова складність: Залежить від задачі, рекурсивні рішення часто мають високу складність, якщо їх
// не оптимізувати через мемоізацію (у динамічному програмуванні).


// Recursion is suitable for tasks with a natural recursive structure, such as computing factorials or
// working with trees.

//When to use:
//- For problems with a natural recursive structure or when the algorithm can be broken down into
// subproblems with the same logic.
//- When there are problems with trees, graphs or combinatorics.
//Example tasks:
//- Tree or graph traversal (DFS).
//- Calculation of factorial or Fibonacci numbers.
//Time complexity: Depends on the problem, recursive solutions often have high complexity, if any
// do not optimize due to memoization (in dynamic programming).