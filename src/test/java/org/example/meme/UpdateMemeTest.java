package org.example.meme;

import org.example.meme.client.MemeClient;
import org.example.meme.constant.Props;
import org.example.meme.dto.Info;
import org.example.meme.dto.Meme;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UpdateMemeTest extends BaseTest {

    Meme raw;
    Meme created;
    Meme updated;
    String URL = "https://ichef.bbci.co.uk/news/1024/branded_news/7CC2/production/_118283913_29xp-meme-mobilemasterat3x-v3.jpg";
    String TEXT = "Disaster girl";

    @BeforeMethod
    public void createMeme() {
        raw = new Meme();
        raw.setUrl(URL);
        raw.setText(""); //will be changed in test
        raw.setTags(Collections.singletonList("disaster"));
        raw.setInfo(new Info());
        raw.setUpdated_by(Props.USERNAME);

        created = MemeClient.postMeme(raw)
                .statusCode(200)
                .extract().body().as(Meme.class);
    }

    @Test
    public void testUpdateMeme() {
        created.setText(TEXT);

        updated = MemeClient.putMeme(created.getId(), created)
                .statusCode(200)
                .extract().as(Meme.class);
        assertThat(updated.getText(), equalTo(TEXT));
        assertThat(updated, equalTo(created));

        updated = MemeClient.getMeme(created.getId())
                .statusCode(200)
                .extract().as(Meme.class);
        assertThat(updated, equalTo(created));
    }

    @AfterMethod
    public void deleteMeme() {
        MemeClient.deleteMeme(created.getId())
                .statusCode(200);
    }
}
