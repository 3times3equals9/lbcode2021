package study_week_1st;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Tree implements Comparable<Tree>{
    int y,x,age;
    @Override
    public int compareTo(Tree t){
        return this.age>t.age?1:-1;
    }
}

class Main{
    static int N,M,K;
    static int[][] map, add;
    static int[] dy={-1,-1,-1,0,0,1,1,1};
    static int[] dx={-1,0,1,-1,1,-1,0,1};

    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] tmp=br.readLine().split(" ");
        N=Integer.parseInt(tmp[0]);
        M=Integer.parseInt(tmp[1]);
        K=Integer.parseInt(tmp[2]);
        map=new int[N][N];
        add=new int[N][N];
        PriorityQueue<Tree>[] pq=new PriorityQueue[2];
        pq[0]=new PriorityQueue<Tree>();
        pq[1]=new PriorityQueue<Tree>();
        int cur=0,next=0;

        for(int i=0;i<N;i++){
            tmp=br.readLine().split(" ");
            for(int j=0;j<N;j++){
                add[i][j]=Integer.parseInt(tmp[j]);
                map[i][j]=5;
            }
        }
        for(int i=0;i<M;i++){
            tmp=br.readLine().split(" ");
            Tree t=new Tree();
            t.y=Integer.parseInt(tmp[0])-1;
            t.x=Integer.parseInt(tmp[1])-1;
            t.age=Integer.parseInt(tmp[2]);
            pq[cur].offer(t);
        }

        for(int i=0;i<K;i++){
            next=(cur+1)%2;
            Queue<Tree> life_tree=new LinkedList<>();
            Queue<Tree> dead_tree=new LinkedList<>();

            // 봄: 양분먹기+나이먹기 or 죽기
            while(!pq[cur].isEmpty()){
                Tree cur_tree=pq[cur].peek();
                pq[cur].poll();
                // 땅에 양분이 충분하다면 나무가 자란다
                if(map[cur_tree.y][cur_tree.x]>=cur_tree.age){
                    map[cur_tree.y][cur_tree.x]-=cur_tree.age;
                    Tree next_tree=new Tree();
                    next_tree.y=cur_tree.y;
                    next_tree.x=cur_tree.x;
                    next_tree.age=cur_tree.age+1;

                    life_tree.add(next_tree);
                    pq[next].add(next_tree);
                } else{
                    // 양분이 부족하면 죽는다
                    dead_tree.add(cur_tree);
                }
            }
            // 여름: 죽은 나무가 양분으로
            while(!dead_tree.isEmpty()){
                Tree cur_tree=dead_tree.peek();
                dead_tree.poll();
                map[cur_tree.y][cur_tree.x]+=(cur_tree.age/2);
            }
            // 가을: 나무 번식
            while(!life_tree.isEmpty()){
                Tree cur_tree=life_tree.peek();
                life_tree.poll();
                if(cur_tree.age%5 == 0){
                    for(int dir=0;dir<8;dir++){
                        Tree next_tree=new Tree();
                        next_tree.y=cur_tree.y+dy[dir];
                        next_tree.x=cur_tree.x+dx[dir];
                        next_tree.age=1;

                        if(next_tree.y<0||next_tree.y>=N||next_tree.x<0||next_tree.x>=N){
                            continue;
                        }
                        pq[next].add(next_tree);
                    }
                }
            }

            // 겨울: 로봇이 양분 추가
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    map[y][x]+=add[y][x];
                }
            }
            cur=next;
        }
        System.out.println(pq[next].size());
    }
}
