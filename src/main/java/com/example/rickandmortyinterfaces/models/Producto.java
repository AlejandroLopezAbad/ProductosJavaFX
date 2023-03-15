package com.example.rickandmortyinterfaces.models;

import javafx.beans.property.*;

public class Producto {

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty category;
    private StringProperty image;
    private StringProperty description;
    private DoubleProperty price;

    public Producto(int id, String name, String category, String image, String description, double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.image = new SimpleStringProperty(image);
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category = new SimpleStringProperty(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public String getImage() {
        return image.get();
    }

    public void setImage(String image) {
        this.image = new SimpleStringProperty(image);
    }

    public StringProperty imageProperty() {
        return image;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price = new SimpleDoubleProperty(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name=" + name +
                ", category=" + category +
                ", image=" + image +
                ", description=" + description +
                ", price=" + price +
                '}';
    }
}
