package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Departments构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Departments",value = "Departments")
@Table(name="departments")
public class Departments implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "科室名称",required = false)
    @Column(name = "Depar_Name")
	private String DeparName;//科室名称



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getDeparName() {
		return DeparName;
	}

	//set方法
	public void setDeparName(String DeparName) {
		this.DeparName = DeparName;
	}


}
