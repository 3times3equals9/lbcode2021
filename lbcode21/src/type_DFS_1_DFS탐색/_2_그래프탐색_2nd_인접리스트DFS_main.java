package type_DFS_1_DFS탐색;

import java.util.ArrayList;
import java.util.Scanner;

public class _2_그래프탐색_2nd_인접리스트DFS_main {
	
	static final int MAX_NUM = 100;
	static int n, m;
	static int vertex_cnt;
	
	// index를 1번 부터 사용하기 위해 MAX_NUM+1만큼 할당합니다.
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	static void DFS(int vertex) {
	    // 해당 정전에서 이어져있는 모든 정점을 탐색해줍니다.
	    for(int i = 0; i < (int) graph[vertex].size(); i++){
	        int curr_v = graph[vertex].get(i);
	        if(!visited[curr_v]) {
	            // 아직 방문한 적이 없는 정점에 대해서만 탐색을 진행합니다.
	            visited[curr_v] = true;
	            vertex_cnt++;
	            DFS(curr_v);
	        }
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// index를 1번 부터 사용하기 위해 MAX_NUM+1만큼 할당합니다.
//		vector<int> graph[MAX_NUM + 1];
//		bool visited[MAX_NUM + 1];
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList[n+1];
		for(int i=0; i<n+1; i++) {
			graph[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		
		int v1, v2;
	    for(int i = 0; i < m; i++) {
	        // 각 정점이 서로 이동이 가능한 양방향 그래프이기 때문에
	        // 각 정점에 대한 간선을 각각 저장해줍니다.
	        v1 = sc.nextInt();
	        v2 = sc.nextInt();
	        graph[v1].add(v2);
	        graph[v2].add(v1);
	    }
		
	    vertex_cnt = 0;
	    
	    visited[1] = true;
	    DFS(1);
	    
	    System.out.println(vertex_cnt);
	    
		sc.close();
	}
}









































































