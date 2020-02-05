package src.main.java;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableRow;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.util.Callback;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import java.util.Iterator;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.animation.FadeTransition;
import javafx.scene.paint.*;
import javafx.util.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import java.io.*;
import java.util.*;
import java.lang.Object.*;
import javafx.scene.layout.*;
import java.lang.Math.*;
import javafx.fxml.FXMLLoader;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

/**
 * Creates a generic, empty, table that is used by all of the meals in the application.
 */

public class NutritionTableView
 {

TableView<Meals> table;

public NutritionTableView(TableView<Meals> originalTable, ObservableList<Meals> data){

    originalTable.setEditable(false);

    TableColumn<Meals, String> nameCol = (TableColumn<Meals, String>)new TableColumn("Name");

    nameCol.setCellValueFactory((Callback)new PropertyValueFactory("name"));
    TableColumn<Meals, Integer> calCol = (TableColumn<Meals, Integer>)new TableColumn("Cals");

    calCol.setCellValueFactory((Callback)new PropertyValueFactory("calories"));
    TableColumn<Meals, Integer> carbCol = (TableColumn<Meals, Integer>)new TableColumn("Carbs");

    carbCol.setCellValueFactory((Callback)new PropertyValueFactory("carbs"));
    TableColumn<Meals, Integer> proteinCol = (TableColumn<Meals, Integer>)new TableColumn("Prot");

    proteinCol.setCellValueFactory((Callback)new PropertyValueFactory("protein"));
    TableColumn<Meals, Integer> fatCol = (TableColumn<Meals, Integer>)new TableColumn("Fat");

    fatCol.setCellValueFactory((Callback)new PropertyValueFactory("fat"));
    TableColumn<Meals, Integer> satFatCol = (TableColumn<Meals, Integer>)new TableColumn("Satu");

    satFatCol.setCellValueFactory((Callback)new PropertyValueFactory("saturates"));
    TableColumn<Meals, Integer> sugars = (TableColumn<Meals, Integer>)new TableColumn("Suga");

    sugars.setCellValueFactory((Callback)new PropertyValueFactory("sugar"));

    originalTable.getColumns().addAll(nameCol, calCol, carbCol, proteinCol, fatCol, satFatCol, sugars);

    System.out.println(data.size()+" is the size.");
    originalTable.setItems(data);
    System.out.println("test");
    this.table = originalTable;
}

public TableView<Meals> getNutritionTableView(){
  return table;
}

}