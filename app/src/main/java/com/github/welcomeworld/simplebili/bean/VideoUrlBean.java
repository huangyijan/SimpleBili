package com.github.welcomeworld.simplebili.bean;

import java.util.List;

public class VideoUrlBean {

    /**
     * code : 0
     * message : 0
     * ttl : 1
     * data : {"from":"local","result":"suee","quality":32,"format":"flv480","timelength":192593,"accept_format":"flv,flv720,flv480,flv360","accept_description":["高清 1080P","高清 720P","清晰 480P","流畅 360P"],"accept_quality":[80,64,32,16],"video_codecid":7,"fnver":0,"fnval":16,"video_project":true,"seek_param":"start","seek_type":"offset","dash":{"video":[{"id":16,"base_url":"https://cn-zjjh4-dx-v-05.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":410109,"codecid":7},{"id":32,"base_url":"https://cn-zjjh4-dx-v-09.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":921610,"codecid":7},{"id":64,"base_url":"https://cn-zjjh4-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-05.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":2048762,"codecid":7},{"id":80,"base_url":"https://cn-zjjh4-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-06.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":2164125,"codecid":7}],"audio":[{"id":30280,"base_url":"https://cn-zjjh4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-10.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":193663,"codecid":0},{"id":30216,"base_url":"https://cn-zjjh4-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-01.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":67176,"codecid":0}]}}
     */

    private int code;
    private String message;
    private int ttl;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * from : local
         * result : suee
         * quality : 32
         * format : flv480
         * timelength : 192593
         * accept_format : flv,flv720,flv480,flv360
         * accept_description : ["高清 1080P","高清 720P","清晰 480P","流畅 360P"]
         * accept_quality : [80,64,32,16]
         * video_codecid : 7
         * fnver : 0
         * fnval : 16
         * video_project : true
         * seek_param : start
         * seek_type : offset
         * dash : {"video":[{"id":16,"base_url":"https://cn-zjjh4-dx-v-05.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":410109,"codecid":7},{"id":32,"base_url":"https://cn-zjjh4-dx-v-09.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30032.m4s?expires=1548348900&platform=android&ssig=6tx8-wgt6Wj9IjIzKctRGg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":921610,"codecid":7},{"id":64,"base_url":"https://cn-zjjh4-dx-v-07.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-05.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30064.m4s?expires=1548348900&platform=android&ssig=ay_kEW15uMB2UEFEgIAlDg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":2048762,"codecid":7},{"id":80,"base_url":"https://cn-zjjh4-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-06.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30080.m4s?expires=1548348900&platform=android&ssig=etFB_rY6Ag7-dBR2lGVFHg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":2164125,"codecid":7}],"audio":[{"id":30280,"base_url":"https://cn-zjjh4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-10.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":193663,"codecid":0},{"id":30216,"base_url":"https://cn-zjjh4-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","backup_url":["https://cn-zjwz4-dx-v-01.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30216.m4s?expires=1548348900&platform=android&ssig=eYbCfydBYtfI4eVsEkek-g&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"],"bandwidth":67176,"codecid":0}]}
         */

        private String from;
        private String result;
        private int quality;
        private String format;
        private int timelength;
        private String accept_format;
        private int video_codecid;
        private int fnver;
        private int fnval;
        private boolean video_project;
        private String seek_param;
        private String seek_type;
        private DashBean dash;
        private List<String> accept_description;
        private List<DurlBean> durl;
        private List<Integer> accept_quality;

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public int getQuality() {
            return quality;
        }

