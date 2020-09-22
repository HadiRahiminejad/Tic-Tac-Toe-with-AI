package tictactoe;

import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Integer.parseInt;

 class Hard {
    String[] boardMain = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
    String huPlayer = "X";
    String aiPlayer = "O";
    int iter = 0;
    int round = 0;

    public int minimax( String[] reboard, String player) {
        iter++;
        int score;
        String[] array = avail(reboard);
        if (winning(reboard, huPlayer)) {
            score = -10;
            return score;

        } else if (winning(reboard, aiPlayer)) {
            score = 10;
            return score;

        } else if (array.length == 0) {
            score = 0;
            return score;
        }

        String[] moves = {};
        for (int i = 0; i < array.length; i++) {
            int[] move = {};
            reboard[i] = player;

            if (player.equals(aiPlayer)) {
                var g = minimax(reboard, huPlayer);
                move[i] = g;
            } else {
                var g = minimax(reboard, aiPlayer);
                move[i] = g;
            }
            reboard[i] = Integer.toString(move[i]);
            moves[i] = (Integer.toString(move[i]));
        }

        int bestMove = 10;
        if (player.equals(aiPlayer)) {
            var bestScore = -10000;
            for (var i = 0; i < moves.length; i++) {
                if (Integer.parseInt(moves[i]) > bestScore) {
                    bestScore = Integer.parseInt(moves[i]);
                    bestMove = i;
                }
            }
        } else {
            var bestScore = 10000;
            for (var i = 0; i < moves.length; i++) {
                if (Integer.parseInt(moves[i]) < bestScore) {
                    bestScore = Integer.parseInt(moves[i]);
                    bestMove = i;
                }
            }
        }
        return bestMove;
    }

    //available spots
    public String[] avail(String[] reboard) {
        for (int i = 0; i < reboard.length; i++) {
            if (!reboard[i].equals("X") && !reboard[i].equals("O"))
                reboard[0] = reboard[i];
        }
        return reboard;
    }

    // winning combinations
    public boolean winning(String[] board, String player) {

        return (board[0].equals(player) && board[1].equals(player) && board[2].equals(player)) ||
                (board[3].equals(player) && board[4].equals(player) && board[5].equals(player)) ||
                (board[6].equals(player) && board[7].equals(player) && board[8].equals(player)) ||
                (board[0].equals(player) && board[3].equals(player) && board[6].equals(player)) ||
                (board[1].equals(player) && board[4].equals(player) && board[7].equals(player)) ||
                (board[2].equals(player) && board[5].equals(player) && board[8].equals(player)) ||
                (board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) ||
                (board[2].equals(player) && board[4].equals(player) && board[6].equals(player));
    }
}
public class Main {
    static Scanner sc = new Scanner(System.in);

    static int cunterX = 0;
    static int cunterO = 0;
    static int n = 3;
    static String[][] ticta = {{"0", "1", "2"}, {"3", "4", "5"}, {"6", "7", "8"}};
    static List<String> listTicta = new ArrayList<String>(Arrays.<String>asList(ticta));

    static String input;
    static String[] tict;
    static String[][] threeNodes = {{"00", "01", "02"}, {"10", "11", "12"},{"20", "21", "22"}, {"00", "10", "20"}, {"01", "11", "21"}, {"02", "12", "22"}, {"00", "11", "22"}, {"02", "11", "20"}};


