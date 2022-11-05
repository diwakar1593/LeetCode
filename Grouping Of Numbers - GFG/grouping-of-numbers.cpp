//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int maxGroupSize(int arr[], int N, int K) {
        int freq[K]={0};
        for(int i = 0; i < N; i++)
            freq[arr[i]%K]++;
            if(K%2==0)
            freq[K/2]=min(freq[K/2],1);
        int res = min (freq[0],1);
        for(int i=1; i<=K/2;i++)
        res+= max(freq[i],freq[K-i]);
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N,K;
        
        cin>>N>>K;
        int arr[N];
        
        for(int i=0; i<N; i++)
            cin>>arr[i];

        Solution ob;
        cout << ob.maxGroupSize(arr,N,K) << endl;
    }
    return 0;
}
// } Driver Code Ends