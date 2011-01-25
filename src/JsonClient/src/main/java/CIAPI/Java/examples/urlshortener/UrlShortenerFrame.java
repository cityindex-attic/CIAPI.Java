package CIAPI.Java.examples.urlshortener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import CIAPI.Java.ApiException;
import CIAPI.Java.AsyncJsonApi;
import CIAPI.Java.DefaultJsonClient;
import CIAPI.Java.async.CallBack;

public class UrlShortenerFrame extends JFrame {

	private JTextField longUrlField;
	private JTextField shortenedUrl;
	private JButton submitButton;

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
	}

	private void layoutComponents() {
		JPanel mainPane = new JPanel();
		mainPane.add(longUrlField);
		mainPane.add(submitButton);
		mainPane.add(shortenedUrl);
		add(mainPane);
	}

	private void addActions() {
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AsyncJsonApi api = new AsyncJsonApi("https://www.googleapis.com/urlshortener/v1/url",
						new DefaultJsonClient());
				try {
					Map<String, String> key = new HashMap<String, String>();
					key.put("key", "AIzaSyCYMdrcIDWDf6YFFzyFjA2HCEbfazSkf_M");
					Future<Object> future = api.beginCallPostMethod("", key,
							new GooglePostRequest(longUrlField.getText()), GoogleResponse.class, new CallBack() {
								@Override
								public void doCallBack(Object result) {
									GoogleResponse resp = (GoogleResponse) result;
									shortenedUrl.setText(resp.getId());
								}
							});
					future.isCancelled();
				} catch (ApiException e1) {
					shortenedUrl.setText("Error");
				}
			}
		});
	}

	public static void main(String[] args) throws ApiException {
		new UrlShortenerFrame().setVisible(true);
	}
}
