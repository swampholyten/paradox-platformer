package com.project.paradoxplatformer.model.trigger;

import com.project.paradoxplatformer.model.entity.MutableObject;
import com.project.paradoxplatformer.model.obstacles.Obstacle;

/**
 * The Trigger interface represents an entity that can activate certain actions
 * or events when specific conditions are met.
 * 
 * <p>
 * Triggers are associated with obstacles and are responsible for activating
 * them when necessary. This interface also extends {@link MutableObject},
 * allowing
 * for additional properties or behaviors related to the game's mutable
 * entities.
 * </p>
 */
public interface Trigger extends MutableObject {

    /**
     * Activates the trigger, causing the associated action or event to occur.
     * <p>
     * For example, this could activate one or more obstacles when a certain
     * condition in the game is met.
     * </p>
     */
    void activate();

    /**
     * Associates an obstacle with this trigger, allowing it to activate the
     * obstacle's effects when triggered.
     * 
     * @param obstacle the obstacle to associate with this trigger
     */
    void addObstacle(Obstacle obstacle);
}