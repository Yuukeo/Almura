/**
 * This file is part of Almura, All Rights Reserved.
 *
 * Copyright (c) AlmuraDev <http://github.com/AlmuraDev/>
 */
package com.almuradev.almura;

import com.almuradev.almura.api.block.BuildableBlockType;
import com.almuradev.almura.api.block.rotable.RotableBlockType;
import com.almuradev.almura.api.creativetab.CreativeTab;
import com.almuradev.almura.block.builder.AbstractBlockTypeBuilder;
import com.almuradev.almura.block.builder.rotable.AbstractRotableTypeBuilder;
import com.almuradev.almura.configuration.AbstractConfiguration;
import com.almuradev.almura.configuration.MappedConfigurationAdapter;
import com.almuradev.almura.network.NetworkUtil;
import com.almuradev.almura.network.play.SWorldInformationMessage;
import com.almuradev.almura.pack.PackManager;
import com.almuradev.almura.registry.CreativeTabRegistryModule;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.Order;
import org.spongepowered.api.event.entity.MoveEntityEvent;
import org.spongepowered.api.event.entity.living.humanoid.player.RespawnPlayerEvent;
import org.spongepowered.api.event.filter.Getter;
import org.spongepowered.api.event.game.state.GameConstructionEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.network.ChannelBinding;
import org.spongepowered.api.network.ChannelRegistrationException;

/**
 * The common platform of Almura. All code meant to run on the client and both dedicated and integrated server go here.
 */
public abstract class CommonProxy {

    protected ChannelBinding.IndexedMessageChannel network;

    protected void onGameConstruction(GameConstructionEvent event) {
        registerFileSystem();
        registerMessages();
        registerModules();
        registerBuilders();
        registerListeners();

    }

    protected void onGamePreInitialization(GamePreInitializationEvent event) {
        PackManager.loadPacks(FileSystem.PATH_CONFIG_PACKS);
    }

    public abstract MappedConfigurationAdapter<? extends AbstractConfiguration> getPlatformConfigAdapter();

    public ChannelBinding.IndexedMessageChannel getNetwork() {
        return this.network;
    }

    protected void registerFileSystem() {
        FileSystem.construct();
    }

    protected void registerMessages() {
        if (!Sponge.getGame().getChannelRegistrar().isChannelAvailable("AM|FOR")) {
            throw new ChannelRegistrationException("Some other mod/plugin has registered Almura's networking channel [AM|FOR]");
        }

        network = Sponge.getGame().getChannelRegistrar().createChannel(Almura.instance.container, "AM|FOR");

        this.network.registerMessage(SWorldInformationMessage.class, 0);
    }

    protected void registerModules() {
        Sponge.getRegistry().registerModule(CreativeTab.class, CreativeTabRegistryModule.getInstance());
    }

    protected void registerBuilders() {
        Sponge.getRegistry().registerBuilderSupplier(BuildableBlockType.Builder.class, AbstractBlockTypeBuilder.BuilderImpl::new);
        Sponge.getRegistry().registerBuilderSupplier(RotableBlockType.Builder.class, AbstractRotableTypeBuilder.BuilderImpl::new);
    }

    protected void registerListeners() {
        Sponge.getEventManager().registerListeners(Almura.instance.container, this);
    }

    @Listener(order = Order.LAST)
    public void onClientConnectionJoin(ClientConnectionEvent.Join event) {
        NetworkUtil.sendWorldHUDData(event.getTargetEntity(), event.getTargetEntity().getTransform());
    }

    @Listener(order = Order.LAST)
    public void onMoveEntity(MoveEntityEvent.Teleport event, @Getter("getTargetEntity") Player player) {
        if (!event.getFromTransform().getExtent().equals(event.getToTransform().getExtent())) {
            NetworkUtil.sendWorldHUDData(player, event.getToTransform());
        }
    }

    @Listener(order = Order.LAST)
    public void onRespawnPlayer(RespawnPlayerEvent event) {
        if (!event.getFromTransform().getExtent().equals(event.getToTransform().getExtent())) {
            NetworkUtil.sendWorldHUDData(event.getTargetEntity(), event.getToTransform());
        }
    }
}
