package com.coding_cole.tasktimer;

import android.content.ContentUris;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

import static com.coding_cole.tasktimer.AppProvider.CONTENT_AUTHORITY;
import static com.coding_cole.tasktimer.AppProvider.CONTENT_AUTHORITY_URI;

public class TasksContract {

    static final String TABLE_NAME = "Tasks";

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

	/**
	 * The uri to acess the Tasks table
	 */
	public static final Uri CONTENT_URI = Uri.withAppendedPath(CONTENT_AUTHORITY_URI, TABLE_NAME);

	static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + "." + TABLE_NAME;
	static final String CONTENT_ITEM_TYPE = "vnd.adroid.cursor.dir/vnd" + CONTENT_AUTHORITY + "." + TABLE_NAME;

	static Uri buildTaskUri(long taskId) {
		return ContentUris.withAppendedId(CONTENT_URI, taskId);
	}

	static long getTaskId(Uri uri) {
		return ContentUris.parseId(uri);
	}
}
