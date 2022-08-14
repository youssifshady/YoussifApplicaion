package com.example.youssifapplicaion.Classes;


public class ClassOfFireBaseOfApp {

//    public String getDiwanname() {
//        return diwanname;
//    }
//
//    public void setDiwanname(String diwanname) {
//        this.diwanname = diwanname;
//    }
//
//    private String diwanname;
   // public Member(String diwanname) {
//        this.diwanname = diwanname;
//    }

   private String poetpass;
   private String poetusername;
    private String poemname;
    private String poembody;

    public String getDonoteditpoetusername() {
        return poetusername;
    }

    public void setDonoteditpoetusername(String donoteditpoetusername) {
        this.poetusername = donoteditpoetusername;
    }



    public String getEditpoetpassword() {
        return poetpass;
    }

    public void setEditpoetpassword(String editpoetpassword) {
        this.poetpass = editpoetpassword;
    }

//    public String getPoetpass() {
//        return editpoetpassword;
//    }
//
//    public void setPoetpass(String poetpass) {
//        this.editpoetpassword = poetpass;
//    }


    public ClassOfFireBaseOfApp(String editpoetpassword , String donoteditpoetusername , String poemname, String poembody) {
        this.poemname = poemname;
        this.poembody = poembody;
        this.poetpass = editpoetpassword;
        this.poetusername = donoteditpoetusername;
    }

    public ClassOfFireBaseOfApp() {
    }

    public String getPoemname() {
        return poemname;
    }

    public void setPoemname(String poemname) {
        this.poemname = poemname;
    }

    public String getPoembody() {
        return poembody;
    }

    public void setPoembody(String poembody) {
        this.poembody = poembody;
    }


}
