package com.vo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpbitCoinInfoDto {

    @JsonProperty("market")
    private String market;
    @JsonProperty("trade_date")
    private String tradeDate;
    @JsonProperty("trade_time")
    private String tradeTime;
    @JsonProperty("trade_date_kst")
    private String tradeDateKst;
    @JsonProperty("trade_time_kst")
    private String tradeTimeKst;
    @JsonProperty("trade_timestamp")
    private long tradeTimestamp;
    @JsonProperty("opening_price")
    private double openingPrice;
    @JsonProperty("high_price")
    private double highPrice;
    @JsonProperty("low_price")
    private double lowPrice;
    @JsonProperty("trade_price")
    private double tradePrice;
    @JsonProperty("prev_closing_price")
    private double prevClosingPrice;
    @JsonProperty("change")
    private String change;
    @JsonProperty("change_price")
    private double changePrice;
    @JsonProperty("change_rate")
    private double changeRate;
    @JsonProperty("signed_change_price")
    private double signedChangePrice;
    @JsonProperty("signed_change_rate")
    private double signedChangeRate;
    @JsonProperty("trade_volume")
    private double tradeVolume;
    @JsonProperty("acc_trade_price")
    private double accTradePrice;
    @JsonProperty("acc_trade_price_24h")
    private double accTradePrice24h;
    @JsonProperty("acc_trade_volume")
    private double accTradeVolume;
    @JsonProperty("acc_trade_volume_24h")
    private double accTradeVolume24h;
    @JsonProperty("highest_52_week_price")
    private double highest52WeekPrice;
    @JsonProperty("highest_52_week_date")
    private String highest52WeekDate;
    @JsonProperty("lowest_52_week_price")
    private double lowest52WeekPrice;
    @JsonProperty("lowest_52_week_date")
    private String lowest52WeekDate;
    @JsonProperty("timestamp")
    private long timestamp;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("market")
    public String getMarket() {
        return market;
    }

    @JsonProperty("market")
    public void setMarket(String market) {
        this.market = market;
    }

    public UpbitCoinInfoDto withMarket(String market) {
        this.market = market;
        return this;
    }

    @JsonProperty("trade_date")
    public String getTradeDate() {
        return tradeDate;
    }

    @JsonProperty("trade_date")
    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public UpbitCoinInfoDto withTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
        return this;
    }

    @JsonProperty("trade_time")
    public String getTradeTime() {
        return tradeTime;
    }

    @JsonProperty("trade_time")
    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public UpbitCoinInfoDto withTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
        return this;
    }

    @JsonProperty("trade_date_kst")
    public String getTradeDateKst() {
        return tradeDateKst;
    }

    @JsonProperty("trade_date_kst")
    public void setTradeDateKst(String tradeDateKst) {
        this.tradeDateKst = tradeDateKst;
    }

    public UpbitCoinInfoDto withTradeDateKst(String tradeDateKst) {
        this.tradeDateKst = tradeDateKst;
        return this;
    }

    @JsonProperty("trade_time_kst")
    public String getTradeTimeKst() {
        return tradeTimeKst;
    }

    @JsonProperty("trade_time_kst")
    public void setTradeTimeKst(String tradeTimeKst) {
        this.tradeTimeKst = tradeTimeKst;
    }

    public UpbitCoinInfoDto withTradeTimeKst(String tradeTimeKst) {
        this.tradeTimeKst = tradeTimeKst;
        return this;
    }

    @JsonProperty("trade_timestamp")
    public long getTradeTimestamp() {
        return tradeTimestamp;
    }

    @JsonProperty("trade_timestamp")
    public void setTradeTimestamp(long tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }

    public UpbitCoinInfoDto withTradeTimestamp(long tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
        return this;
    }

    @JsonProperty("opening_price")
    public double getOpeningPrice() {
        return openingPrice;
    }

    @JsonProperty("opening_price")
    public void setOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
    }

    public UpbitCoinInfoDto withOpeningPrice(double openingPrice) {
        this.openingPrice = openingPrice;
        return this;
    }

    @JsonProperty("high_price")
    public double getHighPrice() {
        return highPrice;
    }

    @JsonProperty("high_price")
    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public UpbitCoinInfoDto withHighPrice(double highPrice) {
        this.highPrice = highPrice;
        return this;
    }

    @JsonProperty("low_price")
    public double getLowPrice() {
        return lowPrice;
    }

    @JsonProperty("low_price")
    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public UpbitCoinInfoDto withLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    @JsonProperty("trade_price")
    public double getTradePrice() {
        return tradePrice;
    }

    @JsonProperty("trade_price")
    public void setTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
    }

    public UpbitCoinInfoDto withTradePrice(double tradePrice) {
        this.tradePrice = tradePrice;
        return this;
    }

    @JsonProperty("prev_closing_price")
    public double getPrevClosingPrice() {
        return prevClosingPrice;
    }

    @JsonProperty("prev_closing_price")
    public void setPrevClosingPrice(double prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
    }

    public UpbitCoinInfoDto withPrevClosingPrice(double prevClosingPrice) {
        this.prevClosingPrice = prevClosingPrice;
        return this;
    }

    @JsonProperty("change")
    public String getChange() {
        return change;
    }

    @JsonProperty("change")
    public void setChange(String change) {
        this.change = change;
    }

    public UpbitCoinInfoDto withChange(String change) {
        this.change = change;
        return this;
    }

    @JsonProperty("change_price")
    public double getChangePrice() {
        return changePrice;
    }

    @JsonProperty("change_price")
    public void setChangePrice(double changePrice) {
        this.changePrice = changePrice;
    }

    public UpbitCoinInfoDto withChangePrice(double changePrice) {
        this.changePrice = changePrice;
        return this;
    }

    @JsonProperty("change_rate")
    public double getChangeRate() {
        return changeRate;
    }

    @JsonProperty("change_rate")
    public void setChangeRate(double changeRate) {
        this.changeRate = changeRate;
    }

    public UpbitCoinInfoDto withChangeRate(double changeRate) {
        this.changeRate = changeRate;
        return this;
    }

    @JsonProperty("signed_change_price")
    public double getSignedChangePrice() {
        return signedChangePrice;
    }

    @JsonProperty("signed_change_price")
    public void setSignedChangePrice(double signedChangePrice) {
        this.signedChangePrice = signedChangePrice;
    }

    public UpbitCoinInfoDto withSignedChangePrice(double signedChangePrice) {
        this.signedChangePrice = signedChangePrice;
        return this;
    }

    @JsonProperty("signed_change_rate")
    public double getSignedChangeRate() {
        return signedChangeRate;
    }

    @JsonProperty("signed_change_rate")
    public void setSignedChangeRate(double signedChangeRate) {
        this.signedChangeRate = signedChangeRate;
    }

    public UpbitCoinInfoDto withSignedChangeRate(double signedChangeRate) {
        this.signedChangeRate = signedChangeRate;
        return this;
    }

    @JsonProperty("trade_volume")
    public double getTradeVolume() {
        return tradeVolume;
    }

    @JsonProperty("trade_volume")
    public void setTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
    }

    public UpbitCoinInfoDto withTradeVolume(double tradeVolume) {
        this.tradeVolume = tradeVolume;
        return this;
    }

    @JsonProperty("acc_trade_price")
    public double getAccTradePrice() {
        return accTradePrice;
    }

    @JsonProperty("acc_trade_price")
    public void setAccTradePrice(double accTradePrice) {
        this.accTradePrice = accTradePrice;
    }

    public UpbitCoinInfoDto withAccTradePrice(double accTradePrice) {
        this.accTradePrice = accTradePrice;
        return this;
    }

    @JsonProperty("acc_trade_price_24h")
    public double getAccTradePrice24h() {
        return accTradePrice24h;
    }

    @JsonProperty("acc_trade_price_24h")
    public void setAccTradePrice24h(double accTradePrice24h) {
        this.accTradePrice24h = accTradePrice24h;
    }

    public UpbitCoinInfoDto withAccTradePrice24h(double accTradePrice24h) {
        this.accTradePrice24h = accTradePrice24h;
        return this;
    }

    @JsonProperty("acc_trade_volume")
    public double getAccTradeVolume() {
        return accTradeVolume;
    }

    @JsonProperty("acc_trade_volume")
    public void setAccTradeVolume(double accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
    }

    public UpbitCoinInfoDto withAccTradeVolume(double accTradeVolume) {
        this.accTradeVolume = accTradeVolume;
        return this;
    }

    @JsonProperty("acc_trade_volume_24h")
    public double getAccTradeVolume24h() {
        return accTradeVolume24h;
    }

    @JsonProperty("acc_trade_volume_24h")
    public void setAccTradeVolume24h(double accTradeVolume24h) {
        this.accTradeVolume24h = accTradeVolume24h;
    }

    public UpbitCoinInfoDto withAccTradeVolume24h(double accTradeVolume24h) {
        this.accTradeVolume24h = accTradeVolume24h;
        return this;
    }

    @JsonProperty("highest_52_week_price")
    public double getHighest52WeekPrice() {
        return highest52WeekPrice;
    }

    @JsonProperty("highest_52_week_price")
    public void setHighest52WeekPrice(double highest52WeekPrice) {
        this.highest52WeekPrice = highest52WeekPrice;
    }

    public UpbitCoinInfoDto withHighest52WeekPrice(double highest52WeekPrice) {
        this.highest52WeekPrice = highest52WeekPrice;
        return this;
    }

    @JsonProperty("highest_52_week_date")
    public String getHighest52WeekDate() {
        return highest52WeekDate;
    }

    @JsonProperty("highest_52_week_date")
    public void setHighest52WeekDate(String highest52WeekDate) {
        this.highest52WeekDate = highest52WeekDate;
    }

    public UpbitCoinInfoDto withHighest52WeekDate(String highest52WeekDate) {
        this.highest52WeekDate = highest52WeekDate;
        return this;
    }

    @JsonProperty("lowest_52_week_price")
    public double getLowest52WeekPrice() {
        return lowest52WeekPrice;
    }

    @JsonProperty("lowest_52_week_price")
    public void setLowest52WeekPrice(double lowest52WeekPrice) {
        this.lowest52WeekPrice = lowest52WeekPrice;
    }

    public UpbitCoinInfoDto withLowest52WeekPrice(double lowest52WeekPrice) {
        this.lowest52WeekPrice = lowest52WeekPrice;
        return this;
    }

    @JsonProperty("lowest_52_week_date")
    public String getLowest52WeekDate() {
        return lowest52WeekDate;
    }

    @JsonProperty("lowest_52_week_date")
    public void setLowest52WeekDate(String lowest52WeekDate) {
        this.lowest52WeekDate = lowest52WeekDate;
    }

    public UpbitCoinInfoDto withLowest52WeekDate(String lowest52WeekDate) {
        this.lowest52WeekDate = lowest52WeekDate;
        return this;
    }

    @JsonProperty("timestamp")
    public long getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public UpbitCoinInfoDto withTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public UpbitCoinInfoDto withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}