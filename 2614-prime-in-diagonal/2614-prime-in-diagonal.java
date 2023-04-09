class Solution {
private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int maxPrime = 0; // to store the largest prime number found
        int n = nums.length; // length of the square matrix
        
        // Check main diagonal
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) { // Check if current element is prime
                maxPrime = Math.max(maxPrime, nums[i][i]); // Update maxPrime if larger prime is found
            }
        }
        
        // Check secondary diagonal
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][n - i - 1])) { // Check if current element is prime
                maxPrime = Math.max(maxPrime, nums[i][n - i - 1]); // Update maxPrime if larger prime is found
            }
        }
        
        return maxPrime; 
    }
}