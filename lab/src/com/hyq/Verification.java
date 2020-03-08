package com.hyq;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verification {

    //    private variables
    private List<Integer> money = new ArrayList<>();
    private double chosen = 0;
    private double temp = 0;
    private int i;

    public Verification() {
        money.addAll(Arrays.asList(50, 20, 10, 5, 5, 1, 1, 1));
    }


    //    the method of seeking the biggest number <= the number what we need
    public int seek (double temp) {
        int k = 0;
        while(!(temp >= money.get(k)) ){
            if(k >= money.size() - 1) {
                break;
            }
            k++;
        }
        return k;
    }
    //    main method
    public boolean verify(double given) {
        if(given > 93 || given < 0){
            return false;
        }
        if (given == 0){
            return true;
        }
        else {
            i = seek(given);
            if(money.get(i) > given){
                return false;
            }
            while(chosen < given) {
                chosen = money.get(i) + chosen;
                money.remove(i);
                temp = given - chosen;
                if (money.size() == 0) {
                    if (chosen == given) {
                        return true;
                    } else {
                        return  false;
                    }
                }
                i = seek(temp);
                if(money.get(i) > temp){
                    if(chosen == given) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            if (chosen == given) {
                return true;
            } else {
                return false;
            }
        }
    }

}