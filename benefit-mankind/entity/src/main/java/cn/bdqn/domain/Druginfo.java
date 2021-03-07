package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Druginfo构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Druginfo",value = "Druginfo")
@Table(name="druginfo")
public class Druginfo implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "药品名称",required = false)
    @Column(name = "Drug_name")
	private String DrugName;//药品名称

	@ApiModelProperty(value = "药品单价",required = false)
    @Column(name = "Drug_price")
	private String DrugPrice;//药品单价

	@ApiModelProperty(value = "药品说明",required = false)
    @Column(name = "Drug_explain")
	private String DrugExplain;//药品说明

	@ApiModelProperty(value = "药品类型",required = false)
    @Column(name = "Drug_type")
	private String DrugType;//药品类型

	@ApiModelProperty(value = "药品剂量",required = false)
    @Column(name = "Drug_dosage")
	private String DrugDosage;//药品剂量

	@ApiModelProperty(value = "药品规格",required = false)
    @Column(name = "Drug_specifications")
	private String DrugSpecifications;//药品规格

	@ApiModelProperty(value = "药品使用方式",required = false)
    @Column(name = "Drug_way")
	private String DrugWay;//药品使用方式

	@ApiModelProperty(value = "保质期",required = false)
    @Column(name = "Drug_quality")
	private String DrugQuality;//保质期

	@ApiModelProperty(value = "药品生产日期",required = false)
    @Column(name = "Drug_manufacture")
	private Date DrugManufacture;//药品生产日期

	@ApiModelProperty(value = "单位(盒,片，瓶)",required = false)
    @Column(name = "Drug_company")
	private String DrugCompany;//单位(盒,片，瓶)

	@ApiModelProperty(value = "厂家",required = false)
    @Column(name = "Drug_manufactor")
	private String DrugManufactor;//厂家



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getDrugName() {
		return DrugName;
	}

	//set方法
	public void setDrugName(String DrugName) {
		this.DrugName = DrugName;
	}
	//get方法
	public String getDrugPrice() {
		return DrugPrice;
	}

	//set方法
	public void setDrugPrice(String DrugPrice) {
		this.DrugPrice = DrugPrice;
	}
	//get方法
	public String getDrugExplain() {
		return DrugExplain;
	}

	//set方法
	public void setDrugExplain(String DrugExplain) {
		this.DrugExplain = DrugExplain;
	}
	//get方法
	public String getDrugType() {
		return DrugType;
	}

	//set方法
	public void setDrugType(String DrugType) {
		this.DrugType = DrugType;
	}
	//get方法
	public String getDrugDosage() {
		return DrugDosage;
	}

	//set方法
	public void setDrugDosage(String DrugDosage) {
		this.DrugDosage = DrugDosage;
	}
	//get方法
	public String getDrugSpecifications() {
		return DrugSpecifications;
	}

	//set方法
	public void setDrugSpecifications(String DrugSpecifications) {
		this.DrugSpecifications = DrugSpecifications;
	}
	//get方法
	public String getDrugWay() {
		return DrugWay;
	}

	//set方法
	public void setDrugWay(String DrugWay) {
		this.DrugWay = DrugWay;
	}
	//get方法
	public String getDrugQuality() {
		return DrugQuality;
	}

	//set方法
	public void setDrugQuality(String DrugQuality) {
		this.DrugQuality = DrugQuality;
	}
	//get方法
	public Date getDrugManufacture() {
		return DrugManufacture;
	}

	//set方法
	public void setDrugManufacture(Date DrugManufacture) {
		this.DrugManufacture = DrugManufacture;
	}
	//get方法
	public String getDrugCompany() {
		return DrugCompany;
	}

	//set方法
	public void setDrugCompany(String DrugCompany) {
		this.DrugCompany = DrugCompany;
	}
	//get方法
	public String getDrugManufactor() {
		return DrugManufactor;
	}

	//set方法
	public void setDrugManufactor(String DrugManufactor) {
		this.DrugManufactor = DrugManufactor;
	}


}
