package com.pony.MobileInterface.entity;

import com.pony.domain.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class UsableContainerTypeAndNumber {
    private int id;
    //柜门数量
    private int containerQuantity;
    //柜门长
    private int containerLength;
    //柜门宽
    private int containerWidth;
    //柜门高
    private int containerHigh;
    //柜子体积
    private int volume;
    private UsableContainerTypeAndNumber bigger;
    private UsableContainerTypeAndNumber smaller;
    private Stack<ProductTemp> myProductTempStack = new Stack<ProductTemp>();
    private Stack<Container> containerStack = new Stack<Container>();
    //setter and getter

    public Stack<Container> getContainerStack() {
        return containerStack;
    }

    public void setContainerStack(Stack<Container> containerStack) {
        this.containerStack = containerStack;
    }

    public UsableContainerTypeAndNumber getBigger() {
        return bigger;
    }

    public void setBigger(UsableContainerTypeAndNumber bigger) {
        this.bigger = bigger;
    }

    public UsableContainerTypeAndNumber getSmaller() {
        return smaller;
    }

    public void setSmaller(UsableContainerTypeAndNumber smaller) {
        this.smaller = smaller;
    }

    public Stack<ProductTemp> getMyProductTempStack() {
        return myProductTempStack;
    }

    public void setMyProductTempStack(Stack<ProductTemp> myProductTempStack) {
        this.myProductTempStack = myProductTempStack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContainerQuantity() {
        return containerQuantity;
    }

    public void setContainerQuantity(int containerQuantity) {
        this.containerQuantity = containerQuantity;
    }

    public int getContainerLength() {
        return containerLength;
    }

    public void setContainerLength(int containerLength) {
        this.containerLength = containerLength;
    }

    public int getContainerWidth() {
        return containerWidth;
    }

    public void setContainerWidth(int containerWidth) {
        this.containerWidth = containerWidth;
    }

    public int getContainerHigh() {
        return containerHigh;
    }

    public void setContainerHigh(int containerHigh) {
        this.containerHigh = containerHigh;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
