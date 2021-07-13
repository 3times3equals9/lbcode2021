package study_week_5th;

import java.util.*;
import java.io.*;

public class _승자독식모노폴리 {

	//각 상어의 방향이 차례대로 주어진다. 1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
	static class Shark {
		int id, r, c, dir;
		int[][] priority = new int[5][5];
		
		Shark() { }
		
		int findNextDir(Set<Integer> candidates) {
			//우선순위에 따라서 1번부터 검사.
			for(int i=1; i<5; i++) {
				if(candidates.contains(priority[dir][i])) {
					return priority[dir][i];
				}
			}
			return 0;
		}
	}
	
	//첫 줄에는 N, M, k가 주어진다. (2 ≤ N ≤ 20, 2 ≤ M ≤ N2, 1 ≤ k ≤ 1,000)
	static int N, M, k;
	/**
	 arr, smellOwner, leftTime 각각 상어의 위치, 냄새의 주인, 냄새들의 남은 시간을 기록한 2 차원 배열입니다.
	 (아마도 arr이라고 쓴 이유는, 자료구조 이름 맵이랑 헷갈리지 않기 위해서 이렇게 한 듯)
	 */
	static int[][] arr = new int[21][21];
	static int[][] smellOwner = new int[21][21];
	static int[][] leftTime = new int[21][21];
	//상어번호로 상어정보(객체)불러오는게 편하니까 연관배열, 해시맵 사용!!!
	static Map<Integer, Shark> sharks = new HashMap<>();
	static int time = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		/** input */
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		//#상어 위치(arr) 지도정보 입력받음. jido.
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				//0이면 빈칸이고, 1보다 큰숫자면 상어 넘버임
				if(arr[i][j] > 0) {
					Shark s = new Shark();
					s.id = arr[i][j];
					s.r = i;
					s.c = j;
					sharks.put(s.id, s);
					
					smellOwner[i][j] = s.id;
					leftTime[i][j] = k;
				}
			}
		}
		
		//#direction of sharks 
		//그 다음 줄에는 각 상어의 방향이 차례대로 주어진다. 1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			//상어는 M마리가 있음. 그리고 0-base에 1 더해서 1-base로 바꿔줌
			//각 상어의 방향이 차례대로 주어짐. 그거 상어 객체에 입력 
			Shark s = sharks.get(i+1);
			s.dir = Integer.parseInt(st.nextToken());
		}
		//그 다음 줄부터 각 상어의 방향 우선순위가 상어 당 4줄씩 차례대로 주어진다.
		//하나의 상어를 나타내는 네 줄 중 
		//첫 번째 줄은 해당 상어가 위를 향할 때의 방향 우선순위, 두 번째 줄은 아래를 향할 때의 우선순위, 
		//세 번째 줄은 왼쪽을 향할 때의 우선순위, 네 번째 줄은 오른쪽을 향할 때의 우선순위이다.
		
		//#priority of sharks
		for(int i=0; i<M; i++) {
			Shark s = sharks.get(i+1);
			//j+1 : 상어 보는 방향 / z+1 : 보는 방향에 따른 우선순위 1234순위 / priority[j+1][z+1] : 우선순위방향값 1234
			for(int j=0; j<4; j++) {
				st = new StringTokenizer(br.readLine());
				for(int z=0; z<4; z++) {
					s.priority[j+1][z+1] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		//solution
		solution();
	}

	static void solution() {
		while(time++ < 1000) {
			moveShark();
			decreaseSmellTime();
			createSmell();
			
			if(sharks.size() == 1) {
				System.out.println(time);
				return;
			}
		}
		
		System.out.println(-1);
	}
	
	//상어 이동 후, 겹친 애 쫓아내기
	static void moveShark() {
		//dr, dc는 위, 아래, 왼쪽, 오른쪽 순서
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		/**바로 지워주면 런타임 에러가 나니까, 지울애들 담아주고 한꺼번에 지워준다.*/
		/** 큐큐큐 큐는 while(!isEmpty) 쓰기 편함. 그냥 바구니라고 생각 */
		Queue<Integer> willRemove = new LinkedList<Integer>();
		
		for(Integer id : sharks.keySet()) {
			Set<Integer> noSmellSet = new HashSet<>();
			Set<Integer> mySmellSet = new HashSet<>();
			Shark s = sharks.get(id);
			
			for(int i=0; i<4; i++) {
				int nr = s.r + dr[i];
				int nc = s.c + dc[i];
				
				//범위 밖으로 나가면 이 아래 코드 실행 안하고, 다음단계 반복문으로
				if(nr<0 || nr >= N || nc<0 || nc>= N) continue;
				
				//상어는 자기주변 네칸만 검사한다.
				if(smellOwner[nr][nc] == 0) { 
					//i+1 해주어야, 이미 적어놓은 방향인덱스 1,2,3,4 사용하는 것
					noSmellSet.add(i+1);
				} else if (smellOwner[nr][nc] == s.id) {
					mySmellSet.add(i+1);
				}
			}
			
			//냄새 없는 곳 부터 스캔하고, 자기 냄새 있는 곳을 스캔해서 이동할 방향 구하기.
			int nextDir = s.findNextDir(noSmellSet);
			
			if(nextDir == 0) {
				nextDir = s.findNextDir(mySmellSet);
			}
			
			//상어 이동
			arr[s.r][s.c] = 0;
			//1, 2, 3, 4는 각각 위, 아래, 왼쪽, 오른쪽을 의미한다.
			if(nextDir == 1) {
				s.r -= 1;
			}else if(nextDir == 2) {
				s.r += 1;
			}else if(nextDir == 3) {
				s.c -= 1;
			}else if(nextDir == 4) {
				s.c += 1;
			}
			
			//이동할 위치에 상어가 있으면, 경쟁 후 작은 번호가 승리
			if(arr[s.r][s.c] == 0 || s.id < arr[s.r][s.c]) {
				//빈칸이거나, 칸에 누가 있어도 내가 이기면 자리 차지
				arr[s.r][s.c] = s.id;
				//그 후에는 방금 이동한 방향이 보고 있는 방향이 된다.
				s.dir = nextDir;
			}else {
				/** 어쨋든 위의 경우가 안전하게 갈 수 있는 거고, 그게 아니면... */
				//지워질 상어 큐에 담아주기
				willRemove.add(s.id);
			}
		}
		
		while(!willRemove.isEmpty()) {
			//poll은 빠져나오는 동시에 값을 리턴
			sharks.remove(willRemove.poll());
		}
	}
	
	//맵 전체의 냄새 시간을 하나씩 감소시키고, 0이 되면 냄새 주인 정보도 지움
	static void decreaseSmellTime() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//(1)냄새시간이 0임 >> 냄새 주인 없음이 자명함. continue로 넘어감.
				if(leftTime[i][j] == 0) continue;
				//(2)냄새시간 하나 감소 >> 이 때에는 냄새시간이 1이상임
				leftTime[i][j]--;
				//(3)냄새시간이 1 감소시켜서 0이 되었다. >> 그 자리 주인 지워줌
				if(leftTime[i][j] == 0) {
					smellOwner[i][j] = 0;
				}
			}
		}
	}
	
	//상어가 이동한 곳에 새로운 냄새 생성
	static void createSmell() {
		for(Integer id : sharks.keySet()) {
			Shark s = sharks.get(id);
			smellOwner[s.r][s.c] = s.id;
			leftTime[s.r][s.c] = k;
		}
	}
}
