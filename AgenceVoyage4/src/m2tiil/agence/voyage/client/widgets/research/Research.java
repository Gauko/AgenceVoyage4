package m2tiil.agence.voyage.client.widgets.research;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Research extends Composite {

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, Research> {
	}

	public Research() {
		initWidget(binder.createAndBindUi(this));
	}

}
