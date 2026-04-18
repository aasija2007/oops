import java.io.*;
import java.util.*;
class Solution {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter the number of students");
 int n = sc.nextInt();
 sc.nextLine();
 StudentInfo si[] = new StudentInfo[n];
 for(int i =0 ;i<n;i++){
 System.out.println("Enter the student "+(i+1)+" detail");
 String input=sc.nextLine();
 String arr[] = input.split(",");
 String a =arr[0];
 int b =Integer.parseInt(arr[1]);
 int c =Integer.parseInt(arr[2]);
 int d =Integer.parseInt(arr[3]);
 int e =Integer.parseInt(arr[4]);
 
 
 
 si[i] = new StudentInfo (a,b,c,d,e);
 
 }
 System.out.println("Student Details");
 for(int i =0;i<n;i++){
 si[i].display();
 }
 
 }
}
class StudentInfo{
 
 String name;
 int age;
 int rollno;
 int batch;
 int marks;
 
 StudentInfo(String a, int b , int c, int d, int e){
 this.name = a; this.age = b ;
 this.rollno = c;
 this.batch = d;
 this.marks = e;
 
 }
 void display(){
 System.out.println("Name: "+name);
 System.out.println("Age: "+age);
 System.out.println("rollno: "+rollno);
 System.out.println("Batch: "+batch);
 System.out.println("Marks: "+marks);
}
}