package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Dept构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Dept",value = "Dept")
@Table(name="dept")
public class Dept implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "部门名称",required = false)
    @Column(name = "ept_name")
	private String eptName;//部门名称



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getEptName() {
		return eptName;
	}

	//set方法
	public void setEptName(String eptName) {
		this.eptName = eptName;
	}


}
