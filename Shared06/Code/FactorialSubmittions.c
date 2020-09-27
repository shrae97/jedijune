
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char* allocateMem( int len ){
    char* res = (char*)malloc((len+1)*sizeof(char)) ; res[len]='\0';
    return res ; 
}

char* add( char* num1,char* num2 ){
    int n1 = strlen(num1) ,n2 = strlen(num2) ; 
    int res_len = 1 + (n1>n2?n1:n2) ;
    char* res = allocateMem(res_len); 
    res[res_len]='\0' ; 
    res[res_len-1]='0' ; 
    int c = 0 ;
    for(int i = 0 ; i<res_len;++i){
        int o1 = 0,o2=  0 ; 
        if( i<n1 ) o1 = num1[i]-'0' ; if( i<n2 ) o2 = num2[i]-'0' ;
        res[i] = (o1+o2+c)%10 + '0' ; 
        c = (o1+o2+c)/10 ; 
    }
    if(res[res_len-1]=='0') res[res_len-1]='\0' ; 
    return res ; 
}

char* mul10( char* num1, int num_of_zeroes ){
    int n1 = strlen(num1) ;
    char* res; 
    if( n1==1 && num1[0]=='0'){ res = (char*)malloc(2*sizeof(char)) ; res[0]='0';res[1]='\0' ; return res ;  }
    res = allocateMem(n1+num_of_zeroes) ;
    for(int i = 0 ; i <num_of_zeroes;++i) res[i]='0' ;
    for(int i=num_of_zeroes;i<num_of_zeroes+n1;++i) res[i] = num1[i-num_of_zeroes] ;
    return res; 
}

char* mulBySingleDigit(char* num , int x){
    char* res ;
    if( x==0 ){ res = allocateMem(1) ; res[0]='0' ; return res ;   }
    int c = 0 ; 
    int n = strlen(num) ;
    res = allocateMem(n+1) ; 
    res[n] = '0' ; 
    for(int i=0;i<n;++i){
        int temp = (num[i]-'0')*x+c ; c = temp/10 ;
        res[i]= (temp%10)+'0' ; 
    }
    if(c==0) res[n]='\0' ;
    else res[n]=c+'0' ;
    return res ; 
}

char* mul( char* num1,char* num2 ){
    char* res = allocateMem(1) ; res[0]='0' ;  
    int n1=strlen(num1),n2=strlen(num2) ;
    for(int i=0;i<n2;++i){
        res = add(res,mul10(mulBySingleDigit(num1,num2[i]-'0'),i)) ;
    }
    return res ; 
}

char* factorial( int num ){
    if(num<0){ printf(""Invalid Input"") ; return NULL ;  }
    char* const_one = allocateMem(1) ; const_one[0]='1' ;
    char* int_in_array = allocateMem(1); int_in_array[0]='1' ; 
    char* res = allocateMem(1) ; res[0]='1' ; 
    for(int i =2;i<=num;++i){
        int_in_array = add(int_in_array,const_one) ;
        // printf(""%s"",int_in_array);
        res = mul(res,int_in_array) ;
    }
    return res ; 
}

void print_human_readable( char* num ){
    int len = strlen(num) ;
    for(int i=len-1;i>=0;--i) printf(""%c"",num[i]) ;
    printf(""\n"") ;
}

int main(){
    char arr[] = ""12"" ; char brr[] = ""01"" ; 
    print_human_readable(factorial(512)) ; 
    
}