package jimdandy.mybooklist.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hessro on 5/30/17.
 */

public class BookDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Book.db";
    private static final int DATABASE_VERSION = 5;

    public BookDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_FAVORITE_REPOS_TABLE =
                        "CREATE TABLE " + BookContract.FavoriteBook.TABLE_NAME + " (" +
                        BookContract.FavoriteBook._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        BookContract.FavoriteBook.COLUMN_TITLE + " TEXT NOT NULL, " +
                        BookContract.FavoriteBook.COLUMN_AUTHOR + " TEXT NOT NULL, " +
                        BookContract.FavoriteBook.COLUMN_IMAGE_URL + " TEXT, " +
                        BookContract.FavoriteBook.COLUMN_BOOK_ID + " TEXT, " +
                        BookContract.FavoriteBook.COLUMN_RATING + " INTEGER DEFAULT 0, " +
                        BookContract.FavoriteBook.COLUMN_TIMESTAMP + " INTEGER DEFAULT 0, " +

                        BookContract.FavoriteBook.COLUMN_GOING + " TEXT NOT NULL, " +
                        BookContract.FavoriteBook.COLUMN_CURRENT + " TEXT NOT NULL, " +
                        BookContract.FavoriteBook.COLUMN_FUTURE + " TEXT NOT NULL " +
                        " );";

        db.execSQL(SQL_CREATE_FAVORITE_REPOS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BookContract.FavoriteBook.TABLE_NAME);
        onCreate(db);
    }
}
