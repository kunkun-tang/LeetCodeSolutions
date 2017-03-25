package _338_Counting_Bits_;

public class Solution {
    public int[] countBits(int num) {
        int count = num-0 + 1;
        int[] ret = new int[count];
        int curr = 1;
        while(curr <= num){
            int prev = curr-1;
            for(int i= curr; i<= curr + prev; i++){
                if(i<count)
                    ret[i] = 1 + ret[i-curr];
            }
            curr = curr * 2;
        }
        return ret;
    }
}
