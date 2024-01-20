package com.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpbitCoinInfoDto {

    @JsonProperty("market")
    public String market;
    @JsonProperty("trade_date")
    public String tradeDate;
    @JsonProperty("trade_time")
    public String tradeTime;
    @JsonProperty("trade_date_kst")
    public String tradeDateKst;
    @JsonProperty("trade_time_kst")
    public String tradeTimeKst;
    @JsonProperty("trade_timestamp")
    public Long tradeTimestamp;
    @JsonProperty("opening_price")
    public Double openingPrice;
    @JsonProperty("high_price")
    public Double highPrice;
    @JsonProperty("low_price")
    public Double lowPrice;
    @JsonProperty("trade_price")
    public Double tradePrice;
    @JsonProperty("prev_closing_price")
    public Double prevClosingPrice;
    @JsonProperty("change")
    public String change;
    @JsonProperty("change_price")
    public Double changePrice;
    @JsonProperty("change_rate")
    public Double changeRate;
    @JsonProperty("signed_change_price")
    public Double signedChangePrice;
    @JsonProperty("signed_change_rate")
    public Double signedChangeRate;
    @JsonProperty("trade_volume")
    public Double tradeVolume;
    @JsonProperty("acc_trade_price")
    public Double accTradePrice;
    @JsonProperty("acc_trade_price_24h")
    public Double accTradePrice24h;
    @JsonProperty("acc_trade_volume")
    public Double accTradeVolume;
    @JsonProperty("acc_trade_volume_24h")
    public Double accTradeVolume24h;
    @JsonProperty("highest_52_week_price")
    public Double highest52WeekPrice;
    @JsonProperty("highest_52_week_date")
    public String highest52WeekDate;
    @JsonProperty("lowest_52_week_price")
    public Double lowest52WeekPrice;
    @JsonProperty("lowest_52_week_date")
    public String lowest52WeekDate;
    @JsonProperty("timestamp")
    public Long timestamp;

}