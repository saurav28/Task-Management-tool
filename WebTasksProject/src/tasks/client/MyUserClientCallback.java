package tasks.client;

import java.util.List;


import tasks.client.ui.UITable;
import tasks.shared.model.DataSource;
import tasks.shared.model.MyUser;


import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MyUserClientCallback implements AsyncCallback<List<MyUser>>{
	
	private UITable table;

	public MyUserClientCallback(UITable table) {
		this.table = table;

	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());

		
	}

	@Override
	public void onSuccess(List<MyUser> result) {
		List<MyUser> users = result;
		DataSource datasource = new DataSource(users);
		table.setInput(datasource);
		for (MyUser user : users) {
			System.out.println(user.getUsername());
		}

		
	}

}
