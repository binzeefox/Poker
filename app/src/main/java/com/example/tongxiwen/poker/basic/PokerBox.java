package com.example.tongxiwen.poker.basic;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 卡组实体类
 * Created by tong.xiwen on 2017/11/17.
 */
public class PokerBox {
    private Set<Poker> pokerSet;
    private Stack<Poker> pokerStack;    // 随机的扑克牌卡组

    public PokerBox(){
        pokerSet = new HashSet<Poker>();
        prepareBox(Poker.COLOR_JOKER);
        prepareBox(Poker.COLOR_CLUB);
        prepareBox(Poker.COLOR_DIAMOND);
        prepareBox(Poker.COLOR_HEART);
        prepareBox(Poker.COLOR_SPADE);

        formCards();
    }

    /**
     * 形成随机牌堆
     */
    private void prepareBox(String color) {
        switch (color){
            case Poker.COLOR_JOKER:
                pokerSet.add(new Poker(Poker.COLOR_JOKER, Poker.JOKER_D));
                pokerSet.add(new Poker(Poker.COLOR_JOKER, Poker.JOKER_W));
                break;
            default:
                for (int i = 1;i < 14; i++){
                    pokerSet.add(new Poker(color, i));
                }
                break;
        }
    }

    /**
     * 形成卡组
     */
    private void formCards() {
        pokerStack = new Stack<>();
        for (Poker poker : pokerSet){
            pokerStack.push(poker);
        }
    }

    /**
     * 查看卡组最上层一张
     */
    public Poker peekCard(){
        return pokerStack.peek();
    }

    /**
     * 抽卡
     */
    public Poker popCard(){
        return pokerStack.pop();
    }

    /**
     * 卡组剩余卡数
     */
    public int remainCards(){
        return pokerStack.size();
    }
}
