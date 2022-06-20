public class CrossAndZero {
    public static final int SIZE = 6;
    public static final char EMPTY = '-';
    public static final char CROSS = 'X';
    public static final char ZERO = 'O';

    public static void main(String[] args) {
        char[][] field = createEmptyField();
        for (int i = 0; i < SIZE / 2; i++) {
            for (int j = 0; j < SIZE / 2; j++) {
                field[i][j] = CROSS;
            }
        }
        for (int i = SIZE / 2; i < SIZE; i++) {
            for (int j = SIZE / 2; j < SIZE; j++) {
                field[i][j] = ZERO;
            }
        }
        System.out.println("Демонстрация");
        System.out.println();
        isWin2(field);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            field[0][i] = CROSS;
        }
        isWin2(field);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            field[i][SIZE - 1 - i] = ZERO;
        }
        isWin2(field);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            field[i][2] = CROSS;
        }
        isWin2(field);
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            field[i][i] = ZERO;
        }
        isWin2(field);
    }

    public static boolean isWin(char[][] field, char player) {
        int line;
        for (int row = 0; row < SIZE; row++) {
            line = 0;
            for (int cell = 0; cell < SIZE; cell++) {
                if (field[row][cell] == player)
                    line++;
            }
            if (line == SIZE)
                return true;
        }
        int column;
        for (int i = 0; i < SIZE; i++) {
            column = 0;
            for (int j = 0; j < SIZE; j++) {
                if (field[j][i] == player)
                    column++;
            }
            if (column == SIZE)
                return true;
        }
        int diagonal1 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (field[i][i] == player)
                diagonal1++;
        }
        if (diagonal1 == SIZE)
            return true;
        int diagonal2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (field[i][SIZE - 1 - i] == player)
                diagonal2++;
        }
        return diagonal2 == SIZE;
    }

    public static void printField(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void isWin2(char[][] field) {
        if (isWin(field, CROSS)) {
            printField(field);
            System.out.println("Победили крестики");
        } else if (isWin(field, ZERO)) {
            printField(field);
            System.out.println("Победили нолики");
        } else {
            printField(field);
            System.out.println("Никто не победил");
        }
    }

    public static char[][] createEmptyField () {
        char[][] field = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                field[i][j] = EMPTY;
            }
        }
        return field;
    }
}
