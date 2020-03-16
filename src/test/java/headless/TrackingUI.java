package headless;

import de.embl.cba.bdp2.image.Image;
import de.embl.cba.bdp2.load.files.FileInfos;
import de.embl.cba.bdp2.ui.BigDataProcessor2;
import de.embl.cba.bdp2.viewers.BdvImageViewer;
import net.imagej.ImageJ;

public class TrackingUI
{
	public static void main( String[] args )
	{

		final ImageJ imageJ = new ImageJ();
		imageJ.ui().showUI();

		final BigDataProcessor2 bdp = new BigDataProcessor2<>();

		String imageDirectory = "/Users/tischer/Documents/fiji-plugin-bigDataProcessor2/" +
				"src/test/resources/test-data/microglia-track-nt123/volumes";

		final Image image = bdp.openImage(
				imageDirectory,
				FileInfos.SINGLE_CHANNEL_TIMELAPSE,
				".*" );

		image.setVoxelUnit( "pixel" );
		image.setVoxelSpacing( 1.0, 1.0, 1.0 );

		final BdvImageViewer viewer = bdp.showImage( image );
		viewer.setDisplayRange( 0, 150, 0 );
	}

}
