package type_simulation_4_격자안에서단일객체를이동;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class _6_뱀은사과를좋아해_3rd_시뮬_더블링크드리스트_해쉬셋 {
	
	static class Pair{
		public int row;
		public int col;
		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int hashCode = Integer.hashCode(row);
			hashCode = prime * hashCode + Integer.hashCode(col);
			return hashCode;
		}
		
		@Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) {
                return false;
            }

            Pair p = (Pair) o;
            return this.row == p.row &&
                    this.col == p.col;
        }
	}
	
	static final int MAX_N = 100;
	static final int ASCII_NUM = 128;
	
	static LinkedList<Pair> snake = new LinkedList<>();
	static HashSet<Pair> snakePos = new HashSet<>();
	
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
	// 몸이 꼬였는지 여부는
	// HashSet에 새로 들어온 머리 위치가
	// 이미 존재하는지를 확인하면 됩니다.
	static boolean IsTwisted(Pair newHead) {                 
		//return snakePos.find(newHead) != snakePos.end();      
	    return snakePos.contains(newHead);      
	}  
	
	// 새로운 머리를 추가합니다.
	static boolean PushFront(Pair newHead) {
		// 몸이 꼬이는 경우
		// false를 반환합니다.
	    if(IsTwisted(newHead) == true)                        
	        return false;                                     
	    
		// 새로운 머리를 추가합니다.
	    snake.addFirst(newHead);                
	    // HashSet에 새로운 좌표를 기록합니다.
	    snakePos.add(newHead);                             

		// 정상적으로 머리를 추가헀다는 의미로
		// true를 반환합니다.
	    return true;                                         
	} 
	
	// 꼬리를 지웁니다.
	static void PopBack() {
		Pair tail = snake.getLast();
		// 꼬리 부분을 HashSet에서도 지우고
		snakePos.remove(tail);   
	    // List에서도 삭제합니다.
		snake.removeLast();
	    
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
		Pair init = new Pair(1, 1); 
	    snake.addFirst(init);
	    snakePos.add(init);
	    
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

/**
1. 이 문제에서 뱀의 위치를 관리하기 위한 자료구조로 Queue를 사용할 수는 없는걸까요?

불가능합니다. Queue를 이용했을 때 머리를 새로 추가하고 (push), 가장 먼저 들어와있던 꼬리를 삭제하는 (pop) 연산은 가능하지만, 이 문제에서 중요한 조건 중 하나인 뱀의 몸이 꼬여있지는 않은지에 대한 판단은 현재 뱀의 위치를 이루고 있는 block들을 전부 순회하며 새로 들어올 머리와 겹치는지를 확인해야 하기 때문에, Queue 구조로는 순회가 불가능하므로 부적합하다고 볼 수 있습니다.

단, 만약 Solution3 방법처럼 Queue와 HashSet을 같이 사용하여 몸이 겹쳐져 있는지 여부를 Queue를 순회하는 것이 아닌 HashSet을 이용해 해결한다면 올바른 답을 얻을 수 있습니다.

2. Solution3에서 HashSet을 직접 쓰지 않고, HashSet 역할을 해주는 checked 배열로 해결할 수는 없나요?

가능합니다. 단, 배열을 사용할 경우 항상 격자 크기에 해당하는 만큼의 메모리를 추가적으로 사용하게 됩니다. HashSet의 경우 정확히 뱀의 길이에 해당하는 만큼의 메모리만 사용하게 됩니다.
*/
/*
Intuition
뱀의 상태를 DoublyLinkedList를 통해 관리하며 동시에 HashSet을 이용해 각 뱀을 이루고 있는 block들의 위치가 겹치지 않고 단 한 번씩만 나와있는지를 O(1)만에 확인할 수 있습니다.

Algorithm
Solution2에서는 Solution1과 마찬가지로 겹치는지를 확인하기 위해 뱀의 몸을 이루고 있는 모든 위치를 다 확인해보는데 시간이 O(N^2)이 소요되었습니다. 하지만 한 움직임마다 새로 추가되는 부분은 머리 하나 뿐이고, 삭제되는 부분도 꼬리 하나 뿐이므로 항상 모든 위치를 순회할 필요 없이, 새롭게 추가되고 삭제되는 부분만 관리해도 무방합니다.

따라서 HashSet이라는 자료구조를 통해 각 위치에 뱀을 이루고 있는 block들이 놓여져 있는지를 쉽게 관리할 수 있고, HashSet의 경우 삽입 삭제 탐색에 걸리는 시간이 전부 O(1)이기 때문에 DoublyLinkedList와 HashSet을 같이 사용하면 새로운 머리를 추가하고, 몸이 꼬여있는지 확인하는데 전부 O(1)이므로, 입력을 제외한 총 시간복잡도는 O(S)가 됩니다.

*/
/*
#include <iostream>
#include <list>
#include <unordered_set>

#define MAX_NUM 100
#define ASCII_NUM 128

using namespace std;

int n, m, K;
bool apple[MAX_NUM + 1][MAX_NUM + 1];

// pair를 key로 HashSet에서 쓰기 위해 필요합니다.
namespace std {
    template <> struct hash<pair<int, int> > {
        inline size_t operator()(const pair<int, int> &v) const {
            hash<int> int_hasher;
            return int_hasher(v.first) ^ int_hasher(v.second);
        }
    };
}

list<pair<int, int> > snake;
unordered_set<pair<int, int> > snakePos;

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

int mapper[ASCII_NUM];

int ans;

// (x, y)가 범위 안에 들어가는지 확인합니다. 
bool CanGo(int x, int y) {
    return x >= 1 && y >= 1 && x <= n && y <= n;
}

// 뱀이 꼬였는지 확인합니다.
// 몸이 꼬였는지 여부는
// HashSet에 새로 들어온 머리 위치가
// 이미 존재하는지를 확인하면 됩니다.
bool IsTwisted(pair<int, int> newHead) {                 
    return snakePos.find(newHead) != snakePos.end();      
}                                                         

// 새로운 머리를 추가합니다.
bool PushFront(pair<int, int> newHead) {
	// 몸이 꼬이는 경우
	// false를 반환합니다.
    if(IsTwisted(newHead) == true)                       
        return false;                                    
    
	// 새로운 머리를 추가하고
    snake.push_front(newHead);      
	// HashSet에 새로운 좌표를 기록합니다.
    snakePos.insert(newHead);                             

	// 정상적으로 머리를 추가헀다는 의미로
	// true를 반환합니다.
    return true;                                        
}                                                        

// 꼬리를 지웁니다.
void PopBack() {
    pair<int, int> tail = snake.back();
	// 머리 부분을 HashSet에서도 지우고
    snakePos.erase(tail);   
	// List에서도 삭제합니다.
    snake.pop_back();                                   
}

// (nx, ny) 쪽으로 뱀을 움직입니다.
bool MoveSnake(int nx, int ny) {
	// 머리가 이동할 자리에 사과가 존재하면
	// 사과는 사라지게 되고
    if(apple[nx][ny] == true) {                           
        apple[nx][ny] = false;
		// 꼬리는 사라지지 않고 머리만 늘어납니다.
		// 늘어난 머리때문에 몸이 꼬이게 된다면
		// false를 반환합니다.
        if(PushFront(make_pair(nx, ny)) == false)         
            return false;                                 
    }                                                     
    else {
		// 사과가 없으면 꼬리는 사라지게 되고
        PopBack();
		
		// 머리는 늘어나게 됩니다.
		// 늘어난 머리때문에 몸이 꼬이게 된다면
		// false를 반환합니다.
        if(PushFront(make_pair(nx, ny)) == false)         
            return false;                                 
    }       
	
	// 정상적으로 뱀이 움직였으므로
    // true를 반환합니다.
    return true;                                         
}

// 뱀을 dir 방향으로 num 번 움직입니다.
bool Move(int dir, int num) {
	// num 횟수만큼 뱀을 움직입니다.
	// 한 번 움직일때마다 답을 갱신합니다.
    while(num--) {                              
        ans++;                                  

        pair<int, int> head = snake.front(); 

		// 뱀의 머리가 그다음으로 움직일
		// 위치를 구합니다.
        int nx = head.first + dx[dir];          
        int ny = head.second + dy[dir];         

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

int main() {
    // 입력으로 주어진 방향을 정의한 dx, dy에 맞도록 
	// 변환하는데 쓰이는 배열을 정의합니다.
    mapper['D'] = 0;
    mapper['U'] = 1;
    mapper['R'] = 2;
    mapper['L'] = 3;
	
    // 입력:
    cin >> n >> m >> K;
	
    // 사과가 있는 위치를 표시합니다.
	for(int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        apple[x][y] = true;
	}

    // 뱀은 처음에 (1, 1)에서 길이 1의 상태로 있습니다.
    snake.push_back(make_pair(1, 1));
	snakePos.insert(make_pair(1, 1));

    // K개의 명령을 수행합니다.
    for(int i = 0; i < K; i++) {
		// dir 방향으로 num 횟수 만큼 움직여야 합니다.
        char dir; int num;
        cin >> dir >> num;                 

		// 움직이는 도중 게임이 종료되었을 경우
		// 더 이상 진행하지 않습니다.
        if(Move(mapper[dir], num) == false) 
            break;                         
    }

    // 출력:
    cout << ans;
    return 0;
}

*/































































