package com.sanver.trials.spittr.spittle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.sanver.trials.spittr.Spittle;

@Component
public class SpittleConstantRepository implements SpittleRepository {

	private List<Spittle> spittleList;

	public SpittleConstantRepository() {
		spittleList = createSpittleList(100);
	}

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		Comparator<Spittle> idReversed = Comparator.comparing((Spittle s) -> s.getId()).reversed();
		List<Spittle> resultList = spittleList.parallelStream().filter(x -> x.getId() < max).sorted(idReversed)
				.sequential().limit(count).collect(Collectors.toList());
		return resultList;
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();

		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle " + i, new Date(), getRandomNumber(-90, 90), getRandomNumber(-180, 180)));
		}

		return spittles;
	}

	public double getRandomNumber(double minInclusive, double maxExclusive) {
		return Math.random() * (maxExclusive - minInclusive) + minInclusive;
	}
}
