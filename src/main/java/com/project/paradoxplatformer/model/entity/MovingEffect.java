package com.project.paradoxplatformer.model.entity;

import java.util.Queue;

import org.apache.commons.lang3.tuple.Pair;

import com.project.paradoxplatformer.utils.geometries.Dimension;
import com.project.paradoxplatformer.utils.geometries.coordinates.Coord2D;
import com.project.paradoxplatformer.utils.geometries.vector.api.Simple2DVector;
import com.project.paradoxplatformer.utils.geometries.vector.api.Vector2D;

public abstract class MovingEffect{
    
    protected final Queue<TrajectoryInfo> trasformationStats;
    protected Vector2D displacement;
    protected Vector2D heightVector;
    protected Vector2D widthVector;
    //TODO fro withd and x also
    private final double anchorY;
    private final double anchorHeight;

    protected MovingEffect(final Coord2D position, final Dimension dimension, Queue<TrajectoryInfo> trasfStats) {
        super();
        this.displacement = new Simple2DVector(position.x(), position.y());
        this.anchorY = position.y();
        this.anchorHeight = dimension.height();
        this.heightVector = new Simple2DVector(0.d, dimension.height());
        this.widthVector = new Simple2DVector(dimension.width(), 0.);
        this.trasformationStats = trasfStats;
    }

    // //RREMINEDER ADD ABSTRACT METHODS
    // 

}
