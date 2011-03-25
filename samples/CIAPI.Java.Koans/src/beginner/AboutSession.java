package beginner;

import static com.sandwich.koan.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;
import static com.sandwich.util.Assert.assertNotNull;
import static com.sandwich.util.Assert.fail;
import static com.sandwich.util.Assert.assertTrue;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import CIAPI.Java.examples.ciapi.SyncApiFActory;

import com.sandwich.koan.Koan;
import com.sandwich.util.Assert;

public class AboutSession {

    private static final String USERNAME = "DM078963";
    private static final String PASSWORD = "password";

    @Koan()
	public void anApiConnection() throws ApiException {

        SyncApi api = new SyncApiFActory().getApi();

        assertNotNull(api);
    }

    @Koan()
	public void CreatingASession() throws ApiException {

        SyncApi api = new SyncApiFActory().getApi();

        try
        {
			// the 'true' tells the api to renew the session token automatically if it expires
            api.logIn(USERNAME, PASSWORD, true);
        }
        catch (ApiException apiException)
        {
            Assert.fail(String.format("cannot login because %s", apiException.getMessage()));
        }

        // KoanAssert.That(api.getSessionId() !=null && !api.getSessionId().equals(""), "after logging in, you should have a valid session");
        // Not exactly sure how to use the Koans API, but you get the idea.
        assertTrue(api.getSessionId() !=null && !api.getSessionId().equals(""));
    }
}
