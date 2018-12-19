package com.mygdx.platformtutorial.World;

import java.awt.*;
import java.util.ArrayList;

public class CoinSpawn {

    private ArrayList<Rectangle> coins;

    public CoinSpawn() {
        coins = new ArrayList<Rectangle>();
    }

    public void spawnCoin(int x, int y){
        Rectangle coin = new Rectangle();
        coin.x = x;
        coin.y = y;
        coin.width = 16;
        coin.height = 16;
        coins.add(coin);
    }



    public void spawnCoins(){
        int tileSize = TileType.TILE_SIZE;

        spawnCoin(4*tileSize + 8, 4*tileSize + 8);
        spawnCoin(5*tileSize + 8, 3*tileSize + 8);
        spawnCoin(5*tileSize + 8, 5*tileSize + 8);
        spawnCoin(6*tileSize + 8, 4*tileSize + 8);
        spawnCoin(8*tileSize + 8, 2*tileSize + 8);
        spawnCoin(8*tileSize + 8, 3*tileSize + 8);
        spawnCoin(8*tileSize + 8, 4*tileSize + 8);
        spawnCoin(10*tileSize + 8, 5*tileSize + 8);
        spawnCoin(11*tileSize + 8, 5*tileSize + 8);
        spawnCoin(13*tileSize + 8, 3*tileSize + 8);
        spawnCoin(13*tileSize + 8, 4*tileSize + 8);
        spawnCoin(13*tileSize + 8, 5*tileSize + 8);
        spawnCoin(15*tileSize + 8, 3*tileSize + 8);
        spawnCoin(16*tileSize + 8, 4*tileSize + 8);
        spawnCoin(17*tileSize + 8, 4*tileSize + 8);
        spawnCoin(18*tileSize + 8, 3*tileSize + 8);
        spawnCoin(21*tileSize + 8, 4*tileSize + 8);
        spawnCoin(21*tileSize + 8, 5*tileSize + 8);
        spawnCoin(21*tileSize + 8, 6*tileSize + 8);
        spawnCoin(24*tileSize + 8, 2*tileSize + 8);

        spawnCoin(25*tileSize + 8, 2*tileSize + 8);
        spawnCoin(26*tileSize + 8, 3*tileSize + 8);
        spawnCoin(27*tileSize + 8, 3*tileSize + 8);
        spawnCoin(28*tileSize + 8, 2*tileSize + 8);
        spawnCoin(29*tileSize + 8, 2*tileSize + 8);
        spawnCoin(32*tileSize + 8, 2*tileSize + 8);
        spawnCoin(33*tileSize + 8, 2*tileSize + 8);
        spawnCoin(34*tileSize + 8, 2*tileSize + 8);
        spawnCoin(35*tileSize + 8, 2*tileSize + 8);
        spawnCoin(36*tileSize + 8, 2*tileSize + 8);
        spawnCoin(40*tileSize + 8, 3*tileSize + 8);
        spawnCoin(41*tileSize + 8, 2*tileSize + 8);
        spawnCoin(42*tileSize + 8, 2*tileSize + 8);

        spawnCoin(46*tileSize + 8, 2*tileSize + 8);
        spawnCoin(45*tileSize + 8, 3*tileSize + 8);
        spawnCoin(46*tileSize + 8, 4*tileSize + 8);
        spawnCoin(47*tileSize + 8, 3*tileSize + 8);
        spawnCoin(36*tileSize, 6*tileSize + 8);
        spawnCoin(36*tileSize, 7*tileSize + 8);
        spawnCoin(36*tileSize, 8*tileSize + 8);
        spawnCoin(40*tileSize + 8, 6*tileSize + 8);
        spawnCoin(41*tileSize + 8, 7*tileSize + 8);
        spawnCoin(40*tileSize + 8, 8*tileSize + 8);
        spawnCoin(45*tileSize + 8, 11*tileSize + 8);
        spawnCoin(46*tileSize + 8, 10*tileSize + 8);
        spawnCoin(47*tileSize + 8, 10*tileSize + 8);
        spawnCoin(40*tileSize + 8, 10*tileSize + 8);
        spawnCoin(41*tileSize + 8, 10*tileSize + 8);
        spawnCoin(35*tileSize + 8, 11*tileSize + 8);

        spawnCoin(32*tileSize + 8, 11*tileSize + 8);
        spawnCoin(34*tileSize, 13*tileSize + 8);
        spawnCoin(31*tileSize + 8, 13*tileSize + 8);
        spawnCoin(29*tileSize + 8, 14*tileSize + 8);
        spawnCoin(28*tileSize, 14*tileSize + 8);
        spawnCoin(26*tileSize + 8, 14*tileSize);
        spawnCoin(25*tileSize + 8, 14*tileSize + 8);
        spawnCoin(24*tileSize + 8, 13*tileSize + 8);
        spawnCoin(24*tileSize + 8, 15*tileSize + 8);
        spawnCoin(22*tileSize + 8, 13*tileSize + 8);
        spawnCoin(20*tileSize + 8, 14*tileSize + 8);
        spawnCoin(18*tileSize + 8, 13*tileSize + 8);
        spawnCoin(17*tileSize + 8, 11*tileSize + 8);
        spawnCoin(16*tileSize, 13*tileSize);
        spawnCoin(14*tileSize + 8, 11*tileSize + 8);
        spawnCoin(13*tileSize + 8, 13*tileSize + 8);
        spawnCoin(12*tileSize, 12*tileSize + 8);

        spawnCoin(10*tileSize + 8, 11*tileSize + 8);
        spawnCoin(9*tileSize + 8, 10*tileSize + 8);
        spawnCoin(8*tileSize + 8, 9*tileSize + 8);
        spawnCoin(7*tileSize + 8, 9*tileSize + 8);
        spawnCoin(6*tileSize + 8, 9*tileSize + 8);
        spawnCoin(5*tileSize + 8, 9*tileSize + 8);
        spawnCoin(4*tileSize + 8, 9*tileSize + 8);
        spawnCoin(3*tileSize + 8, 9*tileSize + 8);
        spawnCoin(2*tileSize + 8, 9*tileSize + 8);
        spawnCoin(8*tileSize + 8, 10*tileSize + 8);
        spawnCoin(8*tileSize + 8, 11*tileSize + 8);
        spawnCoin(8*tileSize + 8, 12*tileSize + 8);
        spawnCoin(1*tileSize + 8, 9*tileSize + 8);
        spawnCoin(1*tileSize + 8, 10*tileSize + 8);
        spawnCoin(1*tileSize + 8, 11*tileSize + 8);
        spawnCoin(1*tileSize + 8, 12*tileSize + 8);

        spawnCoin(6*tileSize + 8, 12*tileSize + 8);
        spawnCoin(6*tileSize + 8, 13*tileSize + 8);
        spawnCoin(6*tileSize + 8, 14*tileSize + 8);
        spawnCoin(6*tileSize + 8, 15*tileSize + 8);
        spawnCoin(1*tileSize + 8, 15*tileSize + 8);
        spawnCoin(1*tileSize + 8, 16*tileSize + 8);
        spawnCoin(1*tileSize + 8, 17*tileSize + 8);
        spawnCoin(1*tileSize + 8, 18*tileSize + 8);
        spawnCoin(6*tileSize + 8, 18*tileSize + 8);
        spawnCoin(6*tileSize + 8, 19*tileSize + 8);
        spawnCoin(6*tileSize + 8, 20*tileSize + 8);
        spawnCoin(6*tileSize + 8, 21*tileSize + 8);
        spawnCoin(1*tileSize + 8, 21*tileSize + 8);
        spawnCoin(1*tileSize + 8, 22*tileSize + 8);
        spawnCoin(1*tileSize + 8, 23*tileSize + 8);
        spawnCoin(1*tileSize + 8, 24*tileSize + 8);

        spawnCoin(6*tileSize + 8, 24*tileSize + 8);
        spawnCoin(6*tileSize + 8, 25*tileSize + 8);
        spawnCoin(6*tileSize + 8, 26*tileSize + 8);
        spawnCoin(6*tileSize + 8, 27*tileSize + 8);
        spawnCoin(1*tileSize + 8, 27*tileSize + 8);
        spawnCoin(1*tileSize + 8, 28*tileSize + 8);
        spawnCoin(1*tileSize + 8, 29*tileSize + 8);
        spawnCoin(1*tileSize + 8, 30*tileSize + 8);
        spawnCoin(7*tileSize + 8, 32*tileSize + 8);
        spawnCoin(8*tileSize + 8, 32*tileSize + 8);
        spawnCoin(9*tileSize + 8, 32*tileSize + 8);
        spawnCoin(10*tileSize + 8, 31*tileSize + 8);
        spawnCoin(12*tileSize + 8, 30*tileSize + 8);
        spawnCoin(13*tileSize + 8, 30*tileSize + 8);
        spawnCoin(12*tileSize + 8, 33*tileSize + 8);
        spawnCoin(13*tileSize + 8, 33*tileSize + 8);

        spawnCoin(16*tileSize + 8, 28*tileSize + 8);
        spawnCoin(17*tileSize + 8, 28*tileSize + 8);
        spawnCoin(18*tileSize + 8, 27*tileSize + 8);
        spawnCoin(19*tileSize + 8, 27*tileSize + 8);
        spawnCoin(20*tileSize + 8, 27*tileSize + 8);
        spawnCoin(21*tileSize + 8, 27*tileSize + 8);
        spawnCoin(25*tileSize + 8, 25*tileSize + 8);
        spawnCoin(26*tileSize + 8, 25*tileSize + 8);
        spawnCoin(27*tileSize + 8, 25*tileSize + 8);
        spawnCoin(26*tileSize, 26*tileSize + 8);
        spawnCoin(27*tileSize + 8, 26*tileSize + 8);
        spawnCoin(26*tileSize + 8, 27*tileSize + 8);
        spawnCoin(17*tileSize + 8, 31*tileSize + 8);
        spawnCoin(18*tileSize + 8, 31*tileSize + 8);
        spawnCoin(19*tileSize + 8, 31*tileSize + 8);
        spawnCoin(20*tileSize + 8, 31*tileSize + 8);

        spawnCoin(19*tileSize + 8, 34*tileSize + 8);
        spawnCoin(20*tileSize + 8, 34*tileSize + 8);
        spawnCoin(21*tileSize + 8, 34*tileSize + 8);
        spawnCoin(22*tileSize + 8, 34*tileSize + 8);
        spawnCoin(23*tileSize + 8, 35*tileSize + 8);
        spawnCoin(24*tileSize + 8, 35*tileSize + 8);
        spawnCoin(25*tileSize + 8, 35*tileSize + 8);
        spawnCoin(24*tileSize + 8, 36*tileSize + 8);
        spawnCoin(25*tileSize + 8, 36*tileSize + 8);
        spawnCoin(23*tileSize + 8, 37*tileSize + 8);
        spawnCoin(24*tileSize + 8, 37*tileSize + 8);
        spawnCoin(25*tileSize + 8, 37*tileSize + 8);
        spawnCoin(20*tileSize + 8, 38*tileSize + 8);

        spawnCoin(19*tileSize + 8, 38*tileSize + 8);
        spawnCoin(18*tileSize + 8, 38*tileSize + 8);
        spawnCoin(17*tileSize + 8, 38*tileSize + 8);
        spawnCoin(20*tileSize, 39*tileSize + 8);
        spawnCoin(19*tileSize, 39*tileSize + 8);
        spawnCoin(18*tileSize, 39*tileSize + 8);
        spawnCoin(16*tileSize + 8, 39*tileSize + 8);
        spawnCoin(15*tileSize + 8, 40*tileSize + 8);
        spawnCoin(13*tileSize + 8, 39*tileSize + 8);
        spawnCoin(12*tileSize + 8, 39*tileSize + 8);
        spawnCoin(11*tileSize + 8, 39*tileSize + 8);
        spawnCoin(10*tileSize + 8, 39*tileSize + 8);
    }

    public ArrayList<Rectangle> getCoins() {
        return coins;
    }
}
