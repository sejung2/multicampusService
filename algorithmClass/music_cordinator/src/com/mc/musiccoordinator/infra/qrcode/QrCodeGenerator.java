package com.mc.musiccoordinator.infra.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.mc.musiccoordinator.infra.qrcode.dto.QrCodeDTO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

public class QrCodeGenerator {
    // AIzaSyAX0oeen34Jw8JK6fu5NTQw-3Q53B9pOCI
    public void generate(QrCodeDTO dto) throws WriterException {
        try(FileOutputStream fos = new FileOutputStream(dto.fileName())) {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(dto.text(), BarcodeFormat.QR_CODE, 300, 300);
            MatrixToImageWriter.writeToStream(bitMatrix, dto.format(), fos);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
