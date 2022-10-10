#include <iostream>
#include <algorithm>
using namespace std;

void merge(int a[], int b[], int m, int n){
    
    int i=0,j=0;
    while(i<m && j<n){
        if(a[i]<b[j])
            cout<<a[i++]<<" ";
        else
            cout<<b[j++]<<" ";
    }
    while(i<m)
        cout<<a[i++]<<" ";
    while(j<n)
        cout<<b[j++]<<" ";    
}

int main() {
	
    int a[]={10,15,20,40};
    int b[]={5,6,6,10,15};
	
	int m=sizeof(a)/sizeof(a[0]);
	int n=sizeof(b)/sizeof(b[0]);
	merge(a,b,m,n);
}
