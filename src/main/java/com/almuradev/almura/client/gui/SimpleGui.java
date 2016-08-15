/**
 * This file is part of Almura, All Rights Reserved.
 *
 * Copyright (c) AlmuraDev <http://github.com/AlmuraDev/>
 */
package com.almuradev.almura.client.gui;

import com.almuradev.almura.Almura;
import com.google.common.base.Optional;
import net.malisis.core.client.gui.Anchor;
import net.malisis.core.client.gui.GuiTexture;
import net.malisis.core.client.gui.MalisisGui;
import net.malisis.core.client.gui.component.UIComponent;
import net.malisis.core.renderer.icon.GuiIcon;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public abstract class SimpleGui extends MalisisGui {

    public static final ResourceLocation LOCATION_GUI_SPRITE_SHEET;
    public static final ResourceLocation ALMURA_LOGO_LOCATION;
    public static final ResourceLocation ALMURA_MAN_LOCATION;
    public static final ResourceLocation SPONGIE_LOCATION;
    public static final ResourceLocation SPONGEPOWERED_LOGO_LOCATION;
    public static final ResourceLocation BLOOD_HEAD_LOCATION;
    public static final ResourceLocation DOCKTER_HEAD_LOCATION;
    public static final ResourceLocation GRINCH_HEAD_LOCATION;
    public static final ResourceLocation MUMFREY_HEAD_LOCATION;
    public static final ResourceLocation WIFEE_HEAD_LOCATION;
    public static final ResourceLocation ZIDANE_HEAD_LOCATION;
    public static final GuiTexture TEXTURE_SPRITESHEET;

    public static final GuiIcon ICON_EMPTY;
    public static final GuiIcon ICON_BAR;
    public static final GuiIcon ICON_HEART;
    public static final GuiIcon ICON_ARMOR;
    public static final GuiIcon ICON_HUNGER;
    public static final GuiIcon ICON_STAMINA;
    public static final GuiIcon ICON_XP;
    public static final GuiIcon ICON_PLAYER;
    public static final GuiIcon ICON_COMPASS;
    public static final GuiIcon ICON_MAP;
    public static final GuiIcon ICON_WORLD;
    public static final GuiIcon ICON_CLOCK;
    public static final GuiIcon ICON_CLOSE_NORMAL;
    public static final GuiIcon ICON_CLOSE_HOVER;
    public static final GuiIcon ICON_CLOSE_PRESSED;
    public static final GuiIcon ICON_FORUM;
    public static final GuiIcon ICON_FA_GITHUB;
    public static final GuiIcon ICON_FA_COG;
    public static final GuiIcon ICON_FA_SITEMAP;
    public static final GuiIcon ICON_FA_MAP;
    public static final GuiIcon ICON_FA_PIE_CHART;
    public static final GuiIcon ICON_FA_TROPHY;
    public static final GuiIcon ICON_FA_BOOK;
    public static final GuiIcon ICON_FA_SHOPPING_BAG;
    public static final GuiIcon ICON_HEAD_ZIDANE;

    static {
        LOCATION_GUI_SPRITE_SHEET = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/gui.png");
        ALMURA_LOGO_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/almura_logo.png");
        ALMURA_MAN_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/almura_man.png");
        SPONGIE_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/spongie.png");
        SPONGEPOWERED_LOGO_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/spongepowered_logo.png");
        BLOOD_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/blood_head.png");
        DOCKTER_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/dockter_head.png");
        GRINCH_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/grinch_head.png");
        MUMFREY_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/mumfrey_head.png");
        WIFEE_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/wifee_head.png");
        ZIDANE_HEAD_LOCATION = new ResourceLocation(Almura.PLUGIN_ID, "textures/gui/about/zidane_head.png");

        TEXTURE_SPRITESHEET = new GuiTexture(LOCATION_GUI_SPRITE_SHEET, 300, 144);

        ICON_EMPTY = TEXTURE_SPRITESHEET.getIcon(299, 141, 1, 1);
        ICON_BAR = TEXTURE_SPRITESHEET.getIcon(0, 126, 256, 14);
        ICON_HEART = TEXTURE_SPRITESHEET.getIcon(149, 62, 26, 26);
        ICON_ARMOR = TEXTURE_SPRITESHEET.getIcon(64, 63, 20, 27);
        ICON_HUNGER = TEXTURE_SPRITESHEET.getIcon(198, 96, 28, 29);
        ICON_STAMINA = TEXTURE_SPRITESHEET.getIcon(99, 93, 32, 31);
        ICON_XP = TEXTURE_SPRITESHEET.getIcon(169, 98, 24, 24);
        ICON_PLAYER = TEXTURE_SPRITESHEET.getIcon(67, 92, 28, 32);
        ICON_COMPASS = TEXTURE_SPRITESHEET.getIcon(118, 66, 30, 26);
        ICON_MAP = TEXTURE_SPRITESHEET.getIcon(0, 95, 32, 26);
        ICON_WORLD = TEXTURE_SPRITESHEET.getIcon(133, 93, 32, 32);
        ICON_CLOCK = TEXTURE_SPRITESHEET.getIcon(86, 64, 28, 26);
        ICON_CLOSE_NORMAL = TEXTURE_SPRITESHEET.getIcon(239, 69, 45, 19);
        ICON_CLOSE_HOVER = TEXTURE_SPRITESHEET.getIcon(239, 88, 45, 19);
        ICON_CLOSE_PRESSED = TEXTURE_SPRITESHEET.getIcon(239, 107, 45, 19);
        ICON_FORUM = TEXTURE_SPRITESHEET.getIcon(284, 0, 16, 16);
        ICON_FA_GITHUB = TEXTURE_SPRITESHEET.getIcon(284, 16, 16, 16);
        ICON_FA_COG = TEXTURE_SPRITESHEET.getIcon(284, 32, 16, 16);
        ICON_FA_SITEMAP = TEXTURE_SPRITESHEET.getIcon(284, 48, 16, 16);
        ICON_FA_MAP = TEXTURE_SPRITESHEET.getIcon(284, 64, 16, 16);
        ICON_FA_PIE_CHART = TEXTURE_SPRITESHEET.getIcon(284, 80, 16, 16);
        ICON_FA_TROPHY = TEXTURE_SPRITESHEET.getIcon(284, 96, 16, 16);
        ICON_FA_BOOK = TEXTURE_SPRITESHEET.getIcon(284, 112, 16, 16);
        ICON_FA_SHOPPING_BAG = TEXTURE_SPRITESHEET.getIcon(284, 128, 16, 16);
        ICON_HEAD_ZIDANE = new GuiTexture(ZIDANE_HEAD_LOCATION).getIcon(0, 0, 64, 64);
    }

    protected final Optional<SimpleGui> parent;

    /**
     * Creates a gui with an absent parent
     */
    public SimpleGui() {
        this(null);
    }

    /**
     * Creates a gui with a parent
     *
     * @param parent the {@link SimpleGui} that we came from
     */
    public SimpleGui(SimpleGui parent) {
        this.parent = Optional.fromNullable(parent);
        renderer.setDefaultTexture(TEXTURE_SPRITESHEET);
        mc = Minecraft.getMinecraft();
    }

    public static int getPaddedX(UIComponent<?> component, int padding) {
        return getPaddedX(component, padding, Anchor.LEFT);
    }

    public static int getPaddedX(UIComponent<?> component, int padding, int anchor) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null!");
        } else if (anchor == Anchor.BOTTOM || anchor == Anchor.TOP) {
            throw new IllegalArgumentException("Anchor must be Anchor.LEFT or Anchor.RIGHT.");
        } else if (anchor == Anchor.RIGHT) {
            return component.getX() - component.getWidth() - padding;
        } else {
            return component.getX() + component.getWidth() + padding;
        }
    }

    public static int getPaddedY(UIComponent<?> component, int padding) {
        return getPaddedY(component, padding, Anchor.TOP);
    }

    public static int getPaddedY(UIComponent<?> component, int padding, int anchor) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null!");
        } else if (anchor == Anchor.LEFT || anchor == Anchor.RIGHT) {
            throw new IllegalArgumentException("Anchor must be Anchor.TOP or Anchor.BOTTOM.");
        } else if (anchor == Anchor.BOTTOM) {
            return component.getY() - component.getHeight() - padding;
        } else {
            return component.getY() + component.getHeight() + padding;
        }
    }

    /**
     * Closes this {@link SimpleGui} and displays the parent, if present.
     */
    @Override
    public final void close() {
        Keyboard.enableRepeatEvents(false);
        if (mc.thePlayer != null) {
            mc.thePlayer.closeScreen();
        }

        onClose();

        mc.displayGuiScreen(parent.isPresent() ? parent.get() : null);
        if (!parent.isPresent()) {
            mc.setIngameFocus();
        }
    }

    protected void onClose() {
    }
}

