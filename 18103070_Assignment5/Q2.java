public class q2 extends Thread {

	public static long maxDiv = 0;
	public static long num = 0;

	public long start;

	public q2(long s) {
		this.start = s;
	}

	public void run() {
		for(long i = this.start; i<=this.start+10000; i++) {
			long divisors=0;
            for(long j=i; j>0; j--)
            {
                if(i%j==0)
                {
                    divisors+=1;
                }
            }
            synchronized(this) {
            if(divisors > maxDiv)
            {
            	
            		maxDiv = divisors;
	                num = i;
            	
            }
        }
		}
	}

	public static void main(String[] args) {
		q2 t1 = new q2(1);
		q2 t2 = new q2(10001);
		q2 t3 = new q2(20001);
		q2 t4 = new q2(30001);
		q2 t5 = new q2(40001);
		q2 t6 = new q2(50001);
		q2 t7 = new q2(60001);
		q2 t8 = new q2(70001);
		q2 t9 = new q2(80001);
		q2 t10 = new q2(90001);

		long start = System.currentTimeMillis();

		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			
		}

		t2.start();
		try {
			t2.join();
		} catch (Exception e) {
			
		}

		t3.start();
		try {
			t3.join();
		} catch (Exception e) {
			
		}

		t4.start();
		try {
			t4.join();
		} catch (Exception e) {
			
		}

		t5.start();
		try {
			t5.join();
		} catch (Exception e) {
			
		}

		t6.start();
		try {
			t6.join();
		} catch (Exception e) {
			
		}

		t7.start();
		try {
			t7.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		t8.start();
		try {
			t8.join();
		} catch (Exception e) {
	
		}

		t9.start();
		try {
			t9.join();
		} catch (Exception e) {
			
		}

		t10.start();
		try {
			t10.join();
		} catch (Exception e) {
	
		}

		long time_elapsed = System.currentTimeMillis() - start;

		System.out.println("Number " + num + " has maximum Divisors which are equal to = " + maxDiv);
        System.out.println("Total time elapsed :" + (time_elapsed)+"milliseconds");
	}
}