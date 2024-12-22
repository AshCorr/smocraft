package rocks.ashleigh.smocraft;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import rocks.ashleigh.smocraft.fishing.FishingEventListener;

public final class Smocraft extends JavaPlugin {

    public static Smocraft plugin = null;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new FishingEventListener(), this);
        getServer().resetRecipes();
        
        // Glistening Cookie Recipe

        ItemStack glisteringCookie = new ItemStack(Material.COOKIE, 1);
        glisteringCookie.editMeta((meta) -> {
            meta.itemName(Component.text("Glistering Cookie", ItemRarity.COMMON.color()));
            meta.setRarity(ItemRarity.COMMON);
        });

        ShapedRecipe glisteringCookieRecipe = new ShapedRecipe(new NamespacedKey(this, "glistering_cookie"), glisteringCookie);
        glisteringCookieRecipe.shape("XXX", "XYX", "XXX");
        glisteringCookieRecipe.setIngredient('X', new ItemStack(Material.GOLD_NUGGET));
        glisteringCookieRecipe.setIngredient('Y', new ItemStack(Material.COOKIE));

        getServer().addRecipe(glisteringCookieRecipe, true);

        // Counterfit Cookie Recipe

        ItemStack counterfitCookie = new ItemStack(Material.COOKIE, 1);
        counterfitCookie.editMeta((meta) -> {
            meta.itemName(Component.text("Counterfit Cookie", NamedTextColor.GRAY));
            meta.setRarity(ItemRarity.COMMON);
        });

        ShapedRecipe counterfitCookieRecipe = new ShapedRecipe(new NamespacedKey(this, "counterfit_cookie"), counterfitCookie);
        counterfitCookieRecipe.shape("XXX", "XYX", "XXX");
        counterfitCookieRecipe.setIngredient('X', new ItemStack(Material.YELLOW_DYE));
        counterfitCookieRecipe.setIngredient('Y', new ItemStack(Material.COOKIE));

        getServer().addRecipe(counterfitCookieRecipe, true);

        // Golden Cookie Recipe

        ItemStack goldenCookie = new ItemStack(Material.COOKIE, 1);
        goldenCookie.editMeta((meta) -> {
            meta.itemName(Component.text("Golden Cookie", ItemRarity.UNCOMMON.color()));
            meta.setRarity(ItemRarity.UNCOMMON);
        });

        ShapedRecipe goldenCookieRecipe = new ShapedRecipe(new NamespacedKey(this, "golden_cookie"), goldenCookie);
        goldenCookieRecipe.shape("XXX", "XYX", "XXX");
        goldenCookieRecipe.setIngredient('X', new ItemStack(Material.GOLD_INGOT));
        goldenCookieRecipe.setIngredient('Y', new ItemStack(Material.COOKIE));

        getServer().addRecipe(goldenCookieRecipe, true);

        // Enchanted Golden Cookie Recipe

        ItemStack enchantedGoldenCookie = new ItemStack(Material.COOKIE, 1);
        enchantedGoldenCookie.editMeta((meta) -> {
            meta.itemName(Component.text("Enchanted Golden Cookie", ItemRarity.RARE.color()));
            meta.setRarity(ItemRarity.RARE);
            meta.setEnchantmentGlintOverride(true);
        });

        ShapedRecipe enchantedGoldenCookieRecipe = new ShapedRecipe(new NamespacedKey(this, "enchanted_golden_cookie"), enchantedGoldenCookie);
        enchantedGoldenCookieRecipe.shape("XXX", "XYX", "XXX");
        enchantedGoldenCookieRecipe.setIngredient('X', new ItemStack(Material.GOLD_BLOCK));
        enchantedGoldenCookieRecipe.setIngredient('Y', new ItemStack(Material.COOKIE));

        getServer().addRecipe(enchantedGoldenCookieRecipe, true);

        // Glistering Cookie -> Golden Cookie Recipe

        ShapelessRecipe glisteringCookieToGoldenCookieRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "glistering_to_golden_cookie"), goldenCookie);
        glisteringCookieToGoldenCookieRecipe.addIngredient(8,  glisteringCookie);
    
        getServer().addRecipe(glisteringCookieToGoldenCookieRecipe, true);

        // Golden Cookie -> Enchanted Golden Cookie Recipe

        ShapelessRecipe goldenCookieToEnchantedGoldenCookieRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "golden_to_enchanted_golden_cookie"), enchantedGoldenCookie);
        goldenCookieToEnchantedGoldenCookieRecipe.addIngredient(8,  goldenCookie);
    
        getServer().addRecipe(goldenCookieToEnchantedGoldenCookieRecipe, true);

        // Enchanted Golden Cookie -> Golden Cookie Recipe
        
        ShapelessRecipe enchantedGoldenCookieToGoldenCookieRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "enchanted_golden_to_golden_cookie"), goldenCookie.asQuantity(8));
        enchantedGoldenCookieToGoldenCookieRecipe.addIngredient(1,  enchantedGoldenCookie);
    
        getServer().addRecipe(enchantedGoldenCookieToGoldenCookieRecipe, true);

        // Enchanted Golden Cookie -> Golden Cookie Recipe

        ShapelessRecipe goldenCookieToGlisteringCookieRecipe = new ShapelessRecipe(new NamespacedKey(plugin, "golden_to_glistering_cookie"), glisteringCookie.asQuantity(8));
        goldenCookieToGlisteringCookieRecipe.addIngredient(1,  goldenCookie);
    
        getServer().addRecipe(goldenCookieToGlisteringCookieRecipe, true);
    }

    @Override
    public void onDisable() {
        
    }


}