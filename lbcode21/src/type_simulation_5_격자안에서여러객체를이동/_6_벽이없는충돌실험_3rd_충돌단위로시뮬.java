package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _6_벽이없는충돌실험_3rd_충돌단위로시뮬 {
	
	static class Pair{
		public int row;
		public int col;
		public Pair() {
			super();
		}
		public Pair(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	//이때 영향력이 크다 함은 무게가 가장 크거나, 무게가 같은 구슬이 여러 개일 경우 구슬의 번호가 가장 클 경우를 의미합니다
	static class Marble implements Comparable<Marble>{
		public int row;
		public int col;
		public int weight;
		public int dir;
		public int num;
		public Marble() {
			super();
		}
		public Marble(int row, int col, int weight, int dir, int num) {
			super();
			this.row = row;
			this.col = col;
			this.weight = weight;
			this.dir = dir;
			this.num = num;
		}

		@Override
		public int compareTo(Marble o) {
			if(this.weight != o.weight) {
				return -(this.weight - o.weight);
			} else {
				return -(this.num - o.num);
			}
		}
		
	}
	/*
		// 구슬을 무게를 내림차순으로 정렬합니다.
		// 무게가 동일할 경우 숫자를 내림차순으로 정렬하여
		// 정렬 이후 더 앞선 구슬들이
		// 충돌시에 항상 더 영향력을 가질 수 있도록 합니다.
		bool Cmp(const Marble &marble1, const Marble &marble2) {
		    int weight1, num1;
		    tie(ignore, ignore, weight1, ignore, num1) = marble1;
		
		    int weight2, num2;
		    tie(ignore, ignore, weight2, ignore, num2) = marble2;
		
		    if(weight1 != weight2)
		        return weight1 > weight2;
		    return num1 > num2;
		}
	 */
	
	static class Collision implements Comparable<Collision>{
		public int time;
		public int index1;
		public int index2;
		
		public Collision() {
			super();
		}

		public Collision(int time, int index1, int index2) {
			super();
			this.time = time;
			this.index1 = index1;
			this.index2 = index2;
		}

		@Override
		public int compareTo(Collision o) {
			return this.time - o.time;
		}
		//시간순으로 오름차순정렬해야함
	}
	
	static final int DIR_NUM = 4;
	static final int MAX_N = 100;
	static final int ASCII_NUM = 128;
	// 전역 변수 선언:
	static int t, n;
	static int[] mapper = new int[ASCII_NUM];
	
	static final int[] dx = {0, 1, -1, 0};
	static final int[] dy = {1, 0, 0, -1};
		
	//static boolean[] disappear = new boolean[MAX_N + 1];
	static boolean[] disappear;
	static int last_collision_time;
	
	//vector<Marble> marbles;
	//vector<Collision> collisions;
	static ArrayList<Marble> marbles;
	static ArrayList<Collision> collisions;
	
	// 해당 구슬의 k초 후의 위치를 계산하여 반환합니다.
	static Pair Move(Marble marble, int k) {
	    // tuple의 경우 다음과 같이 원하는 변수에 값을 뽑아줄 수 있습니다.
	    int x, y, dir;
	    //tie(x, y, ignore, dir, ignore) = marble;
	    x = marble.row;
	    y = marble.col;
	    dir = marble.dir;
	    
	    int nx = x + dx[dir] * k, ny = y + dy[dir] * k;
	    return new Pair(nx, ny);
	}
	
	// 두 구슬만 좌표 평면 위에 존재한다 했을 때
	// 충돌이 일어난다면 언제 일어나는지 그 시간을 반환합니다.
	// 만약 충돌이 일어나지 않는다면 -1을 반환합니다.
	static int CollisionOccurTime(Marble marble1, Marble marble2) {
	    int x1, y1, dir1;
	    //tie(x1, y1, ignore, dir1, ignore) = marble1;
	    x1 = marble1.row;
	    y1 = marble1.col;
	    dir1 = marble1.dir;
	    
	    int x2, y2, dir2;
	    //tie(x2, y2, ignore, dir2, ignore) = marble2;
	    x2 = marble2.row;
	    y2 = marble2.col;
	    dir2 = marble2.dir;
	    
	    // Case1 : 두 구슬의 방향이 같은 경우에는 절대 충돌하지 않습니다.
	    if(dir1 == dir2)
	        return -1;

	    // Case2 : 두 구슬의 방향이 반대인 경우에는 
	    //         x, y 값 중 하나가 일치해야 하고
	    //         두 구슬의 거리를 반으로 나눈 값 만큼
	    //         두 구슬을 각각의 방향으로 움직였을 때 
	    //         서로 같은 위치로 도달해야 충돌한다고 볼 수 있습니다. 
	    if(dir1 == 3 - dir2) {
	        // x, y 둘 다 일치하지 않으면 불가합니다.
	        if(x1 != x2 && y1 != y2)
	            return -1;
	        
	        // x, y 둘 중에 하나가 일치한다면 
	        // 처음에 모든 좌표를 다 2배씩 해줬기 때문에 
	        // dist는 짝수임을 보장할 수 있습니다. 
	        int dist = (x1 != x2) ? Math.abs(x1 - x2) : Math.abs(y1 - y2);
	        int half = dist / 2;
	        
	        //if(Move(marble1, half) == Move(marble2, half))
	        Pair p1 = Move(marble1, half);
	        Pair p2 = Move(marble2, half);
	        if(p1.row == p2.row && p1.col == p2.col)
	            return half;
	        else
	            return -1;
	    }

	    // Case3 : 두 방향이 서로 나란히 있지 않은 경우에는
	    //         두 구슬의 x좌표, y좌표의 차이가 정확히 일치해야 하며
	    //         두 구슬의 각각의 방향으로 그 거리의 차이 만큼씩 움직였을 때
	    //         서로 같은 위치로 도달해야 충돌한다고 볼 수 있습니다. 

	    int x_dist = Math.abs(x1 - x2);
	    int y_dist = Math.abs(y1 - y2);
	    //if(x_dist == y_dist && Move(marble1, x_dist) == Move(marble2, x_dist))
	    Pair p3 = Move(marble1, x_dist);
        Pair p4 = Move(marble2, x_dist);
	    if(x_dist == y_dist && p3.row == p4.row && p3.col == p4.col)
	        return x_dist;
	    else
	        return -1;
	}
	
	// 모든 구슬쌍에 대해 충돌이 일어나는지 확인하고
	// 발생 가능한 충돌들에 대해 시간순으로 정렬해줍니다.
	static void ArrangeCollisions() {
	    for(int i = 0; i < (int) marbles.size(); i++)
	        for(int j = i + 1; j < (int) marbles.size(); j++) {
	            int time = CollisionOccurTime(marbles.get(i), marbles.get(j));
	            if(time != -1)
	                collisions.add(new Collision(time, i, j));
	        }
	    
	    // tuple은 기본적으로 앞의 원소부터 오름차순으로 정렬하므로
	    // 다음과 같이 정렬시 시간순으로 오름차순으로 정렬됨을 보장할 수 있습니다.
	    //sort(collisions.begin(), collisions.end());
	    Collections.sort(collisions);
	}
	
	// 시간에 따라 충돌 단위로 시뮬레이션을 진행합니다.
	static void Simulate() {
	    for(int i = 0; i < (int) collisions.size(); i++) {
	        int index1, index2, collision_time;
	        //tie(collision_time, index1, index2) = collisions[i];
	        collision_time = collisions.get(i).time;
	        index1 = collisions.get(i).index1;
	        index2 = collisions.get(i).index2;
	        
	        // 두 구슬 중 하나라도 이미 이전의 충돌로 인해 소멸되어 버렸다면
	        // 두 구슬은 실제로 충돌이 일어날 수 없었다는 의미이므로
	        // 패스합니다.
	        if(disappear[index1] || disappear[index2])
	            continue;

	        // 처음에 구슬의 목록을 (무게 순, 번호가 더 큰 순)으로
	        // 정렬해놨기 때문에 index1 < index2인 경우 
	        // 항상 index1이 더 영향력이 크기 때문에 살아남게 되고
	        // index2는 소멸하게 됩니다.

	        disappear[index2] = true;
	        last_collision_time = collision_time;
	    }
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 3 - dir 방향이 dir 방향과 정 반대가 되도록
	    // dir에 따른 dx, dy 값을 적절하게 정의합니다.
	    // 후에 두 구슬의 방향이 서로 정 반대인지 쉽게 판단하기 위함입니다. 
	    mapper['U'] = 0;
	    mapper['R'] = 1;
	    mapper['L'] = 2;
	    mapper['D'] = 3;
	    
	    // 테스트 케이스 수 입력:
	    t = sc.nextInt();
	    
	    while(t-- > 0) {
	    	// 새로운 테스트 케이스가 시작될때마다 기존에 사용하던 값들을 초기화해줍니다.
	    	marbles = new ArrayList<>();
			collisions = new ArrayList<>();
	        last_collision_time = -1;
	        /*
	        for(int i = 1; i <= MAX_N; i++)
	            disappear[i] = 0;
			*/
	        disappear = new boolean[MAX_N + 1];
	        
	        // 입력:
	        n = sc.nextInt();
	        for(int i = 1; i <= n; i++) {
	        	//cin >> x >> y >> weight >> d;
	        	int x = sc.nextInt();
	        	int y = sc.nextInt();
	        	int weight = sc.nextInt();
	        	char d = sc.next().charAt(0);

	            // 구슬이 움직이는 도중에 충돌하는 문제를 깔끔하게 처리하기 위해
	            // 좌표를 2배로 불려 1초에 한칸 씩 이동하는 문제로 바꿉니다.
	            // 이렇게 문제가 바뀌면 따로 구슬이 움직이는 도중 충돌하는 경우를 생각하지
	            // 않아도 됩니다.
	            x *= 2; y *= 2;

	            marbles.add(new Marble(x, y, weight, mapper[d], i));
	        }

	        // 충돌시 영향력이 더 높은 구슬이 앞으로 오도록 정렬합니다.
	        // 영향력이 더 높다 함은 무게가 더 크거나, 무게가 같더라도 번호가 더 커
	        // 충돌시 살아남게 되는 구슬을 의미합니다.
	        //sort(marbles.begin(), marbles.end(), Cmp);
	        Collections.sort(marbles);
	        
	        // 모든 구슬쌍에 대해 충돌이 일어나는 경우를 구해
	        // 시간순으로 정리해줍니다.
	        ArrangeCollisions();

	        // 시간에 따라 충돌 단위로 시뮬레이션을 진행합니다.
	        Simulate();
	        
	        // 출력:
	        System.out.println(last_collision_time);
	    }
		
		sc.close();
	}
}









































































