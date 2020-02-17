// Class: CSE 1322L
//Section:
//Term: spring 2020
//Instructor: Kevin Markley
//Name: Tyler Williams
//Assignment 3

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Main extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		Text t1 = new Text();
		String test = "Hello";
		boolean pressed = false;
		EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				t1.setText(t1.getText() + "0");
			}
		};
		
		//used lambdas here, basically if a object has one abstract method, you can do parameter -> what to do in the method,
		//and it declares the method and says what to do in it, in a much nicer-looking line. this does the same thing as 
		//the code above. The number/input is added on to the end of the text.
		
		//Learned lambdas using stackexchange
		EventHandler<MouseEvent> eventHandler2 = (a -> t1.setText(t1.getText() + "1"));
		EventHandler<MouseEvent> eventHandler3 = (a -> t1.setText(t1.getText() + "2"));
		EventHandler<MouseEvent> eventHandler4 = (a -> t1.setText(t1.getText() + "3"));
		EventHandler<MouseEvent> eventHandler5 = (a -> t1.setText(t1.getText() + "4"));
		EventHandler<MouseEvent> eventHandler6 = (a -> t1.setText(t1.getText() + "5"));
		EventHandler<MouseEvent> eventHandler7 = (a -> t1.setText(t1.getText() + "6"));
		EventHandler<MouseEvent> eventHandler8 = (a -> t1.setText(t1.getText() + "7"));
		EventHandler<MouseEvent> eventHandler9 = (a -> t1.setText(t1.getText() + "8"));
		EventHandler<MouseEvent> eventHandler10 = (a -> t1.setText(t1.getText() + "9"));
		EventHandler<MouseEvent> eventHandler11 = (a -> t1.setText(t1.getText() + "+"));
		EventHandler<MouseEvent> eventHandler12 = (a -> t1.setText(t1.getText() + "-"));
		EventHandler<MouseEvent> eventHandler13 = (a -> t1.setText(t1.getText() + "*"));
		EventHandler<MouseEvent> eventHandler14 = (a -> t1.setText(t1.getText() + "/"));
		//This command first passes t1 to calc, then when calc returns a double, instantly turns the returned value into
		//a string and loads it back into t1.
		EventHandler<MouseEvent> eventHandler15 = (a -> t1.setText(Double.toString(TheCalc(t1))));
		EventHandler<MouseEvent> eventHandlerClr = (a -> t1.setText(""));
		//this gets the string from t1, then gets the substring of the t1 string from 0 (the start) to .length-1 (the end-1), and then makes that the
		//new text.
		EventHandler<MouseEvent> eventHandlerBksp = (a -> {if(t1.getText().length()!=0)t1.setText(t1.getText().substring(0, t1.getText().length()-1));});
		
		//Declare buttons with their text
		Button b1 = new Button("0");
		Button b2 = new Button("1");
		Button b3 = new Button("2");
		Button b4 = new Button("3");
		Button b5 = new Button("4");
		Button b6 = new Button("5");
		Button b7 = new Button("6");
		Button b8 = new Button("7");
		Button b9 = new Button("8");
		Button b10 = new Button("9");
		Button b11 = new Button("+");
		Button b12 = new Button("-");
		Button b13 = new Button("*");
		Button b14 = new Button("/");
		Button b15 = new Button("=");
		Button bClr = new Button("C");
		Button bBksp = new Button("B");
		
		//make it so that if buttons are clicked, the eventHandlers are triggered
		b1.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
		b2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
		b3.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);
		b4.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler4);
		b5.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler5);
		b6.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler6);
		b7.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler7);
		b8.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler8);
		b9.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler9);
		b10.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler10);
		b11.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler11);
		b12.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler12);
		b13.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler13);
		b14.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler14);
		b15.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler15);
		bClr.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerClr);
		bBksp.addEventFilter(MouseEvent.MOUSE_CLICKED,  eventHandlerBksp);
		
		//Borderpane lets you align elements to top, left, bottom, etc. by making the text display by itself at the top, 
		//and excluding it from the rest of the borderpane, the text no longer shifts the bpane when updated.
		
		//Learned borderpanes via java's documentation
		BorderPane bPane = new BorderPane();
		//Gridpane aligns all elements on a grid and displays them
		GridPane gPane = new GridPane();
		
		bPane.setCenter(gPane);
		bPane.setTop(t1);
		
		
		//adding buttons to gpane
		gPane.add(b1, 0, 1);
		gPane.add(b2, 1, 1);
		gPane.add(b3, 2, 1);
		gPane.add(b4, 3, 1);
		gPane.add(b5, 4, 1);
		gPane.add(b6, 0, 2);
		gPane.add(b7, 1, 2);
		gPane.add(b8, 2, 2);
		gPane.add(b9, 3, 2);
		gPane.add(b10, 4, 2);
		gPane.add(b11, 0, 3);
		gPane.add(b12, 1, 3);
		gPane.add(b13, 2, 3);
		gPane.add(b14, 3, 3);
		gPane.add(b15, 4, 3);
		gPane.add(bClr,  0, 4);
		gPane.add(bBksp, 1, 4);
		
		//sets padding. found on stack overflow.
		gPane.setHgap(5);
		gPane.setVgap(5);
		
		Scene theScene = new Scene(bPane, 200, 200);
		
		primaryStage.setScene(theScene);
		primaryStage.show();
		
	}
	
	public double TheCalc(Text t)
	{
		double[] theNumbs = new double[2];
		String[] numbStr = new String[] {"", ""};
		double result = 0;
		//declares conv as the text sent to the method by t, then trims whitespace
		String conv = t.getText();
		conv.trim();
		
		//declares an array of strings, those being the operators the calculator allows. also declares array opInd,
		//which is used to store where the operator is, as well as what operator it is.
		String[] oper = new String[] {"+", "-", "*", "/"};
		int[] opInd = new int[2];
		
		//default value for when indexOf fails to find the char it's looking for is -1. so that's why this is -1.
		opInd[0] = -1;
		
		//Scans the text for one of the four operators, checking each by using the array of operators. if an operator is found,
		//the location of the operator is stored in opInd[0] and the type of operator is stored in opInd[1].
		for(int i = 0; i < 4; i++)
		{
			if(opInd[0] == -1)
			{
				opInd[0] = conv.indexOf(oper[i]);
				opInd[1] = i;
			}
		}
		System.out.println("Done");
		
		
		//extracts the numbers before and after the operator by getting each character and adding it to either [0] or [1]
		for(int i = 0; i < opInd[0]; i++)
		{
			System.out.println(conv.charAt(i));
			numbStr[0] = numbStr[0] + conv.charAt(i);
		}
		for(int i = opInd[0]+1; i < conv.length(); i++)
		{
			numbStr[1] = numbStr[1] + conv.charAt(i);
		}
		System.out.println("Done " + opInd[0] + " First numb: str: " + numbStr[0] + " Second numb: str: " + numbStr[1]);
		
		//converts the strings to doubles
		theNumbs[0] = Double.parseDouble(numbStr[0]);
		theNumbs[1] = Double.parseDouble(numbStr[1]);
		
		System.out.println("Done");
		System.out.println("Operand numb: " + opInd[1] + " First numb: " + theNumbs[0] + " Second numb: " + theNumbs[1]);
		
		//determines which operator to use depending on the value of opInd[1]
		switch(opInd[1])
		{
		case 0:
			result = theNumbs[0] + theNumbs[1];
			break;
		case 1:
			result = theNumbs[0] - theNumbs[1];
			break;
		case 2:
			result = theNumbs[0] * theNumbs[1];
			break;
		case 3:
			result = theNumbs[0] / theNumbs[1];
			break;
		}
		System.out.println("Done");
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
