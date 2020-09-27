#include <stdio.h>

struct Human {
	int id;
	char name[100];	
};

int main() {
	void *array[5];

	char ch = 'A';
	int a = 20;
	float f = 20.30;
	double d = 90.90;
	struct Human h = { 111, "Gabbar Singh"};

	array[0] = &ch;
	array[1] = &a;
	array[2] = &f;
	array[3] = &h;
	array[4] = &d; // Read Location

	printf("%c\n",  *(char *) (array[0]) );
	printf("%d\n",  *(int *) (array[1]) );
	printf("%f\n",  *(float *) (array[2]) );
	// printf("%d\n", (*(struct Human *) array[3]).id );
	// printf("%s\n", (*(struct Human *) array[3]).name );

	printf("%lf\n",  *(struct Human *) array[3] );
	// Above To Read Next Memory Location

	printf("%lf\n",  *(struct Human *) array[3] );
	printf("%lf\n", *(double *) (array[4]) );
// A
// 20
// 20.299999
// 20.299999
// 90.900000

// A
// 20
// 20.299999
// 111
// Gabbar Singh
// 90.900000	
}

