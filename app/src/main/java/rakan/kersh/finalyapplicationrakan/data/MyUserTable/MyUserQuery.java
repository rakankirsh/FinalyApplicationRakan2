package rakan.kersh.finalyapplicationrakan.data.MyUserTable;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface MyUserQuery {
    List<MyUser> getAll();
    // استخراج مستعمل حسب رقم المميز لهid

    List<MyUser> loadAllByIds(int[] userIds);
    //هل المستعمل موجود حسب الايميل وكلمة السر

    MyUser checkEmailPassw(String myEmail, String myPassw);
    //فحص هل الايميل موجود من قبل

    MyUser checkEmail(String myEmail);
    // اضافة مستعمل او مجموعة مستعملين

    void insertAll(MyUser... users);
    // حذف
    void delete(MyUser user);
    //حذف حسب الرقم المميز id

    void delete(int id);
    //اضافة مستعمل واحد

    void insert(MyUser myUser);
    //تعديل مستعمل او قائمة مستعملين

    void update(MyUser...values);

    LiveData<List<MyUser>> getAllUsers();

    LiveData<List<MyUser>> getUsersByUserId(long userIds);

    LiveData<List<MyUser>> getUsersByEmail(String myEmail);

    LiveData<List<MyUser>> getUsersByPassw(String myPassw);
}
