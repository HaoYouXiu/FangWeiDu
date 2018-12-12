package com.bwei.model.fangweidushangcheng.net;

import android.content.Context;
import android.content.SharedPreferences;


import com.bwei.model.fangweidushangcheng.app.App;

import java.util.Map;

/**
 * date:2018/12/8
 * author:郝仁（Thinkpad)
 * function:
 */
public class SpUtil {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEdit;

    //初始化
    public void SharedPreferencesBackupHelper(){
        mSharedPreferences = App.scontext.getSharedPreferences(Constant.SP_NAME, Context.MODE_PRIVATE );
        mEdit = mSharedPreferences.edit();
    }

    public void put(String kay,Object o){
        if (o instanceof String){
            mEdit.putString( kay, (String) o );
        }else if (o instanceof Integer){
            mEdit.putString( kay, (String) o );
        }else if (o instanceof Boolean){
            mEdit.putBoolean( kay, (boolean) o );
        }else if (o instanceof Float){
            mEdit.putFloat( kay, (Float) o );
        }else if (o instanceof Long){
            mEdit.putLong( kay, (long) o );
        }else {
            mEdit.putString( kay,o.toString() );
        }
        mEdit.commit();
    }
    //从SharedPreferences中获取某个值
    public Object getData(String key, Object object){
        if (object instanceof String){
            return mSharedPreferences.getString( key, (String) object );
        }else if(object instanceof Integer){
            return mSharedPreferences.getInt( key, (Integer) object );
        }else if(object instanceof Boolean){
            return mSharedPreferences.getBoolean( key, (Boolean) object );
        }else if(object instanceof Float){
            return mSharedPreferences.getFloat( key, (Float) object );
        }else if(object instanceof Long){
            return mSharedPreferences.getLong( key, (Long) object );
        }else {
            return mSharedPreferences.getString( key,object.toString() );
        }
    }

    //产删除某个值
    public void removValue(String key){
        mEdit.remove( key );
        mEdit.commit();
    }

    //清楚所有
    public void clear(){
        mEdit.clear();
        mEdit.commit();
    }

    //查询某个值是否存在
    public boolean contain(String key){
        return mSharedPreferences.contains( key );
    }
    //获取所有存储的键值对
    public Map<String, ?> getAll(){
        return mSharedPreferences.getAll();
    }
}
