package com.chat.pojo;

public class ChatGroup {
	public enum ChatGroupEnum{
		group_id,
		group_name,
		created_at;
	}

	private String groupID;
	private String groupName;
	private String createdAt;
	
	public ChatGroup(String groupID, String groupName, String createdAt) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.createdAt = createdAt;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "GroupDetails [groupID=" + groupID + ", groupName=" + groupName + ", createdAt=" + createdAt + "]";
	}
	
	
	
}
