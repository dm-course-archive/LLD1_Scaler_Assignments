package util;

import java.io.*;
import java.util.Properties;

public class MarkdownGenerator {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            // Load the properties file
            properties.load(new FileInputStream("quiz.properties"));

            // Read the quiz content
            String question = properties.getProperty("question");
            String codeFile = properties.getProperty("codeFile");
            String[] options = properties.getProperty("options").split("\\|");
            int correctOption = Integer.parseInt(properties.getProperty("correctOption"));
            String explanation = properties.getProperty("explanation").replace("\\n", "\n");

            // Read the code snippet from the specified file
            StringBuilder codeSnippet = new StringBuilder();
            if(codeFile!=null && !codeFile.isBlank()){
                try (BufferedReader reader = new BufferedReader(new FileReader(codeFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        codeSnippet.append(line).append("\n");
                    }
                }
            }

            // Generate the markdown content
            StringBuilder markdown = new StringBuilder();
            markdown.append("# Quiz Question\n\n");
            markdown.append("## Question\n");
            markdown.append(question).append("\n\n");
            markdown.append("### Code\n");
            markdown.append(codeSnippet).append("\n\n");
            markdown.append("## Options\n");
            for (int i = 0; i < options.length; i++) {
                markdown.append((i + 1)).append(". ").append(options[i]).append("\n");
            }
            markdown.append("\n");
            markdown.append("<details>\n");
            markdown.append("<summary>See Answer</summary>\n\n");
            markdown.append("### Correct Answer\n");
            markdown.append(correctOption).append(". ").append(options[correctOption - 1]).append("\n\n");
            markdown.append("### Explanation\n");
            markdown.append(explanation).append("\n\n");
            markdown.append("</details>\n");

            // Write the markdown to a file
            FileWriter writer = new FileWriter("QUESTION.md");
            writer.write(markdown.toString());
            writer.close();

            System.out.println("QUESTION.md generated successfully!");

        } catch (IOException e) {
            System.out.println("Failed to generate README.md: " + e.getMessage());
        }
    }
}
