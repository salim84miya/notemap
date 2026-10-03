package com.salim.notemap.services;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PdfTokenSplitter implements DataTokenSplitter{
    @Override
    public List<Document> splitData(List<Document> documents) {

        TokenTextSplitter tokenTextSplitter = TokenTextSplitter.builder()
                .withChunkSize(250)
                .withMinChunkSizeChars(200)
                .withMinChunkLengthToEmbed(10)
                .withKeepSeparator(true)
                .build();

        return tokenTextSplitter.apply(documents);
    }
}
