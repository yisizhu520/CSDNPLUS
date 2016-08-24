package wang.mogujun.csdnplus.geeknews.domain.model;

public class ProfileInfoBean {
    private String avatar;
    private String curjob;
    private Edu[] eduexp;
    private String industry;
    private String realname;
    private String selfdesc;
    private String skills;
    private Work[] work;

    public String getAvatar() {
        return this.avatar;
    }

    public String getCurjob() {
        return this.curjob;
    }

    public Edu[] getEdu() {
        return this.eduexp;
    }

    public String getIndustry() {
        return this.industry;
    }

    public String getRealname() {
        return this.realname;
    }

    public String getSelfdesc() {
        return this.selfdesc;
    }

    public String getSkills() {
        return this.skills;
    }

    public Work[] getWork() {
        return this.work;
    }

    public void setAvatar(String paramString) {
        this.avatar = paramString;
    }

    public void setCurjob(String paramString) {
        this.curjob = paramString;
    }

    public void setEdu(Edu[] paramArrayOfEdu) {
        this.eduexp = paramArrayOfEdu;
    }

    public void setIndustry(String paramString) {
        this.industry = paramString;
    }

    public void setRealname(String paramString) {
        this.realname = paramString;
    }

    public void setSelfdesc(String paramString) {
        this.selfdesc = paramString;
    }

    public void setSkills(String paramString) {
        this.skills = paramString;
    }

    public void setWork(Work[] paramArrayOfWork) {
        this.work = paramArrayOfWork;
    }

    public static class Edu {
        public int degree;
        public String eduenddate;
        public int eduid;
        public String edustartdate;
        public String majorstr;
        public String schoolname;
    }

    public static class Work {
        public String job;
        public int orgid;
        public String orgname;
        public String workbegindate;
        public String workdesc;
        public String workenddate;
        public int workid;
    }
}

