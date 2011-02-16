package CIAPI.Java.examples.urlshortener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import CIAPI.Java.ApiException;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.async.AsyncApiCall;
import CIAPI.Java.async.AsyncJsonApi;
import CIAPI.Java.async.CallBack;
import CIAPI.Java.throttle.ThrottledHttpClient;

/**
 * Tiny program designed to showcase the Async Api
 * 
 * @author Justin Nelson
 * 
 */
public class UrlShortenerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField longUrlField;
	private JTextField shortenedUrl;
	private JButton submitButton;
	private JPanel south;

	/**
	 * Creates and builds a new UrlShortenerFrame
	 */
	public UrlShortenerFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createComponents();
		layoutComponents();
		addActions();
		pack();
	}

	private void createComponents() {
		longUrlField = new JTextField(20);
		shortenedUrl = new JTextField(20);
		submitButton = new JButton("Shorten!");
		south = new JPanel();
		south.setVisible(false);
	}

	private void layoutComponents() {
		JPanel mainPane = new JPanel(new BorderLayout());
		JPanel north = new JPanel();
		north.add(longUrlField);
		north.add(submitButton);
		north.add(shortenedUrl);
		JProgressBar progress = new JProgressBar();
		progress.setIndeterminate(true);
		south.add(progress);
		mainPane.add(north, BorderLayout.NORTH);
		mainPane.add(south, BorderLayout.SOUTH);
		add(mainPane);
	}

	private void addActions() {
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AsyncJsonApi api = new AsyncJsonApi("https://www.googleapis.com/urlshortener/v1/url",
						new DefaultJsonClient(new ThrottledHttpClient()));
				AsyncApiCall call = api.createNewCall("");
				call.addCallCompleteListener(new CallBack() {
					@Override
					public void doCallBack(Object result) {
						GooglePostResponse resp = (GooglePostResponse) result;
						shortenedUrl.setText(resp.getId());
						south.setVisible(false);
						UrlShortenerFrame.this.pack();
					}

					@Override
					public void handleException(Exception e) {
						shortenedUrl.setText("Error shortening url.");
						south.setVisible(false);
						UrlShortenerFrame.this.pack();
					}
				});
				Map<String, String> key = new HashMap<String, String>();
				key.put("key", "AIzaSyCYMdrcIDWDf6YFFzyFjA2HCEbfazSkf_M");
				south.setVisible(true);
				UrlShortenerFrame.this.pack();
				call.beginCallPostMethod(key, new GooglePostRequest(longUrlField.getText()),
						GooglePostResponse.class);
			}
		});
	}

	/**
	 * Main entry point for the app. Simply creates and shows a new window
	 * 
	 * @param args
	 * @throws ApiException
	 */
	public static void main(String[] args) throws ApiException {
		new UrlShortenerFrame().setVisible(true);
	}
}
