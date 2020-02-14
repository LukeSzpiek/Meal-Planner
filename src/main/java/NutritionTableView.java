package src.main.java;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;

 /**
  * A generic, empty, TableView that can be used throughout the application to display nuturitional information about a meal.
  *
  * @author Luke.s
  * @version V2
  */
public class NutritionTableView
 {

TableView<Meals> table;

/**
 * Constructor for the class.
 * @param originalTable The original TableView with no added columns.
 * @param data Data to insert into this new tableView.
 */
public NutritionTableView(TableView<Meals> originalTable, ObservableList<Meals> data){

    originalTable.setEditable(false);

    TableColumn<Meals, String> nameCol = new TableColumn<Meals, String>("Name");
    nameCol.setCellValueFactory(new PropertyValueFactory<Meals,String>("name"));

    TableColumn<Meals, Integer> calCol = new TableColumn<Meals, Integer>("Cals");
    calCol.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("calories"));

    TableColumn<Meals, Integer> carbCol = new TableColumn<Meals, Integer>("Carbs");
    carbCol.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("carbs"));

    TableColumn<Meals, Integer> proteinCol = new TableColumn<Meals, Integer>("Prot");
    proteinCol.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("protein"));

    TableColumn<Meals, Integer> fatCol = new TableColumn<Meals, Integer>("Fat");
    fatCol.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("fat"));

    TableColumn<Meals, Integer> satFatCol = new TableColumn<Meals, Integer>("Satu");
    satFatCol.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("saturates"));

    TableColumn<Meals, Integer> sugars = new TableColumn<Meals, Integer>("Suga");
    sugars.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("sugar"));

    originalTable.getColumns().addAll(nameCol, calCol, carbCol, proteinCol, fatCol, satFatCol, sugars);

    originalTable.setItems(data);
    this.table = originalTable;
}

public TableView<Meals> getNutritionTableView(){
  return table;
}

}
