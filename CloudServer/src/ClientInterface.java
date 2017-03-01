

import java.rmi.Remote;
import java.rmi.RemoteException;

import org.json.simple.JSONObject;

public interface ClientInterface extends Remote {
	public boolean sendData(String filename, byte[] data, int len)throws RemoteException;
	public String getName() throws RemoteException;
	
//	public  JSONObject printFnames(String sDir) throws Exception;
//  public  String print(String str) throws Exception;
//	public byte[] downloadFile(String fileName) throws Exception;
//	public boolean uploadFile(byte[] fileData, String fileName) throws Exception;
}
