package org.example.meme.dto;

import lombok.Data;

import java.util.List;

@Data
public class Meme {
    private int id;
    private String url;
    private List<String> tags;
    private Info info;
    private String updated_by;
    private String text;
}