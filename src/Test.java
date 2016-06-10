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
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class Test {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		MyUtils myUtils = new MyUtils();
		String value = "我是大帅哥1";
//		myUtils.genImage(value, "jpg", "gbk", "d://d");
		
		
		Result res= myUtils.parseImage("d://d//new.jpg", "gbk");
		System.out.println(res.getText());
		System.out.println(res.getBarcodeFormat());
		
		
		/*String text = "http://www.baidu.com";
		int width = 300;
		int height = 300;
		// 二维码的图片格式
		String format = "png";
		Hashtable hints = new Hashtable();
		// 内容所使用编码
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height, hints);
		// 生成二维码
		File outputFile = new File("d:" + File.separator + "new.png");
		MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
		*/


		
		
		
//		String filePath = "d:" + File.separator + "new.png";
//		BufferedImage image;  
//        try {  
//            image = ImageIO.read(new File(filePath));  
//            LuminanceSource source = new BufferedImageLuminanceSource(image);  
//            Binarizer binarizer = new HybridBinarizer(source);  
//            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);  
//            Map<DecodeHintType, Object> hints1 = new HashMap<DecodeHintType, Object>();  
//            hints1.put(DecodeHintType.CHARACTER_SET, "UTF-8");  
//            Result result = new MultiFormatReader().decode(binaryBitmap, hints1);// 对图像进行解码  
//            System.out.println(result.getText());
//           /* JSONObject content = JSONObject.parseObject(result.getText());  
//            System.out.println("图片中内容：  ");  
//            System.out.println("author： " + content.getString("author"));  
//            System.out.println("zxing：  " + content.getString("zxing"));  
//            System.out.println("图片中格式：  ");  
//            System.out.println("encode： " + result.getBarcodeFormat());  */
//        } catch (IOException e) {  
//            e.printStackTrace();  
//        } catch (NotFoundException e) {  
//            e.printStackTrace();  
//        }  
		
	}

}