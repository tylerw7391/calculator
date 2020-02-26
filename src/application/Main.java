// Class: CSE 1322L
//Section:
//Term: spring 2020
//Instructor: Kevin Markley
//Name: Tyler Williams
//Assignment 3

package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class Main extends Application 
{
	//this defines the operators for the rest of the class.
	private final String[] oper = new String[] {"*", "/", "+", "-"};
	private ArrayList<Integer> opInfoLocation = new ArrayList<>();
	private ArrayList<Integer> opInfoType = new ArrayList<>();
	private ArrayList<Object> equation = new ArrayList();
	private ArrayList<Double> theNumbs = new ArrayList<>();
	
	@Override
	public void start(Stage primaryStage) 
	{
		Text t1 = new Text();
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
		//a string and overwrites t1 with the newly returned string.
		EventHandler<MouseEvent> eventHandler15 = (a -> t1.setText(Double.toString(TheCalcMulti(t1))));
		EventHandler<MouseEvent> eventHandlerClr = (a -> t1.setText(""));
		//this gets the string from t1, then gets the substring of the t1 string from 0 (the start) to .length()-1 (the end-1), and then makes that the
		//new text.
		EventHandler<MouseEvent> eventHandlerBksp = (a -> {if(t1.getText().length() != 0) {t1.setText(t1.getText().substring(0, t1.getText().length()-1));}});
		
		
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
	
	//This version of the calculator can be used(with great effect) on two-variable equations, with one operator. Much more efficient, but will fail if
	//there's more than one operator!
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
		//String[] oper = new String[] {"+", "-", "*", "/"};
		int[] opInd = new int[2];
		
		//default value for when indexOf fails to find the char it's looking for is -1. so that's why this is -1.
		opInd[0] = -1;
		
		//Scans the text for one of the four operators, checking each by using the array of operators. if an operator is found,
		//the location of the operator is stored in opInd[0] and the type of operator is stored in opInd[1].
		for(int i = 0; i < oper.length; i++)
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
		case 2:
			result = theNumbs[0] + theNumbs[1];
			break;
		case 3:
			result = theNumbs[0] - theNumbs[1];
			break;
		case 0:
			result = theNumbs[0] * theNumbs[1];
			break;
		case 1:
			result = theNumbs[0] / theNumbs[1];
			break;
		}
		System.out.println("Done");
		
		return result;
	}
	
	public double TheCalcMulti(Text t)
	{
		String conv = t.getText();
		conv = conv.trim();
		System.out.println("\n" + "The original equation: " + conv);
		double totalResult = 0;
		int[][] opInfo = OperatorFinder(conv);
		totalResult = TextToCalc(conv, opInfo);
		opInfoLocation.clear();
		opInfoType.clear();
		equation.clear();
		theNumbs.clear();
		return totalResult;
	}
	
	//locates the position of an operator in a string, and identifies it based off the idea that 
	//+ = 0, - = 1, * = 2, / = 3. Returns operator position as array[0][operator number], and operator type as array[1][op number].
	public int[][] OperatorFinder(String t)
	{
		//oper[] is used to store the four valid types of operators usable in the calculator.
		//String[] oper = new String[] {"+", "-", "*", "/"};
		//opCount is used to store the number of operators
		int opCount = 0;
		
		//Searches for operators and adds to the counter if one is found.
		for(int i = 0; i < t.length(); i++)
		{
			for(int c = 0; c < oper.length; c++)
			{
				//converts t.charAt(i) to a string, then checks to see if that character (i) is equal to the current operator being compared (c)
				if(oper[c].contentEquals(Character.toString(t.charAt(i))))
				{
					opCount++;
				}
			}
		}
		
		System.out.println("OpCount: " + opCount);
		//This array stores operator positions, as well as their types. The position is stored in array[0][i] and the type is stored in array[1][i]
		int[][] opInfo = new int[2][opCount];
		
		//this loop searches for the position of however many operators were found (i) and stores the position and type in the designated place.
		//l is required to search for all 4 types.
		int storeFound = 0;
		
		//searches and indexes operators into the opInfo array
		for(int i = 0; i < t.length(); i++)
		{
			for(int c = 0; c < oper.length; c++)
			{
				if(String.valueOf(t.charAt(i)).contentEquals(oper[c]))
				{
					System.out.println("Ran position: " + i + " operator type: " + c);
					opInfo[0][storeFound] = i;
					opInfo[1][storeFound] = c;
					System.out.println("Found operator " + storeFound);
					storeFound++;
				}
			}
		}
		
		/**
		for(int i = 0; i < oper.length; i++)
		{
			for(int c = 0; c < t.length(); c++)
			{
				if(t.indexOf(oper[i]) != -1 && storeFound < opCount)
				{
					System.out.println("Ran1");
					for(int j = 0; j < opCount; j++)
					{
						System.out.println("Storef: " + storeFoundAr[j] + " index oper: " + t.indexOf(oper[i]));
						if(storeFoundAr[j] == t.indexOf(oper[i]))
						{
							foundBool = true;
						}
					}
					
					if(foundBool == false && storeFound != 0)
					{
						opInfo[0][storeFound] = t.indexOf(oper[i], location+1);
						opInfo[1][storeFound] = i;
						storeFoundAr[c] = t.indexOf(oper[i]);
						storeFound++;
						location = storeFoundAr[c];
						
						System.out.println("Operator " + c + " position: " + opInfo[0][c]);
						System.out.println("Operator " + c + " type: " + opInfo[1][c]);
					}
					else if(foundBool == false && storeFound == 0)
					{
						opInfo[0][storeFound] = t.indexOf(oper[i]);
						opInfo[1][storeFound] = i;
						storeFoundAr[c] = t.indexOf(oper[i]);
						storeFound++;
						
						System.out.println("Operator " + c + " position: " + opInfo[0][c]);
						System.out.println("Operator " + c + " type: " + opInfo[1][c]);
					}
					foundBool = false;
				}
			}
		}
		
		
		for(int i = 0; i < opCount; i++)
		{
			for(int l = 0; l < oper.length; l++)
			{
				if(i == 0)
				{
					if(t.indexOf(oper[l]) != -1)
					{
						opInfo[0][i] = t.indexOf(oper[l]);
						opInfo[1][i] = l;
						storeFound = opInfo[0][i]+1;
						storeFoundAr[i] = opInfo[0][i];
						
						System.out.println("Operator " + i + " position: " + opInfo[0][i]);
						System.out.println("Operator " + i + " type: " + opInfo[1][i]);
						break;
					}
					else
					{
						if(t.indexOf(oper[l]) != -1 && t.indexOf(oper[l]) != storeFoundAr[i-1])
						{
							opInfo[0][i] = t.indexOf(oper[l]);
							opInfo[1][i] = l;
							storeFound = opInfo[0][i]+1;
							storeFoundAr[i] = opInfo[0][i];
							
							System.out.println("Operator " + i + " position: " + opInfo[0][i]);
							System.out.println("Operator " + i + " type: " + opInfo[1][i]);
							break;
						}
					}
				}
			}
			storeFound = 0;
		}
		**/
		System.out.println("Completed gathering opInfo" + "\n");
		return opInfo;
	}
	
	//This method accepts a string and the location/type of operator, stored as follows: position [0][i], type [1][i].
	//The method will perform the operation specified in the string, then return the result as a double.
	public double TextToCalc(String t, int[][] opInfo)
	{
		for(int i = 0; i < 3; i++)
		{
			equation.add(0);
		}
		
		int digCount = 0;
		double testNumb = 0;
		//startEnd[] is used to store the start and endpoints of the numbers, which will then be passed on to TextToNumb
		int[] startEnd = new int[2];
		//theNumbs[] is used to store the doubles that will be used in the equation. the length of the array is determined by
		//opInfo.length, which is an easier way of determining how many operators there are, +1, since there will be a number at the end
		//unaccompanied by an operator (example 3+3+3, 3 numbers, 2 operators).
		
		//double[] theNumbs = new double[opInfo[0].length+1];
		//ArrayList<Double> theNumbs = new ArrayList<>();
		//this is used to store the original position of the operators, so that a determination of what numbers were before and after can be made.
		int[] origOrder = new int[opInfo[0].length];
		
		//populates with the original order of each location, regardless of their operator.
		//origOrder[0][i] specifies the original index of the operator, and i specifies the number of operators that came before it.
		for(int i = 0; i < origOrder.length; i++)
		{
			origOrder[i] = opInfo[0][i];
		}
		
		//This uses opInfo[0].length to determine the number of operators without importing it explicitly. The loop iterates
		//a number of times equal to how many operators there are, each time determining the start and end of the number by
		//looking at the former location and adding 1 to it for the start, and the current location and subtracting 1 for the end,
		//as opInfo stores where the operators are. For iteration 0, the number's beginning can be assumed to be at 0.
		for(int i = 0; i < opInfo[0].length+1; i++)
		{
			if(i == 0)
			{
				startEnd[0] = 0;
				startEnd[1] = opInfo[0][i]-1;
				System.out.println("Ran " + "Location of ");
			}
			else if(i == opInfo[0].length)
			{
				System.out.println("Ran " + i);
				startEnd[0] = opInfo[0][i-1]+1;
				startEnd[1] = t.toString().length()-1;
			}
			else
			{
				System.out.println("Ran " + i);
				startEnd[0] = opInfo[0][i-1]+1;
				System.out.println("OpInfo: " + opInfo[0][0]);
				startEnd[1] = opInfo[0][i]-1;
			}

			System.out.println("0: "  + startEnd[0] + " 1: " + startEnd[1]);
			//by doing this, theNumbs[i] now contains one of the values to be operated on.
			theNumbs.add(TextToNumb(t, startEnd));
			System.out.println("Number returned by TextToNumb: " + TextToNumb(t, startEnd));
		}
		
		//determine how many digits are in the number added, then adjust the opLocation value so it properly matches the numbers it's paired with
		for(int i = 0; i < opInfo[0].length+1; i++)
		{
			testNumb = theNumbs.get(i);
			while(testNumb >= 1)
			{
				testNumb /= 10;
				digCount++;
			}
			if(digCount > 1)
			{
				for(int c = 0; c < opInfo[0].length; c++)
				{
					if(opInfo[0].length == i)
					{
						break;
					}
					else if(opInfo[0][i] <= opInfo[0][c])
					{
						System.out.println("Old opInfo location: " + opInfo[0][c]);
						opInfo[0][c] -= (digCount-1);
						System.out.println("New opInfo location: " + opInfo[0][c]);
					}
				}
			}
			System.out.println();
			digCount = 0;
		}
		
		//sorts the operators into PEMDAS order, location data remains the same
		int n = opInfo[1].length;
		for(int i = 1; i < n; ++i)
		{
			int temp = opInfo[1][i];
			int temp2 = opInfo[0][i];
			int j = i - 1;
			while(j >= 0 && opInfo[1][j] > temp)
			{
				opInfo[1][j+1] = opInfo[1][j];
				opInfo[0][j+1] = opInfo[0][j];
				j = j-1;
			}
			opInfo[1][j+1] = temp;
			opInfo[0][j+1] = temp2;
		}
		
		//finds the location of the operator, then performs the desired operation using the number before and after it.
		
		int i = 0;
		boolean[] foundAr = new boolean[4];
		
		for(int z = 0; z < opInfo[0].length; z++)
		{
			opInfoLocation.add(opInfo[0][z]);
			opInfoType.add(opInfo[1][z]);
			if(opInfo[1][z] == 0)
			{
				foundAr[0] = true;
			}
			else if(opInfo[1][z] == 1)
			{
				foundAr[1] = true;
			}
			else if(opInfo[1][z] == 2)
			{
				foundAr[2] = true;
			}
			else if(opInfo[1][z] == 3)
			{
				foundAr[3] = true;
			}
			System.out.println("opinfoarraylist: Location: " + opInfoLocation.get(z) + " Type: " + opInfoType.get(z));
		}
		
		//Re-sorts MD and AS in left-to-right order, since that's just how it works.
		SortMdas(foundAr);
		
		for(int z = 0; z < opInfoLocation.size(); z++)
		{
			System.out.println("NEW opinfoarraylist: Location: " + opInfoLocation.get(z) + " Type: " + opInfoType.get(z));
		}
		
		//for(int i = 0; i < theNumbs.size(); i++)
		while(theNumbs.size() > 1)
		{
			PemdasCalc(i);
			/**
			System.out.println("OpInfo: " + opInfo[1][i]);
			switch(opInfo[1][i])
			{
			case 0:
				//determines what position the operator originally came from, which is needed to determine what numbers are on
				//either side of the operator. c+1 operators came before the operator stored in origOrder.
				for(int c = 0; c < origOrder.length; c++)
				{
					//determines 
					System.out.println("c: " + c + " Origorder[c]: " + origOrder[c] + " opInfo: " + opInfo[0][i]);
					if(origOrder[c] == opInfo[0][i])
					{
						System.out.println("Reached case 0");
						System.out.print("Result: " + theNumbs.get(c) + "*" + theNumbs.get(c+1) + "=");
						theNumbs.set(c, theNumbs.get(c) * theNumbs.get(c+1));
						theNumbs.remove(c+1);
						System.out.println(theNumbs.get(c));
					}
				}
				break;
			case 1:
				for(int c = 0; c < origOrder.length; c++)
				{
					//determines 
					if(origOrder[c] == opInfo[0][i])
					{
						System.out.println("Reached case 1");
						System.out.print("Result: " + theNumbs.get(c) + "/" + theNumbs.get(c+1) + "=");
						theNumbs.set(c, theNumbs.get(c) / theNumbs.get(c+1));
						theNumbs.remove(c+1);
						System.out.println(theNumbs.get(c));
					}
				}
				break;
			case 2:
				for(int c = 0; c < origOrder.length; c++)
				{
					System.out.println("Reached case 2");
					//determines 
					System.out.println("Orig order: " + origOrder[c] + " opinfo: " + opInfo[0][i]);
					if(origOrder[c] == opInfo[0][i])
					{
						
						System.out.print("Result: " + theNumbs.get(c) + "*" + theNumbs.get(c+1) + "=");
						theNumbs.set(c, theNumbs.get(c) * theNumbs.get(c+1));
						theNumbs.remove(c+1);
						System.out.println(theNumbs.get(c));
					}
				}
				break;
			case 3:
				for(int c = 0; c < origOrder.length; c++)
				{
					//determines 
					System.out.println("c: " + c + " Origorder[c]: " + origOrder[c] + " opInfo: " + opInfo[0][i]);
					if(origOrder[c] == opInfo[0][i])
					{
						System.out.println("Reached case 3");
						System.out.print("Result: " + theNumbs.get(c) + "-" + theNumbs.get(c+1) + "=");
						theNumbs.set(c, theNumbs.get(c) - theNumbs.get(c+1));
						theNumbs.remove(c+1);
						System.out.println(theNumbs.get(c));
					}
				}
				break;
			}
			**/
			i++;
		}
		return theNumbs.get(0);
		
	}
	
	//this method is intended to re-sort the sorted array of location and type. This is because both MD and AS go in left to right order, instead of whichever
	//comes first.
	private void SortMdas(boolean[] foundAr)
	{
		int bound = 0;
		int temp = 0;
		int temp2 = 0;
		if(foundAr[0] == true && foundAr[1] == true)
		{
			for(int z = 0; z < opInfoType.size(); z++)
			{
				if(opInfoType.get(z) == 2)
				{
					bound = z-1;
					break;
				}
			}
			System.out.println("Lower half bound: " + bound);
			
			while(bound >= 0)
			{
				for(int z = 0; z < bound; z++)
				{
					System.out.println("oplocation(z): " + opInfoLocation.get(z) + " oplocation(z+1) " + opInfoLocation.get(z+1) + " Z: " + z);
					if(opInfoLocation.get(z)>opInfoLocation.get(z+1))
					{
						temp = opInfoLocation.get(z);
						temp2 = opInfoType.get(z);
						System.out.println("opInfo about to be switched: Location: " + opInfoLocation.get(z) + " Type: " + opInfoType.get(z) + " Z: " + z);
						opInfoLocation.set(z, opInfoLocation.get(z+1));
						opInfoType.set(z, opInfoType.get(z+1));
						opInfoLocation.set(z+1, temp);
						opInfoType.set(z+1, temp2);
					}
				}
				bound--;
			}
		}
		int mid = 0;
		if(foundAr[0] == true && foundAr[1] == true)
		{
			for(int z = 0; z < opInfoType.size(); z++)
			{
				if(opInfoType.get(z) == 2)
				{
					bound = z;
					break;
				}
			}
			System.out.println("Upper half bound: " + bound);
			mid = bound;
			while(bound <= opInfoLocation.size())
			{
				for(int z = mid; z < opInfoType.size()-1; z++)
				{
					System.out.println("oplocation(z): " + opInfoLocation.get(z) + " oplocation(z+1) " + opInfoLocation.get(z+1));
					if(opInfoLocation.get(z)>opInfoLocation.get(z+1))
					{
						temp = opInfoLocation.get(z);
						temp2 = opInfoType.get(z);
						System.out.println("opInfo about to be switched: Location: " + opInfoLocation.get(z) + " Type: " + opInfoType.get(z) + " Z: " + z);
						opInfoLocation.set(z, opInfoLocation.get(z+1));
						opInfoType.set(z, opInfoType.get(z+1));
						opInfoLocation.set(z+1, temp);
						opInfoType.set(z+1, temp2);
					}
				}
				System.out.println("Bound update: " + bound);
				bound++;
			}
		}
	}
	//performs operation by sending theNumbs to bindoptonumb() be sorted into a simple equation, then calculates the simple equation, then, using the flushused() 
	//method, flushes used operators and numbers out and updates the equation to include the found result.
	private void PemdasCalc(int i)
	{
		System.out.println("OpInfo: " + opInfoLocation.get(0));
		double result = 0;
		BindOpToNumb();
		
		switch((int)equation.get(1))
		{
		case 0:
			System.out.println("Reached case 0! Equation: " + equation.get(0) + "*" + equation.get(2));
			result = (double)equation.get(0) * (double)equation.get(2);
			break;
		case 1:
			System.out.println("Reached case 1! Equation: " + equation.get(0) + "/" + equation.get(2));
			result = (double)equation.get(0) / (double)equation.get(2);
			break;
		case 2:
			System.out.println("Reached case 2! Equation: " + equation.get(0) + "+" + equation.get(2));
			result = (double)equation.get(0) + (double)equation.get(2);
			break;
		case 3:
			System.out.println("Reached case 3! Equation: " + equation.get(0) + "-" + equation.get(2));
			result = (double)equation.get(0) - (double)equation.get(2);
			break;
		}
		FlushUsed(result);
		/**
		switch(opInfoType.get(0))
		{
		case 0:
			for(int c = 0; c < origOrderList.size(); c++)
			{
				if(origOrderList.get(c) == opInfoLocation.get(c))
				{
					System.out.println("Reached case 0");
					System.out.print("Result: " + theNumbs.get(c) + "*" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) * theNumbs.get(c+1));
					theNumbs.remove(c+1);
					origOrderList.remove(c);
					opInfoLocation.remove(c);
					opInfoType.remove(c);
					System.out.println(theNumbs.get(c));
				}
			}
		case 1:
			for(int c = 0; c < origOrderList.size(); c++)
			{
				if(origOrderList.get(c) == opInfoLocation.get(c))
				{
					System.out.println("Reached case 1");
					System.out.print("Result: " + theNumbs.get(c) + "/" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) / theNumbs.get(c+1));
					theNumbs.remove(c+1);
					origOrderList.remove(c);
					opInfoLocation.remove(c);
					opInfoType.remove(c);
					System.out.println(theNumbs.get(c));
				}
			}
		case 2:
			for(int c = 0; c < origOrderList.size(); c++)
			{
				if(origOrderList.get(c) == opInfoLocation.get(c))
				{
					System.out.println("Reached case 2");
					System.out.print("Result: " + theNumbs.get(c) + "+" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) + theNumbs.get(c+1));
					theNumbs.remove(c+1);
					origOrderList.remove(c);
					opInfoLocation.remove(c);
					opInfoType.remove(c);
					System.out.println(theNumbs.get(c));
				}
			}
		case 3:
			for(int c = 0; c < origOrderList.size(); c++)
			{
				if(origOrderList.get(c) == opInfoLocation.get(c))
				{
					System.out.println("Reached case 3");
					System.out.print("Result: " + theNumbs.get(c) + "-" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) - theNumbs.get(c+1));
					theNumbs.remove(c+1);
					origOrderList.remove(c);
					opInfoLocation.remove(c);
					opInfoType.remove(c);
					System.out.println(theNumbs.get(c));
				}
			}
		}
		
		/**
		switch(opInfo[1][i])
		{
		case 0:
			//determines what position the operator originally came from, which is needed to determine what numbers are on
			//either side of the operator. c+1 operators came before the operator stored in origOrder.
			for(int c = 0; c < origOrder.length; c++)
			{
				//determines 
				System.out.println("c: " + c + " Origorder[c]: " + origOrder[c] + " opInfo: " + opInfo[0][i]);
				if(origOrder[c] == opInfo[0][i])
				{
					System.out.println("Reached case 0");
					System.out.print("Result: " + theNumbs.get(c) + "*" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) * theNumbs.get(c+1));
					theNumbs.remove(c+1);
					System.out.println(theNumbs.get(c));
				}
			}
			break;
		case 1:
			for(int c = 0; c < origOrder.length; c++)
			{
				//determines 
				if(origOrder[c] == opInfo[0][i])
				{
					System.out.println("Reached case 1");
					System.out.print("Result: " + theNumbs.get(c) + "/" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) / theNumbs.get(c+1));
					theNumbs.remove(c+1);
					System.out.println(theNumbs.get(c));
				}
			}
			break;
		case 2:
			for(int c = 0; c < origOrder.length; c++)
			{
				System.out.println("Reached case 2");
				//determines 
				System.out.println("Orig order: " + origOrder[c] + " opinfo: " + opInfo[0][i]);
				if(origOrder[c] == opInfo[0][i])
				{
					
					System.out.print("Result: " + theNumbs.get(c) + "*" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) * theNumbs.get(c+1));
					theNumbs.remove(c+1);
					System.out.println(theNumbs.get(c));
				}
			}
			break;
		case 3:
			for(int c = 0; c < origOrder.length; c++)
			{
				//determines 
				System.out.println("c: " + c + " Origorder[c]: " + origOrder[c] + " opInfo: " + opInfo[0][i]);
				if(origOrder[c] == opInfo[0][i])
				{
					System.out.println("Reached case 3");
					System.out.print("Result: " + theNumbs.get(c) + "-" + theNumbs.get(c+1) + "=");
					theNumbs.set(c, theNumbs.get(c) - theNumbs.get(c+1));
					theNumbs.remove(c+1);
					System.out.println(theNumbs.get(c));
				}
			}
			break;
		}
		**/
	}
	
	//this method binds the number before an operator, the operator type, and the number after the operator, into a 3-part arraylist.
	public void BindOpToNumb()
	{
		for(int i = 0; i < theNumbs.size(); i++)
		{
			System.out.println("theNumbs index " + i + ": " + theNumbs.get(i));
		}
		System.out.println();
		System.out.println("The index of the number being placed in equation[0]: " + (opInfoLocation.get(0)-1)/2);
		System.out.println("The index of the number being placed in equation[2]: " + (opInfoLocation.get(0)+1)/2);
		System.out.println("The number being placed in equation[0]: " + theNumbs.get((opInfoLocation.get(0)-1)/2));
		System.out.println("The number being placed in equation[2]: " + theNumbs.get((opInfoLocation.get(0)+1)/2));
		equation.set(0, theNumbs.get((opInfoLocation.get(0)-1)/2));
		equation.set(1,  opInfoType.get(0));
		equation.set(2, theNumbs.get((opInfoLocation.get(0)+1)/2));
	}
	
	//this method flushes the numbers and operators that were just used in calculation out of the data, then adjusts the opInfoLocation arraylist
	//to match the index of thenumbs post-deletion.
	public void FlushUsed(double result)
	{
		System.out.println("The result: " + result + " The location that result is being set: " + (opInfoLocation.get(0)-1)/2);
		theNumbs.set((opInfoLocation.get(0)-1)/2, result);
		theNumbs.remove((opInfoLocation.get(0)+1)/2);
		
		//find all numbers after the newly removed location number, and add 2 to each
		for(int i = 0; i < opInfoLocation.size(); i++)
		{
			if(opInfoLocation.get(0) < opInfoLocation.get(i))
			{
				opInfoLocation.set(i, opInfoLocation.get(i)-2);
			}
		}
		
		opInfoType.remove(0);
		opInfoLocation.remove(0);
	}
	
	//converts the text to a double by accepting the start and end position of the number in the string, and returns a double based off those values.
	private double TextToNumb(String t, int [] startEnd)
	{
		//tshort is used to store the shortened string
		String tShort = "";
		//used to store the length of the number
		System.out.println(startEnd[0] + " " + startEnd[1]);
		int length = startEnd[1]-startEnd[0];
		//stores the converted int
		double theNumb = 0;
		
		/**
		System.out.println(length);
		System.out.println(t.charAt(0));
		System.out.println(t.charAt(1));
		System.out.println("String: " + t);
		**/
		
		for(int i = 0; i < length+1; i++)
		{
			tShort = tShort + t.charAt(startEnd[0]+i);
		}
		theNumb = Double.parseDouble(tShort);
		System.out.println("The numb: " + theNumb);
		return theNumb;
	}
	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
