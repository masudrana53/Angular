//package com.crudproject.crudproject.config;
//
//import com.lowagie.text.DocumentException;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//
//import java.io.FileOutputStream;
//import java.io.OutputStream;
//import java.util.Map;
//
//public class PdfGenerator {
//
//    public static void generatePDF(String templatePath, String outputPath, Context context){
//        TemplateEngine templateEngine = new TemplateEngine();
//        String htmlContent = templateEngine.process(templatePath, context);
//
//        if (customData != null) {
//            for (Map.Entry<String, Object> entry : customData.entrySet()) {
//                context.setVariable(entry.getKey(), entry.getValue());
//            }
//        }
//
//        try (OutputStream os = new FileOutputStream(outputPath)) {
//            ITextRenderer renderer = new ITextRenderer();
//            renderer.setDocumentFromString(htmlContent);
//            renderer.layout();
//            renderer.createPDF(os, false);
//        } catch (DocumentException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
