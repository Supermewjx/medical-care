package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Recipe构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Recipe",value = "Recipe")
@Table(name="recipe")
public class Recipe implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "挂号外键 病人信息",required = false)
    @Column(name = "Regis_ID")
	private Integer RegisID;//挂号外键 病人信息

	@ApiModelProperty(value = "药品信息ID外键",required = false)
    @Column(name = "Druginfo_ID")
	private Integer DruginfoID;//药品信息ID外键

	@ApiModelProperty(value = "药品数量",required = false)
    @Column(name = "Drug_number")
	private Integer DrugNumber;//药品数量

	@ApiModelProperty(value = "总金额",required = false)
    @Column(name = "Drug_totalprice")
	private String DrugTotalprice;//总金额

	@ApiModelProperty(value = "缴费状态",required = false)
    @Column(name = "Recipe_payStatus")
	private Integer RecipePayStatus;//缴费状态



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
	public Integer getDruginfoID() {
		return DruginfoID;
	}

	//set方法
	public void setDruginfoID(Integer DruginfoID) {
		this.DruginfoID = DruginfoID;
	}
	//get方法
	public Integer getDrugNumber() {
		return DrugNumber;
	}

	//set方法
	public void setDrugNumber(Integer DrugNumber) {
		this.DrugNumber = DrugNumber;
	}
	//get方法
	public String getDrugTotalprice() {
		return DrugTotalprice;
	}

	//set方法
	public void setDrugTotalprice(String DrugTotalprice) {
		this.DrugTotalprice = DrugTotalprice;
	}
	//get方法
	public Integer getRecipePayStatus() {
		return RecipePayStatus;
	}

	//set方法
	public void setRecipePayStatus(Integer RecipePayStatus) {
		this.RecipePayStatus = RecipePayStatus;
	}


}
