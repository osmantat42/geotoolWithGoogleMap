// 
// Decompiled by Procyon v0.5.30
// 

package tr.tat.gis.gmap.google;

import java.net.URL;
import org.geotools.tile.Tile;
import org.geotools.tile.TileIdentifier;
import org.geotools.tile.TileService;
import org.geotools.tile.impl.WebMercatorTileFactory;
import org.geotools.tile.impl.ZoomLevel;

public class GoogleTile extends Tile
{
    public static final int DEFAULT_TILE_SIZE = 256;
    private TileService service;
    
    public GoogleTile(final int x, final int y, final ZoomLevel zoomLevel, final TileService service) {
        this(new GoogleTileIdentifier(x, y, zoomLevel, service.getName()), service);
    }
    
    public GoogleTile(final TileIdentifier tileName, final TileService service) {
        super(tileName, WebMercatorTileFactory.getExtentFromTileName(tileName), 256);
        this.service = service;
    }
    
    public URL getUrl() {
        final String url = this.service.getBaseUrl().replace("{x}", this.getTileIdentifier().getX()+"").replace("{y}", this.getTileIdentifier().getY()+"").replace("{z}", this.getTileIdentifier().getZ()+"")+
                   ".png";
        try {
            return new URL(url);
        }
        catch (Exception e) {
            final String mesg = "Cannot create URL from " + url;
            throw new RuntimeException(mesg, e);
        }
    }
}
