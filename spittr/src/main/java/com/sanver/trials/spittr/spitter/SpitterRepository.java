package com.sanver.trials.spittr.spitter;

import java.util.List;

import com.sanver.trials.spittr.Spitter;

public interface SpitterRepository {
	List<Spitter> findSpitters(long max, int count);

	Spitter findByUsername(String username);

	Spitter save(Spitter unsaved);
}
