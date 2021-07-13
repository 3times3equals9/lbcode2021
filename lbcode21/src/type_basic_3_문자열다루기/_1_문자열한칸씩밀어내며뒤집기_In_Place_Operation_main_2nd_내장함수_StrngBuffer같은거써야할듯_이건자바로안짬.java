package type_basic_3_문자열다루기;

import java.util.Scanner;

public class _1_문자열한칸씩밀어내며뒤집기_In_Place_Operation_main_2nd_내장함수_StrngBuffer같은거써야할듯_이건자바로안짬 {
	
	static String input_str;
	static int str_size;
	static char[] car;
	
	public static void shiftFront() {
		char tmp = car[0];
		for(int k=1; k<str_size; k++) {
			car[k-1] = car[k];
		}
		car[str_size-1] = tmp;
		
		input_str = new String(car);
		System.out.println(input_str);
	    return;
	}
	
	public static void shiftBack() {
		char tmp = car[str_size-1];
		for(int k=str_size-1-1; k>=0; k--) {
			car[k+1] = car[k];
		}
		car[0] = tmp;
		
		input_str = new String(car);
		System.out.println(input_str);
	    return;
	}
	
	public static void reverse() {
		for(int k=0; k<(str_size/2); k++) {
			char tmp = car[k];
			car[k] = car[str_size-1-k];
			car[str_size-1-k] = tmp;
		}
		
		input_str  = new String(car);
		System.out.println(input_str);
	    return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int q_num;
		input_str = sc.next();
		q_num = sc.nextInt();
	    str_size = input_str.length();
	    car = input_str.toCharArray();

	    int q_type;
	    for(int i = 0; i < q_num; i++) {
	        q_type = sc.nextInt();
	        if(q_type == 1)
	            shiftFront();
	        else if(q_type == 2)
	            shiftBack();
	        else if(q_type == 3)
	            reverse();
	    }
		
		sc.close();
	}
}

/*
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] ca  = str.toCharArray();
		int len = str.length();
		
		int q = sc.nextInt();
		int[] arr = new int[q];
		for(int i=0; i<q; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<q; i++) {
			if(arr[i] == 1) {
				char tmp = ca[0];
				for(int k=1; k<len; k++) {
					ca[k-1] = ca[k];
				}
				ca[len-1] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if(arr[i] == 2) {
				char tmp = ca[len-1];
				for(int k=len-1-1; k>=0; k--) {
					ca[k+1] = ca[k];
				}
				ca[0] = tmp;
				
				String prt  = new String(ca);
				System.out.println(prt);
			}else if( arr[i] == 3) {
				for(int k=0; k<(len/2); k++) {
					char tmp = ca[k];
					ca[k] = ca[len-1-k];
					ca[len-1-k] = tmp;
				}
				
				String prt  = new String(ca);
				System.out.println(prt);
			}
		}
	
		sc.close();
	}
	
}
*/

/*

#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

string input_str;
int str_size;

void shiftFront() {
    int len = (int) input_str.size();
    input_str = input_str.substr(1, len) + input_str.substr(0, 1);

    cout << input_str << endl;
    return;
}

void shiftBack() {
    int len = (int) input_str.size();
    input_str = input_str.substr(len - 1, len) + input_str.substr(0, len - 1);

    cout << input_str << endl;
    return;
}

void reverse() {
    reverse(input_str.begin(), input_str.end());

    cout << input_str << endl;
    return;
}

int main() {
    int q_num;
    cin >> input_str >> q_num;

    str_size = input_str.size();

    int q_type;
    for(int i = 0; i < q_num; i++) {
        cin >> q_type;
        if(q_type == 1)
            shiftFront();
        else if(q_type == 2)
            shiftBack();
        else if(q_type == 3)
            reverse();
    }

    return 0;
}
 * */


/*
input_str, q_num = tuple(input().split())
q_num = int(q_num)


def shift_front():
    global input_str
    input_str = input_str[1:] + input_str[0]
    
    print(input_str)

    
def shift_back():
    global input_str
    input_str = input_str[-1] + input_str[:-1]
    
    print(input_str)


def reverse():
    global input_str
    input_str = input_str[::-1]
    
    print(input_str)


for _ in range(q_num):
    q_type = int(input())
    if q_type == 1:
        shift_front()
    elif q_type == 2:
        shift_back()
    elif q_type == 3:
        reverse()
 * */
































































