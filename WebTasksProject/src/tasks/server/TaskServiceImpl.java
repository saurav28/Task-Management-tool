package tasks.server;

import java.util.ArrayList;

import java.util.List;

import tasks.client.TaskService;
import tasks.shared.FieldVerifier;
import tasks.shared.model.MyUser;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class TaskServiceImpl extends RemoteServiceServlet implements
		TaskService {
	
	private static final long serialVersionUID = 1L;

	private List<MyUser> userList = new ArrayList<MyUser>();


	
	public TaskServiceImpl() {
		MyUser user = new MyUser();
		user.setId("1");
		user.setUsername("Peter");
		user.setNumberOfHits("15");
		userList.add(user);

		user = new MyUser();
		user.setId("2");
		user.setUsername("Hanz");
		user.setNumberOfHits("25");
		userList.add(user);

	}

	public String greetServer(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);

		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
	
	
	public MyUser getUser(String id) {

		for (Object object : userList) {
			if (((MyUser) object).getId().equals(id))
				return ((MyUser) object);
		}
		return null;
	}

	public List<MyUser> getUserList() {
		return userList;
	}

}
