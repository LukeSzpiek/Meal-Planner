        package src.main.java;
        //package jfxtras.styles.jmetro;

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


        public class MainScreen extends Application
        {

            Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
            public double widthOfWindow = visualBounds.getWidth();
            public double doubleWidthOfWindow = visualBounds.getWidth();
            public double heightOfWindow = visualBounds.getHeight();

            BorderPane mainPane = new BorderPane();
            Scene scene = new Scene((Parent)mainPane, (double)widthOfWindow, (double)heightOfWindow);
            Stage st;

            Style STYLE = Style.LIGHT;
            JMetro jm = new JMetro(scene, STYLE);

            public MainScreen() {

            PlateHandler.loadMealLists(); //The problem.

            }

            @Override
            public void start(Stage stage) {
                //System.out.println("ready to go");
                startAnimation();
                stage.setTitle("Luke's Meal Planner");
                stage.setScene(scene);
                st = stage;
                st.show();

            }

            private void startAnimation(){

                FadeTransition fade = new FadeTransition();
                fade.setOnFinished(ev -> {drawMainMenu();});

                //setting the duration for the Fade transition
                fade.setDuration(Duration.millis(3000));

                //setting the initial and the target opacity value for the transition
                fade.setFromValue(10);
                fade.setToValue(10);

                try{

                URL url = getClass().getResource("/sprites/havslogosmall.jpg");
                Image image = new Image(url.toExternalForm());

                ImageView imageView = new ImageView(image);

                fade.setNode(imageView);
                mainPane.setCenter(imageView);
                }

                catch(Exception e){
                Circle circle = new Circle();
                circle.setCenterX(100.0f);
                circle.setCenterY(100.0f);
                circle.setRadius(50.0f);

                fade.setNode(circle);
                mainPane.setCenter(circle);
                }

                //play the transition
                fade.play();

            }


            public void profileClick() {

                clearScreen();

                Profile prof = new Profile();
                ProfileController profController = new ProfileController(prof);

                try{
                  Parent p = FXMLLoader.load(getClass().getResource("/scenes/profile.fxml"));
                  Scene s = new Scene(p);

                //mainPane.setCenter(profController.getLoader().load());
              }
                catch(Exception e){
                  System.out.println(e);
                  System.out.println("noobs");
                }

            }


            public void drawMainMenu() {

              clearScreen();

              //MainMenuController menuController = new MainMenuController();

              try{
              //mainPane.setCenter(menuController.getLoader().load());
            }
              catch(Exception e){
                System.out.println(e);
              }


              /*
                profile.setOnAction(this::profileClick);
                //foods.setOnAction(ev -> foodsClick(false));
              //today.setOnAction(ev -> plateMenu());
                exit.setOnAction(this::exitClick);
                */
            }

            /**
             * FOODS MENU
             * The menu that pops up when you click the 'foods' menu, or when you try to add an item to your plate.
             * The 'select' variable determines if the user has entered from the plate menu, and are 'selecting' a item to add to their plate.
             */
             /*
            private void foodsClick(boolean select) {
                clearScreen();

                int numberOfButtons = 3;

                Button breakfast = new Button("Breakfast");
                Button lunch = new Button("Lunch");
                Button dinner = new Button("Dinner");
                Button snacks = new Button("Snacks");
                Button boosters = new Button("Boosters");

                ArrayList<Button> buttons = new ArrayList<Button>();
                buttons.add(breakfast);

                breakfast.setOnAction(ev -> typeClick("Breakfast", select));
                buttons.add(lunch);

                lunch.setOnAction(ev -> typeClick("Lunch", select));
                buttons.add(dinner);

                dinner.setOnAction(ev -> typeClick("Dinner", select));
                buttons.add(snacks);

                snacks.setOnAction(ev -> typeClick("Snacks", select));
                buttons.add(boosters);

                boosters.setOnAction(ev -> typeClick("Boosters", select));

                for ( Button button : buttons) {
                    button.setPrefHeight((double)(80));
                    button.setPrefWidth((double)widthOfWindow - 20);
                }

                Image image;

                GridPane gp = new GridPane();

                try{
                image = new Image(new FileInputStream("FoodsLogo.png"));
                ImageView imageView = new ImageView(image);


                //gp.add(imageView,0,1);
                gp.add(imageView,0,1);

                //mp.setTop(imageView);
                }

                catch(Exception e){
                Circle circle = new Circle();
                circle.setCenterX(100.0f);
                circle.setCenterY(100.0f);
                circle.setRadius(50.0f);

                mainPane.getChildren().add(circle);

                }

                //Label foodsLabel = new Label("FOODS");

                //mainPane.setTop(foodsLabel);

                VBox pane = new VBox(

                breakfast, lunch, dinner, snacks, boosters);



                gp.add(breakfast,0,2);

                gp.add(lunch,0,3);

                gp.add(dinner,0,4);

                gp.add(snacks,0,5);

                gp.add(boosters,0,6);

                mainPane.setCenter(gp);

                gp.setPadding(new Insets(20));
                gp.setVgap(10);

                Button exitButton = new Button("Back");

                exitButton.setPrefHeight(50.0);
                exitButton.setPrefWidth((double)widthOfWindow);
                mainPane.setBottom(exitButton);

                if (!select) {
                    exitButton.setOnAction(eve -> drawMainMenu());
                }
                else if (select) {
                    exitButton.setOnAction(eve -> plateMenu());
                }
            }

            /**
             * MEAL TYPE MENU
             * Foods > Breakfast
             * The menu that appears when you click into a category from the 'foods' menu.
             */
             /*
            private void typeClick( String type,  boolean select) {

                Label typeLabel = new Label(type);

                Button add = new Button("Add New Menu Item");
                Button delete = new Button("Delete");
                Button addToPlateButton = new Button("Add to Plate");
                Button back = new Button("Back");

                ArrayList<Button> buttons = new ArrayList<Button>();

                buttons.add(add);
                buttons.add(delete);
                buttons.add(addToPlateButton);
                buttons.add(back);

                if (!select) {
                    back.setOnAction(event -> foodsClick(false));
                }
                else if (select) {
                    back.setOnAction(event -> foodsClick(true));
                }

                add.setOnAction(event -> addClick(type, select));

                VBox vbb = new VBox(add, delete, back);


                // Creates a table, loads in the data, and puts it into the grid, of all of the items you have saved under a category.
                TableView<Meals> table = getTable();
                ObservableList<Meals> data = MealLoader.GenerateData(type, true,"meals.csv");
                table.setItems((ObservableList)data);

                // When a row is clicked, it can then be acted on. You can either press 'add to plate', which will add it to your plate, or you can press 'delete', which will remove it from the csv.
                table.setRowFactory(tv -> {

                    TableRow<Meals> row = (TableRow<Meals>)new TableRow();

                    row.setOnMouseClicked(event -> {
                        if (!row.isEmpty()) {

                            Meals rowData = (Meals)row.getItem();

                            addToPlateButton.setOnAction(ev -> QuantityMenu(rowData));

                            delete.setOnAction(even -> {
                                MealLoader.addRow(rowData, true, "meals.csv");
                                typeClick(type, select);
                            });
                        }

                    });

                    return row;

                });

                //vbb = new VBox(add, delete, addToPlateButton, back);

                for ( Button button : buttons) {
                    button.setPrefHeight(50);
                    button.setPrefWidth((double)widthOfWindow - 20);
                }



                GridPane gp = new GridPane();
                gp.setPadding(new Insets(20));

                gp.add(add,0,2);
                gp.add(delete,0,3);
                gp.add(addToPlateButton,0,1);
                gp.add(back,0,4);
                gp.setVgap(20);

                VBox bottomVBox = new VBox(gp, back);
                back.setPrefWidth(widthOfWindow);

                mainPane.setTop(typeLabel);
                mainPane.setBottom(bottomVBox);
                mainPane.setCenter(table);



            }

            /**
             * QUANTITY MENU
             * PLATE > ADD > BREAKFAST > ADD TO PLATE
             * The menu that appears when you try to add an item to your plate.
             */
             /*
            public void QuantityMenu(Meals data) {
                clearScreen();

                Label quantityLabel = new Label("Enter a Quantity:");
                TextField quantityTextField = new TextField();

                HBox quantityHBox = new HBox();
                quantityHBox.getChildren().addAll(quantityLabel, quantityTextField);
                quantityHBox.setSpacing(10.0);

                Button back = new Button("Back");
                Button confirm = new Button("Confirm Quanity");

                ArrayList<Button> buttons = new ArrayList<Button>();
                buttons.add(back);
                buttons.add(confirm);

                back.setOnAction(event -> typeClick(data.getType(), true));

                for ( Button button : buttons) {
                    button.setPrefHeight((double)(heightOfWindow / 6));
                    button.setPrefWidth((double)widthOfWindow);
                }

                // When you press the 'confirm' button, the data from the meal, and the quantity you inputted, is sent off and then acted on.
                confirm.setOnAction(event -> {
                    AdjustDataQuantity(data, Double.parseDouble(quantityTextField.getCharacters().toString()));
                    plateMenu();
                });

                VBox buttonVBox = new VBox(confirm, back);
                mainPane.setCenter(quantityHBox);
                mainPane.setBottom(buttonVBox);
            }

            /**
             * Creates a new meal item that has had its nutritional quantities adjusted.
             */
             /*
            public void AdjustDataQuantity(Meals meals,  double quantity) {
                System.out.println(quantity);
                if (quantity != 1.0 || quantity != 1 || quantity != 1.00) {
                    meals = new Meals(meals.getKey(), meals.getType(), meals.getName(), meals.getCalories() * quantity, meals.getCarbs() * quantity, meals.getProtein() * quantity, meals.getFat() * quantity, meals.getSaturates() * quantity, meals.getSugar() * quantity, meals.getSalt() * quantity, meals.getFibre() * quantity, meals.getB1() * quantity, meals.getB2() * quantity, meals.getB3() * quantity, meals.getB6() * quantity, meals.getB9() * quantity, meals.getB12() * quantity, meals.getD() * quantity, meals.getIron() * quantity);
                }
                AddMealToMealList(meals);
            }

            /**
             * Adds a new meal, that has perhaps had its quantity adjusted, to the 'plate.csv' file, which holds all of the meals currently on the user's plate, and adds it to the current meal list.
             */
             /*
            private void AddMealToMealList(Meals meal) {
                PlateHandler.addCurrentMeals(meal);

                String type = meal.getType();

                if (type.equals("Breakfast")) {
                    PlateHandler.addBreakfast(meal);
                    MealLoader.addRow(meal, false, "plate.csv");
                }
                else if (type.equals("Lunch")) {
                    PlateHandler.addLunch(meal);
                    MealLoader.addRow(meal, false, "plate.csv");
                }
                else if (type.equals("Dinner")) {
                    PlateHandler.addDinner(meal);
                    MealLoader.addRow(meal, false, "plate.csv");
                }
                if (type.equals("Snacks")) {
                    PlateHandler.addSnack(meal);
                    MealLoader.addRow(meal, false, "plate.csv");
                }
                if (type.equals("Boosters")) {
                    PlateHandler.addBoosters(meal);
                    MealLoader.addRow(meal, false, "plate.csv");
                }
            }

            /**
             * Creates a generic, empty, table that is used by all of the meals in the application.
             */
             /*
            public TableView<Meals> getTable() {
                TableView<Meals> table = (TableView<Meals>)new TableView();

                table.setPrefHeight(300.0);
                table.setPrefWidth(doubleWidthOfWindow);
                table.setEditable(false);

                TableColumn<Meals, String> nameCol = (TableColumn<Meals, String>)new TableColumn("Name");
                nameCol.setPrefWidth((double)(widthOfWindow / 7));

                nameCol.setCellValueFactory((Callback)new PropertyValueFactory("name"));
                TableColumn<Meals, Integer> calCol = (TableColumn<Meals, Integer>)new TableColumn("Cals");
                calCol.setPrefWidth((double)(widthOfWindow / 7));

                calCol.setCellValueFactory((Callback)new PropertyValueFactory("calories"));
                TableColumn<Meals, Integer> carbCol = (TableColumn<Meals, Integer>)new TableColumn("Carbs");
                carbCol.setPrefWidth((double)(widthOfWindow / 7));

                carbCol.setCellValueFactory((Callback)new PropertyValueFactory("carbs"));
                TableColumn<Meals, Integer> proteinCol = (TableColumn<Meals, Integer>)new TableColumn("Prot");
                proteinCol.setPrefWidth((double)(widthOfWindow / 7));

                proteinCol.setCellValueFactory((Callback)new PropertyValueFactory("protein"));
                TableColumn<Meals, Integer> fatCol = (TableColumn<Meals, Integer>)new TableColumn("Fat");
                fatCol.setPrefWidth((double)(widthOfWindow / 7));

                fatCol.setCellValueFactory((Callback)new PropertyValueFactory("fat"));
                TableColumn<Meals, Integer> satFatCol = (TableColumn<Meals, Integer>)new TableColumn("Satu");
                satFatCol.setPrefWidth((double)(widthOfWindow / 7));

                satFatCol.setCellValueFactory((Callback)new PropertyValueFactory("saturates"));
                TableColumn<Meals, Integer> sugars = (TableColumn<Meals, Integer>)new TableColumn("Suga");
                sugars.setPrefWidth((double)(widthOfWindow / 7));

                sugars.setCellValueFactory((Callback)new PropertyValueFactory("sugar"));
                table.getColumns().addAll(nameCol, calCol, carbCol, proteinCol, fatCol, satFatCol, sugars);
                return table;
            }

            /**
             * FOODS > BREAKFAST > ADD NEW MENU ITEM
             *
             * The menu that appears when you are adding a new item to your dictionary.
             *
             */
             /*
            public void addClick(String type,  boolean select) {
                clearScreen();

                Label header = new Label("Add a New Food Item");

                Button back = new Button("Back");
                Button confirm = new Button("Confirm");

                ArrayList<Button> buttons = new ArrayList<Button>();

                buttons.add(back);
                back.setOnAction(event -> typeClick(type, select));

                buttons.add(confirm);

                    for ( Button button : buttons) {
                        button.setPrefHeight(50.0);
                        button.setPrefWidth((double)widthOfWindow);
                    }

                    Label nameLabel = new Label("Name:");
                    TextField nameTextField = new TextField();
                    HBox nameHBox = new HBox();
                    nameHBox.getChildren().addAll(nameLabel, nameTextField );
                    nameHBox.setSpacing(10.0);

                    Label calorieLabel = new Label("Calories:");
                    TextField calorieTextField = new TextField();
                    HBox calorieHBox = new HBox();
                    calorieHBox.getChildren().addAll(calorieLabel, calorieTextField);
                    calorieHBox.setSpacing(10.0);

                    Label carbsLabel = new Label("Carbs:");
                    TextField carbsTextField = new TextField();
                    HBox carbsHBox = new HBox();
                    carbsHBox.getChildren().addAll(carbsLabel, carbsTextField);
                    carbsHBox.setSpacing(10.0);

                    Label proteinLabel = new Label("Protein:");
                    TextField proteinTextField = new TextField();
                    HBox proteinHBox = new HBox();
                    proteinHBox.getChildren().addAll(proteinLabel, proteinTextField);
                    proteinHBox.setSpacing(10.0);

                    Label fatLabel = new Label("Fat:");
                    TextField fatTextField = new TextField();
                    HBox fatHBox = new HBox();
                    fatHBox.getChildren().addAll(fatLabel, fatTextField);
                    fatHBox.setSpacing(10.0);

                    Label saturatesLabel = new Label("Saturates:");
                    TextField saturatesTextField = new TextField();
                    HBox saturatesHBox = new HBox();
                    saturatesHBox.getChildren().addAll(saturatesLabel, saturatesTextField);
                    saturatesHBox.setSpacing(10.0);

                    Label sugarLabel = new Label("Sugar:");
                    TextField sugarTextField = new TextField();
                    HBox sugarHBox = new HBox();
                    sugarHBox.getChildren().addAll(sugarLabel, sugarTextField);
                    sugarHBox.setSpacing(10.0);

                    Label fibreLabel = new Label("Fibre:");
                    TextField fibreTextField = new TextField();
                    HBox fibreHBox = new HBox();
                    fibreHBox.getChildren().addAll(fibreLabel, fibreTextField);
                    fibreHBox.setSpacing(10.0);

                    Label saltLabel = new Label("Salt:");
                    TextField saltTextField = new TextField();
                    HBox saltHBox = new HBox();
                    saltHBox.getChildren().addAll(saltLabel, saltTextField);
                    saltHBox.setSpacing(10.0);

                    Label b1Label = new Label("B1:");
                    TextField b1TextField = new TextField();
                    HBox b1HBox = new HBox();
                    b1HBox.getChildren().addAll(b1Label, b1TextField);
                    b1HBox.setSpacing(10.0);

                    Label b2Label = new Label("B2:");
                    TextField b2TextField = new TextField();
                    HBox b2HBox = new HBox();
                    b2HBox.getChildren().addAll(b2Label, b2TextField);
                    b2HBox.setSpacing(10.0);

                    Label b3Label = new Label("B3:");
                    TextField b3TextField = new TextField();
                    HBox b3HBox = new HBox();
                    b3HBox.getChildren().addAll(b3Label, b3TextField);
                    b3HBox.setSpacing(10.0);

                    Label b6Label = new Label("B6:");
                    TextField b6TextField = new TextField();
                    HBox b6HBox = new HBox();
                    b6HBox.getChildren().addAll(b6Label, b6TextField);
                    b6HBox.setSpacing(10.0);

                    Label b9Label = new Label("B9:");
                    TextField b9TextField = new TextField();
                    HBox b9HBox = new HBox();
                    b9HBox.getChildren().addAll(b9Label, b9TextField);
                    b9HBox.setSpacing(10.0);

                    Label b12Label = new Label("B12:");
                    TextField b12TextField = new TextField();
                    HBox b12HBox = new HBox();
                    b12HBox.getChildren().addAll(b12Label, b12TextField);
                    b12HBox.setSpacing(10.0);

                Label dLabel = new Label("D:");
                TextField dTextField = new TextField();
                HBox dHBox = new HBox();
                dHBox.getChildren().addAll(dLabel, dTextField);
                dHBox.setSpacing(10.0);

                Label ironLabel = new Label("Iron:");
                TextField ironTextField = new TextField();
                HBox ironHBox = new HBox();
                ironHBox.getChildren().addAll(ironLabel, ironTextField);
                ironHBox.setSpacing(10.0);

                confirm.setOnAction(event -> {

                MealLoader.addMeal(type, nameTextField, calorieTextField, carbsTextField, proteinTextField, fatTextField, saturatesTextField,
                sugarTextField, fibreTextField, saltTextField, b1TextField, b2TextField, b3TextField, b6TextField, b9TextField, b12TextField,
                dTextField, ironTextField);

                typeClick(type,select);

                });

                VBox v = new VBox(nameHBox, calorieHBox, carbsHBox, proteinHBox, fatHBox, saturatesHBox, sugarHBox,
                fibreHBox, saltHBox, b1HBox, b2HBox, b3HBox, b6HBox, b9HBox, b12HBox, dHBox, ironHBox);

                GridPane selectionGridpane = new GridPane();

                selectionGridpane.add(nameLabel,0,1);
                selectionGridpane.add(nameTextField,1,1);

                selectionGridpane.add(calorieLabel,0,2);
                selectionGridpane.add(calorieTextField,1,2);

                selectionGridpane.add(carbsLabel,0,3);
                selectionGridpane.add(carbsTextField,1,3);

                selectionGridpane.add(proteinLabel,0,4);
                selectionGridpane.add(proteinTextField,1,4);

                selectionGridpane.add(fatLabel,0,5);
                selectionGridpane.add(fatTextField,1,5);

                selectionGridpane.add(saturatesLabel,0,6);
                selectionGridpane.add(sugarTextField,1,6);

                selectionGridpane.add(fibreLabel,0,7);
                selectionGridpane.add(fibreTextField,1,7);

                selectionGridpane.add(saltLabel,0,8);
                selectionGridpane.add(saltTextField,1,8);

                selectionGridpane.add(b1Label,0,9);
                selectionGridpane.add(b1TextField,1,9);

                selectionGridpane.add(b2Label,0,10);
                selectionGridpane.add(b2TextField,1,10);

                selectionGridpane.add(b3Label,0,11);
                selectionGridpane.add(b3TextField,1,11);

                selectionGridpane.add(b6Label,0,12);
                selectionGridpane.add(b6TextField,1,12);

                selectionGridpane.add(b9Label,0,13);
                selectionGridpane.add(b9TextField,1,13);

                selectionGridpane.add(b12Label,0,14);
                selectionGridpane.add(b12TextField,1,14);

                selectionGridpane.add(dLabel,0,15);
                selectionGridpane.add(dTextField,1,15);

                selectionGridpane.add(ironLabel,0,16);
                selectionGridpane.add(ironTextField,1,16);

                selectionGridpane.setPadding(new Insets(30));

                selectionGridpane.setHgap(10);
                selectionGridpane.setVgap(10);



                ScrollPane scroll = new ScrollPane();
                scroll.setContent(selectionGridpane);

                v.setPadding(new Insets(10.0, 50.0, 50.0, 10.0));
                v.setSpacing(10.0);

                GridPane bottomGp = new GridPane();

                bottomGp.add(confirm,0,1);
                bottomGp.setPadding(new Insets(25));

                VBox vb = new VBox(bottomGp, back);

                mainPane.setBottom(vb);
                mainPane.setCenter(scroll);
                mainPane.setTop(header);
    }




    /**
    * PLATE MENU
    *
    * The menu that appears when you click the 'plate' button in the main menu.
    *
    */
    /*
    private void plateMenu() {
        clearScreen();

        Label breakfastLabel = new Label("Breakfast");
        TableView<Meals> breakfastTable = getTable();
        VBox breakfastBox = new VBox(breakfastLabel, breakfastTable);
        breakfastBox.setPrefHeight(100.0);
        breakfastBox.setPrefWidth(100.0);
        breakfastTable.setItems((ObservableList)MealLoader.GenerateData("Breakfast", false, "plate.csv"));

        Label lunchLabel = new Label("Lunch");
        TableView<Meals> lunchTable = getTable();
        VBox lunchBox = new VBox(lunchLabel, lunchTable);
        lunchBox.setPrefHeight(100.0);
        lunchTable.setItems((ObservableList)MealLoader.GenerateData("Lunch", false,"plate.csv"));

        Label dinnerLabel = new Label("Dinner");
        TableView<Meals> dinnerTable = getTable();
        VBox dinnerBox = new VBox(dinnerLabel, dinnerTable);
        dinnerBox.setPrefHeight(100.0);
        dinnerTable.setItems((ObservableList)MealLoader.GenerateData("Dinner", false,"plate.csv"));

        Label snackLabel = new Label("Snacks");
        TableView<Meals> snackTable = getTable();
        VBox snackBox = new VBox(snackLabel, snackTable);
        snackBox.setPrefHeight(120.0);
        snackTable.setItems((ObservableList)MealLoader.GenerateData("Snacks", false,"plate.csv"));

        Label boosterLabel = new Label("Boosters");
        TableView<Meals> boosterTable = getTable();
        VBox boosterBox = new VBox(boosterLabel, boosterTable);
        boosterBox.setPrefHeight(120.0);
        boosterTable.setItems((ObservableList)MealLoader.GenerateData("Boosters", false,"plate.csv"));

        Button back = new Button("Back");
        Button add = new Button("Add Meal to Plate");
        Button clear = new Button("Clear Plate");
        Button confirm = new Button("View Statistics");
        ArrayList<Button> buttons = new ArrayList<Button>();

        back.setOnAction(event -> drawMainMenu());
        add.setOnAction(ev -> foodsClick(true));

        clear.setOnAction(ev -> {PlateHandler.clearCurrentMeals(); PlateHandler.clearBreakfastMeals(); PlateHandler.clearLunchMeals(); PlateHandler.clearDinnerMeals();
            PlateHandler.clearSnackMeals(); PlateHandler.clearBoosterMeals(); plateMenu(); MealLoader.createNewPlate();});

        buttons.add(back);
        buttons.add(add);
        buttons.add(clear);
        buttons.add(confirm);

        GridPane gp = new GridPane();
        //gp.add(back,0,1);
        gp.add(add,0,2);
        gp.add(clear,0,3);
        gp.add(confirm,0,4);

        VBox bottomVBox = new VBox(gp,back);

        gp.setPadding(new Insets(25));
        //gp.setVgap(30);

        for ( Button button : buttons) {
            button.setPrefHeight(50);
            button.setPrefWidth((double)widthOfWindow);
        }

        back.setPrefHeight(50);

        confirm.setOnAction(ev -> {statisticsMenu();});

        //VBox buttonVBox = new VBox(dataLabel, confirm, add, clear, back);
        VBox mainVBox = new VBox(breakfastBox, lunchBox, dinnerBox, snackBox, boosterBox);

        ScrollPane sp = new ScrollPane(mainVBox);
        mainPane.setCenter(sp);
        mainPane.setBottom(bottomVBox);
    }

    private void statisticsMenu(){
        clearScreen();

        HashMap hm = UserDataManager.loadUserStats();

        Collection test = hm.values();

        Object[] sh = test.toArray();

        int s = (int)sh[0];
        int h = (int)sh[1];
        int w = (int)sh[2];
        int a = (int)sh[3];
        int c = (int)sh[4];

        System.out.println(PlateHandler.getTotalCalories());

        double shouldEatCarbs = (0.50*c)/4;
        double shouldEatProtein = (0.75*w);
        double shouldEatFat = ((0.275*c)/9);
        double maximumSugar = ((c*0.1)/4);

        Label dataLabel = new Label("YOUR TOTAL CONSUMPTION:"+
        "\n"+"Calories: "+PlateHandler.getTotalCalories()+
        "\n"+"Carbs: "+PlateHandler.getTotalCarbs()+
        "\n"+"Protein: "+PlateHandler.getTotalProtein()+
        "\n"+"Fat: "+PlateHandler.getTotalFats()+
        "\n"+"Saturates: "+PlateHandler.getTotalSaturates()+
        "\n"+"Sugar: "+PlateHandler.getTotalSugar()+
        "\n"+"\n"+
        "YOU SHOULD BE CONSUMING: "+
        "\n"+"Calories: "+c+" ("+Math.round((PlateHandler.getTotalCalories()/c)*100)+"%"+")"+
        "\n"+"Carbs: "+(shouldEatCarbs)+" ("+Math.round((PlateHandler.getTotalCarbs()/shouldEatCarbs)*100)+"%"+")"+
        "\n"+"Protein: "+(shouldEatProtein)+" ("+Math.round((PlateHandler.getTotalProtein()/shouldEatProtein)*100)+"%"+")"+
        "\n"+"Fat: "+(shouldEatFat)+" ("+Math.round((PlateHandler.getTotalFats()/shouldEatFat)*100)+"%"+")"+
        "\n"+"Sugar: "+(maximumSugar));



        mainPane.setCenter(dataLabel);

        Button back = new Button("Back");
        back.setOnAction(ev -> {plateMenu();});

        ArrayList<Button> buttons = new ArrayList();
        buttons.add(back);

        for ( Button button : buttons) {
            button.setPrefHeight(50);
            button.setPrefWidth((double)widthOfWindow);
        }

        mainPane.setBottom(back);
    }

    */

    private void exitClick( ActionEvent event) {
        st.close();
    }

    public void clearScreen() {
        mainPane.setTop(null);
        mainPane.setCenter(null);
        mainPane.setBottom(null);
        System.out.println("test");
    }

}
