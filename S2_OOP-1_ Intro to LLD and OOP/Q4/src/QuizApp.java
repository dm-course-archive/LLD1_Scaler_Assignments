import util.MarkdownGenerator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class QuizApp {

    public static void main(String[] args) {
        MarkdownGenerator.main(new String[]{});
        Properties properties = new Properties();

        try {
            // Load the properties file
            properties.load(new FileInputStream("quiz.properties"));

            // Read question, options, correct answer, and explanation
            String question = properties.getProperty("question");
            String[] options = properties.getProperty("options").split("\\|"); // Split options using '|'
            int correctOption = Integer.parseInt(properties.getProperty("correctOption"));
            String explanation = properties.getProperty("explanation").replace("\\n", "\n"); // Replace \n with actual newlines

            // Run the quiz
            runQuiz(question, options, correctOption, explanation);

        } catch (IOException e) {
            System.out.println("Failed to load quiz properties file: " + e.getMessage());
        }
    }

    /**
     * Runs the quiz with the given question, options, correct answer, and explanation.
     *
     * @param question      The quiz question
     * @param options       Array of options
     * @param correctOption The index of the correct option (1-based)
     * @param explanation   Explanation for the correct answer
     */
    public static void runQuiz(String question, String[] options, int correctOption, String explanation) {
        Scanner scanner = new Scanner(System.in);

        // Display the question and options
        System.out.println("Question:");
        System.out.println(question);
        System.out.println("Options:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        // Get the user's choice
        System.out.print("Enter your choice (1/" + options.length + "): ");
        int choice = scanner.nextInt();

        // Check the answer and display the result
        if (choice == correctOption) {
            System.out.println("Correct! " + options[correctOption - 1]);
            System.out.println(explanation);
        } else {
            System.out.println("Incorrect.");
            System.out.println("The correct answer is: " + correctOption + ". " + options[correctOption - 1]);
            System.out.println(explanation);
        }

        scanner.close();
    }
}
