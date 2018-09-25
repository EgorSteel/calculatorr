import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {

    Label screen;
    SupMath supMath;
    boolean flag;
    @Override
    public void start(Stage primaryStage) {
        supMath = new SupMath();
        flag = true;
        primaryStage.setTitle("Calculator");
        FlowPane rootPane = new FlowPane();
        Scene scene = new Scene(rootPane, 300,340);
        Font font = new Font(30);
        screen = new Label("0");
        screen.setFont(font);
        screen.setMaxSize(300,40);
        screen.setMinSize(300,40);
        Font font1 = new Font(20);
        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();

        Button percent = new Button("%");
        percent.setFont(font1);
        gridPane.add(percent,0,0);
        percent.setMinSize(75,50);

        percent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              screen.setText(supMath.gerPercent());
                flag = true;
            }
        });

        Button root = new Button("√");
        root.setFont(font1);
        gridPane.add(root,1,0);
        root.setMinSize(75,50);
        root.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (!(supMath.getLastSign() == '=')) {
                        if (supMath.getLastSign() == '+') {
                            supMath.sqrt();
                            screen.setText(supMath.summa());
                        } else if (supMath.getLastSign() == '-') {
                            supMath.sqrt();
                            screen.setText(supMath.minus());
                        } else if (supMath.getLastSign() == '×') {
                            supMath.sqrt();
                            screen.setText(supMath.mult());
                        } else if (supMath.getLastSign() == '÷') {
                            supMath.sqrt();
                            screen.setText(supMath.shared());
                        }
                    } else {
                        screen.setText(supMath.sqrt());
                    }
                    supMath.setLastSign('√');
                    flag = true;
                    supMath.setLastChar('√');
                }
                catch (NumberFormatException ex){
                    screen.setText("Нельзя извлечь √ из отриц. числа");
                    supMath.setLastSum("0");
                    supMath.setLastSign('=');
                    supMath.setLastChar('=');
                    supMath.setFirstSum("0");
                    flag = true;

                }
            }
        });

        Button degree2 = new Button("x²");
        degree2.setFont(font1);
        gridPane.add(degree2,2,0);
        degree2.setMinSize(75,50);
        degree2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!(supMath.getLastSign() == '=')) {
                    if (supMath.getLastSign() == '+') {
                        supMath.degree2();
                        screen.setText(supMath.summa());
                    } else if (supMath.getLastSign() == '-') {
                        supMath.degree2();
                        screen.setText(supMath.minus());
                    } else if (supMath.getLastSign() == '×') {
                        supMath.degree2();
                        screen.setText(supMath.mult());
                    } else if (supMath.getLastSign() == '÷') {
                        supMath.degree2();
                        screen.setText(supMath.shared());
                    }
                } else {
                    screen.setText(supMath.degree2());
                }
                supMath.setLastSign('q');
                flag = true;
                supMath.setLastChar('q');
            }
        });

        Button cCe = new Button("CE");
        cCe.setFont(font1);
        gridPane2.add(cCe,0,0);
        cCe.setMinSize(150,50);
        cCe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                screen.setText("0");
                supMath.setLastSum("0");
            }
        });
        Button cC = new Button("C");
        cC.setFont(font1);
        gridPane2.add(cC,1,0);
        cC.setMinSize(150,50);
        cC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            screen.setText("0");
            supMath.setLastSum("0");
            supMath.setLastSign('=');
            supMath.setLastChar('=');
            supMath.setFirstSum("0");
            flag = true;
            }
        });

        Button share = new Button("÷");
        share.setFont(font1);
        gridPane.add(share,3,0);
        share.setMinSize(75,50);


            share.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (!(supMath.getLastChar()=='=')) {
                        if (supMath.getLastSign() == '+') {
                            screen.setText(supMath.summa());
                        } else if (supMath.getLastSign() == '-') {
                            screen.setText(supMath.minus());
                        } else if (supMath.getLastSign() == '×') {
                            screen.setText(supMath.mult());
                        } else {
                            screen.setText(supMath.shared());
                        }
                    }
                    supMath.setLastSign('÷');
                    supMath.setLastChar('÷');
                    flag = true;
                }

            });


        Button int7 = new Button("7");
        int7.setFont(font1);
        gridPane.add(int7,0,1);
        int7.setMinSize(75,50);
        int7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")|| flag){
                 supMath.setLastSum("7");
                 flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+7);
                      supMath.setLastSum(screen.getText());
                } ;
                supMath.setLastChar('7');
            }
        });
        Button int8 = new Button("8");
        int8.setFont(font1);
        gridPane.add(int8,1,1);
        int8.setMinSize(75,50);
        int8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||flag){
                    supMath.setLastSum("8");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+8);
                    supMath.setLastSum(screen.getText());  ;
        }
                supMath.setLastChar('8');
            }
        }
        );
        Button int9 = new Button("9");
        int9.setFont(font1);
        gridPane.add(int9,2,1);
        int9.setMinSize(75,50);
        int9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")|| screen.getText().equals("0")||flag){
                    supMath.setLastSum("9");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+9);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('9');}
        });
        Button multiply = new Button("×");
        multiply.setFont(font1);
        gridPane.add(multiply,3,1);
        multiply.setMinSize(75,50);
        multiply.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!(supMath.getLastChar()=='=')) {
                    if (supMath.getLastSign() == '+') {
                        screen.setText(supMath.summa());
                    } else if (supMath.getLastSign() == '-') {
                        screen.setText(supMath.minus());
                    } else if (supMath.getLastSign() == '÷') {
                        screen.setText(supMath.shared());
                    } else {
                        screen.setText(supMath.mult());
                    }
                }
                supMath.setLastSign('×');
                supMath.setLastChar('×');
                flag = true;
            }
        });

        Button int4 = new Button("4");
        int4.setFont(font1);
        gridPane.add(int4,0,2);
        int4.setMinSize(75,50);
        int4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||flag){
                    supMath.setLastSum("4");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+4);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('4');
            }
        });
        Button int5 = new Button("5");
        int5.setFont(font1);
        gridPane.add(int5,1,2);
        int5.setMinSize(75,50);
        int5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||screen.getText().equals("0")||flag){
                    supMath.setLastSum("5");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+5);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('5');
            }
        });
        Button int6 = new Button("6");
        int6.setFont(font1);
        gridPane.add(int6,2,2);
        int6.setMinSize(75,50);
        int6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||screen.getText().equals("0")||flag){
                    supMath.setLastSum("6");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+6);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('6');
            }
        });
        Button minus = new Button("-");
        minus.setFont(font1);
        gridPane.add(minus,3,2);
        minus.setMinSize(75,50);
        minus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!(supMath.getLastChar()=='=')) {
                    if (supMath.getLastSign() == '+') {
                        screen.setText(supMath.summa());
                    }
                    if (supMath.getLastSign() == '×') {
                        screen.setText(supMath.mult());
                    }
                    if (supMath.getLastSign() == '÷') {
                        screen.setText(supMath.shared());
                    } else
                        screen.setText(supMath.minus());
                }
                supMath.setLastSign('-');
                supMath.setLastChar('-');
                flag = true;
            }
        });

        Button int1 = new Button("1");
        int1.setFont(font1);
        gridPane.add(int1,0,3);
        int1.setMinSize(75,50);
        int1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")|| screen.getText().equals("0")||flag){
                    supMath.setLastSum("1");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+1);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('1');
            }
        });

        Button int2 = new Button("2");
        int2.setFont(font1);
        gridPane.add(int2,1,3);
        int2.setMinSize(75,50);
        int2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||screen.getText().equals("0")||flag){
                    supMath.setLastSum("2");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+2);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('2');
            }
        });

        Button int3 = new Button("3");
        int3.setFont(font1);
        gridPane.add(int3,2,3);
        int3.setMinSize(75,50);
        int3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||screen.getText().equals("0")||flag){
                    supMath.setLastSum("3");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+3);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('3');
            }

        });

        Button plus = new Button("+");
        plus.setFont(font1);
        gridPane.add(plus,3,3);
        plus.setMinSize(75,50);
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             if (!(supMath.getLastChar()=='=')) {
                    if (supMath.getLastSign() == '-') {
                        screen.setText(supMath.minus());
                    }
                    if (supMath.getLastSign() == '×') {
                        screen.setText(supMath.mult());
                    }
                    if (supMath.getLastSign() == '÷') {
                        screen.setText(supMath.shared());
                    } else {
                        screen.setText(supMath.summa());
                    }
                }
                supMath.setLastSign('+');
                supMath.setLastChar('+');
                flag = true;
            }

        });


        Button plusMinus = new Button("±");
        plusMinus.setFont(font1);
        gridPane.add(plusMinus,0,4);
        plusMinus.setMinSize(75,50);
        plusMinus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!(supMath.getLastSign() == '=')) {
                    if (supMath.getLastSign() == '+') {
                        supMath.negateSign();
                        screen.setText(supMath.summa());
                    } else if (supMath.getLastSign() == '-') {
                        supMath.negateSign();
                        screen.setText(supMath.minus());
                    } else if (supMath.getLastSign() == '×') {
                        supMath.negateSign();
                        screen.setText(supMath.mult());
                    } else if (supMath.getLastSign() == '÷') {
                        supMath.negateSign();
                        screen.setText(supMath.shared());
                    }
                } else {
                    screen.setText(supMath.negateSign());
                }
                supMath.setLastSign('±');
                flag = true;
                supMath.setLastChar('±');
            }
        });


        Button zero = new Button("0");
        zero.setFont(font1);
        gridPane.add(zero,1,4);
        zero.setMinSize(75,50);
        zero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(screen.getText().equals("0")||screen.getText().equals("0")||flag)
                {
                    supMath.setLastSum("0");
                    flag = false;
                    screen.setText(supMath.getLastSum());}
                else {screen.setText(supMath.getLastSum()+0);
                    supMath.setLastSum(screen.getText());  ;
                }
                supMath.setLastChar('0');
            }
        });

        Button dot = new Button(".");
        dot.setFont(font1);
        gridPane.add(dot,2,4);
        dot.setMinSize(75,50);
        dot.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 try{ Integer.parseInt(screen.getText());
                     if(!(flag))
                     {
                      supMath.setLastSum(supMath.getLastSum()+".");
                screen.setText(screen.getText()+".");} }
                catch (Exception ex){
                }
            }
        });

        Button equally = new Button("=");
        equally.setFont(font1);
        gridPane.add(equally,3,4);
        equally.setMinSize(75,50);
        equally.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    String temp = supMath.getLastSum();
                    switch (supMath.getLastSign()) {
                        case '+':
                            screen.setText(supMath.summa());
                            break;
                        case '-':
                            screen.setText(supMath.minus());
                            break;
                        case '×':
                            screen.setText(supMath.mult());
                            break;
                        case '÷':
                            screen.setText(supMath.shared());
                            break;
//                        case '√':
//                            screen.setText(supMath.sqrt());
//                            break;
                    }
                    supMath.setLastSum(temp);
                supMath.setLastChar('=');
                flag = true;
            }
        });
        primaryStage.setScene(scene);
        FlowPane flowPane = new FlowPane(0,0);
        flowPane.getChildren().addAll(screen,gridPane,gridPane2 );
        rootPane.getChildren().add(flowPane);
        primaryStage.show();

    }
}
