package com.peng.lottery.app.config;

import android.support.v4.app.Fragment;

import com.peng.lottery.mvp.model.db.bean.LotteryNumber;
import com.peng.lottery.mvp.ui.fragment.DaLeDouFragment;
import com.peng.lottery.mvp.ui.fragment.PkShiFragment;
import com.peng.lottery.mvp.ui.fragment.ShiYiXuanWuFragment;
import com.peng.lottery.mvp.ui.fragment.ShuangSeQiuFragment;

import java.util.ArrayList;
import java.util.List;

import static com.peng.lottery.app.config.ActionConfig.LotteryType.LOTTERY_TYPE_11X5;
import static com.peng.lottery.app.config.ActionConfig.LotteryType.LOTTERY_TYPE_DLT;
import static com.peng.lottery.app.config.ActionConfig.LotteryType.LOTTERY_TYPE_PK10;
import static com.peng.lottery.app.config.ActionConfig.LotteryType.LOTTERY_TYPE_SSQ;
import static com.peng.lottery.app.config.ActionConfig.NumberBallType.NUMBER_BALL_TYPE_BLUE;
import static com.peng.lottery.app.config.ActionConfig.NumberBallType.NUMBER_BALL_TYPE_NULL;
import static com.peng.lottery.app.config.ActionConfig.NumberBallType.NUMBER_BALL_TYPE_OTHER;
import static com.peng.lottery.app.config.ActionConfig.NumberBallType.NUMBER_BALL_TYPE_RED;

public class ActionConfig {

    /**
     * 获取对应彩票类型的可选号码球
     */
    public static List<LotteryNumber> getLotteryNumberBallList(LotteryType lotteryType) {
        List<LotteryNumber> numberBallList = new ArrayList<>();
        switch (lotteryType) {
            case LOTTERY_TYPE_DLT:
                for (int number = 1; number <= 35; number++) {
                    LotteryNumber lotteryNumber = new LotteryNumber();
                    lotteryNumber.setNumberValue(number < 10 ? "0" + number : "" + number);
                    lotteryNumber.setNumberType(NUMBER_BALL_TYPE_RED.type);
                    numberBallList.add(lotteryNumber);
                }
                for (int number = 1; number <= 12; number++) {
                    LotteryNumber lotteryNumber = new LotteryNumber();
                    lotteryNumber.setNumberValue(number < 10 ? "0" + number : "" + number);
                    lotteryNumber.setNumberType(NUMBER_BALL_TYPE_BLUE.type);
                    numberBallList.add(lotteryNumber);
                }
                break;
            case LOTTERY_TYPE_SSQ:
                for (int number = 1; number <= 35; number++) {
                    LotteryNumber lotteryNumber = new LotteryNumber();
                    lotteryNumber.setNumberValue(number < 10 ? "0" + number : "" + number);
                    lotteryNumber.setNumberType(number <= 33 ? NUMBER_BALL_TYPE_RED.type : NUMBER_BALL_TYPE_NULL.type);
                    numberBallList.add(lotteryNumber);
                }
                for (int number = 1; number <= 16; number++) {
                    LotteryNumber lotteryNumber = new LotteryNumber();
                    lotteryNumber.setNumberValue(number < 10 ? "0" + number : "" + number);
                    lotteryNumber.setNumberType(NUMBER_BALL_TYPE_BLUE.type);
                    numberBallList.add(lotteryNumber);
                }
                break;
            case LOTTERY_TYPE_11X5:
                for (int number = 1; number <= 11; number++) {
                    LotteryNumber lotteryNumber = new LotteryNumber();
                    lotteryNumber.setNumberValue(number < 10 ? "0" : "" + number);
                    lotteryNumber.setNumberType(NUMBER_BALL_TYPE_OTHER.type);
                    numberBallList.add(lotteryNumber);
                }
                break;
        }
        return numberBallList;
    }

    /**
     * 获取首页TabList
     */
    public static List<String> getMainTabs() {
        List<String> tabs = new ArrayList<>();
        tabs.add(LOTTERY_TYPE_DLT.type);
        tabs.add(LOTTERY_TYPE_SSQ.type);
        tabs.add(LOTTERY_TYPE_11X5.type);
        tabs.add(LOTTERY_TYPE_PK10.type);
        return tabs;
    }

    /**
     * 获取首页FragmentList
     */
    public static List<Fragment> getMainFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DaLeDouFragment());
        fragments.add(new ShuangSeQiuFragment());
        fragments.add(new ShiYiXuanWuFragment());
        fragments.add(new PkShiFragment());
        return fragments;
    }

    /**
     * 彩票类型
     */
    public enum LotteryType {
        LOTTERY_TYPE_DLT("大乐透"),
        LOTTERY_TYPE_SSQ("双色球"),
        LOTTERY_TYPE_11X5("11选5"),
        LOTTERY_TYPE_PK10("PK拾");

        public String type;

        LotteryType(String type) {
            this.type = type;
        }
    }

    /**
     * 彩票号码球类型
     */
    public enum NumberBallType {
        NUMBER_BALL_TYPE_RED("red"),
        NUMBER_BALL_TYPE_BLUE("blue"),
        NUMBER_BALL_TYPE_NULL("null"),
        NUMBER_BALL_TYPE_OTHER("other");

        public String type;

        NumberBallType(String type) {
            this.type = type;
        }
    }
}
