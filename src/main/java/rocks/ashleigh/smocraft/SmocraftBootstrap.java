package rocks.ashleigh.smocraft;

import org.bukkit.inventory.EquipmentSlotGroup;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.data.EnchantmentRegistryEntry;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.keys.EnchantmentKeys;
import io.papermc.paper.registry.keys.tags.ItemTypeTagKeys;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;

public class SmocraftBootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(BootstrapContext context) {
         context.getLifecycleManager().registerEventHandler(RegistryEvents.ENCHANTMENT.freeze().newHandler(event -> {
            event.registry().register(
                EnchantmentKeys.create(Key.key("smocraft", "hooks")),
                b -> b.description(Component.text("Hooks"))
                    .supportedItems(event.getOrCreateTag(ItemTypeTagKeys.ENCHANTABLE_FISHING))
                    .anvilCost(1)
                    .maxLevel(2)
                    .weight(10)
                    .minimumCost(EnchantmentRegistryEntry.EnchantmentCost.of(24, 74))
                    .maximumCost(EnchantmentRegistryEntry.EnchantmentCost.of(33, 83))
                    .activeSlots(EquipmentSlotGroup.HAND)
            );
        }));
    }
    
}
