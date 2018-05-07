package main;

import java.awt.Point;

public class Process {
	private int matrix[][];
	private int win = 0;
	
	public Process(){
		matrix = new int[Graphics.row + 2][Graphics.col + 2];
	}

	public boolean updateMatrix(boolean useCross, Point point){
		int row = point.x + 1;
		int col = point.y + 1;
		short player = (short) (useCross?1:2);
		
		for(int i = 0; i < Graphics.row; i++){
			System.out.println();
		}
		
		if(matrix[row][col] == 0){
			matrix[row][col] = player;
		}else{
			System.out.println("error");
			return false;
		}
		
		for(int i = 1; i < Graphics.row - 1; i++){
			for(int j = 1; j < Graphics.col -1; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		win = checkWin(row, col);
		return true;
	}

	private int checkWin(int row, int col) {
		int[][] rc = {{0, -1, 0, 1}, {-1, 0, 1,0}, {1, -1, -1, 1}, {-1, -1, 1, 1}};
		int i = row, j = col;
		for(int direction = 0; direction < 4; direction++){
			int count = 0;
			System.out.println("[" + direction + "]-" + "[" + row + "," + col + "]  ");
			
			i = row;
			j = col;
			while (i > 0 && i < matrix.length && j > 0 && j < matrix.length
					&& matrix[i][j] == matrix[row][col]) {
				count++;
				if (count == 5) {
					return matrix[row][col];
				}
				System.out.print("\t[" + i + "," + j + "]  ");
				i += rc[direction][0];
				j += rc[direction][1];
				System.out.println("--->[" + i + "," + j + "]  ");
			}
			System.out.println("\tcount1 : " + count);

			count--;
			i = row;
			j = col;
			while (i > 0 && i < matrix.length && j > 0 && j < matrix.length
					&& matrix[i][j] == matrix[row][col]) {
				count++;
				if (count == 5) {
					return matrix[row][col];
				}
				System.out.print("\t[" + i + "," + j + "]  ");
				i += rc[direction][2];
				j += rc[direction][3];
				System.out.println("--->[" + i + "," + j + "]  ");
			}
			System.out.println("\tcount : " + count);
		}
		
		return 0;
	}
	
	protected void undoMatrix(Point point) {
		int row = point.x + 1;
		int col = point.y + 1;
		matrix[row][col] = 0;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
}
