/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package spittr.data.impl;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yudequan on 24/02/2017.
 */
@Component
public class SpitterRepositoryImpl implements SpitterRepository
{
    private Map<String, Spitter> spitters = new HashMap<String, Spitter>();

    @Override
    public Spitter save(Spitter spitter)
    {
        this.spitters.put(spitter.getUsername(), spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username)
    {
        return this.spitters.get(username);
    }
}
