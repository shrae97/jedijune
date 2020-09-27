
#include <stdio.h>

struct Human {
	int id;
	char name[100];
};

void playWithPointers() {
	char c = 'A';
	int i = 10;
	long l = 9090909090;
	float f = 10.10;
	double d = 90.90;
	struct Human h = { 420, "Gabbar Singh" };

	printf("\n c = %ld", (sizeof(char *)));
	printf("\n i = %ld", (sizeof(int *)));
	printf("\n l = %ld", (sizeof(long *)));
	printf("\n f = %ld", (sizeof(float *)));
	printf("\n d = %ld", (sizeof(double *)));
	printf("\n h = %ld", (sizeof(struct Human*)));

	printf("\n c = %lX", (sizeof(char *)));
	printf("\n i = %lX", (sizeof(int *)));
	printf("\n l = %lX", (sizeof(long *)));
	printf("\n f = %lX", (sizeof(float *)));
	printf("\n d = %lX", (sizeof(double *)));
	printf("\n h = %lX", (sizeof(struct Human*)));
}

int main() {
	printf("\nFunction : playWithPointers");
	playWithPointers();

	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
	// printf("\nFunction : ");
}
