package spittr.data;

import spittr.Spittle;

import java.util.List;

/**
 * Created by yudequan on 23/02/2017.
 */
public interface SpittleRepository
{
    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
