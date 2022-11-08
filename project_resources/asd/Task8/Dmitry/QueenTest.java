package org.viable;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QueenTest {

    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = new PrintStream(System.out);

    public static void main(String[] args) {
        Chessboard chessboard = new Chessboard() {
        };
        QueenInteractor interactor = new QueenInteractor(chessboard);
        interactor.calculate(new int[chessboard.getN()], 0);
        System.out.println(interactor.getSolutions());
    }
}

abstract class Chessboard {
    private final int n = 8;

    public int getN() {
        return n;
    }
}

class QueenInteractor {
    private Chessboard chessboard;
    private int n = 0;
    private List<List<Integer>> solutions = new ArrayList<>(n);

    public QueenInteractor(Chessboard chessboard) {
        this.chessboard = chessboard;
        this.n = chessboard.getN();
    }

    public List<List<Integer>> getSolutions() {
        return solutions;
    }

    public int calculate(int[] board, int subsize) {

        if (subsize == n) {
            solutions.add(Arrays.stream(board).boxed().collect(Collectors.toList()));
            return 0;
        }

        IntStream
                .range(0, n)
                .forEach(i -> {
                    board[subsize] = i;
                    var u = placeQueen(board, subsize) ? calculate(board, subsize + 1) : 1;
                });
        return 0;
    }

    // Stepwise Refinement approach
    private boolean placeQueen(int[] board, int n) {
        return IntStream
                .range(0, n)
                .map(i -> {
                    if (board[i] == board[n]) {
                        return 1;
                    }
                    if ((board[i] - board[n]) == (n - i)) {
                        return 1;
                    }
                    if ((board[n] - board[i]) == (n - i)) {
                        return 1;
                    }
                    return 0;
                })
                .sum() == 0;
    }

}





