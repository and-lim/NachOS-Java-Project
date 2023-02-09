package nachos.proj1;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;
import nachos.machine.Timer;


public class FileSystemMenu {
	

	public void addProduct() {
		String filename,message;
		console.writeLn("Input Phone Name;");
		filename = console.read();
		
		console.write("Input Category:");
		message = console.read();
		
		console.write("Input Price:");
		message = console.read();
		
		OpenFile ofile = fs.open(filename, true);
		byte[] messageBytes = message.getBytes();
		ofile.write(messageBytes, 0, messageBytes.length);
		
	}
	
	
	public void viewProduct() {
		String filename,message;
		console.writeLn("Input phone Name;");
		filename = console.read();
		
		console.write("Input Category:");
		message = console.read();
		
		console.write("Input Price:");
		message = console.read();
		
		
		OpenFile ofile = fs.open(filename, false);
		if(ofile !=null) {
			byte[] messageBytes = new byte[ofile.length()];
			ofile.read(messageBytes, 0, messageBytes.length);
			message = new String(messageBytes);
			console.writeLn("Message:");
			console.writeLn(message);
		}else {
			console.writeLn("There is no mobile phone yet");
		}
	}
	public void deleteProduct() {
		String filename,message;
		console.writeLn("Input phone Name;");
		filename = console.read();
		
		console.write("Input Category:");
		message = console.read();
		
		console.write("Input Price:");
		message = console.read();
		
		OpenFile ofile = fs.open(filename, false);
		
		if(ofile !=null) {
			message = "\n" +message;
			byte[] messageBytes = message.getBytes();
			ofile.write(ofile.length(), messageBytes, 0, messageBytes.length);
		}else {
			console.writeLn("Mobile Phone delete successfully");
		}
	}
	
	
	private MyConsole console;
	private Integer input;
	private FileSystem fs;
	
	Integer choose =0;
	Timer t = Machine.timer();
	Runnable handler = new Runnable( ) {
		
		@Override
		public void run() {
			System.out.println("");
			try {
				Thread.sleep(100000000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	};
	
	
	public FileSystemMenu() {
		console = new MyConsole();
		fs = Machine.stubFileSystem();
				
		do {
			console.writeLn("GeitadenwaShop");
			console.writeLn("==============");
			console.writeLn("1.Add New Product");
			console.writeLn("2.View Product");
			console.writeLn("3.Delete Existing Product");
			console.writeLn("4.exit");
			console.writeLn("choose >>");
			input = console.readInt();
			
			switch (input) {
			case 1:
				addProduct();
				break;
			case 2:
				viewProduct();
				break;
			case 3:
				deleteProduct();	
				break;
			}		
		} while  (input !=4);
			
	}

}
