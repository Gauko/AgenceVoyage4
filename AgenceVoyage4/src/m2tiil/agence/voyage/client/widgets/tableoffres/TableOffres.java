package m2tiil.agence.voyage.client.widgets.tableoffres;

import java.util.ArrayList;

import m2tiil.agence.voyage.server.bdd.dao.OffreDAO;
import m2tiil.agence.voyage.shared.bdd.pojo.Offre;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

public class TableOffres extends Composite {

	private static final Binder binder = GWT.create(Binder.class);

	final SimplePager pager = new SimplePager();
	final ListDataProvider<Offre> listOffers = new ListDataProvider<Offre>();

	@UiField(provided = true)
	CellTable<Offre> cellTable = new CellTable<Offre>();

	interface Binder extends UiBinder<Widget, TableOffres> {
	}

	public TableOffres() {
		initWidget(binder.createAndBindUi(this));
		createOffersTable();
	}

	public void createOffersTable() {

		// Create tweet column.
		TextColumn<Offre> titleCollumn = new TextColumn<Offre>() {
			@Override
			public String getValue(Offre offre) {
				return offre.getLibelle();
			}
		};

		// Create tweet column.
		TextColumn<Offre> priceColumn = new TextColumn<Offre>() {
			@Override
			public String getValue(Offre offre) {
				return String.valueOf(offre.getPrix());
			}
		};

		final MultiSelectionModel<Offre> multiSelectionModel = new MultiSelectionModel<Offre>();
		cellTable.setSelectionModel(multiSelectionModel,
				DefaultSelectionEventManager.<Offre> createCheckboxManager());

		Column<Offre, Boolean> checkColumn = new Column<Offre, Boolean>(
				new CheckboxCell(true, false)) {

			@Override
			public Boolean getValue(Offre object) {
				return multiSelectionModel.isSelected(object);
			}
		};

		// Add the columns.
		cellTable.addColumn(checkColumn);
		cellTable.addColumn(titleCollumn, "Intitulle");
		cellTable.addColumn(priceColumn, "Prix");
		ArrayList<Offre> tmp = OffreDAO.selectAll();
		listOffers.setList(tmp);
		
		listOffers.addDataDisplay(cellTable);

		final SimplePager pager = new SimplePager();
		pager.setDisplay(cellTable);
	}

}
