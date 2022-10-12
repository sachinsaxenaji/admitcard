package com.api.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Product {

    @Id
    private String Sno;

    private String RollNo;

    private String Name;

    private String DOB;
    
    private String FatherName;
    
    private String Category;
    
    private String Post;
    
    private Integer picid;
    
//    private String pic;
    
    @Lob    
    private byte[] pic;

    
	public Product() {
		super();
	}


	public Product(String sno, String rollNo, String name, String dOB, String fatherName, String category, String post,
			Integer picid, byte[] pic) {
		super();
		Sno = sno;
		RollNo = rollNo;
		Name = name;
		DOB = dOB;
		FatherName = fatherName;
		Category = category;
		Post = post;
		this.picid = picid;
		pic = pic;
	}

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getFatherName() {
		return FatherName;
	}

	public void setFatherName(String fatherName) {
		FatherName = fatherName;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getPost() {
		return Post;
	}

	public void setPost(String post) {
		Post = post;
	}

	

	public byte[] getpic() {
		return pic;
	}

	public void setpic(byte[] pic) {
		pic = pic;
	}
	
	

	public Integer getPicid() {
		return picid;
	}

	public void setPicid(Integer picid) {
		this.picid = picid;
	}


	@Override
	public String toString() {
		return "Product [Sno=" + Sno + ", RollNo=" + RollNo + ", Name=" + Name + ", DOB=" + DOB + ", FatherName="
				+ FatherName + ", Category=" + Category + ", Post=" + Post + ", picid=" + picid + ", pic="
				+ Arrays.toString(pic) + "]";
	}


    
    

}
