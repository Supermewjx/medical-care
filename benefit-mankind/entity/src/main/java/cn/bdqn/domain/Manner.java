package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Manner构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Manner",value = "Manner")
@Table(name="manner")
public class Manner implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "方式名称(普通挂号，高级挂号)",required = false)
    @Column(name = "Manner_Name")
	private String MannerName;//方式名称(普通挂号，高级挂号)



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getMannerName() {
		return MannerName;
	}

	//set方法
	public void setMannerName(String MannerName) {
		this.MannerName = MannerName;
	}


}
