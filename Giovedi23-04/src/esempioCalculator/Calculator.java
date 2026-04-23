package esempioCalculator;

import java.util.ArrayList;

public class Calculator {
    public int add(int a ,int b){
        return a+b;
    }
    public int add(int a ,int b, int c){
        return a+b+c;
    }
    public double add(double a ,double b){
        return a+b;
    }

    public int add(ArrayList<Integer> nums){

        int sum = 0;
        for(int i=0;i<nums.size();i++){
            sum+=nums.get(i);
        }

        return sum;
    }
}
