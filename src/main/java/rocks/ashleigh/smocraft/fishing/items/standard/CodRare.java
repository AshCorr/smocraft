package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class CodRare extends FishItem {
    public CodRare() {
        super("Cod", 1, Material.COD, ItemRarity.RARE);
    }
    
}
