package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.entity.FishHook;
import org.bukkit.loot.LootContext;
import org.bukkit.potion.PotionEffectType;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingCursedByTheSeaReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 10;
    }

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();


        context.getKiller().addPotionEffect(PotionEffectType.BAD_OMEN.createEffect(30 * 60 * 20, 1));
        context.getKiller().sendMessage(Component.text("You feel an evil presence watching you...").decorate(TextDecoration.ITALIC));
        hook.setHookedEntity(null);
    }
    
}
