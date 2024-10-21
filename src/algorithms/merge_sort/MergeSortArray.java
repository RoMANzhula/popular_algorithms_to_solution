package algorithms.merge_sort;

import java.util.Arrays;

public class MergeSortArray {
    
    public static void main(String[] args) {
        int[] notSortArray = {12, 7, 11, 4, 7, 10, 2};

        System.out.print("It's our NOT SORTED array: ");
        System.out.println(Arrays.toString(notSortArray));
        
        mergeSort(notSortArray, 0, notSortArray.length - 1);

        System.out.print("It's our SORTED array: ");
        System.out.println(Arrays.toString(notSortArray));
        
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
    
}

// Merge Sort is used because of its stability and efficiency for large data, as it has O9n log n) complexity.

//When to use:
//- When you need stable and efficient sorting with O(n log n) time complexity, especially for large datasets.
//- When working with arrays or lists that are important to split into pieces and merge back.
//Example tasks:
//- Sorting large arrays or lists.
//- Tasks where stable sorting is required (preserving the order of equal elements).


// Merge Sort використовується через його стабільність і ефективність для великих даних, оскільки
// має складність O(n log n).

//Коли використовувати:
//- Коли потрібно стабільне та ефективне сортування з часовою складністю O(n log n), особливо для великих наборів даних.
//- При роботі з масивами або списками, які важливо розбити на частини та зливати назад.
//Приклад задач:
//- Сортування великих масивів чи списків.
//- Задачі, де потрібно стабільне сортування (збереження порядку рівних елементів).
//Часова складність: O(n log n).