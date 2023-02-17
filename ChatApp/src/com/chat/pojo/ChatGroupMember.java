package com.chat.pojo;

public class ChatGroupMember {
	public enum ChatGroupMemberEnum{
		group_id,
		contact_id,
		added_at,
		removed_at;
	}

	private String groupID;
	private String contactId;
	private String addedAt;
	private String removedAt;
	
	public ChatGroupMember(String groupID, String contactId, String addedAt, String removedAt) {
		this.groupID = groupID;
		this.contactId = contactId;
		this.addedAt = addedAt;
		this.removedAt = removedAt;
	}

	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(String addedAt) {
		this.addedAt = addedAt;
	}

	public String getRemovedAt() {
		return removedAt;
	}

	public void setRemovedAt(String removedAt) {
		this.removedAt = removedAt;
	}

	@Override
	public String toString() {
		return "GroupMembers [groupID=" + groupID + ", contactId=" + contactId + ", addedAt=" + addedAt + ", removedAt=" + removedAt + "]";
	}
	
	
	
	
}
