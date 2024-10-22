package algorithms.reverse_string;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        String str = "hello";
        System.out.print("Our string: ");
        System.out.println(str);

        System.out.print("Here our reverse string: ");
        System.out.print(solution.getReverseString(str));
    }

    public String getReverseString(String str) {
        char[] charsArray = str.toCharArray();
        int left = 0;
        int right = charsArray.length - 1;

        while (left < right) {
            char temp = charsArray[left];
            charsArray[left] = charsArray[right];
            charsArray[right] = temp;

            left++;
            right--;
        }

        return  new String(charsArray);
    }

}

//Reverse string sorting (Reverse String)

//When to use:
//- For simple tasks to work with strings, where you need to change the order of characters.
//- Tasks related to palindrome checking or other string manipulations.
//Example tasks:
//- Check if a string is a palindrome.
//- String formatting tasks.


//Зворотне сортування рядка (Reverse String)

//Коли використовувати:
//- Для простих задач на роботу з рядками, де потрібно змінити порядок символів.
//- Задачі, пов’язані з перевіркою паліндромів або іншими маніпуляціями над рядками.
//Приклад задач:
//- Перевірка, чи є рядок паліндромом.
//- Задачі на форматування рядків.