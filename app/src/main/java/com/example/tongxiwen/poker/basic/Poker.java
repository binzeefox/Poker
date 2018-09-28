package com.example.tongxiwen.poker.basic;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 扑克卡实体类
 * Created by tong.xiwen on 2017/11/17.
 */
public class Poker implements Parcelable{
    public static final int JOKER_W = -1;   // 大王
    public static final int JOKER_D = 0;    // 小王

    public static final String COLOR_JOKER = "joker";   // 小丑
    public static final String COLOR_HEART = "heart";   // 红心
    public static final String COLOR_SPADE = "spade";   // 黑桃
    public static final String COLOR_DIAMOND = "diamond";   // 方块
    public static final String COLOR_CLUB = "club"; // 草花

    private String color;   // 花色
    private int number;     // 数值

    public Poker(String color, int number){
        this.color = color;
        this.number = number;
    }

    protected Poker(Parcel in) {
        color = in.readString();
        number = in.readInt();
    }

    public static final Creator<Poker> CREATOR = new Creator<Poker>() {
        @Override
        public Poker createFromParcel(Parcel in) {
            return new Poker(in);
        }

        @Override
        public Poker[] newArray(int size) {
            return new Poker[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(color);
        parcel.writeInt(number);
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (Poker.COLOR_JOKER.equals(getColor())){
            switch (getNumber()){
                case Poker.JOKER_D:
                    return "小王";
                case Poker.JOKER_W:
                    return "大王";
                default:
                    break;
            }
        } else {
            switch (getColor()){
                case Poker.COLOR_CLUB:
                    builder.append("草花 ");
                    break;
                case Poker.COLOR_DIAMOND:
                    builder.append("方块 ");
                    break;
                case Poker.COLOR_HEART:
                    builder.append("红心 ");
                    break;
                case Poker.COLOR_SPADE:
                    builder.append("黑桃 ");
                    break;
                default:
                    break;
            }

            switch (getNumber()){
                case 11:
                    builder.append("J");
                    break;
                case 12:
                    builder.append("Q");
                    break;
                case 13:
                    builder.append("K");
                    break;
                default:
                    builder.append(getNumber());
                    break;
            }
        }
        return builder.toString();
    }
}
