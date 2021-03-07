package study_week_1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class _바이러스실험_제출하면컴파일에러뜸 {

	private static class Tree implements Comparable<Tree>{
		int r,c,age;
		@Override
		public int compareTo(Tree o) {
			//오름차순으로 정렬할라고, 1이면 바꿔주는거. 큰게 뒤로감.
			return this.age > o.age ? 1 : -1;
		}
	}
	
	static final int[] dr = {-1,-1,-1,0,0,+1,+1,+1};
	static final int[] dc = {-1,0,+1,-1,+1,-1,0,+1};
	
	static int N, M, K; 
	static int[][] map, add;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] tmp=br.readLine().split(" ");
		
        N=Integer.parseInt(tmp[0]);
        M=Integer.parseInt(tmp[1]);
        K=Integer.parseInt(tmp[2]);
		
		map = new int[N][N]; //맨 처음 양분. 
		add = new int[N][N]; //매 겨울 새로 추가할 양분.
		
		PriorityQueue<Tree>[] pq = new PriorityQueue[2];
		pq[0] = new PriorityQueue<>();
		pq[1] = new PriorityQueue<>();
		int cur = 0, next = 0;
		
		for(int r=0; r<N; r++) {
			tmp=br.readLine().split(" ");
			for(int c=0; c<N; c++) {
				add[r][c] = Integer.parseInt(tmp[c]);
				map[r][c] = 5;
			}
		}
		
		//나무 위치 입력받기.
		for(int i=0; i<M; i++) {
			tmp=br.readLine().split(" ");
			Tree tr = new Tree();
			tr.r = Integer.parseInt(tmp[0])-1;
			tr.c = Integer.parseInt(tmp[1])-1;
			tr.age = Integer.parseInt(tmp[2]);
			pq[cur].offer(tr);
		}
		
		//K년만큼 돌기.
		for(int i=0; i<K; i++) {
			next = (cur+1)%2;
			Queue<Tree> life_tree = new LinkedList<>();
			Queue<Tree> dead_tree = new LinkedList<>();
			
			//봄 : 양분먹기 + 나이먹기 or 죽기
			while(!pq[cur].isEmpty()) {
				//current tree.
				Tree ct = pq[cur].peek();
				pq[cur].poll();
				//땅에 양분이 충분하다면 나무가 자란다.
				if(map[ct.r][ct.c] >= ct.age) {
					map[ct.r][ct.c] -= ct.age;
					
					//next tree.
					Tree nt = new Tree();
					nt.r = ct.r;
					nt.c = ct.c;
					nt.age = ct.age+1; //나이만큼 양분 먹으면 나이 1증가.
					
					life_tree.add(nt);
					pq[next].add(nt);
				}else {
					//양분이 부족하면 죽는다.
					dead_tree.add(ct);
				}
			}
			
			//여름 : 죽은 나무가 양분으로.
			while(!dead_tree.isEmpty()) {
				Tree ct = dead_tree.peek();
				dead_tree.poll();
				map[ct.r][ct.c] += (ct.age/2);
			}
		
			//가을 : 나무 번식.
			while(!life_tree.isEmpty()) {
				Tree ct = life_tree.peek();
				life_tree.poll();
				if(ct.age % 5 == 0) {
					for(int k=0; k<8; k++) {
						Tree nt = new Tree();
						nt.r = ct.r + dr[k];
						nt.c = ct.c + dc[k];
						nt.age = 1;
						
						if(0<=nt.r && nt.r<N && 0<=nt.c && nt.c<N) {
							pq[next].add(nt);
						}
					}
				}
				
			}
			
			//겨울 : 로봇이 양분 추가(보충).
			for(int r=0; r<N; r++) {
				for(int c=0;c<N;c++) {
					map[r][c] += add[r][c];
				}
			}
			
			cur = next;
		}
		
//		System.out.println(pq[cur].size());
		System.out.println(pq[next].size());
	}

}


