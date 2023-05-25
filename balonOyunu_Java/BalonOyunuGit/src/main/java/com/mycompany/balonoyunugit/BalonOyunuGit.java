/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.balonoyunugit;
import java.util.Scanner;

/**
 *
 * @author kerem
 */
public class BalonOyunuGit {
     //Node sınıfını iç sınıf olarak tanımlayalım.
    private static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data=data;
        }
    }
    
    public static void balonPozisyonuBul(int m,int n){
        //n balon sayısını , m ise patlayacak balonu ifade eder.
        
        Node head=new Node(1);
        Node prev=head;
        
        //Dairesel bağlı liste oluşturalım.
        for(int i=2;i<=n;i++){
            Node newNode=new Node(i);
            prev.next=newNode;
            prev=newNode;
        }
        //Dairesel yapıda en başa dönme durumu/sonu başa bağlama
        prev.next=head;
        
        
        //Listenin son kalan elemanı dışındaki balonlar patlasın
        Node current=head;
        Node prev2=null;
        while(current.next != current){//en son 1 balon kalmazsa
            //M. pozisyondaki balonu patlatalım.
            for(int i=1;i<m;i++){
                prev2=current;
                current=current.next;
            }
            //Patlatılan balon düğümü listeden çıkaralım.
            prev2.next=current.next;
            current=prev2.next;
        }
        
        //Son kalan elemanı gösterelim.
        System.out.println("Patlamayan balonun pozisyonu:" +  current.data);
    }
    
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Kaç adet balon olsun?");
        int n=scanner.nextInt();
        System.out.print("Kaçıncı balon patlasın?");
        int m=scanner.nextInt();
        balonPozisyonuBul(m,n);
    }

}
