// 
// Decompiled by Procyon v0.5.30
// 

package tr.tat.gis.gmap.google;

import org.geotools.tile.Tile;
import org.geotools.tile.TileFactory;
import org.geotools.tile.TileService;
import org.geotools.tile.impl.WebMercatorTileFactory;
import org.geotools.tile.impl.ZoomLevel;


public class GoogleTileFactory extends WebMercatorTileFactory
{
    public Tile findTileAtCoordinate(double lon, double lat, final ZoomLevel zoomLevel, final TileService service) {
        lat = TileFactory.normalizeDegreeValue(lat, 90);
        lon = TileFactory.normalizeDegreeValue(lon, 180);
        lat = moveInRange(lat, -85.05112878, 85.05112878);
        final int xTile = (int)Math.floor((lon + 180.0) / 360.0 * (1 << zoomLevel.getZoomLevel()));
        final int yTile = (int)Math.floor((1.0 - Math.log(Math.tan(lat * 3.141592653589793 / 180.0) + 1.0 / Math.cos(lat * 3.141592653589793 / 180.0)) / 3.141592653589793) / 2.0 * (1 << zoomLevel.getZoomLevel()));
        return new GoogleTile(xTile, yTile, zoomLevel, service);
    }
    
    public static double moveInRange(double value, final double min, final double max) {
        if (value < min) {
            value = min;
        }
        else if (value > max) {
            value = max;
        }
        return value;
    }
    
    public Tile findRightNeighbour(final Tile tile, final TileService service) {
        return new GoogleTile(tile.getTileIdentifier().getRightNeighbour(), service);
    }
    
    public Tile findLowerNeighbour(final Tile tile, final TileService service) {
        return new GoogleTile(tile.getTileIdentifier().getLowerNeighbour(), service);
    }
}
