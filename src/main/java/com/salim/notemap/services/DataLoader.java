package com.salim.notemap.services;


import org.springframework.ai.document.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DataLoader {

    public List<Document> uploadPdf(MultipartFile file) throws IOException;
}
