package algorithms.dynamic_programming;

public class CalculateFibonacciNumber {

    public static void main(String[] args) {
        CalculateFibonacciNumber solution = new CalculateFibonacciNumber();

        System.out.print("Here calculated Fibonacci Number: ");
        System.out.print(solution.getFibNumber(10)); // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
    }

    public int getFibNumber(int number) {
        if (number <= 1) return number;

        int[] dpAsResult = new int[number + 1];

        dpAsResult[0] = 0;
        dpAsResult[1] = 1;

        for (int i = 2; i <= number; i++) {
            // We use formula F(i)=F(i−1)+F(i−2) for n≥2
            dpAsResult[i] = dpAsResult[i - 1] + dpAsResult[i - 2];
        }

        return dpAsResult[number];
    }

}


//Використовуємо динамічне програмування, щоб зменшити кількість обчислень завдяки збереженню попередніх результатів.

//Коли використовувати:
//- Для задач із підзадачами, які повторюються.
//- Коли задача має властивість оптимальної підструктури (оптимальний розв'язок можна побудувати з оптимальних
// розв'язків підзадач).
//Приклад задач:
//- Задачі на знаходження найдовшої підпослідовності або підрядка (LCS, LIS).
//- Шлях з мінімальною сумою у матриці.
//Часова складність: Залежить від задачі, але часто O(n^2) або O(n*m).


//Use dynamic programming to reduce the number of calculations by saving previous results.

//When to use:
//- For tasks with repeating subtasks.
//- When the problem has the property of an optimal substructure (an optimal solution can be constructed from optimal
// solutions of subproblems).
//Example tasks:
//- Problems for finding the longest subsequence or substring (LCS, LIS).
//- The path with the minimum sum in the matrix.
//Time complexity: Depends on the problem, but often O(n^2) or O(n*m).