package Objectlock;
class Objtest{  
  
 void printTable(int n){  
   synchronized(this){//synchronized block  
     for(int i=1;i<=5;i++){  
      System.out.println(n*i);  
      try{  
       Thread.sleep(400);  
      }catch(Exception e){System.out.println(e);}  
     }  
   }  
 }//end of the method  
}  
  
class MyThread1 extends Thread{  
	Objtest t;  
MyThread1(Objtest t){  
this.t=t;  
}  
public void run(){  
t.printTable(5);  
}  
  
}  
class MyThread2 extends Thread{  
	Objtest t;  
MyThread2(Objtest t){  
this.t=t;  
}  
public void run(){  
t.printTable(100);  
}  
}  
