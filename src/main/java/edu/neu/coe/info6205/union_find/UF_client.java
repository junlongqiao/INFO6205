package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_client {
    public static void main(String args[]) {
        int[] n = new int[100];
        for(int i=0;i<100;i++){
            n[i] = i+10;
        }
        for (int i = 0; i < n.length; i++) {
            int m  = count(n[i]);
            System.out.println("n = "+ (i+10) +"  m = "+m);
        }
    }

    private static int count(int n){
        Random r = new Random();
        UF h = new UF_HWQUPC(n);
        int count = 0;
        while (!isAllConnect(h, n)) {
            int p = r.nextInt(n);
            int q = r.nextInt(n);
            if (!h.isConnected(p, q)) {
                h.union(p, q);
                count++;
            }
        }
        return count;
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

