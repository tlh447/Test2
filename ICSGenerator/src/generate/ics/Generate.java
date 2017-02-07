package generate.ics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Generate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "Test";
		String version =    "VERSION:2.0\r\n";
		String prodid =     "PRODID:-//Elara/lofy/tanare/delp/314sum2015\r\n";
		String calBegin =   "BEGIN:VCALENDAR\r\n";
		String calEnd =     "END:VCALENDAR";
		String eventBegin = "BEGIN:VEVENT\r\n";
		String eventEnd =   "END:VEVENT\r\n";
		
		StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(".ics");

        String testExample = "UID:uid1@example.com\r\n" +
        		"DTSTAMP:19970714T170000Z\r\n" +
        		"ORGANIZER;CN=John Doe:MAILTO:john.doe@example.com\r\n" +
        		"DTSTART:19970714T170000Z\r\n" +
        		"DTEND:19970715T035959Z\r\n" +
        		"SUMMARY:Bastille Day Party\r\n";

        try {


            File file = new File(builder.toString());

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(calBegin);
            bw.write(version);
            bw.write(prodid);
            bw.write(eventBegin);
            bw.write(testExample);
            bw.write(eventEnd);
            bw.write(calEnd);

            System.out.println("STuff");
            bw.close();


            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	}

