import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Question {
    protected String text;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String text, String correctAnswer, String studentAnswer, double points) {
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double calculateScore();
    public abstract String getType();
}

class ExactMatchQuestion extends Question {
    private String type;
    public ExactMatchQuestion(String type, String text, String correct, String student, double points) {
        super(text, correct, student, points);
        this.type = type;
    }
    @Override
    public double calculateScore() {
        return studentAnswer.equalsIgnoreCase(correctAnswer) ? points : 0.0;
    }
    @Override
    public String getType() { return type; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }
    @Override
    public double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        int matchCount = 0;
        String studentLower = studentAnswer.toLowerCase();
        
        for (String keyword : keywords) {
            if (studentLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }
        
        if (matchCount >= 2) return points * 0.75;
        if (matchCount == 1) return points * 0.50;
        return 0.0;
    }
    @Override
    public String getType() { return "ESSAY"; }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            // Splitting by quote character to easily extract the string literals
            String[] parts = line.split("\"");
            String type = parts[0].trim();
            String text = parts[1];
            String correct = parts[3];
            String student = parts[5];
            double points = Double.parseDouble(parts[6].trim());

            if (type.equals("MCQ") || type.equals("TF")) {
                questions.add(new ExactMatchQuestion(type, text, correct, student, points));
            } else if (type.equals("ESSAY")) {
                questions.add(new EssayQuestion(text, correct, student, points));
            }
        }

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.calculateScore();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    scanner.close();}
}