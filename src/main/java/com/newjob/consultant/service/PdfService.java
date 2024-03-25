package com.newjob.consultant.service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;


@Service
public class PdfService {
    public String html2Pdf(String html) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter pdfWriter = new PdfWriter(byteArrayOutputStream);

            DefaultFontProvider defaultFontProvider = new DefaultFontProvider(false, true, false);

            ConverterProperties converterProperties = new ConverterProperties();

            converterProperties.setFontProvider(defaultFontProvider);

            HtmlConverter.convertToPdf(html, pdfWriter, converterProperties);

            FileOutputStream fileOutputStream = new FileOutputStream("/Users/jeeewan/TestPdfs/Career");

            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.close();

            byteArrayOutputStream.flush();
            fileOutputStream.close();

            return null;
        } catch (Exception ex) {
            /**
             * *exception occurred*/

        }
        return null;
    }
}
