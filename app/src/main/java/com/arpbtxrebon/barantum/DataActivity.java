package com.arpbtxrebon.barantum;

import java.util.ArrayList;

public class DataActivity {
    private static String[] nama = {
            "Advent", "King", "Saitama", "Sony"
    };
    private static String[] job = {
            "Tani", "Buruh", "Pos Man", "Tani"

    };
    private static String[] status = {
            "single", "duda", "janda", "gantung"

    };
    private static String[] date = {
            "12/2/2021", "15/6/2021", "14/4/2021", "17/3/2021"
    };
    private static String[] activity = {
            "a a a a a", "b b b b b", "c c c c", "d d d d"

    };

    static ArrayList<DataModelActivity> getListDataModel() {
        ArrayList<DataModelActivity> listdata = new ArrayList<>();
        for (int position = 0; position < nama.length; position++) {
            DataModelActivity dataModelActivity = new DataModelActivity();
            dataModelActivity.setNama(nama[position]);
            dataModelActivity.setJob(job[position]);
            dataModelActivity.setStatus(status[position]);
            dataModelActivity.setDate(date[position]);
            dataModelActivity.setActivity(activity[position]);
            listdata.add(dataModelActivity);
        }
        return listdata;
    }
}
