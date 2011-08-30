package tasks.client;

import java.util.List;

import tasks.shared.model.MyUser;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface TaskService extends RemoteService {
	String greetServer(String name) throws IllegalArgumentException;
	
	List<MyUser> getUserList();
	MyUser getUser(String id);

}
