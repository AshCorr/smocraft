package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.Drowned;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingDrownedReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Drowned drowned = (Drowned) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.DROWNED);

        hook.setHookedEntity(drowned);
        hook.pullHookedEntity();
        hook.pullHookedEntity();
    }
    
}
