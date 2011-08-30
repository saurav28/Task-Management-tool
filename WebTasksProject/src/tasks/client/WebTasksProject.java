package tasks.client;

import tasks.client.ui.UITable;
import tasks.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WebTasksProject implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final TaskServiceAsync greetingService = GWT
			.create(TaskService.class);

	private UITable myTable;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		myTable = new UITable(null);

		Button button = new Button("Check the tasks on clicking the button");

		// We can add style names
		button.addStyleName("pc-template-btn");
		// or we can set an id on a specific element for styling

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setWidth("100%");
		vPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		vPanel.add(button);

		vPanel.add(myTable);

		// Add table and button to the RootPanel
		RootPanel.get().add(vPanel);

		// Create the dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Welcome to GWT Server Communication!");
		dialogBox.setAnimationEnabled(true);
		Button closeButton = new Button("close");
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.setWidth("100%");
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_CENTER);
		dialogVPanel.add(closeButton);

		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				dialogBox.hide();
			}
		});
		// Set the contents of the Widget
		dialogBox.setWidget(dialogVPanel);
		// Add a handler to close the DialogBox
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				MyUserClientCallback myUserCallback = new MyUserClientCallback(myTable);
				greetingService.getUserList(myUserCallback);
			}
		});

		
	}
}
