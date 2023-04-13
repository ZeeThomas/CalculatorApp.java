import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.scene.paint.*;
public class Calc extends Application
{
    //create Sceen area that holds calculation text
    
    TextArea Screen = new TextArea();
    @Override
    public void start(Stage primaryStage)
    {
        Screen.setEditable(false);
        BorderPane UI = new BorderPane();
        GridPane ButtonRows = new GridPane();
        GridPane CalculateCol = new GridPane();
        UI.setPadding(new Insets(2,10,10,10));
        UI.setMargin(Screen, new Insets(0,0,10,0));
        //ButtonRows.setAlignment(Pos.CENTER);
        ButtonRows.setHgap(20);
        ButtonRows.setVgap(10);
        ///create new col for Calculations to allow space for a larger Equal button
        CalculateCol.setHgap(20);
        CalculateCol.setVgap(10);
        //CalculateCol.setAlignment(Pos.CENTER_LEFT);
        //buttons
        //row1
        Button btnClear = createCircularButton("C", Color.web("#ffbf00",.5));
        Button btnOpenPar = createCircularButton("(", Color.web("#ffbf00",.5));
        Button btnClosePar = createCircularButton(")", Color.web("#ffbf00",.50));
        Button btnMultiply = createCircularButton("×",Color.web("#805B87"));
        //row2
        Button btnSqrRoot = createCircularButton("√ ", Color.web("#ffbf00", .50));
        Button btnPercent = createCircularButton("%", Color.web("#ffbf00", .50));
        Button btnChangeSign = createCircularButton("+/-",Color.web("#ffbf00", .50));
        Button btnDivision = createCircularButton("÷",Color.web("#805B87"));
        //row 3
        Button btn7 = createCircularButton("7 ", Color.web("#444444"));
        Button btn8 = createCircularButton("8", Color.web("#444444"));
        Button btn9 = createCircularButton("9",Color.web("#444444"));
        Button btnMinus = createCircularButton("-", Color.web("#805B87"));
        //row 4
        Button btn4 = createCircularButton("4", Color.web("#444444"));
        Button btn5 = createCircularButton("5", Color.web("#444444"));
        Button btn6 = createCircularButton("6",Color.web("#444444"));
        Button btnPlus = createCircularButton("+", Color.web("#805B87"));
        //row 5
        Button btn1 = createCircularButton("1", Color.web("#444444"));
        Button btn2 = createCircularButton("2", Color.web("#444444"));
        Button btn3 = createCircularButton("3",Color.web("#444444"));
        Button btnEqual = createCircularButton("=", "#805B87", "110");
        //row6
        Button btnDecimal = createCircularButton(".", Color.web("#444444"));
        Button btn0 = createCircularButton("0", Color.web("#444444"));
        Button btnDel = createCircularButton("del",Color.web("#444444"));        
        //set location of buttons
        ButtonRows.add(btnClear, 0, 0);
        ButtonRows.add(btnOpenPar, 1,0);
        ButtonRows.add(btnClosePar,2,0);
        CalculateCol.add(btnMultiply, 0,0);
        ButtonRows.add(btnSqrRoot, 0, 1);
        ButtonRows.add(btnPercent, 1,1);
        ButtonRows.add(btnChangeSign,2,1);
        CalculateCol.add(btnDivision, 0,1);
        ButtonRows.add(btn7, 0, 2);
        ButtonRows.add(btn8, 1,2);
        ButtonRows.add(btn9,2,2);
        CalculateCol.add(btnMinus, 0,2);
        ButtonRows.add(btn4, 0, 3);
        ButtonRows.add(btn5, 1,3);
        ButtonRows.add(btn6,2,3);
        CalculateCol.add(btnPlus, 0,3);
        ButtonRows.add(btn1, 0, 4);
        ButtonRows.add(btn2, 1,4);
        ButtonRows.add(btn3,2,4);
        CalculateCol.add(btnEqual, 0,4);
        ButtonRows.add(btnDecimal, 0, 5);
        ButtonRows.add(btn0, 1,5);
        ButtonRows.add(btnDel,2,5);
        UI.setTop(Screen);
        UI.setCenter(ButtonRows);
        UI.setLeft(null);
        UI.setRight(CalculateCol);
        //sets background to the gradient color
        UI.setStyle(" -fx-background-color: linear-gradient(from 25% 25% to 100% 100%, #444444, #0A0708);");
        //UI.setBackground(new Background(new BackgroundFill(Color.BLACK,1.3,null)));

        Scene scene = new Scene(UI, 300, 600);
        primaryStage.setTitle("Calculator Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
    //creates custom button that are circles for Button interfaces
    private Button createCircularButton(String text, Color btnColor)
    {
        Button btn = new Button(text);
        btn.setStyle("-fx-background-radius: 25;-fx-pref-width: 50;-fx-text-fill: #B1B1B1;-fx-pref-height: 50;-fx-background-color:'" + btnColor +"';");
        return btn;
    }
    private Button createCircularButton(String text, String btnColor, String height)
    {
        Button btn = new Button(text);
        btn.setStyle("-fx-background-radius: 25;-fx-pref-width: 50;-fx-pref-height:"+ height+";-fx-background-color:" + btnColor +";");
        return btn;
    }
}