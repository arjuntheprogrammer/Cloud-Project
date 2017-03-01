package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.simple.JSONObject;

import Server.ServerInterface;

public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {

	protected ClientImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
