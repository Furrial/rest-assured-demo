package org.example.meme.constant;

import org.example.meme.util.PropsReader;

public class Props {
    public static final String USERNAME = PropsReader.getProperty("username");
    public static final String ENVIRONMENT = PropsReader.getProperty("environment");
}
