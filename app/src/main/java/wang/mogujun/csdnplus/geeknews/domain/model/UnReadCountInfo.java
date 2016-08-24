package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/5/8.
 */
public class UnReadCountInfo {


    /**
     * unread_message_count : 0
     * unread_letter_count : 0
     * unread_bbs_msg_count : 0
     * unread_ask_msg_count : 0
     */

    private int unread_message_count;
    private int unread_letter_count;
    private int unread_bbs_msg_count;
    private int unread_ask_msg_count;

    public int getUnread_message_count() {
        return unread_message_count;
    }

    public void setUnread_message_count(int unread_message_count) {
        this.unread_message_count = unread_message_count;
    }

    public int getUnread_letter_count() {
        return unread_letter_count;
    }

    public void setUnread_letter_count(int unread_letter_count) {
        this.unread_letter_count = unread_letter_count;
    }

    public int getUnread_bbs_msg_count() {
        return unread_bbs_msg_count;
    }

    public void setUnread_bbs_msg_count(int unread_bbs_msg_count) {
        this.unread_bbs_msg_count = unread_bbs_msg_count;
    }

    public int getUnread_ask_msg_count() {
        return unread_ask_msg_count;
    }

    public void setUnread_ask_msg_count(int unread_ask_msg_count) {
        this.unread_ask_msg_count = unread_ask_msg_count;
    }
}
