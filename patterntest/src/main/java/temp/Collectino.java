package temp;

import java.util.LinkedList;

public class Collectino {

    public static String rps(String p1, String p2) {
        String scissors = "scissors";
        String paper = "paper";
        String rock = "rock";
        if (p1.equals(scissors) & p2.equals(paper)) {
            return "Player 1 won!";
        }
        if (p1.equals(paper) & p2.equals(scissors)) {
            return "Player 2 won!";
        }
        if (p1.equals(paper) & p2.equals(rock)) {
            return "Player 1 won!";
        }
        if (p1.equals(rock) & p2.equals(paper)) {
            return "Player 2 won!";
        }
        if (p1.equals(rock) & p2.equals(scissors)) {
            return "Player 1 won!";
        }
        if (p1.equals(scissors) & p2.equals(rock)) {
            return "Player 2 won!";
        } else {
            return "Draw!";
        }
    }

    public static String insertDash(int number) {
        Integer current;
        Integer prev;
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (number > 0) {
            stack.push(number % 10);
            number = number / 10;
        }

        prev = stack.pop();
        sb.append(prev);

        while (!stack.isEmpty()) {
            current = stack.pop();
            if ((prev % 2 != 0) && (current % 2 != 0)) {
                sb.append("-");
            }
            sb.append(current);
            prev = current;
        }
        return String.valueOf(sb);

    }

    public static void main(String[] args) {
        System.out.println(insertDash(454793));
        System.out.println(insertDash(1003567));

    }
}
