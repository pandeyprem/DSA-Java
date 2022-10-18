long maxSubarraySum(int arr[], int n){
        
        // Your code here
        long maxsum=Integer.MIN_VALUE;
        long max_endingsum=0;
        for(int i=0;i<n;i++){
            max_endingsum+=arr[i];
            if(max_endingsum>maxsum)
                maxsum=max_endingsum;
            if(max_endingsum<0)
                max_endingsum=0;
        }
        return maxsum;
    }
