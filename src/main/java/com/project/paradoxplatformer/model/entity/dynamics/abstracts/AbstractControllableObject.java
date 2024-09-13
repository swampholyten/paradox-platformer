package com.project.paradoxplatformer.model.entity.dynamics.abstracts;

import com.project.paradoxplatformer.controller.games.GameEventListener;
import com.project.paradoxplatformer.model.entity.dynamics.ControllableObject;
import com.project.paradoxplatformer.utils.geometries.vector.api.Simple2DVector;
import com.project.paradoxplatformer.utils.geometries.vector.api.Vector2D;
import com.project.paradoxplatformer.model.entity.dynamics.behavior.JumpBehavior;

//REMINDER
//should extend horizonal and vertical merged abstract class
public abstract class AbstractControllableObject extends AbstractHorizontalObject implements ControllableObject {


    protected Vector2D verticalSpeed;
    private JumpBehavior jumpBehavior;
    private GameEventListener gameEventListener;

    protected AbstractControllableObject(final Vector2D initDisplacement, final HorizonalStats stats) {
        super(stats.limit(), stats.delta());
        this.verticalSpeed = new Simple2DVector(0., 0.);
    }

    //should implement by abstract class
    @Override
    public void jump() {

        jumpBehavior.jump().ifPresent(vector -> {
            this.verticalSpeed = vector;
        });
    }

    @Override
    public void fall() {
        this.verticalSpeed = this.jumpBehavior.fall();
    }
    
    @Override
    public void setJumpBehavior(JumpBehavior jb) {
        this.jumpBehavior = jb;
    }

    public void setGameEventListener(GameEventListener listener) {
        this.gameEventListener = listener;
        
    }

    @Override
    public void onCollision() {
        if (gameEventListener != null) {
            System.out.println("Player death event triggered.");
            gameEventListener.onPlayerDeath(); // Notifica l'evento al controller
        } else {
            System.out.println("No GameEventListener attached.");
        }
    }

}