package com.coding_cole.tasktimer;

import android.provider.BaseColumns;

public class TasksContract {

    static final String TABLE_NAME = "TAsks";

    // tasks fields
    public static class Coloumns {
        public static final String _ID = BaseColumns._ID;
        public static final String TASKS_NAME = "Name";
        public static final String TASKS_DESCRIPTION = "Dscription";
        public static final String TASKS_SORTORDER = "SortOrder";

        private Coloumns() {
            // private constructor to prevent instantiation
        }
    }
}
