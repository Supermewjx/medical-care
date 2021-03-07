package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Bunk构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Bunk",value = "Bunk")
@Table(name="bunk")
public class Bunk implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "床位号",required = false)
    @Column(name = "Bunk_ID")
	private Integer BunkID;//床位号

	@ApiModelProperty(value = "房间表外键ID",required = false)
    @Column(name = "Room_ID")
	private Integer RoomID;//房间表外键ID

	@ApiModelProperty(value = "是否住人（0，未住1，住）",required = false)
    @Column(name = "Bunk_status")
	private Integer BunkStatus;//是否住人（0，未住1，住）



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public Integer getBunkID() {
		return BunkID;
	}

	//set方法
	public void setBunkID(Integer BunkID) {
		this.BunkID = BunkID;
	}
	//get方法
	public Integer getRoomID() {
		return RoomID;
	}

	//set方法
	public void setRoomID(Integer RoomID) {
		this.RoomID = RoomID;
	}
	//get方法
	public Integer getBunkStatus() {
		return BunkStatus;
	}

	//set方法
	public void setBunkStatus(Integer BunkStatus) {
		this.BunkStatus = BunkStatus;
	}


}
