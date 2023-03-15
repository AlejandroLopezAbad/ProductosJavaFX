package com.example.rickandmortyinterfaces.Controller;

import com.example.rickandmortyinterfaces.models.Producto;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GraficaController {
    private final int OK = 200;
    @FXML
    public PieChart grafica;
    @FXML
    private Button botongrafica;




  public void loadPieChart(List<Producto> list) {

        ObservableList<PieChart.Data> listPieChart = FXCollections.observableArrayList(

                new PieChart.Data("Jewelary", list.stream().map(Producto::getCategory).filter("jewelery"::equals).count()),
                new PieChart.Data("Electronics", list.stream().map(Producto::getCategory).filter("electronics"::equals).count()),
                new PieChart.Data("Men's clothing", list.stream().map(Producto::getCategory).filter("men's clothing"::equals).count()),
                new PieChart.Data("Women's clothing", list.stream().map(Producto::getCategory).filter("women's clothing"::equals).count())

        );

        Platform.runLater(() -> {
            grafica.setData(listPieChart);

        });

    }



}
