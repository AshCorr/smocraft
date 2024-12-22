package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Trident;
import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingTridentReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Trident trident = (Trident) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.TRIDENT);

        hook.setHookedEntity(trident);
        hook.pullHookedEntity();
        hook.pullHookedEntity();
    }
    
}
