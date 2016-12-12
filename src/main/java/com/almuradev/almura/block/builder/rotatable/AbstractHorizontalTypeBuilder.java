/**
 * This file is part of Almura, All Rights Reserved.
 *
 * Copyright (c) AlmuraDev <http://github.com/AlmuraDev/>
 */
package com.almuradev.almura.block.builder.rotatable;

import static com.google.common.base.Preconditions.checkNotNull;

import com.almuradev.almura.Almura;
import com.almuradev.almura.api.block.rotatable.HorizontalBlockType;
import com.almuradev.almura.block.GenericHorizontal;
import com.almuradev.almura.block.builder.AbstractBlockTypeBuilder;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

@SuppressWarnings("unchecked")
public abstract class AbstractHorizontalTypeBuilder<HORIZONTAL extends HorizontalBlockType, BUILDER extends AbstractHorizontalTypeBuilder<HORIZONTAL,
        BUILDER>> extends AbstractBlockTypeBuilder<HORIZONTAL, BUILDER> implements HorizontalBlockType.Builder<HORIZONTAL, BUILDER> {

    public static final class BuilderImpl extends AbstractHorizontalTypeBuilder<HorizontalBlockType, BuilderImpl> {

        @Override
        public HorizontalBlockType build(String id) {
            checkNotNull(id);

            final GenericHorizontal block = GameRegistry.register(new GenericHorizontal(Almura.PLUGIN_ID, id, this));

            final ItemBlock itemBlock = new ItemBlock(block);
            itemBlock.setRegistryName(Almura.PLUGIN_ID, id);

            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(Almura.PLUGIN_ID + ":" + id, "facing=south"));

            // TODO Make this configurable and make Almura GenericItemBlock
            GameRegistry.register(itemBlock);

            return (HorizontalBlockType) (Object) block;
        }
    }
}