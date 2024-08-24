import java.util.*;

class QuizQuestion {
    private String question;
    private String[] options;
    private char correctAnswer;

    public QuizQuestion(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    private Map<QuizQuestion, Boolean> results;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
        this.results = new HashMap<>();
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion q : questions) {
            displayQuestion(q);
            long startTime = System.currentTimeMillis();
            boolean answered = false;

            while ((System.currentTimeMillis() - startTime) < 15000 && !answered) { // 15 seconds timer
                System.out.print("Your answer (A/B/C/D): ");
                char answer = scanner.next().toUpperCase().charAt(0);
                
                if (answer >= 'A' && answer <= 'D') {
                    answered = true;
                    if (answer == q.getCorrectAnswer()) {
                        System.out.println("Correct!\n");
                        score++;
                        results.put(q, true);
                    } else {
                        System.out.println("Incorrect! The correct answer was " + q.getCorrectAnswer() + ".\n");
                        results.put(q, false);
                    }
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D.");
                }
            }

            if (!answered) {
                System.out.println("\nTime's up! The correct answer was " + q.getCorrectAnswer() + ".\n");
                results.put(q, false);
            }
        }

        displayResults();
        scanner.close();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ". " + options[i]);
        }
    }

    private void displayResults() {
        System.out.println("\nQuiz Completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());

        System.out.println("\nSummary:");
        for (QuizQuestion q : questions) {
            System.out.println(q.getQuestion());
            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((char) ('A' + i) + ". " + options[i]);
            }
            boolean wasCorrect = results.get(q);
            System.out.println("Your answer was " + (wasCorrect ? "correct" : "incorrect") + ".\n");
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        List<QuizQuestion> questions = new ArrayList<>();

      questions.add(new QuizQuestion(
        "Which is the smallest prime number?",
        new String[]{"1", "2", "3", "5"},
        'B'
));

questions.add(new QuizQuestion(
        "Which element has the chemical symbol 'O'?",
        new String[]{"Oxygen", "Gold", "Osmium", "Ozone"},
        'A'
));

questions.add(new QuizQuestion(
        "Who is the author of 'The Lord of the Rings'?",
        new String[]{"J.K. Rowling", "J.R.R. Tolkien", "George R.R. Martin", "C.S. Lewis"},
        'B'
));

questions.add(new QuizQuestion(
        "Which country is known as the Land of the Rising Sun?",
        new String[]{"China", "South Korea", "Japan", "Thailand"},
        'C'
));


        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
