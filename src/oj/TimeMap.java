package oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
	Map<String, List<VersionData>> versionMap;

	public TimeMap() {
		versionMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!versionMap.containsKey(key))
			versionMap.put(key, new ArrayList<>());
		versionMap.get(key).add(new VersionData(value, timestamp));
	}

	public String get(String key, int timestamp) {
		if (versionMap.get(key) == null)
			return "";
		return findValue(versionMap.get(key), timestamp);
	}

	String findValue(List<VersionData> dataList, int timestamp) {
		if (dataList.get(0).timestamp > timestamp)
			return "";
		if (dataList.get(dataList.size() - 1).timestamp <= timestamp)
			return dataList.get(dataList.size() - 1).value;
		if (dataList.get(0).timestamp == timestamp)
			return dataList.get(0).value;
		int begin = 0, end = dataList.size() - 1;
		String value = dataList.get(0).value;
		while (begin <= end) {
			int subIndex = (begin + end) / 2;
			if (subIndex == begin)
				break;
			VersionData data = dataList.get(subIndex);
			if (data.timestamp == timestamp)
				return data.value;
			if (data.timestamp > timestamp) {
				end = subIndex;
			} else {
				begin = end;
				value = data.value;
			}
		}
		return value;
	}

	class VersionData {
		int timestamp;
		String value;

		public VersionData(String value, int timestamp) {
			this.timestamp = timestamp;
			this.value = value;
		}
	}
}
