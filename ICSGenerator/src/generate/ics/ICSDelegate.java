package generate.ics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.activiti.engine.FormService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.form.TaskFormData;

public class ICSDelegate implements JavaDelegate {
	 public void execute(DelegateExecution execution) throws Exception {
		 String name = "Test";
			String version =    "VERSION:2.0\r\n";
			String prodid =     "PRODID:-//Elara/lofy/tanare/delp/314sum2015\r\n";
			String calBegin =   "BEGIN:VCALENDAR\r\n";
			String calEnd =     "END:VCALENDAR";
			String eventBegin = "BEGIN:VEVENT\r\n";
			String eventEnd =   "END:VEVENT\r\n";
			String dateStamp = execution.getVariable("timeStamp").toString();
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


	            bw.close();


	            System.out.println("Done");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
