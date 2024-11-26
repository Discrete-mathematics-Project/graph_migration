package graphsearch;

import java.util.ArrayList;

public class Dfs {
    private ArrayList<Integer> traversalOrder;//탐색 결과를 저장하는 배열 선언

    public Dfs() {
        traversalOrder = new ArrayList<>();
    }

    public void dfs(Integer[][] graph, int startNode) {
        boolean[] visited = new boolean[graph.length];
        traversalOrder.clear(); // 이전 탐색 결과 초기화
        dfsUtil(graph, startNode, visited);// 탐색 시작
        System.out.println("깊이 우선 탐색" +"\n"+ formatTraversal());//깊이 우선 탐색 결과를 출력하는 코드
    }

    private void dfsUtil(Integer[][] graph, int currentNode, boolean[] visited) {
        visited[currentNode] = true;//방문한 노드인지 확인하는 코드
        traversalOrder.add(currentNode + 1); // 탐색 순서에 추가 (노드 번호는 1부터)

        for (int i = 0; i < graph.length; i++) {
            if (graph[currentNode][i] != Integer.MAX_VALUE && !visited[i]) {//그래프 탐색 재귀적 방식을 사용해서 깊이 우선 탐색을 수행함
                dfsUtil(graph, i, visited);
            }
        }
    }

    private String formatTraversal() {
        return String.join(" – ", traversalOrder.stream().map(String::valueOf).toArray(String[]::new));
    }
    //main함수 입력예시
    /*
     public static void main(String[] args) {
        System.out.println("----------------------------");
        FileRead fileRead = new FileRead("files/input1.txt");
        DFS dfs = new DFS();
        if (!fileRead.capacity.isEmpty()) {
            dfs.dfs(fileRead.capacity.get(0), 0);
        } else {
            System.out.println("그래프 데이터가 없습니다.");
        }
    }
     */
}