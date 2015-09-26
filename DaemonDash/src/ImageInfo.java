import java.awt.Color;
import java.awt.image.BufferedImage;

public class ImageInfo {

	static final int ROWS = 4;
	static int COLS = 4;
	static int CHUNKS = ROWS * COLS;

	final int CHUNK_HEIGHT;
	final int CHUNK_WIDTH;
	final int CHUNK_SIZE;
	
	float[][] hsb;

	public ImageInfo(BufferedImage buffImg) {
		CHUNK_HEIGHT = buffImg.getHeight() / COLS;
		CHUNK_WIDTH = buffImg.getWidth() / ROWS;
		CHUNK_SIZE = CHUNK_HEIGHT * CHUNK_WIDTH;
		hsb = new float[CHUNKS][3];
		getHSB(buffImg);
	}

	private void getHSB(BufferedImage img) {
		for (int chunk = 0; chunk < CHUNKS; chunk++) {
			long rgbs = 0;
			for (int i = 0; i < CHUNK_WIDTH; i++) {
				for (int j = 0; j < CHUNK_HEIGHT; j++) {
					rgbs += img.getRGB(i + chunk % COLS, j + chunk / ROWS);
				}
			}

			rgbs /= CHUNK_SIZE;
			Color.RGBtoHSB((int) rgbs & 0xFF0000, (int) rgbs & 0x00FF00, (int) rgbs & 0x0000FF, hsb[chunk]);
		}

	}

}
