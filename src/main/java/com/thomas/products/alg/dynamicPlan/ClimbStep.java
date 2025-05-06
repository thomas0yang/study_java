package com.thomas.products.alg.dynamicPlan;

/**
 *
 */
public class ClimbStep {
    public static void main(String[] args) {
        System.out.println(climbingStep(10));
        System.out.println(climbingStep2(10));
    }

    public static int climbingStep(int n){
        if (0 == n || 1 == n){
            return 1;
        }
        return climbingStep(n-1) + climbingStep(n-2);
    }

    public static int climbingStep2(int n){
        if (0 == n || 1 == n){
            return 1;
        }
        int[] steps = new int[n+1];
        steps[0] = 1;
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
