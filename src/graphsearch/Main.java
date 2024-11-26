package graphsearch;

import graphsearch.Bfs;
import graphsearch.Dfs;
import graphsearch.Dijkstra;
import graphsearch.FileRead1;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. 최단 경로 구하기 수행 결과");

        FileRead1 fileRead = new FileRead1("files/input1.txt");
        String input1Path = "files/input1.txt";
        FileRead1 fileRead1 = new FileRead1(input1Path);
        Dfs dfs = new Dfs();
        for (int i = 0; i < fileRead.capacity.size(); i++) {
            System.out.println("그래프 ["+(i+1)+"]");
            System.out.println("----------------------------");
            dfs.dfs(fileRead.capacity.get(i), 0); // 0번 노드에서 시작
            Integer[][] graph = fileRead1.capacity.get(i);
            // BFS 수행
            Bfs bfs = new Bfs(graph);
            bfs.performBFS(0); // 시작 정점 1 (0 인덱스)
            System.out.println("=========================");
            System.out.println();
        }

        FileRead2 fileRead2 = new FileRead2("files/input2.txt");

        System.out.println("2. 최단 경로 구하기 수행 결과");

        for (int i = 0; i < fileRead2.capacity.size(); i++) {
            Integer[][] graph = fileRead2.capacity.get(i);
            Dijkstra dijkstra = new Dijkstra(graph);
            System.out.println("\n그래프 [" + (i + 1) + "]");
            System.out.println("----------------------------");
            dijkstra.findShortestPaths(0); // 시작 정점 1 (0번 인덱스)
            System.out.println("=========================");
        }
    }
}