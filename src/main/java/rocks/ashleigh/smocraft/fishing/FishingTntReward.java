package rocks.ashleigh.smocraft.fishing;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Wither;
import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.Smocraft;
import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingTntReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 1;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Wither wither = (Wither) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.WITHER);
        wither.setAggressive(false);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Smocraft.plugin, () -> wither.remove(), 100);

        hook.setHookedEntity(wither);
    }
    
}
