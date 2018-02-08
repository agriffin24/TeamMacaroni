/******************************************                           
 *Our algorithm: Starting from the                                        
 *bottom left corner, the finder goes                                       
 *through by checking the number and moving                                 
 *right or up if the desired number is                                      
 *smaller or larger than the array number,                                  
 *respectively. Breaks if column or row is                                  
 *too big.                                                                 
 *************************************/
public class lab0 {
    int[][] arr;
    /******************************
     *Overloaded Constructor
     **Makes a new MatrixFinder of
     **certain length
     *****************************/
    public lab0(int n){
	arr = new int[n][n];
    }//end constructor(int)
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //toString to display the array
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public String toString() {
	String retString = "";
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[0].length; j++) {
		if (j + 1 == arr[0].length) {
		    System.out.print(arr[i][j] + "\n");
		}
		else{
		    System.out.print(arr[i][j] + "\t");
		}
	    }
	}
	return retString;
    }//end toString()
    
    //finder(int) method: used to find element in matrix
    //if the element is in the matrix, return its coordinates CS style(starting from 0)
    //if the element is not in the matrix return (-1,-1)
    public String finder(int number) {
	int row = arr.length - 1;
	int col = 0;
	for (int i = 0; i < (2 * arr.length) - 2; i++) { //counter
	    if (arr[row][col] == number) {
		System.out.println(row);
		return "(" + row + ", " + col + ")";
	    }
	    else{
		if (row - 1 < 0) {
		    break;
		}
		else{
		    if (arr[row][col] > number) {
			row--;
		    }
		    else{
			if (col + 1 != arr[0].length) {
			    col++;
			}
			else{
			    break;
			}
		    }
		}
	    }
	    if (i == 0 || i == (2 * arr.length) - 3){
		System.out.println(System.currentTimeMillis());
	    }
	}
	return "(-1, -1)";
    }//end finder(int)
    
    public static void main (String[] args) {
	int choice = 1;
	lab0 pop = new lab0(10000);
	int k = pop.arr.length;
	System.out.println(k);
	System.out.println(System.currentTimeMillis());
	for (int a = 0; a < pop.arr.length; a++) {
	    for (int w = 0; w < pop.arr[0].length; w++) {
		if (w == 0){
		    pop.arr[a][w] = a;
		}
		else{
		    pop.arr[a][w] = (a + 2 * w);
		}
	    }
	}
	//System.out.println(pop);
	try {
	    choice = (int) (30000 * Math.random());
	    System.out.println(choice);
	    System.out.println(System.currentTimeMillis());
	}
	catch (Exception e) { }
	long a = System.currentTimeMillis();
	System.out.println(pop.finder(choice));
	long b = System.currentTimeMillis();
	long x = b - a;
	System.out.println("(10,000, " + x + ")");
    }//end main()
}//end MatrixFinder
