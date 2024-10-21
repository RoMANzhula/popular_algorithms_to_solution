package algorithms.bynary_search;

public class FindNumberInSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7, 9};
        int target = 7;

        System.out.print("Here is the number we are looking for: ");
        System.out.print(binarySearch(nums, target));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else { //case where middle > target
                right = middle - 1;
            }
        }

        return -1;
    }

}

// We use binary search because the array is sorted, and binary search has logarithmic complexity O(log n), which
// allows us to quickly find elements.

//When to use:
//- When you want to find an element in a sorted array or range.
//- Tasks for searching where elements are in ascending or descending order.
//Example tasks:
//- Search for the index of the given number in the sorted array.
//- Search for the first or last occurrence of an element in an array.
//Time complexity: O(log n).


// Ми використовуємо бінарний пошук, оскільки масив відсортований, і бінарний пошук має логарифмічну
// складність O(log n), що дозволяє швидко знаходити елементи.

//Коли використовувати:
//- Коли потрібно знайти елемент у відсортованому масиві або діапазоні.
//- Задачі на пошук, де елементи в порядку зростання чи спадання.
//Приклад задач:
//- Пошук індексу заданого числа у відсортованому масиві.
//- Пошук першої або останньої появи елемента в масиві.
//Часова складність: O(log n).