package app.view;

import app.App;
import app.model.Baza;
import app.model.Raspored;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class PrviView extends VBox {
    private HBox hb;
    private ComboBox<String> cb;
    private Button btnPrikazi;
    private Label lbl;
    private Button btnStatistika;

    private ObservableList<Raspored> olRaspored;
    private TableView<Raspored> tv;
    private Button btnStampa;

    public PrviView(){
        // super(7);
        napraviElemente();
        dodajElemente();
        dodatnaPodesavanja();
        dodajAkcije();
    }

    private void dodajAkcije() {
        btnStatistika.setOnAction(a -> {
            App.getPrviProzor().close();
            App.getDrugiProzor().show();
        });

        btnPrikazi.setOnAction(a -> {
            String selektovanaUcionica = cb.getSelectionModel().getSelectedItem();
            olRaspored.clear();
            olRaspored.addAll(Baza.getInstance().getFullRaspored().get(selektovanaUcionica));
        });
    }

    private void napraviElemente() {
        hb = new HBox();
        cb = new ComboBox<>();
        Set<String> ucionice = new TreeSet<>(Baza.getInstance().getFullRaspored().keySet());

        cb.getItems().addAll(ucionice);
        cb.getSelectionModel().selectFirst();
        btnPrikazi = new Button("Prikazi");
        lbl = new Label("Poruka");
        btnStatistika = new Button("Statistika");

        olRaspored = FXCollections.observableArrayList(Baza.getInstance().getFullRaspored().get(cb.getSelectionModel().getSelectedItem()));
        tv = new TableView<>(olRaspored);
        tv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // tv.getItems().addAll(Baza.getInstance().getFullRaspored().get(cb.getSelectionModel().getSelectedItem()));
        TableColumn<Raspored, String> tc1 = new TableColumn<>("Predmet");
        TableColumn<Raspored, String>  tc2 = new TableColumn<>("Nastavnik");
        TableColumn<Raspored, String>  tc3 = new TableColumn<>("Vrsta");
        TableColumn<Raspored, String>  tc4 = new TableColumn<>("Grupe");
        TableColumn<Raspored, String>  tc5 = new TableColumn<>("Termin");
        TableColumn<Raspored, String>  tc6 = new TableColumn<>("Dan");

        tc1.setCellValueFactory(new PropertyValueFactory<>("predmet"));
        tc2.setCellValueFactory(new PropertyValueFactory<>("profesor"));
        tc3.setCellValueFactory(new PropertyValueFactory<>("vrsta"));
        tc4.setCellValueFactory(new PropertyValueFactory<>("grupe"));
        tc5.setCellValueFactory(new PropertyValueFactory<>("termin"));
        tc6.setCellValueFactory(new PropertyValueFactory<>("dan"));

        tv.getColumns().addAll(tc1, tc2, tc3, tc4, tc5, tc6);

        btnStampa = new Button("Stampa");
    }

    private void dodajElemente() {
        hb.getChildren().addAll(cb, btnPrikazi, lbl, btnStatistika);
        getChildren().addAll(hb, tv, btnStampa);
    }

    private void dodatnaPodesavanja() {
        hb.setSpacing(7);
        hb.setAlignment(Pos.CENTER);
        setSpacing(7);
        setPadding(new Insets(7, 0, 7, 0));
        setAlignment(Pos.CENTER);
    }
}
