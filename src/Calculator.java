import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {

    Label screen;
    Label smallScreen;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");
        FlowPane rootPane = new FlowPane();
        Scene scene = new Scene(rootPane, 300,400);
        Font font = new Font(40);
        screen = new Label("0");
        screen.setFont(font);
        smallScreen = new Label("");
        smallScreen.setMinSize(300,10);
        smallScreen.setMaxSize(scene.getWidth(),40);
        screen.setMaxSize(scene.getWidth(),10);
        screen.setMinSize(300,50);


        Separator separator1 = new Separator();
        separator1.setPrefWidth(300);

        Font font1 = new Font(20);

        GridPane gridPane = new GridPane();
        Button percent = new Button("%");
        percent.setFont(font1);
        gridPane.add(percent,0,0);
        percent.setMinSize(75,50);
        Button root = new Button("√");
        root.setFont(font1);
        gridPane.add(root,1,0);
        root.setMinSize(75,50);
        Button degree2 = new Button("x²");
        degree2.setFont(font1);
        gridPane.add(degree2,2,0);
        degree2.setMinSize(75,50);
        Button oneShareX = new Button("1/x");
        oneShareX.setFont(font1);
        gridPane.add(oneShareX,3,0);
        oneShareX.setMinSize(75,50);

        Button cCe = new Button("CE");
        cCe.setFont(font1);
        gridPane.add(cCe,0,1);
        cCe.setMinSize(75,50);
        Button cC = new Button("C");
        cC.setFont(font1);
        gridPane.add(cC,1,1);
        cC.setMinSize(75,50);
        cC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            screen.setText("0");
            smallScreen.setText(""); ;
            }
        });
        Button remove = new Button("⌫");
        remove.setFont(font1);
        gridPane.add(remove,2,1);
        remove.setMinSize(75,50);
        Button share = new Button("÷");
        share.setFont(font1);
        gridPane.add(share,3,1);
        share.setMinSize(75,50);

        Button int7 = new Button("7");
        int7.setFont(font1);
        gridPane.add(int7,0,2);
        int7.setMinSize(75,50);
        int7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                 CalculatorApp.lastChar='7';
                    screen.setText("7");}
                else screen.setText(screen.getText()+7); ;
            }
        });
        Button int8 = new Button("8");
        int8.setFont(font1);
        gridPane.add(int8,1,2);
        int8.setMinSize(75,50);
        int8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='8';
                    screen.setText("8");}
                else screen.setText(screen.getText()+8); ;
            }
        });
        Button int9 = new Button("9");
        int9.setFont(font1);
        gridPane.add(int9,2,2);
        int9.setMinSize(75,50);
        int9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='9';
                    screen.setText("9");}
                else screen.setText(screen.getText()+9); ;
            }
        });
        Button multiply = new Button("×");
        multiply.setFont(font1);
        gridPane.add(multiply,3,2);
        multiply.setMinSize(75,50);

        Button int4 = new Button("4");
        int4.setFont(font1);
        gridPane.add(int4,0,3);
        int4.setMinSize(75,50);
        int4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='4';
                    screen.setText("4");}
                else screen.setText(screen.getText()+4); ;
            }
        });
        Button int5 = new Button("5");
        int5.setFont(font1);
        gridPane.add(int5,1,3);
        int5.setMinSize(75,50);
        int5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='5';
                    screen.setText("5");}
                else screen.setText(screen.getText()+5); ;
            }
        });
        Button int6 = new Button("6");
        int6.setFont(font1);
        gridPane.add(int6,2,3);
        int6.setMinSize(75,50);
        int6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='6';
                    screen.setText("6");}
                else screen.setText(screen.getText()+6); ;
            }
        });
        Button minus = new Button("-");
        minus.setFont(font1);
        gridPane.add(minus,3,3);
        minus.setMinSize(75,50);



        Button int1 = new Button("1");
        int1.setFont(font1);
        gridPane.add(int1,0,4);
        int1.setMinSize(75,50);
        int1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='1';
                    screen.setText("1");}
                else screen.setText(screen.getText()+1); ;
            }
        });

        Button int2 = new Button("2");
        int2.setFont(font1);
        gridPane.add(int2,1,4);
        int2.setMinSize(75,50);
        int2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='2';
                    screen.setText("2");}
                else screen.setText(screen.getText()+2); ;
            }
        });

        Button int3 = new Button("3");
        int3.setFont(font1);
        gridPane.add(int3,2,4);
        int3.setMinSize(75,50);
        int3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='){
                    CalculatorApp.lastChar='3';
                    screen.setText("3");}
                else screen.setText(screen.getText()+3); ;
            }
        });

        Button plus = new Button("+");
        plus.setFont(font1);
        gridPane.add(plus,3,4);
        plus.setMinSize(75,50);
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!(smallScreen.getText().isEmpty())) {
                    Double x = Double.valueOf(smallScreen.getText()) + Double.valueOf(smallScreen.getText());
                    screen.setText(""+x);
                    smallScreen.setText("");

                }
                else if(!(screen.getText().isEmpty())&& smallScreen.getText().isEmpty()){
                    smallScreen.setText(screen.getText());
                    CalculatorApp.lastChar='+';
                }

            }
        });


        Button plusMinus = new Button("±");
        plusMinus.setFont(font1);
        gridPane.add(plusMinus,0,5);
        plusMinus.setMinSize(75,50);

        Button zero = new Button("0");
        zero.setFont(font1);
        gridPane.add(zero,1,5);
        zero.setMinSize(75,50);
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||CalculatorApp.lastChar=='='||CalculatorApp.lastChar=='-')
                {
                    CalculatorApp.lastChar='0';
                    screen.setText("0");}

                else screen.setText(screen.getText()+0); ;
            }
        });

        Button dot = new Button(".");
        dot.setFont(font1);
        gridPane.add(dot,2,5);
        dot.setMinSize(75,50);
        dot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 try{ Integer.parseInt(screen.getText());
                screen.setText(screen.getText()+"."); }
                catch (Exception ex){

                }
            }
        });

        final double temp = 0;

        Button equally = new Button("=");
        equally.setFont(font1);
        gridPane.add(equally,3,5);
        equally.setMinSize(75,50);
        equally.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(!(smallScreen.getText().isEmpty())) {
                   Double x = Double.valueOf(smallScreen.getText()) + Double.valueOf(smallScreen.getText());
                   screen.setText(""+x);
               }
               if(!(screen.getText().isEmpty())){
                   CalculatorApp.lastChar='=';
               }

            }
        });



        primaryStage.setScene(scene);
        FlowPane flowPane = new FlowPane(10,10);
        flowPane.getChildren().addAll(smallScreen,separator1,screen,gridPane );
        rootPane.getChildren().add(flowPane);

        primaryStage.show();
    }
}
