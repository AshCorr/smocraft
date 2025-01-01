package rocks.ashleigh.smocraft;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import org.bukkit.inventory.ItemStack;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import io.papermc.paper.command.brigadier.MessageComponentSerializer;
import io.papermc.paper.command.brigadier.argument.CustomArgumentType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import rocks.ashleigh.smocraft.fishing.items.standard.Cod;
import rocks.ashleigh.smocraft.fishing.items.standard.CodRare;
import rocks.ashleigh.smocraft.fishing.items.standard.CodUncommon;
import rocks.ashleigh.smocraft.fishing.items.standard.Pufferfish;
import rocks.ashleigh.smocraft.fishing.items.standard.PufferfishRare;
import rocks.ashleigh.smocraft.fishing.items.standard.PufferfishUncommon;
import rocks.ashleigh.smocraft.fishing.items.standard.Salmon;
import rocks.ashleigh.smocraft.fishing.items.standard.SalmonRare;
import rocks.ashleigh.smocraft.fishing.items.standard.SalmonUncommon;
import rocks.ashleigh.smocraft.fishing.items.standard.TropicalFish;
import rocks.ashleigh.smocraft.fishing.items.standard.TropicalFishRare;
import rocks.ashleigh.smocraft.fishing.items.standard.TropicalFishUncommon;
import rocks.ashleigh.smocraft.fishing.items.unique.Catfish;
import rocks.ashleigh.smocraft.fishing.items.unique.Clownfish;
import rocks.ashleigh.smocraft.fishing.items.unique.GoldenPufferfish;
import rocks.ashleigh.smocraft.fishing.items.unique.HandsomeSquidward;
import rocks.ashleigh.smocraft.fishing.items.unique.Hsif;
import rocks.ashleigh.smocraft.fishing.items.unique.RedHerring;
import rocks.ashleigh.smocraft.fishing.items.unique.RubberDucky;
import rocks.ashleigh.smocraft.fishing.items.unique.Shark;
import rocks.ashleigh.smocraft.fishing.items.unique.TheGreatOldOne;
import rocks.ashleigh.smocraft.fishing.items.unique.WhoThatFishemon;
import rocks.ashleigh.smocraft.lib.CustomItem;
import rocks.ashleigh.smocraft.spellcraft.items.Spellbook;

public enum SmocraftItemRegistry {
    COD(new Cod()),
    COD_UNCOMMON(new CodUncommon()),
    COD_RARE(new CodRare()),
    SALMON(new Salmon()),
    SALMON_UNCOMMON(new SalmonUncommon()),
    SALMON_RARE(new SalmonRare()),
    TROPICAL_FISH(new TropicalFish()),
    TROPICAL_FISH_UNCOMMON(new TropicalFishUncommon()),
    TROPICAL_FISH_RARE(new TropicalFishRare()),
    PUFFERFISH(new Pufferfish()),
    PUFFERFISH_UNCOMMON(new PufferfishUncommon()),
    PUFFERFISH_RARE(new PufferfishRare()),
    CATFISH(new Catfish()),
    CLOWNFISH(new Clownfish()),
    GOLDEN_PUFFERFISH(new GoldenPufferfish()),
    HANDSOME_SQUIDWARD(new HandsomeSquidward()),
    HSIF(new Hsif()),
    RUBBER_DUCKY(new RubberDucky()),
    RED_HERRING(new RedHerring()),
    SHARK(new Shark()),
    THE_GREAT_OLD_ONE(new TheGreatOldOne()),
    WHO_THAT_FISHEMON(new WhoThatFishemon()),
    SPELLBOOK(new Spellbook());

    private CustomItem item;

    private SmocraftItemRegistry(CustomItem item) {
        this.item = item;
    }

    public CustomItem getCustomItem() {
        return item;
    }

    public ItemStack getItem() {
        return item.getItem();
    }

    public static class Argument implements CustomArgumentType.Converted<SmocraftItemRegistry, String> {
        @Override
        public ArgumentType<String> getNativeType() {
            return StringArgumentType.word();
        }

        @Override
        public SmocraftItemRegistry convert(String nativeType) throws CommandSyntaxException {
            try {
                return SmocraftItemRegistry.valueOf(nativeType.toUpperCase(Locale.ENGLISH));
            } catch (IllegalArgumentException ignored) {
                Message message = MessageComponentSerializer.message()
                        .serialize(Component.text("Invalid item %s!".formatted(nativeType), NamedTextColor.RED));

                throw new CommandSyntaxException(new SimpleCommandExceptionType(message), message);
            }
        }

        @Override
        public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context,
                SuggestionsBuilder builder) {
            for (SmocraftItemRegistry item : SmocraftItemRegistry.values()) {
                builder.suggest(item.name());
            }

            return builder.buildFuture();
        }

    }
}
