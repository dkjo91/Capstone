package com.project.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.apache.cordova.CordovaActivity;

/**
 * Created by Kyuuung on 2014-04-05.
 */
// Activity 클래스를 상속받은 사용자 정의 액티비티에 OnTouchListener 를 구현한다.
public class Touch_activity extends CordovaActivity implements View.OnTouchListener
{
    // 좌표를 출력할 텍스트뷰
    private TextView m_text_view = null;
    // 터치 위치에 원이 그려지는 사용자 정의 뷰
    private TipsView m_tips_view = null;
    static private String x_coordinate = "";
    static private String y_coordinate = "";
    String my_TAG = "qwer";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // XML 파일에 정의한대로 레이아웃을 설정한다.
        setContentView(R.layout.touch);

        // 리소스 파일에 정의된 is_tv 라는 ID의 텍스트뷰를 얻어온다.
        m_text_view = (TextView) findViewById(R.id.id_tv);
        // 텍스트뷰에 문자열을 출력한다.
        m_text_view.setText("Touch Touch!!");

        // 리소스 파일에 정의된 id_view 라는 ID 의 사용자정의뷰를 얻어온다.
        m_tips_view = (TipsView) findViewById(R.id.id_view);
        // 사용자정의 뷰에 이 클래스에서 구현한 리스너를 등록한다.
        m_tips_view.setOnTouchListener(this);
    }

    // 터치 리스너를 구현하는 onTouch 메소드
    public boolean onTouch(View v, MotionEvent event)
    {
        // 어떤 이벤트가 발생하였는지에 따라 처리가 달라진다.
        switch (event.getAction()) {
            // DOWN 이나 MOVE 가 발생한 경우
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                // 터치가 발생한 X, Y 의 각 좌표를 얻는다.
                float x = event.getX();
                float y = event.getY();
                x_coordinate = String.valueOf((int)x);
                y_coordinate = String.valueOf((int)y);

                String str;
                // 좌표값을 이용하여 문자열을 구성한다.
                //str = "Coordinate : ( " + (int)x + ", " + (int)y + " )";
                str = x_coordinate+" "+y_coordinate;
                // 구성한 문자열을 텍스트뷰에 출력한다.
                m_text_view.setText(str);
                Intent i = new Intent(Touch_activity.this, Capstone.class);
                startActivity(i);
                m_text_view.setText("Touch Touch!!");

                break;
            case MotionEvent.ACTION_UP:
                // UP 이 발생한 경우 문자를 출력한다.
                float x1 = event.getX();
                float y1 = event.getY();
                x_coordinate = String.valueOf((int)x1);
                y_coordinate = String.valueOf((int)y1);
                break;

        }


        // false 를 반환하여 뷰 내에 재정의한 onTouchEvent 메소드로 이벤트를 전달한다.
        return false;
    }


    public String get_X(){
        Log.v(my_TAG,x_coordinate );
        return x_coordinate;

    }

    public String get_Y(){
        return y_coordinate;
    }
}
