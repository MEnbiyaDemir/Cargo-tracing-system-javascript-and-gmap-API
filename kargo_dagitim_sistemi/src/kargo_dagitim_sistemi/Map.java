package kargo_dagitim_sistemi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.RoadsApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.kingaspx.util.BrowserUtil;
import com.kingaspx.version.Version;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.ConsoleEvent;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class Map extends JFrame{
	JFrame frame;
	Browser browser;
	BrowserView view;
	public Map() {
		super();
		
		setSize(700,700);
		setLocation(600, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		
		
		/* GeoApiContext context = new GeoApiContext.Builder()
			    .apiKey("AIzaSyCOZsDWen6nyguy5doqhmA9QDgnpCVttVM")
			    .build();
			GeocodingResult[] results = null;
			try {
				results = GeocodingApi.geocode(context, "1600 Amphitheatre Parkway Mountain View, CA 94043").await();
			} catch (ApiException | InterruptedException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			System.out.println(gson.toJson(results[0].addressComponents));
			
			
			*/
		
		
		open_site();
	}
	
	void open_site() {
		
	
		BrowserUtil.setVersion(Version.V6_22);
	
		browser = new Browser();
		view = new BrowserView(browser);
		
		add(view,BorderLayout.CENTER);
		
		browser.addTitleListener((TitleEvent e) -> {
			setTitle(e.getTitle());
			
		});
		
		browser.addConsoleListener((ConsoleEvent e) -> {
			System.out.println("LOG: " + e.getMessage());
			
		});
		
		browser.addLoadListener(new LoadAdapter()  {
			@Override
			public void onFinishLoadingFrame(FinishLoadingEvent e) {
				e.getBrowser().setZoomLevel(-1); // -2 idi.
			}
		});
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
        
	browser.loadURL(currentWorkingDir.normalize().toString()+"\\sample.html");
	
	}
	
	
	
	
}
