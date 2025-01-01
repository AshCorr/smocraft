package rocks.ashleigh.smocraft.spellcraft;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class SpellbookInventoryHolder implements InventoryHolder {
    private Inventory inventory;
    private final ItemStack spellbook;

    public SpellbookInventoryHolder(ItemStack spellbook, ItemStack[] items, Integer capacity) {
        this.spellbook = spellbook;
        this.inventory = Bukkit.getServer().createInventory(this, capacity * 9, Component.text("Spellbook", NamedTextColor.DARK_PURPLE));

        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) continue;

            inventory.setItem(i, items[i]);
        }
    }

    public ItemStack getSpellbook() {
        return spellbook;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
