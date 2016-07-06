package com.freemarkertest;

/**
 *
 *
 * 
 */
public class DemoTest {

	public static void main(String[] args) {
		// System.out.println(List.class.getCanonicalName());
		// System.out.println(Map.class.getCanonicalName());
		// System.out.println(Date.class.getCanonicalName());
		// System.out.println(Integer.class.getCanonicalName());
		// System.out.println(String.class.getCanonicalName());
		// System.out.println(Double.class.getCanonicalName());
		// System.out.println(Object.class.getCanonicalName());
		// String url = "jdbc:mysql://127.0.0.1:3306/mybatis";
		// String name = "com.mysql.jdbc.Driver";
		// String user = "root";
		// String password = "password";
		// Connection conn = null;
		// PreparedStatement pst = null;
		// try {
		// Class.forName(name);
		// conn = DriverManager.getConnection(url, user, password);// 获取连接
		// pst = conn.prepareStatement("show tables");// 准备执行语句
		// } catch (Exception e) {
		// // TODO: handle exception
		// }

		String string = "ardd_ee_kk_ii";
		String returnString = "";
		String[] strings = string.split("_");
		for (int i = 1; i < strings.length; i++) {
			strings[i] = strings[i].substring(0, 1).toUpperCase()
					+ strings[i].substring(1);
			System.out.println(strings[i]);
			returnString += strings[i];
		}
		System.out.println(strings[0] + returnString);
	}
}
