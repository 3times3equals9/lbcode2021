package type_simulation_4_격자안에서단일객체를이동;

import java.util.ArrayList;
import java.util.Scanner;

public class _6_뱀은사과를좋아해_1st_시뮬_배열_노트_main {
	
	static class Pair{
		public int row;
		public int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static final int MAX_N = 100;
	static final int ASCII_NUM = 128;
	
	static ArrayList<Pair> snake = new ArrayList<>();
	
	static final int[] dx = {1, -1, 0, 0};
	static final int[] dy = {0, 0, 1, -1};
	
	static int n, m, K;
	static boolean[][] apple;
	
	static int ans;
	static int[] mapper = new int[ASCII_NUM];
	
	// (x, y)가 범위 안에 들어가는지 확인합니다. 
	static boolean CanGo(int x, int y) {
	    return x >= 1 && y >= 1 && x <= n && y <= n;
	}
	
	// 뱀이 꼬였는지 확인합니다.
	static boolean IsTwisted(Pair newHead) {
	    // 뱀이 꼬였는지 여부는
	    // 새로 들어올 머리가 기존 뱀의 몸통과 부딪히는지만 확인하면 됩니다.
	    
		 // 머리와 그 부분이 겹치는 경우에는
		// true 값을 반환해줍니다.
	    for(int i = 0; i < snake.size(); i++)
	        if(snake.get(i).row == newHead.row && snake.get(i).col == newHead.col)                        
	            return true;                                
	    
		 // 겹치지 않는 경우에는 false를 반환합니다.
	    return false; 
	}
	
	// 새로운 머리를 추가합니다.
	static boolean PushFront(Pair newHead) {
		// 몸이 꼬이는 경우
		// false를 반환합니다.
	    if(IsTwisted(newHead) == true)                        
	        return false;                                     
	    
		// 새로운 머리를 추가합니다.
	    //snake.insert(snake.begin(), newHead);                
	    //snake.add(0, new Pair(newHead.row, newHead.col));                
	    snake.add(0, newHead);                

		// 정상적으로 머리를 추가헀다는 의미로
		// true를 반환합니다.
	    return true;                                         
	}  
	
	// 꼬리를 지웁니다.
	static void PopBack() {
		int snake_length = snake.size();
	    snake.remove(snake_length-1);                                    
	}
	
	// (nx, ny) 쪽으로 뱀을 움직입니다.
	static boolean MoveSnake(int nx, int ny) {
		// 머리가 이동할 자리에 사과가 존재하면
		// 사과는 사라지게 되고
	    if(apple[nx][ny] == true) {                           
	        apple[nx][ny] = false;
			// 꼬리는 사라지지 않고 머리만 늘어납니다.
			// 늘어난 머리때문에 몸이 꼬이게 된다면
			// false를 반환합니다.
	        if(PushFront(new Pair(nx, ny)) == false)         
	            return false;                                 
	    }                                                     
	    else {
			// 사과가 없으면 꼬리는 사라지게 되고
	        PopBack();
			
			// 머리는 늘어나게 됩니다.
			// 늘어난 머리때문에 몸이 꼬이게 된다면
			// false를 반환합니다.
	        if(PushFront(new Pair(nx, ny)) == false)         
	            return false;                                 
	    }       
		
		// 정상적으로 뱀이 움직였으므로
	    // true를 반환합니다.
	    return true;                                         
	}   
	
