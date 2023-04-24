class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       if(n == 0) return true;
        int i = 0;
        while(i < flowerbed.length){
            if(flowerbed[i] == 0){
                if((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                    flowerbed[i] = 1;
                    i += 2;
                    n--;
                } else {
                    i++;
                }
            } else {
                i += 2;
            }
            if(n == 0) return true;
        }
        return false;  
    }
}