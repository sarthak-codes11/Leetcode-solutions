
class TimeMap {
    HashMap<String, List<Pair>> map;

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                result = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
