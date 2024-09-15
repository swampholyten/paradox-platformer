package com.project.paradoxplatformer.controller;

import java.util.Optional;

import com.project.paradoxplatformer.controller.event.EventManager;
import com.project.paradoxplatformer.controller.event.GameEventType;
import com.project.paradoxplatformer.model.effect.api.Level;
import com.project.paradoxplatformer.model.obstacles.Obstacle;
import com.project.paradoxplatformer.utils.collision.api.CollidableGameObject;
import com.project.paradoxplatformer.view.javafx.PageIdentifier;

/**
 * Manages subscriptions to game events.
 */
public class GameEventSubscriber {

    private final GameListener gameEventListener;
    private final EventManager<GameEventType, PageIdentifier> eventManager;

    public GameEventSubscriber(GameListener gameEventListener) {
        this.gameEventListener = gameEventListener;
        this.eventManager = EventManager.getInstance();
        subscribeToEvents();
    }

    private void subscribeToEvents() {
        eventManager.subscribe(GameEventType.STOP_VIEW, this::handleStopView);
        eventManager.subscribe(GameEventType.REMOVE_OBJECT, this::handleRemoveObject);
        eventManager.subscribe(GameEventType.TRIGGER_EFFECT, this::handleTriggerEffect);
    }

    private void handleStopView(PageIdentifier id, Level param) {
        gameEventListener.handleStopView(id, param);
    }

    private void handleRemoveObject(PageIdentifier id, Optional<? extends CollidableGameObject> object) {
        gameEventListener.handleRemoveObject(id, object);
    }

    private void handleTriggerEffect(PageIdentifier id, Obstacle param) {
        gameEventListener.handleTriggerEffect(id, param);
    }
}