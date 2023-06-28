class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed == null || flowerbed.length == 0) {
      return false;
    }
    int count = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0 && // (1)
          (i == 0 || flowerbed[i - 1] == 0) &&
          (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
        flowerbed[i] = 1;
        count++; // (2)
      }
      if (count >= n) { // (3)
        return true;
      }
    }

    return false;
  }
        
    
}