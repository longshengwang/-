import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class MyUtils {
	public void genImage(String value, String imageformat,String charset, String genPath){ 
//		String text = "http://www.baidu.com";
		int width = 300;
		int height = 300;
		
		Hashtable hints = new Hashtable();
		// ������ʹ�ñ���
		hints.put(EncodeHintType.CHARACTER_SET, charset);
		BitMatrix bitMatrix;
		try {
			bitMatrix = new MultiFormatWriter().encode(value, BarcodeFormat.QR_CODE, width, height, hints);
			File outputFile = new File( genPath + File.separator + "new."+ imageformat);
			MatrixToImageWriter.writeToFile(bitMatrix, imageformat, outputFile);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Result parseImage(String filepath, String charset){
		BufferedImage image;  
        try {  
            image = ImageIO.read(new File(filepath));  
            LuminanceSource source = new BufferedImageLuminanceSource(image);  
            Binarizer binarizer = new HybridBinarizer(source);  
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
            Map<DecodeHintType, Object> hints1 = new HashMap<DecodeHintType, Object>();  
            hints1.put(DecodeHintType.CHARACTER_SET, charset);  
            Result result = new MultiFormatReader().decode(binaryBitmap, hints1);// ��ͼ����н���  
            System.out.println(result.getText());
            return result;
           /* JSONObject content = JSONObject.parseObject(result.getText());  
            System.out.println("ͼƬ�����ݣ�  ");  
            System.out.println("author�� " + content.getString("author"));  
            System.out.println("zxing��  " + content.getString("zxing"));  
            System.out.println("ͼƬ�и�ʽ��  ");  
            System.out.println("encode�� " + result.getBarcodeFormat());  */
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (NotFoundException e) {  
            e.printStackTrace();  
        }  
        return null;
	}
}
