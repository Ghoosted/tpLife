/* Auteur: Brock Marion
 *
 * Date: 2015-12-01
 * Last Modified: 2017-06-09
 *
 * Conway's game of life!
 *
 */

public class tpLife {
	
	// # Declare variables #
	int [][] lifeTable = new int [15][15];
	int [][] nextLife = new int [15][15];
	int row = 0;
	int col = 0;
	int nearby = 0;
	KeyBoardInput kb;
	
	public void loadTable() {
		
		// # Declare variables #
		int cellNum;
		int template;

		if (kb.readChar("Do you want a preset cell arrangement? [y/n]: ") != 'n') {
			System.out.println("Preset 1: Blinker");
			System.out.println("Preset 2: Glider");
			System.out.println("Preset 3: Pulsar");
			System.out.println("Preset 4: Fumarole");
			System.out.println("Preset 5: Galaxy");
			template = kb.readInt("Which preset would you like? [1-5]: ");

			switch (template) {
				case 1: 
					lifeTable[7][6] = 1;
					lifeTable[7][7] = 1;
					lifeTable[7][8] = 1;
					break;
				case 2: 
					lifeTable[0][1] = 1;
					lifeTable[1][2] = 1;
					lifeTable[2][0] = 1;
					lifeTable[2][1] = 1;
					lifeTable[2][2] = 1;
					break;
				case 3: 
					lifeTable[1][3] = 1;
					lifeTable[1][4] = 1;
					lifeTable[1][5] = 1;
					lifeTable[1][9] = 1;
					lifeTable[1][10] = 1;
					lifeTable[1][11] = 1;
					lifeTable[3][1] = 1;
					lifeTable[3][6] = 1;
					lifeTable[3][8] = 1;
					lifeTable[3][13] = 1;
					lifeTable[4][1] = 1;
					lifeTable[4][6] = 1;
					lifeTable[4][8] = 1;
					lifeTable[4][13] = 1;
					lifeTable[5][1] = 1;
					lifeTable[5][6] = 1;
					lifeTable[5][8] = 1;
					lifeTable[5][13] = 1;
					lifeTable[6][3] = 1;
					lifeTable[6][4] = 1;
					lifeTable[6][5] = 1;
					lifeTable[6][9] = 1;
					lifeTable[6][10] = 1;
					lifeTable[6][11] = 1;
					lifeTable[8][3] = 1;
					lifeTable[8][4] = 1;
					lifeTable[8][5] = 1;
					lifeTable[8][9] = 1;
					lifeTable[8][10] = 1;
					lifeTable[8][11] = 1;
					lifeTable[9][1] = 1;
					lifeTable[9][6] = 1;
					lifeTable[9][8] = 1;
					lifeTable[9][13] = 1;
					lifeTable[10][1] = 1;
					lifeTable[10][6] = 1;
					lifeTable[10][8] = 1;
					lifeTable[10][13] = 1;
					lifeTable[11][1] = 1;
					lifeTable[11][6] = 1;
					lifeTable[11][8] = 1;
					lifeTable[11][13] = 1;
					lifeTable[13][3] = 1;
					lifeTable[13][4] = 1;
					lifeTable[13][5] = 1;
					lifeTable[13][9] = 1;
					lifeTable[13][10] = 1;
					lifeTable[13][11] = 1;
					break;
				case 4: 
					lifeTable[4][6] = 1;
					lifeTable[4][7] = 1;
					lifeTable[5][4] = 1;
					lifeTable[5][9] = 1;
					lifeTable[6][4] = 1;
					lifeTable[6][9] = 1;
					lifeTable[7][4] = 1;
					lifeTable[7][9] = 1;
					lifeTable[8][5] = 1;
					lifeTable[8][8] = 1;
					lifeTable[9][3] = 1;
					lifeTable[9][5] = 1;
					lifeTable[9][8] = 1;
					lifeTable[9][10] = 1;
					lifeTable[10][3] = 1;
					lifeTable[10][4] = 1;
					lifeTable[10][9] = 1;
					lifeTable[10][10] = 1;
					break;
				case 5: 
					lifeTable[3][5] = 1;
					lifeTable[3][8] = 1;
					lifeTable[3][10] = 1;
					lifeTable[4][3] = 1;
					lifeTable[4][4] = 1;
					lifeTable[4][6] = 1;
					lifeTable[4][8] = 1;
					lifeTable[4][9] = 1;
					lifeTable[4][10] = 1;
					lifeTable[5][4] = 1;
					lifeTable[5][11] = 1;
					lifeTable[6][3] = 1;
					lifeTable[6][4] = 1;
					lifeTable[6][10] = 1;
					lifeTable[8][4] = 1;
					lifeTable[8][10] = 1;
					lifeTable[8][11] = 1;
					lifeTable[9][3] = 1;
					lifeTable[9][10] = 1;
					lifeTable[10][4] = 1;
					lifeTable[10][5] = 1;
					lifeTable[10][6] = 1;
					lifeTable[10][8] = 1;
					lifeTable[10][10] = 1;
					lifeTable[10][11] = 1;
					lifeTable[11][4] = 1;
					lifeTable[11][6] = 1;
					lifeTable[11][9] = 1;
					break;
			}

		} else {
			cellNum = kb.readInt("How many cells would you like? [1-225]: ");
			
			for (int i = 1; i < cellNum + 1; i++) {
				row = kb.readInt("Enter the row for cell #" + i + ": ");
				col = kb.readInt("Enter the column for cell #" + i + ": ");
				lifeTable[row][col] = 1;
			}
		}
		// # Asking number of cells and their positions #

	}
	
