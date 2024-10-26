package algorithms.depth_first_search;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchInUndirectedGraph {

    public static void main(String[] args) {

        int vertices = 5; // for example create 5 vertices

        //adjacency list for a graph (список суміжності)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges to the graph (undirected graph)
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(2).add(0);
        graph.get(2).add(4);
        graph.get(3).add(1);
        graph.get(4).add(2);

        // array for saving visited vertices
        boolean[] visitedVertices = new boolean[vertices];

        // create a DFS starting at vertex 0
        DepthFirstSearchInUndirectedGraph solution = new DepthFirstSearchInUndirectedGraph();
        System.out.print("Here DFS graph traversal: ");
        solution.depthFirstSearch(0, visitedVertices, graph); // output: 0 1 3 2 4

    }

    public void depthFirstSearch(int node, boolean[] visitedVertices, List<List<Integer>> graph) {
        visitedVertices[node] = true; // mark first vertex as visited
        System.out.print(node + " ");

        //recursively visit all the neighbors of this node
        for (int neighbor : graph.get(node)) {
            if (!visitedVertices[neighbor]) {
                depthFirstSearch(neighbor, visitedVertices, graph);
            }
        }

    }
}

//Пошук у глибину (Depth First Search, DFS) — це алгоритм обходу або пошуку в графі або дереві, що
// досліджує якнайглибші вузли перед тим, як переміститися до сусідніх.

//Коли використовувати DFS:
//- Пошук у лабіринті: коли потрібно знайти шлях до кінця або перевірити, чи існує шлях.
//- Перевірка зв'язності компонентів: DFS може допомогти знайти всі вузли, які належать до однієї компоненти зв’язності.
//- Обхід дерева: у випадку з деревами DFS використовується для обхідних стратегій, таких як префіксний (preorder),
// постфіксний (postorder) і інфіксний (inorder) обходи.
//- Задачі на топологічне сортування: в орієнтованих ациклічних графах DFS можна використовувати для
// топологічного сортування.
//- Пошук циклів у графах: можна використовувати DFS для перевірки наявності циклів у графі.
//Складність:
//Часова складність: O(V + E), де V — кількість вершин, а E — кількість ребер.
//Просторова складність: O(V) для зберігання стану відвіданих вершин та рекурсивного стеку.


//Depth First Search (DFS) is a graph or tree traversal or search algorithm that explores the deepest
// possible nodes before moving to the nearest ones.

//When to use DFS:
//- Maze search: when you need to find a path to the end or check if a path exists.
//- Checking component connectivity: DFS can help find all nodes that belong to the same connectivity component.
//- Tree traversal: In the case of trees, DFS is used for traversal strategies such as prefix (preorder),
// postfix (postorder) and infix (inorder) traversals.
//- Topological sorting problems: in directed acyclic graphs DFS can be used for
// topological sorting.
//- Searching for cycles in graphs: You can use DFS to check for cycles in a graph.
//Complexity:
//Time complexity: O(V + E), where V is the number of vertices and E is the number of edges.
//Space complexity: O(V) for storing state of visited vertices and recursive stack.

