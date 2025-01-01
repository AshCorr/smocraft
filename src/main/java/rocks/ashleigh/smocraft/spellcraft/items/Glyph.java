package rocks.ashleigh.smocraft.spellcraft.items;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.kyori.adventure.text.Component;
import rocks.ashleigh.smocraft.lib.CustomItem;

public abstract class Glyph extends CustomItem {
    private String name;
    private ItemRarity rarity;

    public Glyph(String name, Material material, ItemRarity rarity) {
        super(String.format("glyph_%s", name.toLowerCase().replace(" ", "_")), material);
        this.name = name;
    }

    @Override
    protected ItemStack generateItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        meta.itemName(Component.text("Glyph of ").append(Component.text(name, rarity.color())));
        meta.setRarity(rarity);
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public abstract void onEffect(Player player, Glyph next);
}
