package com.example.vkapp.Database;

public class Employee {
    private int COL_ID;
    private String COL_NAME;
    //private String COL_WORK;
    //private String PEN_CUT;
    //private String DONE_CUT;

    public Employee(int COL_ID,String COL_NAME){
        this.COL_ID=COL_ID;
        this.COL_NAME=COL_NAME;
    }

    public int getCOL_ID(){
        return COL_ID;
    }

    public void setCOL_ID(){
        this.COL_ID=COL_ID;
    }

    public String getCOL_NAME(){
        return COL_NAME;
    }

    public void setCOL_NAME(){
        this.COL_NAME=COL_NAME;
    }
}
