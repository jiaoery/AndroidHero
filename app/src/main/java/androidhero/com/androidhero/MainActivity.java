package androidhero.com.androidhero;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import androidhero.com.androidhero.adapter.MainAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener{

    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.auto_completedtextview)
    AutoCompleteTextView auto_completedtextview;
    @BindView(R2.id.main_listview)
    ListView main_listview;
    //跳转键值对
    Map<String, String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar(toolbar, getString(R.string.app_name));
        initView();
    }

    private void initView() {
        //获取数据
        String[] titles = getResources().getStringArray(R.array.main_title);
        String[] classes = getResources().getStringArray(R.array.clsses_array);
        for (int i = 0; i < titles.length; i++) {
            map.put(titles[i], classes[i]);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.only_textview, titles);
        auto_completedtextview.setAdapter(arrayAdapter);
        MainAdapter adapter=new MainAdapter(titles,this);
        main_listview.setAdapter(adapter);
        auto_completedtextview.setOnItemClickListener(this);
        main_listview.setOnItemClickListener(this);
    }

    /**
     * 跳转到指定的activity
     *
     * @param name
     */
    private void jump(String name) {
        String toclass = map.get(name);
        //显示所进入的页面
        if (toclass != null && toclass.length() > 0) {
            Class cls;
            try {
                //反射
                cls = Class.forName(toclass);
                Intent intent = new Intent(this, cls);
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "控件未找到!请重新搜索", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "控件未找到!请重新搜索", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //为顶部的输入框
        if(adapterView.getAdapter() instanceof ArrayAdapter){
            String toclass = adapterView.getItemAtPosition(i).toString();
            jump(toclass);
        }else if(adapterView.getAdapter() instanceof MainAdapter){
            //listview item点击事件
            String toclass = adapterView.getItemAtPosition(i).toString();
            jump(toclass);
        }
    }
}
