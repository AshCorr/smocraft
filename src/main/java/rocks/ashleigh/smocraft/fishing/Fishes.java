package rocks.ashleigh.smocraft.fishing;

import javax.inject.Named;

import org.bukkit.Material;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class Fishes {
    public static final ItemStack COD = createFish(Material.COD, ItemRarity.COMMON, 1, "Cod");
    public static final ItemStack COD_UNCOMMON = createFish(Material.COD, ItemRarity.UNCOMMON, 1, "Cod");
    public static final ItemStack COD_RARE = createFish(Material.COD, ItemRarity.RARE, 1, "Cod");
    public static final ItemStack SALMON = createFish(Material.SALMON, ItemRarity.COMMON, 2, "Salmon");
    public static final ItemStack SALMON_UNCOMMON = createFish(Material.SALMON, ItemRarity.UNCOMMON, 2, "Salmon");
    public static final ItemStack SALMON_RARE = createFish(Material.SALMON, ItemRarity.RARE, 2, "Salmon");
    public static final ItemStack TROPICAL = createFish(Material.TROPICAL_FISH, ItemRarity.COMMON, 3, "Tropical Fish");
    public static final ItemStack TROPICAL_UNCOMMON = createFish(Material.TROPICAL_FISH, ItemRarity.RARE, 3, "Tropical Fish");
    public static final ItemStack TROPICAL_RARE = createFish(Material.TROPICAL_FISH, ItemRarity.EPIC, 3, "Tropical Fish");
    public static final ItemStack PUFFERFISH = createFish(Material.PUFFERFISH, ItemRarity.COMMON, 4, "Pufferfish");
    public static final ItemStack PUFFERFISH_UNCOMMON = createFish(Material.PUFFERFISH, ItemRarity.UNCOMMON, 4, "Pufferfish");
    public static final ItemStack PUFFERFISH_RARE = createFish(Material.PUFFERFISH, ItemRarity.RARE, 4, "Pufferfish");

    public static final ItemStack GOLDEN_PUFFERFISH = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 101, "Golden Pufferfish");
    public static final ItemStack WHO_THAT_FISHEMON = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 102, "Who's That Fishemon??");
    public static final ItemStack CLOWN_FISH = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 103, "Clown-Fish");
    public static final ItemStack HANDSOME_SQUIDWARD = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 104, "Handsome Squidward");
    public static final ItemStack CATFISH = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 105, "\"Cat\"fish");
    public static final ItemStack SHARK = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 106, "Shark");
    public static final ItemStack RED_HERRING = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 107, "Red Herring");
    public static final ItemStack HSIF = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 108, "hsiF");
    public static final ItemStack RUBBER_DUCKY = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 109, "Rubber Ducky");
    public static final ItemStack THE_GREAT_OLD_ONE = createFish(Material.PUFFERFISH, ItemRarity.EPIC, 110, "The great old one");


    private static ItemStack createFish(Material fishType, ItemRarity rarity, int fishId, String name) {
        ItemStack fish = new ItemStack(fishType);
        ItemMeta meta = fish.getItemMeta();

        Component component = Component.text()
            .decoration(TextDecoration.ITALIC, false)
            .append(Component.text(rarity.name().toUpperCase(), rarity.color(), TextDecoration.BOLD))
            .append(Component.text(" "))
            .append(Component.text(name, NamedTextColor.WHITE))
            .build();

        if (rarity.equals(ItemRarity.EPIC)) {
            component = Component.text()
                .decoration(TextDecoration.ITALIC, false)
                .append(Component.text("⭐ ", NamedTextColor.GOLD, TextDecoration.BOLD))
                .append(Component.text(name, NamedTextColor.WHITE))
                .build();

            meta.setMaxStackSize(1);
        }

        

        meta.displayName(component);
        meta.itemName(component);
        meta.setCustomModelData(fishId);
        meta.setRarity(rarity);

        fish.setItemMeta(meta);
        return fish;
    }
}
