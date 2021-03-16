package Lab2;//Дана матрица.
//В каждой строке найти наибольший элемент.
//Из этих элементов найти наименьший и удалить ту строку которой он принадлежит.
//Вывести исходную матрицу и новую.

public class Lab2 {
    String matrixBefore = "[";
    String matrixAfter = "[";
    int x = 4;

    public void setX(int x) {
        this.x = x;
    }

    public String getMatrixBefore() {
        return matrixBefore;
    }

    public String getMatrixAfter() {
        return matrixAfter;
    }

    public void work() {
        int[][] originalArrayMatrix = new int [x][x];
        //Заполнение матрицы
        for (int i = 0; i < originalArrayMatrix.length; i++) {
            for (int j = 0; j < originalArrayMatrix[i].length; j++) {
                originalArrayMatrix[i][j] = (int) (Math.random() * 10);
                if (j + 1 != x)
                    matrixBefore += originalArrayMatrix[i][j] + " ";
                else
                    matrixBefore += originalArrayMatrix[i][j];
            }
            if (i + 1 != x)
                matrixBefore += "]\n[";
            else
                matrixBefore += "]";
        }


        int mValue;
        int[] maxValueVector = new int [x];
        //Находим максимальные значения в строках и записываем это в вектор
        for (int i = 0; i < x; i++) {
            mValue = originalArrayMatrix[i][0];
            for (int j = 0; j < x; j++) {
                if (originalArrayMatrix[i][j] > mValue)
                    mValue = originalArrayMatrix[i][j];
            }
            maxValueVector[i] = mValue;
        }

        int minVectorIndex = 0;
        mValue = maxValueVector[0];
        //Находим индекс минимального из максимальных значений
        for (int i = 0; i < x; i++)
            if (maxValueVector[i] < mValue) {
                mValue = maxValueVector[i];
                minVectorIndex = i;
            }

        int counter = 0;
        int[][] finalArrayMatrix = new int [x-1][x];
        //Заполнение и вывод финальной матрицы
        for (int i = 0; i < finalArrayMatrix.length; i++) {
            if (minVectorIndex == i) counter++;
            for (int j = 0; j < finalArrayMatrix[i].length; j++) {
                finalArrayMatrix[i][j] = originalArrayMatrix[i + counter][j];
                if (j + 1 != x)
                    matrixAfter += finalArrayMatrix[i][j] + " ";
                else
                    matrixAfter += finalArrayMatrix[i][j];
            }
            if (i + 1 != x -1)
                matrixAfter += "]\n[";
            else
                matrixAfter += "]";
        }
    }
}
