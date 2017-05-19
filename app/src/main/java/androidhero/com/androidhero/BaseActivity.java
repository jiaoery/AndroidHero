package androidhero.com.androidhero;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;


/**
 * Created by heshaokang on 2015/8/5.
 * Activity基类 抽象一些公共方法
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 不传递任何参数，前往该实际Activity
     * @param target 目标Activity类
     */
    public void startActivity(Class target) {
        startActivity(new Intent(this, target));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("进入界面：", toString());
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this); // 友盟session统计
    }

    /**
     * 点击左上角图标，以便关闭当前activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(0, R.anim.slide_right_out);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * toolbar的初始化
     *
     * @param mToolBar
     * @param activityName
     */
    public void initToolbar(Toolbar mToolBar, String activityName) {
        mToolBar.setTitle("");
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        if (toolbar_title != null && !TextUtils.isEmpty(activityName)) {
            toolbar_title.setText(activityName);
        }
        initToolbar(mToolBar);
    }

    public void initToolbar(Toolbar mToolBar, int activityName) {
        mToolBar.setTitle("");
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        if (toolbar_title != null) {
            toolbar_title.setText(activityName);
        }
//        mToolBar.setTitle(activityName);
        initToolbar(mToolBar);
    }

    private void initToolbar(Toolbar mToolBar) {
        mToolBar.setTitleTextColor(getResources().getColor(R.color.common_white));
//        mToolBar.setNavigationIcon(R.drawable.icon_left);
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
    }

    protected void setToolbarName(String name) {
        TextView toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setText(name);
    }
}
