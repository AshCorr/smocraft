package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingLightningReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        context.getLocation().getWorld().strikeLightning(context.getKiller().getLocation());
    }
    
}
