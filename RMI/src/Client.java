import java.rmi.*;


public class Client{
	public static void main(String a[]) throws Exception{
		String url="rmi://172.16.80.71:1099/ADD";
		 if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
		 //Runtime.getRuntime().exec("rmiregistry 1099");
		
		AddI obj = (AddI)Naming.lookup(url);
		int n= obj.add(5,4);
		System.out.println("addition in client is :"+n);
	}
}