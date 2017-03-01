package Server;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Client.ClientInterface;

public class ServerImplementation extends UnicastRemoteObject implements ServerInterface{

	protected ServerImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String print(String str) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public  JSONObject printFnames(String sDir) throws Exception
	{
		File dir=new File(sDir);
		JSONObject obj= new JSONObject();
		//System.out.println(dir.getAbsolutePath());
		if(dir.isFile())
		{
			obj.put("type","file");
			obj.put("name", dir.getName());
			
		}
		else if(dir.isDirectory())
		{
			JSONArray ja = new JSONArray();
			
			File[] faFiles = dir.listFiles();
			
			for(File file: faFiles)
			{
				try{
					ja.add(printFnames(file.getAbsolutePath()));
				}
				catch(Exception e){
					
				}
			}
			
			obj.put("type","directory");
			obj.put("name", dir.getName());
			obj.put("subDir", ja);
		}
		return obj;	
		
		   
	}
	
}
