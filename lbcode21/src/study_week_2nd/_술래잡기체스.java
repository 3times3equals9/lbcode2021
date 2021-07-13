package study_week_2nd;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class _술래잡기체스 {
	
	public static int answer, cnt; //최대값, queue에 따른 정보를 저장하기 위한 변수
	public static Map<Integer, int[][]> sMap; //queue에 따른 map 정보 저장, shark 상어
	public static Map<Integer, Map<Integer, int[]>> fMove; //queue에 따른 fish 정보 저장
	public static Queue<int[]> q; //bfs 사용을 위한 queue
	//방향, dir[0]은 안쓰고, dir[n][0] : 행, dir[n][1] : 열
	//1부터 순서대로 ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 를 의미
	public static int[][] dir = {
			{0,0}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		answer = 0;
		cnt = 0;
		int[][] map = new int[4][4];
		Map<Integer, int[]> f = new HashMap<>(); 
		//맵 f는 Integer(물고기번호)값을 Key로, 그 번호 물고기의 좌표값, 방향을 알 수 있다
		//map[i][j] : 물고기 번호
		//f.get(map[i][j])[0] : 행, f.get(map[i][j])[0] : 열, f.get(map[i][j])[0] : 방향
		sMap = new HashMap<>();
		fMove = new HashMap<>();
		q = new LinkedList<>();
		
		for(int i=0; i<4; ++i) {
			for(int j=0; j<4; ++j) {
				map[i][j] = sc.nextInt(); //일단 물고기 번호 집어넣네
				//map[i][j] : 물고기 번호, new int[] : 그 물고기의 좌표값, 방향
				f.put(map[i][j], new int[] {i, j, sc.nextInt()});
			}
		}
		
		/** cnt를 맵 상태 와 물고기 상태의 고유번호로 사용 */
		/** 지금 cnt는 0임 */
		sMap.put(cnt, map); //상어맵에는 카운트랑 맵
		fMove.put(cnt, f); // 물고기맵에는 카운트랑 물고기정보맵
		//q에 들어있는것은 현재 판의 상황, 상어 좌표, 상어방향, 점수, cnt는 물고기 위치 map의 key
		//다음번에 뽑아서 탐색 시작할 상어 상태 집어넣음 
		q.offer(new int[] {0,0,f.get(map[0][0])[2], 0, cnt++}); //cnt는 횟수로 추측
		/** cnt 한개 증가, cnt = 1 */
		bfs();
		
		System.out.println(answer);
		sc.close();
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] s = q.poll();
			int[][] map = sMap.get(s[4]); //cnt를 이용해 queue에 따른 map 정보 불러오기
			
			Map<Integer, int[]> f = fMove.get(s[4]); //cnt를 이용해 queue에 따른 fish 정보 불러오기
			
			/** 상어가 물고기 잡아먹음 */
			int sum = s[3] + map[s[0]][s[1]]; //상어가 지금 있는 자리의 물고기 번호 먹음.
			answer = answer < sum ? sum : answer; //최대값 확인
			
			/** 물고기가 이동 */
			map[s[0]][s[1]] = -1;//상어 위치 표시
			move(map, f); //물고기의 이동
			
			/** 물고기가 이동했으니 상어가 이동할 차례이다. */
			map[s[0]][s[1]] = 0; //상어가 물고기를 먹고 난 후, 빈 자리 표시
			int y = s[0] + dir[s[2]][0];
			int x = s[1] + dir[s[2]][1];
			// 상어가 가진 방향에서 먹을 수 있는 물고기들을 모두 Queue 에 넣기
			while(0<=y && y<4 && 0<= x && x<4) {
				if(map[y][x] != 0) {
					//map과 fish 정보는 주소값으로 저장되기 때문에, 새로운 배열과 HashMap을 만들고 새로운 주소로 저장
					int[][] cMap = new int[4][4];
					Map<Integer, int[]> cFish = new HashMap<>();
					
					//맵 값 복사
					for(int i=0; i<4; ++i) {
						for(int j=0; j<4; ++j) {
							cMap[i][j] = map[i][j];
						}
					}
					//물고기 정보 복사
					cFish.putAll(f);
					
					sMap.put(cnt, cMap);
					fMove.put(cnt, cFish);
					//다음번에 뽑아서 새로 탐색할 상어의 상태 집어넣음
					q.offer(new int[] {y, x, f.get(map[y][x])[2], sum, cnt++});
				}
				
				//상어방향에서 한칸씩 전진하면서 ...
				y += dir[s[2]][0];
				x += dir[s[2]][1];
			}
		}
	}
	
	//죽은 물고기 인지 확인
	public static boolean dead(int[][] map, int num) {
		/** 맵을 전체 탐색해서, 그 물고기 번호가 있으면 안죽은거, 없으면 죽은거 */
		for(int i=0; i<4; ++i) {
			for(int j=0; j<4; ++j) {
				if(map[i][j] == num) return false;
			}
		}
		return true;
	}
	
	public static void move(int[][] map, Map<Integer, int[]> f) {
		for(int i=1; i<=16; ++i) {
			if(dead(map, i)) continue;
			
			/** 1. 여기서 새로 적을 값을 가지고 있으니까, */
			//location
			int[] l = new int[] {f.get(i)[0], f.get(i)[1]};
			//direction
			int d = f.get(i)[2];
			int y = l[0] + dir[d][0];
			int x = l[1] + dir[d][1];
			
			//방향을 먼저 잡음, -1 : 상어 표시
			while(y<0 || 4<=y || x<0 || 4<=x || map[y][x] == -1) {
				d = (d+1) % 9; //인덱스1증가 : 반시계방향으로 45도 회전
				if(d == 0) d=1; //인덱스 0은 안씀
				
				y = l[0] + dir[d][0];
				x = l[1] + dir[d][1];
			}
			
			/** 2. 다른 값 가져와서, 여기에 적어주고 */
			//해당 방향으로 한 칸 이동
			//만약 해당 칸에 물고기가 없다면 0과 swap, 있다면 그 물고기와 swap
			if(map[y][x] == 0) {
				// ( l[0], l[1] ) : 지금 건들고 있는 물고기 좌표
				map[l[0]][l[1]] = 0;
			} else { // -1인 상어는 위에서 걸렀으니, 어짜피 1~16 
				//물고기 끼리 위치는 바꾸되, 방향은 안바꿈
				// ( y, x ) : 지금 건들고 있는 물고기가 새로 갈 자리 좌표
				f.put(map[y][x], new int[] {l[0] , l[1], f.get(map[y][x])[2]});
				map[l[0]][l[1]] = map[y][x];
			}
			
			/** 3. 그 다른값은 이미 복사가 되었으니, 그 장소에다가  (1)에서 가지고 있던 값을 적어줌 */
			f.put(i, new int[] {y,x,d});
			map[y][x] = i;
		}
	}

}
