package com.github.welcomeworld.simplebili.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.github.welcomeworld.simplebili.R;
import com.github.welcomeworld.simplebili.adapter.BiliDanmukuParser;
import com.github.welcomeworld.simplebili.listener.IjkMediaListener;
import com.github.welcomeworld.simplebili.utils.FileUtils;
import com.github.welcomeworld.simplebili.utils.StringUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import master.flame.danmaku.controller.DrawHandler;
import master.flame.danmaku.controller.IDanmakuView;
import master.flame.danmaku.danmaku.loader.ILoader;
import master.flame.danmaku.danmaku.loader.IllegalDataException;
import master.flame.danmaku.danmaku.loader.android.DanmakuLoaderFactory;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.IDisplayer;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import master.flame.danmaku.danmaku.parser.BaseDanmakuParser;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class IjkMediaView extends FrameLayout implements SeekBar.OnSeekBarChangeListener,View.OnTouchListener,RadioGroup.OnCheckedChangeListener{

    private String TAG="IjkMediaView";

    private IjkMediaPlayer mMediaPlayer = null;
    /** * 视频文件地址 */
    private ArrayList<String> paths=null;
    private ArrayList<String> titles=null;
    private String currentPath="";
    private Context mContext;

    GestureDetector gestureDetector;

    AudioManager audioManager;

    DanmakuContext danmakuContext;
    BaseDanmakuParser baseDanmakuParser;

    PopupWindow moreOptions;

    PopupWindow videoListPopupWindow;

    Observable<Long> videoObservable;
    Disposable videoDisposable;


    //RootView
    @BindView(R.id.surface)
    SurfaceView surfaceView;
    @BindView(R.id.pauseOrStart)
    ImageView pauseOrStartButton;
    @BindView(R.id.seek_bar)
    SeekBar seekBar;
    @BindView(R.id.current_position)
    TextView currentPosition;
    @BindView(R.id.duration)
    TextView durationView;
    @BindView(R.id.player_bottom)
    LinearLayout bottomLayout;
    @BindView(R.id.fullscreen)
    ImageView fullscreenButton;
    @BindView(R.id.player_top)
    LinearLayout topLayout;
    @BindView(R.id.lock)
    ImageView lockView;
    @BindView(R.id.cover)
    ImageView coverView;
    @BindView(R.id.share)
    ImageView shareView;
    @BindView(R.id.play_back)
    ImageView backButton;
    @BindView(R.id.play_title)
    TextView titleView;
    @BindView(R.id.player_volume)
    LinearLayout volumeLayout;
    @BindView(R.id.volume_seekbar)
    SeekBar volumeSeekBar;
    @BindView(R.id.volume_image)
    ImageView volumeImage;
    @BindView(R.id.player_bright)
    LinearLayout brightLayout;
    @BindView(R.id.bright_seekbar)
    SeekBar brightSeekBar;
    @BindView(R.id.fastfoward)
    TextView fastfowardView;
    @BindView(R.id.danmaku_status)
    ImageView danmakuStatusButton;
    @BindView(R.id.more)
    ImageView playerMoreButton;
    @BindView(R.id.play_video_list)
    TextView videoListButton;
    @BindView(R.id.danmaku_view)
    IDanmakuView danmakuView;





    //status
    private int INVALID_CODE=-1;
    private boolean locked=false;
    private boolean subViewHidded=false;
    private long progress=0;
    private long duration=0;
    private final int SEEKBAR_MAX=1000;
    private boolean volumechanging=false;
    private boolean brightchanging=false;
    private boolean fastfowarding=false;
    private int VOLUME_MAX=INVALID_CODE;
    private int screen_width=INVALID_CODE;
    private int screen_height=INVALID_CODE;
    private double lastXpercentage=0;
    private double lastYpercentage=0;
    private static final long FASTFORWARD_MAX=180000;
    private long fastforward_record=0;
    private float speed=1;
    private boolean systemBack=true;
    private int playMode=1;
    private boolean seekBarTracking=false;
    private boolean stopChangeSeek=false;

    private IjkMediaListener listener;

    public IjkMediaView(@NonNull Context context) {
        super(context);
        mContext=context;
        initVideoView(context);
    }
    public IjkMediaView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initVideoView(context);
    }
    public IjkMediaView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initVideoView(context);
    }

    @SuppressLint("UseSparseArrays")
    private void initDanmaku() {
         HashMap<Integer,Integer> maxLinesPair=new HashMap<>();
        maxLinesPair.put(BaseDanmaku.TYPE_SCROLL_RL,5);
        HashMap<Integer,Boolean> overlappingEnable=new HashMap<>();
        overlappingEnable.put(BaseDanmaku.TYPE_FIX_TOP,true);
        overlappingEnable.put(BaseDanmaku.TYPE_SCROLL_RL,true);
        danmakuContext=DanmakuContext.create();
        danmakuContext.setDanmakuStyle(IDisplayer.DANMAKU_STYLE_STROKEN,3);
        danmakuContext.setDuplicateMergingEnabled(false);
        danmakuContext.setMaximumLines(maxLinesPair);
        danmakuContext.setScaleTextSize(1);
        danmakuContext.setScrollSpeedFactor(1);
        danmakuContext.preventOverlapping(overlappingEnable);
        InputStream danmakuInputStream= null;
        if(currentPath.startsWith("file")){
            File danmakuFile=new File(currentPath.substring(0,currentPath.lastIndexOf('.'))+".xml");
            if(!danmakuFile.exists()){
                try {
                    if(!danmakuFile.createNewFile()){
                       Log.e(TAG,"create file fail");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                danmakuInputStream = new FileInputStream(danmakuFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        baseDanmakuParser=createDanmakuParser(danmakuInputStream);
        danmakuView.setCallback(new DrawHandler.Callback() {
            @Override
            public void prepared() {
                if(mMediaPlayer.isPlaying()){
                    danmakuView.start(mMediaPlayer.getCurrentPosition());
                }
            }

            @Override
            public void updateTimer(DanmakuTimer timer) {

            }

            @Override
            public void danmakuShown(BaseDanmaku danmaku) {

            }

            @Override
            public void drawingFinished() {

            }
        });
        danmakuView.prepare(baseDanmakuParser,danmakuContext);
        danmakuView.enableDanmakuDrawingCache(true);
    }

    private BaseDanmakuParser createDanmakuParser(InputStream inputStream){
        if(inputStream==null){
            return new BaseDanmakuParser() {
                @Override
                protected IDanmakus parse() {
                    return new Danmakus();
                }
            };
        }
        ILoader iLoader= DanmakuLoaderFactory.create(DanmakuLoaderFactory.TAG_BILI);
        try {
            iLoader.load(inputStream);
        } catch (IllegalDataException e) {
            e.printStackTrace();
        }
        BaseDanmakuParser parser=new BiliDanmukuParser();
        parser.load(iLoader.getDataSource());
        return parser;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }



    @SuppressLint("ClickableViewAccessibility")
    private void initVideoView(Context context) {
        setFocusable(true);
        View rootView=LayoutInflater.from(context).inflate(R.layout.ijkmediaview,this,true);
        ButterKnife.bind(rootView);
        createSurfaceView();
        gestureDetector=new GestureDetector(context,new PlayerGestureDetectorListener());
        audioManager= (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
        this.setOnTouchListener(this);
        seekBar.setMax(SEEKBAR_MAX);
        seekBar.setOnSeekBarChangeListener(this);
        brightSeekBar.setMax(SEEKBAR_MAX);
        volumeSeekBar.setMax(SEEKBAR_MAX);
        int settingBrightness;
        try {
            settingBrightness= Settings.System.getInt(mContext.getContentResolver(),Settings.System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            settingBrightness=125;
            e.printStackTrace();
        }
        brightSeekBar.setProgress(settingBrightness*SEEKBAR_MAX/255);
        Activity activity= (Activity) context;
        WindowManager.LayoutParams layoutParams=activity.getWindow().getAttributes();
        layoutParams.screenBrightness=settingBrightness/(float)255;
        activity.getWindow().setAttributes(layoutParams);
        initPopupWindow();
        videoObservable=Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                while(!stopChangeSeek){
                    try {
                        emitter.onNext(1L);
                        Thread.sleep((long) (1000/speed));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    private void initPopupWindow(){
        screen_height=getResources().getDisplayMetrics().heightPixels;
        screen_width=getResources().getDisplayMetrics().widthPixels;
        if (screen_width < screen_height) {
            int temp=screen_width;
            screen_width=screen_height;
            screen_height=temp;
        }
        View popupView=LayoutInflater.from(mContext).inflate(R.layout.player_more,this,false);
        moreOptions=new PopupWindow(popupView,screen_width/2,screen_height,true);
        moreOptions.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        moreOptions.setTouchable(true);
        moreOptions.setAnimationStyle(R.style.rightPopupWindowTheme);
        RadioGroup speedList=popupView.findViewById(R.id.play_speed_list);
        speedList.setOnCheckedChangeListener(this);
        RadioGroup sizeList=popupView.findViewById(R.id.size_list);
        sizeList.setOnCheckedChangeListener(this);
        RadioGroup wayList=popupView.findViewById(R.id.play_way);
        wayList.setOnCheckedChangeListener(this);
    }

    public void setVideoPath(Uri uri){
        paths=new ArrayList<>();
        titles=new ArrayList<>();
        if(uri.getScheme().equalsIgnoreCase("http")||uri.getScheme().equalsIgnoreCase("https")){
            Log.e(TAG,""+uri.getScheme());
            paths.add(uri.toString());
            titles.add("http");
            setVideoPaths(paths,titles,0);
            return;
        }
        String path= FileUtils.getPath(mContext,uri);
        File pathDir;
        if(path!=null&&path.lastIndexOf('/')>0){
            pathDir=new File(path.substring(0,path.lastIndexOf('/')));
        }else{
            return;
        }
        if(pathDir.listFiles()==null||pathDir.listFiles().length<1){
            paths.add(path);
            titles.add(path);
            setVideoPaths(paths,titles,0);
            return;
        }
        for(File child:pathDir.listFiles()){
            if(!child.isDirectory()){
                if(child.getName().endsWith("mp4")){
                    paths.add(child.getAbsolutePath());
                    titles.add(child.getAbsolutePath().substring(child.getAbsolutePath().lastIndexOf('/')+1,child.getAbsolutePath().length()));
                }
            }
        }
        setVideoPaths(paths,titles,paths.indexOf(path));
    }

    public void setVideoPaths(ArrayList<String>paths,ArrayList<String> titles,int currentIndex) {
        this.titles=titles;
        this.paths=paths;
        currentPath=paths.get(currentIndex);
        titleView.setText(titles.get(currentIndex));
        load();
        initVideoListWindow();
    }

    private void initVideoListWindow(){
        View videoListView=LayoutInflater.from(mContext).inflate(R.layout.player_video_list,this,false);
        screen_height=getResources().getDisplayMetrics().heightPixels;
        screen_width=getResources().getDisplayMetrics().widthPixels;
        if (screen_width < screen_height) {
            int temp=screen_width;
            screen_width=screen_height;
            screen_height=temp;
        }
        videoListPopupWindow=new PopupWindow(videoListView,screen_width/2,screen_height,true);
        videoListPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        videoListPopupWindow.setTouchable(true);
        videoListPopupWindow.setAnimationStyle(R.style.rightPopupWindowTheme);
       RadioGroup radioGroup=videoListView.findViewById(R.id.video_list_radio);
       for(int i=0;i<paths.size();i++){
           RadioButton radioButton=new RadioButton(radioGroup.getContext());
           radioButton.setButtonDrawable(null);
           radioButton.setTextColor(getResources().getColorStateList(R.color.radio_color));
           radioButton.setText(paths.get(i));
           if(paths.get(i).equalsIgnoreCase(currentPath)){
               radioButton.setChecked(true);
           }
           radioButton.setId(i);
           radioGroup.addView(radioButton);
       }
       radioGroup.setOnCheckedChangeListener(this);
    }



    private void createSurfaceView() {
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.e(TAG,"surfaceCreated");
                if(currentPath!=null&&!currentPath.trim().equals("")){
                    load();
                }
            }
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    @OnClick(R.id.pauseOrStart)
    public void pauseOrStart(){
        if(mMediaPlayer!=null){
            if(mMediaPlayer.isPlaying()){
                pause();
            }else{
                start();
            }
        }
    }

    @OnClick(R.id.fullscreen)
    public void fullscreen(){
        changeToLandscape();
        systemBack=false;
    }

    @OnClick(R.id.lock)
    public void lockOrUnlock(){
        if(locked){
            locked=false;
            lockView.setSelected(false);
            showSubView();
        }else{
            locked=true;
            lockView.setSelected(true);
            hideSubView();
        }
    }

    @OnClick(R.id.share)
    public void shareVideo(){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,currentPath);
        mContext.startActivity(Intent.createChooser(intent,"分享到:"));
    }

    @OnClick(R.id.player_top)
    public void topDoNothing(){}

    @OnClick(R.id.player_bottom)
    public void bottomDoNothing(){}

    @OnClick(R.id.play_back)
    public void playBack(){
        if(isSystemBack()){
            Activity activity= (Activity) mContext;
            activity.onBackPressed();
            mMediaPlayer.reset();
            mMediaPlayer.release();
        }else{
            systemBack=true;
            changeToPortrait();
        }
    }

    @OnClick(R.id.danmaku_status)
    public void danmakuStatusChange(){
        if(danmakuStatusButton.isSelected()){
            danmakuStatusButton.setSelected(false);
            danmakuView.show();
        }else{
            danmakuStatusButton.setSelected(true);
            danmakuView.hide();
        }
    }

    @OnClick(R.id.more)
    public void moreOptions(){
        moreOptions.showAtLocation(this,Gravity.END,0,0);
    }

    @OnClick(R.id.play_video_list)
    public void showVideoList(){
        videoListPopupWindow.showAtLocation(this,Gravity.END,0,0);
    }

    /** * 加载视频 */
    private void load() {
        coverView.setVisibility(VISIBLE);
        createPlayer();
        try {
            mMediaPlayer.setDataSource(currentPath);
            }
            catch (Exception e) {
            e.printStackTrace();
            }
        mMediaPlayer.setDisplay(surfaceView.getHolder());
        mMediaPlayer.prepareAsync();
        initDanmaku();
        }
     private void createPlayer() {
                    if (mMediaPlayer != null) {
                        mMediaPlayer.stop();
                        mMediaPlayer.setDisplay(null);
                        mMediaPlayer.release();
                    }
                    IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
                    IjkMediaPlayer.native_setLogLevel(IjkMediaPlayer.IJK_LOG_DEBUG);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "mediacodec", 1);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER,"max-buffer-size",500*1024);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, "min-frames", 100);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER,"enable-accurate-seek",1);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT,"reconnect",1);
                    ijkMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER,"framedrop",5);
                    mMediaPlayer = ijkMediaPlayer;
                    if(listener==null){
                        listener=new IjkMediaListener() {
                            @Override
                            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                                    seekBar.setSecondaryProgress(i*SEEKBAR_MAX/100);
                            }

                            @Override
                            public void onCompletion(IMediaPlayer iMediaPlayer) {
                                Log.e(TAG,"onCompletion");
                                switch (playMode){
                                    case 0:
                                        pause();
                                        break;
                                    case 1:
                                        if(paths.indexOf(currentPath)<paths.size()-1){
                                            currentPath=paths.get(paths.indexOf(currentPath)+1);
                                            load();
                                        }else{
                                            pause();
                                        }
                                        break;
                                    case 2:
                                        currentPath=paths.indexOf(currentPath)>=paths.size()-1?paths.get(0):paths.get(paths.indexOf(currentPath)+1);
                                        load();
                                        break;
                                    case 3:
                                        break;
                                }
                            }

                            @Override
                            public boolean onError(IMediaPlayer iMediaPlayer, int i, int i1) {
                                Log.e(TAG,"error_code"+i+":"+i1);
                                return false;
                            }

                            @Override
                            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i1) {
                                Log.e(TAG,"onInfo:i:"+i+"i1:"+i1);
                                return false;
                            }

                            @Override
                            public void onPrepared(IMediaPlayer iMediaPlayer) {
                                duration=mMediaPlayer.getDuration();
                                currentPosition.setText(StringUtils.formatTime(0));
                                durationView.setText(StringUtils.formatTime(duration));
                                coverView.setVisibility(GONE);
                                pauseOrStartButton.setSelected(true);
                                if(danmakuView.isPrepared()){
                                    danmakuView.start();
                                }
                                videoDisposable= videoObservable.subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long ong) {
                                        if(!fastfowarding&&!seekBarTracking&&mMediaPlayer.isPlaying()){
                                            currentPosition.setText(StringUtils.formatTime(mMediaPlayer.getCurrentPosition()));
                                            seekBar.setProgress((int) (mMediaPlayer.getCurrentPosition()*SEEKBAR_MAX/duration));
                                        }
                                    }
                                });
                            }

                            @Override
                            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                                Log.e(TAG,"Player seek:"+iMediaPlayer.getCurrentPosition());
                            }

                            @Override
                            public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i1, int i2, int i3) {

                            }
                        };
                    }
                    mMediaPlayer.setOnPreparedListener(listener);
                    mMediaPlayer.setOnInfoListener(listener);
                    mMediaPlayer.setOnSeekCompleteListener(listener);
                    mMediaPlayer.setOnCompletionListener(listener);
                    mMediaPlayer.setOnBufferingUpdateListener(listener);
                    mMediaPlayer.setOnErrorListener(listener);
                    mMediaPlayer.setOnVideoSizeChangedListener(listener);
                }
    private void hideSubView(){
        subViewHidded=true;
        bottomLayout.setVisibility(GONE);
        topLayout.setVisibility(GONE);
        lockView.setVisibility(GONE);
    }
    private void showSubView(){
        subViewHidded=false;
        if(!locked){
            bottomLayout.setVisibility(VISIBLE);
            topLayout.setVisibility(VISIBLE);
        }
        lockView.setVisibility(VISIBLE);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.progress=progress;
        if(seekBarTracking){
            currentPosition.setText(StringUtils.formatTime(progress*duration/SEEKBAR_MAX));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        seekBarTracking=true;
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.e(TAG,"onStopTracking0:"+mMediaPlayer.getCurrentPosition());
        mMediaPlayer.seekTo(progress*duration/SEEKBAR_MAX);
        Log.e(TAG,"onStopTracking1:"+mMediaPlayer.getCurrentPosition());
        danmakuView.seekTo(mMediaPlayer.getCurrentPosition());
        currentPosition.setText(StringUtils.formatTime(mMediaPlayer.getCurrentPosition()));
        seekBarTracking=false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            if(fastfowarding){
                fastfowarding=false;
                fastfowardView.setVisibility(GONE);
                mMediaPlayer.seekTo(fastforward_record);
                fastforward_record=0;
                lastXpercentage=0;
            }
            if(brightchanging||volumechanging){
                Observable<Integer> observable=Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        Thread.sleep(1000);
                        emitter.onNext(1);
                        emitter.onComplete();
                    }
                });
                        Disposable disposable=observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) {
                                if(!brightchanging&&!volumechanging&&!fastfowarding){
                                    brightLayout.setVisibility(GONE);
                                    volumeLayout.setVisibility(GONE);
                                }
                            }
                        });
            }
            brightchanging=false;
            volumechanging=false;
            lastYpercentage=0;
        }
        gestureDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(group.getId()==R.id.play_speed_list){
            switch (checkedId){
                case R.id.speed_0_5:
                    mMediaPlayer.setSpeed(0.5f);
                    speed=0.5f;
                    break;
                case R.id.speed_0_75:
                    mMediaPlayer.setSpeed(0.75f);
                    speed=0.75f;
                    break;
                case R.id.speed_1:
                    mMediaPlayer.setSpeed(1f);
                    speed=1f;
                    break;
                case R.id.speed_1_25:
                    mMediaPlayer.setSpeed(1.25f);
                    speed=1.25f;
                    break;
                case R.id.speed_1_5:
                    mMediaPlayer.setSpeed(1.5f);
                    speed=1.5f;
                    break;
                case R.id.speed_2:
                    mMediaPlayer.setSpeed(2f);
                    speed=2f;
                    break;
            }
            if(mMediaPlayer.getCurrentPosition()-danmakuView.getCurrentTime()>1000||mMediaPlayer.getCurrentPosition()-danmakuView.getCurrentTime()<-1000){
                danmakuView.seekTo(mMediaPlayer.getCurrentPosition());
            }
        }
        if(group.getId()==R.id.size_list){
            ViewGroup.LayoutParams layoutParams;
            screen_height=getResources().getDisplayMetrics().heightPixels;
            screen_width=getResources().getDisplayMetrics().widthPixels;
            switch (checkedId){
                case R.id.size_default:
                    layoutParams=surfaceView.getLayoutParams();
                    layoutParams.width=mMediaPlayer.getVideoWidth();
                    layoutParams.height=mMediaPlayer.getVideoHeight();
                    surfaceView.setLayoutParams(layoutParams);
                    break;
                case R.id.size_fullscreen:
                    layoutParams=surfaceView.getLayoutParams();
                    layoutParams.width=screen_width;
                    layoutParams.height=screen_height;
                    surfaceView.setLayoutParams(layoutParams);
                    break;
                case R.id.size_4_3:
                    layoutParams=surfaceView.getLayoutParams();
                    layoutParams.width=screen_height*4/3;
                    layoutParams.height=screen_height;
                    surfaceView.setLayoutParams(layoutParams);
                    break;
                case R.id.size_16_9:
                    layoutParams=surfaceView.getLayoutParams();
                    layoutParams.width=screen_height*16/9;
                    layoutParams.height=screen_height;
                    surfaceView.setLayoutParams(layoutParams);
                    break;
            }
        }
        if(group.getId()==R.id.play_way){
            switch (checkedId){
                case R.id.playway_pause:
                    playMode=0;
                    mMediaPlayer.setLooping(false);
                    break;
                case R.id.playway_auto:
                    playMode=1;
                    mMediaPlayer.setLooping(false);
                    break;
                case R.id.playway_list_recycle:
                    playMode=2;
                    mMediaPlayer.setLooping(false);
                    break;
                case R.id.playway_item_recycle:
                    playMode=3;
                    mMediaPlayer.setLooping(true);
                    break;
            }
        }
        if(group.getId()==R.id.video_list_radio){
            currentPath=paths.get(checkedId);
            load();
        }

    }

    class PlayerGestureDetectorListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if(!locked){
                pauseOrStart();
                return true;
            }
            return false;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if(subViewHidded){
                subViewHidded=false;
                showSubView();
            }else{
                subViewHidded=true;
                hideSubView();
            }
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if(locked){
                return false;
            }
            String fastfowardText;
            screen_height=getResources().getDisplayMetrics().heightPixels;
            screen_width=getResources().getDisplayMetrics().widthPixels;
            double change;
            double xpercentage= -distanceX/screen_width+lastXpercentage;
            double ypercentage= distanceY/screen_height+lastYpercentage;
            if(!brightchanging&&!volumechanging&&!fastfowarding){
                if(xpercentage>0.1||xpercentage<-0.1){
                    fastfowarding=true;
                    brightLayout.setVisibility(GONE);
                    volumeLayout.setVisibility(GONE);
                    fastforward_record=mMediaPlayer.getCurrentPosition();
                    fastfowardText=StringUtils.formatTime(fastforward_record)+"/"+StringUtils.formatTime(duration);
                    fastfowardView.setText(fastfowardText);
                    fastfowardView.setVisibility(VISIBLE);
                }else if(ypercentage>0.1||ypercentage<-0.1){
                    if(e1.getX()<screen_width/2){
                        brightchanging=true;
                        volumeLayout.setVisibility(GONE);
                        fastfowardView.setVisibility(GONE);
                        brightLayout.setVisibility(VISIBLE);
                    }else{
                        volumechanging  =true;
                        brightLayout.setVisibility(GONE);
                        fastfowardView.setVisibility(GONE);
                        volumeLayout.setVisibility(VISIBLE);
                        VOLUME_MAX=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
                    }
                }else{
                    lastYpercentage=ypercentage;
                    lastXpercentage=xpercentage;
                }
                return false;
            }
            if(brightchanging){
                Activity activity= (Activity) mContext;
                WindowManager.LayoutParams layoutParams=activity.getWindow().getAttributes();
                change=ypercentage+brightSeekBar.getProgress()/(double) SEEKBAR_MAX<0?0:ypercentage+brightSeekBar.getProgress()/(double) SEEKBAR_MAX;
                change=change>1?1:change;
                layoutParams.screenBrightness= (float) (change);
                activity.getWindow().setAttributes(layoutParams);
                brightSeekBar.setProgress((int) (brightSeekBar.getProgress()+ypercentage*SEEKBAR_MAX));
                lastYpercentage=0;
            }else if(fastfowarding){
                change=xpercentage*FASTFORWARD_MAX+fastforward_record>duration?duration:xpercentage*FASTFORWARD_MAX+fastforward_record;
                fastforward_record= (long) change;
                fastfowardText=StringUtils.formatTime(fastforward_record)+"/"+StringUtils.formatTime(duration);
                fastfowardView.setText(fastfowardText);
                seekBar.setProgress((int) (change*SEEKBAR_MAX/duration));
                currentPosition.setText(StringUtils.formatTime(fastforward_record));
                lastXpercentage=0;
            }else {
                int volume_current = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                if(1>ypercentage*VOLUME_MAX&&ypercentage*VOLUME_MAX>-1){
                    lastYpercentage=ypercentage;
                    return false;
                }
                change=ypercentage*VOLUME_MAX>0?Math.floor(ypercentage*VOLUME_MAX):Math.ceil(ypercentage*VOLUME_MAX);
                if(change+ volume_current <=0){
                    volumeImage.setSelected(true);
                }else{
                    volumeImage.setSelected(false);
                }
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, (int) change+ volume_current,0);
                volumeSeekBar.setProgress((int) ((change+ volume_current)*SEEKBAR_MAX/VOLUME_MAX));
                lastYpercentage=0;
            }
            return false;
        }


    }

    public boolean isSystemBack() {
        return systemBack;
    }

    public void changeToLandscape(){
        Activity activity= (Activity) mContext;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT,Gravity.CENTER);
        setLayoutParams(layoutParams);
        fullscreenButton.setVisibility(GONE);
        videoListButton.setVisibility(VISIBLE);
    }

    public void changeToPortrait(){
        Activity activity= (Activity) mContext;
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT,Gravity.CENTER);
        layoutParams.height=560;
        setLayoutParams(layoutParams);
        fullscreenButton.setVisibility(VISIBLE);
        videoListButton.setVisibility(GONE);
    }

    public void pause(){
        if(mMediaPlayer!=null){
            mMediaPlayer.pause();
            pauseOrStartButton.setSelected(false);
            danmakuView.pause();
        }
    }

    public void start(){
        coverView.setVisibility(GONE);
        mMediaPlayer.start();
        pauseOrStartButton.setSelected(true);
        if(danmakuView.isPrepared()){
            danmakuView.start(mMediaPlayer.getCurrentPosition());
        }
    }
}