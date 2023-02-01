package ftmk.bitp3453.izzahbalqis.testapp.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import ftmk.bitp3453.izzahbalqis.testapp.Student;

public class database extends SQLiteOpenHelper {

    public static final String dbName = "dbStudent";
    public static final String tblNameExpense = "student";
    public static final String colStuFullName = "studentName";
    public static final String colStuNo = "studentNumber";
    public static final String colStuEmail = "studentsEmail";
    public static final String colStuBirth = "studentBirthdate";
    public static final String colStuGender = "studentGenders";
    public static final String colStuState = "studentState";

    public static final String strCrtTableExpenses = "CREATE TABLE " + tblNameExpense
            + " (" + colStuNo + " INTEGER PRIMARY KEY, "
            + colStuFullName + " TEXT, "
            + colStuEmail + " TEXT, "
            + colStuGender + " TEXT, "
            + colStuBirth + " DATE, "
            + colStuState + " TEXT" + ")";

    public static final String strDropTableExpenses = "DROP TABLE IF EXISTS " + tblNameExpense;

    public database(Context context) {
        super(context, dbName, null, 2);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(strCrtTableExpenses);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(strDropTableExpenses);
        onCreate(db);

    }


    public float fnInsertExpense(Student student) {
        float retResult = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(colStuFullName, student.getStrFullname());
        values.put(colStuNo, student.getStrStudNo());
        values.put(colStuEmail, student.getStrEmail());
        values.put(colStuBirth, student.getStrBirthdate());
        values.put(colStuGender, student.getStrGender());
        values.put(colStuState, student.getStrState());

        retResult = db.insert(tblNameExpense, null, values);
        return retResult;
    }

    @SuppressLint("Range")
    public Student fnGetExpenses(int intExpId) {
        Student student = new Student();

        String strSelQuery = "Select * from " + tblNameExpense + "where " + colStuNo + "= " + intExpId;
        Cursor cursor = this.getReadableDatabase().rawQuery(strSelQuery, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        student.setStrFullname(cursor.getString(cursor.getColumnIndex(colStuFullName)));
        student.setStrStudNo(cursor.getString(cursor.getColumnIndex(colStuNo)));
        student.setStrEmail(cursor.getString(cursor.getColumnIndex(colStuEmail)));
        student.setStrBirthdate(cursor.getString(cursor.getColumnIndex(colStuBirth)));
        student.setStrState(cursor.getString(cursor.getColumnIndex(colStuState)));

        return student;
    }


    @SuppressLint("Range")
    public List<Student> fnGetAllExpenses() {

        List<Student> listExp = new ArrayList<>();

        String strSelAll = "Select * from " + tblNameExpense;

        Cursor cursor = this.getReadableDatabase().rawQuery(strSelAll, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();

                student.setStrFullname(cursor.getString(cursor.getColumnIndex(colStuFullName)));
                student.setStrStudNo(cursor.getString(cursor.getColumnIndex(colStuNo)));
                student.setStrEmail(cursor.getString(cursor.getColumnIndex(colStuEmail)));
                student.setStrBirthdate(cursor.getString(cursor.getColumnIndex(colStuBirth)));
                student.setStrState(cursor.getString(cursor.getColumnIndex(colStuState)));
                student.setStrGender(cursor.getString(cursor.getColumnIndex(colStuGender)));

                listExp.add(student);

            } while (cursor.moveToNext());
        }

        return listExp;
    }

    public int fnUpdateExpenses(Student student) {
        int retResult = 0;

        ContentValues values = new ContentValues();
        values.put(colStuFullName, student.getStrFullname());
        values.put(colStuNo, student.getStrStudNo());
        values.put(colStuEmail, student.getStrEmail());
        values.put(colStuBirth, student.getStrBirthdate());
        values.put(colStuGender, student.getStrGender());
        values.put(colStuState, student.getStrState());

        String[] argg = {String.valueOf(student.getStrStudNo())};

        this.getWritableDatabase().update(tblNameExpense, values, colStuNo + " = ?", argg);
        return retResult;
    }
}