	public void printTable() {
		
		// # Print Array #
		for (int i = 0; i < lifeTable[0].length; i++) {
			for (int j = 0; j < lifeTable[0].length; j++) {
				if (lifeTable[i][j] == 1) {
					System.out.print("# ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
		
		for (int r = 0; r < lifeTable[0].length; r++) {
			for (int c = 0; c < lifeTable[0].length; c++) {
				// 1
				if (r == 0 && c == 0){
					nearby = 
						lifeTable[r][c+1] +
						lifeTable[r+1][c+1] +
						lifeTable[r+1][c];
		
				}
				// 2
				else if (r == 0 && c == lifeTable[0].length-1) {
					nearby = 
						lifeTable[r][c-1] +
						lifeTable[r+1][c-1] +
						lifeTable[r+1][c];
				}
				// 3
				else if (r == lifeTable[0].length-1 && c == 0) {
					nearby = 
						lifeTable[r-1][c] +
						lifeTable[r-1][c+1] +
						lifeTable[r][c+1];
				}
				// 4
				else if (r == lifeTable[0].length-1 && c == lifeTable[0].length-1) {
					nearby = 
						lifeTable[r-1][c-1] +
						lifeTable[r-1][c] +
						lifeTable[r][c-1];
				}
				// 5
				else if (r == 0) {
					nearby = 
						lifeTable[r][c-1] +
						lifeTable[r][c+1] +
						lifeTable[r+1][c-1] +
						lifeTable[r+1][c] +
						lifeTable[r+1][c+1];
				}
				// 6
				else if (c == lifeTable[0].length-1) {
					nearby = 
						lifeTable[r-1][c-1] +
						lifeTable[r-1][c] +
						lifeTable[r][c-1] +
						lifeTable[r+1][c-1] +
						lifeTable[r+1][c];
				}
				// 7
				else if (r == lifeTable[0].length-1) {
					nearby = 
						lifeTable[r-1][c-1] +
						lifeTable[r-1][c] +
						lifeTable[r-1][c+1] +
						lifeTable[r][c-1] +
						lifeTable[r][c+1];
				}
				// 8
				else if (c == 0) {
					nearby = 
						lifeTable[r-1][c] +
						lifeTable[r-1][c+1] +
						lifeTable[r][c+1] +
						lifeTable[r+1][c] +
						lifeTable[r+1][c+1];
				}
				// 9
				else {
					nearby = 
						lifeTable[r-1][c-1] +
						lifeTable[r-1][c] +
						lifeTable[r-1][c+1] +
						lifeTable[r][c-1] +
						lifeTable[r][c+1] +
						lifeTable[r+1][c-1] +
						lifeTable[r+1][c] +
						lifeTable[r+1][c+1];
				}
				if (lifeTable[r][c] == 1) {
					if (nearby < 2 || nearby > 3) {
						nextLife[r][c] = 0;
					}
					else {
						nextLife[r][c] = 1;
					}
				}
				else {
					if (nearby == 3) {
						nextLife[r][c] = 1;
					}
				}
				
				
			}
			
		}
		for (int i = 0; i < lifeTable[0].length; i++) {
			for (int j = 0; j < lifeTable[0].length; j++) {
				lifeTable[i][j] = nextLife[i][j];
			}
		}
	}
	
	public tpLife() {

		kb = new KeyBoardInput();
		loadTable();
		
	}
	
	
	public static void main(String [] args) {
		
		KeyBoardInput kb = new KeyBoardInput();
		int counter = 0;
		String pass;
		tpLife me = new tpLife();

		do {
			System.out.println(" ");
			me.printTable();
			counter++;
		} while (kb.readChar("Do you wish to see another pass? [y/n]") != 'n');

		System.out.println("You have made a total of " + counter + " passes!");
		System.out.println("Thanks for playing!");
	}
}