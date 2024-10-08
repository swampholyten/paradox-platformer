package com.project.paradoxplatformer.controller.deserialization.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data Transfer Object regarding a specific game object, most used in platform
 * games.
 * Such class is used by the deserializer to retrive json objects,
 * so they must not be normally initiliazed.
 * Such class holds every spec a game object can have, it is very related to the
 * model entity, so such
 * class must reflect model entity structure.
 */
public final class GameDTO {
    private String type;
    private int id;
    private double x;
    private double y;
    private double width;
    private double height;
    private String subtype;
    private String image;
    private ColorDTO color;
    private final TrajMacro[] traj;
    @JsonProperty
    private SpriteDTO spriteMeta;
    private final int triggeringId;

    /**
     * Non-argument constructors which initialises the trajectory moves, making it
     * final.
     */
    public GameDTO() {
        this.traj = new TrajMacro[0];
        this.triggeringId = -1;
    }

    /**
     * Constructs a LevelDTO object with the specified parameters.
     * <p>
     * This constructor is not used by Jackson for deserialization.
     * </p>
     *
     * @param type          the type of the level
     * @param id            the unique identifier for the level
     * @param x             the x-coordinate position of the level
     * @param y             the y-coordinate position of the level
     * @param width         the width of the level
     * @param height        the height of the level
     * @param subtype       the subtype of the level
     * @param image         the image associated with the level
     * @param color         the color configuration of the level
     * @param traj          an array of {@link TrajMacro} objects representing trajectory macros
     * @param triggeringId  the ID of the trigger associated with the level
     */
    public GameDTO(
            final String type,
            final int id,
            final double x,
            final double y,
            final double width,
            final double height,
            final String subtype,
            final String image,
            final ColorDTO color,
            final TrajMacro[] traj,
            final int triggeringId) {
        this.type = type;
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.subtype = subtype;
        this.image = image;
        this.color = color;
        this.traj = traj != null ? traj.clone() : new TrajMacro[0];
        this.triggeringId = triggeringId;
    }

    /**
     * An unique id to identify the gameObject.
     * Very useful for join predicates and to reckon the game object in find
     * operations.
     * 
     * @return the unique id (a simple incremental value)
     */
    public int getID() {
        return this.id;
    }

    /**
     * Holds sequential moves of a modded obstacle, such object mus be null if
     * entity is not an obstacle nor
     * have a stored moving patterns.
     * 
     * @return an array containg the moves directions, should be handled as a queue,
     *         or even better an iterator
     */
    public TrajMacro[] getTraj() {
        return this.traj.clone();
    }

    /**
     * Gets a game object color. Such method must be called in view segment
     * Usually blocks, such as platforms, walls, ecc are only colored.
     * <p>
     * Note: It is paired with a rectangle view component meaning that a gameDTO
     * which has a (non-null)
     * color must not be an image nor an button ecc...
     * </p>
     * 
     * @return relative DTO color
     */
    public ColorDTO getColor() {
        return this.color;
    }

    /**
     * Gets a game object image. Such method must be called in view segment
     * Usually player, special obstacles, triggers and exit doors have an image.
     * <p>
     * Note: It is paired with a image view component meaning that such component
     * must be able to
     * retrive an image interface based on the path
     * </p>
     * 
     * @return the image file path, can be either .png, .jpeg. Note that such method
     *         does not provide a restriction upon file
     *         extention, such responsabilty must be handled whoever creates an
     *         image based on file path
     */
    public String getImage() {
        return this.image;
    }

    /**
     * Gets the type of the game object which helps to track the game object
     * supertype.
     * It could be either player, obstacle, trigger...
     * 
     * @return the super type attribute
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the x coordinate.
     * 
     * @return an double (specific) coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Gets the y coordinate.
     * 
     * @return an double (specific) coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Gets the default width dimension.
     * 
     * @return an double (specific) width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the default height dimension.
     * 
     * @return an double (specific) height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Gets the sub type of the obstacle which helps to identify the obstacle type.
     * 
     * <p>
     * NOTE: Such string must be equivalent to the obstacle type class name
     * (CamelCase) cause it is used
     * for reflection purposes. Such implementation could be avoided but on the
     * other hand it would require
     * a mapping between classes and subtype which could result in boilerplate code.
     * </p>
     * 
     * @return the super type attribute
     */
    public String getSubtype() {
        return this.subtype;
    }

    /**
     * Has content about the sprite data.
     * Is valuable only when the image in acutually sprite as it holds info about
     * the number of images regarding
     * running, jumping, idling and falling of a full sprite
     * 
     * @return the sprite data
     */

    public SpriteDTO getSpriteMeta() {
        return spriteMeta;
    }

    /**
     * Gets the game object id which must be triggered by a trigger.
     * It is logic to refer game objects whcih have a particular triggerable move
     * set, otherwise this operation in vane.
     * 
     * @return game object id to be triggered
     */
    public int getTriggeringId() {
        return this.triggeringId;
    }
}
