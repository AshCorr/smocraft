package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class TropicalFishRare extends FishItem {
    public TropicalFishRare() {
        super("Tropical Fish", 1, Material.TROPICAL_FISH, ItemRarity.RARE);
    }
    
}
