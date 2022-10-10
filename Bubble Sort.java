package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many elements you want in the array ? ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        input(arr);
        System.out.println(Arrays.toString(arr));
        bubblesort(arr);
        System.out.println("The array after sorting is : ");
        System.out.println(Arrays.toString(arr));
    }
    static void input(int[] arr){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Enter the " + (i + 1) + " element : ");
            arr[i] = sc.nextInt();
        }
    }
    static void bubblesort(int[] arr){
        for(int i = 0;i < arr.length-1;i++){
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