        public void setQuality(int quality) {
            this.quality = quality;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public int getTimelength() {
            return timelength;
        }

        public void setTimelength(int timelength) {
            this.timelength = timelength;
        }

        public String getAccept_format() {
            return accept_format;
        }

        public void setAccept_format(String accept_format) {
            this.accept_format = accept_format;
        }

        public int getVideo_codecid() {
            return video_codecid;
        }

        public void setVideo_codecid(int video_codecid) {
            this.video_codecid = video_codecid;
        }

        public int getFnver() {
            return fnver;
        }

        public void setFnver(int fnver) {
            this.fnver = fnver;
        }

        public int getFnval() {
            return fnval;
        }

        public void setFnval(int fnval) {
            this.fnval = fnval;
        }

        public boolean isVideo_project() {
            return video_project;
        }

        public void setVideo_project(boolean video_project) {
            this.video_project = video_project;
        }

        public String getSeek_param() {
            return seek_param;
        }

        public void setSeek_param(String seek_param) {
            this.seek_param = seek_param;
        }

        public String getSeek_type() {
            return seek_type;
        }

        public void setSeek_type(String seek_type) {
            this.seek_type = seek_type;
        }

        public DashBean getDash() {
            return dash;
        }

        public void setDash(DashBean dash) {
            this.dash = dash;
        }

        public List<String> getAccept_description() {
            return accept_description;
        }

        public void setAccept_description(List<String> accept_description) {
            this.accept_description = accept_description;
        }

        public List<DurlBean> getDurl() {
            return durl;
        }

        public void setDurl(List<DurlBean> durl) {
            this.durl = durl;
        }

        public static class DurlBean {
            private int order;
            private int length;
            private int size;
            private String url;
            private List<String> backup_url;

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public List<String> getBackup_url() {
                return backup_url;
            }

            public void setBackup_url(List<String> backup_url) {
                this.backup_url = backup_url;
            }
        }

        public List<Integer> getAccept_quality() {
            return accept_quality;
        }

        public void setAccept_quality(List<Integer> accept_quality) {
            this.accept_quality = accept_quality;
        }

        public static class DashBean {
            private List<VideoBean> video;
            private List<AudioBean> audio;

            public List<VideoBean> getVideo() {
                return video;
            }

            public void setVideo(List<VideoBean> video) {
                this.video = video;
            }

            public List<AudioBean> getAudio() {
                return audio;
            }

            public void setAudio(List<AudioBean> audio) {
                this.audio = audio;
            }

            public static class VideoBean {
                /**
                 * id : 16
                 * base_url : https://cn-zjjh4-dx-v-05.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                 * backup_url : ["https://cn-zjwz4-dx-v-03.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-08.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30015.m4s?expires=1548348900&platform=android&ssig=Q9Q9KoN1lR-tN3iTxJLLKg&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"]
                 * bandwidth : 410109
                 * codecid : 7
                 */

                private int id;
                private String base_url;
                private int bandwidth;
                private int codecid;
                private List<String> backup_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBase_url() {
                    return base_url;
                }

                public void setBase_url(String base_url) {
                    this.base_url = base_url;
                }

                public int getBandwidth() {
                    return bandwidth;
                }

                public void setBandwidth(int bandwidth) {
                    this.bandwidth = bandwidth;
                }

                public int getCodecid() {
                    return codecid;
                }

                public void setCodecid(int codecid) {
                    this.codecid = codecid;
                }

                public List<String> getBackup_url() {
                    return backup_url;
                }

                public void setBackup_url(List<String> backup_url) {
                    this.backup_url = backup_url;
                }
            }

            public static class AudioBean {
                /**
                 * id : 30280
                 * base_url : https://cn-zjjh4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1
                 * backup_url : ["https://cn-zjwz4-dx-v-04.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1","https://cn-zjwz3-dx-v-10.acgvideo.com/upgcxcode/37/00/59840037/59840037-1-30280.m4s?expires=1548348900&platform=android&ssig=Eb8Mf82imumrAeHZYKDXQw&oi=3071419030&hfb=NzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ=&trid=ff212041d0494f85a537cdb8b7f99620&nfb=maPYqpoel5MI3qOUX6YpRA==&nfc=1"]
                 * bandwidth : 193663
                 * codecid : 0
                 */

                private int id;
                private String base_url;
                private int bandwidth;
                private int codecid;
                private List<String> backup_url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getBase_url() {
                    return base_url;
                }

                public void setBase_url(String base_url) {
                    this.base_url = base_url;
                }

                public int getBandwidth() {
                    return bandwidth;
                }

                public void setBandwidth(int bandwidth) {
                    this.bandwidth = bandwidth;
                }

                public int getCodecid() {
                    return codecid;
                }

                public void setCodecid(int codecid) {
                    this.codecid = codecid;
                }

                public List<String> getBackup_url() {
                    return backup_url;
                }

                public void setBackup_url(List<String> backup_url) {
                    this.backup_url = backup_url;
                }
            }
        }
    }
}
