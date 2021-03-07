package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Doctordiagnose构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Doctordiagnose",value = "Doctordiagnose")
@Table(name="doctordiagnose")
public class Doctordiagnose implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "挂号外键 病人信息",required = false)
    @Column(name = "Regis_ID")
	private Integer RegisID;//挂号外键 病人信息

	@ApiModelProperty(value = "病情",required = false)
    @Column(name = "Diag_Condition")
	private String DiagCondition;//病情

	@ApiModelProperty(value = "是否需要住院（默认不需要）",required = false)
    @Column(name = "Is_hospital")
	private Integer IsHospital;//是否需要住院（默认不需要）



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public Integer getRegisID() {
		return RegisID;
	}

	//set方法
	public void setRegisID(Integer RegisID) {
		this.RegisID = RegisID;
	}
	//get方法
	public String getDiagCondition() {
		return DiagCondition;
	}

	//set方法
	public void setDiagCondition(String DiagCondition) {
		this.DiagCondition = DiagCondition;
	}
	//get方法
	public Integer getIsHospital() {
		return IsHospital;
	}

	//set方法
	public void setIsHospital(Integer IsHospital) {
		this.IsHospital = IsHospital;
	}


}
