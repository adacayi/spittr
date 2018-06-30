package com.sanver.trials.spittr.spittle;

import java.util.List;

import com.sanver.trials.spittr.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
}
