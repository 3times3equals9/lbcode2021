package study_week_4th;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class _자율주행전기차 {
	
	private static class Node implements Comparable<Node>{
		int r, c, dist;
		
		public Node(int r, int c, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
		
		//태울 승객을 고를 때는 현재 위치에서 최단거리가 가장 짧은 승객을 고른다. 
		//그런 승객이 여러 명이면 그중 행 번호가 가장 작은 승객을, 
		//그런 승객도 여러 명이면 그중 열 번호가 가장 작은 승객을 고른다. 
		@Override
		public int compareTo(Node o) {
			if(this.dist != o.dist) {
				return this.dist - o.dist;
			}else {
				if(this.r != o.r) {
					return this.r - o.r;
				}else {
					return this.c - o.c;
				}
			}
		}
		/**
		compareTo() 메서드 작성법 : 일케 하면 오름차순이네 
		현재 객체 < 파라미터로 넘어온 객체: 음수 리턴
		현재 객체 == 파라미터로 넘어온 객체: 0 리턴
		현재 객체 > 파라미터로 넘어온 객체: 양수 리턴
		음수 또는 0이면 객체의 자리가 그대로 유지되며, 양수인 경우에는 두 객체의 자리가 바뀐다.
		*/
	}
	
	private static class Info{
		//start, end
		int sr, sc, er, ec;
		public Info(int sr, int sc, int er, int ec) {
			super();
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
		}
	}
	
	static int N,M,fuel;
	static int[][] map;
	static boolean[][] visited;
	static int driver_r, driver_c; 
	static final int[] dr = {-1, 0, 1, 0};
	static final int[] dc = {0, 1, 0, -1};
	static ArrayList<Node> guest = new ArrayList<>();
	static ArrayList<Info> cust_list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		fuel = sc.nextInt();
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			for(int c=1; c<=N; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) {
					//1은 벽을 나타낸다. 근데 양의정수 사용해야해서, 벽은 -1로 바꾼다.
					map[r][c] = -1;
				}
			}
		}
		
		driver_r = sc.nextInt();
		driver_c = sc.nextInt();
		
		//손님 넘버링도 내가 해야함. 손님 번호관리는 1부터M까지로 
		for(int i=1; i<=M; i++) {
			int start_r = sc.nextInt();
			int start_c = sc.nextInt();
			int end_r = sc.nextInt();
			int end_c = sc.nextInt();
			cust_list.add(new Info(start_r, start_c, end_r, end_c));
			//맵에다가 손님 번호 적어주기.
			map[start_r][start_c] = i;
		}
		
		//문제풀이 시작
		while(true) {
			if(cust_list.size() == 0) {
				System.out.println(fuel);
				return;
			}
			
			guest.clear();
			visited = new boolean[N+1][N+1];
			
			get_cust(driver_r, driver_c); //가장 가까운 손님 찾기
			if(guest.size() == 0) { //벽에 의해서 못가거나, 승객을 못태울 경우...
				System.out.println(-1);
				return;
			}
			
			//get_cust 함수 돌리면, guest의 가장 첫번째 인덱스에 가장 가까운 손님 들어감
			Node a = guest.get(0);
			map[a.r][a.c] = 0;
			fuel -= a.dist; //기사 현재 위치에서 승객을 데리러 가는 연료 소비
			if(fuel < 0) { // 연료가 없으면 끝
				System.out.println(-1);
				return;
			}
			
			//승객의 위치에서 승객의 목적지까지 가는 과정
			int dist = 0;
			visited = new boolean[N+1][N+1];
			for(int i=0; i<cust_list.size(); i++) {
				Info info = cust_list.get(i);
				//손님 배열리스트에서 하나씩 꺼내서... 출발위치 같으면 해당 손님인걸로 판단...
				if(info.sr == a.r && info.sc ==a.c) {
					dist = get_dist(info.sr, info.sc, info.er, info.ec);
					if(dist == -1) {
						//목적지까지 못가는 경우가 생길수도 있구나...
						System.out.println(-1);
						return;
					}
					
					//이건 갈 수 있는 경우
					//갈수 있는거 찾으면, 도착지로 택시위치 변경하고
					//손님리스트에서 해당손님 지워줌
					//글고 반복문 나감
					driver_r = info.er;
					driver_c = info.ec;
					cust_list.remove(info);
					break;
				}
			}
			
			//여기까지 온거면 손님 태워 줬다는거임
			//기름빼자
			fuel -= dist;
			if(fuel <0) {
				System.out.println(-1);
				return;
			}
			
			//손님 태워다 주고 기름이 0보다 크면 , 재충전 가능
			fuel += dist*2;
		}
		
		//sc.close();
	}
	
	public static boolean isRange(int r, int c) {
		if(1<=r && r<=N && 1<=c && c<=N) {
			return true;
		}
		return false;
	}

	public static int get_dist(int cur_r, int cur_c, int end_r, int end_c) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(cur_r, cur_c, 0));
		
		while(!q.isEmpty()) {
			Node a = q.poll();
			if(a.r == end_r && a.c == end_c) {
				return a.dist;
			}
			for(int i=0; i<4; i++) {
				int nr = a.r + dr[i];
				int nc = a.c + dc[i];
				if(isRange(nr,nc) && !visited[nr][nc] && map[nr][nc] != -1) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, a.dist+1));
				}
			}
		}
		return -1;
	}
	
	//택시 위치 기준으로 가장 가까운 손님 계산.
	public static void get_cust(int r, int c) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(r, c, 0));
		
		while(!q.isEmpty()) {
			Node a = q.poll();
			if(map[a.r][a.c] >= 1) {
				//사람있는 칸인지 아닌지를 여기서 체크함..
				//그리고는 손님 배열에 넣고 끝내네... 뭐야 ㅡㅡ
				//이거 쓰면 guest ArrayList 에 가장 가까운 손님이 들어가게 됨.
				guest.add(new Node(a.r, a.c, a.dist));
				break;
			}
			
			for(int i = 0; i<4; i++) {
				int nr = a.r + dr[i];
				int nc = a.c + dc[i];
				if(isRange(nr, nc) && map[nr][nc] != -1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr, nc, a.dist+1));
				}
			}
			
		}
	}
}