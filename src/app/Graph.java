package app;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> graph;

    // Конструктор
    public Graph() {
        graph = new HashMap<>();
    }

    // Метод для додавання вершини
    public void addVertex(int vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ArrayList<>());
        } else {
            System.out.println("Вершина " + vertex + " вже існує у графі.");
        }
    }

    // Метод для додавання ребра
    public void addEdge(int source, int destination) {
        graph.putIfAbsent(source, new ArrayList<>());
        graph.putIfAbsent(destination, new ArrayList<>());

        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    // Метод для видалення вершини
    public void removeVertex(int vertex) {
        if (graph.containsKey(vertex)) {
            for (int neighbor : graph.get(vertex)) {
                graph.get(neighbor).remove((Integer) vertex);
            }
            graph.remove(vertex);
        } else {
            System.out.println("Вершини " + vertex + " немає у графі.");
        }
    }

    // Метод для видалення ребра
    public void removeEdge(int source, int destination) {
        if (graph.containsKey(source)) {
            graph.get(source).remove((Integer) destination);
        }
        if (graph.containsKey(destination)) {
            graph.get(destination).remove((Integer) source);
        }
    }

    // Метод для перевірки існування вершини
    public boolean hasVertex(int vertex) {
        return graph.containsKey(vertex);
    }

    // Метод для перевірки існування ребра
    public boolean hasEdge(int source, int destination) {
        return graph.containsKey(source) && graph.get(source).contains(destination);
    }

    // Метод для відображення графа
    public void display() {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Головний метод для демонстрації роботи графа
    public static void main(String[] args) {
        Graph g = new Graph();

        // Додаємо вершини
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);

        // Додаємо ребра
        g.addEdge(1, 2);
        g.addEdge(2, 3);

        // Виводимо граф
        System.out.println("Граф після додавання вершин та ребер:");
        g.display();

        // Перевіряємо існування вершин та ребер
        System.out.println("Чи існує вершина 2? " + g.hasVertex(2));
        System.out.println("Чи існує вершина 4? " + g.hasVertex(4));
        System.out.println("Чи існує ребро між 1 та 2? " + g.hasEdge(1, 2));
        System.out.println("Чи існує ребро між 1 та 3? " + g.hasEdge(1, 3));

        // Видаляємо вершину
        g.removeVertex(2);
        System.out.println("Граф після видалення вершини 2:");
        g.display();

        // Видаляємо ребро
        g.removeEdge(1, 3);
        System.out.println("Граф після видалення ребра між 1 та 3:");
        g.display();
    }
}
