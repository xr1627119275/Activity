package com.xr.activity.util;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.xr.activity.bean.Contact;

//查询联系人的工具类
public class QueryContactsUtils {


	public static List<Contact> queryContacts(Context context){
		//[0]创建一个集合

		List<Contact>  contactLists = new ArrayList<Contact>();
		//[1]先查询row_contacts表 的contact_id列 我们就知道一共有几条联系人
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Uri dataUri = Uri.parse("content://com.android.contacts/data");
		Cursor cursor = context.getContentResolver().query(uri,new String[]{"contact_id"} , null, null, null);
		while(cursor.moveToNext()){
			String contact_id = cursor.getString(0);


			if (contact_id!=null) {
				//创建javabean对象
				Contact contact = new Contact();

				contact.setId(contact_id);

				System.out.println("contact_id:"+contact_id);
				//[2]根据contact_id去查询data表  查询data1列和mimetype_id

				//☆ ☆ ☆ ☆ 当我们在查询data表的时候 其实查询的是view_data的视图

				Cursor dataCursor = context.getContentResolver().query(dataUri, new String[]{"data1","mimetype"}, "raw_contact_id=?", new String[]{contact_id}, null);
				while(dataCursor.moveToNext()){
					String data1 = dataCursor.getString(0);
					String mimetype = dataCursor.getString(1);
					//[3]根据mimetype 区分data1列的数据类型
					if ("vnd.android.cursor.item/name".equals(mimetype)) {
						contact.setName(data1);
					}else if ("vnd.android.cursor.item/phone_v2".equals(mimetype)) {
						contact.setPhone(data1);
					}else if ("vnd.android.cursor.item/email_v2".equals(mimetype)) {
						contact.setEmail(data1);
					}


				}

				//把javabean对象加入到集合中
				contactLists.add(contact);
			}

		}

		return contactLists;

	}

}
