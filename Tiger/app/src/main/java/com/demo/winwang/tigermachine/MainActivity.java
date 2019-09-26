package com.demo.winwang.tigermachine;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.winwang.tigermachine.widget.OnWheelScrollListener;
import com.demo.winwang.tigermachine.widget.WheelView;
import com.demo.winwang.tigermachine.widget.adapters.AbstractWheelAdapter;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        initWheel(R.id.dialog_slot_1);
        initWheel(R.id.dialog_slot_2);
        initWheel(R.id.dialog_slot_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startScrool(911);
//                handler.sendEmptyMessageDelayed(10, 1000);
            }
        });
    }

    /**
     * 初始化轮子
     *
     * @param id the wheel widget Id
     */
    private void initWheel(int id) {
        WheelView wheel = getWheel(id);
        wheel.setViewAdapter(new SlotMachineAdapter());
        wheel.setVisibleItems(3);
        if (id == R.id.dialog_slot_3) {
            wheel.addScrollingListener(scrolledListener);
        }
        wheel.setCyclic(true);
        wheel.setEnabled(false);
        wheel.setDrawShadows(false);
    }

    //车轮滚动的监听器
    OnWheelScrollListener scrolledListener = new OnWheelScrollListener() {
        public void onScrollingStarted(WheelView wheel) {
        }

        public void onScrollingFinished(WheelView wheel) {

        }
    };

    public void startScrool(Integer num) {
        String numString = num.toString();
        int length = numString.length();
        if (length == 1) {
            mixWheel(R.id.dialog_slot_1, 50, 2000);
            mixWheel(R.id.dialog_slot_2, 70, 3000);
            mixWheel(R.id.dialog_slot_3, 90 + num, 5000);
        } else if (length == 2) {
            mixWheel(R.id.dialog_slot_1, 50, 2000);
            char c = numString.charAt(0);
            int firstNum = Integer.parseInt(String.valueOf(c));
            mixWheel(R.id.dialog_slot_2, 70 + firstNum, 3000);
            char c1 = numString.charAt(1);
            int secondNum = Integer.parseInt(String.valueOf(c1));
            mixWheel(R.id.dialog_slot_3, 90 + secondNum, 5000);
        } else if (length == 3) {
            char c = numString.charAt(0);
            int firstNum = Integer.parseInt(String.valueOf(c));
            mixWheel(R.id.dialog_slot_1, 50 + firstNum, 2000);
            char c1 = numString.charAt(1);
            int secondNum = Integer.parseInt(String.valueOf(c1));
            mixWheel(R.id.dialog_slot_2, 70 + secondNum, 3000);
            char c2 = numString.charAt(2);
            int thirdNum = Integer.parseInt(String.valueOf(c2));
            mixWheel(R.id.dialog_slot_3, 90 + secondNum, 5000);
        }
    }


    /**
     * 转动轮子
     *
     * @param id the wheel id
     */
    private void mixWheel(int id, int round, int time) {
        WheelView wheel = getWheel(id);
        wheel.scroll(round, time);
    }


    /**
     * 根据id获取轮子
     *
     * @param id the wheel Id
     * @return the wheel with passed Id
     */
    private WheelView getWheel(int id) {
        WheelView wheelView = (WheelView) findViewById(id);
        return wheelView;
    }


    /**
     * 老虎机适配器
     */
    private class SlotMachineAdapter extends AbstractWheelAdapter {
        @Override
        public int getItemsCount() {
            return 10;
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view;
            if (cachedView != null) {
                view = cachedView;
            } else {
                view = View.inflate(MainActivity.this, R.layout.item_dialog_tiger_img, null);
            }
            ImageView img = (ImageView) view.findViewById(R.id.iv_dialog_home_tiger);
            switch (index) {
                case 0:
                    img.setImageResource(R.mipmap.png0);
                    break;

                case 1:
                    img.setImageResource(R.mipmap.png1);
                    break;

                case 2:
                    img.setImageResource(R.mipmap.png2);
                    break;

                case 3:
                    img.setImageResource(R.mipmap.png3);
                    break;

                case 4:
                    img.setImageResource(R.mipmap.png4);
                    break;

                case 5:
                    img.setImageResource(R.mipmap.png5);
                    break;

                case 6:
                    img.setImageResource(R.mipmap.png6);
                    break;

                case 7:
                    img.setImageResource(R.mipmap.png7);
                    break;

                case 8:
                    img.setImageResource(R.mipmap.png8);
                    break;

                case 9:
                    img.setImageResource(R.mipmap.png9);
                    break;

            }

            return view;
        }
    }
}
