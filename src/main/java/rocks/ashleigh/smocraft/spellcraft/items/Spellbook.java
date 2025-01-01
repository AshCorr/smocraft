package rocks.ashleigh.smocraft.spellcraft.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import net.kyori.adventure.text.Component;
import rocks.ashleigh.smocraft.SmocraftItemRegistry;
import rocks.ashleigh.smocraft.lib.CustomItem;
import rocks.ashleigh.smocraft.lib.ItemStackSerialization;
import rocks.ashleigh.smocraft.spellcraft.SpellbookInventoryHolder;

public class Spellbook extends CustomItem {
    public Spellbook() {
        super("spellbook", Material.BOOK);
    }

    @Override
    protected ItemStack generateItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.itemName(Component.text("Spellbook"));
        
        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(new NamespacedKey("smocraft", "spellbook_contents"), PersistentDataType.STRING, ItemStackSerialization.serialize(new ItemStack[0]));

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    @EventHandler
    public void onLeftClick(PlayerInteractEvent e) {
        if (e.getAction() != Action.LEFT_CLICK_AIR && e.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (!isApplicable(e.getItem())) {
            return;
        }

        e.getPlayer().sendMessage("Not implemented yet.");
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }

        ItemStack spellbook = e.getPlayer().getInventory().getItem(e.getHand());

        if (!isApplicable(spellbook)) {
            return;
        }

        String contentsAsString = spellbook.getPersistentDataContainer().get(new NamespacedKey("smocraft", "spellbook_contents"), PersistentDataType.STRING);
        ItemStack[] contents = ItemStackSerialization.deserialize(contentsAsString);

        SpellbookInventoryHolder inventory = new SpellbookInventoryHolder(spellbook, contents, 1);
        inventory.getInventory().setStorageContents(contents);
        e.getPlayer().openInventory(inventory.getInventory());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        Inventory inventory = e.getInventory();
        // Add a null check in case the player clicked outside the window.
        if (inventory == null || !(inventory.getHolder(false) instanceof SpellbookInventoryHolder spellbookInventory)) {
            return;
        }

        Spellbook spellbookClass = (Spellbook) SmocraftItemRegistry.SPELLBOOK.getCustomItem();
        spellbookClass.setSpells(spellbookInventory.getSpellbook(), spellbookInventory.getInventory().getStorageContents());
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Inventory inventory = e.getClickedInventory();
        // Add a null check in case the player clicked outside the window.
        if (inventory == null || !(inventory.getHolder(false) instanceof SpellbookInventoryHolder spellbookInventory)) {
            return;
        }

        

        Spellbook spellbookClass = (Spellbook) SmocraftItemRegistry.SPELLBOOK.getCustomItem();
        spellbookClass.setSpells(spellbookInventory.getSpellbook(), spellbookInventory.getInventory().getStorageContents());
    }

    public List<ItemStack> getSpells(ItemStack stack) {
        List<ItemStack> spells = new ArrayList<>();

        ItemMeta meta = stack.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        return spells;
    }

    public void setSpells(ItemStack stack, ItemStack[] spells) {
        ItemMeta meta = stack.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        data.set(new NamespacedKey("smocraft", "spellbook_contents"), PersistentDataType.STRING, ItemStackSerialization.serialize(spells));

        stack.setItemMeta(meta);
    }
}
