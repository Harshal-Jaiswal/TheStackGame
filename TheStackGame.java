/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thestackgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author HP JAISWAL
 */
public class TheStackGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        String s =sc.nextLine();
        String BolckNo[] = s.split(" ");
        ArrayList<ArrayList<Integer>> NumList = new ArrayList();
        ArrayList<Integer> Numb ;
        int min=9999;
        for(int i=0; i<BolckNo.length ; i++){
            Numb = new ArrayList();
            for(int j=0;j< Integer.parseInt(BolckNo[i]); j++){
                Numb.add(sc.nextInt());
                
            }
            if(addList(Numb) < min){
                    min = addList(Numb);
                }
            NumList.add(Numb);
        }
        int m =calcMin(NumList,min);
        System.out.println(m);
    }
    
    public static int calcMin(ArrayList<ArrayList<Integer>> NumList,int min){
        
        for(int i=0; i< NumList.size(); i++){
            if (addList(NumList.get(i)) > min){
                NumList.get(i).remove(0);
                return calcMin(NumList, min);
            }else{
                if(addList(NumList.get(i)) < min){
                    return calcMin(NumList, addList(NumList.get(i)));
                }
            }
        }
        return min;
    }
    
    public static int addList(ArrayList<Integer> a){
        int sum =0;
        for(int x=0; x<a.size();x++){
            sum+=a.get(x);
        }
        return sum;
    }
}
