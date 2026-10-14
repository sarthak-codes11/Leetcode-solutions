class TimeMap {

    class Pair {
        int timeStamp;
        String value;

        Pair(int timeStamp, String value) {
            this.timeStamp = timeStamp;
            this.value = value;
        }
    }

    Map<String, List<Pair>> hm;

    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new ArrayList<>());
        }

        hm.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)) return "";
        
        String result = "";

        List<Pair> list = hm.get(key);

        int left=0, right = list.size() - 1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(list.get(mid).timeStamp <= timestamp) {
                result = list.get(mid).value;
                left = mid+1;
            } else {
                right = mid-1;
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