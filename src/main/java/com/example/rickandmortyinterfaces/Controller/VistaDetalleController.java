package com.example.rickandmortyinterfaces.Controller;

import com.example.rickandmortyinterfaces.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaDetalleController {

    @FXML
    public TextField textFieldCategoria;
    @FXML
    public TextField textFieldNombre;
    @FXML
    public TextField textFieldPrecio;
    @FXML
    public TextArea textAreaDescripcion;

    @FXML
    public ImageView imagenProduct;





    public void setInfo(Producto producto){
        textFieldCategoria.setText(producto.getCategory());
        textFieldNombre.setText(producto.getName());
        textFieldPrecio.setText(String.valueOf(producto.getPrice()));
        textAreaDescripcion.setText(producto.getDescription());
        loadImage(producto.getImage());
    }

    private void loadImage(String image) {
        new Thread(() -> {
            imagenProduct.setImage(null);

            imagenProduct.setImage(new Image(image));

        }).start();
    }



}
