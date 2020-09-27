#include <stdio.h> 

int sum2(int x, int y) 		{ return x + y; }
int sum3(int x, int y, int z) 	{ return x + y + z; }

int main() {
	int result = 0;

	result = sum2(10, 20);
	result = sum3(10, 20, 30);
}
