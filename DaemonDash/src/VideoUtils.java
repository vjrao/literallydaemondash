import java.io.File;

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
		try {
			while (true) {
				// Request a video frame
				videoFrame = videoAdapter.getFrame();
			}
		} catch (MarvinVideoInterfaceException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//        VideoUtils m = new VideoUtils(null);
//    }

}
