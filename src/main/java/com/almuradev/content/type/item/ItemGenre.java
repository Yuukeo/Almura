/*
 * This file is part of Almura.
 *
 * Copyright (c) AlmuraDev <https://github.com/AlmuraDev/>
 *
 * All Rights Reserved.
 */
package com.almuradev.content.type.item;

import com.almuradev.content.ContentType;
import com.almuradev.content.type.item.type.food.FoodItem;
import com.almuradev.content.type.item.type.normal.NormalItem;
import com.almuradev.content.type.item.type.seed.SeedItem;
import com.almuradev.content.type.item.type.tool.type.hoe.HoeToolItem;
import com.almuradev.content.type.item.type.tool.type.pickaxe.PickaxeToolItem;
import com.almuradev.content.type.item.type.tool.type.shovel.ShovelToolItem;

/**
 * An enumeration of item types.
 */
@ContentType.MultiType.Name("items")
public enum ItemGenre implements ContentType.MultiType<ContentItemType, ContentItemType.Builder<ContentItemType>> {
    /**
     * An item type representing a normal item.
     */
    NORMAL("normal", NormalItem.Builder.class),
    /**
     * An item type representing a piece of food.
     */
    FOOD("food", FoodItem.Builder.class),
    /**
     * An item type representing a seed.
     */
    SEED("seed", SeedItem.Builder.class),
    /**
     * HOE HOE HOE
     */
    TOOL_HOE("tool_hoe", HoeToolItem.Builder.class),
    /**
     * An item type representing a pickaxe.
     */
    TOOL_PICKAXE("tool_pickaxe", PickaxeToolItem.Builder.class),
    /**
     * An item type representing a shovel.
     */
    TOOL_SHOVEL("tool_shovel", ShovelToolItem.Builder.class);

    /**
     * The id of this item type.
     *
     * <p>The id is used for identification and loading.</p>
     */
    private final String id;
    private final Class<? extends ContentItemType.Builder<? extends ContentItemType>> builder;

    ItemGenre(final String id, final Class<? extends ContentItemType.Builder<? extends ContentItemType>> builder) {
        this.id = id;
        this.builder = builder;
    }

    @Override
    public String id() {
        return this.id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<ContentItemType.Builder<ContentItemType>> builder() {
        return (Class<ContentItemType.Builder<ContentItemType>>) this.builder;
    }
}