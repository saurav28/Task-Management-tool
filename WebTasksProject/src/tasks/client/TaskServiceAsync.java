package tasks.client;

import java.util.List;

import tasks.shared.model.MyUser;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface TaskServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;

	void getUser(String id, AsyncCallback<MyUser> callback);

	void getUserList(AsyncCallback<List<MyUser>> callback);
}
