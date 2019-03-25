public class RobotReturnToOrigin {

    public static void main(String[] args) {
        String moves = "UDL";
        System.out.println( judgeCircle(moves));;
    }

    private static boolean judgeCircle(String moves) {
        int LR = 0;
        int UD = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                UD++;
            } else if (c == 'D') {
                UD--;
            } else if (c == 'L') {
                LR--;
            } else {
                LR++;
            }
        }
        return UD == 0 && LR == 0;
    }
}
