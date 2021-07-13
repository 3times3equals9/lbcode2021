package _lb_mark;

import java.util.Scanner;

public class _불안한무빙워크 {
	
	static class Pair{
		public int stability;
		public boolean occupied;
		public Pair(int stability, boolean occupied) {
			super();
			this.stability = stability;
			this.occupied = occupied;
		}
	}

	static final int MAX_N = 100;
	static int n, k;
	
	static Pair[] u;
	static Pair[] d;
	
	static void Shift() {
		Pair temp = u[n - 1];
	    for(int i = n - 1; i >= 1; i--)
	        u[i] = u[i - 1];
	    u[0] = d[n - 1];
	    
	    for(int i = n - 1; i >= 1; i--)
	        d[i] = d[i - 1];
	    d[0] = temp;
	}
	
	static boolean CanGo(int idx) {
	    // 밖으로 나가는 것은 항상 가능합니다.
	    if(idx == n)
	        return true;
	    
	    // 안정성이 0보다 크면서 사람이 없는 경우에만
	    // 이동이 가능합니다.
	    int stability; 
	    boolean occupied;
	    //tie(stability, occupied) = u[idx];
	    stability = u[idx].stability;
	    occupied = u[idx].occupied;
	    
	    return stability > 0 && !occupied; 
	}

	static void Move(int idx) {
	    // 현재 위치에 있던 사람은 사라집니다.
	    int curr_stability;
	    //tie(curr_stability, ignore) = u[idx];
	    curr_stability = u[idx].stability;
	    u[idx] = new Pair(curr_stability, false);
	    
	    // 밖으로 나가는 것이 아니라면,
	    // 안정성이 1 감소하며, 사람이 추가됩니다.
	    if(idx + 1 < n) {
	        int next_stability;
	        //tie(next_stability, ignore) = u[idx + 1];
	        next_stability = u[idx + 1].stability;
	        u[idx + 1] = new Pair(next_stability - 1, true);
	    }
	}

	static void MoveAll() {
	    // 현재 위치에 사람이 있고, 그 다음 위치로 이동이
	    // 가능한 경우에만 움직입니다.
	    for(int i = n - 1; i >= 0; i--) {
	        boolean occupied;
	        //tie(ignore, occupied) = u[i];
	        occupied = u[i].occupied;
	        
	        if(occupied && CanGo(i + 1))
	            Move(i);
	    }
	}
	
	static void Add() {
	    // 안정성이 0보다 크고 사람이 없는 경우에만
	    // 첫 번째 위치에 사람을 올려놓습니다.
	    int stability; 
	    boolean occupied;
	    //tie(stability, occupied) = u[0];
	    stability = u[0].stability;
	    occupied = u[0].occupied;
	    
	    if(stability > 0 && !occupied)
	        u[0] = new Pair(stability - 1, true);
	}

	static void Simulate() {
	    // Step1. 무빙워크를 한 칸 회전시킵니다.
	    Shift();
	    
	    // Step2. 사람들을 한 칸씩 앞으로 이동시킵니다.
	    MoveAll();
	    
	    // Step3. 사람을 새로 올립니다.
	    Add();
	    
	    // Step4. n번 칸 위치에 사람이 있다면, 즉시 내려줍니다.
	    boolean occupied;
	    //tie(ignore, occupied) = u[n - 1];
	    occupied = u[n - 1].occupied;
	    if(occupied)
	        Move(n - 1);
	}
	
	static boolean Done() {
	    int unstable_cnt = 0;
	    for(int i = 0; i < n; i++) {
	        int stability;
	        //tie(stability, ignore) = u[i];
	        stability = u[i].stability;
	        if(!(stability > 0)) unstable_cnt++;
	    }
	    for(int i = 0; i < n; i++) {
	        int stability;
	        //tie(stability, ignore) = d[i];
	        stability = d[i].stability;
	        if(!(stability > 0)) unstable_cnt++;
	    }
	    
	    return unstable_cnt >= k;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		pair<int, bool> u[MAX_N];
//		pair<int, bool> d[MAX_N];
		n = sc.nextInt();
		k = sc.nextInt();
		
		u = new Pair[n];
		d = new Pair[n];

		for(int i = 0; i < n; i++) {
	        int stability;
	        stability = sc.nextInt();
	        u[i] = new Pair(stability, false);
	    }
		for(int i = 0; i < n; i++) {
	        int stability;
	        stability = sc.nextInt();;
	        d[i] = new Pair(stability, false);
	    }
		
	    int trial = 0;
	    
	    while(!Done()) {
	        Simulate();
	        trial++;
	    }
	    
	    System.out.println(trial);
		sc.close();
	}
}






































