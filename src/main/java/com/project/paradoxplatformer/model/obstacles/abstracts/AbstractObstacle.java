package com.project.paradoxplatformer.model.obstacles.abstracts;

import com.project.paradoxplatformer.model.entity.AbstractPathObject;
import com.project.paradoxplatformer.model.entity.TrajectoryInfo;
import com.project.paradoxplatformer.model.obstacles.api.Obstacle;
import com.project.paradoxplatformer.utils.world.Dimension;
import com.project.paradoxplatformer.utils.world.coordinates.Coord2D;
import com.project.paradoxplatformer.utils.world.vector.Simple2DVector;
import java.util.Optional;

public abstract class AbstractObstacle extends AbstractPathObject implements Obstacle {

    //position inevitablly immutable expept for static purpose
    protected Dimension dimension;
    protected Coord2D  position;

    protected AbstractObstacle(final Coord2D position, final Dimension dimension, final Optional<TrajectoryInfo> trajStats) {
        super(new Simple2DVector(position.x(), position.y()), trajStats);
        this.position = position;
        this.dimension = dimension;
    }

    @Override
    public Coord2D getPosition() {
        return this.position;
    }

    @Override
    public Dimension getDimension() {
        return this.dimension;
    }

    @Override
    public void effect() {
        trajStats.ifPresent(i -> isIdle = false);
    }
    
}
