package m2tiil.agence.voyage.client.widgets.connection;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Connection extends Composite {

	public interface UiUserConnection extends UiBinder<Widget, Connection> {

	}

	private static UiUserConnection uiUserConnection = GWT
			.create(UiUserConnection.class);

	@UiField
	Label login;
	@UiField
	Label password;
	@UiField
	Button connect;
	@UiField
	TextBox loginName;
	@UiField
	TextBox paswd;

	public Connection() {
		initWidget(uiUserConnection.createAndBindUi(this));
	}
}