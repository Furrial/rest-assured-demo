package org.example.meme;

import org.example.meme.client.MemeClient;
import org.example.meme.dto.Meme;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.testng.Assert.assertEquals;


public class GetMemeTest extends BaseTest {

    @Test
    public void testGetMemes() {
        List<Meme> memes = Arrays.asList(MemeClient.getMemes()
                .statusCode(200)
                .extract().jsonPath().getObject("data", Meme[].class));

        assertThat(memes, not(empty()));
        assertThat(memes, hasItem(hasProperty("id", equalTo(DEFAULT_ITEM_ID))));
    }

    @Test
    public void testGetMeme_defaultOne() {
        Meme defaultMeme = MemeClient.getMeme(DEFAULT_ITEM_ID)
                .statusCode(200)
                .extract().body().as(Meme.class);

        assertEquals(defaultMeme.getId(), DEFAULT_ITEM_ID);
    }
}
