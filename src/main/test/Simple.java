import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.github.binarywang.utils.qrcode.MatrixToImageWriter;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class Simple {

	public static void main(String[] args) throws IOException, WriterException {
		String text = "你好";
		String format = "png";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text,
				BarcodeFormat.QR_CODE, 600, 400);
		File outputFile = new File("C:/Users/kevin/Desktop/new.png");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
	}
}
