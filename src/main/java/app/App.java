package app;

import app.model.Baza;
import app.view.DrugiView;
import app.view.PrviView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private static PrviView pv;
    private static DrugiView dv;
    private static Stage prviProzor;
    private static Stage drugiProzor;

    public static void main(String[] args) {
        System.out.println(Baza.getInstance().getGrupe());
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        prviProzor = stage;
        setPv(new PrviView());
        Scene sc = new Scene(pv, 600, 400);
        prviProzor.setScene(sc);

        drugiProzor = new Stage();
        setDv(new DrugiView());
        drugiProzor.setScene(new Scene(dv));

        prviProzor.show();
    }

    public static void setPv(PrviView pv) {
        App.pv = pv;
    }

    public static void setDv(DrugiView dv) {
        App.dv = dv;
    }

    public static PrviView getPv() {
        return pv;
    }

    public static DrugiView getDv() {
        return dv;
    }

    public static Stage getPrviProzor() {
        return prviProzor;
    }

    public static Stage getDrugiProzor() {
        return drugiProzor;
    }
}
