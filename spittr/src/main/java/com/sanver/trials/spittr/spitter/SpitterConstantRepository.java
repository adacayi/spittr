package com.sanver.trials.spittr.spitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sanver.trials.spittr.Spitter;

@Component
public class SpitterConstantRepository implements SpitterRepository {

	private List<Spitter> spitterList;

	public SpitterConstantRepository() {
		spitterList = createSpitterList(100);
	}

	@Override
	public List<Spitter> findSpitters(long max, int count) {
		Comparator<Spitter> idReversed = Comparator.comparing((Spitter s) -> s.getId()).reversed();
		List<Spitter> resultList = spitterList.parallelStream().filter(x -> x.getId() <= max).sorted(idReversed)
				.sequential().limit(count).collect(Collectors.toList());
		return resultList;
	}

	private List<Spitter> createSpitterList(int count) {
		List<Spitter> spitters = new ArrayList<Spitter>();

		for (int i = 0; i < count; i++) {
			spitters.add(new Spitter("spitter_" + i, "pass" + i, "Spitter " + i, "surname " + i));
		}

		return spitters;
	}

	public Spitter findByUsername(String username) {
		Spitter result = spitterList.stream().filter(x -> x.getUsername().equals(username)).findFirst().orElse(null);
		return result;
	}

	@Override
	public Spitter save(Spitter unsaved) {
		spitterList.add(unsaved);
		return unsaved;
	}
}
