package type_simulation_5_격자안에서여러객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _6_벽이없는충돌실험_1st_1초간격으로_움직임직접시뮬_시간초과 {
	
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
		public Marble(Marble m) {
			super();
			this.row = m.row;
			this.col = m.col;
			this.weight = m.weight;
			this.dir = m.dir;
			this.num = m.num;
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
	
	static final int DIR_NUM = 4;
	static final int COORD_SIZE = 4000;
	static final int ASCII_NUM = 128;
	// 전역 변수 선언:
	static int t, n;
	static int[] mapper = new int[ASCII_NUM];
	
	static final int[] dx = {0, 1, -1, 0};
	static final int[] dy = {1, 0, 0, -1};

	static int curr_time;
	static int last_collision_time;

//	vector<Marble> marbles;
//	vector<Marble> next_marbles;
	//static LinkedList<Marble> marbles = new LinkedList<>();
	//static LinkedList<Marble> next_marbles = new LinkedList<>();
	static ArrayList<Marble> marbles = new ArrayList<>();
	static ArrayList<Marble> next_marbles = new ArrayList<>();
	
	// 해당 구슬이 1초 후에 어디 위치에 있는지를 구해 상태를 반환합니다.
	static Marble Move(Marble marble) {
	    // tuple의 경우 다음과 같이 원하는 변수에 값을 뽑아줄 수 있습니다.
	    int x, y, weight, dir, num;
	    //tie(x, y, weight, dir, num) = marble;
	    x = marble.row;
	    y = marble.col;
	    weight = marble.weight;
	    dir = marble.dir;
	    num = marble.num;
	    
	    int nx = x + dx[dir], ny = y + dy[dir];
	    return new Marble(nx, ny, weight, dir, num);
	}
	
	// 해당 구슬과 충돌이 일어나는 구슬이 있는지 확인합니다.
	// 있다면 해당 구슬의 index를 반환하고, 없다면 -1을 반환합니다.
	static int FindDuplicateMarble(Marble marble) {
	    int target_x, target_y;
	    //tie(target_x, target_y, ignore, ignore, ignore) = marble;
	    target_x = marble.row;
	    target_y = marble.col;
	    
	    for(int i = 0; i < (int) next_marbles.size(); i++) {
	        int mx, my;
	        //tie(mx, my, ignore, ignore, ignore) = next_marbles[i];
	        mx = next_marbles.get(i).row;
	        my = next_marbles.get(i).col;
	        
	        if(target_x == mx && target_y == my)
	            return i;
	    }

	    return -1;
	}
	
	// 두 구슬이 같은 위치에서 충돌했을 경우
	// 살아남는 구슬을 반환합니다.
	static Marble Collide(Marble marble1, Marble marble2) {
	    int weight1, num1;
	    //tie(ignore, ignore, weight1, ignore, num1) = marble1;
	    weight1 = marble1.weight;
	    num1 = marble1.num;
	    
	    int weight2, num2;
	    //tie(ignore, ignore, weight2, ignore, num2) = marble2;
	    weight2 = marble2.weight;
	    num2 = marble2.num;
	    
	    // 첫 번째 구슬을 따라가게 되는 경우는
	    // 첫 번째 구슬의 무게가 더 크거나
	    // 무게는 같은데 번호가 더 클 경우 입니다.
	    if(weight1 > weight2 || (weight1 == weight2 && num1 > num2))
	        //return new Marble(marble1);
	    	return (marble1);
	    else
	        //return new Marble(marble2);
	    	return (marble2);
	}

	// 그 다음 구슬의 목록에 반영합니다.
	static void PushNextMarble(Marble marble) {
	    int index = FindDuplicateMarble(marble);

	    // Case1 : 같은 위치에 있는 구슬이 아직 없다면 그대로 목록에 추가합니다.
	    if(index == -1)
	        next_marbles.add(marble);
	    	//next_marbles.add(new Marble(marble));

	    // Case2 :
	    // 다음 구슬의 목록 중 같은 위치에 구슬이 이미 있다면
	    // 더 영향력 있는 구슬만 남기고
	    // 현재 시간을 가장 최근 충돌 시간에 기록합니다.
	    else {
	        //next_marbles[index] = Collide(next_marbles[index], marble);
	    	Marble tmp_marble = Collide(next_marbles.get(index), marble);
	    	next_marbles.set(index, tmp_marble);
	    	last_collision_time = curr_time;
	    }
	}
	
	// 모든 구슬들을 한 칸씩 움직이는 시뮬레이션을 진행합니다.
	static void Simulate() {
	    for(int i = 0; i < (int) marbles.size(); i++) {
	        // Step1 : 각 구슬에 대해 한 칸 움직인 이후의 위치를 받아옵니다.
	        Marble next_marble = Move(marbles.get(i));

	        // Step2 : 그 다음 구슬의 목록에 반영합니다.
	        PushNextMarble(next_marble);
	    }
	    
	    marbles = next_marbles;
	    
	    // 그 다음 Simulation 때 다시 사용해야하므로
	    // 구슬의 목록을 미리 초기화해줍니다. 
	    /** clear() 적폐새끼 */
	    /*next_marbles.clear();*/
	    next_marbles = new ArrayList<>();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    mapper['U'] = 0;
	    mapper['R'] = 1;
	    mapper['L'] = 2;
	    mapper['D'] = 3;

	    // 테스트 케이스 수 입력:
	    t = sc.nextInt();
	    
	    while(t-- > 0) {
	        // 새로운 테스트 케이스가 시작될때마다 기존에 사용하던 값들을 초기화해줍니다.
	    	/** clear() 적폐새끼 */
	        /*marbles.clear();*/
	    	marbles = new ArrayList<>();
	    	next_marbles = new ArrayList<>();
	        last_collision_time = -1;

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

	        // 처음에 구슬들은 전부 
	        // (-2000, -2000)에서 (2000, 2000) 사이에 있기 때문에 
	        // COORD SIZE + 1(4001)만큼 이동하면
	        // 입력으로 주어진 구슬들이 모두 (-2000, -2000) ~ (2000, 2000)
	        // 영역 밖으로 벗어나게 되므로 더 이상 충돌이 일어나지 않게 됩니다.
	        // 따라서 시뮬레이션을 총 COORD_SIZE번 진행합니다.
	        for(int i = 1; i <= COORD_SIZE; i++) {
	            curr_time = i;
	            Simulate();
	        }
	        
	        // 출력:
	        System.out.println(last_collision_time);
	    }
	    
		sc.close();
	}
}









































































