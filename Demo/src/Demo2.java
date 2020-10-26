import java.io.File;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author Kiran Kumar
 * 
 *         input: D:\sampleFolder 
 *         OutPut: 
 *         January-1 
 *         February-0 
 *         March-2 
 *         April-0
 *         May-0 
 *         June-0 
 *         July-3 
 *         August-0 
 *         September-0 
 *         October-8 
 *         November-0
 *         December-0
 *
 */
public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Provide the folder path");
		try (Scanner sc = new Scanner(System.in);) {
			File fileObj = new File(sc.nextLine());
			// checking if the path is valid or not
			if (fileObj.exists() && fileObj.isDirectory()) {
				// fetching all the months to hashMap
				Map<String, Integer> result = fetchMonths();
				// List of all files and directories
				File filesList[] = fileObj.listFiles();
				for (File file : filesList) {
					// filtering only files
					if (file.isFile()) {
						Date date = new Date(file.lastModified());
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						String month = new SimpleDateFormat("MMMM").format(cal.getTime());
						int value = result.get(month);
						result.replace(month, ++value);

					}
				}
				for (Map.Entry<String, Integer> res : result.entrySet()) {
					System.out.println(res.getKey() + "-" + res.getValue());
				}
			} else {
				System.out.println("Path does not exist or Path is not a directory/Invalid");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static Map<String, Integer> fetchMonths() {
		List<String> monthsList = new ArrayList<>();
		String[] months = new DateFormatSymbols().getMonths();
		for (int i = 0; i < months.length; i++) {
			if (months[i] != "")
				monthsList.add(months[i]);
		}
		Map<String, Integer> result = new LinkedHashMap<>();
		for (String month : monthsList) {
			result.put(month, 0);
		}
		return result;
	}

}
