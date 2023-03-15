package com.example.rickandmortyinterfaces.Controller;

import com.example.rickandmortyinterfaces.models.Producto;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ListViewController {
    private final int OK = 200;
    @FXML
    private ListView<Producto> listaProductos ;

    @FXML
    private Button botonrecargar;

    private ObservableList<Producto> list = FXCollections.observableArrayList();

    //AQUI ES PARA PASAR LA INFO
    public ObjectProperty<Producto> selectedProducto = new SimpleObjectProperty<Producto>(null);

    private Producto getProductoSelected(){return selectedProducto.get(); }

    public ObjectProperty<Producto> selectedProductoProperty() {
        return selectedProducto;
    }

    public void setSelectedProducto(Producto selectedProducto) {
        this.selectedProducto.set(selectedProducto);
    }


    //APARTIR DE AQUI PARA PASAR LISTA

    public ListProperty<Producto> selectedList = new SimpleListProperty<Producto>(null);

    ListProperty<Producto>  getListaProductoSelected(){return selectedList; }

    public ListProperty<Producto> selectedProductoListProperty() {
        return selectedList;
    }

    public void setSelectedListProducto(ListProperty<Producto> selectedListProducto) {
        this.selectedList.set(selectedListProducto);
    }


    @FXML
    private void initialize(){
        botonrecargar.setDisable(false);
        listaProductos.setItems(list);

        refreshList();
        productoPulsado();



    }

    @FXML
    private void refreshList() {
        new Thread(() -> {

            botonrecargar.setDisable(true);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://fakestoreapi.com/products")).build();
            HttpResponse<String> response;
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (response.statusCode() == OK) {
                fillTable(response);


                Platform.runLater(() -> {
                    botonrecargar.setDisable(false);
                });
            }


        }).start();


    }


    private void fillTable(HttpResponse<String> response) {
        JSONArray json = new JSONArray(response.body());
        for (int i = 0; i < json.length(); i++) {
            JSONObject object = json.getJSONObject(i);
            Producto product = new Producto(
                    object.getInt("id"),
                    object.getString("title"),
                    object.getString("category"),
                    object.getString("image"),
                    object.getString("description"),
                    object.getDouble("price")
            );
            list.add(product);

        }
        selectedList.set(list);
        System.out.println("LETSGO");
        System.out.println(selectedList);
        listaProductos.setItems(list);

    }



    private void productoPulsado(){
        listaProductos.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) -> {
                    if (newValue != null){
                        System.out.println("Seleccionado");
                        selectedProducto.set(newValue);
                    }
                })



        );
    }

    private void addlistaProducto(){


    }















}
