/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package spittr.data.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yudequan on 24/02/2017.
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRepository
{
    private static final Logger LOGGER = LogManager.getLogger(SpittleRepositoryImpl.class);

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Spittle> findSpittles(long max, int count)
    {
        return this.createSpittleList(count);
    }

    @Override
    public Spittle findOne(long spittleId)
    {
        for(Spittle spittle : this.findSpittles(Long.MAX_VALUE, 20))
        {
            if(spittle.getId() == spittleId)
            {
                return spittle;
            }
        }
        return  new Spittle(999L,"Auto Generate", new Date());
    }

    private List<Spittle> createSpittleList(int count)
    {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i=0; i<count; i++)
        {
            spittles.add(new Spittle(new Long(i),"Spittle " + i, new Date()));
        }

        List<Map<String, Object>> list = jdbcOperations.queryForList("select * from emp");
        for(Map<String, Object> map : list)
        {
            LOGGER.info(map);
        }
        return spittles;
    }
}
