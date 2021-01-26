package com.zyh.leetcode.simple;

import android.util.Log;

public class SimpleArray {
    public static void main(String[] args) {
        chooseSort(new int[]{4,5,6,1,3,2});

    }

    public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3) {
            return false;
        }
        int tempStart = arr[0];
        int tempEnd = arr[arr.length - 1];
        int i = 1;
        for(; i < arr.length; i++) {
            if(arr[i] > tempStart) {
                tempStart = arr[i];
            }else {
                i = i - 1;
                break;
            }
        }
        System.out.println(i);
        int j = arr.length - 2;
        for(; j >= 0; j--) {
            if(arr[j] > tempEnd) {
                tempEnd = arr[j];
            }else {
                j = j + 1;
                break;
            }
        }
        System.out.println(j);

        return i == j;
    }

    public static void chooseSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);

        }
    }


}
