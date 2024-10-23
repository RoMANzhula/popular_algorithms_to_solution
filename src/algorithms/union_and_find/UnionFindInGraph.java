package algorithms.union_and_find;

public class UnionFindInGraph {

    private int[] parent;
    private int[] rank;

    public UnionFindInGraph(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public static void main(String[] args) {
        UnionFindInGraph uf = new UnionFindInGraph(10);

        uf.union(1, 2);
        uf.union(2, 3);

        System.out.print("Our vertexes are a union. Is it so?: ");
        System.out.print(uf.find(1) == uf.find(3)); // true
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP != rootQ) {
            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
    }

    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }

        return parent[p];
    }

}

// Union-Find is suitable for tasks of finding connectivity components, such as determining whether two are connected
// vertices in the graph.

//When to use:
//For working with non-intersecting sets.
//In tasks for combining and finding components in graphs, where it is important to quickly check whether two belong
// elements to one set, and combine sets.
//Example tasks:
//Definition of cycles in the graph.
//Minimum spanning tree (MST) covering problem.


// Union-Find підходить для задач на знаходження компонент зв’язності, таких як визначення, чи з'єднані дві
// вершини в графі.

//Коли використовувати:
//Для роботи з непересічними множинами.
//У задачах на об'єднання та знаходження компонент в графах, де важливо швидко перевіряти, чи належать два
// елементи до однієї множини, і об'єднувати множини.
//Приклад задач:
//Визначення циклів у графі.
//Задача про мінімальне покриття остовним деревом (MST).


//Код реалізує структуру даних Union-Find (або Disjoint Set Union, DSU) з оптимізаціями шляхової компресії та
//об'єднанням за рангом. Вона дозволяє ефективно виконувати дві основні операції:
//Знаходження кореня множини для елемента.
//Об'єднання двох множин.

//Операції, які виконує Union-Find:
//find(int p) — знаходить кореневий елемент (представник множини) для елемента p. Якщо елемент p не є своїм
// власним коренем, застосовується шляхова компресія — це означає, що під час виконання операції find всі
// елементи на шляху до кореня будуть безпосередньо пов'язані з коренем, що значно прискорює наступні
// виклики цієї операції.
//union(int p, int q) — об'єднує дві множини, в яких знаходяться елементи p і q. Спочатку знаходяться корені
// для p та q за допомогою операції find. Потім використовуються оптимізації за допомогою рангу: корінь із
// вищим рангом стає коренем об'єднаної множини. Якщо ранги однакові, один з коренів стає коренем, і
// його ранг збільшується.
//
//Основні складові:
//Масив parent[]: цей масив зберігає для кожного елемента індекс його батьківського елемента. Якщо індекс
// елемента в масиві збігається з його значенням, то цей елемент є коренем (представником) своєї множини.
//Масив rank[]: масив рангу відображає висоту дерева для кожного кореневого елемента. Це використовується
// для мінімізації висоти дерева під час об'єднання.
//
//Пояснення коду:
//Конструктор UnionFind(int size):
//Ініціалізує масиви parent і rank. Спочатку кожен елемент є коренем сам для себе, тому parent[i] = i.
//Ранги на початку всі дорівнюють 0.
//Операція find(int p):
//Якщо parent[p] != p, це означає, що елемент p не є коренем своєї множини. Тоді ми рекурсивно шукаємо
// корінь для p, і при цьому виконується шляхова компресія — кожен елемент на шляху до кореня пов'язується
// безпосередньо з коренем для прискорення наступних викликів find.
//Операція union(int p, int q):
//Спочатку знаходить корені для елементів p і q.
//Якщо корені різні, то ми об'єднуємо їх, порівнюючи ранги. Елемент із більшим рангом стає коренем для
// іншого елемента. Якщо ранги рівні, один з них стає коренем, і його ранг збільшується на 1.