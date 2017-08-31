import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by Rohit on 8/4/2017.
 */
public class KnightWalk {

    public static void main(String[] args) {
        int N=8;
        ChessBoard chessboard = new ChessBoard(N);

        double probability  = chessboard.knightsProbability(0, 0, 2);
        System.out.println("probability = " + probability);

        probability  = chessboard.knightsProbability(3, 3, 1);
        System.out.println("probability = " + probability);

        probability  = chessboard.knightsProbability(1, 2, 10);
        System.out.println("probability = " + probability);

        probability  = chessboard.knightsProbability(3, 2, 50);
        System.out.println("probability = " + probability);

    }

    static class ChessBoard {
        private int N;
        double[][][] memo;

        public ChessBoard(int n) {
            this.N = n;
            memo = new double [N][N][51];
            intitMemo();
        }

        private void intitMemo() {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    memo[i][j][0]=1;
                }

            }
        }

        int[] xd = {1, 2, 2, 1,-1,-2,-2,-1 };

        int[] yd = {2, 1,-1,-2,-2,-1, 1, 2 };


        public double knightsProbability(int x, int y, int steps){
            if(isOutside(x,y)){
                return 0;
            }
            if(steps == 0){
                return 1;
            }
            if(memo[x][y][steps] !=0){
                return memo[x][y][steps];
            }

            double probability = 0;
            for(BoardLocation location : getAllPossibleInsideLocations(new BoardLocation(x,y))){
                probability+=knightsProbability(location.x,location.y,steps-1)/8;
            }
            memo[x][y][steps] = probability;
            return probability;
        }

        private List<BoardLocation> getAllPossibleInsideLocations(BoardLocation currLocation) {
            List<BoardLocation> possibleLocations = IntStream.rangeClosed(0, N-1)
                    .filter(i -> !isOutside(currLocation.x + xd[i], currLocation.y + yd[i]))
                    .mapToObj(i -> new BoardLocation(currLocation.x + xd[i], currLocation.y + yd[i]))
                    .collect(toList());
            return possibleLocations;
        }

        private boolean isOutside(int x, int y) {
            return x>7 || x<0 || y >7 || y<0;
        }

        private class BoardLocation {
            private final int x;
            private final int y;

            public BoardLocation(int x, int y) {

                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }
        }
    }
}
