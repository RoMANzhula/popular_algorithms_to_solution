package algorithms.dijkstra_shorter_way;

import java.util.Arrays;

public class FindShorterWayInGraph {

    public static void main(String[] args) {
        FindShorterWayInGraph solution = new FindShorterWayInGraph();

        int[][] graph = {
                {0, 10, 0, 0, 0, 0},
                {10, 0, 5, 0, 0, 0},
                {0, 5, 0, 1, 0, 0},
                {0, 0, 1, 0, 4, 2},
                {0, 0, 0, 4, 0, 6},
                {0, 0, 0, 2, 6, 0}
        };

        int[] distance = solution.dijkstra(graph, 0);

        System.out.print("Here our shorter way in Graph as array: ");
        System.out.print(Arrays.toString(distance));
    }

    public int[] dijkstra(int[][] graph, int src) {
        int vertexCount = graph.length;
        int[] distance = new int[vertexCount];
        boolean[] visited = new boolean[vertexCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < vertexCount - 1; i++) {
            int vertexU = minDistance(distance, visited);
            visited[vertexU] = true;

            for (int vertexV = 0; vertexV < vertexCount; vertexV++) {
                if (!visited[vertexV] && graph[vertexU][vertexV] != 0 && distance[vertexU] != Integer.MAX_VALUE &&
                    distance[vertexU] + graph[vertexU][vertexV] < distance[vertexV])
                {
                    distance[vertexV] = distance[vertexU] + graph[vertexU][vertexV];
                }
            }
        }

        return distance;
    }

    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int vertex = 0; vertex < distance.length; vertex++) {
            if (!visited[vertex] && distance[vertex] <= min) {
                min = distance[vertex];
                minIndex = vertex;
            }

        }

        return minIndex;
    }

}


// Dijkstra's algorithm is used to find the shortest path in graphs with non-negative weights.

//When to use:
//- For finding the shortest path in graphs with integral edge weights.
//- If the graph has real or integer edge weights and you are looking for the shortest path from one vertex to the others.
//- In tasks such as routing in networks, finding the shortest path between cities on the map, and others.
//Example tasks:
//- Problems with transport routes.
//- Finding the shortest path in networks.
//Time complexity: O(V^2) or O(E log V) (using a priority queue).

// In our code, here are the cells that were summed:
//
//Distance to vertex 1:
// 0 + 10 (from cell [0][1])
//Distance to vertex 2:
// 10 + 5 (from cell [1][2])
//Distance to vertex 3:
// 15 + 1 (from cell [2][3])
//Distance to vertex 4:
// 16 + 4 (from cell [3][4])
//Distance to vertex 5:
// 16 + 2 (from cell [3][5])

// Алгоритм Дейкстри використовується для знаходження найкоротшого шляху в графах з не-негативними вагами.

//Коли використовувати:
//- Для знаходження найкоротшого шляху в графах з невід'ємними вагами ребер.
//- Якщо граф має реальні або цілочислові ваги ребер і ви шукаєте найкоротший шлях від однієї вершини до інших.
//- В задачах, таких як маршрутизація в мережах, пошук найкоротшого шляху між містами на карті, та інші.
//Приклад задач:
//- Задачі з транспортними маршрутами.
//- Пошук найкоротшого шляху у мережах.
//Часова складність: O(V^2) або O(E log V) (з використанням черги з пріоритетом).


//Схема графа
//Давайте позначимо вершини графа від 0 до 5. Тоді матриця сусідства виглядає так:
//
//lua
//Копіювати код
//       0   1   2   3   4   5
//    +-------------------------+
//  0 |  0  10   0   0   0   0  | 0
//  1 | 10   0   5   0   0   0  | 1
//  2 |  0   5   0   1   0   0  | 2
//  3 |  0   0   1   0   4   2  | 3
//  4 |  0   0   0   4   0   6  | 4
//  5 |  0   0   0   2   6   0  | 5
//Пояснення
//Вершина 0:
//
//Вага до 1: 10
//Немає ребер до 2, 3, 4, 5
//Вершина 1:
//
//Вага до 0: 10
//Вага до 2: 5
//Немає ребер до 3, 4, 5
//Вершина 2:
//
//Вага до 1: 5
//Вага до 3: 1
//Немає ребер до 0, 4, 5
//Вершина 3:
//
//Вага до 2: 1
//Вага до 4: 4
//Вага до 5: 2
//Вершина 4:
//
//Вага до 3: 4
//Вага до 5: 6
//Немає ребер до 0, 1, 2
//Вершина 5:
//
//Вага до 3: 2
//Вага до 4: 6
//Немає ребер до 0, 1, 2
//Графічне представлення
//Граф можна уявити у вигляді діаграми:
//
//scss
//Копіювати код
//   (0)---10---(1)
//          |
//          5
//          |
//         (2)---1---(3)
//                |   /  \
//                4  2    6
//                |/       |
//               (4)----- (5)
//Утворення графа
//Граф утворюється на основі матриці, де:
//
//Кожен індекс масиву відповідає вершині графа.
//Значення в масиві вказують на вагу ребра між цими вершинами. Наприклад, вага 10 між вершинами 0 та 1 означає,
// що існує ребро з вагою 10 між цими двома вершинами.
//Наявність нульового значення вказує на відсутність ребра між вершинами.
//Таким чином, за допомогою цієї матриці можна моделювати та досліджувати властивості графа, наприклад,
// знаходити найкоротші шляхи, перевіряти зв’язність графа тощо.

// В нашому коді ось які ячейки були сумовані:
//
//Відстань до вершини 1:
//  0 + 10 (з ячейки [0][1])
//Відстань до вершини 2:
//  10 + 5 (з ячейки [1][2])
//Відстань до вершини 3:
//  15 + 1 (з ячейки [2][3])
//Відстань до вершини 4:
//  16 + 4 (з ячейки [3][4])
//Відстань до вершини 5:
//  16 + 2 (з ячейки [3][5])