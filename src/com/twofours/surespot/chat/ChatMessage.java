package com.twofours.surespot.chat;

import org.json.JSONException;
import org.json.JSONObject;

public class ChatMessage {
	private String mFrom;
	private String mTo;
	private String mCipherText;
	private String mPlainText;
	private String mId;
	
	public String getFrom() {
		return mFrom;
	}
	public void setFrom(String from) {
		mFrom = from;
	}
	public String getTo() {
		return mTo;
	}
	public void setTo(String to) {
		mTo = to;
	}
	public String getCipherText() {
		return mCipherText;		
	}
	public void setCipherText(String cipherText) {
		mCipherText = cipherText;
	}
	public String getPlainText() {
		return mPlainText;
	}
	public void setPlainText(String plainText) {
		mPlainText = plainText;
	}
	

	
	public String getId() {
		return mId;
	}
	public void setId(String id) {
		mId = id;
	}
	public static ChatMessage toChatMessage(JSONObject jsonMessage) throws JSONException {
		ChatMessage chatMessage = new ChatMessage();
		 
		chatMessage.setId(jsonMessage.getString("id"));
		chatMessage.setFrom(jsonMessage.getString("from"));
		chatMessage.setTo(jsonMessage.getString("to"));
		chatMessage.setCipherText(jsonMessage.getString("text"));

		return chatMessage;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (obj.getClass() != getClass())
            return false;
        
        ChatMessage rhs = (ChatMessage) obj;
        
        return this.getCipherText().equals(rhs.getCipherText()) && this.getTo().equals(rhs.getTo()) && this.getFrom().equals(rhs.getFrom()); 
        
       
	}
	
	public int hashCode() {
		return this.getCipherText().hashCode() + this.getFrom().hashCode() + this.getTo().hashCode();
	}
	

}
