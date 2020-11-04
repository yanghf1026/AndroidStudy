package com.example.headportrait;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends Activity {
    public int[] imageId = new int[]{R.drawable.touxiang1,R.drawable.touxiang2,R.drawable.touxiang3,R.drawable.touxiang4,R.drawable.touxiang5};//定义并初始化保存头像ID的数组
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        GridView gridview = findViewById(R.id.gridView);//获取GridView组件
        BaseAdapter adapter = new BaseAdapter() {
            /*
            获取数量
             */
            @Override
            public int getCount() {
                return imageId.length;
            }
            /*
            获取当前选项
             */
            @Override
            public Object getItem(int position) {
                return position;
            }
            /*
            获取当前选项的ID
             */
            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;//声明一个ImageView对象
                if(convertView==null){
                    imageView = new ImageView(HeadActivity.this);//实例化ImageView的对象
                    /*************设置图像的宽度和高度***************/
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    /*********************************************/
                    imageView.setPadding(5,5,5,5);//设置ImageView的内边距
                }else{
                    imageView =(ImageView)convertView;
                }
                imageView.setImageResource(imageId[position]);//为ImageView设置要显示的图片
                return imageView;
            }
        };
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = getIntent();//获取Intent对象
                        Bundle bundle = new Bundle();//实例化要传递的数据包
                        bundle.putInt("imageId",imageId[position]);//显示选中的图片
                        intent.putExtras(bundle);//将数据包保存到intent中
                        setResult(0x11,intent);//设置返回的结果码，并返回调用该Activity的Activity
                        finish();//关闭当前Activity
                    }
                }
        );
    }
}
