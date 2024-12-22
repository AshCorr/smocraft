package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Squid;
import org.bukkit.loot.LootContext;
import org.bukkit.potion.PotionEffectType;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingSquidReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Squid wither = (Squid) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.SQUID);

        context.getKiller().addPotionEffect(PotionEffectType.BLINDNESS.createEffect(30 * 20, 1));
        hook.setHookedEntity(wither);
        hook.pullHookedEntity();
    }
    
}
