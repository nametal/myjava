package text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CSVReader {
	private static final String delim = ",";
	public static void main(String[] args) {
		String csvFilename = "customers.csv";
		Map<String, String[]> header = readCSV(csvFilename, true);
		Map<String, String[]> rows = readCSV(csvFilename, false);
		
		printMap(header);
		printMap(rows);
		
		writeCSV(header, rows, "merged.csv");
	}
	
	/**
	 * Get a CSV file content to a map
	 * @param csvFilename URL of CSV file
	 * @param isHeader read header if <code>true</code>, otherwise read rows
	 * @return map filled with content
	 */
	private static Map<String, String[]> readCSV(String csvFilename, boolean isHeader) {
		BufferedReader br = null;
		String line = "";
		Map<String, String[]> row = null;
		try {
			br = new BufferedReader(new FileReader(csvFilename));
			if(isHeader) {
				row = new HashMap<String, String[]>();
				if ( (line = br.readLine()) != null ) { // read header
					String[] cols = line.split(delim);
					String[] next = new String[3];
					next[0] = cols[1].trim();
					next[1] = cols[2].trim();
					next[2] = cols[3].trim();
					row.put(cols[0].trim(), next);
				}
			} else {
				row = new TreeMap<String, String[]>(); // TreeMap automatically sort keys
				br.readLine(); // skip first row
				while ( (line = br.readLine()) != null ) { // read data
					String[] cols = line.split(delim);
					
					String[] data = row.get(cols[0].trim()); // name as key
					
					if (data == null) {
						data = new String[3];
					}
					if (!cols[1].trim().isEmpty()) { // email
						data[0] = cols[1].trim().toLowerCase();
					}
					if (cols.length > 2 && !cols[2].trim().isEmpty()) { // facebook
						data[1] = cols[2].trim();
					}
					if (cols.length > 3 && !cols[3].trim().isEmpty()) { // twitter
						data[2] = cols[3].trim();
					}
					row.put(cols[0].trim(), data);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return row;
	}
	
	/**
	 * write map content to a CSV file
	 * @param map map to read
	 * @param outputFilename CSV file to write
	 * @param append append to <code>outputFilename</code> if <code>true</code>, otherwise overwrite
	 */
	private static void writeCSV(Map<String, String[]> map, String outputFilename, boolean append) {
		try {
			FileWriter fw = new FileWriter(outputFilename, append);
			for (String key : map.keySet()) {
				fw.append(key);
				String[] isi = map.get(key);
				for (int i = 0; i < isi.length; i++) {
					fw.append(delim);
					fw.append(isi[i]==null ? "" : isi[i]);
				}
				fw.append('\n');
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * write header+rows to a CSV file
	 * @param header header map
	 * @param rows rows map
	 * @param outputFilename CSV file to write
	 */
	private static void writeCSV(Map<String, String[]> header, Map<String, String[]> rows, String outputFilename) {
		writeCSV(header, outputFilename, false);
		writeCSV(rows, outputFilename, true);
	}
	
	/**
	 * prints content of a map to screen
	 * @param map map to print
	 */
	private static void printMap(Map<String, String[]> map) {
		for (String key : map.keySet()) {
			System.out.println(key);
			String[] isi = map.get(key);
			for (int i = 0; i < isi.length; i++) {
				System.out.println("> " + isi[i]);
			}
		}
	}
}
