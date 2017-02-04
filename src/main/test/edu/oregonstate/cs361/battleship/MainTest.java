package edu.oregonstate.cs361.battleship;

import org.junit.jupiter.api.AfterAll;import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.Gson;
import spark.Spark;
import spark.utils.IOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


        import static spark.Spark.awaitInitialization;
/**
 * CREDIT: Some of this code was referenced from Michael Hilton via the url below. Since this was public I decided it was appropriate to adopt some of it
 * Specifically request and Test Request functions since they are imperative to testing server information that we are not familiar with.
 * Junit Jupiter is also not used which is a notable difference.
 * https://github.com/OSU-CS361-W17/project1/blob/master/src/test/edu/oregonstate/cs361/battleship/MainTest.java
 * Created by River Hendriksen on 2/1/17.
 * Edited By:
 */
public class MainTest {

    /**
     * @throws Exception
     * There are two tests on the newmodel to test to see if it works. One being a req.status assert to ensure that the value
     * was 200 (which means it is OK). The other test checks that the new json string is the same as the one provided in the readme
     * at the beginning of the project github.
     */
    @Test
    public void newModel() throws Exception {
        TestResponse res = request("GET", "/model");
        assertEquals(200, res.status);

        /**
         * This string is the words ripped from github, since this is a beautified version
         * We need to strip the new line characters and spaces
         * Don't believe me? go to json lint and compare the two... I dare you.
         */
        String olgit = "{\n" +
                "    \"aircraftCarrier\": {\n" +
                "        \"name\": \"AircraftCarrier\",\n" +
                "        \"length\": 5,  \n" +
                "        \"start\": { \"Across\": 0,\"Down\": 0 },\n" +
                "        \"end\": {\"Across\": 0, \"Down\": 0}\n" +
                "    },\n" +
                "    \"battleship\": {\n" +
                "        \"name\": \"Battleship\",\n" +
                "        \"length\": 4,\n" +
                "        \"start\": { \"Across\": 0,\"Down\": 0 },\n" +
                "        \"end\": {\"Across\": 0, \"Down\": 0}\n" +
                "    },\n" +
                "    \"cruiser\": {\n" +
                "        \"name\": \"Cruiser\",\n" +
                "        \"length\": 3,\n" +
                "        \"start\": { \"Across\": 0,\"Down\": 0 },\n" +
                "        \"end\": {\"Across\": 0, \"Down\": 0}\n" +
                "    },\n" +
                "    \"destroyer\": {\n" +
                "        \"name\": \"Destroyer\",\n" +
                "        \"length\": 2,\n" +
                "        \"start\": { \"Across\": 0,\"Down\": 0 },\n" +
                "        \"end\": {\"Across\": 0, \"Down\": 0}\n" +
                "    },\n" +
                "    \"submarine\": {\n" +
                "        \"name\": \"Submarine\",\n" +
                "        \"length\": 2,\n" +
                "       \"start\": { \"Across\": 0,\"Down\": 0 },\n" +
                "        \"end\": {\"Across\": 0, \"Down\": 0}\n" +
                "    },\n" +
                "    \"computer_aircraftCarrier\": {\n" +
                "        \"name\": \"Computer_AircraftCarrier\",\n" +
                "        \"length\": 5,\n" +
                "        \"start\": { \"Across\": 2,\"Down\": 2 },\n" +
                "        \"end\": {\"Across\": 2, \"Down\": 7}\n" +
                "    },\n" +
                "    \"computer_battleship\": {\n" +
                "        \"name\": \"Computer_Battleship\",\n" +
                "        \"length\": 4,\n" +
                "        \"start\": { \"Across\": 2,\"Down\": 8 },\n" +
                "        \"end\": {\"Across\": 6, \"Down\": 8}\n" +
                "    },\n" +
                "    \"computer_cruiser\": {\n" +
                "        \"name\": \"Computer_Cruiser\",\n" +
                "        \"length\": 3,\n" +
                "        \"start\": { \"Across\": 4, \"Down\": 1 },\n" +
                "        \"end\": {\"Across\": 4, \"Down\": 4}\n" +
                "    },\n" +
                "    \"computer_destroyer\": {\n" +
                "        \"name\": \"Computer_Destroyer\",\n" +
                "        \"length\": 2,\n" +
                "        \"start\": { \"Across\": 7, \"Down\": 3 },\n" +
                "        \"end\": {\"Across\": 7, \"Down\": 5}\n" +
                "    },\n" +
                "    \"computer_submarine\": {\n" +
                "        \"name\": \"Computer_Submarine\",\n" +
                "        \"length\": 2,\n" +
                "        \"start\": { \"Across\": 9, \"Down\": 6 },\n" +
                "        \"end\": {\"Across\": 9, \"Down\": 8}\n" +
                "    },\n" +
                "    \"playerHits\": [],\n" +
                "    \"playerMisses\": [],\n" +
                "    \"computerHits\": [],\n" +
                "    \"computerMisses\": []\n" +
                "}";
        //replace those useless characters
        olgit = olgit.replace("\n", "");
        olgit = olgit.replace(" ", "");

        assertEquals(200, res.status);
        assertEquals(olgit,res.body);
    }

    //Set up the main functon to wait for initialization and not give any arguments to main
    @BeforeAll
    public void setUp() throws Exception {
        Main.main(null);
        awaitInitialization();
    }

    //end the simulate server session
    @AfterAll
    public void tearDown() throws Exception {
        Spark.stop();
    }

    //Michael Hilton Code

    /**
     * Creates a new url (spark always has the same localhost url) then tries to connect to the local host
     * If not it catches the exception and throws an error
     * Path in the example of newmodel would be "/model" and the method is either Get or Post (in this ex it is get)
     */
    private TestResponse request(String method, String path) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    /**
     * Testresponse class this is used to test the values returned by the server
     * it has a string body and a status (see new model for ex)
     */
    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }
    }

}