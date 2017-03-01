

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONObject;


public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {
	public String name;
	
	private String fname = "", fpath = "";
	
	protected ClientImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setFile(String path, String name) {
		fname = name;
		fpath = path;
	}
	@Override
	public boolean recieveDataOnClient(String filename, byte[] data, int len) throws RemoteException {
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

	@Override
	public boolean fileUpload(ServerInterface serverImpl) throws RemoteException {
		try {
			
			File f1 = new File(fpath + fname);
			FileInputStream in = new FileInputStream(f1);
			byte[] mydata = new byte[1024 * 1024];
			int mylen = in.read(mydata);
			while (mylen > 0) {

				serverImpl.recieveDataOnServer(fname, mydata, mylen);
				mylen = in.read(mydata);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}
	
}
