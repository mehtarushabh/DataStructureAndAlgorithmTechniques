package multithreading;

import java.util.concurrent.Semaphore;

/*
 * @author: Rushabh Mehta
 * */
//leetcode 1117
class H2O {
	Semaphore olock;
	Semaphore hfin;
	Semaphore os;
	Semaphore hs;

	public H2O() {
		olock = new Semaphore(1);
		hfin = new Semaphore(0);
		os = new Semaphore(0);
		hs = new Semaphore(0);
	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hs.release();
		os.acquire();
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		releaseHydrogen.run();
		hfin.release();
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		olock.acquire();
		hs.acquire(2);
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
		os.release(2);
		hfin.acquire(2);
		olock.release();
	}
}