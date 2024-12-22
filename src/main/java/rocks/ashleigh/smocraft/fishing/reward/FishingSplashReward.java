package rocks.ashleigh.smocraft.fishing.reward;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.SplashPotion;
import org.bukkit.entity.Squid;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import rocks.ashleigh.smocraft.lib.Lootable;

public class FishingSplashReward implements Lootable  {

    @Override
    public int getWeight(int luck) {
        return 20;
    }

    private static final PotionEffectType[] effects = {
        PotionEffectType.ABSORPTION,
        PotionEffectType.BAD_OMEN,
        PotionEffectType.BLINDNESS,
        PotionEffectType.CONDUIT_POWER,
        PotionEffectType.DARKNESS,
        PotionEffectType.DOLPHINS_GRACE,
        PotionEffectType.FIRE_RESISTANCE,
        PotionEffectType.GLOWING,
        PotionEffectType.HASTE,
        PotionEffectType.HEALTH_BOOST,
        PotionEffectType.HERO_OF_THE_VILLAGE,
        PotionEffectType.HUNGER,
        PotionEffectType.INFESTED,
        PotionEffectType.INSTANT_DAMAGE,
        PotionEffectType.INSTANT_HEALTH,
        PotionEffectType.INVISIBILITY,
        PotionEffectType.JUMP_BOOST,
        PotionEffectType.LEVITATION,
        PotionEffectType.LUCK,
        PotionEffectType.MINING_FATIGUE,
        PotionEffectType.NAUSEA,
        PotionEffectType.NIGHT_VISION,
        PotionEffectType.OOZING,
        PotionEffectType.POISON,
        PotionEffectType.RAID_OMEN,
        PotionEffectType.REGENERATION,
        PotionEffectType.RESISTANCE,
        PotionEffectType.SATURATION,
        PotionEffectType.RESISTANCE,
        PotionEffectType.SATURATION,
        PotionEffectType.SLOWNESS,
        PotionEffectType.SLOW_FALLING,
        PotionEffectType.SPEED,
        PotionEffectType.STRENGTH,
        PotionEffectType.TRIAL_OMEN,
        PotionEffectType.UNLUCK,
        PotionEffectType.WATER_BREATHING,
        PotionEffectType.WEAKNESS,
        PotionEffectType.WEAVING,
        PotionEffectType.WIND_CHARGED,
        PotionEffectType.WITHER,
    };

    @Override
    public void pick(LootContext context) {
        FishHook hook = (FishHook) context.getLootedEntity();

        Material material = Math.random() < 0.5 ? Material.LINGERING_POTION : Material.SPLASH_POTION;

        PotionEffectType effectType = effects[(int) (Math.random() * effects.length)];
        PotionEffect effect = new PotionEffect(effectType, 30 * 20, 1);
        ItemStack potion = new ItemStack(material);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.addCustomEffect(effect, false);
        potion.setItemMeta(meta);

        ThrownPotion entity = (ThrownPotion) context.getLocation().getWorld().spawnEntity(context.getLocation(), EntityType.POTION);
        entity.setItem(potion);

        hook.setHookedEntity(entity);
        hook.pullHookedEntity();
        hook.pullHookedEntity();
    }
    
}
