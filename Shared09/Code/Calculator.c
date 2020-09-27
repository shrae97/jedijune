#include <stdio.h>

// Single Responsibilty Design
int sum(int x, int y) { return x + y; }
int sub(int x, int y) { return x - y; }
int mul(int x, int y) { return x * y; }
int div(int x, int y) { return x / y; }

// Polymorphism
// Mechanim 03: Passing Behaviour To A Behaviour

// Single Responsibilty Design
// Open For Extension And Close Modification
int calculator(int x, int y, int (*operation)(int, int) ) {
	return operation(x, y);
}

int main() {
	int a = 10, b = 20;
	int result = 0;

	result = calculator(a, b, sum);
	printf("\nResult : %d", result);

	result = calculator(a, b, sub);
	printf("\nResult : %d", result);

	result = calculator(a, b, mul);
	printf("\nResult : %d", result);

	result = calculator(a, b, mul);
	printf("\nResult : %d", result);
}
