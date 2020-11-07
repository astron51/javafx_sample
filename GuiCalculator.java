package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.event.*;

public class GuiCalculator extends Application{
	Button Num0 = new Button("0");
	Button Num1 = new Button("1");
	Button Num2 = new Button("2");
	Button Num3 = new Button("3");
	Button Num4 = new Button("4");
	Button Num5 = new Button("5");
	Button Num6 = new Button("6");
	Button Num7 = new Button("7");
	Button Num8 = new Button("8");
	Button Num9 = new Button("9");
	Button Dot = new Button(".");
	Button Plus = new Button("+");
	Button Minus = new Button("-");
	Button Multiply = new Button("*");
	Button Divide = new Button("/");
	Button Delete = new Button("<");
	Button Clear = new Button("CE");
	Button Equal = new Button("=");
	TextField Display = new TextField(); 
	int OperationMode = 0;
	Float FirstInput = 0f;
	
	public void start(Stage primaryStage) {
		BorderPane mBorder = new BorderPane();
		HBox TopView = new HBox();
		HBox FirstRow = new HBox(5);
		HBox SecondRow = new HBox(5);
		HBox ThirdRow = new HBox(5);
		HBox FourthRow = new HBox(5);
		VBox CenterMasterView = new VBox();
		CenterMasterView.setPrefWidth(70);
		CenterMasterView.setPrefHeight(70);
		
		Num0.setMinWidth((CenterMasterView.getPrefWidth() * 2.06));Num0.setMinHeight(CenterMasterView.getPrefHeight());
		Num1.setMinWidth(CenterMasterView.getPrefWidth());Num1.setMinHeight(CenterMasterView.getPrefHeight());
		Num2.setMinWidth(CenterMasterView.getPrefWidth());Num2.setMinHeight(CenterMasterView.getPrefHeight());
		Num3.setMinWidth(CenterMasterView.getPrefWidth());Num3.setMinHeight(CenterMasterView.getPrefHeight());
		Num4.setMinWidth(CenterMasterView.getPrefWidth());Num4.setMinHeight(CenterMasterView.getPrefHeight());
		Num5.setMinWidth(CenterMasterView.getPrefWidth());Num5.setMinHeight(CenterMasterView.getPrefHeight());
		Num6.setMinWidth(CenterMasterView.getPrefWidth());Num6.setMinHeight(CenterMasterView.getPrefHeight());
		Num7.setMinWidth(CenterMasterView.getPrefWidth());Num7.setMinHeight(CenterMasterView.getPrefHeight());
		Num8.setMinWidth(CenterMasterView.getPrefWidth());Num8.setMinHeight(CenterMasterView.getPrefHeight());
		Num9.setMinWidth(CenterMasterView.getPrefWidth());Num9.setMinHeight(CenterMasterView.getPrefHeight());
		Dot.setMinWidth(CenterMasterView.getPrefWidth());Dot.setMinHeight(CenterMasterView.getPrefHeight());
		Plus.setMinWidth(CenterMasterView.getPrefWidth());Plus.setMinHeight(CenterMasterView.getPrefHeight());
		Minus.setMinWidth(CenterMasterView.getPrefWidth());Minus.setMinHeight(CenterMasterView.getPrefHeight());
		Multiply.setMinWidth(CenterMasterView.getPrefWidth());Multiply.setMinHeight(CenterMasterView.getPrefHeight());
		Divide.setMinWidth(CenterMasterView.getPrefWidth());Divide.setMinHeight(CenterMasterView.getPrefHeight());
		Delete.setMinWidth(CenterMasterView.getPrefWidth());Delete.setMinHeight(CenterMasterView.getPrefHeight());
		Clear.setMinWidth(CenterMasterView.getPrefWidth());Clear.setMinHeight(CenterMasterView.getPrefHeight());
		Equal.setMinWidth(CenterMasterView.getPrefWidth());Equal.setMinHeight((CenterMasterView.getPrefHeight() * 2.14));
		Display.setEditable(false);Display.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);Display.setPrefWidth(370);
		
		TopView.setPadding(new Insets(10, 0, 0, 15));
		FirstRow.setPadding(new Insets(10, 0, 0, 15));
		SecondRow.setPadding(new Insets(10, 0, 0, 15));
		ThirdRow.setPadding(new Insets(10, 0, 0, 15));
		FourthRow.setPadding(new Insets(-70, 0, 0, 15));
		
		TopView.getChildren().add(Display);
		FirstRow.getChildren().addAll(Num7, Num8, Num9, Divide, Delete);
		SecondRow.getChildren().addAll(Num4, Num5, Num6, Multiply, Clear);
		ThirdRow.getChildren().addAll(Num1, Num2, Num3, Minus, Equal);
		FourthRow.getChildren().addAll(Num0, Dot, Plus);
		
