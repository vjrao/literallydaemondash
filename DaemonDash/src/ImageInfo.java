import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInfo {
	
	final int CHUNKS = 64; //number of chunks the image should be split into
	
	BufferedImage mImg;
	
	public void readImg(File imgFile) throws IOException{
		FileInputStream mFileInputStream = new FileInputStream(imgFile);
		mImg = ImageIO.read(mFileInputStream);
	}

}
