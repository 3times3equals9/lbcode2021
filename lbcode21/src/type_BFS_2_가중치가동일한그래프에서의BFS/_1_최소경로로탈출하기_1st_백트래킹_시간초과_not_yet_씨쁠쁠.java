package type_BFS_2_가중치가동일한그래프에서의BFS;

import java.util.Scanner;

public class _1_최소경로로탈출하기_1st_백트래킹_시간초과_not_yet_씨쁠쁠 {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		sc.close();
	}
}

/*
#include <iostream>
#include <queue>
#include <algorithm>
#include <climits>

#define MAX_N 100
#define MAX_M 100

using namespace std;

// 전역 변수 선언:
int n, m;

int a[MAX_N][MAX_M];

// backtracking에 필요한 변수들 입니다.
bool visited[MAX_N][MAX_M];

int ans = INT_MAX;

bool InRange(int x, int y) {
    return 0 <= x && x < n && 0 <= y && y < m;
}

// 격자를 벗어나지 않으면서, 뱀도 없고, 아직 방문한 적이 없는 곳이라면
// 이동이 가능합니다.
bool CanGo(int x, int y) {
    return InRange(x, y) && a[x][y] && !visited[x][y];
}

// backtracking을 통해 최소 이동 횟수를 구합니다.
void FindMin(int x, int y, int cnt) {
    if(x == n - 1 && y == m - 1) {
        ans = min(ans, cnt);
        return;
    }

    int dx[4] = {1, -1, 0, 0};
    int dy[4] = {0, 0, 1, -1};

    // 현재 위치를 기준으로 4방향을 확인해봅니다.
    for(int dir = 0; dir < 4; dir++) {
        int nx = x + dx[dir], ny = y + dy[dir];

        // 아직 방문한 적이 없으면서 갈 수 있는 곳이라면
        // 더 진행해봅니다.
        if(CanGo(nx, ny)) {
            visited[nx][ny] = true;
            FindMin(nx, ny, cnt + 1);
            // 지금까지의 선택이 최단경로 로서 부적합했을 수 있으므로
            // 퇴각시 visited값을 다시 false로 바꿔 
            // 다른 방향으로 진행할때도 기회를 주어 모든 가능한 
            // 경로를 전부 탐색할 수 있도록 합니다. 
            visited[nx][ny] = false;
        }
    }
}

int main() {
    // 입력:
    cin >> n >> m;

    for(int i = 0; i < n; i++)
        for(int j = 0; j < m; j++)
            cin >> a[i][j];
    
    // 현재까지 이동 횟수가 0일때, (0, 0)에서 시작하는
    // 재귀를 호출합니다.
    FindMin(0, 0, 0);

    // 출력:
    if(ans == INT_MAX)  // 불가능한 경우라면
        ans = -1;       // -1을 답으로 넣어줍니다.
    
    cout << ans;

    return 0;
}
 */







































































