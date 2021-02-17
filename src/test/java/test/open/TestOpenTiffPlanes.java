package test.open;

import de.embl.cba.bdp2.BigDataProcessor2;
import de.embl.cba.bdp2.image.Image;
import de.embl.cba.bdp2.open.NamingSchemes;
import org.junit.Test;
import test.Utils;

import static de.embl.cba.bdp2.open.NamingSchemes.Z;

public class TestOpenTiffPlanes
{
    public static void main(String[] args)
    {
        Utils.prepareInteractiveMode();

        new TestOpenTiffPlanes().run();
    }

    @Test
    public void run()
    {
        final String directory = "src/test/resources/test/tiff-planes";

        final Image image = BigDataProcessor2.openTIFFSeries( directory, ".*_T(" + NamingSchemes.T + "\\d+)__z(" + Z + "\\d+).*_c(" + NamingSchemes.C + "\\d+).*" );

        double[] voxelSize = image.getVoxelDimensions();
        image.setVoxelDimensions( voxelSize[ 0 ], voxelSize[ 1 ], 1.0 ); // necessary because voxel size in z is NaN for single plane Tiff

        // BigDataProcessor2.showImage( image, true );
    }
}
