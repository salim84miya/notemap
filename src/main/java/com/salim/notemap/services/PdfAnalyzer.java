package com.salim.notemap.services;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PdfAnalyzer {

    private final PdfLoader pdfLoader;
    private final PdfTokenSplitter pdfTokenSplitter;


    public List<String> pdfToDocumentReader(MultipartFile file){

        List<String> pdfData = new ArrayList<>();

        try {
         List<Document> documents =  pdfLoader.uploadPdf(file);
//         List<Document> splitDocuments = pdfTokenSplitter.splitData(documents);

         System.out.println("Document size : "+documents.size());

         documents.forEach(document -> {
             System.out.println(document.getText());
             pdfData.add(document.getText());
         });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return pdfData;
    }
}
