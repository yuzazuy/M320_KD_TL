package Ch;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Reads a CSV file with the lines "CODE,Airport name" and puts them into an {@link AirportMap}.
 */
public class AirportFileReader {

    /**
     * Reads the file line by line, parses each line and puts it into the map.
     * Wrong lines are skipped with a message, duplicate codes replace the old name.
     *
     * @param fileName path of the CSV file
     * @param map      the map the airports are put into
     * @throws IOException if the file cannot be read
     */
    public static void readFile(String fileName, AirportMap map) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);

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
            if (oldName != null) {
                System.out.println("Line " + lineNumber + ": " + code + " already exists, \""
                        + oldName + "\" replaced by \"" + name + "\"");
            }
        }
    }
}
