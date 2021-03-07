package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Registration构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Registration",value = "Registration")
@Table(name="registration")
public class Registration implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "号码",required = false)
    @Column(name = "Regis_number")
	private String RegisNumber;//号码

	@ApiModelProperty(value = "挂号信息姓名",required = false)
    @Column(name = "Regis_Name")
	private String RegisName;//挂号信息姓名

	@ApiModelProperty(value = "性别（0:女 1:男）",required = false)
    @Column(name = "Regis_sex")
	private Integer RegisSex;//性别（0:女 1:男）

	@ApiModelProperty(value = "电话",required = false)
    @Column(name = "Regis_Phone")
	private String RegisPhone;//电话

	@ApiModelProperty(value = "年龄",required = false)
    @Column(name = "Regis_age")
	private Integer RegisAge;//年龄

	@ApiModelProperty(value = "出生日期",required = false)
    @Column(name = "Regis_birthday")
	private Date RegisBirthday;//出生日期

	@ApiModelProperty(value = "科室ID(外键)",required = false)
    @Column(name = "Regis_departments")
	private Integer RegisDepartments;//科室ID(外键)

	@ApiModelProperty(value = "医生ID(外键) ",required = false)
    @Column(name = "Regis_doctor")
	private Integer RegisDoctor;//医生ID(外键) 

	@ApiModelProperty(value = "挂号方式ID(外键)",required = false)
    @Column(name = "Regis_manner")
	private Integer RegisManner;//挂号方式ID(外键)



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getRegisNumber() {
		return RegisNumber;
	}

	//set方法
	public void setRegisNumber(String RegisNumber) {
		this.RegisNumber = RegisNumber;
	}
	//get方法
	public String getRegisName() {
		return RegisName;
	}

	//set方法
	public void setRegisName(String RegisName) {
		this.RegisName = RegisName;
	}
	//get方法
	public Integer getRegisSex() {
		return RegisSex;
	}

	//set方法
	public void setRegisSex(Integer RegisSex) {
		this.RegisSex = RegisSex;
	}
	//get方法
	public String getRegisPhone() {
		return RegisPhone;
	}

	//set方法
	public void setRegisPhone(String RegisPhone) {
		this.RegisPhone = RegisPhone;
	}
	//get方法
	public Integer getRegisAge() {
		return RegisAge;
	}

	//set方法
	public void setRegisAge(Integer RegisAge) {
		this.RegisAge = RegisAge;
	}
	//get方法
	public Date getRegisBirthday() {
		return RegisBirthday;
	}

	//set方法
	public void setRegisBirthday(Date RegisBirthday) {
		this.RegisBirthday = RegisBirthday;
	}
	//get方法
	public Integer getRegisDepartments() {
		return RegisDepartments;
	}

	//set方法
	public void setRegisDepartments(Integer RegisDepartments) {
		this.RegisDepartments = RegisDepartments;
	}
	//get方法
	public Integer getRegisDoctor() {
		return RegisDoctor;
	}

	//set方法
	public void setRegisDoctor(Integer RegisDoctor) {
		this.RegisDoctor = RegisDoctor;
	}
	//get方法
	public Integer getRegisManner() {
		return RegisManner;
	}

	//set方法
	public void setRegisManner(Integer RegisManner) {
		this.RegisManner = RegisManner;
	}


}
