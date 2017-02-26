/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package spittr.web;

/**
 * Created by yudequan on 24/02/2017.
 */
public enum ViewName
{
    SPITTLES("spittles"), SPITTLE("spittle"), HOME("home"), REGISTER("register"), PROFILE("profile");

    private String name;

    ViewName(String name)
    {
        this.name = name;
    }

    String getName()
    {
        return this.name;
    }
}
