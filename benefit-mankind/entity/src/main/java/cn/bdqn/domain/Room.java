package cn.bdqn.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Room构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Room",value = "Room")
@Table(name="room")
public class Room implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private Integer ID;//

	@ApiModelProperty(value = "房间号",required = false)
    @Column(name = "Room_num")
	private Integer RoomNum;//房间号

	@ApiModelProperty(value = "病区外键ID",required = false)
    @Column(name = "Floor_ID")
	private Integer FloorID;//病区外键ID



	//get方法
	public Integer getID() {
		return ID;
	}

	//set方法
	public void setID(Integer ID) {
		this.ID = ID;
	}
	//get方法
	public Integer getRoomNum() {
		return RoomNum;
	}

	//set方法
	public void setRoomNum(Integer RoomNum) {
		this.RoomNum = RoomNum;
	}
	//get方法
	public Integer getFloorID() {
		return FloorID;
	}

	//set方法
	public void setFloorID(Integer FloorID) {
		this.FloorID = FloorID;
	}


}
