package com.example.gamecricket.utility;

public class RandomGeneratorUtil {
    private static int findCeil(int[] arr, int r, int l, int h){
        int mid;
        while (l < h)
        {
            mid = l + ((h - l) >> 1);
            if(r > arr[mid]){
                l = mid + 1;
            }
            else{
                h = mid;
            }
        }
        return (arr[l] >= r) ? l : -1;
    }

    public static int myRandom(){
        int[] arr    = {0,1,2,3,4,5,6,7};
        int[] freq   = {8,30,20,18,15,4,2,3};
        int n = 8;
        int[] prefix = new int[n];
        int i;
        prefix[0] = freq[0];
        for (i = 1; i < n; ++i)
        {
            prefix[i]  = prefix[i - 1] + freq[i];
        }
        int r = (int) (Math.random() * 100) + 1;
        int indexc = findCeil(prefix, r, 0, 7);
        return arr[indexc] - 1;
    }
}
