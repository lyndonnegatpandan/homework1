import java.util.Scanner;
import java.util.Random;


public class homework1{

	public String randomGenerator(){
		Random r = new Random();
		StringBuilder a = new StringBuilder(3); //String builder with capacity of 3
		String ascii="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^&*()_+";
		for(int i = 0; i<3;i++){
			a.append(ascii.charAt(r.nextInt(ascii.length()))); //Randomizer of characters with length of 3.
		}
		return a.toString();
	}

	public void dataEncoder(String[][] cell){
		for(int i = 0; i < cell.length; i++){
			for(int j = 0 ; j < cell[0].length; j++){
				cell[i][j]=randomGenerator();
			}
		}
	}

	public void editData(String[][] cell){
		Scanner sc = new Scanner(System.in);
		System.out.print("Array index x: "); //Input x and y coordinates. 
		int xCoordinate = sc.nextInt();
		System.out.print("Array index y: ");
		int yCoordinate = sc.nextInt();
		System.out.print("Enter new value: ");
		String newValue = sc.next();
		cell[xCoordinate][yCoordinate] = newValue; //Replace the value of the specific coordinates.

		for(int i = 0; i<cell.length; i++){
			for(int j = 0; j<cell[0].length; j++){
				System.out.print(cell[i][j] + " "); //Print the array.
			}
			System.out.println();
		}
	}


	public void search(String[][] cell){
		Scanner sc = new Scanner(System.in);
		int index = 0;
		int count = 0;
	
		System.out.print("Enter value to search: "); //User inputs the value.
		String valueToSearch = sc.next();
		
		for(int i = 0; i<cell.length; i++){
			for(int j = 0; j<cell[0].length	; j++){
				while((index = cell[i][j].indexOf(valueToSearch, index))!=-1){ //Search for the value.
					count++;
					index++;
					System.out.print("[" + i + "," + j + "]" + "-" + count); //Outputs the coordinates and count.
				}
			}
			count = 0;
			System.out.println();
		}
	}


	public static void main(String args[]){
		homework1 Hw1 = new homework1();
		Scanner sc = new Scanner(System.in);
		String cell[][];
		System.out.print("Enter the number of row: ");
		int rowNum = sc.nextInt();
		System.out.print("Enter the number of column: ");
		int colNum = sc.nextInt();
		cell = new String[rowNum][colNum];
		Hw1.dataEncoder(cell); //Pass the array with dimensions from user to method dataEncoder. 
		for(int i = 0; i < cell.length; i++){ //Array output.
			for(int j = 0 ; j < cell[0].length; j++){
				System.out.print(cell[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}


		while(true){ //Outputs the main menu.
			System.out.println("Main Menu");
			System.out.println("1.) New Array");
			System.out.println("2.) Edit Array");
			System.out.println("3.) Search Array");
			System.out.println("4.) View Array");
			System.out.println("5.) Exit");
			System.out.println("Choice: ");
			int a = sc.nextInt();

			switch(a){ //Switch cases.
			case 1:
				System.out.print("Enter the number of row: ");
				rowNum = sc.nextInt();
				System.out.print("Enter the number of column: ");
				colNum = sc.nextInt();
				cell = new String[rowNum][colNum];
				Hw1.dataEncoder(cell);
				for(int i = 0; i < cell.length; i++){
					for(int j = 0; j < cell[0].length; j++){ //Array output.
						System.out.print(cell[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				break;
			case 2:
				Hw1.editData(cell); //Pass the array to method editData.
				break;
			case 3:
				Hw1.search(cell); //Pass the array to method search
				break;
			case 4:
				for(int i = 0; i < cell.length; i++){ //Array output.
					for(int j = 0; j < cell[0].length; j++){
						System.out.print(cell[i][j]);
						System.out.print(" ");
					}
					System.out.println();
				}
				break;
			case 5: 
				System.exit(0);

			}
		}
	}
}