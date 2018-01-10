// 
// Decompiled by Procyon v0.5.30
// 

package tr.tat.gis.gmap.google;

import org.geotools.tile.TileFactory;
import org.geotools.tile.impl.WebMercatorTileService;


/*
https://mt0.google.com/vt/lyrs=y&hl=en&x={x}&y={y}&z={z}&s=Ga
h = roads only
m = standard roadmap
p = terrain
r = somehow altered roadmap
s = satellite only
t = terrain only
y = hybrid
*/
public class GoogleService extends WebMercatorTileService
{
    private static final TileFactory tileFactory;
    private static double[] scaleList;
    
    public GoogleService(final String name, final String baseUrl) {
        super(name, baseUrl);
    }
    
    public double[] getScaleList() {
        return GoogleService.scaleList;
    }
    
    public TileFactory getTileFactory() {
        return GoogleService.tileFactory;
    }
    
    static {
        tileFactory = (TileFactory)new GoogleTileFactory();
        GoogleService.scaleList = new double[] { Double.NaN, Double.NaN, 1.47914381E8, 7.395719E7, 3.6978595E7, 1.8489297E7, 9244648.0, 4622324.0, 2311162.0, 1155581.0, 577790.0, 288895.0, 144447.0, 72223.0, 36111.0, 18055.0, 9027.0, 4513.0, 2256.0 };
    }
}
