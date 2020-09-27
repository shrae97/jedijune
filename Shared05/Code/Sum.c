
#include <stdio.h>
#include <limits.h>

// This Code
// Thinking In Brain Integer [ Mathematical ]
// But In Actual Reality You are Using C int
int sum(int x, int y) {
	return x + y;
}

signed int validSum(signed int a, signed int b) {
    signed int result = 0;

    // Data Type Definition: int Type : 
	//    Range [INT_MIN, INT_MAX]
    //	  + Operation Valid in int Type

    // Type Safe Code
    // Never Ever Mess With Type As Idea
    // 		Treat Type as God
    if (((b > 0) && (a > (INT_MAX - b))) ||
        ((b < 0) && (a < (INT_MIN - b)))) {
        /* Handle error */
    } else {
        result = a + b;
    }
    return result;
}

void main() {
	int a = 898989990909898989;
	int b = 1;

	int result = 0;
	result = sum(a, b);

	printf("\n Result : %d\n", result );

	// Expected Result : 898989990909898990
	// Result : 953217262
}

