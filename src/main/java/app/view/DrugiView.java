package app.view;

import app.App;
import app.model.Baza;
import app.model.Grupa;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;

public class DrugiView extends VBox {
    private TableView<Grupa> tv;
    private Button btnPovratak;

    public DrugiView(){
        super(7);

        tv = new TableView<>();
        tv.getItems().addAll(Baza.getInstance().getGrupe());
        TableColumn<Grupa, String> tc1 = new TableColumn<>("Grupa");
        TableColumn<Grupa, String> tc2 = new TableColumn<>("Dan");
        TableColumn<Grupa, Integer> tc3 = new TableColumn<>("Broj casova");

        tc1.setCellValueFactory(new PropertyValueFactory<>("oznaka"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("dan"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("brojCasova"));

        tv.getColumns().addAll(tc1, tc2, tc3);

        btnPovratak = new Button("Povratak");

        getChildren().addAll(tv, btnPovratak);
        setPadding(new Insets(0, 0, 7, 0));
        setAlignment(Pos.CENTER);

        btnPovratak.setOnAction(a -> {
            App.getDrugiProzor().close();
            App.getPrviProzor().show();
        });
    }
}
