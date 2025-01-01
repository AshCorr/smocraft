package rocks.ashleigh.smocraft.fishing;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;

import com.google.common.collect.Lists;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import rocks.ashleigh.smocraft.lib.CustomItem;

public class FishItem extends CustomItem {
    private ItemRarity rarity;
    private String name;
    private String id;

    private FishItem(String name, String id, Material material, ItemRarity rarity) {
        super(String.format("fish_%s_%s", id, rarity), material);

        this.rarity = rarity;
        this.name = name;
        this.id = id;
    }
    public FishItem(String name, int modelId, Material material, ItemRarity rarity) {
        this(name, name.replaceAll(" ", "_").replaceAll(name, name).toLowerCase(), material, rarity);
    }

    
    @Override
    protected ItemStack generateItem(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        CustomModelDataComponent modelData = meta.getCustomModelDataComponent();
        TextComponent component = Component.text("");

        switch (rarity) {
            case COMMON:
                component = Component.text("⭐ ", NamedTextColor.GOLD);
                break;
            case UNCOMMON:
                component = Component.text("⭐⭐ ", NamedTextColor.GOLD);
                break;
            case RARE:
                component = Component.text("⭐⭐⭐ ", NamedTextColor.GOLD);
                break;
            case EPIC:
                component = Component.text("⭐⭐⭐⭐ ", NamedTextColor.GOLD);
                break;
        }

        component = component.append(Component.text(name, rarity.color()));

        modelData.setStrings(List.of(id));

        meta.setRarity(rarity);
        meta.setCustomModelDataComponent(modelData);
        meta.itemName(component);
        itemStack.setItemMeta(meta);

        return itemStack;
    }
    
}
