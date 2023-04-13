import javafx.application.Application;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.geometry.*;
import javafx.scene.paint.*;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;
public class Calc extends Application
{
    //create Sceen area that holds calculation text
    int size = 0;
    ArrayList<String> calculations = new ArrayList<String>();
    String strCal = "";
    int answer = 10101;
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

        //button actions
        btnClear.setOnAction(e->clear());
        btnOpenPar.setOnAction(e->OpenPar());
        btnClosePar.setOnAction(e->ClosePar());
        btnSqrRoot.setOnAction(e->sqrRoot());
        btnPercent.setOnAction(e->percent());
        btnChangeSign.setOnAction(e->changeSign());
        btn8.setOnAction(e->num8());
        btn9.setOnAction(e->num9());
        btn7.setOnAction(e->num7());
        btn4.setOnAction(e->num4());
        btn5.setOnAction(e->num5());
        btn6.setOnAction(e->num6());
        btn1.setOnAction(e->num1());
        btn2.setOnAction(e->num2());
        btn3.setOnAction(e->num3());
        btnDecimal.setOnAction(e->decimal());
        btnDel.setOnAction(e->del());
        btn0.setOnAction(e->num0());
        Scene scene = new Scene(UI, 300, 600);
        primaryStage.setTitle("Calculator Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args)
    {
        launch(args);
    }
    //updates the String using the Array
    private void update()
    {
        size++;
        strCal = "";
        for (int i = 0; i <= calculations.size()-1 || i == 0; i++)
        {
            strCal += " ";
            strCal += calculations.get(i);
        }
        
        Screen.setText(strCal);
        
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
        btn.setStyle("-fx-background-radius: 25;-fx-text-fill: #B1B1B1;-fx-pref-width: 50;-fx-pref-height:"+ height+";-fx-background-color:" + btnColor +";");
        return btn;
    }
    //action functions
    private void OpenPar()
    {
        calculations.add("(");
        update();
    }
    private void num7()
    {
        calculations.add("7");
        update();
    }
    private void ClosePar()
    {
        calculations.add(")");
        update();
    }
    private void sqrRoot()
    {
        calculations.add( "√");
        update();
    }
    private void percent()
    {
        calculations.add("%");
        update();
    }
    private void changeSign()
    {
        calculations.add("-");
        update();

    }
    private void num8()
    {
        calculations.add("8");
        update();
    }
    private void num9()
    {
        calculations.add("9");
        update();

    }
    private void num4()
    {
        calculations.add( "4");
        update();
    }
    private void num5()
    {
        calculations.add("5");
        update();

    }
    private void num6()
    {
        calculations.add("6");
        update();

    }
    private void num1()
    {
        calculations.add("1");
        update();

    }
    private void num2()
    {
        calculations.add("2");
        update();
    }
    private void num3()
    {
        calculations.add("3");
        update();

    }
    private void decimal()
    {
        calculations.add(".");
        update();
    }
    private void num0()
    {
        calculations.add("0");
        update();
    }
    private void clear()
    {
        for (int i = 0; i < calculations.size()-1 || i == 0; i++)
        {
            calculations.remove(i);
        }
        size = 0;
        strCal = "";
        Screen.setText(strCal);
        
    }
    private void del()
    {
        calculations.remove(calculations.size()-1);
        strCal = " ";
        if (calculations.size() == 0)
        {
            
        }
        else 
        {
            for (int i = 0; i <= calculations.size()-1|| i == 0; i++)
            {
                strCal += " ";
                strCal += calculations.get(i);
            }
        }
        Screen.setText(strCal);
    }

}