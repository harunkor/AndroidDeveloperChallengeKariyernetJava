package com.harunkor.androiddeveloperchallengekariyernetjava.model;

import android.graphics.Color;
import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;

public class Order {


    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("marketName")
    @Expose
    private String marketName;
    @SerializedName("orderName")
    @Expose
    private String orderName;
    @SerializedName("productPrice")
    @Expose
    private Double productPrice;
    @SerializedName("productState")
    @Expose
    private String productState;
    @SerializedName("productDetail")
    @Expose
    private ProductDetail productDetail;

    private int statuColor;


    private int isVisibility=8;





    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {

        return getMonthName(Integer.valueOf(month));
    }

    public void setMonth(String month) {
        this.month = getMonthName(Integer.valueOf(month));
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }





    public String getMonthName(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }


    public String  getProductPriceAddTl()
    {

        return  productPrice.toString()+" TL";
    }

    public String  getOrderSummaryPriceAddTl()
    {

        return  productDetail.getSummaryPrice().toString()+" TL";
    }




   public  int getStatuColor()
    {

        switch (productState) {
            case "Hazırlanıyor":
                return Color.parseColor( "#fd8d26");

            case "Onay Bekliyor":
                return Color.parseColor( "#ea2d3f");


            case "Yolda":
                return Color.parseColor( "#51ad54");



            default:
                return Color.parseColor("#000000");

        }







    }





    public void setStatuColor(int statuColor) {

        this.statuColor = statuColor;
    }


    public int getIsVisibility() {

        return isVisibility;
    }

    public void setIsVisibility(int isVisibility) {
        this.isVisibility = isVisibility;
    }


}
