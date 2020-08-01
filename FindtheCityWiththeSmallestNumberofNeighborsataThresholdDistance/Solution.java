package FindtheCityWiththeSmallestNumberofNeighborsataThresholdDistance;

import java.util.*;

public class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dis[][] = new int[n][n];
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i!=j){
                    dis[i][j] = 1000000;
                }
            }
        }

        for(int[] e : edges){
            dis[e[0]][e[1]] = e[2];
            dis[e[1]][e[0]] = e[2];
        }

        for(int k=0; k<n; ++k){
            for(int i=0; i<n; ++i){
                for(int j=0; j<n; ++j){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k]+dis[k][j]);
                }
            }
        }

        int ret = -1;
        int smallNum = n;
        for(int i=0; i<n; ++i){
            int count = 0;
            for(int j=0; j<n; ++j){
                if(dis[i][j]<=distanceThreshold){
                    count++;
                }
            }
            if(count<=smallNum){
                smallNum = count;
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
}