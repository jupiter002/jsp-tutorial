package com.jupiter002.model;

public class MemberDto {		//경우에 따라서 dto는 여러개 만들어도 됨
	private String id;
	private String name;
	private String password;
	private String emaill;
	private int zonecode;
	private String address;
	private String detailAddressl;
	private String extraAddress;
	
	public MemberDto() {
		super();
	}

	public MemberDto(String id, String name, String password, String emaill, int zonecode, String address,
			String detailAddressl, String extraAddress) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emaill = emaill;
		this.zonecode = zonecode;
		this.address = address;
		this.detailAddressl = detailAddressl;
		this.extraAddress = extraAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String userPw) {
		this.password = userPw;
	}

	public String getEmaill() {
		return emaill;
	}

	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}

	public int getZonecode() {
		return zonecode;
	}

	public void setZonecode(int zonecode) {
		this.zonecode = zonecode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddressl() {
		return detailAddressl;
	}

	public void setDetailAddressl(String detailAddressl) {
		this.detailAddressl = detailAddressl;
	}

	public String getExtraAddress() {
		return extraAddress;
	}

	public void setExtraAddress(String extraAddress) {
		this.extraAddress = extraAddress;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", password=" + password + ", emaill=" + emaill
				+ ", zonecode=" + zonecode + ", address=" + address + ", detailAddressl=" + detailAddressl
				+ ", extraAddress=" + extraAddress + "]";
	}
	
	
	
}
