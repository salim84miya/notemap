package com.salim.notemap.services;


import org.springframework.ai.document.Document;

import java.util.List;

public interface DataTokenSplitter {

    public List<Document> splitData(List<Document> documents);
}
