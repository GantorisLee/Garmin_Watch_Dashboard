package coachingmateanalytics.coachingmate.entity;


public class RequestToken {
	private long userId;
	private String username;
	private String token;
	private String secret;
	private String garminstatus;
	

	public RequestToken() {
		super();
	}

	public RequestToken(String token, String secret) {
		super();
	}

	public RequestToken(String username, long userid, String token, String secret, String garminstatus) {
		super();
		this.userId = userid;
		this.username = username;
		this.token = token;
		this.secret = secret;
		this.garminstatus = garminstatus;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}


	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getGarminstatus() {
		return garminstatus;
	}

	public void setGarminstatus(String garminstatus) {
		this.garminstatus = garminstatus;
	}

}