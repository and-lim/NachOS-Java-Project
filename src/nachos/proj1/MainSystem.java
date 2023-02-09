package nachos.proj1;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;

public class MainSystem {
	MyConsole mc = new MyConsole();
	
	public MainSystem() {
		
		new FileSystemMenu();
			
	}

}
