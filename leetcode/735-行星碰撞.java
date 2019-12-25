class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int[] right = new int[len+1];
        int id = 0;
        for(int i=0; i<len; ++i) {
            if(asteroids[i]>0) right[id++] = i;
            else {
                while(id>0 && asteroids[i]+asteroids[right[id-1]]<=0) {
                    if(asteroids[i]+asteroids[right[id-1]] == 0) {
                        asteroids[i] = 0;
                        asteroids[right[id-1]] = 0;
                        break;
                    }
                    asteroids[right[id-1]] = 0;
                    id--;
                }
                if(id>0) asteroids[i] = 0;
            }
        }
        int sz = 0;
        for(int x: asteroids){
            if(x!=0) sz++;
        }
        int[] res = new int[sz];
        int k=0;
        for(int x:asteroids){
            if(x!=0) res[k++] = x;
        }
        return res;
    }
}