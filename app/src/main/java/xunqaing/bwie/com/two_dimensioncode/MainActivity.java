package xunqaing.bwie.com.two_dimensioncode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

//http://blog.csdn.net/zhengxiaoyao0716/article/details/50129437

//  android:theme="@style/Theme.AppCompat"


public class MainActivity extends Activity {

    private TextView textView;

    private ImageView qrImgImageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent i = new Intent(MainActivity.this, CaptureActivity.class);
//        startActivity(i);

        //打开扫描界面扫描条形码或二维码

        textView = (TextView) findViewById(R.id.result_button_view);

        qrImgImageView = (ImageView)findViewById(R.id.gen_id);

    }
    //扫描
    public void scannner(View view){
        Intent openCameraIntent = new Intent(this, CaptureActivity.class);
        startActivityForResult(openCameraIntent, 0);
    }

    public void gener_pic(View view){
        String contentString = "寻寻最帅气";
        if (!contentString.equals("")) {
            //根据字符串生成二维码图片并显示在界面上，第二个参数为图片的大小（350*350）
//            Bitmap qrCodeBitmap = EncodingUtils.createQRCode(contentString, 350, 350,
//                    BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

            //扫描不带图片的二维码
            Bitmap qrCodeBitmap = EncodingUtils.createQRCode2(contentString, 350, 350);

            qrImgImageView.setImageBitmap(qrCodeBitmap);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            textView.setText(scanResult);
        }
    }
}
