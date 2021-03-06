package com.app.sample.social.data;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

import com.app.sample.social.R;
import com.app.sample.social.model.Message;
import com.app.sample.social.model.MessageDetails;
import com.app.sample.social.model.Friend;
import com.app.sample.social.model.Friend_photos;
import com.app.sample.social.model.Notif;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@SuppressWarnings("ResourceType")
public class Constant {


    public static Resources getStrRes(Context context) {
        return context.getResources();
    }

    public static String formatTime(long time) {
        // income time
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(time);

        // current time
        Calendar curDate = Calendar.getInstance();
        curDate.setTimeInMillis(System.currentTimeMillis());

        SimpleDateFormat dateFormat = null;
        if (date.get(Calendar.YEAR) == curDate.get(Calendar.YEAR)) {
            if (date.get(Calendar.DAY_OF_YEAR) == curDate.get(Calendar.DAY_OF_YEAR)) {
                dateFormat = new SimpleDateFormat("h:mm a", Locale.US);
            } else {
                dateFormat = new SimpleDateFormat("MMM d", Locale.US);
            }
        } else {
            dateFormat = new SimpleDateFormat("MMM yyyy", Locale.US);
        }
        return dateFormat.format(time);
    }


    public static float getAPIVerison() {

        Float f = null;
        try {
            StringBuilder strBuild = new StringBuilder();
            strBuild.append(android.os.Build.VERSION.RELEASE.substring(0, 2));
            f = new Float(strBuild.toString());
        } catch (NumberFormatException e) {
            Log.e("", "erro ao recuperar a versão da API" + e.getMessage());
        }

        return f.floatValue();
    }


    public static List<Friend> getFriendsData(Context ctx)  {
        List<Friend> items = new ArrayList<>();
        String s_arr[] = ctx.getResources().getStringArray(R.array.people_names);
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.people_photos);
        for (int i = 0; i < s_arr.length; i++) {
            Friend fr = new Friend(i, s_arr[i], drw_arr.getResourceId(i, -1));
            items.add(fr);
        }
        return items;
    }

    public static List<Friend_photos> getFriendsAlbumData(Context ctx)  {
        List<Friend_photos> items = new ArrayList<>();
        String album_name[] = ctx.getResources().getStringArray(R.array.friend_photo_album_name);
        TypedArray photo = ctx.getResources().obtainTypedArray(R.array.friend_photo_album_photo);
        for (int i = 0; i <album_name.length; i++) {
            items.add(new Friend_photos(i, album_name[i], photo.getResourceId(i, -1), (5+i) ));
        }
        return items;
    }




    public static List<Message> getMessageData(Context ctx)  {
        List<Message> items = new ArrayList<>();
        String s_arr[] = ctx.getResources().getStringArray(R.array.people_names);
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.people_photos);
        String s_cht[] = ctx.getResources().getStringArray(R.array.message_snippet);
        String s_date[] = ctx.getResources().getStringArray(R.array.message_date);
        for (int i = 0; i < 10; i++) {
            items.add(new Message(i, s_date[i], true, new Friend(s_arr[i+5], drw_arr.getResourceId(i+5, -1)), s_cht[i]));
        }
        return items;
    }
    public static List<MessageDetails> getMessageDetailsData(Context ctx, Friend friend)  {
        List<MessageDetails> items = new ArrayList<>();
        String s_date[] = ctx.getResources().getStringArray(R.array.message_details_date);
        String s_content[] = ctx.getResources().getStringArray(R.array.message_details_content);

        items.add(new MessageDetails(0, s_date[0], friend, s_content[0], false));
        items.add(new MessageDetails(1, s_date[1], friend, s_content[1], true));
        items.add(new MessageDetails(2, s_date[2], friend, s_content[2], false));

        return items;
    }

    public static List<Notif> getNotifData(Context ctx)  {
        List<Notif> items = new ArrayList<>();
        List<Friend> friends = getFriendsData(ctx);
        String content_arr[] = ctx.getResources().getStringArray(R.array.notif_text);
        String s_date[] = ctx.getResources().getStringArray(R.array.notif_date);
        for (int i = 0; i < content_arr.length; i++) {
            items.add(new Notif(i, s_date[i], friends.get(i), content_arr[i]));
        }
        return items;
    }




    private static int getRandomIndex(Random r, int min, int max){
        return r.nextInt(max - min) + min;
    }

    private static String[] getLoremArr(Context ctx){
        String rand_lorem[] = new String[4];
        rand_lorem[0] = ctx.getString(R.string.lorem_ipsum);
        rand_lorem[1] = ctx.getString(R.string.short_lorem_ipsum);
        rand_lorem[2] = ctx.getString(R.string.long_lorem_ipsum);
        rand_lorem[3] = ctx.getString(R.string.middle_lorem_ipsum);
        return  rand_lorem;
    }

}
