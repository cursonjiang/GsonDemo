package com.cursonjiang.gsondemo;

import java.util.List;

/**
 * Created by Administrator on 6/29 0029.
 */
public class Json {

    /**
     * success_response : {"curpage":1,"pagesize":15,"app":[{"downloadurl":"http://m.zxxk.com/apk/gkbb.apk","packagename":"","appname":"学科作业通学生版","appid":19,"appstate":1},{"downloadurl":"http://m.zxxk.com/apk/gkbb.apk","packagename":"","appname":"学科作业通教师版","appid":18,"appstate":0},{"downloadurl":"http://www.zxxk.com/ArticleInfo.aspx?InfoID=242622","packagename":"","appname":"学易学堂","appid":12,"appstate":0},{"downloadurl":"http://www.zxxk.com/ArticleInfo.aspx?InfoID=196234","packagename":"","appname":"掌上e网通2014","appid":2,"appstate":1}],"allcount":["rowscount",4],"state":1,"curcount":4}
     */
    private Success_responseEntity success_response;

    public void setSuccess_response(Success_responseEntity success_response) {
        this.success_response = success_response;
    }

    public Success_responseEntity getSuccess_response() {
        return success_response;
    }

    public class Success_responseEntity {
        /**
         * curpage : 1
         * pagesize : 15
         * app : [{"downloadurl":"http://m.zxxk.com/apk/gkbb.apk","packagename":"","appname":"学科作业通学生版","appid":19,"appstate":1},{"downloadurl":"http://m.zxxk.com/apk/gkbb.apk","packagename":"","appname":"学科作业通教师版","appid":18,"appstate":0},{"downloadurl":"http://www.zxxk.com/ArticleInfo.aspx?InfoID=242622","packagename":"","appname":"学易学堂","appid":12,"appstate":0},{"downloadurl":"http://www.zxxk.com/ArticleInfo.aspx?InfoID=196234","packagename":"","appname":"掌上e网通2014","appid":2,"appstate":1}]
         * allcount : ["rowscount",4]
         * state : 1
         * curcount : 4
         */
        private int curpage;
        private int pagesize;
        private List<App> app;
        private List<String> allcount;
        private int state;
        private int curcount;

        public void setCurpage(int curpage) {
            this.curpage = curpage;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public void setApp(List<App> app) {
            this.app = app;
        }

        public void setAllcount(List<String> allcount) {
            this.allcount = allcount;
        }

        public void setState(int state) {
            this.state = state;
        }

        public void setCurcount(int curcount) {
            this.curcount = curcount;
        }

        public int getCurpage() {
            return curpage;
        }

        public int getPagesize() {
            return pagesize;
        }

        public List<App> getApp() {
            return app;
        }

        public List<String> getAllcount() {
            return allcount;
        }

        public int getState() {
            return state;
        }

        public int getCurcount() {
            return curcount;
        }

        public class App {
            /**
             * downloadurl : http://m.zxxk.com/apk/gkbb.apk
             * packagename :
             * appname : 学科作业通学生版
             * appid : 19
             * appstate : 1
             */
            private String downloadurl;
            private String packagename;
            private String appname;
            private int appid;
            private int appstate;

            public void setDownloadurl(String downloadurl) {
                this.downloadurl = downloadurl;
            }

            public void setPackagename(String packagename) {
                this.packagename = packagename;
            }

            public void setAppname(String appname) {
                this.appname = appname;
            }

            public void setAppid(int appid) {
                this.appid = appid;
            }

            public void setAppstate(int appstate) {
                this.appstate = appstate;
            }

            public String getDownloadurl() {
                return downloadurl;
            }

            public String getPackagename() {
                return packagename;
            }

            public String getAppname() {
                return appname;
            }

            public int getAppid() {
                return appid;
            }

            public int getAppstate() {
                return appstate;
            }
        }
    }
}
