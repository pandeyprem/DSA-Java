#include <iostream>

using namespace std;

int main() {

  int n;

  cout << "Enter an integer: ";

  cin >> n;

  if ( n % 2 == 0)

    cout << n << " is even.";

  else

    cout << n << " is odd.";

  return 0;

}

public class Prime {

    public static void main(String[] args) {

        int low = 20, high = 50;

        while (low < high) {

            if(checkPrimeNumber(low))

                System.out.print(low + " ");

            ++low;

        }

    }

    public static boolean checkPrimeNumber(int num) {

        boolean flag = true;

        for(int i = 2; i <= num/2; ++i) {

            if(num % i == 0) {

                flag = false;

                break;

            }

        }

        return flag;

    }

}
