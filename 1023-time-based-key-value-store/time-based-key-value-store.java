class TimeMap {

    class TimeValue {
        String value;
        int timestamp;

        TimeValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<TimeValue>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<TimeValue> values = map.get(key);

        int left = 0;
        int right = values.size() - 1;

        String result = "";

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (values.get(mid).timestamp <= timestamp) {

                result = values.get(mid).value;

                // This timestamp works.
                // Look for a later valid timestamp.
                left = mid + 1;

            } else {

                // Timestamp is too large.
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */