package ar.edu.unrn.modelo;

import ar.edu.unrn.modelo.punto2.MenuElectronico;
import ar.edu.unrn.modelo.punto2.Restaurante;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Sistema de Pedidos - Restaurante");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Label titulo = new Label("Menu");
        titulo.setStyle("-fx-font-size: 24; -fx-font-weight: bold;");
        root.getChildren().add(titulo);

        // Agregamos los items
        root.getChildren().add(crearFilaItem("Tira de asado", 15000));
        root.getChildren().add(crearFilaItem("Media docena de empanadas", 6000));
        root.getChildren().add(crearFilaItem("Pizza Mozzarella", 11300));
        root.getChildren().add(crearFilaItem("Gaseosa Pepsi Cola 2Lt.", 4200));
        root.getChildren().add(crearFilaItem("Gaseosa Coca Cola 2.25Lt.", 5250));
        root.getChildren().add(crearFilaItem("Jugo Cepita", 2700));

        // Botón Finalizar
        Button btnFinalizar = new Button("Finalizar pedido");
        btnFinalizar.setStyle("-fx-background-color: lightgray;");
        HBox footer = new HBox(btnFinalizar);
        footer.setAlignment(Pos.CENTER_LEFT);
        root.getChildren().add(footer);

        ScrollPane scroll = new ScrollPane(root);
        scroll.setFitToWidth(true);

        Scene scene = new Scene(scroll, 500, 700);
        stage.setScene(scene);
        stage.show();
    }

    private HBox crearFilaItem(String nombre, double precio) {
        HBox fila = new HBox(10);
        fila.setAlignment(Pos.CENTER_LEFT);

        // Información del item
        Label lblNombre = new Label(nombre);
        lblNombre.setStyle("-fx-font-weight: bold;");
        Label lblPrecio = new Label("Precio: " + precio + "$");
        lblPrecio.setStyle("-fx-text-fill: blue;");
        VBox infoBox = new VBox(lblNombre, lblPrecio);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Botones
        Button btnAgregar = new Button("Agregar x1");
        btnAgregar.setStyle("-fx-background-color: lightgray;");
        Button btnQuitar = new Button("Quitar x1");
        btnQuitar.setStyle("-fx-background-color: lightgray;");

        fila.getChildren().addAll(infoBox, spacer, btnAgregar, btnQuitar);
        return fila;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

