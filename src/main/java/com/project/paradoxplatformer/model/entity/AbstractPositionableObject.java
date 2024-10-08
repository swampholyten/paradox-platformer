package com.project.paradoxplatformer.model.entity;

import com.project.paradoxplatformer.utils.collision.api.CollisionType;
import com.project.paradoxplatformer.utils.geometries.Dimension;
import com.project.paradoxplatformer.utils.geometries.coordinates.Coord2D;
import com.project.paradoxplatformer.utils.geometries.vector.api.Simple2DVector;
import com.project.paradoxplatformer.utils.geometries.vector.api.Vector2D;

/**
 * An abstract class representing a positionable game object with movement and
 * interpolation capabilities.
 * <p>
 * This class extends {@link AbstractMutableObject} to include functionality
 * for handling position, movement, and interpolation. It initializes the
 * physics engine and interpolation factory, and provides default
 * implementations
 * for position management.
 * </p>
 */
public abstract class AbstractPositionableObject extends AbstractMutableObject {

    private Vector2D displacement;
    private Coord2D position;

    /**
     * Constructs an {@code AbstractPositionableObject} with the specified initial
     * position.
     * 
     * @param key      the unique id of the positional game object
     * @param position the initial position of the object as a {@link Coord2D}
     *                 object
     */
    protected AbstractPositionableObject(final int key, final Coord2D position) {
        super(key);
        this.displacement = new Simple2DVector(position.x(), position.y());
        this.position = position;
    }

    /**
     * Returns the current position of this object.
     * 
     * @return the position as a {@link Coord2D} object
     */
    @Override
    public Coord2D getPosition() {
        return this.position;
    }

    /**
     * Returns the dimension of this object.
     * <p>
     * This method must be implemented by subclasses to provide the object's
     * dimension.
     * </p>
     * 
     * @return the dimension as a {@link Dimension} object
     */
    @Override
    public abstract Dimension getDimension();

    /**
     * Sets the dimension of this object.
     * <p>
     * This method must be implemented by subclasses to set the object's dimension.
     * </p>
     * 
     * @param dimension the new dimension to set as a {@link Dimension} object
     */
    @Override
    public abstract void setDimension(Dimension dimension);

    /**
     * Sets the position of this object.
     * 
     * @param position the new position to set as a {@link Coord2D} object
     */
    @Override
    public void setPosition(final Coord2D position) {
        this.position = position;
    }

    /**
     * Returns the collision type of this object.
     * <p>
     * This method must be implemented by subclasses to provide the object's
     * collision type.
     * </p>
     * 
     * @return the collision type as a {@link CollisionType} object
     */
    @Override
    public abstract CollisionType getCollisionType();

    /**
     * Updates the state of this object based on the time delta.
     * <p>
     * This method must be implemented by subclasses to define how the object's
     * state
     * changes over time.
     * </p>
     * 
     * @param dt the time delta to use for updating the state
     */
    @Override
    public abstract void updateState(long dt);

    /**
     * Returns the current displacement of this object.
     * <p>
     * This method can be overridden by subclasses to provide specific logic for how
     * the displacement is calculated or retrieved. Subclasses should ensure that
     * any changes to the displacement maintain the consistency of the object's
     * movement logic.
     * </p>
     * 
     * @return the displacement as a {@link Vector2D} object
     */
    protected Vector2D getDisplacement() {
        return displacement;
    }

    /**
     * Sets the displacement of this object.
     * <p>
     * This method can be overridden by subclasses to modify how displacement is
     * set,
     * if necessary. Subclasses should ensure that any changes to the displacement
     * maintain the consistency of the object's movement logic and do not violate
     * game physics or object state.
     * </p>
     * 
     * @param displacement the new displacement to set as a {@link Vector2D} object
     */
    protected void setDisplacement(final Vector2D displacement) {
        this.displacement = displacement;
    }

}
