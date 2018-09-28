package com.example.tongxiwen.poker.basic;

/**
 * Created by tong.xiwen on 2017/11/17.
 */
public class PokerUtil {

    public static String getCardName(Poker poker){
        StringBuilder builder = new StringBuilder();
        if (Poker.COLOR_JOKER.equals(poker.getColor())){
            switch (poker.getNumber()){
                case Poker.JOKER_D:
                    return "小王";
                case Poker.JOKER_W:
                    return "大王";
                default:
                    break;
            }
        } else {
            switch (poker.getColor()){
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

            switch (poker.getNumber()){
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
                    builder.append(poker.getNumber());
                    break;
            }
        }
        return builder.toString();
    }
}
