
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

	printf("\n i = %d", (sizeof(char *)));
	printf("\n i = %d", (sizeof(int *)));
	printf("\n i = %d", (sizeof(long *)));
	printf("\n i = %d", (sizeof(float *)));
	printf("\n i = %d", (sizeof(double *)));
	printf("\n i = %d", (sizeof(struct Human*)));
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
