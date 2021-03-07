package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/****
 * @Author:shenkunlin
 * @Description:Hospitalized构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Hospitalized",value = "Hospitalized")
@Table(name="hospitalized")
public class Hospitalized implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "处方表ID",required = false)
    @Column(name = "recipe_id")
	private Integer recipeId;//处方表ID

	@ApiModelProperty(value = "床位号外键",required = false)
    @Column(name = "bunk_id")
	private Integer bunkId;//床位号外键

	@ApiModelProperty(value = "是否出院（0，住院，1出院）",required = false)
    @Column(name = "status")
	private Integer status;//是否出院（0，住院，1出院）

	@ApiModelProperty(value = "住院天数",required = false)
    @Column(name = "hosp_day")
	private String hospDay;//住院天数

	@ApiModelProperty(value = "住院日期",required = false)
    @Column(name = "hosp_start")
	private Date hospStart;//住院日期

	@ApiModelProperty(value = "出院日期",required = false)
    @Column(name = "host_end")
	private Date hostEnd;//出院日期

	@ApiModelProperty(value = "住院金额",required = false)
    @Column(name = "host_money")
	private String hostMoney;//住院金额

	@ApiModelProperty(value = "挂号表外键",required = false)
    @Column(name = "registration_id")
	private Integer registrationId;//挂号表外键



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public Integer getRecipeId() {
		return recipeId;
	}

	//set方法
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	//get方法
	public Integer getBunkId() {
		return bunkId;
	}

	//set方法
	public void setBunkId(Integer bunkId) {
		this.bunkId = bunkId;
	}
	//get方法
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}
	//get方法
	public String getHospDay() {
		return hospDay;
	}

	//set方法
	public void setHospDay(String hospDay) {
		this.hospDay = hospDay;
	}
	//get方法
	public Date getHospStart() {
		return hospStart;
	}

	//set方法
	public void setHospStart(Date hospStart) {
		this.hospStart = hospStart;
	}
	//get方法
	public Date getHostEnd() {
		return hostEnd;
	}

	//set方法
	public void setHostEnd(Date hostEnd) {
		this.hostEnd = hostEnd;
	}
	//get方法
	public String getHostMoney() {
		return hostMoney;
	}

	//set方法
	public void setHostMoney(String hostMoney) {
		this.hostMoney = hostMoney;
	}
	//get方法
	public Integer getRegistrationId() {
		return registrationId;
	}

	//set方法
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}


}
