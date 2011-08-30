package tasks.client.ui;

import java.util.List;

import tasks.shared.model.DataSource;
import tasks.shared.model.MyUser;



import com.google.gwt.user.client.ui.FlexTable;

public class UITable extends FlexTable {
	DataSource input;


	public UITable(DataSource input) {
		super();
		this.setCellPadding(1);
		this.setCellSpacing(0);
		this.setWidth("100%");
		
		this.setInput(input);

	}
	
	public void setInput(DataSource input) {
		for (int i = this.getRowCount(); i > 0; i--) {
			this.removeRow(0);
		}
		if (input == null) {
			return;
		}

		int row = 0;
		List<String> headers = input.getTableHeader();
		if (headers != null) {
			int i = 0;
			for (String string : headers) {
				this.setText(row, i, string);
				i++;
			}
			row++;
		}
		// Make the table header look nicer
		this.getRowFormatter().addStyleName(0, "tableHeader");

		List<MyUser> rows = input.getUsers();
		int i = 1;
		for (MyUser myUser : rows) {
			this.setText(i, 0, myUser.getId());
			this.setText(i, 1, myUser.getUsername());
			this.setText(i, 2, myUser.getNumberOfHits());
			this.setBorderWidth(2);
			i++;
		}
		this.input = input;
	}


}
