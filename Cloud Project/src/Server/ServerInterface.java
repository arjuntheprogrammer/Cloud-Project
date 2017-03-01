package Server;

import java.rmi.Remote;

import org.json.simple.JSONObject;

public interface ServerInterface extends Remote{
	public  JSONObject printFnames(String sDir) throws Exception;
	public  String print(String str) throws Exception;
//	public byte[] downloadFile(String fileName) throws Exception;
//	public boolean uploadFile(byte[] fileData, String fileName) throws Exception;
}
