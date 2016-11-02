package com.xiaoge.fragmenttabhostdemo.activity;

import android.animation.TypeConverter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.xiaoge.fragmenttabhostdemo.R;
import com.xiaoge.fragmenttabhostdemo.utils.CacheUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyDataActivity extends BaseActivity {

    private RelativeLayout back;
    private RelativeLayout changeNickname;
    private RelativeLayout changeLoginpwd;
    private RelativeLayout changeTelphone;
    private Button quit;

//    private com.circle.www.view.CircleImageView circleImageView;
    int REQUESTCODE_CAMERA = 0;
    int REQUESTCODE_GALLERY = 1;
    int REQUESTCODE_CROP = 2;
    Bitmap changedImage;
    String newPath = null;
    Uri outputUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydata);
        initView();


    }

    private void initView() {
        back = (RelativeLayout) findViewById(R.id.back);
        changeNickname = (RelativeLayout) findViewById(R.id.change_nickname);
        changeLoginpwd = (RelativeLayout) findViewById(R.id.change_loginpwd);
        changeTelphone = (RelativeLayout) findViewById(R.id.change_Telphone);
        quit = (Button) findViewById(R.id.quit);

        back.setOnClickListener(this);
        changeNickname.setOnClickListener(this);
        changeLoginpwd.setOnClickListener(this);
        changeTelphone.setOnClickListener(this);
        quit.setOnClickListener(this);
    }


    @Override
    protected void onInnerClick(View view) {
        super.onInnerClick(view);

        switch (view.getId()) {
            case R.id.change_nickname://修改昵称
                startActivity(new Intent(mContext, ChangeNicknameActivity.class));
                break;

            case R.id.change_Telphone://修改电话
                startActivity(new Intent(mContext, ChangePhoneAcivity.class));
                break;

            case R.id.change_loginpwd://修改登录密码
                startActivity(new Intent(mContext, ChangeLoginpwdActivity.class));
                break;

            case R.id.quit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);        //先得到构造器
//                builder.setTitle("提示");                                         //设置标题
                builder.setMessage("是否确认退出");       //设置内容
//                builder.setIcon(R.mipmap.ic_launcher);   //自定义图标
                builder.setCancelable(false);           //设置是否能点击，对话框的其他区域取消

                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {     //设置其确认按钮和监听事件
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {     //设置其取消按钮和监听事件
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();       //创建对话框
                builder.show();         //显示对话框


                break;

            default:
                break;
        }
    }

    // 启用系统相机
    protected void showCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUESTCODE_CAMERA);
    }

    // 启用系统
    protected void showPhone() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*");
        startActivityForResult(intent, REQUESTCODE_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // 相机回调
        if (requestCode == REQUESTCODE_CAMERA) {

            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                changedImage = (Bitmap) bundle.get("data");
//                circleImageView.setImageBitmap(changedImage);
//            }
//        }// 相册回调
//        else if (requestCode == REQUESTCODE_GALLERY) {
//
//            if (resultCode == RESULT_OK) {
//
//                String path = FileUtils.getPictureSelectedPath(data, this);
//                newPath = CacheUtils.getImagePath(this, "sendImage/"
//                        + TypeConverter.getUUID() + ".jpg");
//                try {
//                    Bitmap bitmap = ImageResizer.decodeSampledBitmapFromFile(
//                            path, 400, 400);
//                    FileUtils.compressAndWriteFile(bitmap, this, newPath);

                    startPhotoZoom(this, Uri.fromFile(new File(newPath)));
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//        // 裁剪回调
//        else if (requestCode == REQUESTCODE_CROP) {
//            if (resultCode == RESULT_OK) {
//                try {
//                    changedImage = BitmapFactory
//                            .decodeStream(getContentResolver().openInputStream(
//                                    outputUri));
//                    circleImageView.setImageBitmap(changedImage);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }

            }
        }
    }

    private void startPhotoZoom(Activity activity, Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 100);
        intent.putExtra("outputY", 100);
        intent.putExtra("scale", true);
        intent.putExtra("return-data", false);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        activity.startActivityForResult(intent, REQUESTCODE_CROP);
    }

}