	// 뱀을 dir 방향으로 num 번 움직입니다.
	static boolean Move(int dir, int num) {
		// num 횟수만큼 뱀을 움직입니다.
		// 한 번 움직일때마다 답을 갱신합니다.
	    while(num-- > 0) {                              
	        ans++;                                  

	        //pair<int, int> head = snake.front(); 
	        Pair head = new Pair(snake.get(0).row, snake.get(0).col);
	        
			// 뱀의 머리가 그다음으로 움직일
			// 위치를 구합니다.
	        int nx = head.row + dx[dir];          
	        int ny = head.col + dy[dir];         

			// 그 다음 위치로 갈 수 없다면
			// 게임을 종료합니다.
	        if(CanGo(nx, ny) == false)              
	            return false;                       

			// 뱀을 한 칸 움직입니다.
			// 만약 몸이 꼬인다면 false를 반환합니다.
	        if(MoveSnake(nx, ny) == false)          
	            return false;                       
	    }
	    
		// 정상적으로 명령을 수행했다는 의미인 true를 반환합니다.
	    return true;                               
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력으로 주어진 방향을 정의한 dx, dy에 맞도록 
		// 변환하는데 쓰이는 배열을 정의합니다.
	    mapper['D'] = 0;
	    mapper['U'] = 1;
	    mapper['R'] = 2;
	    mapper['L'] = 3;
		
	    // 입력:
	    n = sc.nextInt();
	    m = sc.nextInt();
	    K = sc.nextInt();
	    
		//bool apple[MAX_NUM + 1][MAX_NUM + 1];
	    apple = new boolean[n+1][n+1];
	    // 사과가 있는 위치를 표시합니다.
		for(int i = 0; i < m; i++) {
	        int x = sc.nextInt();
	        int y = sc.nextInt();
	        apple[x][y] = true;
		}
		
		//static ArrayList<Pair> snake = new ArrayList<>();
		// 뱀은 처음에 (1, 1)에서 길이 1의 상태로 있습니다.
	    snake.add(new Pair(1, 1));
		
	    // K개의 명령을 수행합니다.
	    for(int i = 0; i < K; i++) {
			// dir 방향으로 num 횟수 만큼 움직여야 합니다.
	        char dir = sc.next().charAt(0); 
	        int num = sc.nextInt();

			// 움직이는 도중 게임이 종료되었을 경우
			// 더 이상 진행하지 않습니다.
	        if(Move(mapper[dir], num) == false) 
	            break;                         
	    }
	    
	    System.out.println(ans);
		sc.close();
	}
}

/*
윗 부분에서 왜 꼬리를 없애는 과정을 새로운 머리를 추가하는 것 보다 먼저 수행했을까요? 그 답은 뱀의 몸이 꼬이는지를 어떻게 판단할 수 있는지를 생각해보면 알 수 있습니다.
>> (사과가 없으면)꼬리 먼저 없애고, 머리 추가
>> 뱀 전체는 동시에 움직이니까!!
>> 그 다음에 뱀 몸통이랑 머리랑 부딪치는지 확인해야함

!!! 다음과 같은 경우 몸이 동시에 움직이기 때문에 실제 충돌이 일어나지 않지만, 만약 꼬리를 없애는 과정을 새로운 머리를 추가한 과정 이후에 수행했다면 몸이 꼬인다고 잘못된 판단을 내리게 됩니다.
!!! 따라서 움직일때에는 먼저 필요한 경우 tail을 삭제한 이후에 head를 새로 추가하면서 몸이 꼬이는 경우가 발생하는지를 확인하면 됩니다.

*
*/

/**
1. 이 문제에서 뱀의 위치를 관리하기 위한 자료구조로 Queue를 사용할 수는 없는걸까요?

불가능합니다. Queue를 이용했을 때 머리를 새로 추가하고 (push), 가장 먼저 들어와있던 꼬리를 삭제하는 (pop) 연산은 가능하지만, 이 문제에서 중요한 조건 중 하나인 뱀의 몸이 꼬여있지는 않은지에 대한 판단은 현재 뱀의 위치를 이루고 있는 block들을 전부 순회하며 새로 들어올 머리와 겹치는지를 확인해야 하기 때문에, Queue 구조로는 순회가 불가능하므로 부적합하다고 볼 수 있습니다.

단, 만약 Solution3 방법처럼 Queue와 HashSet을 같이 사용하여 몸이 겹쳐져 있는지 여부를 Queue를 순회하는 것이 아닌 HashSet을 이용해 해결한다면 올바른 답을 얻을 수 있습니다.

2. Solution3에서 HashSet을 직접 쓰지 않고, HashSet 역할을 해주는 checked 배열로 해결할 수는 없나요?

가능합니다. 단, 배열을 사용할 경우 항상 격자 크기에 해당하는 만큼의 메모리를 추가적으로 사용하게 됩니다. HashSet의 경우 정확히 뱀의 길이에 해당하는 만큼의 메모리만 사용하게 됩니다.
*/





































































