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
	for (int i = 0; i < (2 * arr.length); i++) { //counter
	    if (arr[row][col] == number) {
		return "(" + row + ", " + col + ")";
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
   
    return "(-1, -1)";
}//end finder(int)

    //populates the array with numbers ascending in each row and column
    public void populate(){ 
	int len = this.arr.length;
	int count = 0;
	for (int row = 0; row < len; row++){
	    for (int col = 0; col < len; col++){
		this.arr[row][col] = count;
		count ++;
	    }
	}

    }
    
   public static void main (String[] args) {
       lab0[] master = new lab0[50]; //creates an array of lab0 instances
       int counter = 10000;
       long startT;
       long endT;
       long trial1;
       long trial2;
       long trial3;
       long avg;
       
       for (int i = 0; i < master.length; i++){ 
	   master[i] = new lab0(counter); //instantiates lab0 with sidelength counter
	   master[i].populate();
	   
	   startT = System.nanoTime();
	   master[i].finder(counter-1);
	   endT = System.nanoTime();
	   trial1 = endT-startT;
	   
	   startT = System.nanoTime();
	   master[i].finder(counter-1);
	   endT = System.nanoTime();
	   trial2 = endT-startT;

	   startT = System.nanoTime();
	   master[i].finder(counter-1);
	   endT = System.nanoTime();
	   trial3 = endT-startT;
	   
	   avg = (trial1 + trial2 + trial3)/3;
	   System.out.println(counter + "," +  avg);
	   counter += 50;
       }

       
       

		
    }//end main()
}//end MatrixFinder
