package androidhero.com.androidhero.chapter3;

import android.os.Bundle;
import android.support.annotation.Nullable;

import androidhero.com.androidhero.BaseActivity;
import androidhero.com.androidhero.R;

/**
 * Created by cqjix on 2017/5/19.
 */

public class TestTextview extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_text);
    }
}
