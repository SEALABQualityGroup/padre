package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Db {

	private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

//	static final String DB_URL = "jdbc:mysql://localhost/local_visual_builder";
	Connection dbConnection = null;

	static String DB_URL = null;
	static String USER = null;
	static String PASS = null;
	
    public static String getDB_URL() {
		return DB_URL;
	}

	public static void setDB_URL(String dB_URL) {
		DB_URL = dB_URL;
	}

	public static String getUSER() {
		return USER;
	}

	public static void setUSER(String uSER) {
		USER = uSER;
	}

	public static String getPASS() {
		return PASS;
	}

	public static void setPASS(String pASS) {
		PASS = pASS;
	}
	/**
	 * 
	 */
	public Db() {

	}

	/**
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;

		Class.forName(DRIVER_NAME);
		// System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		// System.out.println("Connected database successfully...");

		return conn;

	}
	

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Statement getStatement() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		dbConnection = DriverManager.getConnection(DB_URL, USER, PASS);

		Statement stmt = dbConnection.createStatement();

		return stmt;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EVL_Tree_Threshold> getThresholdList() throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		
		List<EVL_Tree_Threshold> thresholdList = new ArrayList<EVL_Tree_Threshold>();
		String sql1 = "SELECT name FROM thresholds";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				EVL_Tree_Threshold temp = new EVL_Tree_Threshold(rs1.getString(1));

				thresholdList.add(temp);

			}
			rs1.close();
		
		conn.close();
		return thresholdList;
	}

	/**
	 * @param fName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EVL_Tree_Threshold> getThresholdList(String fName) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM f WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, fName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> FidList = new ArrayList<Integer>();
		while (rs.next()) {
			FidList.add(rs.getInt("id"));
		}
		rs.close();
		List<Integer> thIdList = new ArrayList<Integer>();
		for (Integer id : FidList) {
			String sql2 = "SELECT * FROM f_thresholds WHERE f_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				thIdList.add(rs2.getInt(2));
			}
			rs2.close();
		}
		List<EVL_Tree_Threshold> thresholdList = new ArrayList<EVL_Tree_Threshold>();
		for (Integer id : thIdList) {
			String sql1 = "SELECT name FROM thresholds WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				EVL_Tree_Threshold temp = new EVL_Tree_Threshold(rs1.getString(1));

				thresholdList.add(temp);

			}
			rs1.close();
		}
		conn.close();
		return thresholdList;
	}

	/**
	 * @param contextName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<String> getDo(String contextName) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM context WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, contextName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> contextIdList = new ArrayList<Integer>();
		while (rs.next()) {
			contextIdList.add(rs.getInt("id"));
		}
		rs.close();
		List<Integer> DoIdList = new ArrayList<Integer>();
		for (Integer id : contextIdList) {
			String sql2 = "SELECT * FROM do_context WHERE context_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				DoIdList.add(rs2.getInt(1));
			}
			rs2.close();

		}
		List<String> doNameList = new ArrayList<String>();
		for (Integer id : DoIdList) {
			String sql1 = "SELECT name FROM do WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();

			while (rs1.next()) {
				doNameList.add(rs1.getString(1));

			}
			rs1.close();
		}
		conn.close();
		return doNameList;
	}

	/**
	 * @param fName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_F_Operation> getFListToCompare_deprecated(String fName) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM f WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, fName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> FidList = new ArrayList<Integer>();
		while (rs.next()) {
			FidList.add(rs.getInt("id"));
		}
		rs.close();
		List<Integer> fToCompIdList = new ArrayList<Integer>();
		for (Integer id : FidList) {
			String sql2 = "SELECT * FROM f_f WHERE f_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				fToCompIdList.add(rs2.getInt(2));
			}
			rs2.close();

		}
		List<EOL_Library_F_Operation> fList = new ArrayList<EOL_Library_F_Operation>();
		for (Integer id : fToCompIdList) {
			String sql1 = "SELECT * FROM f WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();
			while (rs1.next()) {
				EOL_Library_F_Operation f;
//				String name = rs1.getString(2);
//				String card = "";
//				String returnType = "";
//				if (rs1.getBoolean(4)) {
//					card = "unary";
//				} else {
//					card = "binary";
//				}
//				if (rs1.getBoolean(3)) {
//					returnType = "boolean";
//				} else {
//					returnType = "real";
//				}
				f = new EOL_Library_F_Operation();
				fList.add(f);

			}
			rs1.close();
		}
		conn.close();
		return fList;
	}

	/**
	 * @param contextName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_F_Operation> getFList_deprecated(String contextName) throws ClassNotFoundException, SQLException {

		Connection conn = Db.getConnection();
		String sql = "SELECT id FROM context WHERE name=?";
		PreparedStatement preparedStatement = conn.prepareStatement(sql);
		preparedStatement.setString(1, contextName);
		ResultSet rs = preparedStatement.executeQuery();
		List<Integer> contextIdList = new ArrayList<Integer>();
		while (rs.next()) {
			contextIdList.add(rs.getInt("id"));
		}
		rs.close();
		List<Integer> fIdList = new ArrayList<Integer>();
		for (Integer id : contextIdList) {
			String sql2 = "SELECT * FROM f_context WHERE context_id=?";
			PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);
			preparedStatement2.setInt(1, id);
			ResultSet rs2 = preparedStatement2.executeQuery();
			while (rs2.next()) {
				fIdList.add(rs2.getInt(1));
			}
			rs2.close();

		}
		List<EOL_Library_F_Operation> fList = new ArrayList<EOL_Library_F_Operation>();
		for (Integer id : fIdList) {
			String sql1 = "SELECT * FROM f WHERE id=?";
			PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
			preparedStatement1.setInt(1, id);
			ResultSet rs1 = preparedStatement1.executeQuery();

			while (rs1.next()) {

				EOL_Library_F_Operation f;
//				String name = rs1.getString(2);
//				String card = "";
//				String returnType = "";
//				if (rs1.getBoolean(4)) {
//					card = "unary";
//				} else {
//					card = "binary";
//				}
//				if (rs1.getBoolean(3)) {
//					returnType = "boolean";
//				} else {
//					returnType = "real";
//				}
				f = new EOL_Library_F_Operation();
				fList.add(f);
			}
			rs1.close();

		}
		conn.close();
		return fList;
	}

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_F_Operation> getFList_deprecated() throws ClassNotFoundException, SQLException {

		Connection conn = Db.getConnection();
		List<EOL_Library_F_Operation> flist = new ArrayList<EOL_Library_F_Operation>();
		String sql1 = "SELECT * FROM f ";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs1 = preparedStatement1.executeQuery();
		while (rs1.next()) {
			EOL_Library_F_Operation f;
//			String name = rs1.getString(2);
//			String card = "";
//			String returnType = "";
//			if (rs1.getBoolean(4)) {
//				card = "unary";
//			} else {
//				card = "binary";
//			}
//			if (rs1.getBoolean(3)) {
//				returnType = "boolean";
//			} else {
//				returnType = "real";
//			}
			f = new EOL_Library_F_Operation();
			flist.add(f);

		}
		rs1.close();
		conn.close();
		return flist;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<Integer> getall_F_id() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<Integer> flist = new ArrayList<Integer>();
		String sql1 = "SELECT id FROM f;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt(1);
			
			flist.add(id);

		}
		
		rs.close();
		conn.close();
		return flist;
	}
	
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static EOL_Library_F_Operation get_F_description_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		EOL_Library_F_Operation f = new EOL_Library_F_Operation();
		String sql1 = "SELECT f.name, context.name, f_context.method FROM f JOIN f_context ON f.id = f_context.f_id JOIN context ON f_context.context_id = context.id WHERE f.id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
			String name = rs.getString(1);
			String context = rs.getString(2);
			String body = rs.getString(3);
			
			f = new EOL_Library_F_Operation(id, name, context, body);

		}
		
		rs.close();
		conn.close();
		return f;
	}
	
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String get_F_method_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();

		String method = "";
		
		String sql1 = "SELECT method FROM f_context WHERE f_id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		if (rs.next()) {
			
			method = rs.getString(1);

		}
		
		rs.close();
		conn.close();
		return method;
	}
	
	/**
	 * @param id
	 * @param method
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void set_F_method_byId(int id, String method) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		
		String sql1 = "UPDATE f_context SET method = ? WHERE f_id = ?;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		preparedStatement1.setString(1, method);
		preparedStatement1.setInt(2, id);

		preparedStatement1.executeUpdate();

		conn.close();
		return;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_F_Operation> getall_Metric_functions() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<EOL_Library_F_Operation> flist = new ArrayList<EOL_Library_F_Operation>();
		String sql1 = "SELECT * FROM f JOIN f_context ON f.id = f_context.f_id JOIN context ON f_context.context_id = context.id;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
//			String name = rs.getString(2) + " for " + rs.getString(9) + " context";
//			String method = rs.getString(7);
//			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String context = rs.getString(9);
			String method = rs.getString(7);
			
			flist.add(new EOL_Library_F_Operation(id, name, context, method));

		}
		
		rs.close();
		conn.close();
		return flist;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<Integer> getall_Do_id() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<Integer> do_list = new ArrayList<Integer>();
		String sql1 = "SELECT id FROM do;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt(1);
			
			do_list.add(id);

		}
		
		rs.close();
		conn.close();
		return do_list;
	}
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static EOL_Library_DO_Operation get_Do_description_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();

		EOL_Library_DO_Operation redo = new EOL_Library_DO_Operation();
		
		String sql1 = "SELECT * FROM do JOIN do_context ON do.id = do_context.do_id JOIN context ON do_context.context_id = context.id WHERE do.id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		if (rs.next()) {
			
			String name = rs.getString(2);
			String context = rs.getString(7);
			
			redo = new EOL_Library_DO_Operation(id, name, context);

		}
		
		rs.close();
		conn.close();
		return redo;
	}
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String get_Do_method_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();

		String method = "";
		
		String sql1 = "SELECT method FROM do_context WHERE do_id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		if (rs.next()) {
			
			method = rs.getString(1);

		}
		
		rs.close();
		conn.close();
		return method;
	}
	
	/**
	 * @param id
	 * @param method
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void set_Do_method_byId(int id, String method) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		
		String sql1 = "UPDATE do_context SET method = ? WHERE do_id = ?;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		preparedStatement1.setString(1, method);
		preparedStatement1.setInt(2, id);

		preparedStatement1.executeUpdate();

		conn.close();
		return;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_DO_Operation> getall_Do_functions() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<EOL_Library_DO_Operation> dolist = new ArrayList<EOL_Library_DO_Operation>();
		String sql1 = "SELECT * FROM do JOIN do_context ON do.id = do_context.do_id JOIN context ON do_context.context_id = context.id;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
//			String name = rs.getString(2) + " for " + rs.getString(7) + " context";
//			String method = rs.getString(5);
			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String context = rs.getString(7);
			String method = rs.getString(5);
			
			dolist.add(new EOL_Library_DO_Operation(id, name, context, method));

		}
		
		rs.close();
		conn.close();
		return dolist;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<Integer> getall_Th_id() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<Integer> th_list = new ArrayList<Integer>();
		String sql1 = "SELECT id FROM thresholds;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt(1);
			
			th_list.add(id);

		}
		
		rs.close();
		conn.close();
		return th_list;
	}
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String get_Th_name_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();

		String threshold_name = null;
		
		String sql1 = "SELECT name FROM thresholds WHERE id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		if (rs.next()) {
			
			threshold_name = rs.getString(1);

		}
		
		rs.close();
		conn.close();
		return threshold_name;
	}
	
	/**
	 * @param id
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String get_Th_method_byId(int id) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();

		String method = "";
		
		String sql1 = "SELECT method FROM thresholds WHERE id = " + id + ";";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		if (rs.next()) {
			
			method = rs.getString(1);

		}
		
		rs.close();
		conn.close();
		return method;
	}
	
	/**
	 * @param id
	 * @param method
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void set_Th_method_byId(int id, String method) throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		
		String sql1 = "UPDATE thresholds SET method = ? WHERE id = ?;";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		preparedStatement1.setString(1, method);
		preparedStatement1.setInt(2, id);

		preparedStatement1.executeUpdate();

		conn.close();
		return;
	}
	
	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<EOL_Library_Th_Operation> getall_Threshold_functions() throws ClassNotFoundException, SQLException
	{
		Connection conn = Db.getConnection();
		List<EOL_Library_Th_Operation> thlist = new ArrayList<EOL_Library_Th_Operation>();
		String sql1 = "SELECT * FROM thresholds";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);

		ResultSet rs = preparedStatement1.executeQuery();
		while (rs.next()) {
			
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String method = rs.getString(3);
			
			thlist.add(new EOL_Library_Th_Operation(id, name, method));

		}
		
		rs.close();
		conn.close();
		return thlist;
	}

	/**
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static List<String> getContexts() throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql1 = "SELECT * FROM context";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		ResultSet rs1 = preparedStatement1.executeQuery();
		List<String> cList = new ArrayList<String>();
		while (rs1.next()) {

			String name = rs1.getString(2);
			cList.add(name);
		}
		rs1.close();
		conn.close();
		return cList;
	}

	/**
	 * @param context
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void insertContext(String context) throws ClassNotFoundException, SQLException {
		Connection conn = Db.getConnection();
		String sql1 = "INSERT IGNORE INTO context (name) VALUES ('" + context + "');";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1);
		preparedStatement1.executeUpdate();

		conn.close();
	}
	
	/**
	 * @param name
	 * @param method
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int insert_Threshold_function(String name, String method) throws ClassNotFoundException, SQLException
	{
		int th_id = -1;
		Connection conn = Db.getConnection();
		//Map<String, String> thmap = new HashMap<String, String>();
		String sql1 = "INSERT INTO thresholds (name,method) VALUES ('" + name + "','" + method + "');";
		PreparedStatement preparedStatement1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

		preparedStatement1.executeUpdate();
		ResultSet rs = preparedStatement1.getGeneratedKeys();
		if (rs.next()) {
			
			th_id = rs.getInt(1);
		}
		
		conn.close();
		
		return th_id;
	}
	
	/**
	 * @param name
	 * @param context
	 * @param method
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int insert_Do_function(String name, String context, String method) throws ClassNotFoundException, SQLException
	{
		
		int context_id, do_id = -1;
		Connection conn = Db.getConnection();
		PreparedStatement preparedStatement;

		//if not exists
		insertContext(context);
		
		String select = "SELECT id FROM context WHERE name='" + context + "';";
		preparedStatement = conn.prepareStatement(select);
		
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			
			context_id = rs.getInt(1);
			
			
			String query = "INSERT INTO do (name) VALUES ('" + name + "');";
			preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				
				do_id = rs.getInt(1);
				
				String insert = "INSERT INTO do_context (do_id,context_id,method) VALUES (?,?,?);";
				preparedStatement = conn.prepareStatement(insert);
				preparedStatement.setInt(1, do_id);
				preparedStatement.setInt(2, context_id);
				preparedStatement.setString(3, method);
				preparedStatement.executeUpdate();
			}
//			else
//			{
//				select = "SELECT id FROM do WHERE name='" + name + "';";
//				preparedStatement = conn.prepareStatement(select);
//				
//				rs = preparedStatement.executeQuery();
//				if (rs.next()) {
//					
//					do_id = rs.getInt(1);
//					
//					String insert = "INSERT INTO do_context (do_id,context_id,method) VALUES ('" + do_id + "','" + context_id + "','" + method + "');";
//					preparedStatement = conn.prepareStatement(insert);
//
//					preparedStatement.executeUpdate();
//				}
//			}
			
		}
		
		rs.close();
		conn.close();
		
		return do_id;
	}
	
	/**
	 * @param context
	 * @param name
	 * @param method
	 * @param return_bool
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int insert_Metric_function(String context, String name, String method) throws ClassNotFoundException, SQLException
	{
		int context_id, f_id = -1;
		Connection conn = Db.getConnection();
		PreparedStatement preparedStatement;

		//if not exists
		insertContext(context);
		
		String select = "SELECT id FROM context WHERE name='" + context + "';";
		preparedStatement = conn.prepareStatement(select);
		
		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			
			context_id = rs.getInt(1);
			
			String query = "INSERT INTO f (name) VALUES ('" + name + "');";
			preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				
				f_id = rs.getInt(1);
				
				String insert = "INSERT INTO f_context (f_id,context_id,method) VALUES (?,?,?);";
				preparedStatement = conn.prepareStatement(insert);
				preparedStatement.setInt(1, f_id);
				preparedStatement.setInt(2, context_id);
				preparedStatement.setString(3, method);
				preparedStatement.executeUpdate();
			}
//			else 
//			{
//				select = "SELECT id FROM f WHERE name='" + name + "';";
//				preparedStatement = conn.prepareStatement(select);
//				
//				rs = preparedStatement.executeQuery();
//				if (rs.next()) {
//					
//					f_id = rs.getInt(1);
//					
//					String insert = "INSERT INTO f_context (f_id,context_id,method) VALUES ('" + f_id + "','" + context_id + "','" + method + "');";
//					preparedStatement = conn.prepareStatement(insert);
//
//					preparedStatement.executeUpdate();
//				}
//			}
			
		}
		
		rs.close();
		conn.close();
		
		return f_id;
	}	
	
	public Connection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public static String getDriverName() {
		return DRIVER_NAME;
	}

}


