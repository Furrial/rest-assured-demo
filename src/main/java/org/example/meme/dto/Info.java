package org.example.meme.dto;

import lombok.Data;

import java.util.List;

@Data
public class Info {
    private List<String> colors;
    private List<String> objects;
}
