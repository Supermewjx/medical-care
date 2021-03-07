package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Floor构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Floor",value = "Floor")
@Table(name="floor")
public class Floor implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "病区名称",required = false)
    @Column(name = "Floor_Name")
	private String FloorName;//病区名称

	@ApiModelProperty(value = "房间号外键ID",required = false)
    @Column(name = "Room_ID")
	private Integer RoomID;//房间号外键ID



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public String getFloorName() {
		return FloorName;
	}

	//set方法
	public void setFloorName(String FloorName) {
		this.FloorName = FloorName;
	}
	//get方法
	public Integer getRoomID() {
		return RoomID;
	}

	//set方法
	public void setRoomID(Integer RoomID) {
		this.RoomID = RoomID;
	}


}
