package rocks.ashleigh.smocraft.fishing.items.standard;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class PufferfishRare extends FishItem {
    public PufferfishRare() {
        super("Pufferfish", 1, Material.PUFFERFISH, ItemRarity.RARE);
    }
    
}
