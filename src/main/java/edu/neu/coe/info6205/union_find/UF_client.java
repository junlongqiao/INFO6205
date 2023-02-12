package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_client {
    public static void main(String args[]) {
        int[] n = new int[1000];
        for(int i=0;i<1000;i++){
            n[i] = i+10;
        }
        for (int i = 0; i < n.length; i++) {
            int m  = count(n[i]);
            System.out.println((i+10) +","+m);
        }
    }

    private static int count(int n){
        int count = 0;
        for(int i=0;i<1000;i++){
            Random r = new Random();
            UF h = new UF_HWQUPC(n);
            while (!isAllConnect(h, n)) {
                count = count + 1;
                int p = r.nextInt(n);
                int q = r.nextInt(n);
                if (!h.isConnected(p, q)) {
                    h.union(p, q);
                }
            }
        }
        return count/1000;
    }
    private static boolean isAllConnect(UF h, int n){
        for(int i=1;i<n;i++){
            if(!h.isConnected(0,i)){
                return false;
            }
        }
        return true;
    }
}

