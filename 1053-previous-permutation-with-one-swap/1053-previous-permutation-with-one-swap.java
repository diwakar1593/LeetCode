class Solution {
    public int[] prevPermOpt1(int[] A) {
        int idx = A.length - 2, i = A.length - 1;
		//find the first i, that A[i] > A[i + 1]
        while (idx >= 0 && A[idx] <= A[idx + 1]) idx--;
        if (idx < 0) return A;
		//find the largest A[i] and smallest i,  that make A[i] < A[idx], where i > idx;
        while (A[i] >= A[idx] || (i > 0 && A[i] == A[i - 1])) i--;
        int tmp = A[i];
        A[i] = A[idx];
        A[idx] = tmp;
        return A;
    }
}