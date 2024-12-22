package rocks.ashleigh.smocraft.fishing;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
        new FishingItemReward(new int[] { 35 }, Fishes.COD),
        new FishingItemReward(new int[] { 25 }, Fishes.SALMON),
        new FishingItemReward(new int[] { 13 }, Fishes.TROPICAL),
        new FishingItemReward(new int[] { 27 }, Fishes.PUFFERFISH)
    );

    public static final FishingLootTable RARE_FISH = FishingLootTable.of(
        new int[] { 25, 75, 125, 175 },
        new FishingItemReward(new int[] { 35 }, Fishes.COD_UNCOMMON),
        new FishingItemReward(new int[] { 25 }, Fishes.SALMON_UNCOMMON),
        new FishingItemReward(new int[] { 13 }, Fishes.TROPICAL_UNCOMMON),
        new FishingItemReward(new int[] { 27 }, Fishes.PUFFERFISH_UNCOMMON)
    );

    public static final FishingLootTable LEGENDARY_FISH = FishingLootTable.of(
        new int[] { 0, 25, 50, 75 },
        new FishingItemReward(new int[] { 35 }, Fishes.COD_RARE),
        new FishingItemReward(new int[] { 25 }, Fishes.SALMON_RARE),
        new FishingItemReward(new int[] { 13 }, Fishes.TROPICAL_RARE),
        new FishingItemReward(new int[] { 27 }, Fishes.PUFFERFISH_RARE)
    );

    public static final FishingLootTable UNIQUE_FISH = FishingLootTable.of(
        new int[] { 0, 0, 15, 30 },
        new FishingItemReward(new int[] { 6 }, Fishes.PUFFERFISH, true),
        new FishingItemReward(new int[] { 12 }, Fishes.WHO_THAT_FISHEMON, true),
        new FishingItemReward(new int[] { 12 }, Fishes.CLOWN_FISH, true),
        new FishingItemReward(new int[] { 12 }, Fishes.HANDSOME_SQUIDWARD, true),
        new FishingItemReward(new int[] { 12 }, Fishes.CATFISH, true),
        new FishingItemReward(new int[] { 10 }, Fishes.SHARK, true),
        new FishingItemReward(new int[] { 10 }, Fishes.RED_HERRING, true),
        new FishingItemReward(new int[] { 10 }, Fishes.HSIF, true),
        new FishingItemReward(new int[] { 12 }, Fishes.RUBBER_DUCKY, true),
        new FishingItemReward(new int[] { 4 }, Fishes.THE_GREAT_OLD_ONE, true)
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
        RARE_FISH,
        LEGENDARY_FISH,
        UNIQUE_FISH,
        TREASURE,
        JUNK,
        HARMFUL
    );
    
}
