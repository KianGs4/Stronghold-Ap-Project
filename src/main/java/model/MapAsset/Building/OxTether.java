package model.MapAsset.Building;

import model.Player;
import model.enums.MapAssetType;
import utils.Vector2D;

public class OxTether extends Building{
    public OxTether(Vector2D coordinate, Player owner, MapAssetType type) {
        super(coordinate, owner, type);
    }
}
