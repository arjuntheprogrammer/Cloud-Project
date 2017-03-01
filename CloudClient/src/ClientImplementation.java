

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONObject;


public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {
	public String name;
	protected ClientImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean sendData(String filename, byte[] data, int len) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			String path_where_client_saves="/home/arjun/";
			File f= new File(path_where_client_saves+filename);
			f.createNewFile();
			FileOutputStream out=new FileOutputStream(f, true);
			out.write(data, 0, len);
			out.flush();
			out.close();
			System.out.println("Done writing data...");
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return true;
	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return name;
	}
	
}
