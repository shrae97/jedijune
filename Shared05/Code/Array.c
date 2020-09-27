
#include <stdio.h>

int main() {
	int buffer1[5] = {10, 20, 30, 40, 50};
	int buffer2[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

	for (int i = 10; i > - 5; i--) {
		printf("%d ", buffer2[i]);
	}
}
