
// Design 1
// ???????
long long sum(long long x, long long y){        

}

// Design 2
int sum(int x, int y){        
    long long res = (long long)x + (long long)y;

    // Comparing long long with int
    if(res > INT_MAX || res < INT_MIN) {
             printf(""Can't calculate the sum\n"");
             return -1;
    }

    return (int)res;
}

// Design 3
int sum(int a, int b){
    // long long int result = a+b;
    
    int result = a+b;

	// Assuming Hardware Configuration
	// Hardware Dependent Design
	// It's Not A Portable Code

    if((a>0 && b>0 && result <0) ||(a<0 && b<0 && result >0)) { 
    		printf(""Can't add the numbers\n"");
            return -1; 
    } else {
            return result;
    }
}

// Design 4
int sum(int x, int y){
        long int res1 = (long int) x + (long int) y;
        int res2 = x + y

        // Comparing Two Different Type Values
        // long int with int
        if(res1 != res2){
                print(""cant add"")
        }
        return res2
}

// Design 5
int sum(int x,int y){
	// Unnecessary Type Conversions
    long long a = (long long) x;
    long long b = (long long) y;


    if(a+b > (long long)INT_MAX || a+b < (long long)INT_MIN){
            printf(""error\n"");
            return 0;
    }else{
            return x+y;
    }
}

// Design 6
int sum(int x, int y) {
    int res = x+y;
    if((x>0 && y>0 && res<0) || (x<0 && y<0 && res>0)){
            printf(""Can't add the numbers"");
            return -1;
    }
    return res;
}

// Design 7
int sum(int x, int y){
      long int z = (long int) x+ (long int)y;
      if((int)z != z) print(""overflow!"")
      return (int)z; // It's should be Valid Result
}

// Design 8
int sum(int x, int y){
    int max_int = 2147483647;
    int min_int = -max_int-1; //?????

    // In Right Direction....
    if(x > max_int - y && x > 0 ){
        printf(""Can not compute sum\n"");
        return -1;
    }
    else if(x < min_int - y && x < 0 ){
        printf(""Can not compute sum\n"");
        return -1;
    }
    else
        return x + y;
}


// Design 9
int sum(int x, int y){
        
        // Some Conditions Are Missing
        if(  (x < INT_MIN -y )  || (x>INT_MAX - y) ){
                printf(""Cannot calculate sum for given inputs"");
                return -1;
        }
        return x+y;
}

// Design 10
int sum (int x, int y) {
        int lower_limit = INT_MIN;
        int upper_limit = INT_MAX;

		// Some Conditions Are Missing
        if (upper_limit-y > x && lower_limit-y < x) {
                return (x+y);
        }
        else {
                printf(""cannot calculate"");
                return -1;
        }
}

// Design 11
int safeAddition (int x, int y) {
    if (x > 0 && y > INT_MAX - x) {
        printf (""overflow"") 
    } else if (x < 0 && y < INT_MIN - x) {
        printf(""underflow"")
    }
   return x + y;
}

// Design 12
void safeAddition(int x, int y) {
	// People are return -1 For Error

	// int z =  x + y;
	// z can go beyond INT_MAX = 9090;
	// z = 9099;

    if (x > 0 && y > INT_MAX - x) {
        printf (""overflow"") 
    } else if (x < 0 && y < INT_MIN - x) {
        printf(""underflow"")
    }

    // Valid Sum
    printf (x + y);
}








