package com.app.sample.social.activity_product;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.app.sample.social.MyApplication;
import com.app.sample.social.R;
import com.app.sample.social.api.Apis;
import com.app.sample.social.data.Tools;
import com.app.sample.social.model.PostProduct;
import com.app.sample.social.model.PostText;
import com.app.sample.social.posttext_presenter.PostTextContract;
import com.app.sample.social.posttext_presenter.PostTextPresenter;
import com.app.sample.social.service.ServiceApi;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import siclo.com.ezphotopicker.api.EZPhotoPick;
import siclo.com.ezphotopicker.api.EZPhotoPickStorage;
import siclo.com.ezphotopicker.api.models.EZPhotoPickConfig;
import siclo.com.ezphotopicker.api.models.PhotoSource;

public class ActivityPostPostduct extends AppCompatActivity {
    private static final String[] PERMISSIONS_READ_STORAGE = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};

    SharedPreferences sharedpreferences;
    public static final String mypreference = "login";
    String userIdPreferences;
    String timeStamp;
    ImageView img_select;

    EditText name;
    EditText desc;
    EditText price;
    EditText location;
    Button btn_post;

    String imagePath;

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_product);

        name = (EditText) findViewById(R.id.name);
        desc = (EditText) findViewById(R.id.desc);
        price = (EditText) findViewById(R.id.price);
        location = (EditText) findViewById(R.id.location);

        btn_post = (Button) findViewById(R.id.btn_post);
        img_select = (ImageView) findViewById(R.id.img_select);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        userIdPreferences = sharedpreferences.getString("userId", "null");
        timeStamp = sharedpreferences.getString("timeStamp", "null");


        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadProduct();

            }
        });

        img_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityPostPostduct.this);
                builder.setMessage("เลือกรูปภาพ")
                        .setPositiveButton("แกลอรี่", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Share
                                showImagePopup();
                            }
                        })
                        .setNegativeButton("กล้อง", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Do something on Cancel
                                // chooseCamera();
                            }
                        });
                builder.show();
            }
        });
        // for system bar in lollipop
        Tools.systemBarLolipop(this);
    }

    public void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
//        actionBar.setTitle(friend.getHtml().get(0).getName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            case R.id.action_sample:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//    private void chooseImage() {
//        EZPhotoPickConfig config = new EZPhotoPickConfig();
//        config.photoSource = PhotoSource.GALLERY;
//        config.exportingSize = 900;
//        EZPhotoPick.startPhotoPickActivity(this, config);
//    }
//
//    private void chooseCamera() {
//        EZPhotoPickConfig config = new EZPhotoPickConfig();
//        config.photoSource = PhotoSource.CAMERA;
//        config.exportingSize = 900;
//        EZPhotoPick.startPhotoPickActivity(this, config);
//    }

    public void showImagePopup() {

        // File System.
        final Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_PICK);

        // Chooser of file system options.
        final Intent chooserIntent = Intent.createChooser(galleryIntent, "รเลือกรูปภาพ");
        startActivityForResult(chooserIntent, 1010);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1010) {
            if (data == null) {

                return;
            }
            Uri selectedImageUri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imagePath = cursor.getString(columnIndex);

            } else {

            }
        }
    }

    private void uploadProduct() {


        //Create Upload Server Client
        ServiceApi service = Apis.getApis();

        //File creating from selected URL
        File file = new File(imagePath);

        // create RequestBody instance from file
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body = MultipartBody.Part.createFormData("postPhotos", file.getName(), requestFile);


        RequestBody userIdR = RequestBody.create(MediaType.parse("text/plain"), "166");
        RequestBody nameR = RequestBody.create(MediaType.parse("text/plain"), name.getText().toString());
        RequestBody timeStampR = RequestBody.create(MediaType.parse("text/plain"), timeStamp);
        RequestBody descR = RequestBody.create(MediaType.parse("text/plain"), desc.getText().toString());
        RequestBody priceR = RequestBody.create(MediaType.parse("text/plain"), price.getText().toString());
        RequestBody cat = RequestBody.create(MediaType.parse("text/plain"), "1");
        RequestBody type = RequestBody.create(MediaType.parse("text/plain"), "0");
        RequestBody locationR = RequestBody.create(MediaType.parse("text/plain"), location.getText().toString());

        Call<PostProduct> resultCall = service.postProduct(userIdR, timeStampR, nameR, descR, body, priceR, cat, type, locationR);

        // finally, execute the request
        resultCall.enqueue(new Callback<PostProduct>() {
            @Override
            public void onResponse(Call<PostProduct> call, Response<PostProduct> response) {

               Log.e("sssss",response.body().toString());
                // Response Success or Fail


                imagePath = "";

            }

            @Override
            public void onFailure(Call<PostProduct> call, Throwable t) {

            }
        });
    }
}
