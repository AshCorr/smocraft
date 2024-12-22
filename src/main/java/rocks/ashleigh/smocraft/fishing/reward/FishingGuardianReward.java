package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Guardian;
import org.bukkit.loot.LootContext;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingGuardianReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Guardian guardian = (Guardian) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.GUARDIAN);

        hook.setHookedEntity(guardian);
        hook.pullHookedEntity();
        hook.pullHookedEntity();
    }
    
}
