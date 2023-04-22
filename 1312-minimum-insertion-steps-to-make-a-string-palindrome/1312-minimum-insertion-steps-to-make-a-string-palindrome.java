class Solution {
    public int minInsertions(String s) {
        // reverse the input string
        String reversed = new StringBuilder(s).reverse().toString();
        // get the length of the input string
        int n = s.length();
        // create a 2D array to store the LCS of substrings
        int[][] dp = new int[n+1][n+1];
        
        // fill up the dp array using dynamic programming approach
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == reversed.charAt(j-1)) {
                    // if characters match, add 1 to LCS
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // otherwise, take maximum LCS of two substrings
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        // return the minimum number of insertions required to make s a palindrome
        // this is the difference between the length of s and the length of its LCS
        return n - dp[n][n];
    }
}