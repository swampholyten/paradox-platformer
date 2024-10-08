package com.project.paradoxplatformer.model.effect.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.project.paradoxplatformer.controller.event.EventManager;
import com.project.paradoxplatformer.controller.event.GameEventType;
import com.project.paradoxplatformer.model.effect.abstracts.AbstractPlayerEffect;
import com.project.paradoxplatformer.model.entity.CollectableGameObject;
import com.project.paradoxplatformer.utils.collision.api.CollidableGameObject;
import com.project.paradoxplatformer.view.javafx.PageIdentifier;

/**
 * Such effects permits the player to collect {@code CollectableGameObject} to
 * update its inventory
 * and erase it from the (Model) world objects.
 * 
 * @see com.project.paradoxplatformer.model.entity.CollectableGameObject
 */
public final class CollectingEffect extends AbstractPlayerEffect {

    /**
     * {@inheritDoc}
     */
    @Override
    protected CompletableFuture<Void> applyToGameObject(final CollidableGameObject gameObject) {
        return CompletableFuture.runAsync(() -> {
            Optional.of(gameObject)
                    .filter(CollectableGameObject.class::isInstance)
                    .filter(g -> getPlayer().isPresent())
                    .map(CollectableGameObject.class::cast)
                    .ifPresent(getPlayer().get()::collectItem);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected CompletableFuture<Void> applyToSelf(final Optional<? extends CollidableGameObject> self) {
        return super.applyToSelf(self)
                .thenAccept(obj -> EventManager.getInstance()
                        .publish(GameEventType.REMOVE_OBJECT, PageIdentifier.GAME, self));
    }

}
