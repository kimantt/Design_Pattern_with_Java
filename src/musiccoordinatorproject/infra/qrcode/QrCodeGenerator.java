package musiccoordinatorproject.infra.qrcode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import musiccoordinatorproject.infra.qrcode.dto.QrCodeDTO;

public class QrCodeGenerator {

	public void generate(QrCodeDTO dto) throws WriterException {
		try (FileOutputStream fos = new FileOutputStream(dto.fileName() + "." + dto.format())) {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
	        BitMatrix bitMatrix = qrCodeWriter.encode(dto.text(), BarcodeFormat.QR_CODE, dto.width(), dto.height());
	        MatrixToImageWriter.writeToStream(bitMatrix, dto.format(), fos);
	    
		} catch (IOException e) {
	        throw new UncheckedIOException(e);
	    }
	}
}
