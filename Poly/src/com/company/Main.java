package com.company;
import java.util.Scanner;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
               /*
        ArrayList<Double> Arr(int n){

            ArrayList<Double> arr=new ArrayList<Double>();
            int i;
            for (i=0; i<n; i++){
                Scanner in= new Scanner(System.in);
                arr.add(in.nextDouble());
            }
            return arr;
        }
        */
	// write your code here


        Poly P0=new Poly();
        Poly P1=new Poly(3);
        Poly P2=new Poly(5);

        Poly P11 =P1.Deriv();
        Poly P12 =P1.Integ(1.1);
        Poly P13=P11.Sum(P12);
        Poly P14=P11.Prod(P12);

        P1.toString();
        P12.toString();
        P13.toString();

    }



}
