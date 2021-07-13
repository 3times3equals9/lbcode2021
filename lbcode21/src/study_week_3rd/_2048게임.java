package study_week_3rd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2048게임 {

	static int N, ANS;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	private static int findMax(int[][] arr) {
		int MAX = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c] <= MAX) {
					continue;
				}
				MAX = Math.max(MAX, arr[r][c]);
			}
		}
		return MAX;
	}
	
	private static int[][] up(int[][] arr) {
		//합쳐진 숫자인지 아닌지 체크하는 배열.
		boolean[][] check = new boolean[N][N];
		//왼쪽에서부터 한 column씩 확인
		for(int c=0; c<N; c++) {
			//맨 위에서부터 한칸 아래 row 부터 확인
			for(int r=1; r<N; r++) {
				if(arr[r][c] == 0) {
					//0이면 패스
					continue;
				}
				//일단 숫자있으면 저장해놓고 
				int num = arr[r][c];
				//아래에 0 아닌 숫자 나올 때 까지 확인. 밀면 합쳐지니깐.
				for(int k=r-1; k>=0; k--) {
					if(arr[k][c] == 0) {
						continue;
					}
					if(arr[k][c] != num || check[k][c]) {
						//같은숫자 아니거나, 다른 애랑 합쳐질 애라면 패스.
						break;
					}
					//( arr[k][c] == num ) 인 경우에 여기로 진입. 
					//인덱스 상황은 아래와 같음.
					//0
					//k
					//r
					//N-1
					arr[k][c] *= 2;
					check[k][c] = true;
					arr[r][c] = 0;
					break;
				}
			}
		}
		//줄별로 빈칸 정리하고 숫자 몰아주기.
		for(int c=0; c<N; c++) {
			for(int r=0; r<N; r++) {
				if(arr[r][c] == 0) {
					continue;
				}
				q.add(arr[r][c]);
				arr[r][c] = 0;
			}
			int index = 0;
			while(!q.isEmpty()) {
				arr[index][c] = q.remove();
				index++;
			}
		}
		return arr;
	}
	
	private static int[][] down(int[][] arr) {
		boolean[][] check = new boolean[N][N];
		for(int c=0; c<N; c++) {
			for(int r=N-2; r>=0; r--) {
				if(arr[r][c] == 0) {
					continue;
				}
				int num = arr[r][c];
				for(int k=r+1; k<N; k++) {
					if(arr[k][c] == 0) {
						continue;
					}
					if(arr[k][c] != num || check[k][c]) {
						break;
					}
					arr[k][c] *= 2;
					check[k][c] = true;
					arr[r][c] = 0;
					break;
				}
			}
		}
		for(int c=0; c<N; c++) {
			for(int r=N-1; r>=0; r--) {
				if(arr[r][c] == 0) {
					continue;
				}
				q.add(arr[r][c]);
				arr[r][c] = 0;
			}
			int index = N-1;
			while(!q.isEmpty()) {
				arr[index][c] = q.remove();
				index--;
			}
		}
		return arr;
	}

	private static int[][] left(int[][] arr) {
		boolean[][] check = new boolean[N][N];
		for(int r=0; r<N; r++) {
			for(int c=1; c<N; c++) {
				if(arr[r][c] == 0) {
					continue;
				}
				int num = arr[r][c];
				for(int k=c-1; k>=0; k--) {
					if(arr[r][k] == 0) {
						continue;
					}
					if(arr[r][k] != num || check[r][k]) {
						break;
					}
					arr[r][k] *= 2;
					check[r][k] = true;
					arr[r][c] = 0;
					break;
				}
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(arr[r][c] == 0) {
					continue;
				}
				q.add(arr[r][c]);
				arr[r][c] = 0;
			}
			int index = 0;
			while(!q.isEmpty()) {
				arr[r][index] = q.remove();
				index++;
			}
		}
		return arr;
	}
	
	private static int[][] right(int[][] arr) {
		boolean[][] check = new boolean[N][N];
		for(int r=0; r<N; r++) {
			for(int c=N-2; c>=0; c--) {
				if(arr[r][c] == 0) {
					continue;
				}
				int num = arr[r][c];
				for(int k=c+1; k<N; k++) {
					if(arr[r][k] == 0) {
						continue;
					}
					if(arr[r][k] != num || check[r][k]) {
						break;
					}
					arr[r][k] *= 2;
					check[r][k] = true;
					arr[r][c] = 0;
					break;
				}
			}
		}
		for(int r=0; r<N; r++) {
			for(int c=N-1; c>=0; c--) {
				if(arr[r][c] == 0) {
					continue;
				}
				q.add(arr[r][c]);
				arr[r][c] = 0;
			}
			int index = N-1;
			while(!q.isEmpty()) {
				arr[r][index] = q.remove();
				index--;
			}
		}
		return arr;
	}
	
	private static void go(int cnt, int[][] arr) {
		if(cnt == 5){
			ANS = Math.max(ANS, findMax(arr));
			return;
		}
		
		int[][] map = new int[N][N];
		
		//map에다가 arr복사해서, 상,하,좌,우 하나씩 변화시킨거 전달해서 재귀 돌림.
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = arr[r][c];
			}
		}
		go(cnt+1, up(map));
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = arr[r][c];
			}
		}
		go(cnt+1, down(map));
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = arr[r][c];
			}
		}
		go(cnt+1, left(map));
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = arr[r][c];
			}
		}
		go(cnt+1, right(map));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}
		go(0,arr);
		System.out.println(ANS);
		sc.close();
	}

}

