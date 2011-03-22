package beginner;

import static com.sandwich.koan.KoanConstants.__;
import static com.sandwich.util.Assert.assertEquals;
import static com.sandwich.util.Assert.assertNotNull;
import static com.sandwich.util.Assert.fail;

import CIAPI.Java.ApiException;
import CIAPI.Java.examples.ciapi.SyncApi;
import com.sandwich.koan.Koan;

public class AboutSession {

    private static final String USERNAME = "DM078963";
    private static final String PASSWORD = "password";

    @Koan()
	public void anApiConnection() throws ApiException {
        //

        SyncApi api = new SyncApi(null, null);

        assertNotNull(api);
    }

    @Koan()
	public void CreatingASession() throws ApiException {

        SyncApi api = new SyncApi(USERNAME, PASSWORD);

//        try
//        {
//            _rpcClient.LogIn(USERNAME, PASSWORD);
//        }
//        catch (ApiException apiException)
//        {
//            KoanAssert.Fail(string.Format("cannot login because {0}", apiException.Message));
//        }
//
//        KoanAssert.That(_rpcClient.SessionId != "", "after logging in, you should have a valid session");
        fail("how do you create a session?");
    }

}
