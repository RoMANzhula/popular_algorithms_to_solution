package algorithms.breadth_first_search;

import java.util.LinkedList;

public class BreadthFirstSearchForUndirectedGraph {

    private int numVertices;
    private LinkedList<Integer>[] adjacencyList;

    public BreadthFirstSearchForUndirectedGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < numVertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        // create graph with 6 vertices
        BreadthFirstSearchForUndirectedGraph solution = new BreadthFirstSearchForUndirectedGraph(6);

        //add edges between vertices
        solution.addEdge(0, 1);
        solution.addEdge(0, 2);
        solution.addEdge(1, 3);
        solution.addEdge(1, 4);
        solution.addEdge(2, 4);
        solution.addEdge(3, 5);
        solution.addEdge(4, 5);

        // call a BreadthFirstSearch starting at the vertex 0
        solution.breadthFirstSearch(0); // output 0 1 2 3 4 5

    }

    public void addEdge(int u, int v) {
        adjacencyList[u].add(v);
        adjacencyList[v].add(u); //since the graph is undirected, we add u to the list v
    }

    public void breadthFirstSearch(int startVertex) {
        boolean[] visitedVertices = new boolean[numVertices];
        LinkedList<Integer> queueToBypass = new LinkedList<>();

        // starting from the "start" vertex
        visitedVertices[startVertex] = true;
        queueToBypass.add(startVertex);

        System.out.println("BFS (Breath First Search) starting from the vertex " + startVertex + ":");

        while (!queueToBypass.isEmpty()) {
            int currentVertex = queueToBypass.poll(); // taking out the vertex from the queue of bypass vertices
            System.out.print(currentVertex + " ");

            //get all adjacent vertices currentVertex
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visitedVertices[neighbor]) { // if not visited
                    visitedVertices[neighbor] = true; // mark it as visited
                    queueToBypass.add(neighbor);
                }
            }
        }
    }
}


//Explanation:
//Creating a graph: We create a graph from 6 vertices. Each vertex has a list of neighbors that are
// connected to it by edges.
//Queue: For traversal, we use a queue, which allows you to pass all nodes at the same level before
// go to next level nodes.
//Array visited: To mark which nodes we have already visited, the Boolean array visited is used.
//Algorithm: BFS starts from the initial vertex (start), adds it to the queue and marks it as visited. Thereafter
// goes through each of its neighbors in turn and continues traversal at the level of the next nodes.

//When to use BFS:
//- Finding the shortest path in unweighted graphs.
//- Traversal of the graph by levels, when it is important to see all the nodes of one level before moving to another.
//- Checking the connectivity of components in the graph.
//BFS is also often used in such tasks as mazes, search in games, graph tasks
// to calculate minimum distances, etc.


//Пояснення:
//Створення графа: Ми створюємо граф із 6 вершин. Кожна вершина має список сусідів, які з’єднані з нею ребрами.
//Черга: Для обходу використовуємо чергу (queue), яка дозволяє проходити всі вузли на одному рівні перед тим, як
// перейти до вузлів наступного рівня.
//Масив visited: Для відмітки, які вузли ми вже відвідали, використовується булевий масив visited.
//Алгоритм: BFS починає з початкової вершини (start), додає її у чергу та позначає як відвідану. Після цього
// по черзі проходить кожного її сусіда і продовжує обхід на рівні чергових вузлів.

//Коли використовувати BFS:
//- Пошук найкоротшого шляху в невагових графах.
//- Обхід графа рівнями, коли важливо побачити всі вузли одного рівня перед переходом до іншого.
//- Перевірка зв'язності компонентів у графі.
//BFS також часто використовується у таких задачах як лабіринти, пошук в іграх, графові задачі
// на підрахунок мінімальних відстаней тощо.