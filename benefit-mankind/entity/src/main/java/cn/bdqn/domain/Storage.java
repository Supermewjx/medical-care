package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Storage构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Storage",value = "Storage")
@Table(name="storage")
public class Storage implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = " 外键",required = false)
    @Column(name = "Dru_ID")
	private Integer DruID;// 外键

	@ApiModelProperty(value = "药库药品剩余总数量",required = false)
    @Column(name = "Drog_yktotalNumber")
	private Integer DrogYktotalNumber;//药库药品剩余总数量



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public Integer getDruID() {
		return DruID;
	}

	//set方法
	public void setDruID(Integer DruID) {
		this.DruID = DruID;
	}
	//get方法
	public Integer getDrogYktotalNumber() {
		return DrogYktotalNumber;
	}

	//set方法
	public void setDrogYktotalNumber(Integer DrogYktotalNumber) {
		this.DrogYktotalNumber = DrogYktotalNumber;
	}


}
