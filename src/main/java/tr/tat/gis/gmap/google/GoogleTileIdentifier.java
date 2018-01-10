// 
// Decompiled by Procyon v0.5.30
// 

package tr.tat.gis.gmap.google;

import org.geotools.tile.TileIdentifier;
import org.geotools.tile.impl.ZoomLevel;


public class GoogleTileIdentifier extends TileIdentifier
{
    public GoogleTileIdentifier(final int x, final int y, final ZoomLevel zoomLevel, final String serviceName) {
        super(x, y, zoomLevel, serviceName);
    }
    
    public String getId() {
        final String separator = "_";
        final StringBuilder sb = this.createGenericCodeBuilder("_");
        sb.insert(0, "_").insert(0, this.getServiceName());
        return sb.toString();
    }
    
    public String getCode() {
        final String separator = "/";
        return this.createGenericCodeBuilder("/").toString();
    }
    
    private StringBuilder createGenericCodeBuilder(final String separator) {
        final StringBuilder sb = new StringBuilder(50);
        sb.append(this.getZ()).append(separator).append(this.getX()).append(separator).append(this.getY());
        return sb;
    }
    
    public TileIdentifier getRightNeighbour() {
        return new GoogleTileIdentifier(TileIdentifier.arithmeticMod(this.getX() + 1, this.getZoomLevel().getMaxTilePerRowNumber()), this.getY(), this.getZoomLevel(), this.getServiceName());
    }
    
    public TileIdentifier getLowerNeighbour() {
        return new GoogleTileIdentifier(this.getX(), TileIdentifier.arithmeticMod(this.getY() + 1, this.getZoomLevel().getMaxTilePerRowNumber()), this.getZoomLevel(), this.getServiceName());
    }
}
