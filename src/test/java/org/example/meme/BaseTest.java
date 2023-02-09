package org.example.meme;

import org.example.meme.client.AuthorizeClient;
import org.example.meme.constant.Props;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    public static final int DEFAULT_ITEM_ID = 1;

    @BeforeSuite
    public void authorize() {
        AuthorizeClient.authorize(Props.USERNAME);
    }
}
