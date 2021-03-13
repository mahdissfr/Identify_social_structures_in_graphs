package aut.ir;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(" use? 1-matrix 2-adjancy list");
        int selector=scanner.nextInt();
        System.out.println("which sort?");
        System.out.println("1-quickSort 2-insertionSort 3-mergeSort 4-bubbleSort 5-optimumSort");
        int sortSelector=scanner.nextInt();
        int N=0;
        int optSelector=0;
        if(sortSelector==5){
            System.out.println("enter N");
            N=scanner.nextInt();
            System.out.println("continue with: 1-bubbleSort 2-insertionSort");
            optSelector=scanner.nextInt();
        }
        ToDo toDo=new ToDo(selector,sortSelector,N,optSelector);

    }
}

