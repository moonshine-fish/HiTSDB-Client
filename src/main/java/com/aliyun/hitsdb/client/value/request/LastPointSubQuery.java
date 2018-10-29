package com.aliyun.hitsdb.client.value.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By jianhong.hjh
 * Date: 2018/10/29
 */
public class LastPointSubQuery extends HashMap<String, Object> {

    public static class Builder {
        private LastPointSubQuery query = new LastPointSubQuery();

        public Builder(String metric, Map<String, String> tags) {
            this.query.setMetric(metric);
            this.query.setTags(tags);
        }

        public Builder(List<String> tsuids) {
            this.query.setTsuids(tsuids);
        }

        public LastPointSubQuery build() {
            return query;
        }
    }

    public static Builder builder(String metric, Map<String, String> tags) {
        return new Builder(metric,tags);
    }

    public static Builder builder(List<String> tsuids){
        return new Builder(tsuids);
    }

    private static final String METRIC = "metric";

    private static final String TAGS = "tags";

    private static final String TSUIDS = "tsuids";


    public String getMetric() {
        return (String) this.get(METRIC);
    }

    public void setMetric(String metric) {
        if (getTsuids() != null) {
            throw new IllegalArgumentException("metric and tsuid parameter provided at the same time is not supported.");
        }
        this.put(METRIC, metric);
    }

    public Map<String, String> getTags() {
        return (Map<String, String>) this.get(TAGS);
    }

    public void setTags(Map<String, String> tags) {
        this.put(TAGS, tags);
    }

    public List<String> getTsuids() {
        return (List<String>) this.get(TSUIDS);
    }

    public void setTsuids(List<String> tsuids) {
        if (getMetric() != null) {
            throw new IllegalArgumentException("metric and tsuid parameter provided at the same time is not supported.");
        }
        this.put(TSUIDS, tsuids);
    }
}
