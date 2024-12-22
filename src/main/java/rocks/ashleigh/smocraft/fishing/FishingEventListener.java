package rocks.ashleigh.smocraft.fishing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.FishHook.HookState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.util.Vector;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import net.kyori.adventure.key.Key;

public class FishingEventListener implements Listener {

    private final Enchantment hooks = RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT).get(Key.key("smocraft", "hooks"));

    @EventHandler
    public void onFish(PlayerFishEvent e) {
        if (e.getState() != PlayerFishEvent.State.CAUGHT_FISH && e.getState() != PlayerFishEvent.State.CAUGHT_ENTITY && e.getState() != PlayerFishEvent.State.REEL_IN) {
            return;
        }

        // This sucks, but I dont want to deal with storing active hooks indexed by players.
        List<FishHook> hooksOwnedByPlayer = e.getPlayer().getWorld().getEntitiesByClass(FishHook.class).stream().filter((hook) -> ((FishHook) hook).getShooter()
            .equals(e.getPlayer())).collect(Collectors.toList());

        for (FishHook hook : hooksOwnedByPlayer) {
            if (hook.getWaitTime() > 0 || hook.getTimeUntilBite() > 0) {
                hook.remove();
                continue;
            }

            LootContext context = new LootContext.Builder(e.getHook().getLocation())
                .lootedEntity(hook)
                .killer(e.getPlayer()).build();

            try {
                FishingLootTables.FISHING.pick(context);
            } catch(Error error) {
                e.getPlayer().sendMessage(error.getMessage());
                e.getPlayer().sendMessage("You caught nothing");
            }

            hook.remove();
        }
    }

    @EventHandler
    public void onFishSent(PlayerFishEvent e) { 
        if (e.getState() != PlayerFishEvent.State.FISHING) {
            return;
        }

        ItemStack rod = e.getPlayer().getInventory().getItem(e.getHand());
        int hooksLevel = rod.getEnchantmentLevel(hooks);

        for (int i = 0; i < hooksLevel; i++) {
            Vector velocity = e.getHook().getVelocity().clone();
            velocity = velocity.multiply(new Vector(
                Math.random() * 0.6 + 0.9,
                Math.random() * 0.6 + 0.9,
                Math.random() * 0.6 + 0.9
            ));

            FishHook hook = e.getPlayer().launchProjectile(FishHook.class, velocity);
            hook.setLureTime(e.getHook().getMinLureTime(), e.getHook().getMaxFreezeTicks());
            hook.setWaitTime(e.getHook().getMinWaitTime(), e.getHook().getMaxWaitTime());
            hook.setLureAngle(e.getHook().getMinLureAngle(), e.getHook().getMaxLureAngle());
        }
    }
}
