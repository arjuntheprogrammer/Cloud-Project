import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class Server {
	
	   public static void main(String argv[]) {
		      if(System.getSecurityManager() == null) {
		         System.setSecurityManager(new RMISecurityManager());
		      }
	
	      try {
	    	  System.out.println("server started1!!!");
	    	 Implement fi = new Implement();
	         Naming.rebind("dir", fi);
		     System.out.println("server started2!!!");
		         
		      } catch(Exception e) {
		         System.out.println("error in server: "+e.getMessage());
		         e.printStackTrace();
		      }
		   }

	   
	   
//	   public static void main(String a[]) throws Exception{
//			Runtime.getRuntime().exec("/bin/bash -c rmiregistry");
//			TimeUnit.SECONDS.sleep(2);
//			System.setProperty("java.security.policy","Server.policy");
//			System.setProperty("java.rmi.server.hostname","172.16.80.71");
//			
//			if(System.getSecurityManager()==null)
//			System.setSecurityManager(new RMISecurityManager());
//			
//			
//			Implement fi = new Implement();
//	        Naming.rebind("dir", fi);
//	        System.out.println("server started!!!");
//	         
//			
//			AddC obj = new AddC();
//			String url="rmi://172.16.80.71:1099/ADD";
//			
//			Naming.rebind(url, obj);
//			
//			System.out.println("Server started");
//		}
}
