package rocks.ashleigh.smocraft.lib;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public abstract class CustomItem implements Listener {
    
    public final String id;
    public final Material material;

    public CustomItem(String id, Material material) {
        this.id = id;
        this.material = material;
    }

    public boolean isApplicable(ItemStack itemStack) {
        if(itemStack == null) return false;
        if(!itemStack.hasItemMeta()) return false;

        ItemMeta meta = itemStack.getItemMeta();
        PersistentDataContainer pdc = meta.getPersistentDataContainer();

        String pdcId = pdc.get(new NamespacedKey("smocraft", "item_id"), PersistentDataType.STRING);

        return id.equals(pdcId);
    }

    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta meta = itemStack.getItemMeta();

        PersistentDataContainer pdc = meta.getPersistentDataContainer();
        pdc.set(new NamespacedKey("smocraft", "item_id"), PersistentDataType.STRING, id);

        itemStack.setItemMeta(meta);

        return generateItem(itemStack);
    }

    protected abstract ItemStack generateItem(ItemStack itemStack);
}
