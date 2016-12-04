package com.company;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;


/**
 * Created by пользователь on 06.10.2016.
 */
public class Poly {
    private ArrayList<Double> AP;

    public String toString(){
        String res="P=";
        for(int i=0; i<this.AP.size();i++){
            res+=this.GETin(i);
        }
        return res;
    }

    //a)
    public Poly(){
        AP=new ArrayList<Double>();
        this.AP.add(0,0.0);
    }

    //b)
    public Poly(ArrayList<Double> koef){
        this.AP=koef;
        koef.clear(); // 1)так нормально?
    }

    //c)
    public Poly(int n) {
        Random rnd=new Random(n);
        for (int i = 0; i < n; i++) {
            this.AP.add((double)(rnd.nextInt())); // 2)вроде как на сайте, а все равно не работает??????????????
        }
    }

    double GETin(int i){
        if ((i>=this.AP.size())||(i<0)){
            throw new IllegalArgumentException("argument less then degree of polynom");
        }
        return this.AP.get(i);
    }

    Poly PUTin(int i, double a){
        // 3)или здесь нужено чтто бы если в многочлен 2й степени добавляли число на например 5е место
        // то многочлен становился многочленом 5й степени?

        if ((i>=this.AP.size())||(i<0));{
            throw new IllegalArgumentException("argument less then degree of polynom");
        }

        this.AP.set(i,a); // 4)???????????????????
        return this;
    }

    Poly Scalar(double k){
        Poly result=new Poly();
        for (int i=0; i<this.AP.size();i++){
            result.AP.set(i,k*this.AP.get(i));
        }
        return result;
    }

    double Value(double x){
        double result=0;
        for(int i=0; i<this.AP.size();i++){
            result+=this.AP.get(i)*Math.pow(x,i);
        }
        return result;
    }



    Poly Sum(Poly B){
        Poly result= new Poly();
        int max;

        // 5)а почему не нужно заполнение нулями? ведь тогда получится что нам придется к Null прибавлять какието числа
        // в случае суммы, а в случае произведения, умножать
        if (this.AP.size()>B.AP.size()) {
            max=this.AP.size();
            for(int j=this.AP.size();j<B.AP.size();j++){
                B.PUTin(j,0.0);
            }
        }
        else {
            max=B.AP.size();
            for(int j=B.AP.size();j<this.AP.size();j++){
                B.PUTin(j,0.0);
            }
        }
        for (int i=0;i<max;i++) {
            result.AP.set(i,this.AP.get(i)+B.AP.get(i));
        }
        return result;
    }

    Poly Prod(Poly B){

        int max;
        if (this.AP.size()>B.AP.size()) {
            max=this.AP.size();
            for(int m=this.AP.size();m<B.AP.size();m++){
                B.PUTin(m,0.0);
            }
        }
        else {
            max=B.AP.size();
            for(int l=B.AP.size();l<this.AP.size();l++){
                B.PUTin(l,0.0);
            }
        }
//6)умножение производится просто нерационаьно, или вобще неправильно??
        Poly result= new Poly();
        int deg=this.AP.size()*B.AP.size();
        for(int k=0;k<deg;k++) {
            double res=0;
            for (int i = 0; i < deg; i++) {
                for (int j = 0; j < deg; j++) {
                    if(k==i+j){
                        res+=this.GETin(i)*B.GETin(j);
                    }

                }

            }
            result.PUTin(k,res);

        }
        return result;
    }

    Poly Deriv(){
        Poly result= new Poly();
        for(int i=0;i<this.AP.size()-1;i++){
            result.PUTin(i,this.GETin(i+1)*i);
        }
        return result;
    }

    Poly Integ(double c){
        Poly result= new Poly();
        result.PUTin(0,c);
        for(int i=1;i<this.AP.size();i++){
            result.PUTin(i,this.GETin(i-1)/i);
        }
        return result;
    }

    /*
    7)у нас как раз на выч методах сейчас задание связанное с численным интегрированием
    поэтому я пока что не пишу этот метод
    */
    double OprInteg(){

        return 0.0;
    }
}