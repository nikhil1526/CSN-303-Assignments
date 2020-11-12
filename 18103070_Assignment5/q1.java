class q1 extends Thread{
public void run(){
for(int i=1;i<=100;i++)
{
System.out.println(i);
if(i%10==0)
System.out.println("Ten numbers completed");

try{
Thread.sleep(1000);
}catch(Exception e){}
}
}

public static void main(String args[])
{
q1 t1=new q1();
t1.start();

}
}