		CenterMasterView.getChildren().add(TopView);
		CenterMasterView.getChildren().add(FirstRow);
		CenterMasterView.getChildren().add(SecondRow);
		CenterMasterView.getChildren().add(ThirdRow);
		CenterMasterView.getChildren().add(FourthRow);
		
		Clear.setOnAction((event) -> {CalculatorHandler(event);});
        Num0.setOnAction((event) -> {CalculatorHandler(event);});
        Num1.setOnAction((event) -> {CalculatorHandler(event);});
        Num2.setOnAction((event) -> {CalculatorHandler(event);});
        Num3.setOnAction((event) -> {CalculatorHandler(event);});
        Num4.setOnAction((event) -> {CalculatorHandler(event);});
        Num5.setOnAction((event) -> {CalculatorHandler(event);});
        Num6.setOnAction((event) -> {CalculatorHandler(event);});
        Num7.setOnAction((event) -> {CalculatorHandler(event);});
        Num8.setOnAction((event) -> {CalculatorHandler(event);});
        Num9.setOnAction((event) -> {CalculatorHandler(event);});
        Plus.setOnAction((event) -> {CalculatorHandler(event);});
        Minus.setOnAction((event) -> {CalculatorHandler(event);});
        Multiply.setOnAction((event) -> {CalculatorHandler(event);});
        Divide.setOnAction((event) -> {CalculatorHandler(event);});
        Dot.setOnAction((event) -> {CalculatorHandler(event);});
        Delete.setOnAction((event) -> {CalculatorHandler(event);});
        Equal.setOnAction((event) -> {CalculatorHandler(event);});
        
		Scene scene = new Scene(mBorder, 400, 370);
		mBorder.setCenter(CenterMasterView);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("JavaFX Calculator");
		primaryStage.show();
	}
	
	void CalculatorHandler(ActionEvent e) {
		if (e.getSource() == Clear)
        {
			OperationMode = 0;
			Display.clear();
        }else if (e.getSource() == Num0){
        	Display.setText(Display.getText() + "0");
        }else if (e.getSource() == Num1){
        	Display.setText(Display.getText() + "1");
        }else if (e.getSource() == Num2){
        	Display.setText(Display.getText() + "2");
        }else if (e.getSource() == Num3){
        	Display.setText(Display.getText() + "3");
        }else if (e.getSource() == Num4){
        	Display.setText(Display.getText() + "4");
        }else if (e.getSource() == Num5){
        	Display.setText(Display.getText() + "5");
        }else if (e.getSource() == Num6){
        	Display.setText(Display.getText() + "6");
        }else if (e.getSource() == Num7){
        	Display.setText(Display.getText() + "7");
        }else if (e.getSource() == Num8){
        	Display.setText(Display.getText() + "8");
        }else if (e.getSource() == Num9){
        	Display.setText(Display.getText() + "9");
        }else if (e.getSource() == Dot){
        	Display.setText(Display.getText() + ".");
        }else if (e.getSource() == Plus){
        	FirstInput = Float.parseFloat(Display.getText());
            OperationMode = 1;
            Display.clear();
        }else if (e.getSource() == Minus){
        	FirstInput = Float.parseFloat(Display.getText());
            OperationMode = 2;
            Display.clear();
        }else if (e.getSource() == Multiply){
        	FirstInput = Float.parseFloat(Display.getText());
            OperationMode = 3;
            Display.clear();
        }else if (e.getSource() == Divide){
        	FirstInput = Float.parseFloat(Display.getText());
            OperationMode = 4;
            Display.clear();
        }else if (e.getSource() == Delete){
        	try {
        		Display.setText(Display.getText(0, Display.getLength()-1));
        	}catch(Exception ec0) {
        		
        	}
        }else if (e.getSource() == Equal){
        	Float SecondInput = 0f;
        	Float Result = 0f;
        	try {
        		SecondInput = Float.parseFloat(Display.getText());
        	}catch(Exception ec1) {
        		
        	}
        	switch(OperationMode) {
        		case 1:
        			 Result = FirstInput + SecondInput;
        			 Display.setText(String.valueOf(Result));
        			break;
        		case 2:
        			Result = FirstInput - SecondInput;
        			Display.setText(String.valueOf(Result));
            		break;
        		case 3:
        			Result = FirstInput * SecondInput;
        			Display.setText(String.valueOf(Result));
                    break;
        		case 4:
        			Result = 0f;
        			try {
        				Result = FirstInput / SecondInput;
        			}catch(Exception ec2) {
        				Display.setText("Error");
        			}
        			Display.setText(String.valueOf(Result));
            		break;
            	default:
            		break;
    		}
        	if (Result == 69420.0f) {
        		Alert alert = new Alert(AlertType.INFORMATION);
            	alert.setTitle("Easter Egg");
            	alert.setHeaderText("Look, an Easter Egg");
            	alert.setContentText("69420 ? Nice number you have there 😎");
            	((Button)alert.getDialogPane().lookupButton(ButtonType.OK)).setText("Thanks Bro");
            	alert.showAndWait();
        	}
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
