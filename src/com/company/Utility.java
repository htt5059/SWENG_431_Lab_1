package com.company;

public class Utility{
    static public int checkName(String name){
        if(name.length()<1||name.length()>15) return 1;
        else if(name.matches("[^A-Za-z\\d\\s,-]")) return 2;
        else{

        }
    }

    static public boolean checkAge(String age){
        if(age.matches("\\d{3}")){
            int val=Integer.parseInt(age);
            if(val>=0 && val<=100) return true;
            else return false;
        }
        return false;
    }
}