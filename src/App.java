import java.util.Scanner;

public class App {
    static int[][] matrixMultiplication(int[][] mat1, int[][] mat2){
        int[][] answer = new int[mat1.length][mat2[0].length];
        int temp = 0;
        int count = 0;
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                while (count < mat2.length) {
                    temp += (mat1[i][count] * mat2[count][j]);
                    count++;
                }
                answer[i][j] = temp;
                temp = count = 0;
            }
        }


        return answer;
    }


    public static void main(String[] args) throws Exception {

        // scanner utility to take user inputs
        try (Scanner scanner = new Scanner(System.in)) {
            boolean check = false; // boolean variable to check if multiplication will be possible;

            // initializing input matrices
            int[][] matrixOne = new int[0][0];
            int[][] matrixTwo = new int[0][0];
            
            
            
            while (!check) {
                boolean checkMatrix1Dimension = false;
                boolean checkMatrix2Dimension = false;
                int mat1Rows = 0;
                int mat1Cols = 0;
                int mat2Rows = 0;
                int mat2Cols = 0;
                

                // taking dimensions of matrix 1 ensuring inputs are validated
                while (!checkMatrix1Dimension) {
                    System.out.print("Enter row dimension of matrix 1: ");
                    mat1Rows = scanner.nextInt();
                    System.out.print("Enter column dimension of matrix 1: ");
                    mat1Cols = scanner.nextInt();
                    matrixOne = new int[mat1Rows][mat1Cols];

                    if(mat1Rows > 0 && mat1Rows <= 100){
                        checkMatrix1Dimension = true;
                    }
                    else{
                        System.out.println("Make sure dimensions are greater than 0 and less than or equal to 100");
                    }
                }

                // taking dimensions of matrix 2 ensuring inputs are validated
                while (!checkMatrix2Dimension) {
                    // Take dimensions of matrix 2
                    System.out.print("Enter row dimension of matrix 2: ");
                    mat2Rows = scanner.nextInt();
                    System.out.print("Enter column dimension of matrix 2: ");
                    mat2Cols = scanner.nextInt();
                    matrixTwo = new int[mat2Rows][mat2Cols];

                    if(mat1Rows > 0 && mat1Rows <= 100){
                        checkMatrix2Dimension = true;
                    }
                    else{
                        System.out.println("Make sure dimensions are greater than 0 and less than or equal to 100");
                    }
                }

                

                // check if matrix 2 row dimension == matrix 1 column dimension
                if(mat1Cols == mat2Rows){
                    check = true;
                }
                else{
                    System.out.println("Make sure number of rows in matrix 2 is equal to number of columns in matrix 1");
                    checkMatrix1Dimension = checkMatrix2Dimension = false;
                }


            }


            // taking elements of matrix 1 ensuring values are validated
            boolean elementCheck = false;
            System.out.println("Enter values of matrix 1 row by row");
            for (int i = 0; i < matrixOne.length; i++) {
                for (int j = 0; j < matrixOne[0].length; j++) {
                    System.out.printf("Enter a number for position (%s, %s): ", i, j);
                    while (!elementCheck) {
                        matrixOne[i][j] = scanner.nextInt();
                        if (matrixOne[i][j] >= 0 && matrixOne[i][j] <= 100) {
                            elementCheck = true;
                        }
                    }
                    elementCheck = false;
                }
            }

            // taking elements of matrix 2 ensuring values are validated
            boolean elementCheck2 = false;
            System.out.println("Enter values of matrix 2 row by row");
            for (int i = 0; i < matrixTwo.length; i++) {
                for (int j = 0; j < matrixTwo[0].length; j++) {
                    System.out.printf("Enter a number for position (%s, %s): ", i, j);
                    while (!elementCheck2) {
                        matrixTwo[i][j] = scanner.nextInt();
                        if (matrixTwo[i][j] >= 0 && matrixTwo[i][j] <= 100) {
                            elementCheck2 = true;
                        }
                    }
                    elementCheck2 = false;
                }
            }

            

            int[][] answer = matrixMultiplication(matrixOne, matrixTwo);

            System.out.println("Matrix C: (" +  answer.length + "," + answer[0].length + ")");
            for (int i = 0; i < answer.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < answer[0].length; j++) {
                    System.out.print(answer[i][j] + " ");
                    if(j == answer[0].length - 1){
                        // System.out.println("");
                    }
                }
                System.out.println(" |\t");
            }
        } catch (Exception e){
            System.out.println("Something went wrong. Try again...");
        }




    }
}
