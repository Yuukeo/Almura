/*
 * This file is part of Almura.
 *
 * Copyright (c) AlmuraDev <https://github.com/AlmuraDev/>
 *
 * All Rights Reserved.
 */
package com.almuradev.content.type.generation.type.feature.deadbush.processor;

import com.almuradev.content.registry.delegate.CatalogDelegate;
import com.almuradev.content.type.deadbush.DeadBush;
import com.almuradev.content.type.generation.type.feature.deadbush.DeadBushGenerator;
import com.almuradev.content.type.generation.type.feature.deadbush.DeadBushGeneratorConfig;
import com.almuradev.toolbox.config.tag.ConfigTag;
import ninja.leaping.configurate.ConfigurationNode;

public final class DeadProcessor implements AbstractDeadBushProcessor {

    private static final ConfigTag TAG = ConfigTag.create(DeadBushGeneratorConfig.DEADBUSH);

    @Override
    public ConfigTag tag() {
        return TAG;
    }

    @Override
    public void processTagged(final ConfigurationNode config, final DeadBushGenerator.Builder builder) {
        builder.deadBush(CatalogDelegate.namespaced(DeadBush.class, config));
    }
}
