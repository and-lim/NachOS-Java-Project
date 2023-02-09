package nachos.proj1;

import java.util.Vector;
import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

public class MyQueue extends ThreadQueue {

	private Vector<KThread> threadList;
	public MyQueue() {
		threadList = new Vector<>();
		
	}

	@Override
	public void waitForAccess(KThread thread) {
		threadList.add(thread);
		
	}

	@Override
	public KThread nextThread() {
		if(threadList.isEmpty()) {
			return null;
		}
		return threadList.get(0);
	}

	@Override
	public void acquire(KThread thread) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
