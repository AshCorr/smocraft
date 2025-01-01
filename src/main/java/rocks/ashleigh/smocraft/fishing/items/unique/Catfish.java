package rocks.ashleigh.smocraft.fishing.items.unique;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.ashleigh.smocraft.fishing.FishItem;

public class Catfish extends FishItem {
    public Catfish() {
        super("Catfish", 5, Material.PUFFERFISH, ItemRarity.EPIC);
    }
    
}
