package org.example.meme;

import org.example.meme.client.MemeClient;
import org.testng.annotations.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.Matchers.containsString;

public class GetMemeValidationTest extends BaseTest {
    @Test
    public void testGetMeme_nonExistentId() {
        MemeClient.getMeme(ThreadLocalRandom.current().nextInt(500, 1000))
                .statusCode(404)
                .body(containsString("Not Found"));
    }
}
