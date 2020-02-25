package model;

public class EOL_Library_Operation_Superclass {

	int database_id;
	String eol_file;

	public EOL_Library_Operation_Superclass() {

	}

	public EOL_Library_Operation_Superclass(String eol_file) {
		this.eol_file = eol_file;
	}

	public EOL_Library_Operation_Superclass(int database_id) {
		this.database_id = database_id;
	}

	public int getDatabase_id() {
		return database_id;
	}

	public void setDatabase_id(int database_id) {
		this.database_id = database_id;
	}

	public String getEol_file() {
		return eol_file;
	}

	public void setEol_file(String eol_file) {
		this.eol_file = eol_file;
	}

}
