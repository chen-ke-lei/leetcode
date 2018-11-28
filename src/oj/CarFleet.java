package oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CarFleet {
	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length==0||speed.length==0||position.length != speed.length)
			return 0;
		Map<Integer, Double> descTime = new HashMap<>();
		for (int i = 0; i < position.length; i++) {
			double time = (target - position[i]) *1.0/ speed[i];
			descTime.put(position[i], time);
		}
		Arrays.sort(position);
		int res = 1;
		for (int i = position.length - 1; i > 0; i--) {
			if (descTime.get(position[i]) >= descTime.get(position[i - 1]))
				descTime.put(position[i - 1], descTime.get(position[i]));
			else 
				res++;
		}
		return res;
	}
}
