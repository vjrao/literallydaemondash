import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInfo {
	
	
	
	public void getImgChunks(File imgFile) throws IOException{
		FileInputStream mFileInputStream = new FileInputStream(imgFile);
		BufferedImage buffImg = ImageIO.read(mFileInputStream);
		
		int rows = 4;  
        int cols = 4;  
        int chunks = rows * cols; 
		
		int chunkHeight = buffImg.getHeight();
		int chunkWidth = buffImg.getWidth();
		int count = 0;
		
		BufferedImage imgChunks[] = new BufferedImage[chunks];
		
		for (int x = 0; x < rows; x++) {  
            for (int y = 0; y < cols; y++) {  
                //Initialize the image array with image chunks  
                imgChunks[count] = new BufferedImage(chunkWidth, chunkHeight, buffImg.getType()); 
                
                Graphics2D gr = imgChunks[count++].createGraphics();  
                gr.drawImage(buffImg, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
                gr.dispose(); 
            }
		}
		
	}
		


}
