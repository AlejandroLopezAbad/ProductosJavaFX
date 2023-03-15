package com.example.rickandmortyinterfaces.Controller;

import com.example.rickandmortyinterfaces.HelloApplication;
import com.example.rickandmortyinterfaces.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.Objects;

public class MainViewController {

    @FXML
    private Button btodetalle;
    @FXML
    private Button btografico;
    @FXML
    private Button btolista;


    //iniciamos todos los includes
    @FXML
    private StackPane stackpaneMain;

    @FXML
    private VBox vistaDetalle;

    @FXML
    private VBox graficaView;

    @FXML
    private VBox listView;

    @FXML
    private ListViewController listViewController;

    @FXML
    private GraficaController graficaController;

    @FXML
    private VistaDetalleController vistaDetalleController;



    @FXML
    private void initialize(){

        //para el producto
        listViewController.selectedProductoProperty().addListener((observable, oldValue, newValue) ->{

            if(newValue !=null){
                System.out.println(newValue);
                cambiarVistaDetalle(newValue);

            }

        });
         ///Para la lista
      /*  listViewController.selectedProductoListProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("LISTA DESDE EL MAIN");
            System.out.println(newValue);

            if(newValue !=null){

                cargarGrafica(newValue);

            }

        });
*/
        //LINEA PARA QUE FUNCIONE EL CSS ACORDARSE DE CAMBIAR de AÑADIR  styleClass="fondo" en el fxml
        stackpaneMain.getStylesheets().add(Objects.requireNonNull(HelloApplication.class.getResource("style/Claro.css")).toString());



    }









    @FXML
    private void detailView(){
        graficaView.setVisible(false);
        graficaView.toBack();
        listView.toBack();
        listView.setVisible(false);
        vistaDetalle.toFront();
        vistaDetalle.setVisible(true);
    }


    @FXML
    private void graficaView(){
        vistaDetalle.toBack();
        vistaDetalle.setVisible(false);
        listView.toBack();
        listView.setVisible(false);
        graficaView.toFront();
        graficaView.setVisible(true);


    }

    @FXML
    private void listView(){

        vistaDetalle.toBack();
        vistaDetalle.setVisible(false);
        graficaView.toBack();
        graficaView.setVisible(false);
        listView.toFront();
        listView.setVisible(true);


    }

    private void cambiarVistaDetalle(Producto producto){
        graficaView.setVisible(false);
        graficaView.toBack();
        listView.toBack();
        listView.setVisible(false);
        vistaDetalle.toFront();
        vistaDetalle.setVisible(true);
        vistaDetalleController.setInfo(producto);

    }


    private void cargarGrafica(List<Producto> list){
        if (graficaController !=null){
            graficaController.loadPieChart(list);
        }

    }








}
