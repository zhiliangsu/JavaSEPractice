package com.hitech.domain;

import java.io.Serial;
import java.io.Serializable;

public class GameInfo implements Serializable {
    @Serial
    private static final long serialVersionUID = 3099699808863848320L;
    private int[][] data;
    private int x;
    private int y;
    private String gameImagePath;
    private int step;
    private String username;

    public GameInfo() {
    }

    public GameInfo(int[][] data, int x, int y, String gameImagePath, int step, String username) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.gameImagePath = gameImagePath;
        this.step = step;
        this.username = username;
    }

    /**
     * 获取
     *
     * @return data
     */
    public int[][] getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(int[][] data) {
        this.data = data;
    }

    /**
     * 获取
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * 设置
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 获取
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * 设置
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 获取
     *
     * @return gameImagePath
     */
    public String getGameImagePath() {
        return gameImagePath;
    }

    /**
     * 设置
     *
     * @param gameImagePath
     */
    public void setGameImagePath(String gameImagePath) {
        this.gameImagePath = gameImagePath;
    }

    /**
     * 获取
     *
     * @return step
     */
    public int getStep() {
        return step;
    }

    /**
     * 设置
     *
     * @param step
     */
    public void setStep(int step) {
        this.step = step;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "GameInfo{data = " + data + ", x = " + x + ", y = " + y + ", gameImagePath = " + gameImagePath + ", step = " + step + ", username = " + username + "}";
    }
}
