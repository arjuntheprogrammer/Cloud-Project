import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Implement extends UnicastRemoteObject implements Interface{
	
	public Implement() throws Exception{
		
		super();
	}
	public byte[] downloadFile(String fileName){

		try {
			System.out.println("here1");
		File file = new File(fileName);
		byte buffer[] = new byte[(int)file.length()];

		BufferedInputStream input = new	BufferedInputStream(new FileInputStream(fileName));

		input.read(buffer,0,buffer.length);
		
		input.close();
		return(buffer);

		} catch(Exception e){

		

		e.printStackTrace();

		return(null);

		}
	}
	
	public boolean uploadFile(byte[] fileData , String FileName){

		try {

		File file = new File("/home/arjun/Documents/eclipse/workspace/Upload.txt");
    	BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file.getName()));

    	output.write(fileData,0,fileData.length);
    	output.flush();
    	output.close();
    	
    	return(true);
    	
		} catch(Exception e){

		//System.out.println(Implement.getMessage());

		e.printStackTrace();

		return(false);

		}
	}
	public  JSONObject printFnames(String sDir) throws NullPointerException
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
	@Override
	public String print(String str) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
