package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Doctor构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Doctor",value = "Doctor")
@Table(name="doctor")
public class Doctor implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "医生工号",required = false)
    @Column(name = "Doctor_number")
	private String DoctorNumber;//医生工号

	@ApiModelProperty(value = "医生姓名",required = false)
    @Column(name = "Doctor_Name")
	private String DoctorName;//医生姓名

	@ApiModelProperty(value = "所属科室 外键",required = false)
    @Column(name = "Departments_id")
	private Integer DepartmentsId;//所属科室 外键

	@ApiModelProperty(value = "部门ID（外键）",required = false)
    @Column(name = "Dept_ID")
	private Integer DeptID;//部门ID（外键）

	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "Doctor_Password")
	private String DoctorPassword;//密码

	@ApiModelProperty(value = "邮箱",required = false)
    @Column(name = "Doctor_email")
	private String DoctorEmail;//邮箱

	@ApiModelProperty(value = "电话",required = false)
    @Column(name = "Doctor_phone")
	private String DoctorPhone;//电话

	@ApiModelProperty(value = "性别",required = false)
    @Column(name = "Doctor_sex")
	private String DoctorSex;//性别

	@ApiModelProperty(value = "家庭住址",required = false)
    @Column(name = "Doctor_address")
	private String DoctorAddress;//家庭住址

	@ApiModelProperty(value = "身份证号",required = false)
    @Column(name = "Doctor_CarID")
	private String DoctorCarID;//身份证号

	@ApiModelProperty(value = "状态（0：正常登录1：异常不可登",required = false)
    @Column(name = "Doc_statsu")
	private Integer DocStatsu;//状态（0：正常登录1：异常不可登



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getDoctorNumber() {
		return DoctorNumber;
	}

	//set方法
	public void setDoctorNumber(String DoctorNumber) {
		this.DoctorNumber = DoctorNumber;
	}
	//get方法
	public String getDoctorName() {
		return DoctorName;
	}

	//set方法
	public void setDoctorName(String DoctorName) {
		this.DoctorName = DoctorName;
	}
	//get方法
	public Integer getDepartmentsId() {
		return DepartmentsId;
	}

	//set方法
	public void setDepartmentsId(Integer DepartmentsId) {
		this.DepartmentsId = DepartmentsId;
	}
	//get方法
	public Integer getDeptID() {
		return DeptID;
	}

	//set方法
	public void setDeptID(Integer DeptID) {
		this.DeptID = DeptID;
	}
	//get方法
	public String getDoctorPassword() {
		return DoctorPassword;
	}

	//set方法
	public void setDoctorPassword(String DoctorPassword) {
		this.DoctorPassword = DoctorPassword;
	}
	//get方法
	public String getDoctorEmail() {
		return DoctorEmail;
	}

	//set方法
	public void setDoctorEmail(String DoctorEmail) {
		this.DoctorEmail = DoctorEmail;
	}
	//get方法
	public String getDoctorPhone() {
		return DoctorPhone;
	}

	//set方法
	public void setDoctorPhone(String DoctorPhone) {
		this.DoctorPhone = DoctorPhone;
	}
	//get方法
	public String getDoctorSex() {
		return DoctorSex;
	}

	//set方法
	public void setDoctorSex(String DoctorSex) {
		this.DoctorSex = DoctorSex;
	}
	//get方法
	public String getDoctorAddress() {
		return DoctorAddress;
	}

	//set方法
	public void setDoctorAddress(String DoctorAddress) {
		this.DoctorAddress = DoctorAddress;
	}
	//get方法
	public String getDoctorCarID() {
		return DoctorCarID;
	}

	//set方法
	public void setDoctorCarID(String DoctorCarID) {
		this.DoctorCarID = DoctorCarID;
	}
	//get方法
	public Integer getDocStatsu() {
		return DocStatsu;
	}

	//set方法
	public void setDocStatsu(Integer DocStatsu) {
		this.DocStatsu = DocStatsu;
	}


}
