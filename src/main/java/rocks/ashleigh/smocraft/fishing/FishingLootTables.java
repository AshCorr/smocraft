package rocks.ashleigh.smocraft.fishing;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import rocks.ashleigh.smocraft.Smocraft;
import rocks.ashleigh.smocraft.SmocraftItemRegistry;
import rocks.ashleigh.smocraft.fishing.reward.FishingCursedByTheSeaReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingDrownedReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingGuardianReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingItemReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingLightningReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingSplashReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingSquidReward;
import rocks.ashleigh.smocraft.fishing.reward.FishingTridentReward;

public class FishingLootTables {
    public static final FishingLootTable COMMON_FISH = FishingLootTable.of(
        new int[] { 775, 720, 640, 570 },
        new FishingItemReward(new int[] { 35 }, SmocraftItemRegistry.COD.getItem()),
        new FishingItemReward(new int[] { 25 }, SmocraftItemRegistry.SALMON.getItem()),
        new FishingItemReward(new int[] { 13 }, SmocraftItemRegistry.TROPICAL_FISH.getItem()),
        new FishingItemReward(new int[] { 27 }, SmocraftItemRegistry.PUFFERFISH.getItem())
    );

    public static final FishingLootTable UNCOMMON_FISH = FishingLootTable.of(
        new int[] { 25, 75, 125, 175 },
        new FishingItemReward(new int[] { 35 }, SmocraftItemRegistry.COD_UNCOMMON.getItem()),
        new FishingItemReward(new int[] { 25 }, SmocraftItemRegistry.SALMON_UNCOMMON.getItem()),
        new FishingItemReward(new int[] { 13 }, SmocraftItemRegistry.TROPICAL_FISH_UNCOMMON.getItem()),
        new FishingItemReward(new int[] { 27 }, SmocraftItemRegistry.PUFFERFISH_UNCOMMON.getItem())
    );

    public static final FishingLootTable RARE_FISH = FishingLootTable.of(
        new int[] { 25, 75, 125, 175 },
        new FishingItemReward(new int[] { 35 }, SmocraftItemRegistry.COD_RARE.getItem()),
        new FishingItemReward(new int[] { 25 }, SmocraftItemRegistry.SALMON_RARE.getItem()),
        new FishingItemReward(new int[] { 13 }, SmocraftItemRegistry.TROPICAL_FISH_RARE.getItem()),
        new FishingItemReward(new int[] { 27 }, SmocraftItemRegistry.PUFFERFISH_RARE.getItem())
    );

    public static final FishingLootTable UNIQUE_FISH = FishingLootTable.of(
        new int[] { 0, 0, 15, 30 },
        new FishingItemReward(new int[] { 6 }, SmocraftItemRegistry.GOLDEN_PUFFERFISH.getItem(), true),
        new FishingItemReward(new int[] { 12 }, SmocraftItemRegistry.WHO_THAT_FISHEMON.getItem(), true),
        new FishingItemReward(new int[] { 12 }, SmocraftItemRegistry.CLOWNFISH.getItem(), true),
        new FishingItemReward(new int[] { 12 }, SmocraftItemRegistry.HANDSOME_SQUIDWARD.getItem(), true),
        new FishingItemReward(new int[] { 12 }, SmocraftItemRegistry.CATFISH.getItem(), true),
        new FishingItemReward(new int[] { 10 }, SmocraftItemRegistry.SHARK.getItem(), true),
        new FishingItemReward(new int[] { 10 }, SmocraftItemRegistry.RED_HERRING.getItem(), true),
        new FishingItemReward(new int[] { 10 }, SmocraftItemRegistry.HSIF.getItem(), true),
        new FishingItemReward(new int[] { 12 }, SmocraftItemRegistry.RUBBER_DUCKY.getItem(), true),
        new FishingItemReward(new int[] { 4 }, SmocraftItemRegistry.THE_GREAT_OLD_ONE.getItem(), true)
    );

    public static final FishingLootTable TREASURE = FishingLootTable.of(new int[] { 50 , 70 ,90, 110},
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.BOW)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.ENCHANTED_BOOK)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.FISHING_ROD)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.NAME_TAG)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.NAUTILUS_SHELL)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.SADDLE))
    );

    public static final FishingLootTable JUNK = FishingLootTable.of(
        new int[] { 100, 80, 60, 40 },
        new FishingItemReward(new int[] { 17 }, new ItemStack(Material.LILY_PAD)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.BOWL)),
        new FishingItemReward(new int[] { 2 }, new ItemStack(Material.FISHING_ROD)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.LEATHER)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.LEATHER_BOOTS)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.ROTTEN_FLESH)),
        new FishingItemReward(new int[] { 5 }, new ItemStack(Material.STICK)),
        new FishingItemReward(new int[] { 5 }, new ItemStack(Material.STRING)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.POTION)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.BONE)),
        new FishingItemReward(new int[] { 1 }, new ItemStack(Material.INK_SAC, 10)),
        new FishingItemReward(new int[] { 10 }, new ItemStack(Material.TRIPWIRE_HOOK))
    );

    public static final FishingLootTable HARMFUL = FishingLootTable.of(
        new int[] { 50, 30, 20, 0 },
        new FishingCursedByTheSeaReward(),
        new FishingDrownedReward(),
        new FishingGuardianReward(),
        new FishingLightningReward(),
        new FishingSplashReward(),
        new FishingSquidReward(),
        new FishingTridentReward()
    );

    public static final FishingLootTable FISHING = FishingLootTable.of(
        null,
        COMMON_FISH,
        UNCOMMON_FISH,
        RARE_FISH,
        UNIQUE_FISH,
        TREASURE,
        JUNK,
        HARMFUL
    );
    
}