    static void matrix (String cell ,int row  ,int column ){


        if (cell.equals(" ")) {
            for ( row = 0; row < n; row++) {
                for (column = 0; column < ticta[row].length; column++) {
                    ticta[row][column] = cell;
                }
            }
        } else {
            ticta[row][column] = cell;
        }
        System.out.println("---------");
        for (int i = 0; i < n; i++) {
            System.out.print("| ");
            for (int j = 0; j < ticta[i].length; j++) {
                System.out.print(ticta[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static boolean win() {

        int p = 0;
        int cX = 0;
        int cO = 0;
        boolean win = false;

        boolean controll = false;

        for (int i = 0; i < 8; i++) {
            String[] both = threeNodes[i][0].split("");
            String[] both1 = threeNodes[i][1].split("");
            String[] both2 = threeNodes[i][2].split("");
            int first = Integer.parseInt(both[0]);
            int second = Integer.parseInt(both[1]);
            int first1 = parseInt(both1[0]);
            int second1 = parseInt(both1[1]);
            int first2 = parseInt(both2[0]);
            int second2 = parseInt(both2[1]);
            if (ticta[first][second].equals("O") && ticta[first1][second1].equals("O") && ticta[first2][second2].equals("O")) {

                controll = true;
                win = true;
                System.out.println("O wins");
            }
        }
        if(!controll) {

            for (int i = 0; i < 8; i++) {
                String[] both = threeNodes[i][0].split("");
                String[] both1 = threeNodes[i][1].split("");
                String[] both2 = threeNodes[i][2].split("");
                int first = Integer.parseInt(both[0]);
                int second = Integer.parseInt(both[1]);
                int first1 = parseInt(both1[0]);
                int second1 = parseInt(both1[1]);
                int first2 = parseInt(both2[0]);
                int second2 = parseInt(both2[1]);
                if (ticta[first][second].equals("X") && ticta[first1][second1].equals("X") && ticta[first2][second2].equals("X")) {
                    win = true;
                    System.out.println("X wins");
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ticta[i][j].equals("X")) {
                    cX++;
                } else if (ticta[i][j].equals("O")) {
                    cO++;
                } else if (ticta[i][j].equals(" ")) {
                    p++;
                }
            }
        }
        if (cX >= 3 && cO >= 3 && p == 0) {
            win = true;
            System.out.println("Draw");
        }
        return win;
    }
    static int[] errors(String number) {
        int cordinates1;
        int cordinates2;
        //   String number = sc.nextLine();
        int[] coordi = new int[2];
        //int[] codi = new int[2];
        String[] num = number.split(" ");
        try  {
            cordinates1 = parseInt(num[1]);
            cordinates2 = parseInt(num[0]);
            coordi[0] = cordinates1;
            coordi[1] = cordinates2;
        }catch(NumberFormatException e) {


            return new int[]{0 ,0};
        }

        return  coordi;
    }

    public int[] rowColunm() {
        System.out.print("Enter the coordinates: ");
        int[] columnRow = errors(sc.nextLine());
        while (columnRow[0] == 0 || columnRow[1] == 0) {
            System.out.println("You should enter numbers! ");
            System.out.print("Enter the coordinates: ");
            columnRow = errors(sc.nextLine());
        }

        while (columnRow[0] > 3 || columnRow[1] > 3) {

            System.out.println("Coordinates should be from 1 to 3!");
            System.out.print("Enter the coordinates: ");
            columnRow = errors(sc.nextLine());


        }
        return columnRow;
    }

    public int[] inputIJ() {
        int[] ij;
        ij = rowColunm();
        int column = Math.abs(ij[1] - 1);
        int row = Math.abs(ij[0] - 3);

        while (!Objects.equals(ticta[row][column], " ")) {
            System.out.println("This cell is occupied! Choose another one!");

            //rowColunm();
            ij = rowColunm();
            row = Math.abs(ij[0] - 3);
            column = Math.abs(ij[1] - 1);
        }
        return new int[]{row, column};
    }
    public static int[] autoIJ() {
        Random random = new Random(9);
        int i = random.nextInt(3);
        int j = random.nextInt(3);
        while (!Objects.equals(ticta[i][j], " ")) {

            i = random.nextInt(3);
            j = random.nextInt(3);
            //System.out.println(i + " " + j);
        }
        int[] cell = new int[2];
        cell[0] = i;
        cell[1] = j;
        return cell;
    }

    public static boolean  start(boolean start) {
        System.out.print("Input command: ");
        input = sc.nextLine();
        
        if (!(input.equals("start hard user") || input.equals("start user hard") || input.equals("start hard hard") || input.equals("start hard medium") || input.equals("start medium hard") || input.equals("start hard easy") || input.equals("start easy hard") || input.equals("start easy medium")  || input.equals("start medium easy") || input.equals("start medium medium")  || input.equals("start user medium") || input.equals("start medium user")  || input.equals("start easy easy") || input.equals("start user easy") || input.equals("start easy user") || input.contains("start user user") || input.contains("exit"))) {
            start = false;
        }
        while (!start && !(input.equals("start hard user") || input.equals("start user hard") || input.equals("start hard hard") || input.equals("start hard medium") || input.equals("start medium hard") || input.equals("start hard easy") || input.equals("start easy hard") || input.equals("start easy medium")  || input.equals("start medium easy") || input.equals("start medium medium")  || input.equals("start user medium") || input.equals("start medium user")  || input.equals("start easy easy") || input.equals("start easy user")  || input.equals("start user easy") || input.contains("start user user") || input.contains("exit"))) {
            System.out.println("Bad parameters!");
            System.out.print("Input command: ");
            input = sc.nextLine();
        }
        start = true;
        return start;
    }
   public static int[] mediumMachineWin() {

       int firs = 4;
       int secon = 4;
       boolean controll = false;

            for (int i = 0; i < 8; i++) {
                String[] both = threeNodes[i][0].split("");
                String[] both1 = threeNodes[i][1].split("");
                String[] both2 = threeNodes[i][2].split("");
                int first = Integer.parseInt(both[0]);
                int second = Integer.parseInt(both[1]);
                int first1 = parseInt(both1[0]);
                int second1 = parseInt(both1[1]);
                int first2 = parseInt(both2[0]);
                int second2 = parseInt(both2[1]);
                if (ticta[first][second].equals(" ") && ticta[first1][second1].equals("O") && ticta[first2][second2].equals("O")) {
                    firs = first;
                    secon = second;
                    controll = true;
                } else if (ticta[first][second].equals("O") && ticta[first1][second1].equals(" ") && ticta[first2][second2].equals("O")) {
                    firs = first1;
                    secon = second1;
                    controll = true;
                } else if (ticta[first][second].equals("O") && ticta[first1][second1].equals("O") && ticta[first2][second2].equals(" ")) {
                    firs = first2;
                    secon = second2;
                    controll = true;
                }
            }
        if(!controll) {

            for (int i = 0; i < 8; i++) {
                String[] both = threeNodes[i][0].split("");
                String[] both1 = threeNodes[i][1].split("");
                String[] both2 = threeNodes[i][2].split("");
                int first = Integer.parseInt(both[0]);
                int second = Integer.parseInt(both[1]);
                int first1 = parseInt(both1[0]);
                int second1 = parseInt(both1[1]);
                int first2 = parseInt(both2[0]);
                int second2 = parseInt(both2[1]);
                if (ticta[first][second].equals(" ") && ticta[first1][second1].equals("X") && ticta[first2][second2].equals("X")) {
                    firs = first;
                    secon = second;

                } else if (ticta[first][second].equals("X") && ticta[first1][second1].equals(" ") && ticta[first2][second2].equals("X")) {
                    firs = first1;
                    secon = second1;

                } else if (ticta[first][second].equals("X") && ticta[first1][second1].equals("X") && ticta[first2][second2].equals(" ")) {
                    firs = first2;
                    secon = second2;

                }
            }
        }
       if(firs == 4 && secon == 4) {

          int[] cell1 = autoIJ();
          firs = cell1[0];
          secon = cell1[1];
       }
       return new int[]{firs, secon};
   }
   static void newHard() {
       Hard h = new Hard();
       List<String> list = new ArrayList<String>(9);
               //Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8");
       System.out.println(list);
       for (int i = 0; i <9; i++) {

                   //if (ticta[i][j].equals("x") || ticta[i][j].equals("O"))
                   list.add(listTicta.get(i));

           }
        for (int i = 0; i < 9; i++) {

            h.boardMain[i] = list.get(i);
        }
       System.out.println(Arrays.toString(h.boardMain));
   }
    public static void main(String[] args) {
        int newi;
        int newj;
        boolean not = false;
        boolean start = false;
        String ch = "X";
        Main m = new Main();
        int[] cell;
        int[] cell1;
        Random random = new Random(9);


        boolean go = start(start);
        //System.out.println(go);
        while (go){
            switch (input) {
                case "start user hard":
                case "start hard user":
                case "start user medium":
                case "start medium user":
                    matrix(" ", 0, 0);

                    cell = m.inputIJ();
                    outer:

                    while (Objects.equals(ticta[cell[0]][cell[1]], " ") && !win()) {
                        matrix(ch, cell[0], cell[1]);
                        newHard();
                        ch = "O";
                        if (win()) {
                            break outer;
                        }
                        if (ch == "O") {

                            int[] first = mediumMachineWin();
                            int first1 = first[0];
                            int second = first[1];
                           while (!Objects.equals(ticta[first1][second], " ")) {
                                first = mediumMachineWin();
                                first1 = first[0];
                                second = first[1];
                            }

                            System.out.println("Making move level \"medium\"");
                            matrix(ch, first1, second);
                            newHard();
                            ch = "X";
                        }
                        if (win()) {
                            break outer;

                        } else {

                            cell = m.inputIJ();
                        }
                    }
                    start = false;
                    start(start);
                    break;

                case "start user easy":
                case "start easy user":
                    matrix(" ", 0, 0);

                    cell = m.inputIJ();
                    outer:

                    while (Objects.equals(ticta[cell[0]][cell[1]], " ") && !win()) {
                        matrix(ch, cell[0], cell[1]);
                        ch = "O";
                        if (win()) {
                            break outer;
                        }
                        if (ch == "O") {
                            int i = random.nextInt(3);
                            int j = random.nextInt(3);
                            while (!Objects.equals(ticta[i][j], " ")) {
                                i = random.nextInt(3);
                                j = random.nextInt(3);
                                //System.out.println(i + " " + j);
                            }
                            System.out.println("Making move level \"easy\"");
                            matrix(ch, i, j);
                            ch = "X";
                        }
                        if (win()) {
                            break outer;

                        } else {
                            cell = m.inputIJ();
                        }
                    }
                    start = false;
                    start(start);
                    break;
                case "start hard hard":
                case "start hard medium":
                case "start medium hard":
                case "start hard easy":
                case "start easy hard":
                case "start medium easy":
                case "start easy medium":

                    matrix(" ", 0, 0);

                    cell1 = mediumMachineWin();
                    outer:

                    while (Objects.equals(ticta[cell1[0]][cell1[1]], " ") && !win()) {

                        System.out.println("Making move level \"medium\"");
                        matrix(ch, cell1[0], cell1[1]);
                        ch = "O";
                        if (win()) {
                            break outer;
                        }
                        if (ch == "O") {
                            int i = random.nextInt(3);
                            int j = random.nextInt(3);
                            while (!Objects.equals(ticta[i][j], " ")) {
                                i = random.nextInt(3);
                                j = random.nextInt(3);
                                //System.out.println(i + " " + j);
                            }
                            System.out.println("Making move level \"easy\"");
                            matrix(ch, i, j);
                            ch = "X";
                        }
                        if (win()) {
                            break outer;

                        }

                        cell1 = mediumMachineWin();
                    }
                    start = false;
                    start(start);

                    break;
                case "start medium medium":

                    matrix(" ", 0, 0);

                    cell1 = mediumMachineWin();
                    outer:

                    while (Objects.equals(ticta[cell1[0]][cell1[1]], " ") && !win()) {

                        System.out.println("Making move level \"medium\"");
                        matrix(ch, cell1[0], cell1[1]);

                        ch = "O";
                        if (win()) {
                            break outer;
                        }
                        if (ch == "O") {
                            int[] first = mediumMachineWin();
                            int first1 = first[0];
                            int second = first[1];
                            while (!Objects.equals(ticta[first1][second], " ")) {
                                first = mediumMachineWin();
                                first1 = first[0];
                                second = first[1];
                            }
                            System.out.println("Making move level \"medium\"");
                            matrix(ch, first1, second);
                            ch = "X";
                        }
                        if (win()) {
                            break outer;

                        } else {

                            cell1 = mediumMachineWin();
                        }
                    }
                    start = false;
                    start(start);
                    break;

                case "start easy easy":
                    matrix(" ", 0, 0);

                    cell1 = autoIJ();
                    outer:

                    while (Objects.equals(ticta[cell1[0]][cell1[1]], " ") && !win()) {

                        System.out.println("Making move level \"easy\"");
                        matrix(ch, cell1[0], cell1[1]);

                        ch = "O";
                        if (win()) {
                            break outer;
                        }
                        if (ch == "O") {
                            int i = random.nextInt(3);
                            int j = random.nextInt(3);
                            while (!Objects.equals(ticta[i][j], " ")) {
                                i = random.nextInt(3);
                                j = random.nextInt(3);
                                //System.out.println(i + " " + j);
                            }
                            System.out.println("Making move level \"easy\"");
                            matrix(ch, i, j);
                            ch = "X";
                        }
                        if (win()) {
                            break outer;

                        }

                        cell1 = autoIJ();
                    }
                    start = false;
                    start(start);

                    break;

                case "start user user":
                    matrix(" ", 0, 0);

                    cell = m.inputIJ();

                    outer:

                    while (Objects.equals(ticta[cell[0]][cell[1]], " ") && !win()) {
                        matrix(ch, cell[0], cell[1]);

                        ch = "O";
                        if (win()) {
                            break outer;
                        } else {
                            cell = m.inputIJ();
                        }
                        if (ch == "O") {
                            matrix(ch, cell[0], cell[1]);
                            ch = "X";
                        }
                        if (win()) {
                            break outer;
                        } else {

                            cell = m.inputIJ();
                        }
                    }
                    start = false;
                    start(start);

                    break;

                case "exit":
                    go = false;
                    break;
            }
        }

    }
}
