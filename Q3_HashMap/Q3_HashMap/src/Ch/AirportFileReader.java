package Ch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Reads CSV data with the lines "CODE,Airport name" and puts them into an {@link AirportMap}.
 * The data can come from any file on disk or from the default file that is shipped with the classes.
 */
public class AirportFileReader {

    /**
     * Name of the default CSV file. It lies in the same package as this class, so it is found
     * on the classpath no matter from which folder or on which computer the program starts.
     */
    public static final String DEFAULT_RESOURCE = "airports.csv";

    /**
     * Not used: the class only holds static methods and a constant.
     */
    private AirportFileReader() {
    }

    /**
     * Reads a CSV file from disk and puts its airports into the map.
     *
     * @param fileName path of the CSV file, relative paths start at the working directory
     * @param map      the map the airports are put into
     * @throws IOException if the file cannot be read
     */
    public static void readFile(String fileName, AirportMap map) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
        putLines(lines, map);
    }

    /**
     * Reads the default CSV file {@value #DEFAULT_RESOURCE} from the classpath and puts its
     * airports into the map.
     *
     * @param map the map the airports are put into
     * @throws IOException if the file is missing next to the classes or cannot be read
     */
    public static void readDefault(AirportMap map) throws IOException {
        InputStream stream = AirportFileReader.class.getResourceAsStream(DEFAULT_RESOURCE);
        if (stream == null) {
            throw new FileNotFoundException(DEFAULT_RESOURCE + " is missing next to the compiled classes.");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            putLines(reader.lines().toList(), map);
        }
    }

    /**
     * Parses each line and puts it into the map.
     * Wrong lines are skipped with a message. A duplicate code replaces the old name,
     * and a message is only shown if the name really changes.
     *
     * @param lines all lines of the CSV data, including the header
     * @param map   the map the airports are put into
     */
    private static void putLines(List<String> lines, AirportMap map) {
        // Starts at 1 because line 0 is the header "AIRPORT CODE,AIRPORT"
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            int lineNumber = i + 1;

            if (line.isEmpty()) {
                continue;
            }

            // Split only at the first "," so the airport name may contain commas
            String[] parts = line.split(",", 2);
            if (parts.length < 2) {
                System.out.println("Line " + lineNumber + " skipped (no ','): " + line);
                continue;
            }

            String code = parts[0].trim().toUpperCase();
            String name = parts[1].trim();
            if (code.isEmpty()) {
                System.out.println("Line " + lineNumber + " skipped (no code): " + line);
                continue;
            }

            // put() returns the old name if the code already existed
            String oldName = map.put(code, name);
            if (oldName != null && !oldName.equals(name)) {
                System.out.println("Line " + lineNumber + ": " + code + " already exists, \""
                        + oldName + "\" replaced by \"" + name + "\"");
            }
        }
    }
}
