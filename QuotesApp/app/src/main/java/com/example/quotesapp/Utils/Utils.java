package com.example.quotesapp.Utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;

import com.example.quotesapp.R;

public class Utils {
    public static final String WALLPAPER_DIRECTORY_NAME = "Status Saver Images";
    public static void copyTextToClipBoard(String text, Activity activity) {
        ClipboardManager clipboard = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
//        ClipData clip = ClipData.newPlainText(label, text);
        ClipData clip = ClipData.newPlainText(text, text);
        clipboard.setPrimaryClip(clip);
    }

    public static void shareText(Activity activity, String text) {
        /*Create an ACTION_SEND Intent*/
        Intent intent = new Intent(Intent.ACTION_SEND);
        /*This will be the actual content you wish you share.*/
        /*The type of the content is text, obviously.*/
        intent.setType("text/plain");
        /*Applying information Subject and Body.*/
        intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        /*Fire!*/
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getString(R.string.share)));
    }

    public static final String[] imgPaths = {
            "https://cdn.pixabay.com/photo/2017/12/31/15/56/portrait-3052641__340.jpg",
            "https://images.unsplash.com/photo-1487695793814-e7d704090ebf?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTl8fGFsb25lfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=400&q=60",
            "https://images.unsplash.com/photo-1546521677-b3a9b11bee6f?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8YW1hemluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60",
            "https://images.unsplash.com/photo-1609852234838-147db6815968?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YW5nZXJ8ZW58MHx8MHx8&auto=format&fit=crop&w=400&q=60",
            "https://images.unsplash.com/photo-1617201460038-6e5555a8a1f5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YW5pdmVyc2FyeXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=400&q=60",
            "https://images.unsplash.com/photo-1511818966892-d7d671e672a2?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8YXJjaGl0ZWN0dXJlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=400&q=60",
            "https://cdn.pixabay.com/photo/2019/02/14/07/28/painting-3995999__340.jpg",
            "https://cdn.pixabay.com/photo/2014/11/21/00/09/man-539993__340.jpg",
            "https://cdn.pixabay.com/photo/2014/09/14/18/04/dandelion-445228__340.jpg",
            "https://cdn.pixabay.com/photo/2016/11/30/12/16/question-mark-1872665__340.jpg",
            "https://cdn.pixabay.com/photo/2016/05/28/00/06/gift-1420830__340.jpg",
            "https://cdn.pixabay.com/photo/2014/12/08/21/25/innovation-561388__340.jpg",
            "https://cdn.pixabay.com/photo/2016/11/22/23/44/porsche-1851246__340.jpg",
            "https://cdn.pixabay.com/photo/2016/03/22/15/39/board-1273117__340.jpg",
            "https://cdn.pixabay.com/photo/2017/04/23/19/30/earth-2254769__340.jpg",
            "https://cdn.pixabay.com/photo/2016/04/04/14/12/monitor-1307227__340.jpg",
            "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832__340.jpg",
            "https://cdn.pixabay.com/photo/2016/09/27/03/39/overcoming-1697546__340.jpg",
            "https://cdn.pixabay.com/photo/2017/09/21/01/04/father-2770301__340.jpg",
            // here rose link will lie
            "https://cdn.pixabay.com/photo/2020/10/09/13/12/man-5640540__340.jpg",
            "https://cdn.pixabay.com/photo/2018/03/30/15/11/deer-3275594__340.jpg",
            "https://images.pexels.com/photos/4137772/pexels-photo-4137772.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1510659/pexels-photo-1510659.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/355948/pexels-photo-355948.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/414837/pexels-photo-414837.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1000445/pexels-photo-1000445.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/210979/pexels-photo-210979.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/3771129/pexels-photo-3771129.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/10199448/pexels-photo-10199448.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1456951/pexels-photo-1456951.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2568539/pexels-photo-2568539.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/236151/pexels-photo-236151.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/210600/pexels-photo-210600.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/841131/pexels-photo-841131.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/461198/pexels-photo-461198.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/4116540/pexels-photo-4116540.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/296282/pexels-photo-296282.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/754769/pexels-photo-754769.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/207983/pexels-photo-207983.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/367903/pexels-photo-367903.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/169523/pexels-photo-169523.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/3684345/pexels-photo-3684345.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/653429/pexels-photo-653429.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/959256/bundestag-reichstag-berlin-bundestagswahl-959256.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2292837/pexels-photo-2292837.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1024792/pexels-photo-1024792.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/12211/pexels-photo-12211.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/806427/pexels-photo-806427.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/208674/pexels-photo-208674.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/731082/pexels-photo-731082.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/401213/pexels-photo-401213.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/6310004/pexels-photo-6310004.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/5641973/pexels-photo-5641973.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1742370/pexels-photo-1742370.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/54101/magic-cube-cube-puzzle-play-54101.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/3771677/pexels-photo-3771677.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/159751/book-address-book-learning-learn-159751.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/5598284/pexels-photo-5598284.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/167682/pexels-photo-167682.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/5668473/pexels-photo-5668473.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/91224/pexels-photo-91224.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1187079/pexels-photo-1187079.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/265856/pexels-photo-265856.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/139398/thermometer-headache-pain-pills-139398.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1172207/pexels-photo-1172207.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/3270224/pexels-photo-3270224.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/47344/dollar-currency-money-us-dollar-47344.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/910411/pexels-photo-910411.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2045600/pexels-photo-2045600.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/265685/pexels-photo-265685.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/12950379/pexels-photo-12950379.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/572897/pexels-photo-572897.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1166990/pexels-photo-1166990.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/10412889/pexels-photo-10412889.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1001990/pexels-photo-1001990.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/752473/pexels-photo-752473.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2194261/pexels-photo-2194261.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1526049/pexels-photo-1526049.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1550337/pexels-photo-1550337.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/193821/pexels-photo-193821.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1458696/pexels-photo-1458696.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/161276/moscow-cathedral-mosque-prospekt-mira-ramadan-sky-161276.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/6140469/pexels-photo-6140469.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/670720/pexels-photo-670720.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1366942/pexels-photo-1366942.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/208147/pexels-photo-208147.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2926723/pexels-photo-2926723.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/46798/the-ball-stadion-football-the-pitch-46798.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/163403/box-sport-men-training-163403.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/1134190/pexels-photo-1134190.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/12321713/pexels-photo-12321713.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/3862130/pexels-photo-3862130.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2582937/pexels-photo-2582937.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/4100647/pexels-photo-4100647.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2072165/pexels-photo-2072165.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/707676/pexels-photo-707676.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/2901209/pexels-photo-2901209.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/814544/pexels-photo-814544.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/4116661/pexels-photo-4116661.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/78783/submachine-gun-rifle-automatic-weapon-weapon-78783.jpeg?auto=compress&cs=tinysrgb&w=600",
            "https://images.pexels.com/photos/313707/pexels-photo-313707.jpeg?auto=compress&cs=tinysrgb&w=600",
    };
}
