package JavaOOP.Projects;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyChart extends Application {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public void start(Stage stage) throws IOException {
        String filePath = getFilePath(); // Get file path (modify for user input if needed)
        Map<Character, Integer> frequencies = countLetterFrequencies(filePath);

        stage.setTitle("Letter Frequencies");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
        xAxis.setLabel("Letter");
        yAxis.setLabel("Frequency");

        XYChart.Series series = new XYChart.Series();
        series.setName("Letter Frequencies");
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            series.getData().add(new XYChart.Data<>(String.valueOf(entry.getKey()), entry.getValue()));
        }

        bc.getData().addAll(series);
        stage.setScene(new Scene(bc, 800, 600));
        stage.show();
    }

    private String getFilePath() {
        // Modify this to get the file path from user input (e.g., using Scanner)
        // Replace with your actual file path
        return "/path/to/your/text.txt";
    }

    private Map<Character, Integer> countLetterFrequencies(String filePath) throws IOException {
        Map<Character, Integer> frequencies = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char character : line.toLowerCase().toCharArray()) {
                    if (ALPHABET.indexOf(character) != -1) {
                        frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
                    }
                }
            }
        }
        return frequencies;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
