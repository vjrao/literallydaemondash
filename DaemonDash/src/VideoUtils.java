import java.io.File;
import java.util.ArrayList;

import marvin.image.MarvinImage;
import marvin.video.MarvinJavaCVAdapter;
import marvin.video.MarvinVideoInterface;
import marvin.video.MarvinVideoInterfaceException;

public class VideoUtils implements Runnable {

	private MarvinVideoInterface videoAdapter;
	private MarvinImage videoFrame;

	public VideoUtils(File vidFile) {
		// TODO Auto-generated constructor stub
		try {
			// Create the VideoAdapter used to load the video file
			videoAdapter = new MarvinJavaCVAdapter();
			videoAdapter.loadResource(vidFile.getAbsolutePath());

			// Start the thread for requesting the video frames
			new Thread(this).start();
		} catch (MarvinVideoInterfaceException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ArrayList<ImageInfo> vidFrameInfoFiles = new ArrayList<ImageInfo>();
		try {
			int c = 0;
			while (true) {
				c++;
				if (c % 30 == 0) {
					// Request a video frame
					videoFrame = videoAdapter.getFrame();
					ImageInfo imgInfo = new ImageInfo(videoFrame.getBufferedImage());
					vidFrameInfoFiles.add(imgInfo);
				}
				System.out.println(vidFrameInfoFiles);
			}
		} catch (MarvinVideoInterfaceException e) {
			e.printStackTrace();
		}
	}

}
